package com.heibaiying.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用ThreadLocal来保证线程安全
 */
public class J2_ThreadSafe {

	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
	private static int sum = 1000;
	private static CountDownLatch countDownLatch = new CountDownLatch(sum);
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	static class Task implements Runnable {

		@Override
		public void run() {
			try {
				if (threadLocal.get() == null) {
					threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				}
				Date parse = threadLocal.get().parse("2018-08-08 08:08:08");
				System.out.println(parse);
				atomicInteger.incrementAndGet();
			} catch (ParseException e) {
				e.printStackTrace();
			} finally {
				countDownLatch.countDown();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < sum; i++) {
			executorService.execute(new Task());
		}
		countDownLatch.await();
		System.out.println("格式化成功次数为：" + atomicInteger.get());
		executorService.shutdown();
	}
}
