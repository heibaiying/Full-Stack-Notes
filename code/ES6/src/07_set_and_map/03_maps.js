// 1.基本使用
let map01 = new Map();
map01.set("name", "Nicholas");
map01.set("age", 25);
map01.delete("name");
map01.clear();

// 2.由数组初始化map
let map02 = new Map([["name", "Nicholas"], ["age", 25]]);
console.log(map02.get("name")); // "Nicholas"
console.log(map02.get("age")); // 25
console.log(map02.size); // 2

// 3.进行遍历
let map03 = new Map([["name", "Nicholas"], ["age", 25]]);
map03.forEach(function (value, key, ownerMap) {
	console.log(key + " " + value);
	console.log(ownerMap === map03);
});
