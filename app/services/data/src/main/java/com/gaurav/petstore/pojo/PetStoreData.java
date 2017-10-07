package com.gaurav.petstore.pojo;

public class PetStoreData {

    private long id;
    private String name;
    
    public PetStoreData(long id, String name) {
        super();
        this.id = id;
        this.name = name;
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
