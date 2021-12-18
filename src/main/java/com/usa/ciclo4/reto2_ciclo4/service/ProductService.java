package com.usa.ciclo4.reto2_ciclo4.service;

import com.usa.ciclo4.reto2_ciclo4.model.Product;
import com.usa.ciclo4.reto2_ciclo4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(String reference){
        return productRepository.getProduct(reference);
    }

    public  Product save(Product product){
        if(product.getReference()==null){
            return product;
        }
        return productRepository.create(product);

    }

    public Product update(Product product) {
        if (product.getReference() != null) {
            Optional<Product> dbProduct = productRepository.getProduct(product.getReference());
            if (!dbProduct.isEmpty()) {
                if(product.getBrand()!=null){
                    dbProduct.get().setBrand(product.getBrand());
                }
                if(product.getCategory()!=null){
                    dbProduct.get().setCategory(product.getCategory());
                }
                if(product.getMaterial()!=null){
                    dbProduct.get().setMaterial(product.getMaterial());
                }
                if(product.getDescription()!=null){
                    dbProduct.get().setDescription(product.getDescription());
                }

                if(product.getAvailability()!=null){
                    dbProduct.get().setAvailability(product.getAvailability());

                }
                if(product.getPrice()!=0.0){
                        dbProduct.get().setPrice(product.getPrice());
                }
                if(product.getQuantity()!=0.0){
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null){
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.getAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference){
        Boolean aBoolean = getProduct(reference).map(Product -> {
            productRepository.delete(Product);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Product>getByPriceLessThanEqual(double price){

        return productRepository.getByPriceLessThanEqual(price);
    }

    public List<Product>getByDescriptionContainingIgnoreCase(String description){
        return productRepository.getByDescriptionContainingIgnoreCase(description);
    }
}
