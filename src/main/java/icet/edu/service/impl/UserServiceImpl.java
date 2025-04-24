package icet.edu.service.impl;

import icet.edu.dto.User;
import icet.edu.entity.UserEntity;
import icet.edu.repository.UserRepository;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public void saveUser(User dto) {
        UserEntity entity = mapper.map(dto, UserEntity.class);
        repository.save(entity);
    }

    @Override
    public User getUser(Long id) {
        UserEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapper.map(entity, User.class);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(user -> mapper.map(user, User.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(Long id, User dto) {
        UserEntity existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existing.setEmail(dto.getEmail());
        existing.setPassword(dto.getPassword());
        existing.setImgUrl(dto.getImgUrl());

        repository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
