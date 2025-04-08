package cap.firmware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutoMobile {
    private int id;
    private String make;
    private String model;
}
