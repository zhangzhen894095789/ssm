package me.zhangzhen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    
    @RequestMapping(value = "/uploadPic.do")
    @ResponseBody
    public String uploadPic(@RequestParam(required=false) MultipartFile pic){
        System.out.println(pic.getOriginalFilename());
        return "success";
    }
    
    @RequestMapping(value = "/test.do",produces = "text/html;charset=UTF-8")//返回中文乱码处理
//    @RequestMapping(value = "/test.do")
    @ResponseBody
    public String test(){
    	return "哈哈哈";
    }
}