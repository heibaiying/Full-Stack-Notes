function createIterator(items) {
	let i = 0;
	return {
		hasNext() {
			return i < items.length;
		},
		next() {
			return i < items.length ? items[i++] : undefined;
		},
	};
}

let iterator = createIterator([1, 2, 3, 4, 5]);
while (iterator.hasNext()) {
	console.log(iterator.next());
}
