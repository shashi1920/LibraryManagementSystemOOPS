package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @Builder
public class Book {

    String id;
    String title;
    Publisher publisher;
    Author author;

}
