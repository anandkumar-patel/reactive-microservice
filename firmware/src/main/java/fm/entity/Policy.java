package fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "policy_main")
public class Policy {
    @Id
    private Long id;
    private String name;
    @Column("start_year")
    private String startYear;
    @Column("end_year")
    private String endYear;
    private double premium;
    @Transient
    List<PolicyContents> contents;
}
