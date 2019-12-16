#  ECMAScript 6 基础
<nav>
<a href="#一变量声明">一、变量声明</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-var">1.1 var</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-let">1.2 let</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-const">1.3 const</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#14-暂时性死区">1.4 暂时性死区</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#15-循环体内的变量">1.5 循环体内的变量</a><br/>
<a href="#二字符串的扩展">二、字符串的扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-字符串方法">2.1 字符串方法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-模板字面量">2.2 模板字面量</a><br/>
<a href="#三函数的扩展">三、函数的扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-参数默认值">3.1 参数默认值</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-剩余参数">3.2 剩余参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-扩展运算符">3.3 扩展运算符</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-箭头函数">3.4 箭头函数</a><br/>
<a href="#四对象的扩展">四、对象的扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-对象字面量">4.1 对象字面量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-相等性判断">4.2 相等性判断</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-属性复制">4.3 属性复制</a><br/>
<a href="#五数组的扩展">五、数组的扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-创建数组">5.1 创建数组</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-数组方法">5.2 数组方法</a><br/>
<a href="#六解构">六、解构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-对象解构">6.1 对象解构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-数组解构">6.2 数组解构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-参数解构">6.3 参数解构</a><br/>
<a href="#七Symbol">七、Symbol</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#71-创建-Symbol">7.1 创建 Symbol</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#72-使用-Symbol">7.2 使用 Symbol</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#73-共享-Symbol">7.3 共享 Symbol</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#74-检索-Symbol">7.4 检索 Symbol</a><br/>
<a href="#八Set--与-Map">八、Set  与 Map</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#81-Set">8.1 Set </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#82-WeakSet">8.2 WeakSet</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#83-Map">8.3 Map</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#84-WeakMap">8.4 WeakMap</a><br/>
<a href="#九迭代器与生成器">九、迭代器与生成器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#91-迭代器">9.1 迭代器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#92-生成器">9.2 生成器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#93-for-of-循环">9.3 for-of 循环</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#94-内置迭代器">9.4 内置迭代器</a><br/>
<a href="#十类">十、类</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#101-类">10.1 类</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#102-继承">10.2 继承</a><br/>
<a href="#十一代理与反射">十一、代理与反射</a><br/>
<a href="#十二模块化">十二、模块化</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#121-基本导出">12.1 基本导出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#122-基本导出">12.2 基本导出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#123-导入路径">12.3 导入路径</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#124-导入导出重命名">12.4 导入导出重命名</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#125-导入导出默认值">12.5 导入导出默认值</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#126-导入再导出">12.6 导入再导出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#127-无绑定导入">12.7 无绑定导入</a><br/>
</nav>



## 一、变量声明

### 1.1 var

在 JavaScript 语言中，使用 `var` 关键字声明的变量，无论其实际声明位置在何处，都会被视为声明与所在函数的顶部；如果声明不在函数内，则视为在全局作用域的顶部，这就是所谓的变量提升：

```javascript
function test(flag) {
    if (flag) {
        var value = "blue";
        console.log(value);
    } else {
        console.log(value);
    }
    console.log(value);
}
```

由于变量提升的影响，以上的代码在效果上与下面的代码等效：

```javascript
function test(flag) {
    // 提升到函数顶部
    var value;
    if (flag) {
        value = "blue";
        console.log(value);
    } else {
        console.log(value);
    }
    console.log(value);
}
```

同样，由于变量提升的影响，你在函数外部声明的变量可能会覆盖原有的全局变量：

```javascript
var RegExp = "Hello!";
console.log(window.RegExp);  // Hello!
console.log(window.RegExp === RegExp); // true
```

为了改变这一影响， ES6 引入了 `let` 关键字。

### 1.2 let

`let` 关键字具有以下作用：

1. 使用 `let` 关键字声明的变量具有块级作用域；

```javascript
function test(flag) {
    if (flag) {
        let value = "blue";  // value的作用域被限制在该{}所包裹的代码块中
        console.log(value);
    } else {
        console.log(value); //value在此处不能访问
    }
    console.log(value);     //value在此处不能访问
}
```

2. 禁止重复声明变量：

```javascript
let value = "blue"; 
let value = "blue";  // 不被允许，会抛出异常 Identifier 'value' has already been declared
```

3. 在函数体外部声明的变量不会覆盖原有的同名的全局变量，只能将其屏蔽：

```javascript
let RegExp = "Hello!";
console.log(RegExp); // Hello! 屏蔽原有的全局变量
console.log(window.RegExp === RegExp); // false 但不会将其覆盖
```

### 1.3 const

ES6 中新增了 `const` 关键字，用于声明不可变的常量，它类似于 Java 语言中的 `final` 关键字，具有如下特性：

+ 使用 `const` 关键字修饰的变量在声明时必须指定初始化的值，并且该变量不可以再被重新赋值；
+ 使用 `const` 关键字修饰的变量同样具备块级作用域；
+ 同样可以禁止重复声明变量；
+ 和 Java 语言类似，如果 `const` 修饰的是对象，此时你仍然可以修改对象的属性：

```javascript
const author = {
    name: "heibai",
};
author.name = "ying"; // 可以修改对象的属性
console.log(author);  // 但不可以对 const 修饰的常量进行重新赋值
author = {
    name: "heibaiying"
};
```

### 1.4 暂时性死区

和 `var` 关键字不同，使用 `let` 和 `const` 关键字声明的变量，在达到声明处之前都是无法访问的：

```javascript
(function test() {
    console.log(typeof value); // ReferenceError: value is not defined
    let value = "blue";  // 下面的语句都不会被输出
    console.log(value);
})();
```

在 value 所在的块级作用域中，如果还没有到达 value 声明行，此时的 value 会被存放在称为 “暂时性死区” 的区域中，只有在 value 声明行之后，该值才会被移出 “暂时性死区”。注意，这里强调的是在 value 所在的块级作用域中， 如果不是在 value 所在的块级作用域中，是不会存在暂时性死区：

```javascript
console.log(typeof value);  // undefined
(function test() {
    let value = "blue"; 
    console.log(value); // blue
})();
```

### 1.5 循环体内的变量

如果在循环体中使用 `var` 变量，其仍然会被提升到全局，这意味着它可以在循环体外部被使用：

```javascript
for (var i = 0; i < 10; i++) {
}

console.log(i); // i 在此处仍然可被访问,值为 10，如果使用的是 let 则不会有类似情况
```

同样的原因，如果在循环体内创建函数，并且函数持有对 i 变量的引用，也会导致同样的问题：

```javascript
let list = [];
for (var i = 0; i < 10; i++) {
    list.push(function () {
        console.log(i);
    });
}
list.forEach(function (func) {
    func();
});
// 输出 10 次 10
```

如果使用 `let` 关键字进行修饰，则每一次循环都会创建一个 i 的副本：

```javascript
let list = [];
for (let i = 0; i < 10; i++) {
    list.push(function () {
        console.log(i);
    });
}
list.forEach(function (func) {
    func();
});
// 输出 0 到 9
```



## 二、字符串的扩展

### 2.1 字符串方法

**1. 识别子字符串**

+ **startsWith(searchString, position)**：字符串是否以指定的子串开头；
+ **endsWith(searchString, endPosition)**：字符串是否以指定的子串结尾；
+ **includes(searchString, position)**：字符串是否包含指定的子串。

它们都接收两个参数：第一个参数代表需要查找的子字符串；第二个是可选参数，代表开始查找的起始位置或结束位置。

```javascript
let msg = "Hello world!";
console.log(msg.startsWith("Hello")); // true
console.log(msg.endsWith("!")); // true
console.log(msg.includes("o")); // true
console.log(msg.startsWith("o", 4)); // true
console.log(msg.endsWith("o", 8)); // true
console.log(msg.includes("o", 8)); // false
```

**2. 复制字符串**

ES6 新增了 `repeat()` 方法用于复制字符串：

```javascript
console.log("hello".repeat(2));
```

**3. 填充字符串**

+ **padStart(maxLength, fillString)**：左填充；
+ **padEnd(maxLength, fillString)**：右填充。

它们都接收两个参数：第一个参数表示字符串填充后的长度，如果该长度小于原有字符串的长度，则不做任何操作；第二个是可选参数，代表用于填充的字符串，如果不指定，则为空字符串：

```javascript
'x'.padStart(5, 'ab');  // 'ababx'
'x'.padEnd(5, 'ab');  // 'xabab'

'xxx'.padStart(2, 'ab');  // 'xxx'
'x'.padStart(4); // '   x'
```

### 2.2 模板字面量

在 ES6 中，你可以使用 **\` \`** 来创建模板字面量，它具有以下特性：

+ 支持在内部使用 `${}` 来引用变量或有效的 JS 表达式；
+ 支持多行字符串。

```java
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
console.log(message04);     // Hello,
                          // my name is Nicholas.
```



## 三、函数的扩展

### 3.1 参数默认值

ES6 中支持为函数的参数指定默认值，该默认值可以是基本类型，也可以是函数，甚至可以是函数的返回值。当参数指定了默认值后，当且仅当该参数未传递值或传递的值为 `undefined` 时，该默认值才会被使用：

```javascript
function request(url, timeout = 2000, callback = function() {}) {
    console.log(`url: ${url}, timeout: ${timeout}`);
    callback();
}

request("GitHub"); // url: GitHub, timeout: 2000
request("GitHub", undefined); // url: GitHub, timeout: 2000
request("GitHub", null); // url: GitHub, timeout: null
request("GitHub", 5000);  // url: GitHub, timeout: 5000
request("GitHub", 5000, () => console.log("超时异常")); // url: GitHub, timeout: 5000 超时异常
```

特别情况下，一个参数的默认值可以是另一个参数：

```javascript
function test01(first, second = first) {
    console.log(`first: ${first}, second: ${second}`);
}
```

此时需要注意避免暂时性死区问题，假设将上面的函数做如下修改：

```javascript
function test02(first = second, second) {
    console.log(`first: ${first}, second: ${second}`);
}

test02(undefined,2); // ReferenceError: second is not defined
test02(1,2);
```

当第一个参数传递 `undefined` 时，first 需要等于其默认值 second，但 second 尚未赋值完成，仍存在于暂时性死区当中，此时就会抛出引用异常，这就是函数参数的暂时性死区。

### 3.2 剩余参数

和 Java 语言类似，ES6 支持使用 `...` 来表示剩余参数，示例如下：

```javascript
function each(...elements) {
    elements.forEach((element) => console.log(element));
}

test(1, 2, 3, 4, 5);
```

需要注意的是 ES6 的剩余参数有以下两个限制：

+ 一个函数只能有一个剩余参数，并且它必须声明在最后；
+ 剩余参数不能在对象字面量的 setter 属性中使用。

```javascript
let object = {
    set name(...value) { // 异常：Setter function argument must not be a rest parameter
    }
};
```

### 3.3 扩展运算符

剩余参数允许用户把多个独立的参数合并到一个数组中；而扩展运算符则允许将一个数组中各个项作为分离的参数传给函数：

```javascript
function each(...elements) {
    elements.forEach((element) => console.log(element));
}

let list = [1, 2, 3, 4, 5];
each(list);    // 输出：[ 1, 2, 3, 4, 5 ]
each(...list); 
// 输出：
1
2
3
4
5
```

### 3.4 箭头函数

ES6 支持和 Java 8 类似的箭头函数，它具有以下特性：

- 箭头函数没有 `[[Construct]]` 方法，因此不能被用作构造函数，即不能使用 `new` 关键字调用；
- 没有原型，也就是没有 `prototype` 属性；
- 箭头函数不允许拥有重复的具名参数；
- 没有 `arguments` 对象，你必须使用具名参数或剩余参数来进行定义。但它能访问包含它的函数的 `arguments` 对
  象，此后无论箭头函数在何处执行，该对象都是不变的；
- 没有 `this`、`super` 、`arguments` 等属性，也没有 `new.target` 绑定； `this`、`super` 、`arguments`以及函数内部的 `new.target` 由所在的，最近的非箭头函数来决定；
- 如果箭头函数被包含在一个非箭头函数内，那么箭头函数的 `this` 值就等于该非箭头函数的 `this` 值；否则，`this` 就表示全局对象（在浏览器中是 window  ，在 Node.js 中是 global ）。`this` 的值在函数内部不能被修改，在函数的整个生命周期会保持不变。

```javascript
let doNothing01 = () => {};
// 等效箭头表达式：
let doNothing02 = function() {};

let reflect01 = value => value;
//  等效箭头表达式：
let reflect02 = function (value) {
    return value;
};

let sum01 = (num1, num2) => num1 + num2;
//  等效箭头表达式：
let sum02 = function (num1, num2) {
    return num1 + num2;
};

let getDetail01 = id => ({id: id, name: "heibaiying"});
// 等效箭头表达式：
let getDetail02 = function (id) {
    return {
        id: id,
        name: "heibaiying"
    };
};

function test() {
    // // 箭头函数能访问包含它的函数的arguments
    return () => arguments[0]; 
}
let arrowFunction = test("hello");
console.log(arrowFunction());  // hello
```



## 四、对象的扩展

### 4.1 对象字面量

在 ES5 或其他语言中，我们常常存在下面的写法：

```javascript
function createPerson(name, age) {
    return {
        name: name,
        age: age
    };
}
```

此时对象的属性名与函数的参数名完全相同，该书写方式显得过于冗余。在 ES6 之后，当对象的属性名与本地变量名相同时，我们可以省略冒号和值：

```javascript
function createPerson(name, age) {
    return {
        name,
        age
    };
}
```

同样的语法精简还出现在为对象字面量方法赋值时，在 ES5 及更早的版本中，写法如下：

```javascript
var person = {
    name: "Nicholas",
    sayName: function() {
        console.log(this.name);
    }
};
```

在 ES6 之后，可以省略冒号和 `function` 关键字：

```javascript
var person = {
    name: "Nicholas",
    sayName() {
        console.log(this.name);
    }
};
```

### 4.2 相等性判断

在 ES5 之前，我们通常使用 `===` 进行相等性判断，它能满足大多数的使用场景，但也会出现一些不准确的结果：

```java
-0 === +0 //true
NaN === NaN //false
```

大多数时候，我们并不需要区分出正负零，但在有的计算中是有必要进行区分的，如下分别使用正负零得到的是完全相反的结果：

```javascript
1/0 // Infinity
1/-0 // -Infinity
```

为了满足这种需求，ES6 引入了 `Object.is()` ，它在效果上类似于 `===` 运算符，但能准确的区分正负零和 NaN 的等值比较：

```javascript
Object.is(+0, -0) // false
Object.is(NaN, NaN) // true
Object.is(5, 5) // true
Object.is(5, "5") // false
```

### 4.3 属性复制

ES6 中引入了 `Object.assign()`，它在效果上类似于 jQuery 库中的 extend 方法，方法的定义如下：

```javascript
assign<T, U>(target: T, source: U): T & U;
assign<T, U, V>(target: T, source1: U, source2: V): T & U & V;
assign<T, U, V, W>(target: T, source1: U, source2: V, source3: W): T & U & V & W;
assign(target: object, ...sources: any[]): any;
```

其中第一个参数是目标对象，后面的参数都是待复制的源对象。`Object.assign()` 方法具有如下特性：

1. 能够将源对象（source）的所有可枚举属性，复制到目标对象（target）：

```javascript
const target = { a: 1 };
const source1 = { b: 2 };
const source2 = { c: 3 };

Object.assign(target, source1, source2);
target // {a:1, b:2, c:3}
```

2. 如果目标对象与源对象之间有同名属性，或者多个源对象间有同名属性，不论该属性的值是基本类型还是对象，后面的属性都会覆盖前面的属性：

```javascript
const target = { a: 1, b: 1 };
const source1 = { b: 2, c: 2 };
const source2 = { c: 3 };

Object.assign(target, source1, source2);
target  // {a:1, b:2, c:3}
```

3. 该方法执行的是浅拷贝，而不是深拷贝，这意味着如果源对象的某个属性的值是对象，那么拷贝的是该对象的引用：

```javascript
const obj1 = {a: {b: 1}};
const obj2 = Object.assign({}, obj1);

obj1.a.b = 2;
obj2.a.b // 2
```

4. `Object.assign()` 可以用来处理数组，但它会把数组当做对象，而不是拷贝源数组中的值到目标数组：

```javascript
Object.assign([1, 2, 3], [4, 5])    // [4, 5, 3]
```

5. `Object.assign()` 只能进行值的复制，如果要复制的值是一个取值函数，那么将会求值后再复制：

```javascript
const source = {
  get foo() { return 1 }
};
const target = {};

Object.assign(target, source)  // { foo: 1 }
```



## 五、数组的扩展

### 5.1 创建数组

+ **Array.of()** ：基于指定元素创建数组；
+ **Array.from()** ：基于一个可迭代对象创建数组，并支持传递转换函数。

```javascript
let items = Array.of(1, 2);
console.log(items);

let numbers = Array.from([1, 2, 3, 4, 5], (value) => value * 10);
console.log(numbers); // [ 10, 20, 30, 40, 50 ]
```

### 5.2 数组方法

**1. find() 与 findIndex()**

+ **find()** ：查找首个符合条件的元素；
+ **findIndex()** ：查找首个符合条件的元素的位置。

```javascript
let numbers = [25, 30, 35, 40, 45];
console.log(numbers.find(n => n > 33)); // 35
console.log(numbers.findIndex(n => n > 33)); // 2
```

**2. fill() 方法**

 该方法能使用指定的值填充数组中的一个或多个元素：

```javascript
let numbers = [1, 2, 3, 4];
// 使用指定的数值填充
numbers.fill(1);
console.log(numbers.toString()); // 1,1,1,1

let numbers = [1, 2, 3, 4];
// 指定填充的起始位置
numbers.fill(1, 2);
console.log(numbers.toString()); // 1,2,1,1
// 指定填充的起始位置和结束位置
numbers.fill(0, 1, 3);
console.log(numbers.toString()); // 1,0,0,1
```

**3. copyWithin() 方法**

`fill()` 方法是使用外部元素来填充数组，`copyWithin()` 则是使用数组自身的元素来填充数组：

```javascript
let numbers = [1, 2, 3, 4];
// 从数组索引为 0 的位置开始复制数据，从索引为 2 的位置开始粘贴
numbers.copyWithin(2, 0);
console.log(numbers.toString()); // 1,2,1,2

let numbers = [1, 2, 3, 4];
// 从 [0,1) 位置开始复制数据，从索引为 2 的位置开始粘贴
numbers.copyWithin(2, 0, 1);
console.log(numbers.toString()); // 1,2,1,4
```



## 六、解构

ES6 允许按照一定模式，从数组和对象中提取值来对变量进行赋值，这被称为解构（Destructuring）。

### 6.1 对象解构

对象解构的基本使用方式如下：

```javascript
let person = {
    name: "heibaiying",
    age: 18
};
let {name, age} = person;
console.log(name); // "heibaiying"
console.log(age); // "18"
```

ES6 还支持为待解构的变量传入默认值：

```javascript
let person = {
    name: "heibaiying",
    age: 18
};
let {name, age, occupation = "programmer"} = person;
console.log(occupation); // programmer
```

通常情况下，待解构的变量名必须和对象中的属性名相同，当然你也可以自定义待解构变量的名称：

```javascript
let person = {
    name: "heibaiying",
    age: 18
};
let {name: myName, age: myAge, occ: occupation = "programmer"} = person;
console.log(myName);
console.log(myAge);
console.log(occupation);
```

解构除了可以用于简单对象外，还可以用于存在嵌套结构的复杂对象：

```javascript
let person = {
    name: "heibaiying",
    age: 18,
    teacher: {
        name: "heibai"
    }
};
let {teacher: {name: teacherName}} = person;
console.log(teacherName); //  "heibai"
```

### 6.2 数组解构

数组解构和对象解构类似，其基本使用方式如下：

```java
let colors = ["red", "green", "blue"];
let [firstColor, secondColor] = colors;
console.log(firstColor); // "red"
console.log(secondColor); // "green"

let colors = ["red", "green", "blue"];
let [, , thirdColor] = colors;
console.log(thirdColor); // "blue
```

和对象解构一样，数组解构也支持设置默认值和嵌套解构：

```java
// 设置默认值
let [firstColor, secondColor = "green"] = ["red"];
console.log(firstColor); // "red"
console.log(secondColor); // "green"

// 嵌套解构
let colors = ["red", ["green", "lightgreen"], "blue"];
let [firstColor, [secondColor]] = colors;
console.log(firstColor); // "red"
console.log(secondColor); // "green"
```

数组解构还可以配合剩余参数来使用，示例如下：

```javascript
let colors = ["red", "green", "blue"];
let [firstColor, ...restColors] = colors;
console.log(firstColor); // "red"
console.log(restColors.length); // 2
console.log(restColors[0]); // "green"
console.log(restColors[1]); // "blue"
```

通过该特性，我们还可以简便地实现数组的克隆：

```javascript
let colors = ["red", "green", "blue"];
let [...clonedColors] = colors;
console.log(clonedColors); // "[red,green,blue]"
```

数组解构的一个典型应用是可以用来快速交换变量的值。在排序算法中，我们常常需要交换两个变量的值，在 ES6 之前我们通常都是使用中间变量来实现的，示例如下：

```javascript
let a = 1, b = 2, tmp;
tmp = a;
a = b;
b = tmp;
```

利用数组解构的特性，则可以简写如下：

```javascript
let a = 1, b = 2;
[a, b] = [b, a];
```

### 6.3 参数解构

在 ES5 中，如果我们想要为一个函数传递大量可选值，通常会为其定义一个对象参数来进行包装，示例如下：

```javascript
function setCookie(name, value, options) {
    options = options || {};
    let secure = options.secure,
    path = options.path,
    domain = options.domain,
    expires = options.expires;
    .....
}
```

其缺点在于此时我们无法直观的知道 options 中可以包含哪些值。使用参数解构就可以有效避免这个问题：

```javascript
function setCookie(name, value, {secure, path, domain, expires} = {}) {
    console.log(`secure: ${secure}, path: ${path}, domain:${domain}, expires:${expires}`)
}

setCookie("type", "js", {
    secure: true,
    expires: 60000
});   // secure: true, path: undefined, domain:undefined, expires:60000
```

需要注意的是被解构的参数是必传参数，不传递时就会抛出解构异常，所以最好和上面一样为其指定一个空对象的默认值。同时和对象解构，数组解构一样，参数解构也支持设置默认值，示例如下：

```javascript
function setCookie02(name, value,
                     {
                         secure = false,
                         path = "/",
                         domain = "example.com",
                         expires = new Date(Date.now() + 360000000)
                     } = {} ) {
}
```



## 七、Symbol

ES6 引入了一种新的数据类型 `Symbol`，用于表示独一无二的值。

### 7.1 创建 Symbol

```javascript
let s = Symbol();
typeof s //symbol
```

在创建时还可以为其传入描述信息：

```javascript
let symbol = Symbol("name");
symbol.toString(); // Symbol(name)
```

### 7.2 使用 Symbol

由于每一个 Symbol 值都是不相等的，这意味着 Symbol 值可以用于对象的属性名，这可以有效避免同名属性，也可以保证属性名不被外部覆盖重写：

```javascript
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
```

### 7.3 共享 Symbol

每一个 Symbol 都是独一无二的，即便它们具有相同的描述：

```javascript
let symbol01 = Symbol();
let symbol02 = Symbol();
console.log(symbol01 === symbol02); // false

let symbol03 = Symbol("name");
let symbol04 = Symbol("name");
console.log(symbol03 === symbol04); // false
```

如果你想要创建一个全局共享的 Symbol，可以使用 `Symbol.for()`， 该方法首先会搜索全局符号注册表，看是否存在一个指定 key 的符号值。若存在，该方法会返回这个已存在的符号值；否则，会创建一个新的符号值，并使用该 key 将其记录到全局符号注册表中，然后再返回这个新的符号值：

```javascript
let symbol05 = Symbol.for("age");
let symbol06 = Symbol.for("age");
console.log(symbol05 === symbol06);  // true
console.log(symbol05);  // Symbol(age)
```

### 7.4 检索 Symbol

传统的 `Object.keys()` 与 `Object.getOwnPropertyNames()` 方法都不能检索到对象的 Symbol 类型的属性，想要检索到对象 Symbol 类型属性，需要使用 `Object.getOwnPropertySymbols()` 方法：

```javascript
function getPerson(name, age) {
    return {
        name,
        age,
        [Symbol("createTime")]: Date.now()
    }
}

let person = getPerson("heibaiying", 10);
let symbols = Object.getOwnPropertySymbols(person); // 获取符号类型的属性
person[symbols[0]] = 1000; // 修改符号类型的属性
console.log(person[symbols[0]]);  // 1000
```



## 八、Set  与 Map

### 8.1 Set 

**1. 基本使用**

ES6 新增了 Set 集合类型用于存储不重复的元素。它具有以下特性：

+ 可以使用 `add()` 方法来添加元素，如果对应的元素在 Set 中不存在，则添加；如果对应的元素存在，则不作任何操作。Set 判断值重复时不会进行强制类型的转换；
+ 支持使用现有的数组来创建 Set，它会对其中的重复元素进行自动去重；
+ 支持使用 `delete()` 来移除某个元素；支持使用 `clear()` 来清空所有元素；支持使用 `has()` 来判断某个元素是否存在；
+ 支持使用 `forEach()` 进行遍历；
+ Set 对其中的对象持有强引用。

```javascript
let set01 = new Set([1, 2, 3, 4, 5, 5, 5, 5]);
set01.add("5"); // set认为5和"5"是两个不同的元素
set01.has("5");
set01.delete("5");
set01.clear();
```

**2. foreach 循环**

Set 在使用 `forEach()` 进行遍历时，会接收三个参数：

```javascript
(value: T, value2: T, set: Set<T>) 
```

 第一个参数和第二个参数都是 Set 中的元素，第三个参数代表 Set 本身：

```javascript
let set03 = new Set(["hei", "bai", "ying"]);
set03.forEach(function (value, key, ownerSet) {
    console.log(key + " " + value);
    console.log(ownerSet === set03);
});
// hei hei
// true
// bai bai
// true
// ying ying
// true
```

如果想要在 forEach 循环中使用当前作用域的 `this` ， 可以通过为 forEach 传递第二个参数或使用箭头函数来进行实现：

```javascript
let Set04 = new Set([1, 2]);
let processor = {
    // 输出方法
    output(value) {
        console.log(value);
    },
    process(dataSet) {
        dataSet.forEach(function (value) {
            this.output(value); // 调用this指代对象的输出方法
        }, this);
        // 1. 给forEach()传入一个this作为第二个参数
    }
};
processor.process(Set04);

// 2. 使用箭头函数，箭头函数的this由包含它的第一个非箭头函数来决定
let set05 = new Set([1, 2]);
let processor = {
    output(value) {
        console.log(value);
    },
    process(dataSet) {
        dataSet.forEach((value) => this.output(value));
    }
};
processor.process(set05);
```

**3. 对象强引用**

Set 对内部存储的对象持有的是强引用，这意味只要对于 Set 实例的引用存在，所存储的对象就无法被垃圾回收机制回收，从而无法释放内存：

```javascript
let set07 = new Set(),
    item = {name: "heibaiying"};
set07.add(item);
item = null;
// 将item置为null,其所指向的对象 {name: "heibaiying"} 仍然不会被垃圾回收，因为其还被Set所持有
console.log([...set07][0]); //{ name: 'heibaiying' }
```

为了解决这个问题，ES 6 引入了 WeakSet ，它对存储在其中的对象持有的是弱引用。

### 8.2 WeakSet

WeakSet 和 Set 类似，支持 `add()`、`has()` 以及 `delete()` 方法，但存在诸多限制：

- `add()` 只能用于添加对象，不能用于添加基本类型的值；
- 不可迭代，不能被用在 `for-of` 循环中；
- 没有对外暴露任何迭代器（例如 `keys()` 与 `values()` 方法），因此无法知晓其内容；
- 没有 `forEach()` 方法；
- 没有 `size`属性。

因为其存在诸多的限制，所以只有在特别关心内存的情况下才应使用它。

### 8.3 Map

ES6 中新增了 Map 类型用于存储键值对，和大多数语言中的 Map 类型类似，并没有太多特别之处，基本使用如下：

```javascript
// 1.基本使用
let map01 = new Map();
map01.set("name", "Nicholas");
map01.set("age", 25);
map01.delete("name");
map01.clear();

// 2.由数组初始化map
let map02 = new Map([["name", "Nicholas"], ["age", 25]]);
console.log(map02.get("name")); // "Nicholas"
console.log(map02.get("age")); // 25
console.log(map02.size); // 2

// 3.进行遍历
let map03 = new Map([["name", "Nicholas"], ["age", 25]]);
map03.forEach(function (value, key, ownerMap) {
    console.log(key + " " + value);
    console.log(ownerMap === map03);
});
```

### 8.4 WeakMap

WeakMap 和上面的 WeakSet 类似，用于解决 Map 存在的强引用问题。它要求所有的键都必须是除 null 以外的任意对象，支持使用 `set()`，`get()`，`has()`，`delete()` 等方法，但不支持 `clear()` 方法 和 `size` 属性，也不能使用 `forEach()` 进行循环。



## 九、迭代器与生成器

### 9.1 迭代器

在其他语言中，集合类都直接或间接实现了迭代器接口，用于实现集合元素的遍历。在 ES6 之前，如果想要实现类似 Java 语言中的 Iterator 迭代器，可以通过如下的代码来实现：

```javascript
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
```

### 9.2 生成器

在 ES6 之后提供了新的方式来快速创建迭代器，这就是生成器。生成器（generator）是能返回一个迭代器的函数，它由放在 `function` 关键字后的一个星号（ * ）来表示 。下面使用生成器对上面的迭代器进行改写：

```javascript
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
```

迭代器内部支持新的关键字 `yield` ：每当遇到 `yield`，循环就会停止；而当 iterator 上的 `next()` 方法被调用，循环就会再次执行到 `yield` 语句处。`yield` 的基本使用如下：

```javascript
function * getIterator() {
    yield 1;
    yield 2;
    yield 3;
}
let iterator = getIterator();
console.log(iterator.next().value); // 1
console.log(iterator.next().value); // 2
console.log(iterator.next().value); // 3
```

通过上面介绍的 `yield` 和生成器方法，在 ES6 中就可以快速的创建迭代器。

### 9.3 for-of 循环

ES6 中的大多数集合都支持使用 for-of 循环，示例如下：

```javascript
let colors = ["red", "green", "blue"];
for (let color of colors){
    console.log(color)
}
```

一个对象能使用 for-of 循环，首先代表该对象是可迭代的，而决定一个对象是否可以迭代，主要是看其是否包含 `Symbol.iterator` 属性，该属性的值是一个生成器对象。如果我们想要让自定义的对象可以使用 for-of 循环，则需要指定该属性：

```javascript
let collection = {
    items: [],
    * [Symbol.iterator]() {
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

### 9.4 内置迭代器

ES6 的内置迭代器大致可以分为三种：

**1. 集合迭代器**

ES6 中的数组、 Map 与 Set 都拥有下面三种的迭代器：

- **entries()**：返回一个包含键值对的迭代器；
- **values()**：返回一个包含集合中的值的迭代器；
- **keys()**：返回一个包含集合中的键的迭代器：对于数组类型，其下标 index 就是对应的键；对于 Set 类型，因为元素不重复，所以元素既是键也是值。

当 for-of 循环没有显式指定迭代器时，每种集合类型都有一个默认的迭代器：`values()`  方法是 数组 与 Set 的默认迭代器，而 `entries()` 方法则是 Map 默认的迭代器。示例如下：

```javascript
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
```

**2. NodeList 的迭代器**

随着默认迭代器被附加到 ES6 ， DOM 关于 NodeList 的规定也包含了一个默认迭代器（此规定在 HTML 规范而非 ES6 规范中），其表现方式与数组的默认迭代器一致：

```javascript
var divs = document.getElementsByTagName("div");
for (let div of divs) {
    console.log(div.id);
}
```

**3. 字符串迭代器**

```javascript
let message = "abc";
for (let i = 0; i < message.length; i++) {
    console.log(message[i]);
}
// a
// b
// c
```



## 十、类

### 10.1 类

ES6 开始支持类，它在语法上与 Java 语言类似，具有以下特性：

- 和 `let` 相似，类的声明不会被提升，因此在程序执行到声明处之前，类都会存在于暂时性死区中；
- 类声明中的所有代码会自动运行在严格模式下，并且无法退出严格模式；
- 类的所有方法都是不可枚举的；
- 类的所有方法内部都没有 `[[Construct]]` ，因此不能使用 `new` 来进行调用；
- 调用类构造器时必须使用 `new` 关键字。

ES6 中的类和函数一样，是一等公民，这意味着它能作为参数传给函数、能作为函数返回值、能用来给变量赋值。其基本使用如下：

```javascript
class Employee {

    /*构造器*/
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    /*实例方法*/
    sayName() {
        console.log("员工：" + this.name);
    }

    /*静态方法*/
    static create(name) {
        return new Employee(name);
    }
}

let employee = new Employee("heibai");
employee.sayName();
```

### 10.2 继承

和 Java 语言一样，ES6 使用 `extends` 来实现继承，支持使用 `super` 关键字来引用父类的属性和方法，支持覆盖重写父类原有的方法：

```javascript
class Manager extends Employee {

    /*覆写原有的方法*/
    sayName() {
        console.log("领导：" + this.name);
    }
}

let manager = new Manager("ying");
manager.sayName();
```

特别的是ES6 的 `extends` 后面可以接受任意类型的表达式，只要该表达式能够返回一个具有 `[[Construct]]` 属性以及原型的函数，你就可以对其使用 `extends`，基于该特性可以很方便的实现动态继承：

```javascript
function getBase(flag) {
    if (flag) {
        return Manager;
    } else {
        return Employee;
    }
}

class CEO extends getBase(true) {
}

let ceo = new CEO();
console.log(ceo instanceof Manager);
```



## 十一、代理与反射

ES6 支持对象代理，你可以通过 `new Proxy(target)` 来基于目标对象创建一个代理对象，这个代理对象对目标对象进行了虚拟，因此该代理对象与目标对象在表面上可以被当作同一个对象来对待：

```javascript
let target = {};
let proxy = new Proxy(target, {});
proxy.name = "proxy";
console.log(proxy.name); // "proxy"
console.log(target.name); // "proxy"
target.name = "target";
console.log(proxy.name); // "target"
console.log(target.name); // "target"
```

ES6 引入代理的真正作用是：允许用户拦截在目标对象上的底层操作。假设我们需要对身份证信息的写入和读取行为进行拦截，你可以利用代码进行高层次的拦截，也可以利用代理在底层进行拦截，示例如下：

```javascript
let person = {
    name: "heibai",
    idCard: null
};
// 建立代理
let proxy = new Proxy(person, {
    // 拦截写入操作
    set(target, propertyKey, value, receiver) {
        // 对输入的合法性进行校验
        if (propertyKey === "idCard" && value.length !== 18) {
            throw new Error("输入的身份证长度必须为18位");
        }
        // 调用反射进行修改
        return Reflect.set(target, propertyKey, value, receiver);
    },
    // 拦截读取操作
    get(target, propertyKey, receiver) {
        if (propertyKey === "idCard") {
            throw new Error("身份证是私密信息，无权读取");
        }
        //  调用反射获取值
        return Reflect.get(target, propertyKey, receiver);
    }
});
proxy.name = "ying";
console.log(proxy.name);
proxy.idCard = "123456789123456789";
console.log(proxy.idCard);
```

ES6 支持对底层的多种行为进行代理，具体如下：

| 可代理的底层操作         | 底层操作对应的外部行为                                       | 对应的反射方法                     |
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
| ownKeys                  | Object.keys，Object.getOwnPropertyNames() 与 <br/>Object.getOwnPropertySymbols() | Reflect.ownKeys()                  |
| apply                    | 调用一个函数                                                 | Reflect.apply()                    |
| construct                | 使用 new 调用一个函数                                        | Reflect.construct()                |



## 十二、模块化

从 ES6 开始，JavaScript 开始支持模块化加载，相比于传统的 JS 脚本，模块化 JS 具有以下特性：

- 模块中的代码自动运行在严格模式下，并且无法退出严格模式；
- 在模块顶级作用域中创建的变量，不会被自动添加到共享的全局作用域，它们只会在模块顶级作用域内部存在；
- 模块顶级作用域的 `this` 值为 undefined ；
- 模块中的内容只有使用 `export` 导出后才能被外部访问；
- 允许使用 `import` 从其他模块导入绑定。

### 12.1 基本导出

使用 `export` 可以进行基本的导出：

```javascript
// 1.导出变量或常量
export var color = "red";
export let name = "Nicholas";
export const magicNumber = 7;

// 2.导出函数
export function sum(num1, num2) {
    return num1 + num1;
}

// 3.导出类
export class Rectangle {
    constructor(length, width) {
        this.length = length;
        this.width = width;
    }
}

function multiply(num1, num2) {
    return num1 * num2;
}

// 4.导出已有的函数
export {multiply};
```

### 12.2 基本导出

使用 `import` 可以实现基本的导入，可以导入单个绑定，也可以一次性导入多个绑定：

```javascript
import { sum } from "./example.js";
console.log(sum(1, 2)); // 3

import { sum, multiply, magicNumber } from "./example.js";
```

也可以将整个模块一次性导入，然后再使用 `模块名.导出名称` 的格式进行调用：

```javascript
import * as example from "./example.js";
console.log(example.sum(1,example.magicNumber)); 
console.log(example.multiply(1, 2)); 
```

如果想要在浏览器中使用导入模块化的 JS ，需要指定其 type 类型为 `module`，它会告诉浏览器要将内联代码或是指定文件中的代码当作模块来解析，而不是当作脚本：

```javascript
<script type="module" src="index.js"></script>
```

### 12.3 导入路径

导入模块的路径必须以 `/` ， `./` ， `../` 开头，它们的含义分别如下：

- 以 `/` 为起始，表示从根目录开始解析；
- 以 `./` 为起始，表示从当前目录开始解析；
- 以 `../` 为起始，表示从父级目录开始解析。

### 12.4 导入导出重命名

ES6 支持对导入导出的原始名称进行重命名：

```javascript
function sum(num1, num2) {
return num1 + num2;
}
// 对导出名称进行重命名
export { sum as add };
```

```javascript
// 对导入名称进行重命名
import { add as sum } from "./example.js";
console.log(typeof add); // "undefined"
console.log(sum(1, 2)); // 3
```

### 12.5 导入导出默认值

ES6 支持使用 `default` 关键字来实现默认值导出，一个模块只能有一个导出默认值，它代表的就是整个模块，实现方式如下：

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

因为默认值代表的就是整个模块，所以导入时就无需使用 `{}` 进行绑定，直接导入即可：

```javascript
import sum from "./example.js";
console.log(sum(1, 2)); // 3
```

### 12.6 导入再导出

ES6 支持对导入的模块进行再导出：

```java
// 导入再导出
export { sum } from "./example.js";
// 对导入模块进行重命名后再导出
export { sum as add } from "./example.js";
// 将导入模块的所有值再导出
export * from "./example.js";
```

### 12.7 无绑定导入

有些模块可以没有任何导出，例如只修改了全局作用域的对象，如下：

```javascript
Array.prototype.pushAll = function(items) {
    if (!Array.isArray(items)) {
           throw new TypeError("Argument must be an array.");
    }
    return this.push(...items);
};
```

尽管没有任何导入与导出，这依然是一个有效的模块。由于它没有任何导出，因此可以使用简化的语法来导入，而无须任何绑定：

```javascript
import "./example.js";

let colors = ["red", "green", "blue"];
let items = [];
items.pushAll(colors);
```



## 参考资料

+ Nicholas C. Zakas . 深入理解ES6 . 电子工业出版社 . 2017-7-1
+ [阮一峰 . ECMAScript 6 入门](https://es6.ruanyifeng.com/)
