package services;

import dao.BookItemDao;
import dao.BookLendingDao;
import dao.MemberDao;
import entity.Member;
import exception.InEligibleException;
import exception.ItemUnavailableException;
import library.BookItem;
import library.BookLendingRecord;
import library.BookStatus;

import java.util.List;

public class BookKeepingService {

    BookItemDao bookItemDao = new BookItemDao();
    BookLendingDao bookLendingDao = new BookLendingDao();
    MemberDao memberDao = new MemberDao();
    EligibilityService eligibilityService = new EligibilityService();

    public void addNew(BookItem bookItem) {
        bookItemDao.save(bookItem);
    }

    public void delete(Long barCode) {
        bookItemDao.findById(barCode);
    }

    public BookLendingRecord lendBook(Long barCode, Long memberBarCode) throws InEligibleException {
        BookItem bookItem = bookItemDao.findById(barCode);
        Member member = memberDao.findById(memberBarCode);
        if (!eligibilityService.isEligibleToLend(member, bookItem)) {
            throw new InEligibleException("member is not available to lent the book");
        }
        bookItem.setStatus(BookStatus.LENT);
        bookItemDao.update(bookItem);
        BookLendingRecord bookLendingRecord = new BookLendingRecord(bookItem, member);
        bookLendingDao.save(bookLendingRecord);
        return bookLendingRecord;
    }
    public BookLendingRecord lendAnyAvailable(Long bookId, Long memberBarCode) throws InEligibleException {
        List<BookItem> allBookItems = bookItemDao.findByBookId(bookId);
        BookItem availableBookItem = allBookItems.stream().filter(x->x.getStatus() == BookStatus.AVAILABLE).findFirst().get();
        if(availableBookItem == null){
            System.out.println("No book Item available");
        }
        Member member = memberDao.findById(memberBarCode);
        if (!eligibilityService.isEligibleToLend(member, availableBookItem)) {
            throw new InEligibleException("member is not available to lent the book");
        }
        availableBookItem.setStatus(BookStatus.LENT);
        bookItemDao.update(availableBookItem);
        BookLendingRecord bookLendingRecord = new BookLendingRecord(availableBookItem, member);
        bookLendingDao.save(bookLendingRecord);
        return bookLendingRecord;
    }

    public BookLendingRecord returnBook(Long bookItemBarCode, Long memberBarCode) {
        BookItem bookItem = bookItemDao.findById(bookItemBarCode);
        Member member = memberDao.findById(memberBarCode);
        if (bookItem == null || bookItem.getStatus() != BookStatus.AVAILABLE) {
            throw new ItemUnavailableException("book requested is not available to lend");
        }
        bookItem.setStatus(BookStatus.AVAILABLE);
        bookItemDao.update(bookItem);
        BookLendingRecord bookLendingRecord = new BookLendingRecord(bookItem, member);
        bookLendingDao.save(bookLendingRecord);
        return bookLendingRecord;
    }

    public Member findLentTo(Long bookItemBarCode) {
        BookLendingRecord bookLendingRecord = bookLendingDao.findLastLent(bookItemDao.findById(bookItemBarCode));
        if (bookLendingRecord == null) {
            return null;
        }
        if (bookLendingRecord.getStatus() == BookLendingRecord.LendingStatus.INITIATED) {
            System.out.println("Book is currently lent to " + bookLendingRecord.getMember());
            return bookLendingRecord.getMember();
        }
        System.out.println("Book is currently available to lent");
        return null;
    }

}
