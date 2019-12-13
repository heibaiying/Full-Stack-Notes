// 1.模板字面量
let name = "Nicholas",
	message01 = `Hello, ${name}.`;
console.log(message01); // "Hello, Nicholas."

// 2.支持JS表达式
let count = 10,
	price = 0.25,
	message02 = `${count} items cost $${(count * price).toFixed(2)}.`;
console.log(message02); // "10 items cost $2.50."

// 3.多行字符串
let message03 = `Multiline
string`;
console.log(message03);      // Hello,
							 // string

// 4.多行字符串与模板嵌套
let fullName = "Nicholas",
	message04 = `Hello, 
	my name is ${fullName}.`;
console.log(message04); 	// Hello,
							// my name is Nicholas.
