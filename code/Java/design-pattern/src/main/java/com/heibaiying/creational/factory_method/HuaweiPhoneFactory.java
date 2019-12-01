package com.heibaiying.creational.factory_method;

public class HuaweiPhoneFactory implements Factory {

	@Override
	public Phone produce() {
		return new HuaweiPhone();
	}
}
