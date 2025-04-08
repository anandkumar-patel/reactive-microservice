package fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDetail {
    private long detailId;
    private String State;
    private String country;
    private int pinCode;
}
