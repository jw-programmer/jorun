/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jwprogrammer.jorun.security.users;

import br.com.jwprogrammer.jorun.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author josias
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final UserRepository UserRepository;

    public UserDetailsServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserRepository.findByUsername(username)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("usuario não encontrado."));
    }
    
}
