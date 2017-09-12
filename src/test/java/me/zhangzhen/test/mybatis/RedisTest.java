package me.zhangzhen.test.mybatis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.zhangzhen.util.DateUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
/**
 * java 连接redis测试
 * @author dell、
 *
 */
public class RedisTest{

	private Jedis jedis = null;
	@Before
	public void connet(){
		try {
			jedis = new Jedis("192.168.71.130");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connect failed!");
		}
		System.out.println("server is runnig  " + jedis.ping());
	}
	
	@Test
	public void testSetKey(){
		System.out.println("开始时所有的key:" + jedis.keys("*"));
		jedis.set("hello", "hello");
		jedis.set("haha", "haha");
		System.out.println("获取指定key的value：" + jedis.get("hello"));
		System.out.println("结束时所有的key:" + jedis.keys("*"));
	}
	
	@Test//设置key的有效时间
	public void setExpireTime() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse("2017-7-17 16:37:00");
		System.out.println(date.getTime());
		Date date2 = new Date(date.getTime());
		System.out.println(date2.toLocaleString());
		long time = date2.getTime();
		
		jedis.set("haha","haha");
		jedis.hset("myhash", "name","jerry");
		jedis.expire("haha", 30);
//		jedis.expire("myhash",30);//有效期设置毫秒值
		jedis.expireAt("myhash",time);//设置有限期时间戳

		
	}
	
	@Test//取消key的有效时间
	public void cancelExpireTime(){
		jedis.persist("haha");
	}
	
	@Test//创建订阅频道，订阅平道
	public void subscir(){
		System.out.println("客户端创建并监听订阅频道");
		String channels = "cheat" ;
		//此方法一直监听订阅频道，直到频道消失，监听结束
		jedis.subscribe(new JedisPubSub() {
			//监听接收到消息
			@Override
			public void onMessage(String channel, String message) {
				// TODO Auto-generated method stub
				super.onMessage(channel, message);
				System.out.println(message);
			}
		}, channels);
	}
	
	@Test//发布消息到指定的订阅频道
	public void sendMessage(){
		jedis.publish("cheat", "发送消息到频道cheat!");
	}
	
	@Test
	public void testHash(){
		jedis.hset("myhash","name", "jack");
		jedis.hset("myhash","gender", "male");
		
		Long hlen = jedis.hlen("myhash");
		
		List<String> hvals = jedis.hvals("myhash");
		System.out.println(hvals);
		System.out.println(hlen);
	}
	
	@Test
	public void testGetHaha(){
		String string = jedis.get("haha");
		String hget = jedis.hget("myhash", "name");
		System.out.println(hget);
		System.out.println(string);
	}
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.71.130");
		Long result = jedis.publish("cheat", "hello redis message !" + new Date().toString());
		
	}
}
