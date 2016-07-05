package com.kaishengit.dao;

import org.springframework.stereotype.Service;

import javax.inject.Named;


//@Service("userDao1")  //名字与Service里属性对象名必须一致 属于Sping
@Named("userDao1") //属于Javax里
public class Demo2 implements UserDao {

    public void save() {
        System.out.println("save2....");
    }
}
