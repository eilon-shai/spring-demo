package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.events.Service2Event;
import com.imperva.spring.demo.ioc.interfaces.IService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Qualifier("service2")
public class Service2 implements IService2 {

    private static final Logger logger = LoggerFactory.getLogger( Service2.class );

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void publishCompleted(){
        logger.info("service2 started");
        applicationEventPublisher.publishEvent(new Service2Event(this));
    }
}
