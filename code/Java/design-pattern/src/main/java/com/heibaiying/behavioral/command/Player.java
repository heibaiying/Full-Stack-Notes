package com.heibaiying.behavioral.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

	private String name;

	public void play() {
		System.out.println(name + "播放");
	}

	public void pause() {
		System.out.println(name + "暂停");
	}

	public void mute() {
		System.out.println(name + "静音");
	}
}
