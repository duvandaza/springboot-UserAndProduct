package com.duvan.curso.springboot.app.springbootcrudjpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.duvan.curso.springboot.app.springbootcrudjpa.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    boolean existsBySku(String sku);

}
