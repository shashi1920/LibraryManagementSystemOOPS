package services;

import dao.BookDao;
import dao.BookLendingDao;
import entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    BookDao bookDao = new BookDao();
    BookLendingDao bookLendingDao = new BookLendingDao();

    public List<Book> searchByTitle(String title) {
        return bookDao.findAll().stream().filter(x -> x.getTitle().contains(title)).collect(Collectors.toList());
    }





}
