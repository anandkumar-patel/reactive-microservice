package fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private long subjectId;
    private String Name;
    private int chapters;
    private float price;
}
