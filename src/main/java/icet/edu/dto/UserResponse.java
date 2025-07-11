package icet.edu.dto;

import icet.edu.util.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String imageUrl;
    private Role role;
}
