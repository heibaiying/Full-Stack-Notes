package com.heibaiying.creational.builder;

public class XiaomiBuilder extends Builder {
	@Override
	public void addProcessor() {
		phone.setProcessor("高通骁龙处理器");
	}

	@Override
	public void addCamera() {
		phone.setCamera("索尼摄像头");
	}

	@Override
	public void addScreen() {
		phone.setScreen("OLED");
	}
}
