function request(url, timeout = 2000, callback = function() {}) {
	console.log(`url: ${url}, timeout: ${timeout}`);
	callback();
}

request("GitHub"); // url: GitHub, timeout: 2000
request("GitHub", undefined); // url: GitHub, timeout: 2000
request("GitHub", null); // url: GitHub, timeout: null
request("GitHub", 5000);  // url: GitHub, timeout: 5000
request("GitHub", 5000, () => console.log("超时异常"));    // url: GitHub, timeout: 5000
																			   // 超时异常

function test01(first, second = first) {
	console.log(`first: ${first}, second: ${second}`);
}

function test02(first = second, second) {
	console.log(`first: ${first}, second: ${second}`);
}

test01(1,undefined);
test01(1,2);
test02(undefined,2);
test02(1,2);
