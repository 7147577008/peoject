package com.kaishengit.service;

import com.kaishengit.mapper.LoginMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Login;
import com.kaishengit.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
@Named
@Transactional
public class UserService {

    @Inject
    UserMapper userMapper;
    @Inject
    LoginMapper loginMapper;

    @Transactional(readOnly = true)
    public void save(User user) {
        userMapper.save(user);
    }

    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Transactional(readOnly = true)
    public User finById(Integer id) {
        return userMapper.finById(id);
    }

    @Transactional(readOnly = true)
    public Login findById(Integer id) {
        return loginMapper.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Login> findAll() {
        List<Login> logins = loginMapper.findAll();
        return logins;
    }


    public User login(String name, String password, String ip) {
        User user = userMapper.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            loginMapper.save(new Login(ip, user.getId()));
            return user;
        } else {
            throw new RuntimeException("账号密码错误");
        }
    }


}
