package com.heibaiying.synchronized_;

public class J3_SynchronizedSafe {

	private static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		// 两个线程调用的是同一个IncreaseTask实例，此时是线程安全的
		IncreaseTask task = new IncreaseTask();
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
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

		private synchronized void inc() {
			i++;
		}
	}
}
