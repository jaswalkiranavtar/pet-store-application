package com.gaurav.petstore.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "pet")
public class Pet {

//	@Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
//	@Column(name = "name")
    private String name;
    
    public Pet(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Pet() {
    	
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
