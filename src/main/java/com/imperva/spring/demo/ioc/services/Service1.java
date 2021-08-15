package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Person;
import com.imperva.spring.demo.ioc.jpa.repositories.PersonRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Service1 implements IService {

    @Autowired
    PersonRepository personRepository;

    private static final Logger logger = LoggerFactory.getLogger( Service1.class );

    public Person getPerson(Long id){
       return personRepository.findById(id).get();
    }

    public void createPerson(String name){
        personRepository.save(new Person(name, randomAddress()));
    }

    public void updatePersonName(Long id, String name){
        final Optional<Person> byId = personRepository.findById(id);
        byId.ifPresent(person -> {
            person.setName(name);
            personRepository.save(person);
        });
    }

    private String randomAddress(){
        return RandomStringUtils.random(20, true, true);
    }


}
