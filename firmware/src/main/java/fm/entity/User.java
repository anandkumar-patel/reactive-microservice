package fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class User {
    private long userId;
    private String name;
    private Address address;
    private List<Subject> subjects;
}
