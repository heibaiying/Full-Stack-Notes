function getPerson(name, age) {
	return {
		name,
		age,
		[Symbol("createTime")]: Date.now()
	}
}

let person = getPerson("heibaiying", 10);
let symbols = Object.getOwnPropertySymbols(person);
person[symbols[0]] = 1000;
console.log(person[symbols[0]]);
