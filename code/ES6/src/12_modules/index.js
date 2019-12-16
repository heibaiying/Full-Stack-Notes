import {multiply} from "./module.js";

let result = multiply(2, 2);
alert(result);


var RegExp = "Hello!";
console.log(window.RegExp); // 在模块顶级作用域中创建的变量，不会被自动添加到共享的全局作用域，它们只会在模块顶级作用域内部存在
console.log(this); // 模块顶级作用域的 `this` 值为 undefined
console.log(window.RegExp === RegExp);
