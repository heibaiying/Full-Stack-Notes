package com.heibaiying.structural.proxy.dynamic_proxy;

import java.lang.reflect.Proxy;

public class ZTest {
	public static void main(String[] args) {
		ComputeService target = new ComputeService();
		IService proxyInstance = (IService) Proxy.newProxyInstance(
			target.getClass().getClassLoader(),
			target.getClass().getInterfaces(),
			(proxy, method, args1) -> {
				System.out.println("权限校验");
				Object invoke = method.invoke(target, args1);
				System.out.println("资源回收");
				return invoke;
			});
		proxyInstance.compute();
	}
}
