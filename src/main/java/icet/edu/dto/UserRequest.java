package icet.edu.dto;

import icet.edu.util.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String imageUrl;
    private Role role;
}
