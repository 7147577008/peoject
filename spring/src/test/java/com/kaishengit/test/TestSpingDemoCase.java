package com.kaishengit.test;

import com.kaishengit.Servicr.BookService;
import com.kaishengit.Servicr.UserService;
import com.kaishengit.dao.Demo1;
import com.kaishengit.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Named;


public class TestSpingDemoCase {
    @Test
    public void tset() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        UserService service = (UserService) context.getBean("userService");
        service.sayHi();


    }
}
