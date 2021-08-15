package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Person;

public interface IPersonService {

    Person getPerson(Long id);

    void createPerson(String name);

    void updatePerson(Long id);

}
