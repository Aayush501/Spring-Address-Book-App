package com.bridgelabz.addressbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AddressBookController {
    @GetMapping("/all")
    public ResponseEntity<String> getAddressBook() {
        return new ResponseEntity<>("address book", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressByID(@PathVariable long id){
        return new ResponseEntity<>("address book", HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody String address){
        return new ResponseEntity<>("address book", HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putAddress(@PathVariable long id,
                                             @RequestBody String address){
        return new ResponseEntity<>("address book", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteAddress(@PathVariable long id){
        return new ResponseEntity<>("address book", HttpStatus.OK);
    }
}
