package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false, defaultValue = "false") String vip, Integer age) {
        logger.debug("--------------------------------------");
        model.addAttribute("username", "hello Spring");
        logger.debug("vip:{},age:{}", vip, age);
        return "user/list";
    }

    /**
     *
     * @param userId
     * @return  通过ModelAndView来返回 ID
     */
    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public ModelAndView findId(@PathVariable("id") Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/find");//需要去跳转的路径
        modelAndView.addObject("userId", userId); //设置跳转值
        return modelAndView;
    }

    /**
     *
     * @param id  user里面的id
     * @param cataId photo里面的id
     * @return  user与photo 同时传两个值
     */ //user/1/photo/cataId/1
    @RequestMapping(value = "/{id:\\d+}/photo/{cataId}", method = RequestMethod.GET)
    public String showPhoto(@PathVariable Integer id, @PathVariable Integer cataId) {
        return "user/photo";
    }

    /**
     *
     * @return 请求转发到new视图里
     */

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser() {
        return "user/new";
    }

    /**
     *
     * @param user 把实体类对象当作参数传进去，新增数据
     * @return 重定向到user视图中
     */

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveUser(User user) {
        logger.debug("-------------------------------------------------");
        logger.debug("username:{} address:{} age:{} ", user.getName(), user.getAddress(), user.getAge());
        logger.debug("-------------------------------------------------");
        return "redirect:/user";
    }

    /**
     *
     * @param id user里id 后跟del 删除该id
     * @return
     */
    @RequestMapping(value = "/{id:\\d}/del", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/del");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    //    AjAx--Json-------------------------------------------------------------------------

    /**
     *
      * @return  类对象  需要添加json依赖文件
     */
    @RequestMapping(value = "/{id}.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User showJson() {
        User user = new User();
        user.setName("张撒");
        user.setAddress("中国");
        user.setAge(23);
        return user;
    }

    //-------------------------------用session来设置对象      -----------------------------------------------
    @RequestMapping("/native")
    public String nativeHttpServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ServletContext context = session.getServletContext();
        session.setAttribute("name", "张三");
        return "home";

    }

    //--------- 文件上传 -----------------------------------------------
    @RequestMapping(value = "/avater/upload", method = RequestMethod.GET)
    public String fileLoad() {

        return "user/upload";
    }

    /**
     *
     * @param photoname 视图中 input name的命名
     * @param file MultipartFile 用来接收视图中name
     * @return  返回视图列表
     */
    @RequestMapping(value = "avater/upload", method = RequestMethod.POST)
    public String upLoadAvater(String photoname, MultipartFile file) {
        try {
            IOUtils.copy(file.getInputStream(), new FileOutputStream("D:/upload1" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/user";
    }

}
