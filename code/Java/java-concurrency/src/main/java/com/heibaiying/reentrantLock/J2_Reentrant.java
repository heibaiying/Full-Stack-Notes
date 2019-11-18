package com.heibaiying.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入性
 */
public class J2_Reentrant {

	private static ReentrantLock reentrantLock = new ReentrantLock();
	private static Integer i = 0;

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			for (int j = 0; j < 100000; j++) {
				try {
					reentrantLock.lock();
					reentrantLock.lock();
					reentrantLock.lock();
					i++;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					reentrantLock.unlock();
					reentrantLock.unlock();
					reentrantLock.unlock();
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
}
