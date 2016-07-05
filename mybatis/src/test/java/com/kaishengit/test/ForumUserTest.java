package com.kaishengit.test;

import com.kaishengit.mapper.ForumMapper;
import com.kaishengit.pojo.ForumUser;
import com.kaishengit.pojo.Tag;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BatisUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ForumUserTest {
    Logger logger = LoggerFactory.getLogger(ForumUserTest.class);

    /**
     * 测试分页
     */
    @Test
    public void testPage() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        ForumMapper forumMapper = sqlSession.getMapper(ForumMapper.class);
        List<ForumUser> forumUsers = forumMapper.findByPage(0, 2);
        for (ForumUser user : forumUsers) {
            logger.debug("{}", forumUsers);
        }
        sqlSession.close();

    }

    /**
     * 测试根据ID查找
     */
    @Test
    public void testFind() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        ForumMapper forumMapper = sqlSession.getMapper(ForumMapper.class);
        ForumUser user = forumMapper.findById(10);
        List<Tag> tags = user.getTagList();
        for (Tag tag:tags) {
             logger.debug("{}",tag);
        }


        sqlSession.close();

    }
}
