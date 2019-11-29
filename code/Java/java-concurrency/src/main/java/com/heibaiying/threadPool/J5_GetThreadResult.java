package com.heibaiying.threadPool;

import java.util.concurrent.*;

public class J5_GetThreadResult {

	static class CustomThread implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return "线程返回结果";
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> submit = executorService.submit(new CustomThread());
		String result = submit.get();
		System.out.println(result);
		executorService.shutdown();
	}
}
