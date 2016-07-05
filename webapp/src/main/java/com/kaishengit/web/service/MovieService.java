package com.kaishengit.web.service;

import com.kaishengit.web.dao.MovieDao;
import com.kaishengit.web.entity.Movie;
import com.kaishengit.web.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class MovieService {

    MovieDao dao = new MovieDao();

    public List<Movie> findAll() {
        return dao.findAll();
    }

    public Page<Movie> findpage(int pageNo) {
        int totalNum = dao.Count().intValue();
        Page page = new Page(totalNum, 10, pageNo);
        List<Movie> list = dao.findByPage(page.getStart(), 10);
        page.setItems(list);
        return page;
    }


}
