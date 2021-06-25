package com.wuhl.boot05web02.controller;

import com.wuhl.boot05web02.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 如果访问的是/ 或者是/login ，都进入login页面
     * @return login.html
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    /**
     * 登录成功之后跳转到 main页面
     * 此次为post方式提交，因为登录时有表单的提交
     * @return 成功：main.html  失败：login.html
     */
    @PostMapping("/login")
    public String mainPage(User user,Model model,HttpSession session
                           ){
        //如果用户名和密码都是正确的，那么可以进入到main页面
        if ("aaa".equals(user.getUsername())&&"123".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            //重定向到main页面
            return "redirect:main.html";
        //如果用户名或者密码错误，那么就保存错误信息，并且仍然停留在login页面
        }else {
            model.addAttribute("msg","抱歉，您的用户名或者密码输入错啦！！！");
            return "login";
        }


    }

    /**
     * 如果在main页面进行刷新操作，则直接重定向到本页面，防止页面的重复提交
     * @return
     */
    @GetMapping("/main.html")
    public String reMain(){
        return "main";
    }


}
