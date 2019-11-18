package com.heibaiying.countDown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class j1_Normal {

	private static AtomicInteger integer = new AtomicInteger(0);

	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			try {
				// 假设这是一个耗时的任务
				Thread.sleep(3000);
				integer.incrementAndGet();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		IncreaseTask task = new IncreaseTask();
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++) {
			executorService.submit(task);
		}
		// 不会等待所有任务完成就输出，此时通常为0
		System.out.println("integer：" + integer);
		executorService.shutdown();
	}
}
