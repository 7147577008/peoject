package com.it.service;

import com.it.dao.UserDao;
import com.it.entity.User;
import com.it.util.EmailUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    UserDao dao = new UserDao();

    /**
     * @param name
     * @param password
     * @return
     */
    public User login(String name, String password) {
        final User user = dao.findName(name);
        if (user != null && user.getPassword().equals(password)) {
            logger.debug("{}登录成功", name);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    EmailUtil.sendEmail(user.getAddress(), "登录通知:", user.getName() + "您已于" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss") + "登录了系统");
                }
            });
            thread.start();

            return user;
        }
        return null;
    }
}