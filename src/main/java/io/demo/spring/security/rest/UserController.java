package io.demo.spring.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/")
    public Map<String , String> noAuth() {
        return Collections.singletonMap("No Authenticated", "This api is accessible even  when user isn't authencticated." );
    }

    //accessible to all once authenticated
    @GetMapping("/api/common")
    public Map<String , String> accessibleWhenAuthenticated() {
        return Collections.singletonMap("Is User Authenticated", "This api is accessible when authenticated, regardless of roles");
    }

    //accessible to users when authenticated
    @GetMapping("/api/users")
    public Map<String , String> accessibleWhenAuthenticatedAndRoleIsUser() {
        return Collections.singletonMap("Is user Authenticated And Role is User", "This api is accessible when authenticated and role is user");
    }

    //accessible to admins when authenticated
    @GetMapping("/api/admins")
    public Map<String,String> accessibleWhenAuthenticatedAndRoleIsAdmin() {
        return Collections.singletonMap("Is user Authenticated And Role is Admin", "This api is accessible when authenticated, and role is admin");
    }
}
