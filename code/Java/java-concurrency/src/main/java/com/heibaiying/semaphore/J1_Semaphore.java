package com.heibaiying.semaphore;

import java.util.concurrent.Semaphore;

public class J1_Semaphore {

	// 限制并发访问的线程的数量为5
	private static Semaphore semaphore = new Semaphore(5);

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getId() + "获得锁!");
				Thread.sleep(5000);
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		IncreaseTask task = new IncreaseTask();
		for (int i = 0; i < 20; i++) {
			new Thread(task).start();
		}
	}
}
