package com.heibaiying.creational.abstract_factory;

public class HuaiweiCharger extends Charger {
	@Override
	public void Charge(Phone phone) {
		System.out.println("华为充电器给" + phone + "充电");
	}
}
