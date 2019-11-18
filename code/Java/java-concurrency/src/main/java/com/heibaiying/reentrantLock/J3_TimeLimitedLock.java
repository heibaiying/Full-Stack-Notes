package com.heibaiying.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class J3_TimeLimitedLock {

	private static ReentrantLock reentrantLock = new ReentrantLock();

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {

			try {
				String threadName = Thread.currentThread().getName();
				// 指定锁定时间
				if (reentrantLock.tryLock(5, TimeUnit.SECONDS)) {
					System.out.println(threadName + "被执行");
					Thread.sleep(6000);
				} else {
					System.out.println(threadName + "获得锁失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				reentrantLock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		Thread thread01 = new Thread(new IncreaseTask());
		thread01.setName("线程1");
		thread01.start();
		Thread thread02 = new Thread(new IncreaseTask());
		thread02.setName("线程2");
		thread02.start();
	}
}
