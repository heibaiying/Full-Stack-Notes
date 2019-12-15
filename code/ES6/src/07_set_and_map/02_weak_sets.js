//1.与Set区别
let set = new WeakSet(),
	key = {};
// 将对象加入 set
set.add(key);
console.log(set.has(key)); // true
key = null;
