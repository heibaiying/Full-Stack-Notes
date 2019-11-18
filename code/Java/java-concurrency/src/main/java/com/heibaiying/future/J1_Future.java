package com.heibaiying.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class J1_Future {

	static class Task implements Callable<Integer> {

		private int operator;

		Task(Integer operator) {
			this.operator = operator;
		}

		@Override
		public Integer call() throws Exception {
			Thread.sleep(500);
			return operator * 10;
		}
	}

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(20);
		List<Future<Integer>> futureList = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			Future<Integer> submit = executors.submit(new Task(i));
			futureList.add(submit);
		}
		// 获取所有线程的返回值并计算
		Integer reduce = futureList.stream().map(x -> {
			try {
				return x.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return 0;
		}).reduce(0, Integer::sum);
		System.out.println("计算结果为:" + reduce);
		executors.shutdown();
	}
}
