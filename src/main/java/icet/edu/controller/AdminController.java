package icet.edu.controller;

import icet.edu.dto.Admin;
import icet.edu.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    final AdminService service;

    @PostMapping
    public void addAdmin(@RequestBody Admin admin) {
        service.addAdmin(admin);
    }

    @PutMapping
    public void updateAdmin(@RequestBody Admin admin) {
        service.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        return service.getAdmin(id);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return service.getAllAdmins();
    }
}
