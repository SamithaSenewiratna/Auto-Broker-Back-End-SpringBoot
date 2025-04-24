package icet.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityLogs {
    private Long id;
    private String actor;       // user/admin who performed the action
    private String timestamp;
    private String description;

}
