package icet.edu.service.impl;

import icet.edu.dto.Admin;
import icet.edu.entity.AdminEntity;
import icet.edu.repository.AdminRepository;
import icet.edu.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    final AdminRepository repository;
    final ModelMapper mapper;

    @Override
    public void addAdmin(Admin admin) {
        repository.save(mapper.map(admin, AdminEntity.class));
    }

    @Override
    public void updateAdmin(Admin admin) {
        repository.save(mapper.map(admin, AdminEntity.class));
    }

    @Override
    public void deleteAdmin(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Admin not found with id: " + id);
        }
    }

    @Override
    public Admin getAdmin(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id)), Admin.class);
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> list = new ArrayList<>();
        repository.findAll().forEach(entity -> list.add(mapper.map(entity, Admin.class)));
        return list;
    }
}
