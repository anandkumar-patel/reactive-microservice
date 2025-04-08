package fm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    private int id;
    private String name;
    private String startYear;
    private String endYear;
}
