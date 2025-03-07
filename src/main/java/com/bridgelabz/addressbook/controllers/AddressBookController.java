package com.bridgelabz.addressbook.controllers;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<AddressDTO>> getAddressBook() {
        log.info("Run get all element function");
        return addressService.getAddressBook();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDTO> getAddressByID(@PathVariable long id){
        log.info("Run get element by id function");
        return addressService.getAddressByID(id);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody AddressDTO address){
        log.info("Run post an element function");
        return addressService.postAddress(address);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putAddress(@PathVariable long id,
                                             @RequestBody AddressDTO address){
        log.info("Run update element function");
        return addressService.putAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteAddress(@PathVariable long id){
        log.info("Run delete element function");
        return addressService.DeleteAddress(id);
    }
}