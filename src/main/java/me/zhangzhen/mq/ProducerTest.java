package me.zhangzhen.mq;

import java.io.IOException;

import org.apache.commons.httpclient.util.TimeoutController.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerTest {

	private static final String EXCHANGE_NAME = "MyFanout1";
	private static final String QUEUE = "test2";

	public static void main(String[] args) throws IOException, TimeoutException, java.util.concurrent.TimeoutException{

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.71.131");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true, false, null);  
     
       // channel.queueDeclare(QUEUE, true,false, false, null); 
        
        String message = getMessage(args);

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
	}
	
	private static String getMessage(String[] strings){
	    if (strings.length < 1)
	    	    return "info: Hello World!!!!!";
	    return joinStrings(strings, " ");
	  }

	  private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	  }
}
