package de.kozdemir.library.configure;

import de.kozdemir.library.model.Role;
import de.kozdemir.library.model.User;
import de.kozdemir.library.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 25.09.2023
 */
@Component
public class StartUpConfig implements CommandLineRunner {

    private final UserService userService;

    public StartUpConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
//        userService.createUser(User.builder().username("hmk").role(Role.ADMIN).password("12345").build());
//        userService.createUser(User.builder().username("abc").role(Role.USER).password("12345").build());

    }
}
