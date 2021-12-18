package com.usa.ciclo4.reto2_ciclo4.controller;

import com.usa.ciclo4.reto2_ciclo4.model.Product;
import com.usa.ciclo4.reto2_ciclo4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cleaningproduct")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Product> getProduct(@PathVariable("reference") String reference){
        return productService.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){

        return productService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return productService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable("price")double price){
        return productService.getByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Product>getByDescriptionContainingIgnoreCase(@PathVariable("description") String description){
        return productService.getByDescriptionContainingIgnoreCase(description);
    }

}
