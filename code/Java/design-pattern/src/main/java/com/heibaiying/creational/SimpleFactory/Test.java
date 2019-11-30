package com.heibaiying.creational.SimpleFactory;


public class Test {
	public static void main(String[] args) {
		PhoneFactory phoneFactory = new PhoneFactory();
		phoneFactory.getPhone("xiaomi").call("123");
		phoneFactory.getPhone("huawei").call("321");
		phoneFactory.getPhone(XiaomiPhone.class).call("456");
		phoneFactory.getPhone(HuaweiPhone.class).call("654");
	}
}
