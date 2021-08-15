package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.NO)
public class Service1 implements IService1 {

    private static final Logger logger = LoggerFactory.getLogger( Service1.class );

    public Service1() {
        logger.info("Service1 constructed: " + System.currentTimeMillis());
    }

    public void method1(){
        logger.info("in method1");
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
