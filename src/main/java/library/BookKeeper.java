package library;

import entity.Member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BookKeeper {

    Member member;
    List<BookLendingRecord> active;
    List<BookLendingRecord> historical;

    public static final int MAX_LIMIT_FOR_BOOK = 5;

    BookKeeper(Member member){
        this.member = member;
        active = new ArrayList<>();
        historical = new ArrayList<>();
    }

    public boolean lendBook(BookItem bookItem){
        if(active.size() < MAX_LIMIT_FOR_BOOK) {
            BookLendingRecord bookLendingRecord = new BookLendingRecord(bookItem, this.member);
            active.add(bookLendingRecord);
            return true;
        }
        return false;
    }

    public boolean returnBook(BookItem bookItem){
        Iterator<BookLendingRecord> iterator = active.listIterator();
        while (iterator.hasNext()){
            BookLendingRecord record = iterator.next();
            if(record.bookItem.equals(bookItem)){
                iterator.remove();
                historical.add(record);
                return true;
            }
        }
        return false;
    }

    public List<BookItem> getCurrentlyLendedBooks(){
        return this.active.stream().map(x->x.bookItem).collect(Collectors.toList());
    }




}
