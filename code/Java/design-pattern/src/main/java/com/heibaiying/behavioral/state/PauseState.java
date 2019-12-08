package com.heibaiying.behavioral.state;

public class PauseState extends State {

	@Override
	public void speed() {
		System.out.print("操作失败：暂停状态下不支持加速");
	}
}
