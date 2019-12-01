package com.heibaiying.creational.abstract_factory;

public class XiaomiPhoneFactory implements Factory {

	@Override
	public Phone producePhone() {
		return new XiaomiPhone();
	}

	@Override
	public Charger produceCharger() {
		return new XiaomiCharger();
	}
}
