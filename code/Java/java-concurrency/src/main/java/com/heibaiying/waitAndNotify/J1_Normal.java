package com.heibaiying.waitAndNotify;

/**
 * 正常情况下
 */
public class J1_Normal {

	private static final Object object = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (object) {
				System.out.println("线程1");
			}
		}).start();
		new Thread(() -> {
			synchronized (object) {
				System.out.println("线程2");
			}
		}).start();
	}
}
