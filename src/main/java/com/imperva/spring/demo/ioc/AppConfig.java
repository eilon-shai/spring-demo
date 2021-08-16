package com.imperva.spring.demo.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger( AppConfig.class );


}
