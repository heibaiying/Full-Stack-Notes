package com.heibaiying.creational.singleton;

/**
 * 线程不安全的懒汉式单例模式
 */
public class LazySingletonUnsafe {

	private static LazySingletonUnsafe instance = null;

	private LazySingletonUnsafe() {
	}

	public static LazySingletonUnsafe getInstance() {
		if (instance == null) {
			instance = new LazySingletonUnsafe();
		}
		return instance;
	}
}
