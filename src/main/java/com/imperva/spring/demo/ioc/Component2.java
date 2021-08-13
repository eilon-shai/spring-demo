package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IComponent2;
import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class Component2 implements IComponent2 {

    private static final Logger logger = LoggerFactory.getLogger( Component2.class );

    @Autowired
    IService1 service1;

    public Component2() {
        logger.info("Component2 constructed");
    }

    @PostConstruct
    public void post(){
        logger.info("Component2 init");
    }

    @PreDestroy
    public void destroy(){
        logger.info("Component2 destroy");
    }
}
