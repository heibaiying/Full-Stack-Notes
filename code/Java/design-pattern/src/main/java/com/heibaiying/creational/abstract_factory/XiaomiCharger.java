package com.heibaiying.creational.abstract_factory;

public class XiaomiCharger extends Charger {
	@Override
	public void Charge(Phone phone) {
		System.out.println("小米充电器给" + phone + "充电");
	}
}
