package me.zhangzhen.thread.test.threadpool;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import me.zhangzhen.test.mybatis.BaseTest;

public class TestSpringThreadPool extends BaseTest{
	
	@Autowired
	static ThreadPoolTaskExecutor threadPool;
	@Test
	public void test(){
		
		int activeCount = threadPool.getCorePoolSize();
		Runnable task  = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					System.out.println("执行业务逻辑");
				}
			}
		};
		threadPool.execute(task);
		System.err.println(activeCount);
	}
}
