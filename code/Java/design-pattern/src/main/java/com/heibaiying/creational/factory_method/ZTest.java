package com.heibaiying.creational.factory_method;

public class ZTest {
	public static void main(String[] args) {
		XiaomiPhoneFactory xiaomiPhoneFactory = new XiaomiPhoneFactory();
		xiaomiPhoneFactory.produce().call("123");
		HuaweiPhoneFactory huaweiPhoneFactory = new HuaweiPhoneFactory();
		huaweiPhoneFactory.produce().call("456");
	}
}
