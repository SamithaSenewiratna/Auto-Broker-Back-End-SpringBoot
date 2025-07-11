package icet.edu.service.impl;

import icet.edu.dto.UserRequest;

import icet.edu.dto.UserResponse;
import icet.edu.entity.UserEntity;
import icet.edu.exceptions.ResourceNotFoundException;
import icet.edu.repository.UserRepository;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserResponse createUser(UserRequest request) {
        UserEntity user = modelMapper.map(request, UserEntity.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return modelMapper.map(userRepo.save(user), UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        modelMapper.map(request, user);

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        return modelMapper.map(userRepo.save(user), UserResponse.class);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepo.deleteById(id);
    }
}
