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
				System.out.println(threadName + "线程等待通知...");
				condition.await();
				System.out.println(threadName + "线程后续操作");
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
		Thread.sleep(1000);
		System.out.println("主线程开始操作");
		lock.lock();
		System.out.println("主线程唤醒");
		condition.signal();
		lock.unlock();
	}
}
