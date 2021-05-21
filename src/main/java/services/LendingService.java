package services;

import dao.BookItemDao;
import dao.BookLendingDao;
import dao.MemberDao;
import entity.Member;
import exception.ItemUnavailableException;
import library.BookItem;
import library.BookLendingRecord;
import library.BookStatus;

public class LendingService {

    BookItemDao bookItemDao = new BookItemDao();
    BookLendingDao bookLendingDao = new BookLendingDao();
    MemberDao memberDao = new MemberDao();


    public void addNew(BookItem bookItem) {
        bookItemDao.save(bookItem);
    }

    public void delete(Long barCode) {
        bookItemDao.findById(barCode);
    }

    public BookLendingRecord lendBook(Long barCode, Long memberBarCode) {
        BookItem bookItem = bookItemDao.findById(barCode);
        Member member = memberDao.findById(memberBarCode);
        if (bookItem == null || bookItem.getStatus() != BookStatus.AVAILABLE) {
            throw new ItemUnavailableException("book requested is not available to lend");
        }
        bookItem.setStatus(BookStatus.LENT);
        bookItemDao.update(bookItem);
        BookLendingRecord bookLendingRecord = new BookLendingRecord(bookItem, member);
        bookLendingDao.save(bookLendingRecord);
        return bookLendingRecord;
    }

    public BookLendingRecord returnBook(Long bookItemBarCode, Long memberBarCode){
        BookItem bookItem = bookItemDao.findById(bookItemBarCode);
        Member member = memberDao.findById(memberBarCode);
        if (bookItem == null || bookItem.getStatus() != BookStatus.AVAILABLE) {
            throw new ItemUnavailableException("book requested is not available to lend");
        }
        bookItem.setStatus(BookStatus.LENT);
        bookItemDao.update(bookItem);
        BookLendingRecord bookLendingRecord = new BookLendingRecord(bookItem, member);
        bookLendingDao.save(bookLendingRecord);
        return bookLendingRecord;
    }


}
