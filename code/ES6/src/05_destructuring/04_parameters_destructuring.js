// 1.参数解构
function setCookie01(name, value, {secure, path, domain, expires} = {}) {
	console.log(`secure: ${secure}, path: ${path}, domain:${domain}, expires:${expires}`)
}

setCookie01("type", "js", {
	secure: true,
	expires: 60000
});

// 2.参数解构默认值
function setCookie02(name, value,
					 {
						 secure = false,
						 path = "/",
						 domain = "example.com",
						 expires = new Date(Date.now() + 360000000)
					 } = {}
) {
}
