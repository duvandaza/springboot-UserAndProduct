package com.duvan.curso.springboot.app.springbootcrudjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duvan.curso.springboot.app.springbootcrudjpa.entities.Product;
import com.duvan.curso.springboot.app.springbootcrudjpa.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
       return repository.findById(id);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }
    
    @SuppressWarnings("null")
    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {    
        Optional<Product> producOptional = repository.findById(id);
        if(producOptional.isPresent()){
            Product productDb = producOptional.orElseThrow();

            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());
            productDb.setSku(product.getSku());
            return Optional.of(repository.save(productDb));
        }
        return producOptional;
    }
    
    @SuppressWarnings("null")
    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = repository.findById(id); 
        productDb.ifPresent(prod ->{
            repository.delete(prod);
        });
        return productDb;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return repository.existsBySku(sku);
    }

    


}
