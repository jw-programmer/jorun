/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jwprogrammer.jorun.resources;

import br.com.jwprogrammer.jorun.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josias
 */
@RestController
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
