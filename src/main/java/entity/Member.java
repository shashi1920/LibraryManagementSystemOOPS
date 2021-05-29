package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Builder
public class Member extends  Person{

    Long barCode;

    int maxAllowedBooks;

}
