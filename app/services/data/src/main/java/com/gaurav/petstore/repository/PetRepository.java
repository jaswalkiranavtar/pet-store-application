package com.gaurav.petstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.petstore.pojo.Pet;

//@RepositoryRestResource(collectionResourceRel = "pet", path = "pet")
//public interface PetRepository extends PagingAndSortingRepository<Pet, Long> 
//{
//
//}

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
}
