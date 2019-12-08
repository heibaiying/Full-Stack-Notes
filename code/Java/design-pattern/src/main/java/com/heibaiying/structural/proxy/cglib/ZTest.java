package com.heibaiying.structural.proxy.cglib;

public class ZTest {
	public static void main(String[] args) {
		Proxy proxy = new Proxy(new ComputeService());
		ComputeService service = (ComputeService) proxy.getProxyInstance();
		service.compute();
	}
}
