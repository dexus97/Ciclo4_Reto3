package com.usa.ciclo4.reto2_ciclo4;

import com.usa.ciclo4.reto2_ciclo4.repository.crud.ProductCrudRepository;
import com.usa.ciclo4.reto2_ciclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class Reto2Ciclo4Application implements CommandLineRunner {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto2Ciclo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productCrudRepository.deleteAll();
        userCrudRepository.deleteAll();


    }
}
