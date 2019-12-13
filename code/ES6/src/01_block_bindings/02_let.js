function test(flag) {
	if (flag) {
		let value = "blue";
		console.log(value);
	} else {
		console.log(value); //value在此处不能访问
	}
	console.log(value);	//value在此处不能访问
}

test(true);
test(false);

