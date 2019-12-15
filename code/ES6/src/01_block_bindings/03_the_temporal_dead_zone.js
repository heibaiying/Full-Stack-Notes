(function test() {
	console.log(typeof value); // ReferenceError: value is not defined
	let value = "blue";  // 下面的语句都不会被输出
	console.log(value);
})();
