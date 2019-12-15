let doNothing01 = () => {
};
// 等效箭头表达式：
let doNothing02 = function () {
};

let reflect01 = value => value;
//  等效箭头表达式：
let reflect02 = function (value) {
	return value;
};


let sum01 = (num1, num2) => num1 + num2;
//  等效箭头表达式：
let sum02 = function (num1, num2) {
	return num1 + num2;
};

let getDetail01 = id => ({id: id, name: "heibaiying"});
// 等效箭头表达式：
let getDetail02 = function (id) {
	return {
		id: id,
		name: "heibaiying"
	};
};

function test() {
	return () => arguments[0]; // 箭头函数能访问包含它的函数的 arguments
}

let arrowFunction = test("hello");
console.log(arrowFunction()); // hello
