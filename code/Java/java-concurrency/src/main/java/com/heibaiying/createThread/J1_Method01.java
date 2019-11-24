package com.heibaiying.createThread;

public class J1_Method01 {
	public static void main(String[] args) {
		System.out.println("Main线程的ID为：" + Thread.currentThread().getId());
		Thread thread = new Thread(new CustomRunner());
		thread.start();
	}
}

class CustomRunner implements Runnable {
	@Override
	public void run() {
		System.out.println("CustomThread线程的ID为：" + Thread.currentThread().getId());
	}
}
