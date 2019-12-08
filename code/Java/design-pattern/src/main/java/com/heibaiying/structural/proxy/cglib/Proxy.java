package com.heibaiying.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy implements MethodInterceptor {

	private Object target;

	public Proxy(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		// 创建用于生成生成动态子类的工具类
		Enhancer enhancer = new Enhancer();
		// 指定动态生成类的父类
		enhancer.setSuperclass(target.getClass());
		// 设置回调
		enhancer.setCallback(this);
		// 动态生成子类
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws InvocationTargetException, IllegalAccessException {
		System.out.println("权限校验");
		Object invoke = method.invoke(target, args);
		System.out.println("资源回收");
		return invoke;
	}
}
