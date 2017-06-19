package me.zhangzhen.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MqController {

	@Autowired
	private AmqpTemplate amqpTemplate;
	@RequestMapping("/sendMsg/{msg}")
	public String send(@PathVariable("msg")String msg){
		String result = "";
		amqpTemplate.convertAndSend("hahaha");
		return result;
	}
}
