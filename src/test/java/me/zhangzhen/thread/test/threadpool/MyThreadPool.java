package me.zhangzhen.thread.test.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
	static int count = 0 ;
	public static void main(String[] args) {
		  ExecutorService executorService = Executors.newFixedThreadPool(5); // 
		  for(int i = 0 ; i < 10 ; i++){
			  executorService.execute(new TestRunnable()); 
          System.out.println("************* a" + (count + 1) + " *************"); 
		  }
	}
}
class TestRunnable implements Runnable { 
    public void run() { 
            System.out.println(Thread.currentThread().getName() + "线程被调用了。"); 
            while (true) { 
                    try { 
                            Thread.sleep(5000); 
                           System.out.println(Thread.currentThread().getName()); 
                    } catch (InterruptedException e) { 
                            e.printStackTrace(); 
                    } 
            } 
    } 
}