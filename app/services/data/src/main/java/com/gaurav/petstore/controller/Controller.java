package com.gaurav.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.petstore.pojo.Pet;
import com.gaurav.petstore.repository.PetRepository;

@RestController
public class Controller {
	
	@Autowired
	PetRepository repository;
	
    @GetMapping("/data")
    public Pet data() {
        return new Pet(1, "Gaurav");
    }
    
    @GetMapping("/list-all-pets")
    public Iterable<Pet> listAll() {
    	return repository.findAll();
    }
    
    @PostMapping("/create-a-pet")
    public Pet createOne(@RequestBody Pet pet) {
    	return repository.save(pet);
    }
    
    @DeleteMapping("/delete-a-pet/{id}")
    public void deleteOne(@PathVariable long id) {
    	repository.delete(id);
    }
    
}
