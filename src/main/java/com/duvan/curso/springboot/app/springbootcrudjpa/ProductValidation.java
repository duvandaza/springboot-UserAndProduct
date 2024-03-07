package com.duvan.curso.springboot.app.springbootcrudjpa;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.duvan.curso.springboot.app.springbootcrudjpa.entities.Product;


@Component
public class ProductValidation implements Validator {

    @SuppressWarnings("null")
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings("null")
    @Override
    public void validate(Object target, Errors errors) {
        
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null ,"Es requerido el campo name!");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotBlank.product.description");
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description", null, "Es requerido y el campo no puede ser vacio");
        }
        if (product.getPrice() == null) {
            errors.rejectValue("price", null, "No puede ser nulo!");
        }else if (product.getPrice() < 500) {
            errors.rejectValue("price", null, "No puede ser un valor menor a 500");
        }
    
    }


}
