package library;

import entity.Librarian;
import entity.Member;
import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class BookLendingRecord {
    private static int id = 0;

    int recordId;
    long initiatedTime;
    long returnedTime;
    Member member;
    BookItem bookItem;
    LendingStatus status;
    Librarian librarian;

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
