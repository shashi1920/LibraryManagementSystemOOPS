package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @NoArgsConstructor @Builder
public class Book {

    Long id;
    String title;
    Publisher publisher;
    List<Author> authors;

}
