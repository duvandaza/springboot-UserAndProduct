package com.duvan.curso.springboot.app.springbootcrudjpa.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.duvan.curso.springboot.app.springbootcrudjpa.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String> {

    @Autowired
    private ProductService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if (service == null) {
            return true;
        }

        return !service.existsBySku(value);

    }


}
