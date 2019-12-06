package com.heibaiying.behavioral.mediator;

abstract class Mediator {

	public abstract void register(Person person);

	public abstract void send(String from, String message);
}
