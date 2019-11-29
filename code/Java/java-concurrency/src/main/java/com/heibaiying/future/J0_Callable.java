package com.heibaiying.future;

import java.util.concurrent.*;

public class J0_Callable {

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws InterruptedException {
			Thread.sleep(3000);
			return 100;
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executors = Executors.newSingleThreadExecutor();
		Future<Integer> future = executors.submit(new Task());
		System.out.println("计算结果为:" + future.get());
		executors.shutdown();
	}
}
