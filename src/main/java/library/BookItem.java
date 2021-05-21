package library;

import entity.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BookItem extends Book{

    String barCode;

    BookStatus status;



}
