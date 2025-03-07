package com.bridgelabz.addressbook.controllers;

import com.bridgelabz.addressbook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<String> getAddressBook() {
        return addressService.getAddressBook();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressByID(@PathVariable long id){
        return addressService.getAddressByID(id);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody String address){
        return addressService.postAddress(address);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putAddress(@PathVariable long id,
                                             @RequestBody String address){
        return addressService.putAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteAddress(@PathVariable long id){
        return addressService.DeleteAddress(id);
    }
}
