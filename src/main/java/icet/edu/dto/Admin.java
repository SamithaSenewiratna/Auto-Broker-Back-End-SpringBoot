package icet.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Admin {

    private Long id;
    private  String name;
    private  String email;
    private  String password;
    private  String imgUrl;


}
