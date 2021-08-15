package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Address;
import com.imperva.spring.demo.ioc.jpa.model.Person;
import com.imperva.spring.demo.ioc.jpa.repositories.AddressRepository;
import com.imperva.spring.demo.ioc.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PersonServiceHelper {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public void updateAddress(long id, String street) {
        try {
            Person person = personRepository.findById(id).get();
            final Set<Address> addresses = person.getAddresses();
            final Address address1 = new Address(street, 0, "Jerusalem", person);
            addresses.add(address1);
            addressRepository.save(address1);
            personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
