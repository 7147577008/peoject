package web;

import com.it.entity.User;
import com.it.service.UserService;
import com.it.util.EmailUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String captcha = req.getParameter("captcha");
        String captchaSession = (String) req.getSession().getAttribute("captcha");
        if (captcha != null && captcha.equalsIgnoreCase(captchaSession)) {
            String username = req.getParameter("name");
            String password = req.getParameter("password");

            UserService userService = new UserService();
            final User user = userService.login(username, password);

            if (user == null) {
                logger.error("用户名或密码错误");
                resp.sendRedirect("/login?error=1002");
            } else {
                logger.debug("{}登录成功", username);


            }
        } else {
            logger.error("验证码错误");
            resp.sendRedirect("/login?error=1001");
        }
    }
}