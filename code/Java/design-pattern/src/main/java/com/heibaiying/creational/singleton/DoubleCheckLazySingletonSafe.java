package com.heibaiying.creational.singleton;

/**
 * 使用双重检查锁来保证线程安全
 */
public class DoubleCheckLazySingletonSafe {

	private static volatile DoubleCheckLazySingletonSafe instance = null;

	private DoubleCheckLazySingletonSafe() {
	}

	public static DoubleCheckLazySingletonSafe getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckLazySingletonSafe.class) {
				if (instance == null) {
					instance = new DoubleCheckLazySingletonSafe();
				}
			}
		}
		return instance;
	}
}
