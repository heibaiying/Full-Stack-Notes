# 《深入理解ES6》《ECMAScript 6 入门》读书笔记
## 目录<br/>
<a href="#第一章-块级绑定">第一章 块级绑定</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-var-声明与变量提升">1. var 声明与变量提升</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-let-与-var-的区别">2. let 与 var 的区别</a><br/>
<a href="#第二章-字符串与正则表达式">第二章 字符串与正则表达式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1字符串扩展">1.字符串扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-includes、startsWith-、endsWith-方法">1.1 includes()、startsWith() 、endsWith() 方法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-repeat-方法">1.2 repeat() 方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-padStart，padEnd方法">1.3 padStart()，padEnd()方法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2正则表达式扩展">2.正则表达式扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-正则表达式-y-标志">2.1 正则表达式 y 标志 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-复制正则表达式">2.2 复制正则表达式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-flags属性">2.3 flags属性 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3模板字符串">3.模板字符串</a><br/>
<a href="#第三章-函数">第三章 函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1带参数默认值的函数">1.带参数默认值的函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2使用不具名参数">2.使用不具名参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-剩余参数">2.1 剩余参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3扩展运算符">3.扩展运算符</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4ES6的名称属性">4.ES6的名称属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5明确函数的双重用途">5.明确函数的双重用途</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-在-ES5-中判断函数如何被调用">5.1 在 ES5 中判断函数如何被调用</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6-箭头函数">6. 箭头函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-创建立即调用函数表达式">6.1 创建立即调用函数表达式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-this-绑定">6.2 this 绑定</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-箭头函数与数组">6.3 箭头函数与数组</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#64-没有-arguments-绑定">6.4 没有 arguments 绑定 </a><br/>
<a href="#第四章-扩展的对象功能">第四章 扩展的对象功能</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1对象字面量语法的扩展">1.对象字面量语法的扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-简写">1.1 简写</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-Objectis-方法">1.2 Object.is() 方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-Objectassign-方法">1.3 Object.assign() 方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2修改对象的原型">2.修改对象的原型 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3使用-super-引用的简单原型访问">3.使用 super 引用的简单原型访问 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4正式的“方法”定义">4.正式的“方法”定义 </a><br/>
<a href="#第五章-结构更方便的数据访问">第五章 结构：更方便的数据访问</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1对象解构">1.对象解构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2数组解构">2.数组解构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3混合解构">3.混合解构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4参数结构">4.参数结构</a><br/>
<a href="#第七章-Set与Map">第七章 Set与Map</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1Set">1.Set</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-Set">1.1 Set</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-WeakSet">1.2 WeakSet </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2Map">2.Map</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-Map">2.1 Map</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-WeakMap">2.2 WeakMap</a><br/>
<a href="#第八章-迭代器与生成器">第八章 迭代器与生成器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1迭代器">1.迭代器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2生成器">2.生成器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-生成器函数表达式">2.1 生成器函数表达式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-生成器对象方法">2.2 生成器对象方法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3可迭代对象与-for-of-循环">3.可迭代对象与 for-of 循环 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4创建可迭代对象">4.创建可迭代对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5内置的迭代器">5.内置的迭代器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-集合的迭代器">5.1 集合的迭代器 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-NodeList-的迭代器">5.2 NodeList 的迭代器 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#53-扩展运算符与非数组的可迭代对象">5.3 扩展运算符与非数组的可迭代对象 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6迭代器高级功能">6.迭代器高级功能 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-传递参数给迭代器">6.1 传递参数给迭代器 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62在迭代器中抛出错误">6.2在迭代器中抛出错误 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-生成器的-Return-语句">6.3 生成器的 Return 语句 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#64-生成器委托">6.4 生成器委托 </a><br/>
<a href="#第九章-JS类">第九章 JS类</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1ES5-中的仿类结构">1.ES5 中的仿类结构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2ES6中的类">2.ES6中的类</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-类表达式">2.1 类表达式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-具名表达式">2.2 具名表达式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3作为一等公民的类">3.作为一等公民的类</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-访问器属性">3.1 访问器属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-需计算的成员变量">3.2 需计算的成员变量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-生成器方法">3.3 生成器方法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-静态成员">3.4 静态成员</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4使用派生类进行继承">4.使用派生类进行继承</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-基本派生类属性">4.1 基本派生类属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-从表达式中派生类">4.2 从表达式中派生类</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-继承内置对象">5. 继承内置对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-Symbolspecies-属性">5.1 Symbol.species 属性 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-在类构造器中使用-newtarget">5.2 在类构造器中使用 new.target </a><br/>
<a href="#第十章-增强的数组功能">第十章 增强的数组功能</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1创建数组">1.创建数组</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11--Arrayof-方法">1.1  Array.of() 方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-Arrayfrom-方法">1.2 Array.from() 方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2所有数组上的方法">2.所有数组上的方法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-find-与-findIndex">2.1 find() 与 findIndex() </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-fill-方法">2.2 fill() 方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-copyWithin-方法">2.3 copyWithin() 方法 </a><br/>
<a href="#第十一章-Promise与异步编程">第十一章 Promise与异步编程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1Promise的含义">1.Promise的含义</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2基本用法">2.基本用法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3Promiseprototypethen">3.Promise.prototype.then()</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4Promiseprototypecatch">4.Promise.prototype.catch()</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5Promiseprototypefinally">5.Promise.prototype.finally()</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6Promiseall">6.Promise.all()</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7Promiserace">7.Promise.race()</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8Promiseresolve">8.Promise.resolve()</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#9Promisereject">9.Promise.reject()</a><br/>
<a href="#第十二章-代理与反射接口">第十二章 代理与反射接口</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1使用-set-陷阱函数验证属性值">1.使用 set 陷阱函数验证属性值 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2使用-get-陷阱函数进行对象外形验证">2.使用 get 陷阱函数进行对象外形验证 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3使用-has-陷阱函数隐藏属性">3.使用 has 陷阱函数隐藏属性 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4使用-deleteProperty-陷阱函数避免属性被删除">4.使用 deleteProperty 陷阱函数避免属性被删除 </a><br/>
<a href="#第十三章-用模块封装代码">第十三章 用模块封装代码</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1基本的导出">1.基本的导出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2基本的导入">2.基本的导入</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21导入绑定的一个微妙怪异点">2.1导入绑定的一个微妙怪异点</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3重命名导出与导入">3.重命名导出与导入</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4模块的默认值">4.模块的默认值</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41导出默认值">4.1导出默认值</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42导入默认值">4.2导入默认值</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5绑定的再导出">5.绑定的再导出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6无绑定的导入">6.无绑定的导入</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7浏览器模块说明符方案">7.浏览器模块说明符方案</a><br/>
## 正文<br/>




## 第一章 块级绑定

### 1. var 声明与变量提升

```javascript
function getValue(condition) {
    if (condition) {
    var value = "blue";
    	// 其他代码
    	return value;
    } else {
    	// value 在此处可访问，值为 undefined
    	return null;
    } 
    	// value 在此处可访问，值为 undefined
}

//提升后 相当于这段代码
function getValue(condition) {
    var value;
    if (condition) {
        value = "blue";
        // 其他代码
        return value;
    } else {
    	return null;
    }
}
```

### 2. let 与 var 的区别

```javascript
//使用var
var funcs = [];
for (var i = 0; i < 10; i++) {
	funcs.push(function() { console.log(i); });
} 
funcs.forEach(function(func) {
	func(); // 输出数值 "10" 十次
})

// 使用let
var funcs = [];
for (let i = 0; i < 10; i++) {
    funcs.push(function() {
    	console.log(i);
    });
} 
funcs.forEach(function(func) {
	func(); // 从 0 到 9 依次输出
})
```

## 第二章 字符串与正则表达式

### 1.字符串扩展

#### 1.1 includes()、startsWith() 、endsWith() 方法

ES6 包含了以下三个方法来满足这类需求：

- `includes()` 方法，在给定文本存在于字符串中的任意位置时会返回 true ，否则返回false ；

- `startsWith()` 方法，在给定文本出现在字符串起始处时返回 true ，否则返回 false ；

- `endsWith()` 方法，在给定文本出现在字符串结尾处时返回 true ，否则返回 false 。 

  每个方法都接受两个参数：需要搜索的文本，以及可选的搜索起始**位置索引**。

  ```javascript
  var msg = "Hello world!";
  console.log(msg.startsWith("Hello")); // true
  console.log(msg.endsWith("!")); // true
  console.log(msg.includes("o")); // true
  console.log(msg.startsWith("o")); // false
  console.log(msg.endsWith("world!")); // true
  console.log(msg.includes("x")); // false
  console.log(msg.startsWith("o", 4)); // true
  console.log(msg.endsWith("o", 8)); // true
  console.log(msg.includes("o", 8)); // false
  ```

#### 1.2 repeat() 方法 

```javascript
console.log("x".repeat(3)); // "xxx"
console.log("hello".repeat(2)); // "hellohello"
console.log("abc".repeat(4)); // "abcabcabcabc"
```

#### 1.3 padStart()，padEnd()方法

ES2017 引入了字符串补全长度的功能。如果某个字符串不够指定长度，会在头部或尾部补全。`padStart()`用于头部补全，`padEnd()`用于尾部补全。

```javascript
'x'.padStart(5, 'ab') // 'ababx'
'x'.padStart(4, 'ab') // 'abax'

'x'.padEnd(5, 'ab') // 'xabab'
'x'.padEnd(4, 'ab') // 'xaba'
```

上面代码中，`padStart`和`padEnd`一共接受两个参数，第一个参数用来指定字符串的最小长度，第二个参数是用来补全的字符串。

如果原字符串的长度，等于或大于指定的最小长度，则返回原字符串。

```javascript
'xxx'.padStart(2, 'ab') // 'xxx'
'xxx'.padEnd(2, 'ab') // 'xxx'
```

如果用来补全的字符串与原字符串，两者的长度之和超过了指定的最小长度，则会截去超出位数的补全字符串。

```javascript
'abc'.padStart(10, '0123456789')
// '0123456abc'
```

如果省略第二个参数，默认使用空格补全长度。

```javascript
'x'.padStart(4) // '   x'
'x'.padEnd(4) // 'x   '
```

### 2.正则表达式扩展

#### 2.1 正则表达式 y 标志 

在 Firefox 实现了对正则表达式 y 标志的专有扩展之后，ES6 将该实现标准化。 y 标志影响正则表达式搜索时的粘连（ sticky ） 属性，它表示从正则表达式的 lastIndex 属性值的位置开始检索字符串中的匹配字符。如果在该位置没有匹配成功，那么正则表达式将停止检索。 

```javascript
var text = "hello1 hello2 hello3",
    pattern = /hello\d\s?/,
    result = pattern.exec(text),
    globalPattern = /hello\d\s?/g,
    globalResult = globalPattern.exec(text),
    stickyPattern = /hello\d\s?/y,
    stickyResult = stickyPattern.exec(text);
console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello1 "
console.log(stickyResult[0]); // "hello1 "
pattern.lastIndex = 1;
globalPattern.lastIndex = 1;
stickyPattern.lastIndex = 1;
result = pattern.exec(text);
globalResult = globalPattern.exec(text);
stickyResult = stickyPattern.exec(text);
console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello2 "
console.log(stickyResult[0]); // Error! stickyResult is null

var text = "hello1 hello2 hello3",
    pattern = /hello\d\s?/,
    result = pattern.exec(text),
    globalPattern = /hello\d\s?/g,
    globalResult = globalPattern.exec(text),
    stickyPattern = /hello\d\s?/y,
    stickyResult = stickyPattern.exec(text);
console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello1 "
console.log(stickyResult[0]); // "hello1 "
console.log(pattern.lastIndex); // 0
console.log(globalPattern.lastIndex); // 7
console.log(stickyPattern.lastIndex); // 7
result = pattern.exec(text);
globalResult = globalPattern.exec(text);
stickyResult = stickyPattern.exec(text);
console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello2 "
console.log(stickyResult[0]); // "hello2 "
console.log(pattern.lastIndex); // 0
console.log(globalPattern.lastIndex); // 14
console.log(stickyPattern.lastIndex); // 14
```

1. 只有调用正则表达式对象上的方法（例如 exec() 与 test() 方法） ， lastIndex 属性才会生效。而将正则表达式作为参数传递给字符串上的方法（例如 match() ） ，并不会体现粘连特性。
2. 当使用 ^ 字符来匹配字符串的起始处时，粘连的正则表达式只会匹配字符串的起始处（或者在多行模式下匹配行首） 。当 lastIndex 为 0 时， ^ 不会让粘连的正则表达式与非粘连的有任何区别；而当 lastIndex 在单行模式下不对应整个字符串起始处，或者当它在多行模式下不对应行首时，粘连的正则表达式永远不会匹配成功。

```javascript
// 判断粘连标志
var pattern = /hello\d/y;
console.log(pattern.sticky); // true

//检测是否支持粘连标志
function hasRegExpY() {
try {
    var pattern = new RegExp(".", "y");
    	return true;
    } catch (ex) {
    	return false;
    }
}
```

#### 2.2 复制正则表达式

```JavaScript
var re1 = /ab/i,
re2 = new RegExp(re1);

//新增标志
var re1 = /ab/i,
// ES5 中会抛出错误, ES6 中可用
re2 = new RegExp(re1, "g");
console.log(re1.toString()); // "/ab/i"
console.log(re2.toString()); // "/ab/g"
console.log(re1.test("ab")); // true
console.log(re2.test("ab")); // true
console.log(re1.test("AB")); // true
console.log(re2.test("AB")); // false          
```

#### 2.3 flags属性 

```javascript
var re = /ab/g;
console.log(re.source); // "ab"
console.log(re.flags); // "g"
```



### 3.模板字符串

替换位允许你将**任何有效的 JS 表达式**嵌入到模板字面量中。 

```javascript
let name = "Nicholas",
message = `Hello, ${name}.`;
console.log(message); // "Hello, Nicholas."

//有效js表达式
let count = 10,
price = 0.25,
message = `${count} items cost $${(count * price).toFixed(2)}.`;
console.log(message); // "10 items cost $2.50."

//嵌套
let name = "Nicholas",
message = `Hello, ${
`my name is ${ name }`
}.`;
console.log(message); // "Hello, my name is Nicholas."
```



## 第三章 函数

### 1.带参数默认值的函数

不传或者传递undefined 都会调用默认值，**传递null是有效的**，不会调用默认值。

```javascript
function makeRequest(url, timeout = 2000, callback) {
// 函数的剩余部分
}

// 使用默认的 timeout
makeRequest("/foo", undefined, function(body) {
doSomething(body);
});
// 使用默认的 timeout
makeRequest("/foo");
// 不使用默认值
makeRequest("/foo", null, function(body) {
doSomething(body);
});
```

**始终依据 arguments 对象来反映初始调用状态。** 

```javascript
function mixArgs(first, second = "b") {
    console.log(arguments.length);  //1
    console.log(first === arguments[0]);  // true
    console.log(second === arguments[1]); // false
    first = "c";
    second = "d";
    console.log(first === arguments[0]);  // false
    console.log(second === arguments[1]); //false
} 
mixArgs("a"); //arguments 反映的是初始化调用状态

function mixArgs(first, second = "b") {
    console.log(arguments.length);  //1
    console.log(first === arguments[0]);  // true
    console.log(second === arguments[1]); // true
    first = "c";
    second = "d";
    console.log(first === arguments[0]);  // false
    console.log(second === arguments[1]); //false
}
mixArgs("a","k"); //arguments 反映的是初始化调用状态
```

**参数默认值最有意思的特性或许就是默认值并不要求一定是基本类型的值**。例如，你可以执行一个函数来产生参数的默认值，就像这样： 

```javascript
function getValue() {
	return 5;
} 
function add(first, second = getValue()) {
	return first + second;
} 
console.log(add(1, 1)); // 2
console.log(add(1)); // 6
```

可以将前面的参数作为后面参数的默认值 ,**反之不行。**

```javascript
function getValue(value) {
	return value + 5;
} 
function add(first, second = getValue(first)) {
	return first + second;
} 
console.log(add(1, 1)); // 2
console.log(add(1)); // 7
```

### 2.使用不具名参数

#### 2.1 剩余参数

剩余参数（rest parameter ） 由三个点（ ... ） 与一个紧跟着的具名参数指定 。

- 剩余参数受到两点限制。一是函数只能有一个剩余参数，并且它必须被放在最后。

- 第二个限制是剩余参数不能在对象字面量的 setter 属性中使用，这意味着如下代码同样会导致语法错误。存在此限制的原因是：对象字面量的 setter 被限定只能使用单个参数；而剩余参数按照定义是不限制参数数量的，因此它在此处不被许可。 

```javascript
let object = {
    // 语法错误：不能在 setter 中使用剩余参数
    set name(...value) {
    // 一些操作
    }
};

function checkArgs(...args) {
console.log(args.length);   //2
console.log(arguments.length); //2
console.log(args[0], arguments[0]);//a  a
console.log(args[1], arguments[1]);//b  b
} 
checkArgs("a", "b");
```

### 3.扩展运算符

```javascript
// ES5解决方案
let values = [25, 50, 75, 100]
console.log(Math.max.apply(Math, values)); // 100

//ES6解决方案
let values = [-25, -50, -75, -100]
console.log(Math.max(...values, 0)); 
```

### 4.ES6的名称属性

```javascript
var doSomething = function doSomethingElse() {
// ...
};
var person = {
    get firstName() {
    	return "Nicholas"
	},
	sayName: function() {
		console.log(this.name);
	}
} 
console.log(doSomething.name); // "doSomethingElse"
console.log(person.sayName.name); // "sayName"
var descriptor = Object.getOwnPropertyDescriptor(person, "firstName");
console.log(descriptor.get.name); // "get firstName"
//person.firstName 实际是个 getter 函数，因此它的名称是 "get firstName" 

var doSomething = function() {
// ...
};
console.log(doSomething.bind().name); // "bound doSomething"
console.log((new Function()).name); // "anonymous"
```

函数名称还有另外两个特殊情况。使用 bind() 创建的函数会在名称属性值之前带有"bound" 前缀；而使用 Function 构造器创建的函数，其名称属性则会有 "anonymous" 前缀。 

### 5.明确函数的双重用途

#### 5.1 在 ES5 中判断函数如何被调用

```javascript
function Person(name) {
if (this instanceof Person) {
	this.name = name; // 使用 new
	} else {
	throw new Error("You must use new with Person.")
	}
} 
var person = new Person("Nicholas");
var notAPerson = Person("Nicholas"); // 抛出错误

//不能避免
function Person(name) {
if (this instanceof Person) {
	this.name = name; // 使用 new
} else {
	throw new Error("You must use new with Person.")
}
} 
var person = new Person("Nicholas");
var notAPerson = Person.call(person, "Michael"); // 奏效了！
```

ES6 引入了 **new.target 元属性**。元属性指的是“非对象”（例如 new ）上的一个属性，并提供关联到它的目标的附加信息。当函数的 [[Construct]] 方法被调用时， new.target 会被填入 new 运算符的作用目标，该目标通常是新创建的对象实例的构造器，并且会成为函数体内部的 this 值。而若 [[Call]] 被执行， new.target 的值则会是undefined 。 

```javascript
function Person(name) {
if (typeof new.target !== "undefined") {
	this.name = name; // 使用 new
} else {
	throw new Error("You must use new with Person.")
}
} 
var person = new Person("Nicholas");
var notAPerson = Person.call(person, "Michael"); // 出错！

//也可以检查 new.target 是否被使用特定构造器进行了调用
function Person(name) {
if (new.target === Person) {
	this.name = name; // 使用 new
} else {
	throw new Error("You must use new with Person.")
}
} 
function AnotherPerson(name) {
Person.call(this, name);
} 
var person = new Person("Nicholas");
var anotherPerson = new AnotherPerson("Nicholas"); // 出错！
```

### 6. 箭头函数

ES6 最有意思的一个新部分就是箭头函数（arrow function ） 。箭头函数正如名称所示那样使用一个“箭头”（ => ） 来定义，但它的行为在很多重要方面与传统的 JS 函数不同：

- 没有 this 、 super 、 arguments ，也没有 new.target 绑定： this 、 super 、arguments 、以及函数内部的 new.target 的值由所在的、最靠近的非箭头函数来决定。
- 不能被使用 new 调用： 箭头函数没有 [[Construct]] 方法，因此不能被用为构造函数，使用 new 调用箭头函数会抛出错误。
- 没有原型： 既然不能对箭头函数使用 new ，那么它也不需要原型，也就是没有prototype 属性。
- 不能更改 this ： this 的值在函数内部不能被修改，在函数的整个生命周期内其值会保持不变。
- 没有 arguments 对象： 既然箭头函数没有 arguments 绑定，你必须依赖于具名参数或剩余参数来访问函数的参数。
- 不允许重复的具名参数： 箭头函数不允许拥有重复的具名参数，无论是否在严格模式下；而相对来说，传统函数只有在严格模式下才禁止这种重复。 

```javascript
var reflect = value => value;
// 有效等价于：
var reflect = function(value) {
return value;
};


var sum = (num1, num2) => num1 + num2;
// 有效等价于：
var sum = function(num1, num2) {
return num1 + num2;
};


var getName = () => "Nicholas";
// 有效等价于：
var getName = function() {
return "Nicholas";
};


var sum = (num1, num2) => {
return num1 + num2;
};
// 有效等价于：
var sum = function(num1, num2) {
return num1 + num2;
};


var doNothing = () => {};
// 有效等价于：
var doNothing = function() {};

//但若箭头函数想要从函数体内向外返回一个对象字面量，就必须将该字面量包裹在圆括号内
var getTempItem = id => ({ id: id, name: "Temp" });
// 有效等价于：
var getTempItem = function(id) {
	return {
    	id: id,
   		name: "Temp"
    };
};
```



#### 6.1 创建立即调用函数表达式

```javascript
//传统方式
let person = function(name) {
return {
    getName: function() {
    	return name;
    	}
    };
}("Nicholas");
console.log(person.getName()); // "Nicholas"

//箭头函数表表达式
let person = ((name) => {
    return {
    getName: function() {
    	return name;
     }
    };
})("Nicholas");
console.log(person.getName()); // "Nicholas"
```

使用传统函数时， (function(){/*函数体*/})(); 与 (function(){/*函数体*/}());这两种方式都是可行的。
但若使用箭头函数，则只有下面的写法是有效的： (() => {/*函数体*/})(); 

#### 6.2 this 绑定

```javascript
var PageHandler = {
id: "123456",
init: function() {
document.addEventListener("click", function(event) {
    this.doSomething(event.type); // 错误 此时这个this指代的是document
    }, false);
},
doSomething: function(type) {
	console.log("Handling " + type + " for " + this.id);
	}
};


var PageHandler = {
id: "123456",
init: function() {
document.addEventListener("click",
	event => this.doSomething(event.type), false);
},
doSomething: function(type) {
	console.log("Handling " + type + " for " + this.id);
	}
};
```

**箭头函数没有 this 绑定，意味着箭头函数内部的 this 值只能通过查找作用域链来确定。**如果箭头函数被包含在一个非箭头函数内，那么 this 值就会与该函数的相等；否则，this 值就会是全局对象（在浏览器中是 window ，在 nodejs 中是 global ） 。 



#### 6.3 箭头函数与数组

```javascript
var result = values.sort((a, b) => a - b);
//能使用回调函数的数组方法（例如 sort() 、 map() 与 reduce() 方法）
```



#### 6.4 没有 arguments 绑定 

尽管箭头函数没有自己的 arguments 对象，但仍然能访问包含它的函数的 arguments 对象。无论此后箭头函数在何处执行，该对象都是可用的。 

```javascript
function createArrowFunctionReturningFirstArg() {
	return () => arguments[0];
} 
var arrowFunction = createArrowFunctionReturningFirstArg(5);
console.log(arrowFunction()); // 5

var sum = (num1, num2) => num1 + num2;
console.log(sum.call(null, 1, 2)); // 3
console.log(sum.apply(null, [1, 2])); // 3
var boundSum = sum.bind(null, 1, 2);
console.log(boundSum()); // 3
```



## 第四章 扩展的对象功能

### 1.对象字面量语法的扩展

#### 1.1 简写

```javascript
function createPerson(name, age) {
return {
    name: name,
    age: age
    };
}

//名称简写相当于
function createPerson(name, age) {
return {
    name,
    age
	};
}


var person = {
    name: "Nicholas",
    sayName: function() {
        console.log(this.name);
        }
};

// 方法简写
var person = {
	name: "Nicholas",
    sayName() {
    console.log(this.name);
    }
};

//对象字面量内的方括号表明该属性名需要计算，其结果是一个字符串。
var suffix = " name";
var person = {
["first" + suffix]: "Nicholas",
["last" + suffix]: "Zakas"
};
console.log(person["first name"]); // "Nicholas"
console.log(person["last name"]); // "Zakas"
```

#### 1.2 Object.is() 方法 

在许多情况下， Object.is() 的结果与 === 运算符是相同的，仅有的例外是：它会认为+0 与 -0 不相等，而且 NaN 等于 NaN 。不过仍然没必要停止使用严格相等运算符，选择 Object.is() ，还是选择 == 或 === ，取决于代码的实际情况。 

```javascript
console.log(+0 == -0); // true
console.log(+0 === -0); // true
console.log(Object.is(+0, -0)); // false
console.log(NaN == NaN); // false
console.log(NaN === NaN); // false
console.log(Object.is(NaN, NaN)); // true
console.log(5 == 5); // true
console.log(5 == "5"); // true
console.log(5 === 5); // true
console.log(5 === "5"); // false
console.log(Object.is(5, 5)); // true
console.log(Object.is(5, "5")); // false
```

#### 1.3 Object.assign() 方法 

  [参见]（http://es6.ruanyifeng.com/#docs/object#Object-assign）

`Object.assign`方法用于对象的合并，将源对象（source）的所有可枚举属性，复制到目标对象（target）。

```javascript
const target = { a: 1 };

const source1 = { b: 2 };
const source2 = { c: 3 };

Object.assign(target, source1, source2);
target // {a:1, b:2, c:3}
```

`Object.assign`方法的第一个参数是目标对象，后面的参数都是源对象。

注意，如果目标对象与源对象有同名属性，或多个源对象有同名属性，则后面的属性会覆盖前面的属性。

```javascript
const target = { a: 1, b: 1 };

const source1 = { b: 2, c: 2 };
const source2 = { c: 3 };

Object.assign(target, source1, source2);
target // {a:1, b:2, c:3}
```

如果只有一个参数，`Object.assign`会直接返回该参数。

```javascript
const obj = {a: 1};
Object.assign(obj) === obj // true
```

如果该参数不是对象，则会先转成对象，然后返回。

```javascript
typeof Object.assign(2) // "object"
```

由于`undefined`和`null`无法转成对象，所以如果它们作为参数，就会报错。

```javascript
Object.assign(undefined) // 报错
Object.assign(null) // 报错
```

如果非对象参数出现在源对象的位置（即非首参数），那么处理规则有所不同。首先，这些参数都会转成对象，如果无法转成对象，就会跳过。这意味着，如果`undefined`和`null`不在首参数，就不会报错。

```javascript
let obj = {a: 1};
Object.assign(obj, undefined) === obj // true
Object.assign(obj, null) === obj // true
```

其他类型的值（即数值、字符串和布尔值）不在首参数，也不会报错。但是，除了字符串会以数组形式，拷贝入目标对象，其他值都不会产生效果。

```javascript
const v1 = 'abc';
const v2 = true;
const v3 = 10;

const obj = Object.assign({}, v1, v2, v3);
console.log(obj); // { "0": "a", "1": "b", "2": "c" }
```

上面代码中，`v1`、`v2`、`v3`分别是字符串、布尔值和数值，结果只有字符串合入目标对象（以字符数组的形式），数值和布尔值都会被忽略。这是因为只有字符串的包装对象，会产生可枚举属性。

```javascript
Object(true) // {[[PrimitiveValue]]: true}
Object(10)  //  {[[PrimitiveValue]]: 10}
Object('abc') // {0: "a", 1: "b", 2: "c", length: 3, [[PrimitiveValue]]: "abc"}
```

上面代码中，布尔值、数值、字符串分别转成对应的包装对象，可以看到它们的原始值都在包装对象的内部属性`[[PrimitiveValue]]`上面，这个属性是不会被`Object.assign`拷贝的。只有字符串的包装对象，会产生可枚举的实义属性，那些属性则会被拷贝。

`Object.assign`拷贝的属性是有限制的，只拷贝源对象的自身属性（不拷贝继承属性），也不拷贝不可枚举的属性（`enumerable: false`）。

```javascript
Object.assign({b: 'c'},
  Object.defineProperty({}, 'invisible', {
    enumerable: false,
    value: 'hello'
  })
)
// { b: 'c' }
```

上面代码中，`Object.assign`要拷贝的对象只有一个不可枚举属性`invisible`，这个属性并没有被拷贝进去。

属性名为 Symbol 值的属性，也会被`Object.assign`拷贝。

```javascript
Object.assign({ a: 'b' }, { [Symbol('c')]: 'd' })
// { a: 'b', Symbol(c): 'd' }
```

**注意点**:

**（1）浅拷贝**

`Object.assign`方法实行的是浅拷贝，而不是深拷贝。也就是说，如果源对象某个属性的值是对象，那么目标对象拷贝得到的是这个对象的引用。

```javascript
const obj1 = {a: {b: 1}};
const obj2 = Object.assign({}, obj1);

obj1.a.b = 2;
obj2.a.b // 2
```

上面代码中，源对象`obj1`的`a`属性的值是一个对象，`Object.assign`拷贝得到的是这个对象的引用。这个对象的任何变化，都会反映到目标对象上面。

**（2）同名属性的替换**

对于这种嵌套的对象，一旦遇到同名属性，`Object.assign`的处理方法是替换，而不是添加。

```javascript
const target = { a: { b: 'c', d: 'e' } }
const source = { a: { b: 'hello' } }
Object.assign(target, source)
// { a: { b: 'hello' } }
```

上面代码中，`target`对象的`a`属性被`source`对象的`a`属性整个替换掉了，而不会得到`{ a: { b: 'hello', d: 'e' } }`的结果。这通常不是开发者想要的，需要特别小心。

一些函数库提供`Object.assign`的定制版本（比如 Lodash 的`_.defaultsDeep`方法），可以得到深拷贝的合并。

**（3）数组的处理**

`Object.assign`可以用来处理数组，但是会把数组视为对象。

```javascript
Object.assign([1, 2, 3], [4, 5])
// [4, 5, 3]
```

上面代码中，`Object.assign`把数组视为属性名为 0、1、2 的对象，因此源数组的 0 号属性`4`覆盖了目标数组的 0 号属性`1`。

**（4）取值函数的处理**

`Object.assign`只能进行值的复制，如果要复制的值是一个取值函数，那么将求值后再复制。

```javascript
const source = {
  get foo() { return 1 }
};
const target = {};

Object.assign(target, source)
// { foo: 1 }
```

上面代码中，`source`对象的`foo`属性是一个取值函数，`Object.assign`不会复制这个取值函数，只会拿到值以后，将这个值复制过去。

### 2.修改对象的原型 

ES5 添加了 **Object.getPrototypeOf()** 方法来从任意指定对象中获取其原型，但仍然缺少在初始化之后更改对象原型的标准方法。ES6 通过添加 **Object.setPrototypeOf()** 方法而改变了这种假定，此方法允许你修改任意指定对象的原型。它接受两个参数：需要被修改原型的对象，以及将会成为前者原型的对象。

```javascript
let person = {
    getGreeting() {
    	return "Hello";
    }
};
let dog = {
    getGreeting() {
    	return "Woof";
    }
};
// 原型为 person
let friend = Object.create(person);
console.log(friend.getGreeting()); // "Hello"
console.log(Object.getPrototypeOf(friend) === person); // true
// 将原型设置为 dog
Object.setPrototypeOf(friend, dog);
console.log(friend.getGreeting()); // "Woof"
console.log(Object.getPrototypeOf(friend) === dog); // true
```

对象原型的实际值被存储在一个内部属性 **[[Prototype]]** 上， Object.getPrototypeOf() 方法会返回此属性存储的值，而 Object.setPrototypeOf() 方法则能够修改该值。 



### 3.使用 super 引用的简单原型访问 

```javascript
let person = {
    getGreeting() {
    	return "Hello";
    }
    };
let dog = {
    getGreeting() {
    	return "Woof";
    }
};
let friend = {
    getGreeting() {
    	return Object.getPrototypeOf(this).getGreeting.call(this) + ", hi!";
    }
};
// 将原型设置为 person
Object.setPrototypeOf(friend, person);
console.log(friend.getGreeting()); // "Hello, hi!"
console.log(Object.getPrototypeOf(friend) === person); // true
// 将原型设置为 dog
Object.setPrototypeOf(friend, dog);
console.log(friend.getGreeting()); // "Woof, hi!"
console.log(Object.getPrototypeOf(friend) === dog); // true



//缺点
let person = {
    getGreeting() {
    	return "Hello";
    }
};
// 原型为 person
let friend = {
    getGreeting() {
    	return Object.getPrototypeOf(this).getGreeting.call(this) + ", hi!";
    }
};
Object.setPrototypeOf(friend, person);
// 原型为 friend
let relative = Object.create(friend);
console.log(person.getGreeting()); // "Hello"
console.log(friend.getGreeting()); // "Hello, hi!"
console.log(relative.getGreeting()); // error!



//ES6 解决方案
let person = {
    getGreeting() {
   		return "Hello";
    }
};
// 原型为 person
let friend = {
    getGreeting() {
    	return super.getGreeting() + ", hi!";
    }
};
Object.setPrototypeOf(friend, person);
// 原型为 friend
let relative = Object.create(friend);
console.log(person.getGreeting()); // "Hello"
console.log(friend.getGreeting()); // "Hello, hi!"
console.log(relative.getGreeting()); // "Hello, hi!"
```



### 4.正式的“方法”定义 

S6 则正式做出了定义：方法是一个拥有 [[HomeObject]] 内部属性的函数，此内部属性指向该方法所属的对象。 

```javascript
let person = {
	// 方法
    getGreeting() {
    	return "Hello";
    }
};
// 并非方法
function shareGreeting() {
	return "Hi!";
}



let person = {
    getGreeting() {
    	return "Hello";
    }
};
// 原型为 person
let friend = {
    getGreeting() {
    	return super.getGreeting() + ", hi!";
	}
};
Object.setPrototypeOf(friend, person);
console.log(friend.getGreeting()); // "Hello, hi!"
```



## 第五章 结构：更方便的数据访问

### 1.对象解构

```javascript
//1.对象结构
let node = {
    type: "Identifier",
    name: "foo"
};
let { type, name } = node;
console.log(type); // "Identifier"
console.log(name); // "foo"


let node = {
    type: "Identifier",
    name: "foo"
},
type = "Literal",
name = 5;
// 使用解构来分配不同的值
({ type, name } = node);
console.log(type); // "Identifier"
console.log(name); // "foo"


//2. 传递值给函数
let node = {
    type: "Identifier",
    name: "foo"
},
type = "Literal",
name = 5;
function outputInfo(value) {
	console.log(value === node); // true
} 
outputInfo({ type, name } = node);
console.log(type); // "Identifier"
console.log(name); // "foo"

//3. 默认值
let node = {
    type: "Identifier",
    name: "foo"
};
let { type, name, value = true } = node;
console.log(type); // "Identifier"
console.log(name); // "foo"
console.log(value); // true


//4. 赋值给不同的本地变量名
let node = {
    type: "Identifier",
    name: "foo"
};
let { type: localType, name: localName } = node;
console.log(localType); // "Identifier"
console.log(localName); // "foo"

//5. 赋值给不同的本地变量名 并添加默认值
let node = {
	type: "Identifier"
};
let { type: localType, name: localName = "bar" } = node;
console.log(localType); // "Identifier"
console.log(localName); // "bar

//6. 嵌套对象解构
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
    }
};
let { loc: { start }} = node;
console.log(start.line); // 1
console.log(start.column); // 1

//7.在对象的嵌套解构中同样能为本地变量使用不同的名称
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
    }
};
// 提取 node.loc.start
let { loc: { start: localStart }} = node;
console.log(localStart.line); // 1
console.log(localStart.column); // 1
```

### 2.数组解构

```javascript
// 1.数组解构
let colors = [ "red", "green", "blue" ];
let [ firstColor, secondColor ] = colors;
console.log(firstColor); // "red"
console.log(secondColor); // "green"

let colors = [ "red", "green", "blue" ];
let [ , , thirdColor ] = colors;
console.log(thirdColor); // "blue


//2.解构赋值
let colors = [ "red", "green", "blue" ],
firstColor = "black",
secondColor = "purple";
[ firstColor, secondColor ] = colors;
console.log(firstColor); // "red"
console.log(secondColor); // "green"

//3.互换值
let a = 1,
b = 2;
[ a, b ] = [ b, a ];
console.log(a); // 2
console.log(b); // 1

// 4.默认值
let colors = [ "red" ];
let [ firstColor, secondColor = "green" ] = colors;
console.log(firstColor); // "red"
console.log(secondColor); // "green"

// 5.嵌套解构
let colors = [ "red", [ "green", "lightgreen" ], "blue" ];
let [ firstColor, [ secondColor ] ] = colors;
console.log(firstColor); // "red"
console.log(secondColor); // "green"

// 6.剩余项解构
let colors = [ "red", "green", "blue" ];
let [ firstColor, ...restColors ] = colors;
console.log(firstColor); // "red"
console.log(restColors.length); // 2
console.log(restColors[0]); // "green"
console.log(restColors[1]); // "blue"

// 7.在 ES6 中克隆数组
let colors = [ "red", "green", "blue" ];
let [ ...clonedColors ] = colors;
console.log(clonedColors); //"[red,green,blue]"
```



### 3.混合解构

```javascript
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
```



### 4.参数结构

**解构的参数是必需的** 

```javascript
// 1.参数解构
function setCookie(name, value, { secure, path, domain, expires }) {
// 设置 cookie 的代码
} s
etCookie("type", "js", {
secure: true,
expires: 60000
});

// 2. 解构的参数是必需的 
function setCookie(name, value, { secure, path, domain, expires } = {}) {
// ...
}

// 3. 参数解构默认值
function setCookie(name, value,
{
secure = false,
path = "/",
domain = "example.com",
expires = new Date(Date.now() + 360000000)
} = {}
) {
// ...
}
```



## 第七章 Set与Map

### 1.Set

#### 1.1 Set

主要方法: new Set()、add()、has()、delete()、clear()、foreach()  属性: size

```javascript
//1. Set 不会使用强制类型转换来判断值是否重复
let set = new Set();
set.add(5);
set.add("5");
console.log(set.size); // 2

let set = new Set(),
key1 = {},
key2 = {};
set.add(key1);
set.add(key2);
console.log(set.size); // 2

// 2.数组来初始化一个 Set 
let set = new Set([1, 2, 3, 4, 5, 5, 5, 5]);
console.log(set.size); // 5

// 3.has() 方法来测试某个值是否存在于 Set 中
let set = new Set();
set.add(5);
set.add("5");
console.log(set.has(5)); // true
console.log(set.has(6)); // false

// 4. 移除值
let set = new Set();
set.add(5);
set.add("5");
console.log(set.has(5)); // true
set.delete(5);
console.log(set.has(5)); // false
console.log(set.size); // 1
set.clear();
console.log(set.has("5")); // false
console.log(set.size); // 0

//4.值的遍历
let set = new Set([1, 2]);
set.forEach(function(value, key, ownerSet) {
console.log(key + " " + value);
console.log(ownerSet === set);
});
//1 1
//true
//2 2
//true

//5. 在 foreach 中绑定作用域 两种方式
let set = new Set([1, 2]);
let processor = {
    output(value) {
    console.log(value);
    },
process(dataSet) {
    dataSet.forEach(function(value) {
    this.output(value);
    }, this);
    //如果想在回调函数中使用 this ，你可以给 forEach() 传入一个 this值作为第二个参数
    }
};
processor.process(set);

//使用箭头函数绑定
let set = new Set([1, 2]);
let processor = {
    output(value) {
    console.log(value);
},
process(dataSet) {
	dataSet.forEach((value) => this.output(value));
	}
};
processor.process(set);

//6. 箭头函数转换为数组
let set = new Set([1, 2, 3, 3, 3, 4, 5]),
array = [...set];
console.log(array); // [1,2,3,4,5]

// 7.对垃圾回收的影响
let set = new Set(),
key = {};
set.add(key);
console.log(set.size); // 1
// 取消原始引用
key = null;
console.log(set.size); // 1
// 重新获得原始引用
key = [...set][0];
```

#### 1.2 WeakSet 

WeakSet 使用 WeakSet 构造器来创建，并包含 add() 方法、 has() 方法以及 delete()方法。以下例子使用了这三个方法：

```javascript
let set = new WeakSet(),
key = {};
// 将对象加入 set
set.add(key);
console.log(set.has(key)); // true
set.delete(key);
console.log(set.has(key)); // false

//1.与Set区别
let set = new WeakSet(),
key = {};
// 将对象加入 set
set.add(key);
console.log(set.has(key)); // true
// 移除对于键的最后一个强引用，同时从 Weak Set 中移除
key = null;
```

1. 对于 WeakSet 的实例，若调用 add() 方法时传入了非对象的参数，就会抛出错误（has() 或 delete() 则会在传入了非对象的参数时返回 false ） ；
2. Weak Set 不可迭代，因此不能被用在 for-of 循环中；
3. Weak Set 无法暴露出任何迭代器（例如 keys() 与 values() 方法） ，因此没有任何编程手段可用于判断 Weak Set 的内容；
4. Weak Set 没有 forEach() 方法；
5. Weak Set 没有 size 属性。 

### 2.Map

#### 2.1 Map

Map 与 Set 共享了几个方法，这是有意的，允许你使用相似的方式来与 Map 及 Set 进行交互。以下三个方法在 Map 与 Set 上都存在：

- has(key) ：判断指定的键是否存在于 Map 中；

- delete(key) ：移除 Map 中的键以及对应的值；

- clear() ：移除 Map 中所有的键与值。

  ```javascript
  let map = new Map();
  map.set("name", "Nicholas");
  map.set("age", 25);
  console.log(map.size); // 2
  console.log(map.has("name")); // true
  console.log(map.get("name")); // "Nicholas"
  console.log(map.has("age")); // true
  console.log(map.get("age")); // 25
  map.delete("name");
  console.log(map.has("name")); // false
  console.log(map.get("name")); // undefined
  console.log(map.size); // 1
  map.clear();
  console.log(map.has("name")); // false
  console.log(map.get("name")); // undefined
  console.log(map.has("age")); // false
  console.log(map.get("age")); // undefined
  console.log(map.size); // 0
  
  //1.初始化map
  let map = new Map([["name", "Nicholas"], ["age", 25]]);
  console.log(map.has("name")); // true
  console.log(map.get("name")); // "Nicholas"
  console.log(map.has("age")); // true
  console.log(map.get("age")); // 25
  console.log(map.size); // 2
  
  //2.map遍历
  let map = new Map([ ["name", "Nicholas"], ["age", 25]]);
  map.forEach(function(value, key, ownerMap) {
      console.log(key + " " + value);
      console.log(ownerMap === map);
  });
  //name Nicholas
  //true
  //age 25
  //true
  ```


#### 2.2 WeakMap

```javascript
//1、与Map区别
let map = new WeakMap(),
element = document.querySelector(".element");
map.set(element, "Original");
let value = map.get(element);
console.log(value); // "Original"
// 移除元素
element.parentNode.removeChild(element);
element = null;
// 该 Weak Map 在此处为空

//2、WeakMap 初始化
let key1 = {},
key2 = {},
map = new WeakMap([[key1, "Hello"], [key2, 42]]);
console.log(map.has(key1)); // true
console.log(map.get(key1)); // "Hello"
console.log(map.has(key2)); // true
console.log(map.get(key2)); // 42
```

Weak Map 只有两个附加方法能用来与键值对交互。 has() 方法用于判断指定的键是否存在于 Map 中，而 delete() 方法则用于移除一个特定的键值对。 clear() 方法不存在，这是因为没必要对键进行枚举，并且枚举 Weak Map 也是不可能的，这与 Weak Set 相同。以下例子同时用到了 has() 与 delete() 方法： 

```javascript
let map = new WeakMap(),
element = document.querySelector(".element");
map.set(element, "Original");
console.log(map.has(element)); // true
console.log(map.get(element)); // "Original"
map.delete(element);
console.log(map.has(element)); // false
console.log(map.get(element)); // undefined
```



## 第八章 迭代器与生成器

### 1.迭代器

```javascript
// ES5 实现的迭代器
function createIterator(items) {
var i = 0;
return {
    next: function() {
    var done = (i >= items.length);
    var value = !done ? items[i++] : undefined;
    return {
        done: done,
        value: value
        };
    }
};
} 
var iterator = createIterator([1, 2, 3]);
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: 3, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
// 之后的所有调用
console.log(iterator.next()); // "{ value: undefined, done: true }"
```

### 2.生成器

生成器（generator ） 是能返回一个迭代器的函数。生成器函数由放在 function 关键字之后的一个星号（ * ） 来表示，并能使用新的 yield 关键字。将星号紧跟在 function 关键字之后，或是在中间留出空格，都是没问题的，正如下例： 

```javascript
// 生成器
function *createIterator() {
yield 1;
yield 2;
yield 3;
} 
// 生成器能像正规函数那样被调用，但会返回一个迭代器
let iterator = createIterator();
console.log(iterator.next().value); // 1
console.log(iterator.next().value); // 2
console.log(iterator.next().value); // 3


// 1 .正确的生成器
function *createIterator(items) {
for (let i = 0; i < items.length; i++) {
yield items[i];
}
} l
et iterator = createIterator([1, 2, 3]);
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: 3, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
// 之后的所有调用
console.log(iterator.next()); // "{ value: undefined, done: true }"

//2. 错误的生成器
function *createIterator(items) {
    items.forEach(function(item) {
    // 语法错误
    yield item + 1;
    });
}

```

yield 关键字只能用在生成器内部，用于其他任意位置都是语法错误，即使在生成器内部的函数中也不行。尽管 yield 严格位于 createIterator() 内部，此代码仍然有语法错误，因为 yield无法穿越函数边界。



#### 2.1 生成器函数表达式

```javascript
let createIterator = function *(items) {
	for (let i = 0; i < items.length; i++) {
   	 	yield items[i];
    }
};
let iterator = createIterator([1, 2, 3]);
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: 3, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
// 之后的所有调用
console.log(iterator.next()); // "{ value: undefined, done: true }"
```

#### 2.2 生成器对象方法

```javascript
var o = {
	createIterator: function *(items) {
        for (let i = 0; i < items.length; i++) {
        yield items[i];
        }
    }
};
let iterator = o.createIterator([1, 2, 3]);

// 简写
var o = {
    *createIterator(items) {
        for (let i = 0; i < items.length; i++) {
        	yield items[i];
        }
    }
};
let iterator = o.createIterator([1, 2, 3]);
```

### 3.可迭代对象与 for-of 循环 

迭代器紧密相关的是，可迭代对象（iterable ） 是包含 Symbol.iterator 属性的对象。这个 Symbol.iterator 知名符号定义了为指定对象返回迭代器的函数。

```javascript
let values = [1, 2, 3];
let iterator = values[Symbol.iterator]();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: 3, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"

//正常调用
for (let num of values) {
	console.log(num);
}

//检测对象是否可迭代
function isIterable(object) {
	return typeof object[Symbol.iterator] === "function";
} 
console.log(isIterable([1, 2, 3])); // true
console.log(isIterable("Hello")); // true
console.log(isIterable(new Map())); // true
console.log(isIterable(new Set())); // true
console.log(isIterable(new WeakMap())); // false
console.log(isIterable(new WeakSet())); // false
```

### 4.创建可迭代对象

```javascript
et collection = {
    items: [],
    *[Symbol.iterator]() {
        for (let item of this.items) {
        yield item;
        }
    }
};
collection.items.push(1);
collection.items.push(2);
collection.items.push(3);
for (let x of collection) {
	console.log(x);
}
```

### 5.内置的迭代器

#### 5.1 集合的迭代器 

ES6 具有三种集合对象类型：数组、 Map 与 Set 。这三种类型都拥有如下的迭代器，有助于探索它们的内容：

- **entries()** ：返回一个包含键值对的迭代器；

- **values()** ：返回一个包含集合中的值的迭代器；

- **keys()** ：返回一个包含集合中的键的迭代器。 

  **当 for-of 循环没有显式指定迭代器时，每种集合类型都有一个默认的迭代器供循环使用。values() 方法是数组与 Set 的默认迭代器，而 entries() 方法则是 Map 的默认迭代器。** 

```javascript
let colors = ["red", "green", "blue"];
let tracking = new Set([1234, 5678, 9012]);
let data = new Map();
data.set("title", "Understanding ES6");
data.set("format", "ebook");
for (let entry of colors.entries()) {
  console.log(entry);
}
for (let entry of tracking.entries()) {
  console.log(entry);
}
for (let entry of data.entries()) {
  console.log(entry);
}

结果：
[0, "red"]
[1, "green"]
[2, "blue"]
[1234, 1234]
[5678, 5678]
[9012, 9012]
["title", "Understanding ES6"]
["format", "ebook"]


let colors = ["red", "green", "blue"];
let tracking = new Set([1234, 5678, 9012]);
let data = new Map();
data.set("title", "Understanding ES6");
data.set("format", "ebook");
for (let key of colors.keys()) {
  console.log(key);
}
for (let key of tracking.keys()) {
  console.log(key);
}
for (let key of data.keys()) {
  console.log(key);
}
结果：
0 
1 
2 
1234
5678
9012
"title"
"format"
// set 的键和值相同
```

```javascript
//map 循环解构
let data = new Map();
data.set("title", "Understanding ES6");
data.set("format", "ebook");
// 与使用 data.entries() 相同
for (let [key, value] of data) {
console.log(key + "=" + value);
}

var message = "A B" ;
for (let c of message) {
console.log(c);
}
```

#### 5.2 NodeList 的迭代器 

```javascript
var divs = document.getElementsByTagName("div");
    for (let div of divs) {
    console.log(div.id);
}
```

#### 5.3 扩展运算符与非数组的可迭代对象 

**扩展运算符能作用于所有可迭代对象**，并且会使用默认迭代器来判断需要使用哪些值。所有的值都从迭代器中被读取出来并插入数组，遵循迭代器返回值的顺序。 

```javascript
let map = new Map([ ["name", "Nicholas"], ["age", 25]]),
array = [...map];
console.log(array); // [ ["name", "Nicholas"], ["age", 25]]

let smallNumbers = [1, 2, 3],
bigNumbers = [100, 101, 102],
allNumbers = [0, ...smallNumbers, ...bigNumbers];
console.log(allNumbers.length); // 7
console.log(allNumbers); // [0, 1, 2, 3, 100, 101, 102]
```

### 6.迭代器高级功能 

#### 6.1 传递参数给迭代器 

```javascript
function *createIterator() {
    let first = yield 1;
    let second = yield first + 2; // 4 + 2
    yield second + 3; // 5 + 3
} 
let iterator = createIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next(4)); // "{ value: 6, done: false }"
console.log(iterator.next(5)); // "{ value: 8, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
```

#### 6.2在迭代器中抛出错误 

```javascript
// 抛出错误
function *createIterator() {
    let first = yield 1;
    let second = yield first + 2; // yield 4 + 2 ，然后抛出错误
    yield second + 3; // 永不会被执行
} 
let iterator = createIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next(4)); // "{ value: 6, done: false }"
console.log(iterator.throw(new Error("Boom"))); // 从生成器中抛出了错误

//异常捕获
function *createIterator() {
    let first = yield 1;
    let second;
    try {
    	second = yield first + 2; // yield 4 + 2 ，然后抛出错误
    } catch (ex) {
   		second = 6; // 当出错时，给变量另外赋值
    } 
    yield second + 3;
} 
let iterator = createIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next(4)); // "{ value: 6, done: false }"
console.log(iterator.throw(new Error("Boom"))); // "{ value: 9, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
```

#### 6.3 生成器的 Return 语句 

```javascript
function *createIterator() {
    yield 1;
    return;
    yield 2;
    yield 3;
} 
let iterator = createIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
```

#### 6.4 生成器委托 

在某些情况下，将两个迭代器的值合并器一起会更有用。生成器可以用星号（ * ） 配合yield 这一特殊形式来委托其他的迭代器。 

```javascript
function *createNumberIterator() {
    yield 1;
    yield 2;
} 
function *createColorIterator() {
    yield "red";
    yield "green";
} 
function *createCombinedIterator() {
    yield *createNumberIterator();
    yield *createColorIterator();
    yield true;
} 
var iterator = createCombinedIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: "red", done: false }"
console.log(iterator.next()); // "{ value: "green", done: false }"
console.log(iterator.next()); // "{ value: true, done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"


//带参数传递的委托
function *createNumberIterator() {
    yield 1;
    yield 2;
    return 3;
} 
function *createRepeatingIterator(count) {
    for (let i=0; i < count; i++) {
    yield "repeat";
}
} 
function *createCombinedIterator() {
	let result = yield *createNumberIterator();
	yield *createRepeatingIterator(result);
} 
var iterator = createCombinedIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: "repeat", done: false }"
console.log(iterator.next()); // "{ value: "repeat", done: false }"
console.log(iterator.next()); // "{ value: "repeat", done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"


//输出返回值
function *createNumberIterator() {
    yield 1;
    yield 2;
    return 3;
} 
function *createRepeatingIterator(count) {
    for (let i=0; i < count; i++) {
    yield "repeat";
}
} 
function *createCombinedIterator() {
    let result = yield *createNumberIterator();
    yield result; //输出返回值
    yield *createRepeatingIterator(result);
} 
var iterator = createCombinedIterator();
console.log(iterator.next()); // "{ value: 1, done: false }"
console.log(iterator.next()); // "{ value: 2, done: false }"
console.log(iterator.next()); // "{ value: 3, done: false }"
console.log(iterator.next()); // "{ value: "repeat", done: false }"
console.log(iterator.next()); // "{ value: "repeat", done: false }"
console.log(iterator.next()); // "{ value: "repeat", done: false }"
console.log(iterator.next()); // "{ value: undefined, done: true }"
```



## 第九章 JS类

### 1.ES5 中的仿类结构

```javascript
function PersonType(name) {
	this.name = name;
} 
PersonType.prototype.sayName = function() {
console.log(this.name);
};
let person = new PersonType("Nicholas");
person.sayName(); // 输出 "Nicholas"
console.log(person instanceof PersonType); // true
console.log(person instanceof Object); // true
```

### 2.ES6中的类

```javascript
class PersonClass {
	// 等价于 PersonType 构造器
    constructor(name) {
    this.name = name;
    } 
	// 等价于 PersonType.prototype.sayName
    sayName() {
    console.log(this.name);
    }
} 
let person = new PersonClass("Nicholas");
person.sayName(); // 输出 "Nicholas"
console.log(person instanceof PersonClass); // true
console.log(person instanceof Object); // true
console.log(typeof PersonClass); // "function"
console.log(typeof PersonClass.prototype.sayName); // "function"
```

1. 类声明不会被提升，这与函数定义不同。类声明的行为与 let 相似，因此在程序的执行到达声明处之前，类会存在于暂时性死区内。

2. 类声明中的所有代码会自动运行在严格模式下，并且也无法退出严格模式。

3. 类的所有方法都是不可枚举的，这是对于自定义类型的显著变化，后者必须用Object.defineProperty() 才能将方法改变为不可枚举。

4. 类的所有方法内部都没有 [[Construct]] ，因此使用 new 来调用它们会抛出错误。

5. 调用类构造器时不使用 new ，会抛出错误。

6. 试图在类的方法内部重写类名，会抛出错误。  


```javascript
// 直接等价于 PersonClass
let PersonType2 = (function () {
  "use strict";
  const PersonType2 = function (name) {
	// 确认函数被调用时使用了 new
    if (typeof new.target === "undefined") {
      throw new Error("Constructor must be called with new.");
    }
    this.name = name;
  }
  Object.defineProperty(PersonType2.prototype, "sayName", {
    value: function () {
	// 确认函数被调用时没有使用 new
      if (typeof new.target !== "undefined") {
        throw new Error("Method cannot be called with new.");
      }
      console.log(this.name);
    },
    enumerable: false,
    writable: true,
    configurable: true
  });
  return PersonType2;
}());
```

#### 2.1 类表达式

```javascript
let PersonClass = class {
  // 等价于 PersonType 构造器
  constructor(name) {
    this.name = name;
  }

  // 等价于 PersonType.prototype.sayName
  sayName() {
    console.log(this.name);
  }
};
let person = new PersonClass("Nicholas");
person.sayName(); // 输出 "Nicholas"
console.log(person instanceof PersonClass); // true
console.log(person instanceof Object); // true
console.log(typeof PersonClass); // "function"
console.log(typeof PersonClass.prototype.sayName); // "function"
```

#### 2.2 具名表达式

```javascript
let PersonClass = class PersonClass2 {
    // 等价于 PersonType 构造器
    constructor(name) {
    	this.name = name;
    } 
    // 等价于 PersonType.prototype.sayName
    sayName() {
    	console.log(this.name);
    }
};
console.log(typeof PersonClass); // "function"
console.log(typeof PersonClass2); // "undefined"   PersonClass2只在类内部有效
```

### 3.作为一等公民的类

**在编程中，能被当作值来使用的就称为一级公民（first-class citizen ） ，意味着它能作为参数传给函数、能作为函数返回值、能用来给变量赋值。** JS的函数就是一级公民（它们有时又被称为一级函数） ，此特性让 JS 独一无二。

```javascript
function createObject(classDef) {
  return new classDef();
}

let obj = createObject(class {
  sayHi() {
    console.log("Hi!");
  }
});
obj.sayHi(); // "Hi!"
```

#### 3.1 访问器属性

```javascript
class CustomHTMLElement {
  constructor(element) {
    this.element = element;
  }

  get html() {
    return this.element.innerHTML;
  }

  set html(value) {
    this.element.innerHTML = value;
  }
}

var descriptor = Object.getOwnPropertyDescriptor(CustomHTMLElement.prototype, "html");
console.log("get" in descriptor); // true
console.log("set" in descriptor); // true
console.log(descriptor.enumerable); // false
```

#### 3.2 需计算的成员变量

```javascript
let propertyName = "html";

class CustomHTMLElement {
  constructor(element) {
    this.element = element;
  }

  get [propertyName]() {
    return this.element.innerHTML;
  }

  set [propertyName](value) {
    this.element.innerHTML = value;
  }
}
```

#### 3.3 生成器方法

```javascript
class MyClass {
    *createIterator() {
        yield 1;
        yield 2;
        yield 3;
    }
} 
let instance = new MyClass();
let iterator = instance.createIterator();


//使用 Symbol.iterator 来定义生成器方法，从而定义出类的默认迭代器
class Collection {
  constructor() {
    this.items = [];
  }

  * [Symbol.iterator]() {
    yield* this.items.values();
  }
}

var collection = new Collection();
collection.items.push(1);
collection.items.push(2);
collection.items.push(3);
for (let x of collection) {
  console.log(x);
}
// 输出：
// 1
// 2
// 3
```

#### 3.4 静态成员

```javascript
// ES5 实现
function PersonType(name) {
  this.name = name;
}

// 静态方法
PersonType.create = function (name) {
  return new PersonType(name);
};
// 实例方法
PersonType.prototype.sayName = function () {
  console.log(this.name);
};
var person = PersonType.create("Nicholas");


//ES6 实现
class PersonClass {
// 等价于 PersonType 构造器
  constructor(name) {
    this.name = name;
  }

  // 等价于 PersonType.prototype.sayName
  sayName() {
    console.log(this.name);
  }

  // 等价于 PersonType.create
  static create(name) {
    return new PersonClass(name);
  }
}

let person = PersonClass.create("Nicholas");
```

### 4.使用派生类进行继承

#### 4.1 基本派生类属性

- 没有显示声明父类构造器，则默认调用父类构造器
- 可以重写覆盖父类方法
- **继承静态成员变量**

```javascript
//ES5 实现继承的方式
function Rectangle(length, width) {
  this.length = length;
  this.width = width;
}

Rectangle.prototype.getArea = function () {
  return this.length * this.width;
};

function Square(length) {
  Rectangle.call(this, length, length);
}

Square.prototype = Object.create(Rectangle.prototype, {
  constructor: {
    value: Square,
    enumerable: true,
    writable: true,
    configurable: true
  }
});
var square = new Square(3);
console.log(square.getArea()); // 9
console.log(square instanceof Square); // true
console.log(square instanceof Rectangle); // true


// ES6 实现继承的方式
class Rectangle {
  constructor(length, width) {
    this.length = length;
    this.width = width;
  }

  getArea() {
    return this.length * this.width;
  }
}

class Square extends Rectangle {
  constructor(length) {
// 与 Rectangle.call(this, length, length) 相同
    super(length, length);
  }
}

var square = new Square(3);
console.log(square.getArea()); // 9
console.log(square instanceof Square); // true
console.log(square instanceof Rectangle); // true
```

#### 4.2 从表达式中派生类

在 ES6 中派生类的最强大能力，或许就是能够从表达式中派生类。只要一个表达式能够返回一个具有 **[[Construct]]** 属性以及原型的函数，你就可以对其使用 extends 。 

```javascript
function Rectangle(length, width) {
  this.length = length;
  this.width = width;
}

Rectangle.prototype.getArea = function () {
  return this.length * this.width;
};

class Square extends Rectangle {
  constructor(length) {
    super(length, length);
  }
}

var x = new Square(3);
console.log(x.getArea()); // 9
console.log(x instanceof Rectangle); // true
```

**实现动态继承**

```javascript
let SerializableMixin = {
  serialize() {
    return JSON.stringify(this);
  }
};
let AreaMixin = {
  getArea() {
    return this.length * this.width;
  }
};

function mixin(...mixins) {
  var base = function () {
  };
  Object.assign(base.prototype, ...mixins);
  return base;
}

class Square extends mixin(AreaMixin, SerializableMixin) {
  constructor(length) {
    super();
    this.length = length;
    this.width = length;
  }
}

var x = new Square(3);
console.log(x.getArea()); // 9
console.log(x.serialize()); // "{"length":3,"width":3}"
```

### 5. 继承内置对象

```javascript
class MyArray extends Array {
// 空代码块
}

var colors = new MyArray();
colors[0] = "red";
console.log(colors.length); // 1
colors.length = 0;
console.log(colors[0]); // undefined
```

#### 5.1 Symbol.species 属性 

继承内置对象一个有趣的方面是：任意能返回内置对象实例的方法，在派生类上却会自动返回派生类的实例。因此，若你拥有一个继承了 Array 的派生类 MyArray ，诸如 slice() 之类的方法都会返回 MyArray 的实例。例如： 

```javascript
class MyArray extends Array {
// 空代码块
}

let items = new MyArray(1, 2, 3, 4),
  subitems = items.slice(1, 3);
console.log(items instanceof MyArray); // true
console.log(subitems instanceof MyArray); // true
```

Symbol.species 符号被用于定义一个能返回函数的静态访问器属性。每当类实例的方法（构造器除外） 必须创建一个实例时，前面返回的函数就被用为新实例的构造器。下列内置类型都定义了 Symbol.species ：

- Array
- ArrayBuffer 
- Map
- Promise
- RegExp
- Set
- 类型化数组

以上每个类型都拥有默认的 Symbol.species 属性，其返回值为 this ，意味着该属性总是会返回自身的构造器函数。若你准备在一个自定义类上实现此功能，代码就像这样 :

```javascript
// 几个内置类型使用 species 的方式类似于此
class MyClass {
  static get [Symbol.species]() {
    return this;
  }

  constructor(value) {
    this.value = value;
  }

  clone() {
    return new this.constructor[Symbol.species](this.value);
  }
}
```

**允许重写该属性**

```javascript
class MyClass {
  static get [Symbol.species]() {
    return this;
  }

  constructor(value) {
    this.value = value;
  }

  clone() {
    return new this.constructor[Symbol.species](this.value);
  }
}

class MyDerivedClass1 extends MyClass {
// 空代码块
}

class MyDerivedClass2 extends MyClass {
  static get [Symbol.species]() {
    return MyClass;
  }
}

let instance1 = new MyDerivedClass1("foo"),
  clone1 = instance1.clone(),
  instance2 = new MyDerivedClass2("bar"),
  clone2 = instance2.clone();
console.log(clone1 instanceof MyClass); // true
console.log(clone1 instanceof MyDerivedClass1); // true
console.log(clone2 instanceof MyClass); // true
console.log(clone2 instanceof MyDerivedClass2); // false



class MyArray extends Array {
static get [Symbol.species]() {
return Array;
}
} l
et items = new MyArray(1, 2, 3, 4),
subitems = items.slice(1, 3);
console.log(items instanceof MyArray); // true
console.log(subitems instanceof Array); // true
console.log(subitems instanceof MyArray); // false
```

#### 5.2 在类构造器中使用 new.target 

```javascript
class Rectangle {
  constructor(length, width) {
    console.log(new.target === Rectangle);
    this.length = length;
    this.width = width;
  }
}

// new.target 就是 Rectangle
var obj = new Rectangle(3, 4); // 输出 true
```

```javascript
class Rectangle {
  constructor(length, width) {
    console.log(new.target === Rectangle);
    this.length = length;
    this.width = width;
  }
}

class Square extends Rectangle {
  constructor(length) {
    super(length, length)
  }
}

// new.target 就是 Square
var obj = new Square(3); // 输出 false
```

```javascript
// 静态的基类   此处的作用 类似于java中的接口
class Shape {
  constructor() {
    if (new.target === Shape) {
      throw new Error("This class cannot be instantiated directly.")
    }
  }
}

class Rectangle extends Shape {
  constructor(length, width) {
    super();
    this.length = length;
    this.width = width;
  }
}

var x = new Shape(); // 抛出错误
var y = new Rectangle(3, 4); // 没有错误
console.log(y instanceof Shape); // true
```

## 第十章 增强的数组功能

### 1.创建数组

#### 1.1  Array.of() 方法 

```javascript
let items = Array.of(1, 2);
console.log(items.length); // 2
console.log(items[0]); // 1
console.log(items[1]); // 2
items = Array.of(2);
console.log(items.length); // 1
console.log(items[0]); // 2
items = Array.of("2");
console.log(items.length); // 1
console.log(items[0]); // "2
```

#### 1.2 Array.from() 方法 

```javascript
//映射转换
function translate() {
return Array.from(arguments, (value) => value + 1);
} 
let numbers = translate(1, 2, 3);
console.log(numbers); // 2,3,4

// 可以手动传递第三个参数给Array.from() 方法，从而指定映射函数内部的 this 值。
let helper = {
    diff: 1,
    add(value) {
    return value + this.diff;
    }
};
function translate() {
	return Array.from(arguments, helper.add, helper);
} 
let numbers = translate(1, 2, 3);
console.log(numbers); // 2,3,4
```

### 2.所有数组上的方法

#### 2.1 find() 与 findIndex() 

find() 与 findIndex() 方法均接受两个参数：一个回调函数、一个可选值用于指定回调函数内部的 this 。该回调函数可接收三个参数：数组的某个元素、该元素对应的索引位置、以及该数组自身。

```javascript
let numbers = [25, 30, 35, 40, 45];
console.log(numbers.find(n => n > 33)); // 35
console.log(numbers.findIndex(n => n > 33)); // 2
```

#### 2.2 fill() 方法 

```javascript
let numbers = [1, 2, 3, 4];
numbers.fill(1);
console.log(numbers.toString()); // 1,1,1,1

//指定位置
let numbers = [1, 2, 3, 4];
numbers.fill(1, 2);
console.log(numbers.toString()); // 1,2,1,1
numbers.fill(0, 1, 3);
console.log(numbers.toString()); // 1,0,0,1
```

#### 2.3 copyWithin() 方法 

copyWithin() 方法允许你在数组内部复制自身元素。为此你需要传递两个参数给 copyWithin() 方法：从什么位置开始进行填充，以及被用来复制的数据的起始位置索引。

```javascript
let numbers = [1, 2, 3, 4];
// 从索引 2 的位置开始粘贴
// 从数组索引 0 的位置开始复制数据
numbers.copyWithin(2, 0);
console.log(numbers.toString()); // 1,2,1,2

let numbers = [1, 2, 3, 4];
// 从索引 2 的位置开始粘贴
// 从数组索引 0 的位置开始复制数据
// 在遇到索引 1 时停止复制
numbers.copyWithin(2, 0, 1);
console.log(numbers.toString()); // 1,2,1,4
```



## 第十一章 Promise与异步编程

### 1.Promise的含义

每个 Promise 都会经历一个短暂的生命周期，初始为挂起态（pending state） ，这表示异步操作尚未结束。一个挂起的 Promise 也被认为是未决的（unsettled ） 。上个例子中的Promise 在 readFile() 函数返回它的时候就是处在挂起态。一旦异步操作结束， Promise就会被认为是已决的（settled ） ，并进入两种可能状态之一：

1. 已完成（fulfilled ） ： Promise 的异步操作已成功结束；
2. 已拒绝（rejected ） ： Promise 的异步操作未成功结束，可能是一个错误，或由其他原因导致。 

### 2.基本用法

```javascript
const promise = new Promise(function(resolve, reject) {
  // ... some code

  if (/* 异步操作成功 */){
    resolve(value);
  } else {
    reject(error);
  }
});


promise.then(function(value) {
  // success
}, function(error) {
  // failure
});

```

### 3.Promise.prototype.then()

romise 实例具有`then`方法，也就是说，`then`方法是定义在原型对象`Promise.prototype`上的。它的作用是为 Promise 实例添加状态改变时的回调函数。前面说过，`then`方法的第一个参数是`resolved`状态的回调函数，第二个参数（可选）是`rejected`状态的回调函数。

```javascript
getJSON("/post/1.json").then(function(post) {
  return getJSON(post.commentURL);
}).then(function funcA(comments) {
  console.log("resolved: ", comments);
}, function funcB(err){
  console.log("rejected: ", err);
});

//使用箭头函数
getJSON("/post/1.json").then(
  post => getJSON(post.commentURL)
).then(
  comments => console.log("resolved: ", comments),
  err => console.log("rejected: ", err)
);

```

### 4.Promise.prototype.catch()

```javascript
let promise = new Promise(function(resolve, reject) {
	throw new Error("Explosion!");
});
promise.catch(function(error) {
	console.log(error.message); // "Explosion!"
});

//等价于
let promise = new Promise(function(resolve, reject) {
try {
	throw new Error("Explosion!");
  } catch (ex) {
	reject(ex);
  }
});
promise.catch(function(error) {
	console.log(error.message); // "Explosion!"
});
```



### 5.Promise.prototype.finally()

`finally`方法用于指定不管 Promise 对象最后状态如何，都会执行的操作。该方法是 ES2018 引入标准的。`finally`方法总是会返回原来的值。

```javascript
promise
.then(result => {···})
.catch(error => {···})
.finally(() => {···});

// resolve 的值是 undefined
Promise.resolve(2).then(() => {}, () => {})

// resolve 的值是 2
Promise.resolve(2).finally(() => {})

// reject 的值是 undefined
Promise.reject(3).then(() => {}, () => {})

// reject 的值是 3
Promise.reject(3).finally(() => {})
```



### 6.Promise.all()

`Promise.all`方法用于将多个 Promise 实例，包装成一个新的 Promise 实例。

```javascript
const p = Promise.all([p1, p2, p3]);
```

上面代码中，`Promise.all`方法接受一个数组作为参数，`p1`、`p2`、`p3`都是 Promise 实例，如果不是，就会先调用下面讲到的`Promise.resolve`方法，将参数转为 Promise 实例，再进一步处理。（`Promise.all`方法的参数可以不是数组，但必须具有 Iterator 接口，且返回的每个成员都是 Promise 实例。）

`p`的状态由`p1`、`p2`、`p3`决定，分成两种情况。

（1）只有`p1`、`p2`、`p3`的状态都变成`fulfilled`，`p`的状态才会变成`fulfilled`，此时`p1`、`p2`、`p3`的返回值组成一个数组，传递给`p`的回调函数。

（2）只要`p1`、`p2`、`p3`之中有一个被`rejected`，`p`的状态就变成`rejected`，此时第一个被`reject`的实例的返回值，会传递给`p`的回调函数。

```javascript
let p1 = new Promise(function(resolve, reject) {
	resolve(42);
});
let p2 = new Promise(function(resolve, reject) {
	resolve(43);
});
let p3 = new Promise(function(resolve, reject) {
	resolve(44);
});
let p4 = Promise.all([p1, p2, p3]);
p4.then(function(value) {
    console.log(Array.isArray(value)); // true
    console.log(value[0]); // 42
    console.log(value[1]); // 43
    console.log(value[2]); // 44
});



let p1 = new Promise(function(resolve, reject) {
	resolve(42);
});
let p2 = new Promise(function(resolve, reject) {
	reject(43);
});
let p3 = new Promise(function(resolve, reject) {
	resolve(44);
});
let p4 = Promise.all([p1, p2, p3]);
p4.catch(function(value) {
    console.log(Array.isArray(value)) // false
    console.log(value); // 43
});

```

### 7.Promise.race()

`Promise.race`方法同样是将多个 Promise 实例，包装成一个新的 Promise 实例。

```javascript
const p = Promise.race([p1, p2, p3]);
```

上面代码中，只要`p1`、`p2`、`p3`之中**有一个实例率先改变状态**，`p`的状态就跟着改变。那个率先改变的 Promise 实例的返回值，就传递给`p`的回调函数。

```javascript
let p1 = Promise.resolve(42);
let p2 = new Promise(function(resolve, reject) {
	resolve(43);
});
let p3 = new Promise(function(resolve, reject) {
	resolve(44);
});
let p4 = Promise.race([p1, p2, p3]);
    p4.then(function(value) {
    console.log(value); // 42
});
```

### 8.Promise.resolve()

有时需要将现有对象转为 Promise 对象，`Promise.resolve`方法就起到这个作用。

```javascript
const jsPromise = Promise.resolve($.ajax('/whatever.json'));
```

上面代码将 jQuery 生成的`deferred`对象，转为一个新的 Promise 对象。

`Promise.resolve`等价于下面的写法。

```javascript
Promise.resolve('foo')
// 等价于
new Promise(resolve => resolve('foo'))
```

`Promise.resolve`方法的参数分成四种情况。

**（1）参数是一个 Promise 实例**

如果参数是 Promise 实例，那么`Promise.resolve`将不做任何修改、原封不动地返回这个实例。

**（2）参数是一个thenable对象**

`thenable`对象指的是具有`then`方法的对象，比如下面这个对象。

```javascript
let thenable = {
  then: function(resolve, reject) {
    resolve(42);
  }
};
```

`Promise.resolve`方法会将这个对象转为 Promise 对象，然后就立即执行`thenable`对象的`then`方法。

```javascript
let thenable = {
  then: function(resolve, reject) {
    resolve(42);
  }
};

let p1 = Promise.resolve(thenable);
p1.then(function(value) {
  console.log(value);  // 42
});
```

上面代码中，`thenable`对象的`then`方法执行后，对象`p1`的状态就变为`resolved`，从而立即执行最后那个`then`方法指定的回调函数，输出 42。

**（3）参数不是具有then方法的对象，或根本就不是对象**

如果参数是一个原始值，或者是一个不具有`then`方法的对象，则`Promise.resolve`方法返回一个新的 Promise 对象，状态为`resolved`。

```javascript
const p = Promise.resolve('Hello');

p.then(function (s){
  console.log(s)
});
// Hello
```

上面代码生成一个新的 Promise 对象的实例`p`。由于字符串`Hello`不属于异步操作（判断方法是字符串对象不具有 then 方法），返回 Promise 实例的状态从一生成就是`resolved`，所以回调函数会立即执行。`Promise.resolve`方法的参数，会同时传给回调函数。

### 9.Promise.reject()

**（4）不带有任何参数**

`Promise.resolve`方法允许调用时不带参数，直接返回一个`resolved`状态的 Promise 对象。

所以，如果希望得到一个 Promise 对象，比较方便的方法就是直接调用`Promise.resolve`方法。

```javascript
const p = Promise.resolve();

p.then(function () {
  // ...
});
```

上面代码的变量`p`就是一个 Promise 对象。

需要注意的是，立即`resolve`的 Promise 对象，是在本轮“事件循环”（event loop）的结束时，而不是在下一轮“事件循环”的开始时。

```javascript
setTimeout(function () {
  console.log('three');
}, 0);

Promise.resolve().then(function () {
  console.log('two');
});

console.log('one');

// one
// two
// three
```

上面代码中，`setTimeout(fn, 0)`在下一轮“事件循环”开始时执行，`Promise.resolve()`在本轮“事件循环”结束时执行，`console.log('one')`则是立即执行，因此最先输出。



## 第十二章 代理与反射接口

1.通过调用 new Proxy() ，你可以创建一个代理用来替代另一个对象（被称为目标） ，这个代理对目标对象进行了虚拟，因此该代理与该目标对象表面上可以被当作同一个对象来对待。 

| 代理陷阱                 | 被重写的行为                                                 | 默认行为                           |
| ------------------------ | ------------------------------------------------------------ | ---------------------------------- |
| get                      | 读取一个属性的值                                             | Reflect.get()                      |
| set                      | 写入一个属性                                                 | Reflect.set()                      |
| has                      | in 运算符                                                    | Reflect.has()                      |
| deleteProperty           | delete 运算符                                                | Reflect.deleteProperty()           |
| getPrototypeOf           | Object.getPrototypeOf()                                      | Reflect.getPrototypeOf()           |
| setPrototypeOf           | Object.setPrototypeOf()                                      | Reflect.setPrototypeOf()           |
| isExtensible             | Object.isExtensible()                                        | Reflect..isExtensible()            |
| preventExtensions        | Object.preventExtensions()                                   | Reflect.preventExtensions()        |
| getOwnPropertyDescriptor | Object.getOwnPropertyDescriptor()                            | Reflect.getOwnPropertyDescriptor() |
| defineProperty           | Object.defineProperty()                                      | Reflect.defineProperty()           |
| ownKeys                  | Object.keys 、 Object.getOwnPropertyNames() 与 Object.getOwnPropertySymbols() | Reflect.ownKeys()                  |
| apply                    | 调用一个函数                                                 | Reflect.apply()                    |
| construct                | 使用 new 调用一个函数                                        | Reflect.construct()                |

```javascript
// 创建简单代理对象
let target = {};
let proxy = new Proxy(target, {});
proxy.name = "proxy";
console.log(proxy.name); // "proxy"
console.log(target.name); // "proxy"
target.name = "target";
console.log(proxy.name); // "target"
console.log(target.name); // "target"
```

#### 1.使用 set 陷阱函数验证属性值 

1. trapTarget ：将接收属性的对象（即代理的目标对象） ；
2. key ：需要写入的属性的键（字符串类型或符号类型） ；
3. value ：将被写入属性的值；
4. receiver ：操作发生的对象（通常是代理对象） 。 

```javascript
let target = {
  name: "target"
};
let proxy = new Proxy(target, {
  set(trapTarget, key, value, receiver) {
// 忽略已有属性，避免影响它们
    if (!trapTarget.hasOwnProperty(key)) {
      if (isNaN(value)) {
        throw new TypeError("Property must be a number.");
      }
    }
    // 添加属性
    return Reflect.set(trapTarget, key, value, receiver);
  }
});
// 添加一个新属性
proxy.count = 1;
console.log(proxy.count); // 1
console.log(target.count); // 1
// 你可以为 name 赋一个非数值类型的值，因为该属性已经存在
proxy.name = "proxy";
console.log(proxy.name); // "proxy"
console.log(target.name); // "proxy"
// 抛出错误
proxy.anotherName = "proxy";
```

#### 2.使用 get 陷阱函数进行对象外形验证 

1. trapTarget ：将会被读取属性的对象（即代理的目标对象） ；
2. key ：需要读取的属性的键（字符串类型或符号类型） ；
3. receiver ：操作发生的对象（通常是代理对象） 。 

```javascript
let proxy = new Proxy({}, {
  get(trapTarget, key, receiver) {
    if (!(key in receiver)) {
      throw new TypeError("Property " + key + " doesn't exist.");
    }
    return Reflect.get(trapTarget, key, receiver);
  }
});
// 添加属性的功能正常
proxy.name = "proxy";
console.log(proxy.name); // "proxy"
// 读取不存在属性会抛出错误
console.log(proxy.nme); // 抛出错误
```

#### 3.使用 has 陷阱函数隐藏属性 

1. trapTarget ：需要读取属性的对象（即代理的目标对象） ；
2. key ：需要检查的属性的键（字符串类型或符号类型） 。 

```javascript
let target = {
  name: "target",
  value: 42
};
let proxy = new Proxy(target, {
  has(trapTarget, key) {
    if (key === "value") {
      return false;
    } else {
      return Reflect.has(trapTarget, key);
    }
  }
});
console.log("value" in proxy); // false
console.log("name" in proxy); // true
console.log("toString" in proxy); // true
```

#### 4.使用 deleteProperty 陷阱函数避免属性被删除 

1. trapTarget ：需要删除属性的对象（即代理的目标对象） ；
2. key ：需要删除的属性的键（字符串类型或符号类型） 。 

```javascript
let target = {
  name: "target",
  value: 42
};
let proxy = new Proxy(target, {
  deleteProperty(trapTarget, key) {
    if (key === "value") {
      return false;
    } else {
      return Reflect.deleteProperty(trapTarget, key);
    }
  }
});
// 尝试删除 proxy.value
console.log("value" in proxy); // true
let result1 = delete proxy.value;
console.log(result1); // false
console.log("value" in proxy); // true
// 尝试删除 proxy.name
console.log("name" in proxy); // true
let result2 = delete proxy.name;
console.log(result2); // true
console.log("name" in proxy); // false
```

## 第十三章 用模块封装代码

1. 模块代码自动运行在严格模式下，并且没有任何办法跳出严格模式；
2. 在模块的顶级作用域创建的变量，不会被自动添加到共享的全局作用域，它们只会在模块顶级作用域的内部存在；
3. 模块顶级作用域的 this 值为 undefined ； 
4. 对于需要让模块外部代码访问的内容，模块必须导出它们；
5. 允许模块从其他模块导入绑定。 

### 1.基本的导出

```javascript
// 导出数据
export var color = "red";
export let name = "Nicholas";
export const magicNumber = 7;
// 导出函数
export function sum(num1, num2) {
return num1 + num1;
} 
// 导出类
export class Rectangle {
constructor(length, width) {
this.length = length;
this.width = width;
}
} 
// 此函数为模块私有
function subtract(num1, num2) {
return num1 - num2;
} 
// 定义一个函数……
function multiply(num1, num2) {
return num1 * num2;
} 
// ……稍后将其导出
export { multiply };
```

### 2.基本的导入

```javascript
//导入绑定的列表看起来与对象解构相似，但实则并无关联。
import { identifier1, identifier2 } from "./example.js";


// 单个导入
import { sum } from "./example.js";
console.log(sum(1, 2)); // 3
sum = 1; // 出错 不能修改它的值

// 多个导入
import { sum, multiply, magicNumber } from "./example.js";
console.log(sum(1, magicNumber)); // 8
console.log(multiply(1, 2)); // 2

// 完全导入一个模块
import * as example from "./example.js";
console.log(example.sum(1,
example.magicNumber)); // 8
console.log(example.multiply(1, 2)); // 2

//只会执行一次
import { sum } from "./example.js";
import { multiply } from "./example.js";
import { magicNumber } from "./example.js";
```

然而要记住，无论你对同一个模块使用了多少次 import 语句，该模块都只会被执行一次。在导出模块的代码执行之后，已被实例化的模块就被保留在内存中，并随时都能被其他import 所引用。 尽管此处的模块使用了三个 import 语句，但 example.js 只会被执行一次。 

#### 2.1导入绑定的一个微妙怪异点

```javascript
export var name = "Nicholas";
export function setName(newName) {
	name = newName;
}

import { name, setName } from "./example.js";
console.log(name); // "Nicholas"
setName("Greg");
console.log(name); // "Greg"
name = "Nicholas"; // error

```

### 3.重命名导出与导入

```javascript
function sum(num1, num2) {
	return num1 + num2;
} 
export { sum as add };
import { add } from "./example.js";

import { add as sum } from "./example.js";
console.log(typeof add); // "undefined"
console.log(sum(1, 2)); // 3
```

### 4.模块的默认值

#### 4.1导出默认值

三种方式：

```javascript
// 方式一
export default function(num1, num2) {
	return num1 + num2;
}

// 方式二
function sum(num1, num2) {
	return num1 + num2;
} 
export default sum;

// 方式三
function sum(num1, num2) {
	return num1 + num2;
} 
export { sum as default };
```

efault 标识符有特别含义，既作为重命名导出，又标明了模块需要使用的默认值。由于default 在 JS 中是一个关键字，它就不能被用作变量、函数或类的名称（但它可以被用作属性名称） 。因此使用 default 来重命名一个导出是个特例，与非默认导出的语法保持了一致性。

#### 4.2导入默认值

```javascript
// 导入默认值
import sum from "./example.js";
console.log(sum(1, 2)); // 3
```

对于既导出了默认值、又导出了一个或更多非默认的绑定的模块，你可以使用单个语句来导入它的所有导出绑定。例如，假设你有这么一个模块：

```javascript
export let color = "red";
export default function(num1, num2) {
	return num1 + num2;
}


import sum, { color } from "./example.js";
console.log(sum(1, 2)); // 3
console.log(color); // "red"


// 等价于上个例子 重命名
import { default as sum, color } from "example";
console.log(sum(1, 2)); // 3
console.log(color); // "red
```

### 5.绑定的再导出

```javascript
export { sum } from "./example.js";

export { sum as add } from "./example.js";

export * from "./example.js";
```

使用完全导出，就可以导出目标模块的默认值及其所有具名导出，但这可能影响你从当前模块所能导出的值。例如，假设 example.js 具有一个默认导出，当你使用这种语法时，你就无法为当前模块另外再定义一个默认导出。 即不能同时有两个默认导出。

### 6.无绑定的导入

有些模块也许没有进行任何导出，相反只是修改全局作用域的对象。尽管这种模块的顶级变量、函数或类最终并不会自动被加入全局作用域，但这并不意味着该模块无法访问全局作用域。诸如 Array 与 Object 之类的内置对象的共享定义在模块内部是可访问的，并且对于这些对象的修改会反映到其他模块中。

例如，若你想为所有数组添加一个 pushAll() 方法，你可以像下面这样定义一个模块： 

```javascript
// 没有导出与导入的模块
Array.prototype.pushAll = function(items) {
// items 必须是一个数组
if (!Array.isArray(items)) {
	throw new TypeError("Argument must be an array.");
} 
// 使用内置的 push() 与扩展运算符
	return this.push(...items);
};
```

这是一个有效的模块，尽管此处没有任何导出与导入。此代码可以作为模块或脚本来使用。由于它没有导出任何东西，你可以使用简化的导入语法来执行此模块的代码，而无须导入任何绑定： 

```javascript
import "./example.js";
let colors = ["red", "green", "blue"];
let items = [];
items.pushAll(colors);
```

此代码导入并执行了包含 pushAll() 的模块，于是 pushAll() 就被添加到数组的原型上。这意味着现在 pushAll() 在当前模块内的所有数组上都可用。 

### 7.浏览器模块说明符方案

浏览器要求模块说明符应当为下列格式之一：

- 以 / 为起始，表示从根目录开始解析；
- 以 ./ 为起始，表示从当前目录开始解析；
- 以 ../ 为起始，表示从父级目录开始解析；
- URL 格式。 

```javascript
// 从 https://www.example.com/modules/example1.js 导入
import { first } from "./example1.js";
// 从 from https://www.example.com/example2.js 导入
import { second } from "../example2.js";
// 从 from https://www.example.com/example3.js 导入
import { third } from "/example3.js";
// 从 from https://www2.example.com/example4.js 导入
import { fourth } from "https://www2.example.com/example4.js";


// 无效：没有以 / 、 ./ 或 ../ 开始
import { first } from "example.js";
// 无效：没有以 / 、 ./ 或 ../ 开始
import { second } from "example/index.js";
```

