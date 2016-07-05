package com.kaishengit.test;

import com.kaishengit.mapper.TopicMapper;
import com.kaishengit.pojo.Topic;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BatisUtil;

/**
 * Created by Administrator on 2016/6/29.
 */
public class TopicTestCase {
    Logger logger = LoggerFactory.getLogger(TopicTestCase.class);

    /**
     * 根据ID 内链接查找表中附表的相关数据
     */
    @Test
    public void testFind() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
        Topic topic = topicMapper.findById(2);
        logger.debug("{}", topic);
        logger.debug("username{}",topic.getForumUser().getUsername());
        logger.debug("useravater{}",topic.getForumUser().getAvatar());
        logger.debug("nodename{}",topic.getForumNode().getNodename());

        sqlSession.close();
    }
}
