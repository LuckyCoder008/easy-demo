package com.lijw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile file){
        System.out.println(file.toString());
        return "/user/fileupload";
    }
}
