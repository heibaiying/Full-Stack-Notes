let mySymbol = Symbol();

// 第一种写法
let a1 = {};
a1[mySymbol] = 'Hello!';

// 第二种写法
let a2 = {
	[mySymbol]: 'Hello!'
};

// 第三种写法
let a3 = {};
Object.defineProperty(a3, mySymbol, {value: 'Hello!'});

// 错误的写法
let a4 = {};
a4.mySymbol = "hello!";


console.log(a1[mySymbol]);  // "Hello!"
console.log(a2[mySymbol]);  // "Hello!"
console.log(a3[mySymbol]);  // "Hello!"
console.log(a4[mySymbol]);  // "undefined"

let symbol01 = Symbol();
let symbol02 = Symbol();
console.log(symbol01 === symbol02);
let symbol03 = Symbol("name");
let symbol04 = Symbol("name");
console.log(symbol03 === symbol04);

let symbol05 = Symbol.for("age");
let symbol06 = Symbol.for("age");
console.log(symbol05 === symbol06);  //true
console.log(symbol05);  // Symbol(age)


