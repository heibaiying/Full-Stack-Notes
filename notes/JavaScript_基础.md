# JavaScript 基础

<nav>
<a href="#一概念简介">一、概念简介</a><br/>
<a href="#二基本类型">二、基本类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-数值类型">2.1 数值类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-字符类型">2.2 字符类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-基本类型检测">2.3 基本类型检测</a><br/>
<a href="#三引用类型">三、引用类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-Object-类型">3.1 Object 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-Array-类型">3.2 Array 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-Date-类型">3.3 Date 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-Funcation-类型">3.4 Funcation 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#35-引用类型检测">3.5 引用类型检测</a><br/>
<a href="#四内置对象">四、内置对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-Global-对象">4.1 Global 对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42--window-对象">4.2  window 对象</a><br/>
<a href="#五作用域与闭包">五、作用域与闭包</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51--作用域">5.1  作用域</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-作用域链">5.2 作用域链</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#53-闭包">5.3 闭包</a><br/>
<a href="#六对象设计">六、对象设计</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-数据属性"> 6.1 数据属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-访问器属性">6.2 访问器属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63--读取属性">6.3  读取属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#64-创建对象">6.4 创建对象</a><br/>
</nav>

## 一、概念简介

JavaScript 是一种专为与网页交互而设计的脚本语言，由以下三个部分组成：

- **ECMAScript**：由 ECMA-262 定义，提供核心语言功能；
- **文档对象模型 (DOM)**：提供访问和操作网页内容的方法和接口；
- **浏览器对象模型 (BOM)**：提供与浏览器交互的方法和接口。 

ECMAScript  提供了语言的核心功能，它定义了以下七种数据类型：

- **六种基本数据类型**：`Undefined`，`Null`，`Boolean`，`Number`，`String`，`Symbol` ( ES 6新增 )；
- **一种引用数据类型**：统称为 Object 类型；具体又细分为 `Object`，`Array`，`Date`，`RegExp`，`Function` 等类型。另外和 Java 语言类似，对于布尔，数值，字符串等基本类型，分别存在其对应的包装类型 Boolean，Number，String，但通常我们并不会使用到这些包装类型，只需要使用其基本类型即可。

## 二、基本类型

### 2.1 数值类型

**1. 进制数值**

ECMAScript 中的 Number 支持以下三种常用进制：

+ **十进制**：正常数值就是十进制；
+ **八进制**：八进制字面值的第一位必须是零（0），然后是八进制数字序列（0～7）；
+ **十六进制**：十六进制字面值的前两位必须是 0x，后跟任意的十六进制数字（0～9 及 A～F）。 

```javascript
console.log(56);     // 56
console.log(070);    // 56
console.log(0x38);   // 56
```

**2. 浮点数值**

ECMAScript 的数值类型同样支持浮点数，但是由于保存浮点数值需要的内存空间是保存整数值的两倍，因此 ECMAScript 会尽量将浮点数值转换为整数值存储。

```javascript
var a = 10.0;
console.log(a);     // 10
```

和其他语言类似，浮点数中的数值也是不精准的，示例如下：

```javascript
var a = 0.1; var b = 0.2;

a + b ;        // 0.30000000000000004
a+b === 0.3 ;  // false
```

如果想要对浮点数进行精确计算，可以使用 [decimal.js](https://github.com/MikeMcl/decimal.js) ，[ math.js](https://github.com/josdejong/mathjs) 等第三方库。

**3. 科学计数法**

ECMAScript 支持使用科学计数法来表达数值：

```javascript
8e-2   // 0.08
8e2    // 800
```

**4. parseInt() \ parseFloat()**

parseInt 可以用于解析字符串并返回整数，parseFloat 用于解析字符串并返回浮点数：

```javascript
parseInt("56");         // 56
parseInt("0x38", 16);   // 56   支持使用第二个参数来表示转换的进制
parseInt("56.6");       // 56

parseFloat("12.2");     // 12.2 

parseInt("blue");       // NaN  NaN用于表示一个本来要返回数值的操作却未返回数值的情况
```

**5. toFixed()**

 toFixed 用于保留指定位数的小数，但需要注意的是其四舍五入的行为是不确定的：

```javascript
1.35.toFixed(1) // 1.4 正确
1.335.toFixed(2) // 1.33 错误
1.3335.toFixed(3) // 1.333 错误
1.33335.toFixed(4) // 1.3334 正确
1.333335.toFixed(5)  // 1.33333 错误
1.3333335.toFixed(6) // 1.333333 错误
```

想要解决这个问题，可以通过判断最后一位是否大于或等于5来决定是否需要进位，重写 toFixed 方法的具体代码如下：

```javascript
// toFixed兼容方法
Number.prototype.toFixed = function(len){
    if(len>20 || len<0){
        throw new RangeError('toFixed() digits argument must be between 0 and 20');
    }
    // .123转为0.123
    var number = Number(this);
    if (isNaN(number) || number >= Math.pow(10, 21)) {
        return number.toString();
    }
    if (typeof (len) == 'undefined' || len == 0) {
        return (Math.round(number)).toString();
    }
    var result = number.toString(),
        numberArr = result.split('.');

    if(numberArr.length<2){
        //整数的情况
        return padNum(result);
    }
    var intNum = numberArr[0], //整数部分
        deciNum = numberArr[1],//小数部分
        lastNum = deciNum.substr(len, 1);//最后一个数字
    
    if(deciNum.length == len){
        //需要截取的长度等于当前长度
        return result;
    }
    if(deciNum.length < len){
        //需要截取的长度大于当前长度 1.3.toFixed(2)
        return padNum(result)
    }
    //需要截取的长度小于当前长度，需要判断最后一位数字
    result = intNum + '.' + deciNum.substr(0, len);
    if(parseInt(lastNum, 10)>=5){
        //最后一位数字大于5，要进位
        var times = Math.pow(10, len); //需要放大的倍数
        var changedInt = Number(result.replace('.',''));//截取后转为整数
        changedInt++;//整数进位
        changedInt /= times;//整数转为小数，注：有可能还是整数
        result = padNum(changedInt+'');
    }
    return result;
    //对数字末尾加0
    function padNum(num){
        var dotPos = num.indexOf('.');
        if(dotPos === -1){
            //整数的情况
            num += '.';
            for(var i = 0;i<len;i++){
                num += '0';
            }
            return num;
        } else {
            //小数的情况
            var need = len - (num.length - dotPos - 1);
            for(var j = 0;j<need;j++){
                num += '0';
            }
            return num;
        }
    }
}
```

> 参考自：[*js中小数四舍五入和浮点数的研究*](http://caibaojian.com/js-tofixed.html)

### 2.2 字符类型

**1. 字符串表示**

ECMAScript 支持使用双引号 ` " ` 或单引号 ` ' ` 来表示字符串，并且 ECMAScript 中的字符串是不可变的，也就是说，字符串一旦创建，它们的值就不能改变。要改变某个变量保存的字符串，首先要销毁原来的字符串，然后再用另一个包含新值的字符串填充该变量，示例如下：

```javascript
var lang = "Java";
/*程序会创建一个能容纳 10 个字符的新字符串用于填充"Java"和"Script"，之后再销毁原有的字符串"Java"和"Script"*/
lang = lang + "Script";
```

**2. 转换为字符串**

要把一个值转换为一个字符串有两种方式：

+ 使用对象方法 **toString()** ：大多数对象都具有这个方法，但需要注意的是 null 和 undefined 没有；
+ 使用转型函数 **String()** ：使用该转型函数时，如果传入的值有 toString() 方法，则调用该方法并返回相应的结果；如果传入的值是 null，则返回 "null" ；如果传入值是 undefined，则返回 "undefined" 。 示例如下：

```javascript
var a = null;
a.toString()    // Uncaught TypeError: Cannot read property 'toString' of null
String(a)    // "null"
```

**3. 常用的字符串操作**

+ **concat()** ：用于拼接一个或多个字符串；
+ **slice()** ：用于截取字符串，接收两个参数，分别代表截取的开始位置和结束位置；
+ **substring()**：用于截取字符串，接收两个参数，分别代表截取的开始位置和结束位置；
+ **substr()** ：用于截取字符串，接收两个参数，分别代表截取的开始位置和截取的长度；
+ **indexOf() \ lastIndexOf()** ：均接收两个参数，分别代表待查找的字符串和查找的开始位置；
+ **trim()** ：用于去除字符串前后的空格。

slice，substring，substr 等方法在传入正数参数时，其行为比较好预期，但传递参数是负数时，其具体的行为表现如下:

+ **slice()** ：会将传入的负值与字符串的长度相加；
+ **substring()** ：方法会把所有负值参数都转换为 0 ；
+ **substr()** ：会将第一个负值参数加上字符串的长度，如果传递了第二个参数且为负数时候，会将其转换为 0 。

```javascript
var stringValue = "hello world";

// 只接收一个参数时
alert(stringValue.slice(3));             // "lo world"
alert(stringValue.substring(3));        // "lo world"
alert(stringValue.substr(3));            // "lo world"

// 接收两个参数时候
alert(stringValue.slice(3, 7));            // "lo w"
alert(stringValue.substring(3,7));        // "lo w"
alert(stringValue.substr(3, 7));        // "lo worl"

// 当第一个参数为负值时
alert(stringValue.slice(-3));             // "rld"          按照规则等价于： slice(8)
alert(stringValue.substring(-3));        // "hello world"  按照规则等价于： substring(0)
alert(stringValue.substr(-3));            // "rld"          按照规则等价于： substr(8)

// 当第二个参数为负值时
alert(stringValue.slice(3, -4));        // "lo w"         按照规则等价于： slice(3,7)
alert(stringValue.substring(3, -4));        // "hel"          按照规则等价于： substring(3,0)
alert(stringValue.substr(3, -4));         // ""（空字符串）  按照规则等价于： substr(3,0)
```

### 2.3 基本类型检测

JavaScript 是一种弱类型的语言，在声明变量时候可以不必指明其具体类型，而是由程序进行推断。如果想要知道变量具体属于哪一个基础类型，可以使用 **typeof** 关键字，它的返回情况如下：

- **undefined**：如果对应的值未定义；
- **boolean**：如果对应的值是布尔值；
- **string**：如果对应的值是字符串； 
- **number**：如果对应的值是数值；
- **object**：如果对应的值是对象或 null；
- **function**：如果对应的值是函数则返回 function。 函数在本质上也是对象，但是由于其一等公民的特殊地位，所以将其和其他普通对象进行区分是很有必要的，因此 typeof 对其检测时会返回 function ，而不是 object 。


## 三、引用类型

### 3.1 Object 类型

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

### 3.2 Array 类型

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

colors.length = 2;            // ["red", "blue"]
colors[colors.length] = "green";    // ["red", "blue", "green"]
colors[10] = "black";            // ["red", "blue", "green", empty × 7, "black"]
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

colors.push("black");    // ["red", "blue", "green", "black"]
colors.pop()        // "black"
colors            // ["red", "blue", "green"]
```

**4. 队列方法**

ECMAScript 的数组提供了类似栈的特性，能够实现先进先出：

```javascript
colors.push("black","yellow");       // ["red", "blue", "green", "black", "yellow"]
colors.shift()                       // "red"
colors                               // ["blue", "green", "black", "yellow"]
```

**5. 重排序方法**

```javascript
var values = [1, 2, 3, 4, 5];
values.reverse();
values    // [5, 4, 3, 2, 1]

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
values    // [1, 2, 3, 4, 5]
```

**6. 操作方法**

**concat()** 用于拼接并返回新的数组：

```javascript
var colors = ["red", "green", "blue"];
var colors2 = colors.concat("yellow", ["black", "brown"]);

colors        // ["red", "green", "blue"]
colors2        // ["red", "green", "blue", "yellow", "black", "brown"]
```

**slice()** 用于截取数组并返回新的数组，它接收两个参数，分别代表截取的开始位置和结束位置，它是一个前开后闭的区间：

```javascript
var colors = ["red", "green", "blue", "yellow", "purple"];

var colors2 = colors.slice(1);        // ["green", "blue", "yellow", "purple"]
var colors3 = colors.slice(0,2);    // ["red", "green"]
```

**splice()** 用于删除并在删除位置新增数据项，它接收任意个参数，其中第一个参数为删除的开始位置，第二个参数为删除多少个数据项，之后可以接任意个参数，用于表示待插入的数据项：

```javascript
var colors = ["red", "green", "blue", "yellow"];

colors.splice(1,2)                  // 返回删除的数据项：["green", "blue"]
colors                              // ["red", "yellow"]

colors.splice(1,0,"black","green")  // []
colors                              // ["red", "black", "green", "yellow"]
```

**7. 位置方法**

**indexOf()** 和 **lastIndexOf()** 用于查找指定元素的 Index ，它们都接收两个参数：待查找项和查找的起点位置：

```shell
var colors = ["red", "green", "blue", "yellow", "green", "blue"];

colors.indexOf("green");            // 1
colors.indexOf("green", 3);            // 4
colors.lastIndexOf("green");            // 4
colors.lastIndexOf("green", 3);            // 1
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

ECMAScript 5 提供了两个归并数组的方法： **reduce()** 和 **reduceRight()** 。 它们都接收四个参数：前一个值、当前值、当前项的索引 和 数组本身，使用示例如下： 

```javascript
var values = [1, 2, 3, 4, 5];
var sum01 = values.reduce(function (prev, cur, index, array) {
    return prev + cur;
});    // 15

var sum02 = values.reduceRight(function (prev, cur, index, array) {
    return prev + cur;
});    // 15
```

### 3.3 Date 类型

创建一个日期对象，可以使用 new 操作符和 Date 构造函数：

```java
var now = new Date();
now.toLocaleString()        // 2019-9-14 9:53:59 AM
    
var date = new Date(2018, 7, 8, 8, 30, 20);
date.toLocaleString();        // 2018-8-8 8:30:20 AM
```

如果你只想知道当前时间的毫秒数，可以直接使用 Date 对象的静态方法：

```javascript
Date.now()
1568426130593
```

**1. 格式转换**

- **toLocaleString()** ：按照浏览器所在时区返回相应的日期格式；
- **toString()** ：返回日期时间数据和的时区数据；
- **valueOf()** ：返回日期的时间戳格式。

```javascript
var date = new Date(2018, 7, 8, 8, 30, 20);

console.log(date.toLocaleString());        // 2018-8-8 8:30:20 AM
console.log(date.toString());            // Wed Aug 08 2018 08:30:20 GMT+0800 (GMT+08:00)
console.log(date.valueOf());            // 1533688220000
```

由于 **valueOf()** 返回的是日期的时间戳格式，所以对于 date 对象，可以直接使用比较运算符来比较其大小：

```javascript
var date01 = new Date(2018, 7, 8, 8, 30, 20);
var date02 = new Date(2016, 7, 8, 8, 30, 20);

console.log(date01 > date02);             // true
console.log(date01 < date02);            // flase
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

### 3.4 Funcation 类型

**1. 函数参数**

ECMAScript 使用 function 关键字来声明函数，但和其他语言不同的是，ECMAScript 中函数对于参数的限制是非常宽松的，例如你在定义函数时定义了两个参数，但在调用时可以只传递一个参数、也可以传三个参数，甚至不传递，示例如下：

```java
function test(first, second) {
    console.log("first:" + first + ",second:" + second);
}
test(1)        // first:1,second:undefined
test(1,2)    // first:1,second:2
test(1,2,3)    // first:1,second:2
```

之所以能实现这样的效果，是因为 ECMAScript 在函数内部使用了一个数组 arguments  来维护所有参数，函数接收到的始终都是这个数组，而在实际使用时指向的也是这个数组中的具体元素，所以以上的函数等价于下面的函数：

```javascript
function test(first, second) {
    console.log("first:" + arguments[0] + ",second:" + arguments[1]);
}
```

**2. 改变函数作用域**

在 ECMAScript 5 中，每个函数都包含两个非继承而来的方法：**apply()** 和 **call()** ，它们都用于在特定的作用域中调用函数。简单来说，可以用这两个方法来改变函数的实际调用对象，从而改变 this 的值，因为 this 总是指向当前函数的实际调用对象：

```javascript
window.color = "red";
var o = { color: "blue" };
function sayColor(){
    console.log(this.color);
}

sayColor();              // red
sayColor.call(this);     // red
sayColor.call(window);   // red
sayColor.call(o);        // blue   此时this指向的是函数调用对象，即 o
```

**apply()** 和 **call()** 的第一个参数都是指代函数的调用对象，它们的区别主要在于第二个参数：**apply()** 支持使用数组或 arguments 给调用函数传值，而 **call()** 给调用函数传值时，必须逐个列举：

```javascript
function sum(num1, num2) {
    return num1 + num2;
}

function callSum1(num1, num2) {
    return sum.apply(this, arguments);
}

function callSum2(num1, num2) {
    return sum.apply(this, [num1, num2]);
}

function callSum3(num1, num2) {
    return sum.call(this, num1, num2);
}

callSum1(10, 10);
callSum2(10, 10);
callSum3(10, 10);
```

**3. 绑定函数作用域**

如果想要将函数绑定在某个特定的作用域上，可以使用 **bind()** 函数：

```javascript
window.color = "red";
var o = { color: "blue" };
function sayColor(){
    console.log(this.color);
}

var objectSayColor = sayColor.bind(o);
objectSayColor();  // blue 此时即便是在全局作用域中调用这个函数，其作用域仍然被永远绑定在 o 对象上
```

### 3.5 引用类型检测

想要检测某个对象是否属于某个引用类型，可以使用 **instanceof** 关键字：

```shell
var date = new Date();
date instanceof Date   // true
```



## 四、内置对象

### 4.1 Global 对象

ECMAScript 中内置了一个全局对象 Global ，任何不属于任何其他对象的属性和方法，最终都是它的属性和方法。 ES 通过该内置对象，提供了一些可以直接调用的全局方法，常用的如下：

+ **isNaN()**：用于确定一个值是否为 NaN；
+ **isFinite()**：用于判断被传入的参数值是否为一个有限数值；
+ **parseInt() \ parseFloat()**：解析并返回一个整数 \ 浮点数；
+ **encodeURI()**：对 URI 进行编码，但不会对本身属于 URI 的特殊字符进行编码，例如冒号、正斜杠、问号和井号；
+ **encodeURIComponent()**：对 URI 进行编码，会对任何非标准字符进行编码。

### 4.2  window 对象

ECMAScript 并没有提供任何直接访问 Global 对象的方法，但是浏览器却基于 Global 扩展实现了 window 对象，可以直接在浏览器环境下使用：

```javascript
window.isFinite(12)  // true
a = 12;
window.a             // 12
```



## 五、作用域与闭包

### 5.1  作用域

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

### 5.2 作用域链

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

### 5.3 闭包

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



## 六、对象设计

ECMAScript 中的对象都有两种基本属性：数据属性和访问器属性。

###  6.1 数据属性


数据属性有以下 4 个描述其行为的特性：

+ **Enumerable**：表示该属性能否通过 for-in 循环返回；对于直接在对象上定义的属性， 该值默认为 true。
+ **Writable**：表示能否修改属性的值；对于直接在对象上定义的属性， 该值默认为 true。
+ **Value**：对应属性的数据值。默认值为 undefined。 
+ **Configurable**：表示能否对属性进行删除，修改等配置操作，对于直接在对象上定义的属性， 该值默认为 true。需要注意的是一旦将该属性的值设置为 false，就不能再将其设置为 true 。即一旦设置为不可配置，就不能再修改为可配置。因为你已经修改为不可配置，此时任何配置操作都无效了，自然修改 Configurable 属性的操作也无效。

```javascript
var person = {age: 12};
Object.defineProperty(person, "name", {
    Enumerable: false,
    writable: false,
    value: "heibai"
});

console.log(person.name);      // heibai
person.name = "ying";
console.log(person.name);      // ying

for (var key in person) {
    console.log("key:" + key + ",value:" + person[key])   /// key:age,value:12
}
```

### 6.2 访问器属性

访问器属性也有以下 4 个描述其行为的特性：

+ **Configurable**：表示能否对属性进行删除，修改等配置操作；对于直接在对象上定义的属性， 该值默认为 true。
+ **Enumerable**：表示该属性能否通过 for-in 循环返回；对于直接在对象上定义的属性， 该值默认为 true。
+ **Get**：在读取属性时调用的函数。默认值为 undefined。
+ **Set**：在写入属性时调用的函数。默认值为 undefined。 

```javascript
var student = {
    _age: null,
    birthday: new Date(2012,7,2)
};
Object.defineProperty(student, "age", {
   
    get: function () {
        if (this._age == null) {
            // 如果年龄不存在就根据出生日期计算
            return new Date().getFullYear() - this.birthday.getFullYear()
        }else {
            return this._age;
        }
    },
    set: function (newValue) {
        if (newValue < 0) {
            console.log("年龄不能设置为负数");
        } else {
            this._age = newValue;
        }
    }
});

student.age = -1;            // 输出：年龄不能设置为负数
console.log(student.age);    // 输出：7
student.age = 12;
console.log(student.age);    // 输出 12
```


### 6.3  读取属性

想要获取一个对象的数据属性和访问器属性，可以使用 **Object.getOwnPropertyDescriptor()** 方法，类似于其他语言中的反射机制。这个方法接收两个参数：属性所在的对象和要读取属性名称。沿用上面的例子，示例如下：

```javascript
var descriptor = Object.getOwnPropertyDescriptor(student, "age");
console.log(descriptor.get);          // 输出 [Function: get]
console.log(descriptor.enumerable);   // 输出 false
```

### 6.4 创建对象

在 ECMAScript 中，对象就是一种特殊的函数，想要声明一个对象，可以结合使用构造器模式和原型模式：基本属性可以通过构造器传入；但方法声明需要定义在原型属性上，如果直接定义在构造器上，每个对象实例都会创建该方法函数，即每个对象实例调用的都是自己重复声明的方法函数，示例如下：

```javascript
function Person(name, age, job) {
    this.name = name;
    this.age = age;
    this.job = job;
    this.friends = ["hei", "bai"];
    // 方法应该声明在原型属性上，而不是这里
    this.sayAge = function () {
        console.log(this.age)
    }
}

Person.prototype = {
    constructor: Person,
    // 方法应该声明在这
    sayName: function () {
        alert(this.name);
    }
}


var person1 = new Person("user01", 29, "Software Engineer");
var person2 = new Person("user02", 27, "Doctor");

person1.friends.push("ying");
console.log(person1.friends);                     // [ 'hei', 'bai', 'ying' ]
console.log(person2.friends);                     // [ 'hei', 'bai']
console.log(person1 instanceof Person);           // true
console.log(person1.constructor === Person);      // true
console.log(person1.sayName === person2.sayName); // true
console.log(person1.sayAge===person2.sayAge);     // false
```





## 参考资料

1. 尼古拉斯·泽卡斯 . JavaScript高级程序设计（第3版）. 人民邮电出版社 . 2012-3-29
2. [JS中小数四舍五入和浮点数的研究](http://caibaojian.com/js-tofixed.html)



