package dao;

import entity.Book;
import entity.Member;
import library.BookItem;
import library.BookLendingRecord;

import java.util.ArrayList;
import java.util.List;

public class BookLendingDao implements BaseDao<BookLendingRecord> {

    @Override
    public List<BookLendingRecord> findAll() {
        return null;
    }

    @Override
    public BookLendingRecord save(BookLendingRecord item) {
        return null;
    }

    @Override
    public BookLendingRecord findById(Long id) {
        return null;
    }

    @Override
    public BookLendingRecord update(BookLendingRecord item) {
        return null;
    }

    @Override
    public void delete(BookLendingRecord item) {

    }

    public List<BookLendingRecord> findByMember(Member member){
        return new ArrayList<>();
    }

    public BookLendingRecord findLastLent(BookItem bookItem){
        return null;
    }

    public List<BookLendingRecord> findByBookItem(BookItem bookItem){
        return new ArrayList<>();
    }
}
