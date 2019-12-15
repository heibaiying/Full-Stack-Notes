function* createIterator(items) {
	for (let i = 0; i < items.length; i++) {
		yield items[i];
	}
}

let iterator = createIterator([1, 2, 3]);
console.log(iterator.next()); // { value: 1, done: false }
console.log(iterator.next()); // { value: 2, done: false }
console.log(iterator.next()); // { value: 3, done: false }
console.log(iterator.next()); // { value: undefined, done: true }


function * getIterator() {
	yield 1;
	yield 2;
	yield 3;
}
// 生成器能像正规函数那样被调用，但会返回一个迭代器
let iterator1 = getIterator();
console.log(iterator1.next().value); // 1
console.log(iterator1.next().value); // 2
console.log(iterator1.next().value); // 3
