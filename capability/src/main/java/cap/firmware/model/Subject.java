package cap.firmware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private int subjectId;
    private String Name;
    private int chapters;
    private float price;
}
