package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Person;

import java.util.List;

public interface IPersonService {

    Person getPerson(Long id);

    long getPersonsCount();

    void createPersons();

    void updatePerson(Long id);

    void deleteAll();

}
