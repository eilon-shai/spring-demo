package com.imperva.spring.demo.ioc.services;

import com.imperva.spring.demo.ioc.jpa.model.Person;

public interface IService {

    Person getPerson(Long id);

    void createPerson(String name);

    void updatePersonName(Long id, String name);

}
