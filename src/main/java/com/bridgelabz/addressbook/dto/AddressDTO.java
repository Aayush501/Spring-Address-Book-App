package com.bridgelabz.addressbook.dto;

public class AddressDTO {
    private long id;
    private String address;

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
