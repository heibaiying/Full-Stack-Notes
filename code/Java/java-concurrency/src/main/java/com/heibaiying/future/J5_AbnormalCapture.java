package com.heibaiying.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异常捕获
 */
public class J5_AbnormalCapture {

	private static Integer compute() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int i = 100 / 0;
		return 100;
	}

	private static Integer dealException(Throwable e) {
		e.printStackTrace();
		return 0;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(J5_AbnormalCapture::compute)
			.exceptionally(J5_AbnormalCapture::dealException)
			.thenAccept(System.out::println);
		future.get();
	}
}
