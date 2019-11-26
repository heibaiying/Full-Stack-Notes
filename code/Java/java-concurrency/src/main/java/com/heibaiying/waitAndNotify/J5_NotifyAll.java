package com.heibaiying.waitAndNotify;

/**
 * 全部唤醒
 */
public class J5_NotifyAll {

	private static final Object object = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (object) {
				try {
					System.out.println("对象object在线程1等待");
					object.wait();
					System.out.println("线程1后续操作");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			synchronized (object) {
				try {
					System.out.println("对象object在线程2等待");
					object.wait();
					System.out.println("线程2后续操作");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			synchronized (object) {
				System.out.println("线程3开始操作");
				System.out.println("对象object唤醒");
				// 如果是object.notify()则是随机唤醒任意一个等待
				object.notifyAll();
			}
		}).start();
	}
}

