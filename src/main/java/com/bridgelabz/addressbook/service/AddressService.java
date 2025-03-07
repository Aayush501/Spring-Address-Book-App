package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.model.AddressModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class AddressService {
    private List<AddressModel>AddressList = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<List<AddressDTO>> getAddressBook() {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for(AddressModel address : AddressList){
            AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
            addressDTOList.add(addressDTO);
        }

        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }

    public ResponseEntity<AddressDTO> getAddressByID(@PathVariable long id){
        for(AddressModel address : AddressList){
            if(address.getId() == id){
                AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
                return new ResponseEntity<>(addressDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> postAddress(@RequestBody AddressDTO addressDTO){
        AddressModel addressModel = modelMapper.map(addressDTO, AddressModel.class);
        AddressList.add(addressModel);
        return new ResponseEntity<>("Address added in book", HttpStatus.CREATED);
    }

    public ResponseEntity<String> putAddress(long id, AddressDTO addressBookDTO) {
        for (int i = 0; i < AddressList.size(); i++) {
            if (id == AddressList.get(i).getId()) {
                AddressModel addressModel = modelMapper.map(addressBookDTO, AddressModel.class);
                AddressList.set(i, addressModel);
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> DeleteAddress(long id) {
        for (int i = 0; i < AddressList.size(); i++) {
            if (id == AddressList.get(i).getId()) {
                AddressList.remove(i);
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
