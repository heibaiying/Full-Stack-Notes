package com.heibaiying.structural.composite;

public class File extends Component {

	private String content;

	public File(String name) {
		super(name);
	}

	@Override
	public void vim(String content) {
		this.content = content;
	}

	@Override
	public void cat() {
		System.out.println(content);
	}

	@Override
	public void print() {
		System.out.println(getName());
	}
}
