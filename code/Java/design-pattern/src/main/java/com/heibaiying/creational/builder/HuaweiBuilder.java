package com.heibaiying.creational.builder;

public class HuaweiBuilder extends Builder {
	@Override
	public void addProcessor() {
		phone.setProcessor("海思麒麟处理器");
	}

	@Override
	public void addCamera() {
		phone.setCamera("莱卡摄像头");
	}

	@Override
	public void addScreen() {
		phone.setScreen("OLED");
	}
}
