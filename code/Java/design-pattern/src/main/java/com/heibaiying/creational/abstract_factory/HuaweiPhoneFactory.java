package com.heibaiying.creational.abstract_factory;

public class HuaweiPhoneFactory implements Factory {

	@Override
	public Phone producePhone() {
		return new HuaweiPhone();
	}

	@Override
	public Charger produceCharger() {
		return new HuaiweiCharger();
	}
}
