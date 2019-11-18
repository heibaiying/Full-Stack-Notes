package com.heibaiying.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class J2_CompletableFuture {

	static class Compute implements Runnable {

		private CompletableFuture<Integer> future;

		Compute(CompletableFuture<Integer> future) {
			this.future = future;
		}

		@Override
		public void run() {
			try {
				System.out.println("子线程等待主线程运算完成····");
				Integer integer = future.get();
				System.out.println("子线程完成后续运算:" + integer * integer);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		System.out.println("主线程开始计算");
		new Thread(new Compute(future)).start();
		int i = 0;
		for (int j = 0; j < 100; j++) {
			i = i + j;
		}
		Thread.sleep(2000);
		System.out.println("主线程计算完成");
		future.complete(i);
	}
}
