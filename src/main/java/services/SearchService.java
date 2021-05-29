package services;

import dao.BookItemDao;
import dao.BookLendingDao;
import entity.Author;
import library.BookItem;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    BookItemDao bookItemDao = new BookItemDao();
    BookLendingDao bookLendingDao = new BookLendingDao();

    public List<BookItem> searchByTitle(String title) {
        return bookItemDao.findAll().stream().filter(x -> x.getTitle().contains(title)).collect(Collectors.toList());
    }

    public List<BookItem> searchByAuthor(Author author) {
        return bookItemDao.findAll().stream().filter(x -> x.getAuthors().contains(author)).collect(Collectors.toList());
    }

}
