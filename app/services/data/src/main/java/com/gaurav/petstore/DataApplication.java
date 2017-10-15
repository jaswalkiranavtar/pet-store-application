package com.gaurav.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.gaurav.petstore.pojo.Pet;
import com.gaurav.petstore.repository.PetRepository;
import com.gaurav.petstore.security.EnablePetStoreSecurity;

@EnablePetStoreSecurity
@EnableDiscoveryClient
@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}
	
	@Autowired
	PetRepository repository;
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			repository.save(new Pet(1, "Tommy"));
			repository.save(new Pet(2, "Billy"));
			repository.save(new Pet(3, "Kitty"));
			repository.save(new Pet(4, "Bonco"));
		}; 
	}
	
}
