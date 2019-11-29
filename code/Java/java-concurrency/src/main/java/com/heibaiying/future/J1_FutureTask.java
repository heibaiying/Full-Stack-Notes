package com.heibaiying.future;

import java.util.concurrent.*;

public class J1_FutureTask {

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws InterruptedException {
			Thread.sleep(3000);
			return 100;
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<Integer> futureTask01 = new FutureTask<>(new Task());
		FutureTask<Integer> futureTask02 = new FutureTask<>(new Task());
		new Thread(futureTask01).start();
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(futureTask02);
		System.out.println("futureTask01 计算结果为：" + futureTask01.get());
		System.out.println("futureTask02 计算结果为：" + futureTask01.get());
		executorService.shutdown();
	}
}
