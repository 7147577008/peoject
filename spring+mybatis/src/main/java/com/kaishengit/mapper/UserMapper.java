package com.kaishengit.mapper;

import com.kaishengit.pojo.Login;
import com.kaishengit.pojo.User;

/**
 * Created by Administrator on 2016/7/2.
 */
public interface UserMapper {
    void save(User user);

    User finById(Integer id);

    User findByName(String name);

}
