/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.jwprogrammer.jorun.repositories;

import br.com.jwprogrammer.jorun.domain.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author josias
 */
//TODO: Modificar conforme minhas necessidades
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findByUsername(String Username);
}
