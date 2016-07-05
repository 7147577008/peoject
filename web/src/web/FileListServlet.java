package web;

import com.it.service.DocumentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.entity.Docoment;

import java.io.IOException;
import java.util.List;

@WebServlet("/filelist")
public class FileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DocumentService documentService = new DocumentService();
        List<Docoment> docoments = documentService.finAll();
        req.setAttribute("docoments", docoments);


        req.getRequestDispatcher("/WEB-INF/views/filelist.jsp").forward(req, resp);
    }
}
