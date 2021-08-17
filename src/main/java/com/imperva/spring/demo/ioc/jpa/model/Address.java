package com.imperva.spring.demo.ioc.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {


    public Address() {
    }

    public Address(String street, int number, String city, Person person) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String street;
    private int number;
    private String city;


    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public Person getPerson() {
        return person;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address : {" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                '}';
    }
}
