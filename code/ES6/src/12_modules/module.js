// 1.导出变量或常量
export var color = "red";
export let name = "Nicholas";
export const magicNumber = 7;

// 2.导出函数
export function sum(num1, num2) {
	return num1 + num1;
}

// 3.导出类
export class Rectangle {
	constructor(length, width) {
		this.length = length;
		this.width = width;
	}
}

function multiply(num1, num2) {
	return num1 * num2;
}

// 4.导出已有的函数
export {multiply};
