package com.heibaiying.creational.abstract_factory;

public class ZTest {
	public static void main(String[] args) {
		XiaomiPhoneFactory xiaomiPhoneFactory = new XiaomiPhoneFactory();
		xiaomiPhoneFactory.produceCharger().Charge(xiaomiPhoneFactory.producePhone());
		HuaweiPhoneFactory huaweiPhoneFactory = new HuaweiPhoneFactory();
		huaweiPhoneFactory.produceCharger().Charge(huaweiPhoneFactory.producePhone());
	}
}
