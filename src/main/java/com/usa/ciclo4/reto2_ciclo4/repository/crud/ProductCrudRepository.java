package com.usa.ciclo4.reto2_ciclo4.repository.crud;

import com.usa.ciclo4.reto2_ciclo4.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCrudRepository extends MongoRepository<Product, String> {
}
