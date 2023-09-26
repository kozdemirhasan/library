package de.kozdemir.library.service;

import de.kozdemir.library.dto.TokenResponseDto;
import de.kozdemir.library.exception.GenericException;
import de.kozdemir.library.request.LoginRequest;
import de.kozdemir.library.utils.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 22.09.2023
 */
@Service
public class AuthService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserService userService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponseDto login(LoginRequest loginRequest) throws GenericException {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return TokenResponseDto.builder()
                    .accessToken(tokenGenerator.generateToken(auth))
                    .userDto(userService.getUser(loginRequest.getUsername()))
                    .build();
        }catch (Exception e){
            throw  GenericException.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .errorMessage("user not found!").build();
        }
    }
}
