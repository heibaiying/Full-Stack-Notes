package com.heibaiying.yieldAndJoin;

/**
 * 正常情况下，输出 0
 */
public class J1_Normal {

	private static int j = 0;

	public static void main(String[] args)  {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				j++;
			}
		});
		thread.start();
		System.out.println(j);
	}
}
