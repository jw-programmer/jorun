package br.com.jwprogrammer.jorun.services;

import br.com.jwprogrammer.jorun.security.jwt.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author josias
 */
@Service
public class AuthenticationService {
    
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    
    public String authenticate(Authentication authentication){
        return jwtService.generateToken(authentication);
    }
}
