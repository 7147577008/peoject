package com.kaishengit.mapper;

import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface UserMapper {

    List<User> findTiaoJian(Map<String, Object> tiaojian);//根据条件进行查询

    //UserAdmin finByParams(@Param("username") String username, @Param("pwd") String pwd);

    User findById(Integer id);

    void update(User user);

    void save(User user);

    void delete(Integer id);

    List<User> findAll();
}
