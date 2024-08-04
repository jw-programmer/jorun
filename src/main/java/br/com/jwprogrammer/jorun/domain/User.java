package br.com.jwprogrammer.jorun.domain;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User
 * Classe que representa um membro do fórun
 * @author josias
 */
@Document("users")
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Set<String> roles;
}
