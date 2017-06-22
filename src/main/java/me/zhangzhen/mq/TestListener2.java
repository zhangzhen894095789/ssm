package me.zhangzhen.mq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("testListener2")
public class TestListener2 implements MessageListener{
//	@Autowired
//	private AmqpTemplate amqpTemplate;
	//监听到消息发送给test1队列
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			//监听并获取到队列的消息
			System.out.println("testListener2启动。。。。                         接收到的消息：  " + new String(message.getBody(),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//给指定的队列发送消息
//		amqpTemplate.convertAndSend("test1", "来自testListener2的消息");
	}

}
