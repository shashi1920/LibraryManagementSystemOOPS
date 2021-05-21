package library;

import entity.Member;
import lombok.Builder;

@Builder
public class BookLendingRecord {
    private static int id = 0;

    int recordId;
    long initiatedTime;
    long returnedTime;
    Member member;
    BookItem bookItem;
    LendingStatus status;

    public enum LendingStatus {
        INITIATED,
        RETURNED;
    }

    public BookLendingRecord(BookItem bookItem, Member member) {
        recordId = id++;
        initiatedTime = System.currentTimeMillis();
        this.member = member;
        this.bookItem = bookItem;
        status = LendingStatus.INITIATED;
    }

    public void markReturned() {
        status = LendingStatus.RETURNED;
        returnedTime = System.currentTimeMillis();
    }
}
