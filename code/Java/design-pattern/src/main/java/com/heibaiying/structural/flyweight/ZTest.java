package com.heibaiying.structural.flyweight;

public class ZTest {
	public static void main(String[] args) {
		PPTFactory pptFactory = new PPTFactory();
		PowerPoint ppt01 = pptFactory.getPPT(BusinessPPT.class);
		ppt01.setTitle("第一季度工作汇报");
		System.out.println(ppt01);
		PowerPoint ppt02 = pptFactory.getPPT(BusinessPPT.class);
		ppt02.setTitle("第二季度工作汇报");
		System.out.println(ppt02);
		PowerPoint ppt03 = pptFactory.getPPT(SciencePPT.class);
		ppt03.setTitle("科技展汇报");
		System.out.println(ppt03);
	}
}
