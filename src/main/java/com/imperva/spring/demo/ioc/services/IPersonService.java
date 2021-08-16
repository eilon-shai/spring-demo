package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Person;

public interface IPersonService {

    Person getPerson(Long id);

    void createPersons();

    void updatePerson(Long id);

    void deleteAll();

}
