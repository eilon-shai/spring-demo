package com.imperva.spring.demo.ioc;

import com.imperva.spring.demo.ioc.events.Service2Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger( AppConfig.class );

}
