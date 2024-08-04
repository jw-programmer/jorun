package br.com.jwprogrammer.jorun.resources;

import br.com.jwprogrammer.jorun.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josias
 */
@RestController
@RequestMapping("auth")
public class AuthenticationResource {
    
    private final AuthenticationService authService;

    @Autowired
    public AuthenticationResource(AuthenticationService authService) {
        this.authService = authService;
    }
    
    @PostMapping("authenticate")
    public String authenticate(Authentication authentication){
        return authService.authenticate(authentication);
    }
}
