package com.imperva.spring.demo.ioc.events;

import org.springframework.context.ApplicationEvent;

public class Service2Event extends ApplicationEvent {

    long swatch;

    public Service2Event(Object source) {
        super(source);
        this.swatch = System.currentTimeMillis();
    }

    public long getSwatch() {
        return swatch;
    }
}
