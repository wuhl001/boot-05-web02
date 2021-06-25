package com.wuhl.boot05web02.controller;

import com.wuhl.boot05web02.domain.User;
import com.wuhl.boot05web02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 点击此按钮是跳转到该页面
     * @return
     */
    @GetMapping("/dynamic_table.html")
    public String dynamic_table(Model model){
        List<User> allUser = userService.findAllUser();
        model.addAttribute("users",allUser);

        return "table/dynamic_table";
    }
}
