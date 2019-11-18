package com.heibaiying.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子对象
 */
public class J1_SimpleType {

	private static int i = 0;
	private static AtomicInteger j = new AtomicInteger(0);
	/*使用AtomicReference对普通对象进行封装*/
	private static AtomicReference<Integer> k = new AtomicReference<>(0);

	static class Task implements Runnable {

		private CountDownLatch latch;

		Task(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			i++;
			j.incrementAndGet();
			k.getAndUpdate(x -> x + 1);
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int number = 10000;
		CountDownLatch latch = new CountDownLatch(number);
		Semaphore semaphore = new Semaphore(10);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Task task = new Task(latch);
		for (int i = 0; i < number; i++) {
			semaphore.acquire();
			executorService.execute(task);
			semaphore.release();
		}
		latch.await();
		System.out.println("输出i的值" + i);
		System.out.println("输出j的值" + j.get());
		System.out.println("输出K的值" + k.get());
		executorService.shutdown();
	}
}
