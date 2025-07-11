package icet.edu.controller;


import icet.edu.dto.AuthRequest;
import icet.edu.dto.AuthResponse;
import icet.edu.entity.UserEntity;
import icet.edu.repository.UserRepository;

import icet.edu.service.impl.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired private JWTService jwtService;
    @Autowired private UserRepository userRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserEntity user = (UserEntity) authentication.getPrincipal();
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getRole().name()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok("User Registered");
    }
}
