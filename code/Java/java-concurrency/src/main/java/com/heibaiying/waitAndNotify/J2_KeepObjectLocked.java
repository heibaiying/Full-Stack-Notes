package com.heibaiying.waitAndNotify;

/**
 * 锁住对象不释放
 */
public class J2_KeepObjectLocked {

	private static final Object object = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (object) {
				while (true) {
					try {
						Thread.sleep(1000);
						System.out.println("线程1");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(() -> {
			synchronized (object) {
				System.out.println("线程2");
			}
		}).start();
	}
}
