let node = {
	type: "Identifier",
	name: "foo",
	loc: {
		start: {
			line: 1,
			column: 1
		},
		end: {
			line: 1,
			column: 4
		}
	},
	range: [0, 3]
};
let {
	loc: {start},
	range: [startIndex]
} = node;
console.log(start.line); // 1
console.log(start.column); // 1
console.log(startIndex); // 0
