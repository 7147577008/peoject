package web;

import com.it.dao.DocumenDao;
import com.it.service.DocumentService;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

/**
 * Created by Administrator on 2016/6/16.
 */
@WebServlet("/fileServlet")
@MultipartConfig
public class FileServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(FileServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/sendfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fileDesc = req.getParameter("fileDesc");
        logger.debug("文件描述为{}", fileDesc);

        Part part = req.getPart("doc");

        logger.debug("size:{}", part.getSize());
        InputStream input = part.getInputStream();
        DocumentService documentService = new DocumentService();


        try {
            documentService.updateFile(getName(part), part.getSize(), input);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getName(Part part) {
        String headerValue = part.getHeader("Content-Disposition");
        headerValue = headerValue.substring(headerValue.indexOf("filenam"));
        headerValue = headerValue.substring(headerValue.indexOf("\"") + 1, headerValue.length() - 1);
        return headerValue;

    }

}
