package me.zhangzhen.mq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("testListener1")
public class TestListener1 implements MessageListener {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	//监听到消息发送给test2队列
	@Override
	public void onMessage(Message message) {

		try {
			//监听并获取到队列的消息
			System.out.println("testListener1启动！！。。。。                             接收到的消息：   " + new String(message.getBody(),"utf-8"));
			//给队列test2发送消息
//			amqpTemplate.convertAndSend( "test2","来自testListener1的消息");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
