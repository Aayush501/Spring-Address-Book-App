package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.AddressModel;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressService {

    private List<AddressModel>AddressList = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<List<AddressDTO>> getAddressBook() {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for(AddressModel address : AddressList){
            AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
            addressDTOList.add(addressDTO);
        }

        log.info("Elements displayed");
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }

    public ResponseEntity<AddressDTO> getAddressByID(@PathVariable long id){
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
        AddressList.add(addressModel);
        log.info("Element added");
        return new ResponseEntity<>("Address added in book", HttpStatus.CREATED);
    }

    public ResponseEntity<String> putAddress(long id, AddressDTO addressBookDTO) {
        for (int i = 0; i < AddressList.size(); i++) {
            if (id == AddressList.get(i).getId()) {
                AddressModel addressModel = modelMapper.map(addressBookDTO, AddressModel.class);
                AddressList.set(i, addressModel);
                log.info("Updated the element");
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            }
        }
        log.error("Element not found.");
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> DeleteAddress(long id) {
        for (int i = 0; i < AddressList.size(); i++) {
            if (id == AddressList.get(i).getId()) {
                AddressList.remove(i);
                log.info("Element has been deleted");
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            }
        }
        log.error("No such element exist");
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

}
