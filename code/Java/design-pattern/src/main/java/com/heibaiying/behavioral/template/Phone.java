package com.heibaiying.behavioral.template;

public abstract class Phone {

	public void assembling() {
		adCamera();
		addBattery();
		if (needAddNFC()) {
			addNFC();
		}
		packaged();
	}

	private void adCamera() {
		System.out.println("组装摄像头");
	}

	private void addBattery() {
		System.out.println("安装电池");
	}

	private void addNFC() {
		System.out.println("增加NFC功能");
	}

	// 钩子方法
	abstract boolean needAddNFC();

	abstract void packaged();
}
