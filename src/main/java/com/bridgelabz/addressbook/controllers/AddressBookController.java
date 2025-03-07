package com.bridgelabz.addressbook.controllers;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<AddressDTO>> getAddressBook() {
        return addressService.getAddressBook();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDTO> getAddressByID(@PathVariable long id){
        return addressService.getAddressByID(id);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody AddressDTO address){
        return addressService.postAddress(address);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putAddress(@PathVariable long id,
                                             @RequestBody AddressDTO address){
        return addressService.putAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteAddress(@PathVariable long id){
        return addressService.DeleteAddress(id);
    }
}
