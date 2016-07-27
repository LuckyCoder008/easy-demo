package com.lijw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lijianwei on 2016/7/26.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping({"/userInfo"})
    public String userInfo(HttpServletRequest request, HttpServletResponse response) {
        return "/user/userinfo";
    }
}
