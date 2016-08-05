package com.lijw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public String fileUpload(HttpServletRequest request, HttpServletResponse response) {
        return "/fileupload/fileupload";
    }

    @RequestMapping({"/fileupload_list"})
    public String fileUploadList(HttpServletRequest request, HttpServletResponse response) {
        return "/fileupload/fileupload_list";
    }

    @RequestMapping(value = "/doupload", method = RequestMethod.POST)
    public String doUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
//        System.out.println(file.toString());
        try {
            byte[] bytes = file.getBytes();
            file.getContentType();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("E:\\projects\\static\\images\\" + UUID.randomUUID() + ".png"));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/fileupload/fileupload";
    }

    @RequestMapping(value = "/douploadlist", method = RequestMethod.POST)
    public String doUploadList(HttpServletRequest request, HttpServletResponse response) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (files.size() > 0) {
            for (int i = 0; i < files.size(); i++) {
                try {
                    MultipartFile file = files.get(i);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("E:\\projects\\static\\images\\" + UUID.randomUUID() + getFileName(file)));
                    stream.write(bytes);
                    stream.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return "/fileupload/fileupload_list";
    }

    private String getFileName(MultipartFile file) {
        String contentType = file.getContentType();
        Assert.notNull(contentType);

        int index = contentType.indexOf("/");
        String fileName = contentType.substring(index + 1, contentType.length());
        return "." + fileName;
    }

    //自己捕获异常
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception ex,HttpServletRequest request) {
//        Map<Object, Object> model = new HashMap<Object, Object>();
//        if (ex instanceof MaxUploadSizeExceededException){
//            model.put("errors", "文件应不大于 "+
//                    getFileKB(((MaxUploadSizeExceededException)ex).getMaxUploadSize()));
//        } else{
//            model.put("errors", "不知错误: " + ex.getMessage());
//        }
//        return new ModelAndView("/fileupload/fileupload", (Map) model);
//
//    }
//
//    private String getFileKB(long byteFile){
//        if(byteFile==0)
//            return "0KB";
//        long kb=1024;
//        return ""+byteFile/kb+"KB";
//    }
//    private String getFileMB(long byteFile){
//        if(byteFile==0)
//            return "0MB";
//        long mb=1024*1024;
//        return ""+byteFile/mb+"MB";
//    }

}
