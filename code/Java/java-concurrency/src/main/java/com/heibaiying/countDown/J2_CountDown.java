package com.heibaiying.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class J2_CountDown {

	private static int number = 100;
	private static CountDownLatch latch = new CountDownLatch(number);
	private static AtomicInteger integer = new AtomicInteger(0);


	static class IncreaseTask implements Runnable {
		@Override
		public void run() {
			try {
				// 假设这是一个耗时的任务
				Thread.sleep(3000);
				integer.incrementAndGet();
				// 计数减一
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		IncreaseTask task = new IncreaseTask();
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < number; i++) {
			executorService.submit(task);
		}
		latch.await();
		// 会等待所有任务执行完成再输出
		System.out.println("integer：" + integer);
		executorService.shutdown();
	}
}
