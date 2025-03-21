package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressModel, Long> {
}
