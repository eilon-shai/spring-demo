package com.imperva.spring.demo.ioc.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestBean {

    private static final Logger logger = LoggerFactory.getLogger( RequestBean.class );

    public RequestBean() {
        logger.info("RequestBean constructed " + System.currentTimeMillis());
    }

    @PostConstruct
    public void post(){
        logger.info("RequestBean init");
    }

    @PreDestroy
    public void destroy(){
        logger.info("RequestBean destroy");
    }

}
