package com.imperva.spring.demo.ioc.abs;

import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MyAbstractClass<T> {

    @Autowired
    AbstractService3<T> service3;
}
