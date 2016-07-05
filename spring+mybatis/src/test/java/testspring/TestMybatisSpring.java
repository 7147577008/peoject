package testspring;

import com.kaishengit.pojo.Login;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:ApplicationContext.xml")


public class TestMybatisSpring {
   @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService service = (UserService) context.getBean("userService");
       service.findAll();
    }


//    @Inject
//    UserService userService;
//
//    @Test
//    public void test() {
//        User user = new User();
//        user.setName("Spingm");
//        user.setAddress("432");
//        user.setPassword("123");
//        userService.save(user);
//
//    }
//
//    @Test
//    public void testFindById() {
//        User user = userService.finById(3);
//        System.out.println(user.show());
//    }
//
//    @Test
//    public void testName() {
//        User user = userService.findByName("tom");
//        System.out.println(user.show());
//    }
//
//    @Test
//    public void testLogin() {
//        userService.login("tom", "123434", "1.1.1.1");
//    }
//
//    @Test
//    public void testLoginFind() {
//        Login login = userService.findById(2);
//        System.out.println(login.show());
//    }
//
//    @Test
//    public void testFindAll() {
//        List<Login> logins = userService.findAll();
//        for (Login login : logins) {
//            System.out.println(login.show());
//        }
//    }
}
