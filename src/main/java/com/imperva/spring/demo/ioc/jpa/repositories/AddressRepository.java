package com.imperva.spring.demo.ioc.jpa.repositories;

import com.imperva.spring.demo.ioc.jpa.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
