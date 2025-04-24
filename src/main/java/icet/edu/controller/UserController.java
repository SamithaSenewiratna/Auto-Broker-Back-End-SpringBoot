package icet.edu.controller;

import icet.edu.dto.User;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/add")
    public String create(@RequestBody User user) {
        service.saveUser(user);
        return "User added successfully";
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody User updatedUser) {
        service.updateUser(id, updatedUser);
        return "User updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
