package icet.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String imgUrl;

    public User(String email, String password) {
        email=this.email;
        password=this.password;
    }
}
