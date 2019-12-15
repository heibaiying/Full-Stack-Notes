class Employee {

	/*构造器*/
	constructor(name, age) {
		this.name = name;
		this.age = age;
	}
	/*实例方法*/
	sayName() {
		console.log("员工：" + this.name);
	}

	/*静态方法*/
	static create(name) {
		return new Employee(name);
	}
}


let employee = new Employee("heibai");
employee.sayName();

class Manager extends Employee {

	/*覆写原有的方法*/
	sayName() {
		console.log("领导：" + this.name);
	}
}

let manager = new Manager("ying");
manager.sayName();

function getBase(flag) {
	if (flag) {
		return Manager;
	} else {
		return Employee;
	}
}

class CEO extends getBase(true) {
}

let ceo = new CEO();
console.log(ceo instanceof Manager);



