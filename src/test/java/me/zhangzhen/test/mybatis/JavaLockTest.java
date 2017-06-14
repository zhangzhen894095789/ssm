package me.zhangzhen.test.mybatis;

import java.util.Iterator;

public class JavaLockTest {

	
    volatile int a ;//保证线程内存中的值是从主内存中拿到的最新的，如果线程同时都读取最新的修改后放回住内存还是会出现并发修改错误
//  ReentrantLock reentrantLock = new ReentrantLock();//互斥锁
//  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();//读写锁
    public void test(){}
    
    public static void main(String[] args) {
		String [] aa =new String[]{"1,50102,3", "1,50009,2", "1,3,6", "3,0,15000"};
		int [] [] result = new int [aa.length][aa.length];
		for(int i = 0 ; i < aa.length ;i++){
			String[] bb = aa[i].split(",");
			int [] ii = new int [bb.length];  
			//转换成int数组
			for (int j = 0; j < bb.length; j++) {
				ii[j] = Integer.parseInt(bb[j]);
			}
//			;
		}
		
	}
}
