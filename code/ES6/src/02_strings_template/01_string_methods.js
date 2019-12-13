let msg = "Hello world!";
console.log(msg.startsWith("Hello")); // true
console.log(msg.endsWith("!")); // true
console.log(msg.includes("o")); // true
console.log(msg.startsWith("o")); // false
console.log(msg.endsWith("world!")); // true
console.log(msg.includes("x")); // false
console.log(msg.startsWith("o", 4)); // true
console.log(msg.endsWith("o", 8)); // true
console.log(msg.includes("o", 8)); // false

console.log("x".repeat(3)); // "xxx"
console.log("hello".repeat(2)); // "hellohello"
console.log("abc".repeat(4)); // "abcabcabcabc"

'x'.padStart(5, 'ab');  // 'ababx'
'x'.padStart(4, 'ab');  // 'abax'

'x'.padEnd(5, 'ab');  // 'xabab'
'x'.padEnd(4, 'ab');  // 'xaba'
'xxx'.padStart(2, 'ab');  // 'xxx'
'xxx'.padEnd(2, 'ab');  // 'xxx'

'abc'.padStart(10, '0123456789'); //'0123456abc'
'x'.padStart(4); // '   x'
'x'.padEnd(4); // 'x   '
