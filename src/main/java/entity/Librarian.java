package entity;

import library.BookItem;
import services.BookKeepingService;

public class Librarian extends Person{

    BookKeepingService bookKeepingService = new BookKeepingService();


    public void addNewBook(BookItem bookItem){
        bookKeepingService.addNew(bookItem);
    }

    public void removeABook(BookItem bookItem){
        bookKeepingService.delete(bookItem.getId());
    }


}
