package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IComponent1;
import com.imperva.spring.demo.ioc.interfaces.IComponent2;
import com.imperva.spring.demo.ioc.interfaces.IService1;
import com.imperva.spring.demo.ioc.interfaces.IService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@ConditionalOnProperty(value="load.component2", havingValue ="true", matchIfMissing = false)
public class Component2 implements IComponent2 {

    private static final Logger logger = LoggerFactory.getLogger( Component2.class );

    @Autowired
    public Component2(IComponent1 component1) {
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
