package com.usa.ciclo4.reto2_ciclo4.repository;

import com.usa.ciclo4.reto2_ciclo4.model.Product;
import com.usa.ciclo4.reto2_ciclo4.repository.crud.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return productCrudRepository.findAll();
    }
    public Optional<Product> getProduct(String id){
        return productCrudRepository.findById(id);
    }

    public Product create(Product product){
        return productCrudRepository.save(product);
    }

    public void update(Product product){
        productCrudRepository.save(product);
    }
    public void delete(Product product){
        productCrudRepository.delete(product);
    }
    public List<Product>getByPriceLessThanEqual(double price){
        return productCrudRepository.findByPriceLessThanEqual(price);
    }


    public List<Product>getByDescriptionContainingIgnoreCase(String description){
        return productCrudRepository.findByDescriptionContainingIgnoreCase(description);

    }
}
