package com.it.test;

import com.it.dao.UserDao;
import com.it.entity.User;
import com.it.util.DbHelp;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/6/12.
 */
public class UserDaoTestCase {

    UserDao userDao = new UserDao();

    @Test
    public void testSave() {
        User user = new User();
        user.setName("tom");
        user.setAddress("usa");
        userDao.save(user);
    }

    @Test
    public void testDelete() {
        userDao.delete(1);
    }

    @Test
    public void tesrFindById() {
        User user = userDao.findById(3);
        System.out.println(user);
    }

    @Test
    public void testFidAll() {
        List<User> list = userDao.findAll();
        System.out.println(list);
    }

}
