package com.heibaiying.creational.singleton;

public class ZTest {
	public static void main(String[] args) {
		HungrySingleton hungrySingleton = HungrySingleton.getInstance();
		StaticInnerClassHungrySingleton staticInnerClassHungrySingleton = StaticInnerClassHungrySingleton.getInstance();
		DoubleCheckLazySingletonSafe doubleCheckLazySingletonSafe = DoubleCheckLazySingletonSafe.getInstance();
		EnumInstance instance = EnumInstance.getInstance();
	}
}
