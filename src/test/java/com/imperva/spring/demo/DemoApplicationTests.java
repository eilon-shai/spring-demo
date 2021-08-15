package com.imperva.spring.demo;

import com.imperva.spring.demo.ioc.Service1;
import com.imperva.spring.demo.ioc.interfaces.IService1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	IService1 service1;

	@Test
	public void test1() {
		((Service1)service1).method1();
		//((Service1)TestUtils.getProxyTarget(service1)).method1();
	}

}
