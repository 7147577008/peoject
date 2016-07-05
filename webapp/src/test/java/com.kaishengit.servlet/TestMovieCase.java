package com.kaishengit.servlet;

import com.kaishengit.web.dao.MovieDao;
import com.kaishengit.web.entity.Movie;
import com.kaishengit.web.service.MovieService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/6/17.
 */
public class TestMovieCase {
    MovieDao dao = new MovieDao();
    MovieService service = new MovieService();

    @Test
    public void test() {
        List<Movie> movies = dao.findAll();
        Assert.assertNotNull(movies);

    }

    @Test
    public void Test() {
        List<Movie> list = dao.findByPage(10, 10);
        System.out.println(list);
    }

    @Test
    public void TE() {
        List<Movie> list = service.finMovieByPage(1);
        for (Movie mo : list) {
            System.out.print(mo);

        }

    }
}
