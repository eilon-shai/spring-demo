package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Address;
import com.imperva.spring.demo.ioc.jpa.model.Person;
import com.imperva.spring.demo.ioc.jpa.repositories.AddressRepository;
import com.imperva.spring.demo.ioc.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.imperva.spring.demo.ioc.services.PersonPersonService.*;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createPerson(){
        try {
            Thread.sleep(3000);
            final Person person = personRepository.save(new Person(randomName()));
            person.getPhoneNumbers().add(randomPhoneNumber());
            person.getPhoneNumbers().add(randomPhoneNumber());
            final Address address = randomAddress(person);
            addressRepository.save(address);
            person.getAddresses().add(address);
            personRepository.save(person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
