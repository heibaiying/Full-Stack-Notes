package com.heibaiying.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private List<Archive> archives = new ArrayList<>();

	void add(Archive archive) {
		archives.add(archive);
	}

	void remove(Archive archive) {
		archives.remove(archive);
	}

	void accept(Visitor visitor) {
		for (Archive archive : archives) {
			archive.accept(visitor);
		}
	}

}
