/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jwprogrammer.jorun.security.jwt;

import java.time.Instant;
import static java.time.Instant.now;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

/**
 *
 * @author josias
 */
@Service
public class JwtService {
    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }
    
    public String generateToken(Authentication authentication) {
        Instant now = now();
        long expira = 3600L;
        
        String autoridades = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        
        JwtClaimsSet clains = JwtClaimsSet.builder()
                .issuer("jorun")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expira))
                .subject(authentication.getName())
                .claim("scope", autoridades)
                .build();
        
        return encoder.encode(JwtEncoderParameters.from(clains)).getTokenValue();
    }
}
