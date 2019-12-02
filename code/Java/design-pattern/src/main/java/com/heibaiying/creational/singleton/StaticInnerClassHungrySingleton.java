package com.heibaiying.creational.singleton;

/**
 * 利用静态内部类来实现饿汉式单例
 */
public class StaticInnerClassHungrySingleton {

	private static class InnerClass {
		private static StaticInnerClassHungrySingleton instance = new StaticInnerClassHungrySingleton();
	}

	public static StaticInnerClassHungrySingleton getInstance() {
		return InnerClass.instance;
	}

	private StaticInnerClassHungrySingleton() {
		if (InnerClass.instance != null) {
			throw new RuntimeException("单例模式禁止反射调用");
		}
	}
}
