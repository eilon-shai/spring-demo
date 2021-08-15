package com.imperva.spring.demo.ioc.abs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;

public class AbstractService3<T> {

    private static final Logger logger = LoggerFactory.getLogger( AbstractService3.class );

    private Class<?> aClass;

    public AbstractService3() {

        aClass = ResolvableType.forClass(getClass()).as(AbstractService3.class).resolveGenerics()[0];

    }

    @Override
    public String toString() {
        return "service3 of type: " + aClass.getSimpleName();
    }
}
