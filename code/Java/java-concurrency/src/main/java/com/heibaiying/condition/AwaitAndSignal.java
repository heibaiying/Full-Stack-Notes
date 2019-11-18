package com.heibaiying.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待与唤醒
 */
public class AwaitAndSignal {

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			try {
				lock.lock();
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + "等待通知...");
				condition.await();
				System.out.println(threadName + "获得锁");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new IncreaseTask());
		thread1.start();
		Thread.sleep(2000);
		lock.lock();
		condition.signal();
		lock.unlock();
	}
}
