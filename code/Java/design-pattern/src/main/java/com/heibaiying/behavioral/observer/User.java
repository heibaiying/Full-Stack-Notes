package com.heibaiying.behavioral.observer;

import lombok.Data;

@Data
public class User implements Observer {

	private String name;

	public User(String name) {
		this.name = name;
	}

	@Override
	public void receive(String message) {
		System.out.println(getName() + "收到消息：" + message);
	}
}
