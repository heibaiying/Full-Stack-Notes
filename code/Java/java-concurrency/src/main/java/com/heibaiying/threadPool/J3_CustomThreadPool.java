package com.heibaiying.threadPool;

import java.util.concurrent.*;

public class J3_CustomThreadPool {

	private static int i = 0;
	private static CountDownLatch latch = new CountDownLatch(1000);

	static class Task implements Runnable {

		@Override
		public void run() {
			increase();
		}

		private void increase() {
			synchronized (this) {
				i++;
			}
			System.out.println(Thread.currentThread().getName() + "输出:" + i);
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// 自定义线程池
		ExecutorService executorService = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<>(),
			r -> {
				Thread thread = new Thread(r);
				thread.setDaemon(true);
				System.out.println("create" + thread.getName());
				return thread;
			});

		Task task = new Task();
		for (int i = 0; i < 1000; i++) {
			executorService.submit(task);
		}
		latch.await();
		System.out.println("最后的结果是" + i);
		executorService.shutdown();
	}
}
