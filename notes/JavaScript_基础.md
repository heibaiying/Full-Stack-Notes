# JavaScript 基础

## 一、简介

JavaScript 是一种专为与网页交互而设计的脚本语言，由以下三个部分组成：

- **ECMAScript**：由 ECMA-262 定义，提供核心语言功能；
- **文档对象模型 ( DOM )**：提供访问和操作网页内容的方法和接口；
- **浏览器对象模型 ( BOM )**：提供与浏览器交互的方法和接口。 



## 二、基本概念

### 2.1 数据类型

ECMAScript 提供了以下六种数据类型：

- 五种基本数据类型：Undefined，Null，Boolean，Number，String ；
- 一种复杂数据类型：Object 。 

JavaScript 是一种弱类型的语言，在声明变量时候可以不必指明其具体类型，而是由程序进行推断。如果想要知道变量的具体类型，可以使用 typeof 关键字，它的返回情况如下：

- **undefined**：如果对应的值未定义；
- **boolean**：如果对应的值是布尔值；
- **string**：如果对应的值是字符串； 
- **number**：如果对应的值是数值；
- **object**：如果对应的值是对象或 null；
- **function**：如果对应的值是函数则返回 function。 函数在本质上也是对象，但是由于其一等公民的特殊地位，所以将其和其他普通对象进行区分是很有必要的，因此 typeof 对其检测时会返回 function ，而不是 object 。

### 2.2 数值类型



### 2.3 字符类型

**1. 字符串表示**

ECMAScript 支持使用双引号 ( " ) 或单引号 ( ' ) 来表示字符串，并且 ECMAScript 中的字符串是不可变的，也就是说，字符串一旦创建，它们的值就不能改变。要改变某个变量保存的字符串，首先要销毁原来的字符串，然后再用另一个包含新值的字符串填充该变量，示例如下：

```javascript
var lang = "Java";
/*创建一个能容纳 10 个字符的新字符串用于填充"Java"和"Script"，之后再销毁原有的字符串"Java"和"Script"*/
lang = lang + "Script";
```

**2. 转换为字符串**

要把一个值转换为一个字符串有两种方式：

+ 调用对象的 toString() 方法：大多数对象都具有这个方法，但需要注意的是 null 和 undefined 没有；
+ 使用转型函数 String() ：使用该转型函数时，如果传入的值有 toString() 方法，则调用该方法并返回相应的结果；如果传入的值是 null，则返回 "null" ；如果传入值是 undefined，则返回 "undefined" 。 示例如下：

```javascript
var a = null;
a.toString()	// Uncaught TypeError: Cannot read property 'toString' of null
String(a)		// "null"
```

**3. 常用的字符串操作**

+ **concat()** ：用于拼接一个或多个字符串；
+ **slice()** ：用于截取字符串，接收两个参数，分别代表截取的开始位置和结束位置；
+ **substring()**：用于截取字符串，接收两个参数，分别代表截取的开始位置和结束位置；
+ **substr()** ：用于截取字符串，接收两个参数，分别代表截取的开始位置和截取的长度；
+ **indexOf() \ lastIndexOf()** ：均接收两个参数，分别代表待查找的字符串和查找的开始位置；
+ **trim()** ：用于去除字符串前后的空格。

在给 slice，substring，substr 等方法传入正数参数时，其行为比较好预期，但传递参数是负数时，其具体的行为表现如下：

+ **slice()** ：会将传入的负值与字符串的长度相加；
+ **substring()** ：方法会把所有负值参数都转换为 0 ；
+ **substr()** ：会将第一个负值参数加上字符串的长度，如果传递了第二个参数且为负数时候，会将其转换为 0 。

```javascript
var stringValue = "hello world";

// 只接收一个参数时
alert(stringValue.slice(3)); 			// "lo world"
alert(stringValue.substring(3));		// "lo world"
alert(stringValue.substr(3));			// "lo world"

// 接收两个参数时候
alert(stringValue.slice(3, 7));			// "lo w"
alert(stringValue.substring(3,7));		// "lo w"
alert(stringValue.substr(3, 7));		// "lo worl"

// 当第一个参数为负值时
alert(stringValue.slice(-3)); 			// "rld"			按照规则等价于： slice(8)
alert(stringValue.substring(-3));		// "hello world"	按照规则等价于： substring(0)
alert(stringValue.substr(-3));			// "rld" 			按照规则等价于： substr(8)

// 当第二个参数为负值时
alert(stringValue.slice(3, -4));		// "lo w"			按照规则等价于： slice(3,7)
alert(stringValue.substring(3, -4));	// "hel"			按照规则等价于： substring(3,0)
alert(stringValue.substr(3, -4)); 		// ""（空字符串）		按照规则等价于： substr(3,0)
```



### 2.4 理解函数

ECMAScript 使用 function 关键字来声明函数，但和其他语言不同的是，ECMAScript 中对于函数参数的限制是非常宽松的，例如你在定义函数时定义了两个参数，但在调用时可以只传递一个参数、也可以传三个参数，甚至不传递，示例如下：

```java
function test(first, second) {
    console.log("first:" + first + ",second:" + second);
}
test(1)		// first:1,second:undefined
test(1,2)	// first:1,second:2
test(1,2,3)	// first:1,second:2
```

之所以能实现这样的效果，是因为 ECMAScript 在函数内部使用了一个数组 arguments  来维护所有参数，函数接收到的始终都是这个数组，而在实际使用时指向的也是这个数组中的具体元素，所以以上的函数等价于下面的函数：

```javascript
function test(first, second) {
    console.log("first:" + arguments[0] + ",second:" + arguments[1]);
}
```



## 三、作用域与闭包

### 3.1  作用域

在 ECMAScript 6 之前，只存在两种作用域，即：全局作用域 和 函数作用域，不存在块级作用域。这意味着在除了函数外的任何代码块中使用 var 关键字声明的变量都会被提升为全局变量，示例如下：

```javascript
function test() {
    var age  =12;
}
age  // age is not defined

if (true) {
	var name = "heibaiying";
}
name  // heibaiying
```

这种情况同样适用与 for 循环代码块：

```javascript
for (var i = 0; i < 10; i++) {}
console.log(i);  //  10
```

### 3.2 作用域链

由于函数作用域的存在，函数内的变量不能被外部访问，但是函数内的变量可以被其内部的函数访问，并且函数也可以访问其父级作用域上的变量，从而形成一条从其自身作用域到全局作用域的链条，示例如下：

```javascript
var global = "global";
var outer = "outer global";

(function outer() {
    var outer = "outer";

    function inner() {
        console.log(global, outer);
    }

    inner()
})();

// 输出：global outer
```

### 3.3 闭包

由于函数作用域的存在，函数内的变量不能被外部访问，这可以保证变量的私有性。但如果你想允许外部对内部变量进行特定操作，可以通过闭包来实现。闭包是指有权访问另一个函数作用域中的变量的函数。示例如下： 

```java
var contain = function () {
    
    var arr = [];

    return {
        push: function () {
            arr.push(...arguments);
        },
        
        get: function () {
            return arr;
        }
    }
};

var ctn = contain();
ctn.push(1, 2, 3, 4);
ctn.get();   // [ 1, 2, 3, 4 ]
```



## 四、引用对象

### 4.1 Object 类型

创建 Object 实例有以下两种方式：

+ 使用 new 操作符后跟着 Object 构造函数；
+ 使用对象字面量的方式。

```javascript
// 1. 使用new操作符
var user  = new Object();
user.name = "heibaiying";
user.age = 30;

// 2. 使用对象字面量
var user = {
    name: "heibaiying",
    age: 30
};
```

### 4.2 Array 类型

创建数组也有两种方式，基于构造函数的方式和基于对象字面量的方式：

```javascript
// 1.基于构造函数的方式
var colors = new Array();
var colors = new Array(20);
var colors = new Array("red", "blue", "green");

// 2.基于对象字面量的方式
var names = [];
var colors = ["red", "blue", "green"];
```

数组的长度保存在其 length 属性中，和其他语言中的 length  属性不同，这个值是不是只读的，可以用其进行数组的截断操作或添加新的数据项，示例如下：

```javascript
var colors = ["red", "blue", "green"]; 

colors.length = 2;						// ["red", "blue"]
colors[colors.length] = "green";   		// ["red", "blue", "green"]
colors[10] = "black";					// ["red", "blue", "green", empty × 7, "black"]
```

数组的其他常用方法如下：

**1. 检测数组**

```javascript
colors instanceof Array 
Array.isArray(colors)
```

**2.  转换方法**

```java
var colors = ["red", "blue", "green"];

colors.valueOf();      // [ 'red', 'blue', 'green' ]
colors;                // [ 'red', 'blue', 'green' ]
colors.toString();     // red,blue,green
colors.join("|");      // red|blue|green
```

**3. 栈方法**

ECMAScript 的数组提供了类似栈的特性，能够实现后进先出：

```javascript
var colors = ["red", "blue", "green"];

colors.push("black");	// ["red", "blue", "green", "black"]
colors.pop()			// "black"
colors					// ["red", "blue", "green"]
```

**4. 队列方法**

CMAScript 的数组提供了类似栈的特性，能够实现先进先出：

```javascript
colors.push("black","yellow");		// ["red", "blue", "green", "black", "yellow"]
colors.shift()						// "red"
colors								// ["blue", "green", "black", "yellow"]
```

**5. 重排序方法**

```javascript
var values = [1, 2, 3, 4, 5];
values.reverse();
values	// [5, 4, 3, 2, 1]

// 支持传入排序函数进行自定义排序
function compare(value1, value2) {
    if (value1 < value2) {
        return -1;
    } else if (value1 > value2) {
        return 1;
    } else {
        return 0;
    }
}
values.sort(compare)
values	// [1, 2, 3, 4, 5]
```

**6. 操作方法**

concat() 用于拼接并返回新的数组：

```javascript
var colors = ["red", "green", "blue"];
var colors2 = colors.concat("yellow", ["black", "brown"]);

colors		// ["red", "green", "blue"]
colors2		// ["red", "green", "blue", "yellow", "black", "brown"]
```

slice() 用于截取数组并返回新的数组，它接收两个参数，分别代表截取的开始位置和结束位置，它是一个前开后闭的区间：

```javascript
var colors = ["red", "green", "blue", "yellow", "purple"];

var colors2 = colors.slice(1);		// ["green", "blue", "yellow", "purple"]
var colors3 = colors.slice(0,2);	// ["red", "green"]
```

splice() 用于删除并在删除位置新增数据项，它接收任意个参数，其中第一个参数为删除的开始位置，第二个参数为删除多少个数据项，之后可以接任意个参数，用于表示待插入的数据项：

```javascript
var colors = ["red", "green", "blue", "yellow"];

colors.splice(1,2)					// 返回删除的数据项：["green", "blue"]
colors								// ["red", "yellow"]

colors.splice(1,0,"black","green")	// []
colors								// ["red", "black", "green", "yellow"]
```

**7. 位置方法**

indexOf() 和 lastIndexOf() 用于查找指定元素的 Index ，它们都接收两个参数：待查找项和查找的起点位置：

```shell
var colors = ["red", "green", "blue", "yellow", "green", "blue"];

colors.indexOf("green");			// 1
colors.indexOf("green", 3);			// 4
colors.lastIndexOf("green");		// 4
colors.lastIndexOf("green", 3);		// 1
```

**8. 迭代方法**

ECMAScript 5 提供了五个迭代方法：

- **every()**：判断数组中的每个元素是否满足指定条件，如果全部满足则返回 true，否则返回 flase；
- **some()**：判断数组中的每个元素是否满足指定条件，只要有一个满足则返回 true，否则返回 flase；
- **filter()**：过滤并返回符合条件的元素组成的数组。
- **forEach()**：对数组中的每一项运行给定函数。
- **map()**：对数组中的每一项运行给定函数，并返回每次函数调用结果所组成的数组。

```javascript
var numbers = [1, 2, 3, 4, 5, 4, 3, 2, 1];

numbers.every(function (value, index, array) {
    return value > 3;
});			
// false

numbers.some(function (value, index, array) {
    return value > 3;
});			
// true

numbers.filter(function (value, index, array) {
    return value > 3;
});			
// [4, 5, 4]

numbers.forEach(function (value, index, array) {
    console.log(value);
});

numbers.map(function (value, index, array) {
    return value * 10;
});			
// [10, 20, 30, 40, 50, 40, 30, 20, 10]
```

**9. 归并方法**

ECMAScript 5 提供了两个归并数组的方法： reduce() 和 reduceRight() 。 它们都接收四个参数：前一个值、当前值、当前项的索引 和 数组本身，使用示例如下： 

```javascript
var values = [1, 2, 3, 4, 5];
var sum01 = values.reduce(function (prev, cur, index, array) {
    return prev + cur;
});	// 15

var sum02 = values.reduceRight(function (prev, cur, index, array) {
    return prev + cur;
});	// 15
```

### 4.3 Date 类型

创建一个日期对象，可以使用 new 操作符和 Date 构造函数：

```java
var now = new Date();
now.toLocaleString()		// 2019-9-14 9:53:59 AM
    
var date = new Date(2018, 7, 8, 8, 30, 20);
date.toLocaleString();		// 2018-8-8 8:30:20 AM
```

如果你只想知道当前时间的毫秒数，可以直接使用 Date 对象的静态方法：

```javascript
Date.now()
1568426130593
```

**1. 格式转换**

- toLocaleString() ：按照浏览器所在时区返回相应的日期格式；
- toString() ：返回日期时间数据和的时区数据；
- valueOf() ：返回日期的时间戳格式。

```javascript
var date = new Date(2018, 7, 8, 8, 30, 20);

console.log(date.toLocaleString());		// 2018-8-8 8:30:20 AM
console.log(date.toString());			// Wed Aug 08 2018 08:30:20 GMT+0800 (GMT+08:00)
console.log(date.valueOf());			// 1533688220000
```

用于 valueOf() 返回的是日期的时间戳格式，所以对于 date 对象，可以直接使用比较运算符来比较其大小：

```javascript
var date01 = new Date(2018, 7, 8, 8, 30, 20);
var date02 = new Date(2016, 7, 8, 8, 30, 20);

console.log(date01 > date02); 			// true
console.log(date01 < date02);			// flase
```

**2. 常用方法**

- **getTime() \ setTime(毫秒)** ：返回和设置整个日期的所代表的毫秒数；与 valueOf() 方法返回的值相同；
- **getFullYear() \ setFullYear(年)** ：返回和设置4位数的年份；
- **getMonth() \ setMonth(月)** ：返回和设置月份，其中 0 表示一月， 11 表示十二月；
- **getDate() \ setDate(日)** ：返回和设置月份中的天数（1到31）；
- **getDay()** ：返回和设置星期几 ( 其中0表示星期日， 6表示星期六）；
- **getHours() \ setHours(时)** ：返回和设置小时数（0到23）；
- **getMinutes() \ setMinutes(分)** ：返回和设置日期中的分钟数（0到59）；
- **getSeconds() \ setSeconds(秒)** ：返回和设置日期中的秒数（0到59）；
- **getMilliseconds() \ setMilliseconds(毫秒)** ：返回和设置日期中的毫秒数。

### 4.5 Funcation 类型



### 4.8 内置对象



## 五、面向对象





