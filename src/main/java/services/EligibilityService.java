package services;

import dao.BookLendingDao;
import entity.Member;
import library.BookItem;
import library.BookLendingRecord;
import library.BookStatus;

import java.util.List;
import java.util.stream.Collectors;

public class EligibilityService {

    private static final int MAX_ALLOWED_PER_MEMBER = 5;
    BookLendingDao bookLendingDao = new BookLendingDao();

    public boolean isEligibleToLend(Member member, BookItem bookItem) {
        if (bookItem == null || !bookItem.getStatus().equals(BookStatus.AVAILABLE)) {
            return false;
        }
        List<BookLendingRecord> bookLendingRecords = bookLendingDao.findByMember(member);
        List<BookLendingRecord> active = bookLendingRecords.stream()
                .filter(bookLendingRecord -> bookLendingRecord.getStatus().equals(BookLendingRecord.LendingStatus.INITIATED))
                .collect(Collectors.toList());
        return active.size() < MAX_ALLOWED_PER_MEMBER;
    }
}
