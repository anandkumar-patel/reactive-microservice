package exp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UWIssues {
    private int issueId;
    private String description;
    private String comment;
}
