package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IComponent1;
import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Component1 implements IComponent1 {

    private static final Logger logger = LoggerFactory.getLogger( Component1.class );

    //@Autowired
    private IService1 service1;

    /*@Autowired
    ApplicationContext applicationContext;*/

    public Component1() {
        //this.service1 = service1;
        logger.info("component1 constructed");
    }

    public void setService1(IService1 service1) {
        this.service1 = service1;
    }

    @PostConstruct
    public void post(){
        logger.info("component1 init");
        System.out.println();
    }

    @PreDestroy
    public void destroy(){
        logger.info("component1 destroy");
    }
}
