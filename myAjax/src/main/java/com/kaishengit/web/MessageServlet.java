package com.kaishengit.web;

import com.google.gson.Gson;
import com.kaishengit.entity.Message;
import com.kaishengit.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> list = new MessageService().findAll();
        req.setAttribute("list", list);
        int maxId = 0;
        if (!list.isEmpty()) {
            maxId = list.get(0).getId();
        }
        req.setAttribute("maxId", maxId);
        req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxId = req.getParameter("maxId");
        List<Message> list = new MessageService().findMessageMaxId(maxId);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(list));
        out.flush();
        out.close();
    }
}
