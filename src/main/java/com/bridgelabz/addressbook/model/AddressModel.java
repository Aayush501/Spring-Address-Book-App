package com.bridgelabz.addressbook.model;

public class AddressModel {
    private long id;
    private String address;


    public AddressModel(long id, String address) {
        this.id = id;
        this.address = address;
    }

    public long getId(){
        return id;
    }

    public String getAddress(){
        return address;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
