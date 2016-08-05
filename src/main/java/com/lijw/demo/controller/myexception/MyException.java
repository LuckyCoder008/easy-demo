package com.lijw.demo.controller.myexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * Created by lijianwei on 2016/8/5.
 */
public class MyException implements HandlerExceptionResolver {

    private String getFileKB(long byteFile){
        if(byteFile==0)
            return "0KB";
        long kb=1024;
        return ""+byteFile/kb+"KB";
    }
    private String getFileMB(long byteFile){
        if(byteFile==0)
            return "0MB";
        long mb=1024*1024;
        return ""+byteFile/mb+"MB";
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<Object, Object> model = new HashMap<Object, Object>();
        if (e instanceof MaxUploadSizeExceededException){
            model.put("errors", "文件应不大于 "+
                    getFileKB(((MaxUploadSizeExceededException)e).getMaxUploadSize()));
        } else{
            model.put("errors", "不知错误: " + e.getMessage());
        }
        return new ModelAndView("/fileupload/fileupload", (Map) model);
    }
}
