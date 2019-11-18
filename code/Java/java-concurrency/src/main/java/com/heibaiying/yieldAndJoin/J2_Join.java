package com.heibaiying.yieldAndJoin;

/**
 * 使用Join让线程的并行执行换成串行执行，输出：100000
 */
public class J2_Join {

	private static int j = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				j++;
			}
		});
		thread.start();
		thread.join();
		System.out.println(j);
	}
}
