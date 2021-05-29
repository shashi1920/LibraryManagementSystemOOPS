package entity;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Amount {
    Double amount;
    String currencyCode;
}
