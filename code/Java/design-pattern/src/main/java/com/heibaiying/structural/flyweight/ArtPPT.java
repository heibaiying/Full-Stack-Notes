package com.heibaiying.structural.flyweight;

public class ArtPPT extends PowerPoint {

	public ArtPPT(String copyright) {
		super(copyright);
	}

	@Override
	void create() {
		System.out.println("艺术类PPT模板");
	}
}
