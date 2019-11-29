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
		int intermediateResult;
		CompletableFuture<Integer> future = new CompletableFuture<>();
		// 启动子线程
		new Thread(new Compute(future)).start();
		System.out.println("启动主线程");
		Thread.sleep(2000);
		System.out.println("主线程计算完成");
		// 假设主线程计算结果为 100
		intermediateResult = 100;
		// 传递主线程的计算结果给子线程
		future.complete(intermediateResult);
	}
}
