package de.kozdemir.library.api;

import de.kozdemir.library.dto.TokenResponseDto;
import de.kozdemir.library.exception.GenericException;
import de.kozdemir.library.request.LoginRequest;
import de.kozdemir.library.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 22.09.2023
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequest loginRequest) throws GenericException {
        return ResponseEntity.ok(authService.login(loginRequest));


    }
}
