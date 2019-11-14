package com.heibaiying.interrupt;

/**
 * 判断当前线程的中断状态，并清除当前线程的中断标志位
 */
public class J3_Interrupted {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			while (!Thread.interrupted() || !Thread.currentThread().isInterrupted()) {
				System.out.println("子线程打印");
			}
		});
		thread.start();
		Thread.sleep(10);
		thread.interrupt();
	}
}
