package com.wuhl.boot05web02.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhl.boot05web02.domain.City;
import com.wuhl.boot05web02.domain.User;
import com.wuhl.boot05web02.service.CityService;
import com.wuhl.boot05web02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    UserService userService;

    /**
     * 访问 dynamic_table 路径时，执行下边的findAll方法
     * @param model
     * @return
     */
    @GetMapping("/dynamic_table")
    public String findAll(  //获取到当前的页码pn，如果没有页面，那么默认页码是第一页
                            @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                            Model model){

        /**
         * 查询出city，并将其存入到model中
         */
        List<City> cityList = cityService.list();
        model.addAttribute("citys",cityList);

        //Page<>(pn,2) 左边参数是当前页码，右边参数是每一页的记录条数
        //page(cityPage) 是MP中的分页函数，左边参数是一个Page对象，右边参数是查询条件
        Page<City> cityPage = new Page<>(pn,2);
        Page<City> page = cityService.page(cityPage, null);

        //把page信息存入到model中
        model.addAttribute("page",page);



        /**
         * 查询出user，并将其存入到model中
         */
        List<User> users = userService.findAllUser();
        model.addAttribute("users",users);

        return "table/dynamic_table";
    }

    /**
     * 根据id删除记录
     * @return
     */
    @GetMapping("delete/{id}")
    public String deleteCityById(@PathVariable("id") Integer id){

        cityService.removeById(id);

        return "redirect:/dynamic_table";
    }



}
