package fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "policy_main")
public class PolicyEntity {
    private int id;
    private String name;
    private String startYear;
    private String endYear;
}
