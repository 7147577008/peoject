package com.it.dao;

import com.it.entity.User;
import com.it.exception.DataAccessException;
import com.it.util.ConnectionManager;
import com.it.util.DbHelp;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/6/11.
 */
public class UserDao {

    public void save(User user) {
        String sql = "insert into t_user(name,address)values(?,?)";
        DbHelp.updata(sql, user.getName(), user.getAddress());
    }

    public void delete(Integer id) {
        String sql = "delete from t_user where id=?";
        DbHelp.updata(sql, id);
    }

    public User findById(Integer id) {
        String sql = "select * from t_user where id=?";
        return DbHelp.query(sql, new BeanHandler<>(User.class), id);

    }

    public List<User> findAll() {
        String sql = "select * from t_user ";

        return DbHelp.query(sql, new BeanListHandler<>(User.class));

    }

    public User findName(String name) {
        String sql = "select * from t_user where name=?";
        return DbHelp.query(sql, new BeanHandler<>(User.class), name);
    }

}