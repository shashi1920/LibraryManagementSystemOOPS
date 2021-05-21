package entity;

import lombok.*;

@Setter @Getter @NoArgsConstructor @Builder
public class Address {

    String houseNo;
    String streetName;
    String cityName;
    Long zipCode;
    String state;
    String country;
}
