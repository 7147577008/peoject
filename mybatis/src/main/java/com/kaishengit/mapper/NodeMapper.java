package com.kaishengit.mapper;

import com.kaishengit.pojo.Node;
import com.kaishengit.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface NodeMapper {
    Node findOneId(Integer id);

    void batchSave(List<Node> nodelist);// 批量存储

    List<Node> findById(List<Integer> id);//批量查询 因为查询可能会是多个所以需要用到List

    void delete(List<Integer> nodeList);//批量删除

}
