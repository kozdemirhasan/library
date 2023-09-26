package de.kozdemir.library.service;

import de.kozdemir.library.exception.GenericException;
import de.kozdemir.library.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 21.09.2023
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userService.findUserByUserName(username);
        } catch (GenericException e) {
            throw new RuntimeException(e);
        }
        var roles= Stream.of(user.getRole())
                .map(role-> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(),roles);
    }
}
