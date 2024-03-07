package com.duvan.curso.springboot.app.springbootcrudjpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.duvan.curso.springboot.app.springbootcrudjpa.entities.User;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
