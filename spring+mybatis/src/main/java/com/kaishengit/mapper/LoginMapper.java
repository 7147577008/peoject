package com.kaishengit.mapper;

import com.kaishengit.pojo.Login;

import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
public interface LoginMapper {
    void save(Login login);

    Login findById(Integer id);

    List<Login> findAll();

}
