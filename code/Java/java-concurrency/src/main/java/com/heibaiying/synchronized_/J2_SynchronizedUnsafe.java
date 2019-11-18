package com.heibaiying.synchronized_;

public class J2_SynchronizedUnsafe {

	private static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		// 两个线程分别调用不同的IncreaseTask实例
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

		/**
		 * 两个线程启动的不是同一个IncreaseTask实例,
		 * 所以两个线程锁住的不是同一个方法对象，此时也是线程不安全的
		 */
		private synchronized void inc() {
			i++;
		}
	}
}
