package com.curso.usuarios.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.curso.usuarios")						// Para que descubra el Service
@EnableJpaRepositories(basePackages={"com.curso.usuarios"})	// Para que descubra los JPARepository
@EntityScan(basePackages={"com.curso.usuarios"})			// Para que descubra los Entity
@SpringBootApplication
public class AplicacionTest {
	
	public static void main(String[] args) {
		SpringApplication.run(AplicacionTest.class, args); 
	}
	
}
