package fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "policy_contents")
public class PolicyContents {
    @Id
    @Column("content_id")
    private Long detailsId;
    @Column("policy_id")
    private Long policyId;
    @Column("item_id")
    private Long itemId;
    private String itemType;
    @Column("cover_amount")
    private Long coverLimit;
}