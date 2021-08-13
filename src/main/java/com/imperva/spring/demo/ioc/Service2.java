package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class Service2 implements IService2 {

    private static final Logger logger = LoggerFactory.getLogger( Service2.class );

    private String name;

    @Autowired
    public Service2(Component1 component1) {
        logger.info("Service2 constructed");
    }

    public Service2(String name) {
        this.name = name;
        logger.info(name + " constructed");
    }

    @PostConstruct
    public void post(){
        logger.info(name!=null?name:"Service2" + " init");
    }

    @PreDestroy
    public void destroy(){
        logger.info(name!=null?name:"Service2" + " destroy");
    }
}
