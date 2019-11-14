package com.heibaiying.interrupt;

/**
 * interrupt() 只是设置中断标志位，并不能中断线程
 */
public class J1_Interrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println("子线程打印");
			}
		});
		thread.start();
		Thread.sleep(10);
		thread.interrupt();
	}
}
