package com.imperva.spring.demo.ioc.abs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;

public class AbstractService3<T> {

    private static final Logger logger = LoggerFactory.getLogger( AbstractService3.class );

    public AbstractService3() {

        final Class<?> aClass = ResolvableType.forClass(getClass()).as(AbstractService3.class).resolveGenerics()[0];
        logger.info("service3 class: " + aClass.getName());

    }
}
