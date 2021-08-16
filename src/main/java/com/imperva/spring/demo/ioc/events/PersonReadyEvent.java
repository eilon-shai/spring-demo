package com.imperva.spring.demo.ioc.events;

public class PersonReadyEvent {

    private long id;

    public PersonReadyEvent(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
