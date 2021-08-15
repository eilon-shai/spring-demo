package com.imperva.spring.demo.ioc.jpa.repositories;

import com.imperva.spring.demo.ioc.jpa.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
