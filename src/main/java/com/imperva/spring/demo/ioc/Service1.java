package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.events.Service2Event;
import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class Service1 implements IService1 {

    private static final Logger logger = LoggerFactory.getLogger( Service1.class );

    public Service1() {
        logger.info("Service1 constructed: " + System.currentTimeMillis());
    }

    @EventListener
    public void applicationRefreshed(ContextRefreshedEvent contextRefreshedEvent){
        logger.info("context load completed");
    }

}
