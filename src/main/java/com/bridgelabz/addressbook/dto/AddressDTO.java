package com.bridgelabz.addressbook.dto;

public class AddressDTO {
    private long id;
    private String address;


    public AddressDTO(long id, String address) {
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
