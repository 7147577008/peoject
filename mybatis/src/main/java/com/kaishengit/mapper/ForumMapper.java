package com.kaishengit.mapper;

import com.kaishengit.pojo.ForumUser;
import com.kaishengit.pojo.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public interface ForumMapper {
    ForumUser findById(Integer id);

    /**
     *
     * @param size 根据条件查询
     * @param page 查询数字必须为int类型
     * @return
     */
    List<ForumUser> findByPage(@Param("start") int size, @Param("size") int page);

}
