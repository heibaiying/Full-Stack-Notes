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
			System.out.println(Thread.currentThread().getName() + "正在执行");
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			executorService.submit(new Task());
		}
		executorService.shutdown();
	}
}
