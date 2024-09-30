package com.swp391.crud_api_koi_veterinary.service.implement;

import com.swp391.crud_api_koi_veterinary.model.dto.request.AuthenticationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.request.UserCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.response.AuthenticationResponse;
import com.swp391.crud_api_koi_veterinary.model.entity.UserAccount;
import com.swp391.crud_api_koi_veterinary.repository.UserRepository;
import com.swp391.crud_api_koi_veterinary.service.AuthService;
import com.swp391.crud_api_koi_veterinary.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse localAuthentication(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            var user = userRepository.findUserByUsername(authentication.getName()).orElseThrow();
            var accessToken = jwtService.generateAccessToken(authentication);
            return AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .role(user.getRole())
                    .finishTime(LocalDateTime.now())
                    .build();
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            throw new RuntimeException("Username or password is incorrect", e);
        }
    }

    public AuthenticationResponse register(UserCreationRequest request) {
        if (userRepository.findUserByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại");
        }
        
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setRole("CUSTOMER"); // Mặc định role là CUSTOMER

        userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String accessToken = jwtService.generateAccessToken(authentication);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .role(user.getRole())
                .finishTime(LocalDateTime.now())
                .build();
    }
}

