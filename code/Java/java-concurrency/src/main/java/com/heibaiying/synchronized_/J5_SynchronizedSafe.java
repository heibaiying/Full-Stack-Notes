package com.heibaiying.synchronized_;

public class J5_SynchronizedSafe {

	private static final String s = "";

	private static int i = 0;

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			for (int j = 0; j < 100000; j++) {
				// 锁住的是同一个对象，此时也是线程安全的
				synchronized (s) {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new IncreaseTask());
		Thread thread2 = new Thread(new IncreaseTask());
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(i);
	}
}
