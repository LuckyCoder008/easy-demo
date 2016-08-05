package com.lijw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

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

    @RequestMapping({"/fileupload"})
    public String fileupload(HttpServletRequest request, HttpServletResponse response) {
        return "/fileupload/fileupload";
    }

    @RequestMapping(value = "/doupload",method = RequestMethod.POST)
    public String doUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file){
//        System.out.println(file.toString());
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("E:\\projects\\static\\images"+ UUID.randomUUID() +".png"));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/fileupload/fileupload";
    }
}
