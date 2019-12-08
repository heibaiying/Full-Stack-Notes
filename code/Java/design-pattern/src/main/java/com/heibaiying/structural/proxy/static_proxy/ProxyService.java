package com.heibaiying.structural.proxy.static_proxy;

public class ProxyService implements IService {

	private IService target;

	public ProxyService(IService target) {
		this.target = target;
	}

	@Override
	public void compute() {
		System.out.println("权限校验");
		target.compute();
		System.out.println("资源回收");
	}
}
