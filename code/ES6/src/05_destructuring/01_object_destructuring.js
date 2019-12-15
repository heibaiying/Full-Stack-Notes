// 1.对象结构
(() => {
	let person = {
		name: "heibaiying",
		age: 18
	};
	let {name, age} = person;
	console.log(name); // "heibaiying"
	console.log(age); // "18"
})();

//2.传递默认值
(() => {
	let person = {
		name: "heibaiying",
		age: 18
	};
	let {name, age, occupation = "programmer"} = person;
	console.log(occupation); // programmer
})();


//3.改变变量名
(() => {
	let person = {
		name: "heibaiying",
		age: 18
	};
	let {name: myName, age: myAge, occ: occupation = "programmer"} = person;
	console.log(myName);
	console.log(myAge);
	console.log(occupation);
})();

//4.支持嵌套
(() => {
	let person = {
		name: "heibaiying",
		age: 18,
		teacher: {
			name: "heibai"
		}
	};
	let {teacher: {name: teacherName}} = person;
	console.log(teacherName);
})();
