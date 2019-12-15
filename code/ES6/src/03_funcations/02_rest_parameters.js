function each(...elements) {
	elements.forEach((element) => console.log(element));
}

let list = [1, 2, 3, 4, 5];
each(list);
each(...list);
