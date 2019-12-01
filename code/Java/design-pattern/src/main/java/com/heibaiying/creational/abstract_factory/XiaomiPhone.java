package com.heibaiying.creational.abstract_factory;

public class XiaomiPhone extends Phone {
	public void call(String phoneNum) {
		System.out.println("小米手机拨打电话：" + phoneNum);
	}

	@Override
	public String toString() {
		return "小米手机";
	}
}
