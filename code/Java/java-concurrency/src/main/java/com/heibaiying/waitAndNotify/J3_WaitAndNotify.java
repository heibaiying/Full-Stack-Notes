package com.heibaiying.waitAndNotify;

/**
 * 等待与唤醒
 */
public class J3_WaitAndNotify {

	private static final Object object = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (object) {
				try {
					System.out.println("对象object等待");
					object.wait();
					System.out.println("线程1后续操作");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			synchronized (object) {
				System.out.println("线程2开始操作");
				System.out.println("对象object唤醒");
				object.notify();
			}
		}).start();
	}
}

