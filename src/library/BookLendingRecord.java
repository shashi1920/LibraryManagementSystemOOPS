package library;

import entity.Member;


public class BookLendingRecord {

    long initiatedTime;
    long returnedTime;
    Member member;
    BookItem bookItem;
    LendingStatus status;

    public enum LendingStatus {
        INITIATED,
        RETURNED;
    }

    BookLendingRecord(BookItem bookItem, Member member){
        initiatedTime = System.currentTimeMillis();
        this.member = member;
        this.bookItem = bookItem;
        status = LendingStatus.INITIATED;
    }

    public void markReturned(){
        status = LendingStatus.RETURNED;
        returnedTime = System.currentTimeMillis();
    }
}
