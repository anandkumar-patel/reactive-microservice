package cap.firmware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class User {
    private int userId;
    private String name;
    private Address address;
    private List<Subject> subjects;
}
