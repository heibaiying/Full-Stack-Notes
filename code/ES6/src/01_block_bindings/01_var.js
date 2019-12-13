function test(flag) {
	if (flag) {
		var value = "blue";
		console.log(value);
	} else {
		console.log(value);
	}
	console.log(value);
}

test(true);
test(false);

