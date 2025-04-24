package icet.edu.service;

import icet.edu.dto.Admin;

import java.util.List;

public interface AdminService {

    void addAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(Long id);
    Admin getAdmin(Long id);
    List<Admin> getAllAdmins();
}
