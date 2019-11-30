package com.heibaiying.creational.SimpleFactory;


public class PhoneFactory {

	public Phone getPhone(String type) {
		if ("xiaomi".equalsIgnoreCase(type)) {
			return new XiaomiPhone();
		} else if ("huawei".equalsIgnoreCase(type)) {
			return new HuaweiPhone();
		}
		return null;
	}

	public Phone getPhone(Class<? extends Phone> phoneClass) {
		try {
			return (Phone) Class.forName(phoneClass.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}


}
