package com.kaishengit.Servicr;

import com.kaishengit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

//@Service  //开头必须要加 属于Sping
@Named    //开头必须要加 属于jAVAX
public class UserService {

    //@Autowired  //根据属性名字进行注入 属于Sping里
    @Inject   //与Autowired相似 与Named都属于JAVAx里 需要一致
    private UserDao userDao1;


    public void sayHi() {
        userDao1.save();
    }


}
