package com.kaishengit.test;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.mapper.NodeMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Node;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BatisUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/28.
 */
public class NodeMapperTest {
    Logger logger = LoggerFactory.getLogger(NodeMapper.class);

    @Test
    /**
     * 测试批量新增方法
     */
    public void testSave() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        List<Node> node = Lists.newArrayList();
        node.add(new Node("xasa"));
        node.add(new Node("xdada"));
        nodeMapper.batchSave(node);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 测试批量删除方法
     */
    public void testDelete() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        List<Integer> nodeList = Lists.newArrayList(7, 8, 9);
        nodeMapper.delete(nodeList);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    /**
     * 测试根据id批量查找
     */
    public void testFind() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        List<Integer> list = Lists.newArrayList(1, 2);

        List<Node> nodeList = nodeMapper.findById(list);
        for (Node node : nodeList) {
            logger.debug("{}", node);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 测试根据多个条件查找
     */
    public void testFindTJ() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = Maps.newHashMap();

        userMapper.findTiaoJian(map);
        sqlSession.close();
    }

    @Test
    /**
     * 测试在一个方法中多次查找 使用缓存
     */
    public void findOne() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        Node node = nodeMapper.findOneId(1);
        Node node1 = nodeMapper.findOneId(1);
       logger.debug("{}",node);
        sqlSession.close();

    }

}
