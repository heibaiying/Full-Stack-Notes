let list = ["red", "green", "blue"];
let set = new Set(list);
let map = new Map();
map.set("name", "heibaiying");
map.set("age", "12");

for (let entry of list.entries()) {
	console.log(entry);
}
// [ 0, 'red' ]
// [ 1, 'green' ]
// [ 2, 'blue' ]

for (let entry of set.entries()) {
	console.log(entry);
}
// [ 'red', 'red' ]
// [ 'green', 'green' ]
// [ 'blue', 'blue' ]

for (let entry of map.entries()) {
	console.log(entry);
}

// [ 'name', 'heibaiying' ]
// [ 'age', '12' ]

for (let key of list.keys()) {
	console.log(key);
}
for (let key of set.keys()) {
	console.log(key);
}
for (let key of map.keys()) {
	console.log(key);
}


let colors = ["red", "green", "blue"];
for (let color of colors){
	console.log(color)
}


let message = "abc";
for (let i = 0; i < message.length; i++) {
	console.log(message[i]);
}
// a
// b
// c
