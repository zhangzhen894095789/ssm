package me.zhangzhen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCGlobalExceptionResloverController {

	@RequestMapping("/ex1/{num}")
	public String test(@PathVariable("num") int num){
		return "num = " + num / 0;
	}
}
