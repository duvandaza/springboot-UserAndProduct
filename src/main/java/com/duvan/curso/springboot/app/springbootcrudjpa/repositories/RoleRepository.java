package com.duvan.curso.springboot.app.springbootcrudjpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.duvan.curso.springboot.app.springbootcrudjpa.entities.Role;


public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String name);

}
