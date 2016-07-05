package web;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/18.
 */
public class CommentFileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fileDesc = req.getParameter("fileDesc");
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            ServletContext servletContext = getServletContext();
                        //声明临时存放的文件夹
            //需要new一个对象出来进行


        }


    }
}
