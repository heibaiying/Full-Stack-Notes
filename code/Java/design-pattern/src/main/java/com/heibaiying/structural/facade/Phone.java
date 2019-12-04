package com.heibaiying.structural.facade;

import lombok.Data;

@Data
public class Phone {

	private String name;

	public Phone(String name) {
		this.name = name;
	}
}
