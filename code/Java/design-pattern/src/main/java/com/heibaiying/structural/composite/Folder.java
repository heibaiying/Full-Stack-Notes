package com.heibaiying.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {

	private List<Component> componentList = new ArrayList<>();

	public Folder(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		componentList.add(component);
	}

	@Override
	public void remove(Component component) {
		componentList.remove(component);
	}

	@Override
	public void print() {
		System.out.println(getName());
		componentList.forEach(x -> System.out.println("	" + x.getName()));
	}
}
