package com.heibaiying.threeCharacteristics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性
 */
public class J2_Atomic {

	private static AtomicInteger i = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		IncreaseTask task = new IncreaseTask();
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		thread1.start();
		thread2.start();
		//等待线程结束后 才打印返回值
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
			i.incrementAndGet();
		}
	}
}
