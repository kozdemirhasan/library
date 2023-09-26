package de.kozdemir.library.service;

import de.kozdemir.library.dto.UserDto;
import de.kozdemir.library.exception.GenericException;
import de.kozdemir.library.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import de.kozdemir.library.repository.UserRepository;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 21.09.2023
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        return UserDto.builder()
                .userName(savedUser.getUsername())
                .role(savedUser.getRole())
                .email(savedUser.getEmail())
                .build();
    }
    public String getUser(String username) throws GenericException {
        var savedUser = findUserByUserName(username);
        return UserDto.builder()
                .userName(savedUser.getUsername())
                .role(savedUser.getRole())
                .email(savedUser.getEmail())
                .build().toString();
    }

    public User findUserByUserName(String userName) throws GenericException {
        return userRepository.findUserByUsername(userName)
                .orElseThrow(() -> GenericException.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .errorMessage("user not found by given id!")
                        .build());
    }
}
