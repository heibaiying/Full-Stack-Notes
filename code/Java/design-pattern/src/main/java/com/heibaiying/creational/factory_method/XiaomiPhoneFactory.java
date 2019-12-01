package com.heibaiying.creational.factory_method;

public class XiaomiPhoneFactory implements Factory {

	@Override
	public Phone produce() {
		return new XiaomiPhone();
	}
}
