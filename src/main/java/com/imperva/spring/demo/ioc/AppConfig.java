package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.interfaces.IService1;
import com.imperva.spring.demo.ioc.interfaces.IService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger( AppConfig.class );

    //@Bean
    public IService2 service2() {
        return new Service2();
    }

}
