package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Address;
import com.imperva.spring.demo.ioc.jpa.model.Person;
import com.imperva.spring.demo.ioc.jpa.repositories.AddressRepository;
import com.imperva.spring.demo.ioc.jpa.repositories.PersonRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class PersonPersonService implements IPersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonServiceHelper personServiceHelper;

    private static final Logger logger = LoggerFactory.getLogger( PersonPersonService.class );

    public Person getPerson(Long id){
       return personRepository.findById(id).get();
    }

    public void createPerson(String name){
        final Person person = personRepository.save(new Person(name));
        person.getPhoneNumbers().add(randomPhoneNumber());
        person.getPhoneNumbers().add(randomPhoneNumber());
        final Address address = randomAddress(person);
        addressRepository.save(address);
        person.getAddresses().add(address);
        personRepository.save(person);
    }

    //@Transactional
    public void updatePerson(Long id){
        final Optional<Person> byId = personRepository.findById(id);
        byId.ifPresent(person -> {
            String value =  RandomStringUtils.random(10, true, false);
            final ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.submit(()->updateName(person.getId(), value));
            executorService.submit(()->updatePhone(person.getId(), value));
            executorService.submit(()->updateAddress(person.getId(), value));
            try {
                executorService.awaitTermination(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void updateName(long id, String name){
        try {
            Person person = personRepository.findById(id).get();
            person.setName(name);
            personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePhone(long id, String phone){
        try {
            Person person = personRepository.findById(id).get();
            person.setPhoneNumbers(Set.of(phone));
            personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Transactional
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

    private static final String[] cities = {"Tokyo","Mumbai","Jerusalem"};
    private static final Random random = new Random();

    private Address randomAddress(Person person){
         String street =  RandomStringUtils.random(10, true, false);
         int number =  random.nextInt(30);
         String city = cities[random.nextInt(2)];
         return new Address(street, number, city, person);
    }

    private String randomPhoneNumber(){
        return "050-" + RandomStringUtils.random(10, false, true);
    }


}
