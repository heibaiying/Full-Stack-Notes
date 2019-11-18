package com.heibaiying.synchronized_;

public class J4_SynchronizedSafe {

	private static int i = 0;

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(new IncreaseTask());
		Thread thread2 = new Thread(new IncreaseTask());
		thread1.start();
		thread2.start();
		//等待结束后 才打印返回值
		thread1.join();
		thread2.join();
		//并打印返回值
		System.out.println(i);
	}

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			for (int j = 0; j < 100000; j++) {
				inc();
			}
		}

		// synchronized 作用在静态方法上，锁住的是类对象，此时也是线程安全的
		private static synchronized void inc() {
			i++;
		}
	}
}
