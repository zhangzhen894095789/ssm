package me.zhangzhen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = "/uploadPic")
	public ModelAndView toUpload(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload/FileUpload_pluploadjs");
		return mv;
	}
	
	@RequestMapping(value = "/fileUpload")
	public ModelAndView fileUpload(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload/FileUpload");
		return mv;
	}
}
