package com.proyecto.farmacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.proyecto.farmacia.dao")
@EntityScan(basePackages = "com.proyecto.farmacia.modelentity")
public class FarmaciaApplication {
    public static void main(String[] args) {
        SpringApplication.run(FarmaciaApplication.class, args);
    }
}
