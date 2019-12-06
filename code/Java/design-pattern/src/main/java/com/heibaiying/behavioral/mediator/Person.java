package com.heibaiying.behavioral.mediator;

import lombok.Data;

@Data
public class Person {

	private String name;
	private Mediator mediator;

	public Person(String name) {
		this.name = name;
	}

	public void send(String message) {
		mediator.send(this.name, message);
	}

	public void receive(String message) {
		System.out.println(name + "收到消息：" + message);
	}
}
