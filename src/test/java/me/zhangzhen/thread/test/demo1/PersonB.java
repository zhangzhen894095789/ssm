package me.zhangzhen.thread.test.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import me.zhangzhen.thread.test.base.BaseThreadLock;

public class PersonB extends BaseThreadLock implements Runnable {
	// 创建银行对象
	Bank bank;

	// 通过构造器传入银行对象，确保两个人进入的是一个银行
	public PersonB(Bank bank) {
		this.bank = bank;
	}

	// 重写run方法，在里面实现使用柜台取钱
	@Override
	public void run() {
		reentLock.lock();//使用互斥锁
		while (Bank.money >= 200) {
//				 readAndWriteLock.writeLock().lock();// 写锁
//				readAndWriteLock.readLock().lock();//读锁
			try {
				// synchronized (lock) {//使用同步锁
				bank.ATM(200);// 每次取200块
				// }
				
//				 readAndWriteLock.writeLock().unlock();// 写锁
//				readAndWriteLock.readLock().lock();//读锁
//				Thread.currentThread().sleep(1000);// 取完休息0.1秒
//			} catch (InterruptedException e) {
//				e.printStackTrace();
			}finally{
				 reentLock.unlock();//互斥锁
			}
		}

	}
}