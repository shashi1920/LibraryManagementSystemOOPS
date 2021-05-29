package dao;

import library.BookItem;

import java.util.ArrayList;
import java.util.List;

public class BookItemDao implements BaseDao<BookItem> {
    @Override
    public List<BookItem> findAll() {
        return null;
    }

    @Override
    public BookItem save(BookItem item) {
        return null;
    }

    @Override
    public BookItem findById(Long id) {
        return null;
    }

    @Override
    public BookItem update(BookItem item) {
        return null;
    }

    @Override
    public void delete(BookItem item) {

    }


    public List<BookItem> findByBookId(Long bookId){
        return new ArrayList<>();
    }
}
