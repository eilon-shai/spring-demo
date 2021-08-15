package com.imperva.spring.demo.ioc.abs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class MyAbstractClass<T> {

    private static final Logger logger = LoggerFactory.getLogger( MyAbstractClass.class );

    @Autowired
    AbstractService3<T> service3;

    @PostConstruct
    public void printServiceType(){
        logger.info(getClass().getSimpleName() + ":" + service3.toString());
    }
}
