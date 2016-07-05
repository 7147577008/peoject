package com.kaishengit.test;


import com.kaishengit.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BatisUtil;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MybatisTest {
    private Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    /**
     * 测试增删改查
     */


    @Test
    public void testFindById() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById", 10);
        logger.debug("user{}", user);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById", 9);
        user.setTitle("新华词典");
        sqlSession.update("com.kaishengit.mapper.UserMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void add() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        User user = new User();
        user.setCode("001");
        user.setTitle("神雕侠侣");
        user.setCount(1000);
        sqlSession.insert("com.kaishengit.mapper.UserMapper.save", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.mapper.UserMapper.delete", 13);

        sqlSession.close();
    }

    @Test
    public void findAll() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        List<User> user = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
        for (User user1 : user) {
            logger.debug("user{}", user1);
        }
        sqlSession.close();
    }
}