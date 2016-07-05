package web;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet("/captcha.png")
public class CaptchaServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(CaptchaServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConfigurableCaptchaService service = new ConfigurableCaptchaService();
        service.setColorFactory(new SingleColorFactory(new Color(170, 46, 57)));
        service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));

        OutputStream outputStream = resp.getOutputStream();
        String captcha = EncoderHelper.getChallangeAndWriteImage(service, "png", outputStream);
        HttpSession session = req.getSession();
        session.setAttribute("captcha", captcha);
        logger.debug("验证码为{}", captcha);

        outputStream.flush();
        outputStream.close();
    }
}
