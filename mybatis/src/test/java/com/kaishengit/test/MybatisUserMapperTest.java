package com.kaishengit.test;

import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;

import com.kaishengit.pojo.UserAdmin;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BatisUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MybatisUserMapperTest {
    private Logger logger = LoggerFactory.getLogger(MybatisUserMapperTest.class);

    @Test
    public void testFindId() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(10);
        logger.debug("id{}", user);
        sqlSession.close();
    }

    @Test
    public void testUpDate() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(10);
        user.setAuthor("三国志1");
        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findAll();
        for (User user : list) {
            logger.debug("user{}", user);
        }
        sqlSession.close();
    }




    @Test
    public void testSave() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();

        user.setAuthor("1");

        user.setTitle("无名");

        userMapper.save(user);
        logger.debug("id{}", user.getId());
        sqlSession.commit();
        sqlSession.close();
    }
}
