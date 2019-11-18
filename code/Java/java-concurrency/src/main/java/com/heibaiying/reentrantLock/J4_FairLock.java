package com.heibaiying.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 */
public class J4_FairLock {

	// 参数为true,代表使用公平锁
	private static ReentrantLock fairLock = new ReentrantLock(true);

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + "获得锁");
				fairLock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new IncreaseTask());
		Thread thread2 = new Thread(new IncreaseTask());
		Thread thread3 = new Thread(new IncreaseTask());
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
