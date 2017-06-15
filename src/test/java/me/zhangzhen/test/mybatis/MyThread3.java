package me.zhangzhen.test.mybatis;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyThread3 implements Runnable {

	public static int count = 0;

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		MyThread3.count = count;
	}

	static String lock = "lock";

	ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	ReentrantLock reentlock = new ReentrantLock();
	@Override
	public void run() {
		// Thread.currentThread().sleep(5000);
		while (true) {
			//java 读写锁
//			synchronized (lock) {
			reentlock.lock();
				if (count == 100) {
					break;
				}
				count = count + 1;
				System.out.println(Thread.currentThread().getName() + "  在执行" + "当前count值" + count);
//			}
				reentlock.unlock();
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
