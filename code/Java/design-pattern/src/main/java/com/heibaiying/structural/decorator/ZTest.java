package com.heibaiying.structural.decorator;

public class ZTest {
	public static void main(String[] args) {
		ShellDecorator decorator = new ShellDecorator(new FilmDecorator(new MiPhone()));
		System.out.println(decorator.getDesc() + " : " + decorator.getPrice());
	}
}
