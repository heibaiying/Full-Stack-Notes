package com.heibaiying.creational.abstract_factory;

public class HuaweiPhone extends Phone {
	public void call(String phoneNum) {
		System.out.println("华为手机拨打电话：" + phoneNum);
	}
	@Override
	public String toString() {
		return "华为手机";
	}
}
