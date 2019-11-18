package com.heibaiying.threadPool;

import java.util.concurrent.*;

public class J4_ExtendedThreadPool {

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

		// 自定义线程
		ExecutorService executorService = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<>()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("线程" + t.getName() + "准备执行");
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("线程" + r + "执行结束");
			}

			@Override
			protected void terminated() {
				System.out.println("线程池退出");
			}
		};

		Task task = new Task();
		for (int i = 0; i < 1000; i++) {
			executorService.submit(task);
		}
		latch.await();
		System.out.println("最后的结果是" + i);
		executorService.shutdown();
	}
}
