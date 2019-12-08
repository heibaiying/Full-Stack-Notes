package com.heibaiying.structural.proxy.static_proxy;

public class ZTest {
	public static void main(String[] args) {
		ProxyService proxyService = new ProxyService(new ComputeService());
		proxyService.compute();
	}
}
