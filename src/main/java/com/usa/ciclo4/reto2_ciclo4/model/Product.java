package com.usa.ciclo4.reto2_ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String material;
    private String description;
    private Double price;
    private Boolean availability;
    private Integer quantity;
    private String photography;

}
