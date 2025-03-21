package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.AddressModel;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressService {
    @Autowired
    private AddressBookRepository repository;

    private List<AddressModel>AddressList;
    private ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<List<AddressDTO>> getAddressBook() {
        AddressList = repository.findAll().stream().toList();

        List<AddressDTO> addressDTOList = new ArrayList<>();

        for(AddressModel address : AddressList){
            AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
            addressDTOList.add(addressDTO);
        }

        log.info("Elements displayed");
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }

    public ResponseEntity<AddressDTO> getAddressByID(@PathVariable long id){
        AddressList = repository.findAll().stream().toList();
        for(AddressModel address : AddressList){
            if(address.getId() == id){
                AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
                log.info("Got the searched element");
                return new ResponseEntity<>(addressDTO, HttpStatus.OK);
            }
        }
        log.error("Element not found");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> postAddress(@RequestBody AddressDTO addressDTO){
        AddressModel addressModel = modelMapper.map(addressDTO, AddressModel.class);
        repository.save(addressModel);
        log.info("Element added");
        return new ResponseEntity<>("Address added in book: " + addressModel, HttpStatus.CREATED);
    }

    public ResponseEntity<String> putAddress(long id, AddressDTO addressBookDTO) {
        AddressList = repository.findAll().stream().toList();
        for (int i = 0; i < AddressList.size(); i++) {
            if (id == AddressList.get(i).getId()) {
                AddressModel addressModel = modelMapper.map(addressBookDTO, AddressModel.class);
                repository.save(addressModel);
                log.info("Updated the element");
                return new ResponseEntity<>("Updated: " + addressModel, HttpStatus.OK);
            }
        }
        log.error("Element not found.");
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> DeleteAddress(long id) {
        AddressList = repository.findAll().stream().toList();
        for (int i = 0; i < AddressList.size(); i++) {
            if (id == AddressList.get(i).getId()) {
                repository.delete(AddressList.get(i));
                return new ResponseEntity<>("Address Deleted", HttpStatus.OK);
            }
        }
        log.error("Element not found.");
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

}
