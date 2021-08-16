package com.imperva.spring.demo.ioc.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

//@Service
public class CustomEventListener implements ApplicationListener<Service2Event> {

    private static final Logger logger = LoggerFactory.getLogger( CustomEventListener.class );

    @Override
    public void onApplicationEvent(Service2Event event) {
        logger.info("service 2 started at {}", event.getSwatch() );
    }
}
