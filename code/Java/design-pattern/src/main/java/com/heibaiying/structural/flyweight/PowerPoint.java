package com.heibaiying.structural.flyweight;

import lombok.ToString;

public abstract class PowerPoint {
	/*版权*/
	private String copyright;
	private String title;

	public PowerPoint(String copyright) {
		this.copyright = copyright;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	abstract void create();

	@Override
	public String toString() {
		return "编号：" + hashCode() + ": PowerPoint{" +
			"copyright='" + copyright + '\'' +
			", title='" + title + '\'' +
			'}';
	}
}
