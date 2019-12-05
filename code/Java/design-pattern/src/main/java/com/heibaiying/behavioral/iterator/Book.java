package com.heibaiying.behavioral.iterator;

import lombok.Data;

@Data
public class Book {
	private String name;

	public Book(String name) {
		this.name = name;
	}

}
