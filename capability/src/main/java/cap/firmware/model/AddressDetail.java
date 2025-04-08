package cap.firmware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDetail {
    private int detailId;
    private String State;
    private String country;
    private int pinCode;
}
