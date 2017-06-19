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

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
		try {
			//监听并获取到队列的消息
			System.out.println("testListener1启动！！。。。。                             接收到的消息：   " + new String(message.getBody(),"utf-8"));
			MessageProperties messageProperties = new MessageProperties();
			messageProperties.setConsumerQueue("test2");
			//给队列test2发送消息
			Message message2 = new Message("testListener2发送来的消息！".getBytes(), messageProperties);
			amqpTemplate.convertAndSend( message2);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
