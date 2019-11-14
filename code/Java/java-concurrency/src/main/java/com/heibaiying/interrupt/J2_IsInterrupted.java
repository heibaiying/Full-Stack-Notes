package com.heibaiying.interrupt;

/**
 * isInterrupted() 用于检查当前线程是否存在中断标志位
 */
public class J2_IsInterrupted {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("子线程打印");
			}
		});
		thread.start();
		Thread.sleep(10);
		thread.interrupt();
	}
}
