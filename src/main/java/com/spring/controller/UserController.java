package com.spring.controller;

import com.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author :xiaozou
 * @Date : 2022/3/11- 14:03
 **/
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Resource
    private UserService userService;

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(){
        logger.info("getUser-------------------------------------");
        return userService.findAllUser().toString();
    }

    @GetMapping("/")
    public String demo(){
        logger.info("demo-------------------------------------");
        return "/index";
    }

    @GetMapping("/page")
    public String getUserPage(){
        logger.info("getUserPage-------------------------------------");
        return "/user";
    }

}
