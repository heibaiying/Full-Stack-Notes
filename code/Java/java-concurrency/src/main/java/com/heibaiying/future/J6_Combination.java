package com.heibaiying.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 利用 thenCompose 和 thenCombineAsync 组合多个 CompletableFuture
 */
public class J6_Combination {

	private static Integer compute() {
		System.out.println("compute 所在线程：" + Thread.currentThread().getId());
		return 100;
	}

	private static Integer multi(Integer integer) {
		System.out.println("epr 所在线程：" + Thread.currentThread().getId());
		return integer * integer;
	}


	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 组合实现方式1 thenCompose 一个计算的输入依赖另外一个计算的结果
		CompletableFuture<Void> future01 = CompletableFuture.supplyAsync(J6_Combination::compute)
			.thenCompose(x -> CompletableFuture.supplyAsync(() -> multi(x)))
			.thenAccept(x -> System.out.println("运算结果:" + x));
		future01.get();

		System.out.println();

		// 组合实现方式2 thenCombineAsync 两个计算之间不依赖
		CompletableFuture<Integer> future02 = CompletableFuture.supplyAsync(J6_Combination::compute);
		CompletableFuture<Integer> future03 = CompletableFuture.supplyAsync(() -> J6_Combination.multi(100));
		CompletableFuture<Integer> futureAll = future02.thenCombineAsync(future03, (x, y) -> x + y);
		System.out.println("运算结果:" + futureAll.get());

	}
}
