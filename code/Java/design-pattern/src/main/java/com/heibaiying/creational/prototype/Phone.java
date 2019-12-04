package com.heibaiying.creational.prototype;

import lombok.Data;

@Data
public class Phone implements Cloneable {

	private String type;

	Phone(String type) {
		System.out.println("构造器被调用");
		this.type = type;
	}

	public void call() {
		System.out.println(type + "拨打电话");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("克隆方法被调用");
		return super.clone();
	}
}
