package com.heibaiying.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 每五个人完成任务后,则算一个小组已完成
 */
public class J1_CyclicBarrier {

	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("五人小组任务执行完成"));

	static class Task implements Runnable {
		@Override
		public void run() {
			try {
				long l = new Double(Math.random() * 5000).longValue();
				Thread.sleep(l);
				System.out.println("任务" + Thread.currentThread().getId() + "执行完成");
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int j = 0; j < 10; j++) {
			executorService.submit(new Task());
		}
		executorService.shutdown();
	}
}
