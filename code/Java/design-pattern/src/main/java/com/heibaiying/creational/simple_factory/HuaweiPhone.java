package com.heibaiying.creational.simple_factory;

public class HuaweiPhone extends Phone {
	public void call(String phoneNum) {
		System.out.println("华为手机拨打电话：" + phoneNum);
	}
}
