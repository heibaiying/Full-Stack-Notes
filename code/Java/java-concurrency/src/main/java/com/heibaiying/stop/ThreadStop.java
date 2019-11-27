package com.heibaiying.stop;

/**
 * 线程终止
 */
public class ThreadStop {

	private static volatile boolean stopFlag = true;

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			while (stopFlag) {
				try {
					Thread.sleep(100);
					System.out.println("持续输出");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		Thread.sleep(3 * 1000);
		stopFlag = false;
		System.out.println("线程终止");
	}
}
