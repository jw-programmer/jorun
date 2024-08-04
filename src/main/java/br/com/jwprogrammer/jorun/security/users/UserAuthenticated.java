package br.com.jwprogrammer.jorun.security.users;

import br.com.jwprogrammer.jorun.domain.User;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author josias
 */
public class UserAuthenticated implements UserDetails{
    
    private final User user;

    public UserAuthenticated(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassoword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
}
