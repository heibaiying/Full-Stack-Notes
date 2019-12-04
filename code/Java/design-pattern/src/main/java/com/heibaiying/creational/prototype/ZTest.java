package com.heibaiying.creational.prototype;

import java.util.Date;

public class ZTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Phone phone = new Phone("3G手机");
		Phone clonePhone = (Phone) phone.clone();
		clonePhone.call();

		SmartPhone smartPhone = new SmartPhone("4G手机", new Date());
		SmartPhone cloneSmartPhone = (SmartPhone) smartPhone.clone();
		System.out.println(smartPhone == cloneSmartPhone);
		System.out.println(smartPhone.getProductionDate() == cloneSmartPhone.getProductionDate());
	}
}
