package com.kaishengit.web.web;


import com.kaishengit.web.entity.Movie;
import com.kaishengit.web.service.MovieService;
import com.kaishengit.web.util.Page;
import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.*;

import org.apache.commons.lang3.StringUtils;
import com.kaishengit.web.entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = new MovieService();
        java.lang.String pageNo = req.getParameter("p");
        int p = 1;
        if (StringUtils.isNumeric(pageNo)) {
            p = Integer.parseInt(pageNo);
        }
        Page<Movie> page = movieService.findpage(p);
        req.setAttribute("page", page);

        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);

    }
}