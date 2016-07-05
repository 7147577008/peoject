package com.kaishengit.web.dao;

import com.kaishengit.web.entity.Movie;
import com.kaishengit.web.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/6/17.
 */
public class MovieDao {
    public List<Movie> findAll() {
        String sql = "select* from movie";
        return DbHelp.query(sql, new BeanListHandler<>(Movie.class));
    }

    public List<Movie> findByPage(int start, int size) {
        String sql = "select * from movie limit ? ,?";
        return DbHelp.query(sql, new BeanListHandler<>(Movie.class), start, size);
    }

    public Long Count() {
        String sql = "select count(*)from movie ";
        return DbHelp.query(sql, new ScalarHandler<Long>());
    }

}
