package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IComponent2;
import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Service1 implements IService1 {

    private static final Logger logger = LoggerFactory.getLogger( Service1.class );

    @Autowired
    public Service1(IComponent2 component2) {
        logger.info("Service1 constructed: " + System.currentTimeMillis());
    }

    @PostConstruct
    public void post(){
        logger.info("Service1 init");
    }

    @PreDestroy
    public void destroy(){
        logger.info("Service1 destroy");
    }
}
