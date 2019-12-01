package com.heibaiying.creational.builder;

public class ZTest {
	public static void main(String[] args) {
		Phone huawei = new Manager(new HuaweiBuilder()).buy();
		System.out.println(huawei);
		Phone xiaomi = new Manager(new XiaomiBuilder()).buy();
		System.out.println(xiaomi);
	}
}
