package com.heibaiying.behavioral.state;

public class CloseState extends State {

	@Override
	public void pause() {
		System.out.println("操作失败：视频已处于关闭状态，无需暂停");
	}

	@Override
	public void speed() {
		System.out.println("操作失败：视频已处于关闭状态，无法加速");
	}
}
