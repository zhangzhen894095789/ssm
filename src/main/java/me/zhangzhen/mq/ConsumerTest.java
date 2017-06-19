package me.zhangzhen.mq;

import com.rabbitmq.client.*;
public class ConsumerTest {
	private static final String EXCHANGE_NAME = "MyFanout1";
		private static final String QUEUE = "test1";
	
		  public static void main(String[] argv) throws Exception {
			  ConnectionFactory factory = new ConnectionFactory();  
		        factory.setHost("192.168.71.131");  
		        factory.setPort(5672);
		        factory.setUsername("guest");
		        factory.setPassword("guest");
		        Connection connection = factory.newConnection();  
		        Channel channel = connection.createChannel();  
		        
		        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true, false, null);  
		        channel.queueDeclare(QUEUE, true, false, false, null);
		   
		        channel.queueBind(QUEUE, EXCHANGE_NAME, "MyFanout1");  
		        
		        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");  
		  
		        QueueingConsumer consumer = new QueueingConsumer(channel);  
		        // 指定接收者，第二个参数为自动应答，无需手动应答  
		        channel.basicConsume(QUEUE, true, consumer);  
		  
		        while (true)  
		        {  
		            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
		            String message = new String(delivery.getBody()); 
		            //JSONObject j = JSONObject.fromObject(message);
		            //System.out.println(j.getString("borrowNid"));
		            //System.out.println(j.getString("borrowNid"));
		            System.out.println(" [x] Received '" + message + "'");  
		  
		        }  
		  }
}

