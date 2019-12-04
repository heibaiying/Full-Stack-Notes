package com.heibaiying.structural.adapter;

public class ChargerAdapter extends PowerSupply implements Target {
	@Override
	public int output5V() {
		int output = output220V();
		System.out.println("充电头适配转换");
		output = output / 44;
		System.out.println("输出电压：" + output);
		return output;
	}
}
