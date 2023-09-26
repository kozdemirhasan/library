package de.kozdemir.library.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 26.09.2023
 */
@RestController
@RequestMapping("/api")
public class TestEndpoint {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user ";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "public";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/method-admin")
    public String methodAdmin(){
        return "method-admin";
    }


    @GetMapping("/me")
    public String getMyself() {
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

}
