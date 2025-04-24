package icet.edu.service;

import icet.edu.dto.User;

import java.util.List;

public interface UserService {
    void saveUser(User dto);
    User getUser(Long id);
    List<User> getAllUsers();
    void updateUser(Long id, User dto);
    void deleteUser(Long id);
}
