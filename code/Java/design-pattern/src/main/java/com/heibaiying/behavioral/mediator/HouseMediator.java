package com.heibaiying.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class HouseMediator extends Mediator {

	private List<Person> personList = new ArrayList<>();

	@Override
	public void register(Person person) {
		if (!personList.contains(person)) {
			personList.add(person);
			person.setMediator(this);
		}
	}

	@Override
	public void send(String from, String message) {
		System.out.println(from + "发送消息：" + message);
		for (Person person : personList) {
			String name = person.getName();
			if (!name.equals(from)) {
				person.receive(message);
			}
		}
	}
}

