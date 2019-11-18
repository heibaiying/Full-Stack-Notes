package com.heibaiying.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class J3_SupplyAsync {

	private static Integer compute() {
		int i = 0;
		for (int j = 0; j < 100; j++) {
			i = i + j;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("子线程计算完成");
		return i;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(J3_SupplyAsync::compute);
		System.out.println("主线程等待子线程计算完成");
		Integer integer = supplyAsync.get();
		System.out.println("主线程计算完成:" + integer * integer);
	}
}
