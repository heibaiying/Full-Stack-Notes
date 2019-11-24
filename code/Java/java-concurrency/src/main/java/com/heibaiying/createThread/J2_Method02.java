package com.heibaiying.createThread;

public class J2_Method02 {
	public static void main(String[] args) {
		System.out.println("Main线程的ID为：" + Thread.currentThread().getId());
		CustomThread customThread = new CustomThread();
		customThread.start();
	}
}

class CustomThread extends Thread {
	@Override
	public void run() {
		System.out.println("CustomThread线程的ID为：" + Thread.currentThread().getId());
	}
}
