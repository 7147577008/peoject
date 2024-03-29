package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/24.
 */
@WebServlet("/upload")
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("file");
        String fileName = getFileName(part);
        System.out.println("FileName:" + fileName);
    }

    private String getFileName(Part part) {
        String headerValue = part.getHeader("Content-Disposition");
        headerValue = headerValue.substring(headerValue.indexOf("filename=\""));
        headerValue = headerValue.substring(headerValue.indexOf("\"") + 1, headerValue.length() - 1);
        return headerValue;
    }
}
