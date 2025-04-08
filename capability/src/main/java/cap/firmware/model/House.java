package cap.firmware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class House {
    private int id;
    private String displayName;
    private String city;
}