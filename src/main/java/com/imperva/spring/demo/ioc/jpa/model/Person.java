package com.imperva.spring.demo.ioc.jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "personName")
    private String name;

    @OneToMany(mappedBy = "id")
    private Set<Address> addresses = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "personPhones", joinColumns=@JoinColumn(name="person_id"))
    @Column(name="phone_number")
    private Set<String> phoneNumbers = new HashSet<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
