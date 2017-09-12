package me.zhangzhen.thread.test.demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.jdbc.pool.MultiLockFairBlockingQueue;
import org.junit.Test;

public class MyThreadPool {
	
	public static void main(String args[]){
		BlockingQueue<Runnable> workQueue = new MultiLockFairBlockingQueue<>();
		long keepAliveTime = 60000;
		int maximumPoolSize = 20;
		int corePoolSize = 5;
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize , maximumPoolSize, keepAliveTime, TimeUnit.HOURS, workQueue);
		
		threadPoolExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("创建线程池");
			}
		});
	}
}
