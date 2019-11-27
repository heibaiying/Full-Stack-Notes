package com.heibaiying.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的基本使用
 */
public class J1_ThreadPool {

	static class Task implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + "正在执行");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			// 提交任务到线程池
			executorService.submit(new Task());
		}
		// 关闭线程池，此时不再接受新任务，但仍会等待原有的任务执行完成，如果想要立即关闭，则可以使用shutdownNow()
		executorService.shutdown();
	}
}
