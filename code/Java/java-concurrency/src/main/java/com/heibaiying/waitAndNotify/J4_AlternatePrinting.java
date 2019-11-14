package com.heibaiying.waitAndNotify;

/**
 * 利用 wait 和 Notify 实现交替打印
 */
public class J4_AlternatePrinting {

	private static final Object object = new Object();
	private volatile static boolean flag = false;
	private static int i = 0;
	private static int threshold = 1000000;

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (object) {
				try {
					while (i <= threshold) {
						if (flag) {
							object.wait();
						} else {
							object.notify();
							System.out.println("Thread 1 : " + i++);
							flag = !flag;
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			synchronized (object) {
				while (i <= threshold) {
					try {
						while (i <= threshold) {
							if (flag) {
								object.notify();
								System.out.println("Thread 2 : " + i++);
								flag = !flag;
							} else {
								object.wait();
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}

