// 1. Set 不会使用强制类型转换来判断值是否重复
let set01 = new Set([1, 2, 3, 4, 5, 5, 5, 5]);
set01.add("5");
set01.has("5");
set01.delete("5");
set01.clear();

let set02 = new Set(),
	key1 = {},
	key2 = {};
set02.add(key1);
set02.add(key2);
console.log(set02.size); // 2

//4.值的遍历
let set03 = new Set(["hei", "bai", "ying"]);
set03.forEach(function (value, key, ownerSet) {
	console.log(key + " " + value);
	console.log(ownerSet === set03);
});

// hei hei
// true
// bai bai
// true
// ying ying
// true

//5. 在 foreach 中绑定作用域 两种方式
let Set04 = new Set([1, 2]);
let processor01 = {
	output(value) {
		console.log(value);
	},
	process(dataSet) {
		dataSet.forEach(function (value) {
			this.output(value);
		}, this);
		//如果想在回调函数中使用 this ，你可以给 forEach() 传入一个 this值作为第二个参数
	}
};
processor01.process(Set04);

//使用箭头函数绑定
let set05 = new Set([1, 2]);
let processor = {
	output(value) {
		console.log(value);
	},
	process(dataSet) {
		dataSet.forEach((value) => this.output(value));
	}
};
processor.process(set05);

//6. 箭头函数转换为数组
let set06 = new Set([1, 2, 3, 3, 3, 4, 5]),
	array = [...set06];
console.log(array); // [1,2,3,4,5]

// 7.对垃圾回收的影响
let set07 = new Set(),
	item = {name: "heibaiying"};
set07.add(item);
item = null;
// 将item置为null,其之前所指向的对象 {name: "heibaiying"}仍然不会被垃圾回收，因为其被Set所持有
console.log([...set07][0]); //{ name: 'heibaiying' }
