package com.heibaiying.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 流式调用
 */
public class J4_StreamingCall {

	private static Integer compute() {
		System.out.println("compute所在线程：" + Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 100;
	}

	private static Integer multi(Integer integer) {
		try {
			System.out.println("multi所在线程：" + Thread.currentThread().getId());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return integer * integer;
	}

	private static void accept(Integer integer) {
		System.out.println("accept所在线程：" + Thread.currentThread().getId());
		System.out.println("accept方法消费掉计算结果:" + integer);
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(J4_StreamingCall::compute)
			.thenApply(J4_StreamingCall::multi)
			.thenAccept(J4_StreamingCall::accept)   //值在这一步被消费掉了
			.thenAccept(x -> System.out.println("运算结果:" + x));
		future.get(); //类似于流式计算的惰性求值，如果缺少这一步，不会有任何输出
	}
}
