package me.zhangzhen.test.mybatis;

class MyThread implements Runnable {

	public static int count = 0;

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		MyThread.count = count;
	}

	static String lock = "lock";

	@Override
	public void run() {
		// Thread.currentThread().sleep(5000);
		while (true) {
			//同步锁
			synchronized (lock) {
				if (count == 100) {
					break;
				}
				count = count + 1;
				System.out.println(Thread.currentThread().getName() + "  在执行" + "当前count值" + count);
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
