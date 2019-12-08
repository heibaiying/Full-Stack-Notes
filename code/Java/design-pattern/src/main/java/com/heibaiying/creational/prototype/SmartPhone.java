package com.heibaiying.creational.prototype;

import lombok.Data;

import java.util.Date;

@Data
public class SmartPhone implements Cloneable {

	private String type;
	private Date productionDate;

	SmartPhone(String type, Date productionDate) {
		this.type = type;
		this.productionDate = productionDate;
	}

	public void call() {
		System.out.println(type + "拨打电话");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SmartPhone smartPhone = (SmartPhone) super.clone();
		// 对引用对象进行拷贝
		smartPhone.productionDate = (Date) smartPhone.productionDate.clone();
		return smartPhone;
	}
}
