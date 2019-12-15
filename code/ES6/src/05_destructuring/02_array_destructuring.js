// 1.数组解构
(() => {
	let colors = ["red", "green", "blue"];
	let [firstColor, secondColor] = colors;
	console.log(firstColor); // "red"
	console.log(secondColor); // "green"
})();

(() => {
	let colors = ["red", "green", "blue"];
	let [, , thirdColor] = colors;
	console.log(thirdColor); // "blue
})();

//3.互换值
let a = 1,
	b = 2;
[a, b] = [b, a];
console.log(a); // 2
console.log(b); // 1

// 4.默认值

(() => {
	let [firstColor, secondColor = "green"] = ["red"];
	console.log(firstColor); // "red"
	console.log(secondColor); // "green"
})();

// 5.嵌套解构
(() => {
	let colors = ["red", ["green", "lightgreen"], "blue"];
	let [firstColor, [secondColor]] = colors;
	console.log(firstColor); // "red"
	console.log(secondColor); // "green"
})();


// 6.剩余项解构
(() => {
	let colors = ["red", "green", "blue"];
	let [firstColor, ...restColors] = colors;
	console.log(firstColor); // "red"
	console.log(restColors.length); // 2
	console.log(restColors[0]); // "green"
	console.log(restColors[1]); // "blue"
})();


// 7.在 ES6 中克隆数组
(() => {
	let colors = ["red", "green", "blue"];
	let [...clonedColors] = colors;
	console.log(clonedColors); //"[red,green,blue]"
})();

