package br.com.jwprogrammer.jorun.domain;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 * Classe que representa um membro do fórun
 * @author josias
 */
//TODO: Mapear a coisa toda para mongoDb
@Getter
@Setter
public class User {
    private String username;
    private String passoword;
    private Set<String> roles;
}
