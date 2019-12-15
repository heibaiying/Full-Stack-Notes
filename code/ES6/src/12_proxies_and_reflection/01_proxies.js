let person = {
	name: "heibai",
	idCard: null
};
let proxy = new Proxy(person, {
	set(target, propertyKey, value, receiver) {
		if (propertyKey === "idCard" && value.length !== 18) {
			throw new Error("输入的身份证长度必须为18位");
		}
		// 调用反射进行修改
		return Reflect.set(target, propertyKey, value, receiver);
	},
	get(target, propertyKey, receiver) {
		if (propertyKey === "idCard") {
			throw new Error("身份证是私密信息，无权读取");
		}
		//  调用反射获取值
		return Reflect.get(target, propertyKey, receiver);
	}
});
proxy.name = "ying";
console.log(proxy.name);
proxy.idCard = "123456789123456789";
console.log(proxy.idCard);

