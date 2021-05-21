package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder @AllArgsConstructor @NoArgsConstructor
public class Amount {
    Double amount;
    String currencyCode;
}
