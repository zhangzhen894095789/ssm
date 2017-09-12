package me.zhangzhen.thread.test.base;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 线程锁
 * @author dell、
 *
 */
public class BaseThreadLock {
	
	 public static final String lock = "";//同步锁，可以自定义
	
	 public static final ReentrantLock reentLock = new ReentrantLock();//互斥锁
	 
	 public static final ReentrantReadWriteLock readAndWriteLock = new ReentrantReadWriteLock();//读写锁
}
