package icet.edu.service;


import icet.edu.dto.UserRequest;
import icet.edu.dto.UserResponse;
import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}
