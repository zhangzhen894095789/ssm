package me.zhangzhen.test.mybatis;

import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class JavaLockTest {

	volatile int a;// 保证线程内存中的值是从主内存中拿到的最新的，如果线程同时都读取最新的修改后放回住内存还是会出现并发修改错误
	// ReentrantLock reentrantLock = new ReentrantLock();//互斥锁
	// ReadWriteLock readWriteLock = new ReentrantReadWriteLock();//读写锁

	@Test
	public void test() {

	}


	@Test
	public void testss() {
		// 同时启动1000个 	线程，去进行i++计算，看看实际结果
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
	}

	
	// }
	
	public static void main(String[] args) {
//		MyThread myThread = new MyThread();//同步锁测试
//		MyThread2 myThread = new MyThread2();//读写锁测试
//		MyThread3 myThread = new MyThread3();//互斥锁测试
		MyThread4 myThread = new MyThread4();
		myThread.setCount(10);
		new Thread(myThread).start();
		new Thread(myThread).start();
		new Thread(myThread).start();
		System.out.println(myThread.getCount());
	}
}
