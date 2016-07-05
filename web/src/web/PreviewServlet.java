package web;

import com.it.service.DocumentService;
import org.apache.commons.dbcp2.Utils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.entity.Docoment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/6/18.
 */
@WebServlet("/preview")
public class PreviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md5 = req.getParameter("id");
        String down = req.getParameter("down");

        if (StringUtils.isNotEmpty(md5)) {
            Docoment document = new DocumentService().findMd5(md5);
            if (document == null) {
                resp.sendError(404);
            } else {
                String saveFileName = document.getSavename();
                File file = new File("D:/upload1", saveFileName);
                if (file.exists()) {

                    if ("true".equals(down)) {

                        resp.setContentType("application/octet-stream");
                        String fileName = new String(document.getFilename().getBytes("UTF-8"), "ISO8859-1");
                        resp.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
                        resp.setContentLength(document.getSize().intValue());

                    }

                    FileInputStream fileInputStream = new FileInputStream(file);
                    OutputStream outputStream = resp.getOutputStream();
                    IOUtils.copy(fileInputStream, outputStream);
                    outputStream.flush();
                    outputStream.close();
                    fileInputStream.close();


                } else {
                    resp.sendError(404);

                }

            }


        } else {
            resp.sendError(404);
        }
    }
}
