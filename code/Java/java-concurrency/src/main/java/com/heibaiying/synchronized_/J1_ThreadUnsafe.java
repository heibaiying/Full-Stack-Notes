package com.heibaiying.synchronized_;

/**
 * 线程不安全
 */
public class J1_ThreadUnsafe {

	private static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new IncreaseTask());
		Thread thread2 = new Thread(new IncreaseTask());
		thread1.start();
		thread2.start();
		// 等待线程结束再打印返回值
		thread1.join();
		thread2.join();
		System.out.println(i);
	}

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			for (int j = 0; j < 100000; j++) {
				inc();
			}
		}

		private void inc() {
			i++;
		}
	}
}
