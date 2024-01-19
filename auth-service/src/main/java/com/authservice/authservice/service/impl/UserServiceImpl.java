package com.authservice.authservice.service.impl;

import com.authservice.authservice.dto.request.LoginRequest;
import com.authservice.authservice.dto.request.SignupRequest;
import com.authservice.authservice.dto.response.AuthResponse;
import com.authservice.authservice.dto.response.SignupResponse;
import com.authservice.authservice.dto.response.UserResponse;
import com.authservice.authservice.entity.User;
import com.authservice.authservice.exception.RecordAlreadyExistException;
import com.authservice.authservice.exception.RecordNotFoundException;
import com.authservice.authservice.repository.UserRepository;
import com.authservice.authservice.service.JwtService;
import com.authservice.authservice.service.UserService;
import com.authservice.authservice.utils.UserMapper;
import com.authservice.authservice.utils.constants.Message;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder, JwtService jwtService,
                           AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public SignupResponse signup(SignupRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new RecordAlreadyExistException(Message.USER_EXISTS + request.getEmail());
        } else {
            var user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();

            userRepository.save(user);

            return SignupResponse.builder()
                    .email(user.getEmail())
                    .message(Message.SIGN_UP_SUCCESSFUL)
                    .build();
        }
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            Optional<User> user = userRepository.findByEmail(request.getEmail());
            String token = jwtService.generateToken(user.get());
            return new AuthResponse(token);
        } catch (AuthenticationException e) {
            throw new RecordNotFoundException(Message.USER_NOT_FOUND + request.getEmail());
        }
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException(Message.USER_NOT_FOUND + email));
        return UserMapper.convertToDTO(user, UserResponse.class);
    }
}
