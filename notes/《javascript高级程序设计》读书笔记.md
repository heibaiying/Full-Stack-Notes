# 《JavaScript 高级程序设计》读书笔记

## 目录<br/>
<a href="#第三章-基本语法">第三章 基本语法</a><br/>
<a href="#第四章-变量、作用域和内存问题">第四章 变量、作用域和内存问题</a><br/>
<a href="#第五章-应用类型">第五章 应用类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-Array-类型">1. Array 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-RegExp-类型">2. RegExp 类型 	</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-Function-类型">3. Function 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-String-类型">4. String 类型</a><br/>
<a href="#第六章-面向对象的程序设计">第六章 面向对象的程序设计</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-理解对象">6.1 理解对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-属性类型"> 1. 属性类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-读取属性">2. 读取属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62--创建对象">6.2  创建对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1--构造函数模式">1.  构造函数模式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2--原型模式">2.  原型模式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3组合使用构造函数和原型模式（主要使用方式）">3.组合使用构造函数和原型模式（主要使用方式）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-继承">6.3 继承</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-原型链">1. 原型链</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-组合继承主要使用方式">2. 组合继承(主要使用方式)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-原型链继承">3. 原型链继承</a><br/>
<a href="#第七章-函数表达式">第七章 函数表达式</a><br/>
<a href="#第八章-BOM">第八章 BOM</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1window-对象">1.window 对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2location-对象">2.location 对象 </a><br/>
<a href="#第十章-DOM">第十章 DOM</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-Node-类型">1. Node 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2Document类型">2.Document类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3Element类型">3.Element类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4Text类型">4.Text类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5动态创建表格">5.动态创建表格</a><br/>
<a href="#第十一章-DOM扩展">第十一章 DOM扩展</a><br/>
<a href="#第十二章-DOM2和DOM3">第十二章 DOM2和DOM3</a><br/>
<a href="#第十三-事件">第十三 事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#131-DOM事件流">13.1 DOM事件流 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#132-事件处理程序">13.2 事件处理程序</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-DOM0-级事件处理程序">1. DOM0 级事件处理程序 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-DOM2-级事件处理程序">2. DOM2 级事件处理程序 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3兼容IE">3.兼容IE</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#133-事件处理程序">13.3 事件处理程序</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#134-事件类型">13.4 事件类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1UI-事件">1.UI 事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2焦点事件">2.焦点事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3鼠标和滚轮事件">3.鼠标和滚轮事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4键盘与文本事件">4.键盘与文本事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5变动事件">5.变动事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6HTML5事件">6.HTML5事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第十四章-表单脚本">第十四章 表单脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#141-表单基础知识">14.1 表单基础知识</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1提交表单">1.提交表单</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2重置表单">2.重置表单</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3表单字段">3.表单字段</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-共有的表单字段属性">3.1 共有的表单字段属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-共有的表单字段方法">3.2 共有的表单字段方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-共有的表单字段事件">3.3 共有的表单字段事件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#142-文本框脚本">14.2 文本框脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-选择文本">1. 选择文本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-过滤输入**keypress**">2. 过滤输入(**keypress**)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3自动切换焦点">3.自动切换焦点</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-HTML5-验证约束API">4. HTML5 验证约束API </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#143-选择框脚本">14.3 选择框脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1选择选项">1.选择选项</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2增加选项">2.增加选项</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3移除选项">3.移除选项</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4移动和重排选项">4.移动和重排选项</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#144-表单序列化">14.4 表单序列化</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第十六章-HTML5-脚本编程">第十六章 HTML5 脚本编程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1媒体元素">1.媒体元素</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第十七章-错误处理">第十七章 错误处理</a><br/>
<a href="#第二十章-JSON">第二十章 JSON</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#201-语法">20.1 语法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#202-json序列化与反序列化">20.2 json序列化与反序列化</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1序列化">1.序列化</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2序列化选项">2.序列化选项</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-过滤结果">2.1 过滤结果</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-toJSON方法">2.2 toJSON()方法 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-解析选项">2.3 解析选项</a><br/>
<a href="#第二十二章-高级技巧">第二十二章 高级技巧</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#221-高级函数">22.1 高级函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1安全类型检测">1.安全类型检测</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2作用域安全的构造函数">2.作用域安全的构造函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3函数绑定">3.函数绑定</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#222-防篡改对象">22.2 防篡改对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1不可扩展对象">1.不可扩展对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3冻结的对象">3.冻结的对象</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#223-高级定时器">22.3 高级定时器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1函数节流">1.函数节流</a><br/>
<a href="#第二十三章-离线应用与客户端存储">第二十三章 离线应用与客户端存储</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#231-离线检测">23.1 离线检测</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#232-数据存储">23.2 数据存储</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1Cookie">1.Cookie</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2web存储机制">2.web存储机制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-Storage-类型">2.1 Storage 类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-sessionStorage-对象">2.2 sessionStorage 对象 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-localStorage-对象">2.3 localStorage 对象 </a><br/>
## 正文<br/>




## 第三章 基本语法

1. 由于保存浮点数值需要的内存空间是保存整数值的两倍，因此 ECMAScript 会不失时机地将浮点数值转换为整数值。显然，如果小数点后面没有跟任何数字，那么这个数值就可以作为整数值来保存。同样地，如果浮点数值本身表示的就是一个整数（如 1.0），那么该值也会被转换为整数，如下面的例子所示：

   ```javascript
   var floatNum1 = 1.; // 小数点后面没有数字——解析为 1
   var floatNum2 = 10.0; // 整数——解析为 10 
   ```

2. 为了消除在使用parseInt() 函数时可能导致的上述困惑，可以为这个函数提供第二个参数：转换时使用的基数（即多少进制）。如果知道要解析的值是十六进制格式的字符串，那么指定基数 16 作为第二个参数，可以保证得到正确的结果，例如：var num = parseInt("0xAF", 16); //175实际上，如果指定了 16 作为第二个参数，字符串可以不带前面的"0x"，如下所示：

   ```javascript
   var num1 = parseInt("AF", 16); //175
   var num2 = parseInt("AF"); //NaN	
   ```

3. 多数情况下，调用 toString()方法不必传递参数。但是，在调用数值的 toString()方法时，可以传递一个参数：输出数值的基数。默认情况下， toString()方法以十进制格式返回数值的字符串表示。而通过传递基数，toString()可以输出以二进制、八进制、十六进制，乃至其他任意有效进制格式表示的字符串值。下面给出几个例子：

   ```javascript
   var num = 10;
   alert(num.toString()); // "10"
   alert(num.toString(2)); // "1010"
   alert(num.toString(8)); // "12"
   alert(num.toString(10)); // "10"
   alert(num.toString(16)); // "a" 
   ```


4. 在不知道要转换的值是不是 null 或 undefined 的情况下，还可以使用转型函数 String()，这个函数能够将任何类型的值转换为字符串。 String()函数遵循下列转换规则：

   + 如果值有 toString()方法，则调用该方法（没有参数）并返回相应的结果；

   - 如果值是 null，则返回"null"；
   -  如果值是 undefined，则返回"undefined"。
       下面再看几个例子： 

   ```javascript
   var value1 = 10;
   var value2 = true;
   var value3 = null;
   var value4;
   alert(String(value1)); // "10"
   alert(String(value2)); // "true"
   alert(String(value3)); // "null"
   alert(String(value4)); // "undefined" 	
   ```

5. Object 的每个实例都具有下列属性和方法。

   + **constructor**：保存着用于创建当前对象的函数。对于前面的例子而言，构造函数（constructor）就是 Object()。

   + **hasOwnProperty(propertyName)**：用于检查给定的属性在当前对象实例中（而不是在实例的原型中）是否存在。其中，作为参数的属性名（propertyName）必须以字符串形式指定（例如： o.hasOwnProperty("name")）。

   + **isPrototypeOf(object)**：用于检查传入的对象是否是传入对象的原型（第 5 章将讨论原型）。

   + **propertyIsEnumerable(propertyName)**：用于检查给定的属性是否能够使用 for-in 语句（本章后面将会讨论）来枚举。与 hasOwnProperty()方法一样，作为参数的属性名必须以字符
        串形式指定。

   + **toLocaleString()**：返回对象的字符串表示，该字符串与执行环境的地区对应。

   + **toString()**：返回对象的字符串表示。

   + **valueOf()**：返回对象的字符串、数值或布尔值表示。通常与 toString()方法的返回值相同。

   <div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/js对象属性.png"/> </div></br>


## 第四章 变量、作用域和内存问题

1. **ECMAScript 中所有函数的参数都是按值传递的。** 

   ```javascript
   function setName(obj) {
   obj.name = "Nicholas";
   }
   var person = new Object();
   setName(person);
   alert(person.name); //"Nicholas"
   ```

   ```javascript
   function setName(obj) {
   obj.name = "Nicholas";
   obj = new Object();
   obj.name = "Greg";
   }
   var person = new Object();
   setName(person);
   alert(person.name); //"Nicholas"
   ```



## 第五章 应用类型

### 1. Array 类型

1. 数组的 length 属性很有特点——它不是只读的。因此，通过设置这个属性，可以从数组的末尾移除项或向数组中添加新项。请看下面的例子： 

   ```javascript
   var colors = ["red", "blue", "green"]; // 创建一个包含 3 个字符串的数组
   colors.length = 2;
   alert(colors[2]); //undefined 
   ```

   这个例子中的数组 colors 一开始有 3 个值。将其 length 属性设置为 2 会移除最后一项（位置为2 的那一项），结果再访问 colors[2]就会显示 undefined 了。如果将其 length 属性设置为大于数组项数的值，则新增的每一项都会取得 undefined 值，如下所示：

   ```javascript
    var colors = ["red", "blue", "green"]; // 创建一个包含 3 个字符串的数组
   colors.length = 4;
   alert(colors[3]); //undefined 
   ```

2. 数组常用方法

   ```javascript
   var colors = ["red", "blue", "green"]; 
   
   alert(colors.toString()); // red,blue,green
   alert(colors.valueOf()); // red,blue,green
   alert(colors); // red,blue,green
   
   alert(colors.join(",")); //red,green,blue
   alert(colors.join("||")); //red||green||blue
   
   
   var colors = new Array(); // 创建一个数组
   var count = colors.push("red", "green"); // 推入两项
   alert(count); //2
   count = colors.push("black"); // 推入另一项
   alert(count); //3
   var item = colors.pop(); // 取得最后一项
   alert(item); //"black"
   alert(colors.length); //2
   
   var item = colors.shift(); //取得第一项
   alert(item); //"red"
   alert(colors.length); //2
   
   
   var colors = new Array(); //创建一个数组
   var count = colors.unshift("red", "green"); //推入两项
   alert(count); //2
   count = colors.unshift("black"); //推入另一项
   alert(count); //3
   var item = colors.pop(); //取得最后一项
   alert(item); //"green"
   alert(colors.length); //2
   ```



3. 数组重排序

   在默认情况下， `sort()`方法按升序排列数组项——即最小的值位于最前面，最大的值排在最后面。为了实现排序， sort()方法会调用每个数组项的 toString()转型方法，然后比较得到的字符串，以确定如何排序。即使数组中的每一项都是数值， sort()方法比较的也是字符串，如下所示。 

   ```javascript
   var values = [1, 2, 3, 4, 5];
   values.reverse();
   alert(values); //5,4,3,2,1
   
   var values = [0, 1, 5, 10, 15];
   values.sort();
   alert(values); //0,1,10,15,5
   
   //传入比较函数
   function compare(value1, value2) {
   	if (value1 < value2) {
   	return -1;
   	} else if (value1 > value2) {
   	return 1;
   } else {
   return 0;
   	}
   }
   
   var values = [0, 1, 5, 10, 15];
   values.sort(compare);
   alert(values); // 15,10,5,1,0
   ```



4. 数组操作方法

   `splice()`的主要用途是向数组的中部插入项，但使用这种方法的方式则有如下 3 种。

   - **删除**：可以删除任意数量的项，只需指定 2 个参数：要删除的第一项的位置和要删除的项数。例如， splice(0,2)会删除数组中的前两项。
   - **插入**：可以向指定位置插入任意数量的项，只需提供 3 个参数：起始位置、 0（要删除的项数）和要插入的项。如果要插入多个项，可以再传入第四、第五，以至任意多个项。例如，splice(2,0,"red","green")会从当前数组的位置 2 开始插入字符串"red"和"green"。
   - **替换**：可以向指定位置插入任意数量的项，且同时删除任意数量的项，只需指定 3 个参数：起始位置、要删除的项数和要插入的任意数量的项。插入的项数不必与删除的项数相等。例如，splice (2,1,"red","green")会删除当前数组位置 2 的项，然后再从位置 2 开始插入字符串"red"和"green"。 

   `splice()`方法始终都会返回一个数组，该数组中包含从原始数组中删除的项（如果没有删除任何项，则返回一个空数组）。下面的代码展示了上述 3 种使用 splice()方法的方式。 

   ```javascript
   //基于当前数据创建新的数组
   var colors = ["red", "green", "blue"];
   var colors2 = colors.concat("yellow", ["black", "brown"]);
   alert(colors); //red,green,blue
   alert(colors2); //red,green,blue,yellow,black,brown
   
   //slice
   var colors = ["red", "green", "blue", "yellow", "purple"];
   var colors2 = colors.slice(1);
   var colors3 = colors.slice(1,4);
   alert(colors2); //green,blue,yellow,purple
   alert(colors3); //green,blue,yellow
   
   
   var colors = ["red", "green", "blue"];
   var removed = colors.splice(0,1); // 删除第一项
   alert(colors); // green,blue
   alert(removed); // red，返回的数组中只包含一项
   removed = colors.splice(1, 0, "yellow", "orange"); // 从位置 1 开始插入两项
   alert(colors); // green,yellow,orange,blue
   alert(removed); // 返回的是一个空数组
   removed = colors.splice(1, 1, "red", "purple"); // 插入两项，删除一项
   alert(colors); // green,red,purple,orange,blue
   alert(removed); // yellow，返回的数组中只包含一项
   ```



5. 数组迭代方法

   ECMAScript 5 为数组定义了 5 个迭代方法。每个方法都接收两个参数：要在每一项上运行的函数和（可选的）运行该函数的作用域对象——影响 this 的值。传入这些方法中的函数会接收三个参数：数组项的值、该项在数组中的位置和数组对象本身。根据使用的方法不同，这个函数执行后的返回值可能会也可能不会影响方法的返回值。以下是这 5 个迭代方法的作用。

   + **every()**：对数组中的每一项运行给定函数，如果该函数对每一项都返回 true，则返回 true。
   + **filter()**：对数组中的每一项运行给定函数，返回该函数会返回 true 的项组成的数组。
   + **forEach()**：对数组中的每一项运行给定函数。这个方法没有返回值。
   +  **map()**：对数组中的每一项运行给定函数，返回每次函数调用的结果组成的数组。
   +  **some()**：对数组中的每一项运行给定函数，如果该函数对任一项返回 true，则返回 true。
       以上方法都不会修改数组中的包含的值。 

   ```javascript
   var numbers = [1,2,3,4,5,4,3,2,1];
   
   var everyResult = numbers.every(function(item, index, array){
   return (item > 2);
   });
   alert(everyResult); //false
   
   var someResult = numbers.some(function(item, index, array){
   return (item > 2);
   });
   alert(someResult); //true
   
   var filterResult = numbers.filter(function(item, index, array){
   return (item > 2);
   });
   alert(filterResult); //[3,4,5,4,3]
   
   var mapResult = numbers.map(function(item, index, array){
   return item * 2;
   });
   alert(mapResult); //[2,4,6,8,10,8,6,4,2]
   
   numbers.forEach(function(item, index, array){
   //执行某些操作
   });
   ```



6. 归并方法 

   ECMAScript 5 还新增了两个归并数组的方法： `reduce()`和 `reduceRight()`。这两个方法都会迭代数组的所有项，然后构建一个最终返回的值。其中， reduce()方法从数组的第一项开始，逐个遍历到最后。而 reduceRight()则从数组的最后一项开始，向前遍历到第一项。这两个方法都接收两个参数：一个在每一项上调用的函数和（可选的）作为归并基础的初始值。传给 reduce()和 reduceRight()的函数接收 4 个参数：前一个值、当前值、项的索引和数组对象。这个函数返回的任何值都会作为第一个参数自动传给下一项。第一次迭代发生在数组的第二项上，因此第一个参数是数组的第一项，第二个参数就是数组的第二项。  

   ```javascript
   var values = [1,2,3,4,5];
   var sum = values.reduce(function(prev, cur, index, array){
   return prev + cur;
   });
   alert(sum); //15
   
   var sum = values.reduceRight(function(prev, cur, index, array){
   return prev + cur;
   });
   alert(sum); //15
   ```



### 2. RegExp 类型 	

```
var expression = / pattern / flags ;
```

1 .   其中的模式（pattern）部分可以是任何简单或复杂的正则表达式，可以包含字符类、限定符、分组、向前查找以及反向引用。每个正则表达式都可带有一或多个标志（flags），用以标明正则表达式的行为。
正则表达式的匹配模式支持下列 3 个标志。

+ **g**：表示全局（global）模式，即模式将被应用于所有字符串，而非在发现第一个匹配项时立即停止；
+  **i**：表示不区分大小写（case-insensitive）模式，即在确定匹配项时忽略模式与字符串的大小写；
+  **m**：表示多行（multiline）模式，即在到达一行文本末尾时还会继续查找下一行中是否存在与模式匹配的项。 

模式中使用的所有元字符都必须转义。正则表达式中的元字符包括： ( [ { \ ^ $ | ) ? * + .]} 

```javascript
/*
* 匹配字符串中所有"at"的实例
*/
var pattern1 = /at/g;
/*
* 匹配第一个"bat"或"cat"，不区分大小写
*/
var pattern2 = /[bc]at/i;
/*
* 匹配所有以"at"结尾的 3 个字符的组合，不区分大小写
*/
var pattern3 = /.at/gi;
/*
* 匹配第一个"bat"或"cat"，不区分大小写
*/
var pattern1 = /[bc]at/i;
/*
* 匹配第一个" [bc]at"，不区分大小写
*/
var pattern2 = /\[bc\]at/i;
/*
* 匹配所有以"at"结尾的 3 个字符的组合，不区分大小写
*/
var pattern3 = /.at/gi;
/*
* 匹配所有".at"，不区分大小写
*/
var pattern4 = /\.at/gi;
/*
* 匹配第一个"bat"或"cat"，不区分大小写
*/
var pattern1 = /[bc]at/i;
/*
* 与 pattern1 相同，只不过是使用构造函数创建的
*/
var pattern2 = new RegExp("[bc]at", "i");
```


2. RegExp 对象的主要方法是 `exec()`，该方法是专门为捕获组而设计的。 exec()接受一个参数，即要应用模式的字符串，然后返回包含第一个匹配项信息的数组；或者在没有匹配项的情况下返回 null。返回的数组虽然是 Array 的实例，但包含两个额外的属性： index 和 input。其中， index 表示匹配项在字符串中的位置，而 input 表示应用正则表达式的字符串。在数组中，第一项是与整个模式匹配的字符串，其他项是与模式中的捕获组匹配的字符串（如果模式中没有捕获组，则该数组只包含一项）。

   ```javascript
   var text = "mom and dad and baby";
   var pattern = /mom( and dad( and baby)?)?/gi;
   var matches = pattern.exec(text);
   alert(matches.index); // 0
   alert(matches.input); // "mom and dad and baby"
   alert(matches[0]); // "mom and dad and baby"
   alert(matches[1]); // " and dad and baby"
   alert(matches[2]); // " and baby"
   ```

   对于 exec()方法而言，即使在模式中设置了全局标志（g），它每次也只会返回一个匹配项。在不设置全局标志的情况下，在同一个字符串上多次调用 exec()将始终返回第一个匹配项的信息。而在设置全局标志的情况下，每次调用 exec()则都会在字符串中继续查找新匹配项，如下面的例子所示。 

   ```javascript
   var text = "cat, bat, sat, fat";
   
   var pattern1 = /.at/;
   var matches = pattern1.exec(text);
   alert(matches.index); //0
   alert(matches[0]); //cat
   alert(pattern1.lastIndex); //0
   matches = pattern1.exec(text);
   alert(matches.index); //0
   alert(matches[0]); //cat
   alert(pattern1.lastIndex); //0
   
   var pattern2 = /.at/g;
   var matches = pattern2.exec(text);
   alert(matches.index); //0
   alert(matches[0]); //cat
   alert(pattern2.lastIndex); //3
   matches = pattern2.exec(text);
   alert(matches.index); //5
   alert(matches[0]); //bat
   alert(pattern2.lastIndex); //8
   
   
   var text = "000-00-0000";
   var pattern = /\d{3}-\d{2}-\d{4}/;
   if (pattern.test(text)){
   alert("The pattern was matched.");
   }
   ```



3. RegExp构造函数属性 

   |   长属性名   | 短属性名 |                            说 明                             |
   | :----------: | :------: | :----------------------------------------------------------: |
   |    input     |    $_    |          最近一次要匹配的字符串。 Opera未实现此属性          |
   |  lastMatch   |    $&    |             最近一次的匹配项。 Opera未实现此属性             |
   |  lastParen   |    $+    |           最近一次匹配的捕获组。 Opera未实现此属性           |
   | leftContext  |    $`    |               input字符串中lastMatch之前的文本               |
   |  multiline   |    $*    | 布尔值，表示是否所有表达式都使用多行模式。 IE和Opera未实现此属性 |
   | rightContext |    $'    |               Input字符串中lastMatch之后的文本               |

   ```javascript
   var text = "this has been a short summer";
   var pattern = /(.)hort/g;
   /*
   * 注意： Opera 不支持 input、 lastMatch、 lastParen 和 multiline 属性
   * Internet Explorer 不支持 multiline 属性
   */
   if (pattern.test(text)){
   alert(RegExp.input); // this has been a short summer
   alert(RegExp.leftContext); // this has been a
   alert(RegExp.rightContext); // summer
   alert(RegExp.lastMatch); // short
   alert(RegExp.lastParen); // s
   alert(RegExp.multiline); // false
   }
   
   if (pattern.test(text)){
   alert(RegExp.$_); // this has been a short summer
   alert(RegExp["$`"]); // this has been a
   alert(RegExp["$'"]); // summer
   alert(RegExp["$&"]); // short
   alert(RegExp["$+"]); // s
   alert(RegExp["$*"]); // false
   }
   
   //RegExp.$1、 RegExp.$2…RegExp.$9，分别用于存储第一、第二……第九个匹配的捕获组。
   var text = "this has been a short summer";
   var pattern = /(..)or(.)/g;
   if (pattern.test(text)){
   alert(RegExp.$1); //sh
   alert(RegExp.$2); //t
   }
   ```


### 3. Function 类型

1. 每个函数都包含两个非继承而来的方法： `apply()`和 `call()`。这两个方法的用途都是在特定的作用域中调用函数，实际上等于设置函数体内 this 对象的值。首先， apply()方法接收两个参数：一个是在其中运行函数的作用域，另一个是参数数组。其中，第二个参数可以是 Array 的实例，也可以是arguments 对象。例如： 

   ```javascript
   function sum(num1, num2){
   	return num1 + num2;
   }
   
   function callSum1(num1, num2){
   	return sum.apply(this, arguments); // 传入 arguments 对象
   }
   
   function callSum2(num1, num2){
   	return sum.apply(this, [num1, num2]); // 传入数组
   }
   
   alert(callSum1(10,10)); //20
   alert(callSum2(10,10)); //20
   
   /*call()方法与 apply()方法的作用相同，它们的区别仅在于接收参数的方式不同。对于 call() 方法而言，第一个参数是 this 值没有变化，变化的是其余参数都直接传递给函数。换句话说，在使用call()方法时，传递给函数的参数必须逐个列举出来，如下面的例子所示。
    */
   function sum(num1, num2){
   	return num1 + num2;
   }
   
   function callSum(num1, num2){
   	return sum.call(this, num1, num2);
   }
   alert(callSum(10,10)); //20
   
   
   /*传递参数并非 apply()和 call()真正的用武之地；它们真正强大的地方是能够扩充函数赖以运行的作用域。下面来看一个例子。*/
   window.color = "red";
   var o = { color: "blue" };
   function sayColor(){
   	alert(this.color);
   }
   sayColor(); //red
   sayColor.call(this); //red
   sayColor.call(window); //red
   sayColor.call(o); //blue
   ```

2. ECMAScript 5 还定义了一个方法： `bind()`。这个方法会创建一个函数的实例，其 this 值会被绑定到传给 bind()函数的值。例如： 

   ```javascript
   window.color = "red";
   var o = { color: "blue" };
   function sayColor(){
   	alert(this.color);
   }
   var objectSayColor = sayColor.bind(o);
   objectSayColor(); //blue
   ```


### 4. String 类型

1. ECMAScript还提供了三个基于子字符串创建新字符串的方法： `slice()`、 `substr()`和 `substring()`。这三个方法都会返回被操作字符串的一个子字符串，而且也都接受一或两个参数。第一个参数指定子字符串的开始位置，第二个参数（在指定的情况下）表示子字符串到哪里结束。具体来说， slice()和substring()的第二个参数指定的是子字符串最后一个字符后面的位置。而 substr()的第二个参数指定的则是返回的字符个数。如果没有给这些方法传递第二个参数，则将字符串的长度作为结束位置。与concat()方法一样， slice()、 substr()和 substring()也不会修改字符串本身的值——它们只是返回一个基本类型的字符串值，对原始字符串没有任何影响。请看下面的例子。  

   ```javascript
   var stringValue = "hello world";
   alert(stringValue.slice(3)); //"lo world"
   alert(stringValue.substring(3)); //"lo world"
   alert(stringValue.substr(3)); //"lo world"
   alert(stringValue.slice(3, 7)); //"lo w"
   alert(stringValue.substring(3,7)); //"lo w"
   alert(stringValue.substr(3, 7)); //"lo worl"
   ```


2. 字符串的模式匹配

   ```javascript
   //match
   var text = "cat, bat, sat, fat";
   var pattern = /.at/;
   //与 pattern.exec(text)相同
   var matches = text.match(pattern);
   alert(matches.index); //0
   alert(matches[0]); //"cat"
   alert(pattern.lastIndex); //0
   
   //search
   var text = "cat, bat, sat, fat";
   var pos = text.search(/at/);
   alert(pos); //1
   
   
   //replace
   ar text = "cat, bat, sat, fat";
   var result = text.replace("at", "ond");
   alert(result); //"cond, bat, sat, fat"
   result = text.replace(/at/g, "ond");
   alert(result); //"cond, bond, sond, fond"
   
   var text = "cat, bat, sat, fat";
   result = text.replace(/(.at)/g, "word ($1)");
   alert(result); //word (cat), word (bat), word (sat), word (fat)
   
   function htmlEscape(text){
   return text.replace(/[<>"&]/g, function(match, pos, originalText){
       switch(match){
           case "<":
           	return "&lt;";
           case ">":
           	return "&gt;";
           case "&":
           	return "&amp;";
           case "\"":
           	return "&quot;";
           }
       });
   }
   alert(htmlEscape("<p class=\"greeting\">Hello world!</p>"));
   //&lt;p class=&quot;greeting&quot;&gt;Hello world!&lt;/p&gt;
   
   
   /*split()，这个方法可以基于指定的分隔符将一个字符串分割成多个子字符串，并将结果放在一个数组中。分隔符可以是字符串，也可以是一个 RegExp 对象（这个方法不会将字符串看成正则表达式）。 split()方法可以接受可选的第二个参数，用于指定数组的大小，以便确保返回的数组不会超过既定大小。请看下面的例子
   */
   var colorText = "red,blue,green,yellow";
   var colors1 = colorText.split(","); //["red", "blue", "green", "yellow"]
   var colors2 = colorText.split(",", 2); //["red", "blue"]
   var colors3 = colorText.split(/[^\,]+/); //["", ",", ",", ",", ""]
   ```

## 第六章 面向对象的程序设计

### 6.1 理解对象

####  1. 属性类型

1. ECMAScript 中有两种属性：数据属性和访问器属性。
   1. **数据属性**
       数据属性包含一个数据值的位置。在这个位置可以读取和写入值。数据属性有 4 个描述其行为的特性。

       + **[[Configurable]]**：表示能否通过 delete 删除属性从而重新定义属性，能否修改属性的特性，或者能否把属性修改为访问器属性。像前面例子中那样直接在对象上定义的属性，它们的这个特性默认值为 true。

       + **[[Enumerable]]**：表示能否通过 for-in 循环返回属性。像前面例子中那样直接在对象上定义的属性，它们的这个特性默认值为 true。

       + **[[Writable]]**：表示能否修改属性的值。像前面例子中那样直接在对象上定义的属性，它们的这个特性默认值为 true。

       + **[[Value]]**：包含这个属性的数据值。读取属性值的时候，从这个位置读；写入属性值的时候，把新值保存在这个位置。这个特性的默认值为 undefined。 

         ```javascript
          var person = {};
           Object.defineProperty(person, "name", {
           	writable: false,
           	value: "Nicholas"
           });
           alert(person.name); //"Nicholas"
           person.name = "Greg";
           alert(person.name); //"Nicholas"
           
           var person = {};
           Object.defineProperty(person, "name", {
           	configurable: false,
           	value: "Nicholas"
           });
           alert(person.name); //"Nicholas"
           delete person.name;
           alert(person.name); //"Nicholas"
           
           //一旦把属性定义为不可配置的，就不能再把它变回可配置了
           var person = {};
           Object.defineProperty(person, "name", {
           	configurable: false,
           	value: "Nicholas"
           });
           //抛出错误
           Object.defineProperty(person, "name", {
           	configurable: true,
           	value: "Nicholas"
           });
         ```

   2. **访问器属性**
      访问器属性不包含数据值；它们包含一对儿 getter 和 setter 函数（不过，这两个函数都不是必需的） 

      + **[[Configurable]]**：表示能否通过 delete 删除属性从而重新定义属性，能否修改属性的特性，或者能否把属性修改为数据属性。对于直接在对象上定义的属性，这个特性的默认值为true。

      + **[[Enumerable]]**：表示能否通过 for-in 循环返回属性。对于直接在对象上定义的属性，这个特性的默认值为 true。

      + **[[Get]]**：在读取属性时调用的函数。默认值为 undefined。

      + **[[Set]]**：在写入属性时调用的函数。默认值为 undefined。 

      **访问器属性不能直接定义，必须使用 Object.defineProperty()来定义。** 

      ```javascript
      var book = {
          _year: 2004,
          edition: 1
      	};
      Object.defineProperty(book, "year", {
          get: function(){
          	return this._year;
      	},
          set: function(newValue){
              if (newValue > 2004) {
                  this._year = newValue;
                  this.edition += newValue - 2004;
              }
          }
      });
      book.year = 2005;
      alert(book.edition); //2
      
      
      // 定义多个属性
      var book = {};
      Object.defineProperties(book, {
          _year: {
         		value: 2004
      	},
      	edition: {
      		value: 1
      	},
      	year: {
              get: function(){
                  return this._year;
              },
              set: function(newValue){
                  if (newValue > 2004) {
                      this._year = newValue;
                      this.edition += newValue - 2004;
                  }
              }
      	}
      });
      ```


#### 2. 读取属性

1. 使用 ECMAScript 5 的 `Object.getOwnPropertyDescriptor()`方法，可以取得给定属性的描述符。这个方法接收两个参数：属性所在的对象和要读取其描述符的属性名称。

```javascript
var book = {};
Object.defineProperties(book, {
    _year: {
    	value: 2004
    },
    edition: {
    	value: 1
    },
    year: {
        get: function(){
       		return this._year;
        },
    set: function(newValue){
            if (newValue > 2004) {
                this._year = newValue;
                this.edition += newValue - 2004;
            }
    	}
    }
});


var descriptor = Object.getOwnPropertyDescriptor(book, "_year");
alert(descriptor.value); //2004
alert(descriptor.configurable); //false

alert(typeof descriptor.get); //"undefined"
var descriptor = Object.getOwnPropertyDescriptor(book, "year");
alert(descriptor.value); //undefined
alert(descriptor.enumerable); //false
alert(typeof descriptor.get); //"function"
```



### 6.2  创建对象

#### 1.  构造函数模式

```javascript
function Person(name, age, job){
    this.name = name;
    this.age = age;
    this.job = job;
    this.sayName = function(){
        alert(this.name);
    };
}
var person1 = new Person("Nicholas", 29, "Software Engineer");
var person2 = new Person("Greg", 27, "Doctor");

alert(person1.constructor == Person); //true
alert(person2.constructor == Person); //true
alert(person1 instanceof Object); //true
alert(person1 instanceof Person); //true
alert(person2 instanceof Object); //true
alert(person2 instanceof Person); //true


//构造函数模式的缺陷
alert(person1.sayName == person2.sayName); //false

//解决办法
function Person(name, age, job){
    this.name = name;
    this.age = age;
    this.job = job;
    this.sayName = sayName;
}
function sayName(){
	alert(this.name);
}
var person1 = new Person("Nicholas", 29, "Software Engineer");
var person2 = new Person("Greg", 27, "Doctor");
```



#### 2.  原型模式

```javascript
function Person(){
}
Person.prototype.name = "Nicholas";
Person.prototype.age = 29;
Person.prototype.job = "Software Engineer";
Person.prototype.sayName = function(){
alert(this.name);
};
var person1 = new Person();
person1.sayName(); //"Nicholas"
var person2 = new Person();
person2.sayName(); //"Nicholas"
alert(person1.sayName == person2.sayName); //true
alert(Person.prototype.constructor=== Person);  //true
alert(Person.prototype == person1.__proto__);  //true
```

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/js原型1.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/js原型2.png"/> </div></br>

```javascript
//覆盖原型中的属性
function Person(){
}
Person.prototype.name = "Nicholas";
Person.prototype.age = 29;
Person.prototype.job = "Software Engineer";
Person.prototype.sayName = function(){
	alert(this.name);
};

var person1 = new Person();
var person2 = new Person();
person1.name = "Greg";
alert(person1.name); //"Greg"—— 来自实例
alert(person2.name); //"Nicholas"—— 来自原型
```

```javascript
//属性恢复
function Person(){
}
Person.prototype.name = "Nicholas";
Person.prototype.age = 29;
Person.prototype.job = "Software Engineer";
Person.prototype.sayName = function(){
	alert(this.name);
};

var person1 = new Person();
var person2 = new Person();
person1.name = "Greg";
alert(person1.name); //"Greg"—— 来自实例
alert(person2.name); //"Nicholas"—— 来自原型
delete person1.name;
alert(person1.name); //"Nicholas"—— 来自原型
```

```javascript
//使用 hasOwnProperty()方法可以检测一个属性是存在于实例中，还是存在于原型中。
function Person(){
}
Person.prototype.name = "Nicholas";
Person.prototype.age = 29;
Person.prototype.job = "Software Engineer";
Person.prototype.sayName = function(){
    alert(this.name);
};

var person1 = new Person();
var person2 = new Person();
alert(person1.hasOwnProperty("name")); //false
person1.name = "Greg";
alert(person1.name); //"Greg"—— 来自实例
alert(person1.hasOwnProperty("name")); //true
alert(person2.name); //"Nicholas"—— 来自原型
alert(person2.hasOwnProperty("name")); //false
delete person1.name;
alert(person1.name); //"Nicholas"—— 来自原型
alert(person1.hasOwnProperty("name")); //false
```

```javascript
// in 操作符只要通过对象能够访问到属性就返回 true
function Person(){
}
Person.prototype.name = "Nicholas";
Person.prototype.age = 29;
Person.prototype.job = "Software Engineer";
Person.prototype.sayName = function(){
alert(this.name);
};

var person1 = new Person();
var person2 = new Person();
alert(person1.hasOwnProperty("name")); //false
alert("name" in person1); //true
person1.name = "Greg";
alert(person1.name); //"Greg" —— 来自实例
alert(person1.hasOwnProperty("name")); //true
alert("name" in person1); //true
alert(person2.name); //"Nicholas" —— 来自原型
alert(person2.hasOwnProperty("name")); //false
alert("name" in person2); //true
delete person1.name;
alert(person1.name); //"Nicholas" —— 来自原型
alert(person1.hasOwnProperty("name")); //false
alert("name" in person1); //true
```

在使用 for-in 循环时，返回的是所有能够通过对象访问的、可枚举的（enumerated）属性，其中既包括存在于实例中的属性，也包括存在于原型中的属性。屏蔽了原型中不可枚举属性（即将[[Enumerable]]标记为 false 的属性）的实例属性也会在 for-in 循环中返回，因为根据规定，所有开发人员定义的属性都是可枚举的。

```javascript
//获取所有可枚举的属性
function Person(){
}
Person.prototype.name = "Nicholas";
Person.prototype.age = 29;
Person.prototype.job = "Software Engineer";
Person.prototype.sayName = function(){
	alert(this.name);
};
var keys = Object.keys(Person.prototype);
alert(keys); //"name,age,job,sayName"
var p1 = new Person();
p1.name = "Rob";
p1.age = 31;
var p1keys = Object.keys(p1);
alert(p1keys); //"name,age"

// 获取所有属性 不论是否可以枚举
var keys = Object.getOwnPropertyNames(Person.prototype);
alert(keys); //"constructor,name,age,job,sayName"
```

```javascript
// 更简单的原型语法
function Person(){
}
Person.prototype = {
    name : "Nicholas",
    age : 29,
    job: "Software Engineer",
    sayName : function () {
    alert(this.name);
	}
};
var friend = new Person();
alert(friend instanceof Object); //true
alert(friend instanceof Person); //true
alert(friend.constructor == Person); //false
alert(friend.constructor == Object); //true


// 弊端
function Person(){
}
//这种赋值方式 相当于把Person.prototype指向一个用字面量创建的对象,相当于下面的创建结果
Person.prototype = {
    name : "Nicholas",
    age : 29,
    job: "Software Engineer",
    sayName : function () {
        alert(this.name);
    }
};
console.log(Person.prototype.constructor); //[Function: Object]
var obj = {
    name : "Nicholas",
    age : 29,
    job: "Software Engineer",
    sayName : function () {
        alert(this.name);
    }
};
console.log(obj.constructor);  //[Function: Object]


//更好的创建方式 以这种方式重设 constructor 属性会导致它的[[Enumerable]]特性被设置为 true。默认情况下，原生的 constructor 属性是不可枚举的，
function Person(){
}
Person.prototype = {
    constructor : Person,
    name : "Nicholas",
    age : 29,
    job: "Software Engineer",
    sayName : function () {
    alert(this.name);
	}
};


//最好的创建方式
function Person(){
}
Person.prototype = {
    name : "Nicholas",
    age : 29,
    job : "Software Engineer",
    sayName : function () {
    alert(this.name);
    }
};
//重设构造函数，只适用于 ECMAScript 5 兼容的浏览器
Object.defineProperty(Person.prototype, "constructor", {
    enumerable: false,
    value: Person
});
```

```javascript
// 扩展原生对象的原型方式
alert(typeof Array.prototype.sort); //"function"
alert(typeof String.prototype.substring); //"function"

String.prototype.startsWith = function (text) {
	return this.indexOf(text) == 0;
};
var msg = "Hello world!";
alert(msg.startsWith("Hello")); //true
```

```javascript
// 原生模式的弊端
function Person(){
}
Person.prototype = {
    constructor: Person,
    name : "Nicholas",
    age : 29,
    job : "Software Engineer",
    friends : ["Shelby", "Court"],
    sayName : function () {
        alert(this.name);
        }
};
var person1 = new Person();
var person2 = new Person();
person1.friends.push("Van");
alert(person1.friends); //"Shelby,Court,Van"
alert(person2.friends); //"Shelby,Court,Van"
alert(person1.friends === person2.friends); //true
```



#### 3.组合使用构造函数和原型模式（主要使用方式）

```javascript
function Person(name, age, job){
    this.name = name;
    this.age = age;
    this.job = job;
    this.friends = ["Shelby", "Court"];
}
Person.prototype = {
constructor : Person,
	sayName : function(){
		alert(this.name);
	}
}


var person1 = new Person("Nicholas", 29, "Software Engineer");
var person2 = new Person("Greg", 27, "Doctor");
person1.friends.push("Van");
alert(person1.friends); //"Shelby,Count,Van"
alert(person2.friends); //"Shelby,Count"
alert(person1.friends === person2.friends); //false
alert(person1.sayName === person2.sayName); //true
```



### 6.3 继承

#### 1. 原型链

```javascript
function Parent(){
    this.property = "parent";
    this.value="common value";
}
Parent.prototype.getParentValue= function(){
    return this.property;
};
Parent.prototype.getValue= function(){
    return this.value;
};
function Son(){
    this.subproperty = "son";
}

Son.prototype = new Parent();
Son.prototype.getSonValue = function (){
    return this.subproperty;
};
var instance = new Son();
console.log(instance.getParentValue());     //parent
console.log(instance.getSonValue());        //son
console.log(instance.getValue());           //common value

//重写原型中的方法
Son.prototype.getValue=function(){
  return this.value+" modified by son"    //common value modified by son
};

console.log(instance.getValue());

// 确定原型和实例的关系
console.log(instance instanceof Object);    //true
console.log(instance instanceof Parent);    //true
console.log(instance instanceof Son);       //true

// 确定原型和实例的关系
console.log(Object.prototype.isPrototypeOf(instance));  //true
console.log(Parent.prototype.isPrototypeOf(instance));  //true
console.log(Son.prototype.isPrototypeOf(instance));     //true
```



#### 2. 组合继承(主要使用方式)

```javascript
function Parent(name) {
    this.name = name;
    this.colors = ["red", "blue", "green"];
}

Parent.prototype.sayName = function () {
    console.log(this.name);
};

function Son(name, age) {
//继承属性
    Parent.call(this, name);
    this.age = age;
}

//继承方法
Son.prototype = new Parent();
Son.prototype.constructor = Son;
Son.prototype.sayAge = function () {
    console.log(this.age);
};
var instance1 = new Son("Nicholas", 29);
instance1.colors.push("black");
console.log(instance1.colors);          //"red,blue,green,black"
instance1.sayName();                    //"Nicholas";
instance1.sayAge();                     //29

var instance2 = new Son("Greg", 27);
console.log(instance2.colors);          //"red,blue,green"
instance2.sayName();                    //"Greg";
instance2.sayAge();                     //27

```



#### 3. 原型链继承

```javascript
var person = {
    name: "Nicholas",
    friends: ["Shelby", "Court", "Van"]
};
var anotherPerson = Object.create(person);
anotherPerson.name = "Greg";
anotherPerson.friends.push("Rob");
var yetAnotherPerson = Object.create(person);
yetAnotherPerson.name = "Linda";
yetAnotherPerson.friends.push("Barbie");

console.log(person.name);               // Nicholas
console.log(yetAnotherPerson.name);     // Linda
console.log(anotherPerson.name);        // Greg
//包含引用类型值的属性始终都会共享相应的值
console.log(person.friends);            // [ 'Shelby', 'Court', 'Van', 'Rob', 'Barbie' ]
console.log(yetAnotherPerson.friends);  // [ 'Shelby', 'Court', 'Van', 'Rob', 'Barbie' ]
console.log(anotherPerson.friends);     // [ 'Shelby', 'Court', 'Van', 'Rob', 'Barbie' ]


var anotherPerson2 = Object.create(person, {
    name: {
        value: "Greg2"
    }
});
console.log(anotherPerson2.name);             //"Greg2"
```



## 第七章 函数表达式

1. 递归的隐藏问题

   ```javascript
   function factorial(num){
       if (num <= 1){
           return 1;
       } else {
           return num * factorial(num-1);
       }
   }
   var anotherFactorial = factorial;
   factorial=function(){
       return 0
   };
   console.log(anotherFactorial(4)); //0
   factorial = null;
   console.log(anotherFactorial(4)); //出错
   
   //稳妥实现方式1
   function factorial(num){
       if (num <= 1){
           return 1;
       } else {
           return num * arguments.callee(num-1);
       }
   }
   
   // 稳妥实现方式2
   var factorial = (function f(num){
       if (num <= 1){
           return 1;
           } else {
           return num * f(num-1);
       }
   });
   ```


2. #### *闭包是指有权访问另一个函数作用域中的变量的函数。*

   ```javascript
   //闭包
   function f(param) {
       // 内部函数持有了外部函数的变量
       return function () {
           return param+10
       }
   }
   let f1 = f(2);
   console.log(f1());   //12
   ```

   ```javascript
   //回调函数和this关键字
   function f(param, fun) {
       for (let i = 0; i < 1000; i++) {
           param++;
       }
       fun(param)
   }
   
   var a = {};
   a.say = f1;
   
   function f1() {
       this.name = 1000;
       var that = this;
       f(222, function (param) {
           console.log("this " + this.name);           // undefined
           console.log("global " + global.name);       // undefined
           console.log("that name " + that.name);      // 1000
           console.log("结果 " + param)                 // 1222
       });
   }
   
   a.say();
   console.log(a.name); //1000
   
   ```



## 第八章 BOM

### 1.window 对象

```javascript
//保证兼容性下确定窗口位置
var leftPos = (typeof window.screenLeft == "number") ?
window.screenLeft : window.screenX;
var topPos = (typeof window.screenTop == "number") ?
window.screenTop : window.screenY;

//窗口大小
var pageWidth = window.innerWidth,
pageHeight = window.innerHeight;
if (typeof pageWidth != "number"){
    if (document.compatMode == "CSS1Compat"){
        pageWidth = document.documentElement.clientWidth;
        pageHeight = document.documentElement.clientHeight;
        } else {
        pageWidth = document.body.clientWidth;
        pageHeight = document.body.clientHeight;
    }
}

// 打开新窗口
window.open("http://www.wrox.com/","wroxWindow","height=400,width=400,top=10,left=10,resizable=yes";
            
// 判断弹出窗口是否被屏蔽
var blocked = false;
try {
    var wroxWin = window.open("http://www.wrox.com", "_blank");
        if (wroxWin == null){
        	blocked = true;
        }
    } catch (ex){
        blocked = true;
    }
    if (blocked){
    alert("The popup was blocked!");
} 

```

```javascript
// 间歇调用和超时调用

//超时调用
setTimeout("alert('Hello world!') ", 1000); //不建议传递字符串！
//推荐的调用方式
setTimeout(function() {
	alert("Hello world!");
}, 1000);

//设置超时调用
var timeoutId = setTimeout(function() {
alert("Hello world!");
}, 1000);
//注意：把它取消
clearTimeout(timeoutId);

// 间歇调用
setInterval ("alert('Hello world!') ", 10000); //不建议传递字符串！
//推荐的调用方式
setInterval (function() {
alert("Hello world!");
}, 10000);
```



### 2.location 对象 

|  属性名  |         例子         |                              说                              |
| :------: | :------------------: | :----------------------------------------------------------: |
|   hash   |     "#contents"      |       返回URL中的hash（#号后跟零或多个字符），如果URL        |
|   host   |  "www.wrox.com:80"   |               返回服务器名称和端口号（如果有）               |
| hostname |    "www.wrox.com"    |                  返回不带端口号的服务器名称                  |
|   href   | "http:/www.wrox.com" | 返回当前加载页面的完整URL。而location对象的toString()方法也返回这个值 |
| pathname |     "/WileyCDA/"     |                返回URL中的目录和（或）文件名                 |
|   port   |        "8080"        | 返回URL中指定的端口号。如果URL中不包含端口号，则这个属性返回空字符串 |
| protocol |       "http:"        |           返回页面使用的协议。通常是http:或https:            |
|  search  |   "?q=javascript"    |          返回URL的查询字符串。这个字符串以问号开头           |

```javascript
//位置操作
window.location = "http://www.wrox.com";
location.href = "http://www.wrox.com";
location.replace("http://www.wrox.com/");
location.assign("http://www.wrox.com");

location.reload(); //重新加载（有可能从缓存中加载）
location.reload(true); //重新加载（从服务器重新加载）
```



## 第十章 DOM

### 1. Node 类型

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/Node节点.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/Node%E8%8A%82%E7%82%B9.png"/> </div>

```JavaScript
//新增节点
var returnedNode = someNode.appendChild(newNode);

//someNode 有多个子节点
var returnedNode = someNode.appendChild(someNode.firstChild);
alert(returnedNode == someNode.firstChild); //false
alert(returnedNode == someNode.lastChild); //true

//插入后成为最后一个子节点
returnedNode = someNode.insertBefore(newNode, null);
alert(newNode == someNode.lastChild); //true
//插入后成为第一个子节点
var returnedNode = someNode.insertBefore(newNode, someNode.firstChild);
alert(returnedNode == newNode); //true
alert(newNode == someNode.firstChild); //true
//插入到最后一个子节点前面
returnedNode = someNode.insertBefore(newNode, someNode.lastChild);
alert(newNode == someNode.childNodes[someNode.childNodes.length-2]); //true

//替换第一个子节点
var returnedNode = someNode.replaceChild(newNode, someNode.firstChild);
//替换最后一个子节点
returnedNode = someNode.replaceChild(newNode, someNode.lastChild);

//移除第一个子节点
var formerFirstChild = someNode.removeChild(someNode.firstChild);
//移除最后一个子节点
var formerLastChild = someNode.removeChild(someNode.lastChild);

// 深拷贝
var deepList = myList.cloneNode(true); 
alert(deepList.childNodes.length); //3（ IE < 9）或 7（其他浏览器）
// 浅拷贝
var shallowList = myList.cloneNode(false);
alert(shallowList.childNodes.length);
```



### 2.Document类型

2.1 JavaScript 通过 Document 类型表示文档。在浏览器中， document 对象是 HTMLDocument（继承自 Document 类型）的一个实例，表示整个 HTML 页面。而且， document 对象是 window 对象的一个属性，因此可以将其作为全局对象来访问。 

```javascript
var html = document.documentElement; //取得对<html>的引用
alert(html === document.childNodes[0]); //true
alert(html === document.firstChild); //true

var body = document.body; //取得对<body>的引用

//取得文档标题
var originalTitle = document.title;
//设置文档标题
document.title = "New page title";
//取得完整的 URL
var url = document.URL;
//取得域名
var domain = document.domain;
//取得来源页面的 URL
var referrer = document.referrer;

//如果 URL 中包含一个子域名，例如 p2p.wrox.com，那么就只能将 domain 设置为"wrox.com"（URL 中包含"www"，如 www.wrox.com 时，也是如此）。不能将这个属性设置为 URL 中不包含的域，
document.domain = "wrox.com"; // 成功
document.domain = "nczonline.net"; // 出错

//假设页面来自于 p2p.wrox.com 域  允许由紧绷到松散 不允许松散到紧绷
document.domain = "wrox.com"; //松散的（成功）
document.domain = "p2p.wrox.com"; //紧绷的（出错！）！
```

2.2 查找元素

```javascript
//getElementById
var div = document.getElementById("mydiv");

//getElementsByTagName
var images = document.getElementsByTagName("img");
alert(images.length); //输出图像的数量
alert(images[0].src); //输出第一个图像元素的 src 特性
alert(images.item(0).src); //输出第一个图像元素的 src 特性

//对 HTMLCollection 而言，我们可以向方括号中传入数值或字符串形式的索引值。在后台，对数值索引就会调用 item()，而对字符串索引就会调用 namedItem()。
<img src="myimage.gif" name="myImage">
var myImage = images.namedItem("myImage");
var myImage = images["myImage"];


<fieldset>
    <legend>Which color do you prefer?</legend>
        <ul>
        <li><input type="radio" value="red" name="color" id="colorRed">
        <label for="colorRed">Red</label></li>
        <li><input type="radio" value="green" name="color" id="colorGreen">
        <label for="colorGreen">Green</label></li>
        <li><input type="radio" value="blue" name="color" id="colorBlue">
        <label for="colorBlue">Blue</label></li>
    </ul>
</fieldset>
//getElementsByName
var radios = document.getElementsByName("color");
```



### 3.Element类型

```javascript
<div id="myDiv"></div>
var div = document.getElementById("myDiv");
alert(div.tagName); //"DIV"
alert(div.tagName == div.nodeName); //true

if (element.tagName == "div"){ //不能这样比较，很容易出错！
//在此执行某些操作
}
if (element.tagName.toLowerCase() == "div"){ //这样最好（适用于任何文档）
//在此执行某些操作
}

<div id="myDiv" class="bd" title="Body text" lang="en" dir="ltr"></div>
var div = document.getElementById("myDiv");
// 取值
alert(div.id); //"myDiv""
alert(div.className); //"bd"
alert(div.title); //"Body text"
alert(div.lang); //"en"
alert(div.dir); //"ltr"
//赋值
div.id = "someOtherId";
div.className = "ft";
div.title = "Some other text";
div.lang = "fr";
div.dir ="rtl";
//取值
alert(div.getAttribute("id")); //"myDiv"
alert(div.getAttribute("class")); //"bd"
alert(div.getAttribute("title")); //"Body text"
alert(div.getAttribute("lang")); //"en"
alert(div.getAttribute("dir")); //"ltr"
//赋值
div.setAttribute("id", "someOtherId");
div.setAttribute("class", "ft");
div.setAttribute("title", "Some other text");
div.setAttribute("lang","fr");
div.setAttribute("dir", "rtl");
//删除属性
div.removeAttribute("class");

// 创建元素方式1
var div = document.createElement("div");
div.id = "myNewDiv";
div.className = "box";
document.body.appendChild(div);

//创建元素方式2
var div = document.createElement("<div id=\"myNewDiv\" class=\"box\"></div >");

//查找子元素
var ul = document.getElementById("myList");
//选择所有后代元素中标签为li，不论是否是直接子元素还是间接子元素
var items = ul.getElementsByTagName("li"); 
```



### 4.Text类型

文本节点由 Text 类型表示，包含的是可以照字面解释的纯文本内容。 

- appendData(text)：将 text 添加到节点的末尾。
- deleteData(offset, count)：从 offset 指定的位置开始删除 count 个字符。
-  insertData(offset, text)：在 offset 指定的位置插入 text。
-  replaceData(offset, count, text)：用 text 替换从 offset 指定的位置开始到 offset+count 为止处的文本。
- splitText(offset)：从 offset 指定的位置将当前文本节点分成两个文本节点。
-  substringData(offset, count)：提取从 offset 指定的位置开始到 offset+count 为止处的字符串。 

```javascript
//创建文本节点
var textNode = document.createTextNode("<strong>Hello</strong> world!");

//创建文本节点
var element = document.createElement("div");
element.className = "message";
var textNode = document.createTextNode("Hello world!");
element.appendChild(textNode);
var anotherTextNode = document.createTextNode("Yippee!");
element.appendChild(anotherTextNode);
document.body.appendChild(element);

//规范化文本节点 DOM 文档中存在相邻的同胞文本节点很容易导致混乱，因为分不清哪个文本节点表示哪个字符串
var element = document.createElement("div");
element.className = "message";
var textNode = document.createTextNode("Hello world!");
element.appendChild(textNode);
var anotherTextNode = document.createTextNode("Yippee!");
element.appendChild(anotherTextNode);
document.body.appendChild(element);
alert(element.childNodes.length); //2
element.normalize();
alert(element.childNodes.length); //1
alert(element.firstChild.nodeValue); // "Hello world!Yippee!"

//分割文本节点
var element = document.createElement("div");
element.className = "message";
var textNode = document.createTextNode("Hello world!");
element.appendChild(textNode);
document.body.appendChild(element);
var newNode = element.firstChild.splitText(5);
alert(element.firstChild.nodeValue); //"Hello"
alert(newNode.nodeValue); //" world!"
alert(element.childNodes.length); //2
```



### 5.动态创建表格

**为\<table>元素添加的属性和方法如下：**

- caption：保存着对\<caption>元素（如果有）的指针。
- tBodies：是一个\<tbody>元素的 HTMLCollection。
- tFoot：保存着对\<tfoot>元素（如果有）的指针。
- tHead：保存着对\<thead>元素（如果有）的指针。
- rows：是一个表格中所有行的 HTMLCollection。
- createTHead()：创建\<thead>元素，将其放到表格中，返回引用。
- createTFoot()：创建\<tfoot>元素，将其放到表格中，返回引用。
- createCaption()：创建\<caption>元素，将其放到表格中，返回引用。
- deleteTHead()：删除\<thead>元素。
- deleteTFoot()：删除\<tfoot>元素。
- deleteCaption()：删除\<caption>元素。
- deleteRow(pos)：删除指定位置的行。
-  insertRow(pos)：向 rows 集合中的指定位置插入一行。

**为\<tbody>元素添加的属性和方法如下：**

- rows：保存着\<tbody>元素中行的 HTMLCollection。
- deleteRow(pos)：删除指定位置的行。
- insertRow(pos)：向 rows 集合中的指定位置插入一行，返回对新插入行的引用。

**为\<tr>元素添加的属性和方法如下：**

- cells：保存着\<tr>元素中单元格的 HTMLCollection。
- deleteCell(pos)：删除指定位置的单元格。
- insertCell(pos)：向 cells 集合中的指定位置插入一个单元格，返回对新插入单元格的引用。  

```javascript
//创建 table
var table = document.createElement("table");
table.border = 1;
table.width = "100%";
//创建 tbody
var tbody = document.createElement("tbody");
table.appendChild(tbody);
//创建第一行
tbody.insertRow(0);
tbody.rows[0].insertCell(0);
tbody.rows[0].cells[0].appendChild(document.createTextNode("Cell 1,1"));
tbody.rows[0].insertCell(1);
tbody.rows[0].cells[1].appendChild(document.createTextNode("Cell 2,1"));
//创建第二行
tbody.insertRow(1);
tbody.rows[1].insertCell(0);
tbody.rows[1].cells[0].appendChild(document.createTextNode("Cell 1,2"));
tbody.rows[1].insertCell(1);
tbody.rows[1].cells[1].appendChild(document.createTextNode("Cell 2,2"));
//将表格添加到文档主体中
document.body.appendChild(table);
```



## 第十一章 DOM扩展

**1. querySelector()方法** 

querySelector()方法接收一个 **CSS 选择符**，返回与该模式匹配的第一个元素，如果没有找到匹配的元素，返回 null。 	

```javascript
//取得 body 元素
var body = document.querySelector("body");
//取得 ID 为"myDiv"的元素
var myDiv = document.querySelector("#myDiv");
//取得类为"selected"的第一个元素
var selected = document.querySelector(".selected");
//取得类为"button"的第一个图像元素
var img = document.body.querySelector("img.button");
```

**2.querySelectorAll()方法** 

querySelectorAll()方法接收的参数与 querySelector()方法一样，**都是一个 CSS 选择符**，但返回的是所有匹配的元素而不仅仅是一个元素。这个方法返回的是一个 NodeList 的实例。 如果没有找到匹配的元素， NodeList 就是空的。 

```javascript
//取得某<div>中的所有<em>元素（类似于 getElementsByTagName("em")）
var ems = document.getElementById("myDiv").querySelectorAll("em");
//取得类为"selected"的所有元素
var selecteds = document.querySelectorAll(".selected");
//取得所有<p>元素中的所有<strong>元素
var strongs = document.querySelectorAll("p strong");

//要取得返回的 NodeList 中的每一个元素，可以使用 item()方法，也可以使用方括号语法，比如：
var i, len, strong;
for (i=0, len=strongs.length; i < len; i++){
    strong = strongs[i]; //或者 strongs.item(i)
    strong.className = "important";
}
```

**3.元素遍历**

Element Traversal API 为 DOM 元素添加了以下 5 个属性。

-  childElementCount：返回子元素（不包括文本节点和注释）的个数。
-  firstElementChild：指向第一个子元素； firstChild 的元素版。
-  lastElementChild：指向最后一个子元素； lastChild 的元素版。
-  previousElementSibling：指向前一个同辈元素； previousSibling 的元素版。
-  nextElementSibling：指向后一个同辈元素； nextSibling 的元素版。

**支持的浏览器为 DOM 元素添加了这些属性，利用这些元素不必担心空白文本节点。**



**4.getElementsByClassName()方法** 

```javascript
//取得所有类中包含"username"和"current"的元素，类名的先后顺序无所谓
var allCurrentUsernames = document.getElementsByClassName("username current");
//取得 ID 为"myDiv"的元素中带有类名"selected"的所有元素
var selected = document.getElementById("myDiv").getElementsByClassName("selected");
```



**5.classList 属性**

classList 属性是新集合类型 DOMTokenList 的实例。与其他 DOM 集合类似，OMTokenList 有一个表示自己包含多少元素的 length 属性，而要取得每个元素可以使用 item()方法，也可以使用方括号语法。此外，这个新类型还定义如下方法。

- add(value)：将给定的字符串值添加到列表中。如果值已经存在，就不添加了。
- contains(value)：表示列表中是否存在给定的值，如果存在则返回 true，否则返回 false。
- remove(value)：从列表中删除给定的字符串。
- toggle(value)：如果列表中已经存在给定的值，删除它；如果列表中没有给定的值，添加它。  

```javascript
<div class="bd user disabled">...</div>

//删除"disabled"类
div.classList.remove("disabled");
//添加"current"类
div.classList.add("current");
//切换"user"类
div.classList.toggle("user");
//确定元素中是否包含既定的类名
if (div.classList.contains("bd") && !div.classList.contains("disabled")){
//执行操作
)
//迭代类名
for (var i=0, len=div.classList.length; i < len; i++){
doSomething(div.classList[i]);
}
```

**6. 焦点管理**

```javascript
var button = document.getElementById("myButton");
button.focus();
alert(document.activeElement === button); //true

var button = document.getElementById("myButton");
button.focus();
alert(document.hasFocus()); //true
```

**7.readyState 属性**

```javascript
//loading，正在加载文档；
//complete，已经加载完文档。
if (document.readyState == "complete"){
//执行操作
}
```

**8.自定义属性**

```javascript
<div id="myDiv" data-appId="12345" data-myname="Nicholas"></div>
//本例中使用的方法仅用于演示
var div = document.getElementById("myDiv");
//取得自定义属性的值
var appId = div.dataset.appId;
var myName = div.dataset.myname;
//设置值
div.dataset.appId = 23456;
div.dataset.myname = "Michael";
//有没有"myname"值呢？
if (div.dataset.myname){
    alert("Hello, " + div.dataset.myname);
}
```



**9.innerHTML 属性 和 outerHTML 属性** 

​	在读模式下， **innerHTML** 属性返回与调用元素的所有子节点（包括元素、注释和文本节点）对应的 HTML 标记。在写模式下， innerHTML 会根据指定的值创建新的 DOM 树，然后用这个 DOM 树完全替换调用元素原先的所有子节点。下面是一个例子。

​	在读模式下， **outerHTML** 返回调用它的元素及所有子节点的 HTML 标签。在写模式下， outerHTML会根据指定的 HTML 字符串创建新的 DOM 子树，然后用这个 DOM 子树完全替换调用元素。  



**10.insertAdjacentHTML()方法** 

- "**beforebegin**"，在当前元素之前插入一个紧邻的同辈元素；

- "**afterbegin**"，在当前元素之下插入一个新的子元素或在第一个子元素之前再插入新的子元素；

- "**beforeend**"，在当前元素之下插入一个新的子元素或在最后一个子元素之后再插入新的子元素；

- "**afterend**"，在当前元素之后插入一个紧邻的同辈元素。 

  ```javascript
  //作为前一个同辈元素插入
  element.insertAdjacentHTML("beforebegin", "<p>Hello world!</p>");
  //作为第一个子元素插入
  element.insertAdjacentHTML("afterbegin", "<p>Hello world!</p>");
  //作为最后一个子元素插入
  element.insertAdjacentHTML("beforeend", "<p>Hello world!</p>");
  //作为后一个同辈元素插入
  element.insertAdjacentHTML("afterend", "<p>Hello world!</p>");
  ```

**11.滚动** 

**scrollIntoView()** ：可以在所有 HTML 元素上调用，通过滚动浏览器窗口或某个容器元素，调用元素就可以出现在视口中。如果给这个方法传入 true 作为参数，或者不传入任何参数，那么窗口滚动之后会让调用元素的顶部与视口顶部尽可能平齐。如果传入 false 作为参数，调用元素会尽可能全部出现在视口中，（可能的话，调用元素的底部会与视口顶部平齐。）不过顶部不一定平齐。

**scrollIntoViewIfNeeded(alignCenter)** ：只在当前元素在视口中不可见的情况下，才滚动浏览器窗口或容器元素，最终让它可见。如果当前元素在视口中可见，这个方法什么也不做。如果将可选的 alignCenter 参数设置为 true，则表示尽量将元素显示在视口中部（垂直方向）。Safari 和 Chrome 实现了这个方法。
 **scrollByLines(lineCount)：**将元素的内容滚动指定的行高， lineCount 值可以是正值，也可以是负值。 Safari 和 Chrome 实现了这个方法。
 **scrollByPages(pageCount)：**将元素的内容滚动指定的页面高度，具体高度由元素的高度决定。 Safari 和 Chrome 实现了这个方法。 

```javascript
//让元素可见
document.forms[0].scrollIntoView(); 

//将页面主体滚动 5 行
document.body.scrollByLines(5);

//在当前元素不可见的时候，让它进入浏览器的视口
document.images[0].scrollIntoViewIfNeeded();

//将页面主体往回滚动 1 页
document.body.scrollByPages(-1);
```



**12.contains()方法** 

判断某个节点是不是另一个节点的后代。 

```javascript
alert(document.documentElement.contains(document.body)); //true
```



## 第十二章 DOM2和DOM3

**1.偏移量、客户区大小、滚动大小**

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/偏移量.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/%E5%81%8F%E7%A7%BB%E9%87%8F.png"/> </div>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/客户区大小.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/%E5%AE%A2%E6%88%B7%E5%8C%BA%E5%A4%A7%E5%B0%8F.png"/> </div>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/滚动大小.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/%E6%BB%9A%E5%8A%A8%E5%A4%A7%E5%B0%8F.png"/> </div>

## 第十三 事件

### 13.1 DOM事件流 

“DOM2级事件”规定的事件流包括三个阶段：事件捕获阶段、处于目标阶段和事件冒泡阶段。首先发生的是事件捕获，为截获事件提供了机会。然后是实际的目标接收到事件。最后一个阶段是冒泡阶段，可以在这个阶段对事件做出响应。 

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/事件流.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/%E4%BA%8B%E4%BB%B6%E6%B5%81.png"/> </div>

### 13.2 事件处理程序

#### 1. DOM0 级事件处理程序 

使用 DOM0 级方法指定的事件处理程序被认为是元素的方法。因此，这时候的事件处理程序是在元素的作用域中运行；换句话说，程序中的 this 引用当前元素。 

```javascript
// 绑定事件
var btn = document.getElementById("myBtn");
btn.onclick = function(){
	alert(this.id); //"myBtn"
};
btn.onclick = null; //删除事件处理程序
```

#### 2. DOM2 级事件处理程序 

“DOM2 级事件” 定义了两个方法，用于处理指定和删除事件处理程序的操作： addEventListener()和 removeEventListener()。所有 DOM 节点中都包含这两个方法，并且它们都接受 3 个参数：要处理的事件名、作为事件处理程序的函数和一个布尔值。最后这个布尔值参数如果是 true，表示在捕获阶段调用事件处理程序；如果是 false，表示在冒泡阶段调用事件处理程序。 **使用 DOM2 级方法添加事件处理程序的主要好处是可以添加多个事件处理程序。** 

```javascript
var btn = document.getElementById("myBtn");
btn.addEventListener("click", function(){
	alert(this.id);
}, false);
btn.addEventListener("click", function(){
	alert("Hello world!");
}, false);

btn.removeEventListener("click", function(){ //没有用！
alert(this.id);
}, false);


//有效解绑
var btn = document.getElementById("myBtn");
var handler = function(){
alert(this.id);
};
btn.addEventListener("click", handler, false);
//这里省略了其他代码
btn.removeEventListener("click", handler, false); //有效
```

#### 3.兼容IE

```javascript
var EventUtil = {
addHandler: function(element, type, handler){
        if (element.addEventListener){
        	element.addEventListener(type, handler, false);
        } else if (element.attachEvent){
        	element.attachEvent("on" + type, handler);
        } else {
        	element["on" + type] = handler;
        }
        },
    removeHandler: function(element, type, handler){
        if (element.removeEventListener){
       		element.removeEventListener(type, handler, false);
        } else if (element.detachEvent){
        	element.detachEvent("on" + type, handler);
        } else {
        	element["on" + type] = null;
    }
}
};
```



### 13.3 事件处理程序

兼容 DOM 的浏览器会将一个 event 对象传入到事件处理程序中。无论指定事件处理程序时使用什么方法（DOM0 级或 DOM2 级），都会传入 event 对象。 

```javascript
var btn = document.getElementById("myBtn");
btn.onclick = function(event){
	alert(event.type); //"click"
};
btn.addEventListener("click", function(event){
	alert(event.type); //"click"
}, false);
```

event 对象包含与创建它的特定事件有关的属性和方法。触发的事件类型不一样，可用的属性和方法也不一样。不过，所有事件都会有下表列出的成员。 

|         属性/方法          |    类 型     | 读/写 | 说 明                                                        |
| :------------------------: | :----------: | :---: | :----------------------------------------------------------- |
|           target           |   Element    | 只读  | 事件的目标                                                   |
|          bubbles           |   Boolean    | 只读  | 表明事件是否冒泡                                             |
|         cancelable         |   Boolean    | 只读  | 表明是否可以取消事件的默认行为                               |
|       currentTarget        |   Element    | 只读  | 其事件处理程序当前正在处理事件的那个元素                     |
|      defaultPrevented      |   Boolean    | 只读  | 为 true 表 示 已 经 调 用 了 preventDefault()（DOM3级事件中新增） |
|           detail           |   Integer    | 只读  | 与事件相关的细节信息                                         |
|         eventPhase         |   Integer    | 只读  | 调用事件处理程序的阶段： 1表示捕获阶段， 2表示“处于目标”， 3表示冒泡阶段 |
|      preventDefault()      |   Function   | 只读  | 取 消 事 件 的 默 认 行 为 。 如 果 cancelable是true，则可以使用这个方法 |
| stopImmediatePropagation() |   Function   | 只读  | 取消事件的进一步捕获或冒泡，同时阻止任何事件处理程序被调用（DOM3级事件中新增） |
|     stopPropagation()      |   Function   | 只读  | 取消事件的进一步捕获或冒泡。如果bubbles为true，则可以使用这个方法 |
|          trusted           |   Boolean    | 只读  | 为true表示事件是浏览器生成的。为false表示 事 件 是 由 开 发 人 员 通 过 JavaScript 创 建 的（DOM3级事件中新增） |
|            type            |    String    | 只读  | 被触发的事件的类型                                           |
|            view            | AbstractView | 只读  | 与事件关联的抽象视图。等同于发生事件的window对象             |

```javascript
//点击myBtn元素
var btn = document.getElementById("myBtn");
btn.onclick = function(event){
    alert(event.currentTarget === this); //true
    alert(event.target === this); //true
};

document.body.onclick = function(event){
	alert(event.currentTarget === document.body); //true
	alert(this === document.body); //true
	alert(event.target === document.getElementById("myBtn")); //true
};

//阻止默认行为
var link = document.getElementById("myLink");
    link.onclick = function(event){
    event.preventDefault();
};

//阻止冒泡
var btn = document.getElementById("myBtn");
    btn.onclick = function(event){
    alert("Clicked");
    event.stopPropagation();
};
```

事件对象的 eventPhase 属性，可以用来确定事件当前正位于事件流的哪个阶段。如果是在捕获阶段调用的事件处理程序，那么 eventPhase 等于 1；如果事件处理程序处于目标对象上，则 eventPhase 等于 2；如果是在冒泡阶段调用的事件处理程序，eventPhase 等于 3。这里要注意的是，尽管“处于目标”发生在冒泡阶段，但 eventPhase 仍然一直等于 2。 

```javascript
var btn = document.getElementById("myBtn");
btn.onclick = function(event){
	alert(event.eventPhase); //2
};
document.body.addEventListener("click", function(event){
	alert(event.eventPhase); //1
}, true);
document.body.onclick = function(event){
	alert(event.eventPhase); //3
};
```

### 13.4 事件类型

#### 1.UI 事件

UI 事件指的是那些不一定与用户操作有关的事件。这些事件在 DOM 规范出现之前，都是以这种或那种形式存在的，而在 DOM 规范中保留是为了向后兼容。现有的 UI 事件如下。

- **load**：当页面完全加载后在 window 上面触发，当所有框架都加载完毕时在框架集上面触发，当图像加载完毕时在\<img>元素上面触发，或者当嵌入的内容加载完毕时在\<object>元素上面触发。
- **unload**：当页面完全卸载后在 window 上面触发，当所有框架都卸载后在框架集上面触发，或者当嵌入的内容卸载完毕后在\<object>元素上面触发。
- **abort**：在用户停止下载过程时，如果嵌入的内容没有加载完，则在\<object>元素上面触发。
- **error**：当发生 JavaScript 错误时在 window 上面触发，当无法加载图像时在\<img>元素上面触发，当无法加载嵌入内容时在\<object>元素上面触发，或者当有一或多个框架无法加载时在框架集上面触发。
- **select**：当用户选择文本框（\<input>或\<texterea>）中的一或多个字符时触发。
- **resize**：当窗口或框架的大小变化时在 window 或框架上面触发。
- **scroll**：当用户滚动带滚动条的元素中的内容时，在该元素上面触发。 \<body>元素中包含所加载页面的滚动条。

多数这些事件都与 window 对象或表单控件相关。  

```javascript
EventUtil.addHandler(window, "load", function(event){
	alert("Loaded!");
});

<body onload="alert('Loaded!')">

// 加载图片    
<img src="smile.gif" onload="alert('Image loaded.')">
    
var image = document.getElementById("myImage");
EventUtil.addHandler(image, "load", function(event){
    event = EventUtil.getEvent(event);
    alert(EventUtil.getTarget(event).src);
});

//创建并加载图片
EventUtil.addHandler(window, "load", function(){
var image = document.createElement("img");
EventUtil.addHandler(image, "load", function(event){
    event = EventUtil.getEvent(event);
    alert(EventUtil.getTarget(event).src);
});
document.body.appendChild(image);
	image.src = "smile.gif";
});

//创建并加载图片2
EventUtil.addHandler(window, "load", function(){
var image = new Image();
EventUtil.addHandler(image, "load", function(event){
alert("Image loaded!");
});
image.src = "smile.gif";
});

//创建并加载脚本
EventUtil.addHandler(window, "load", function(){
var script = document.createElement("script");
EventUtil.addHandler(script, "load", function(event){
alert("Loaded");
});
script.src = "example.js";
document.body.appendChild(script);
});
```

#### 2.焦点事件

**blur**：在元素失去焦点时触发。这个事件不会冒泡；所有浏览器都支持它。 

**focus**：在元素获得焦点时触发。这个事件不会冒泡；所有浏览器都支持它。 

#### 3.鼠标和滚轮事件

**3.1 鼠标事件**

鼠标事件是 Web 开发中最常用的一类事件，毕竟鼠标还是最主要的定位设备。 DOM3 级事件中定义了 9 个鼠标事件。

- **click**：在用户单击主鼠标按钮（一般是左边的按钮）或者按下回车键时触发。这一点对确保易访问性很重要，意味着 onclick 事件处理程序既可以通过键盘也可以通过鼠标执行。

- **dblclick**：在用户双击主鼠标按钮（一般是左边的按钮）时触发。从技术上说，这个事件并不是 DOM2 级事件规范中规定的，但鉴于它得到了广泛支持，所以 DOM3 级事件将其纳入了标准。

- **mousedown**：在用户按下了任意鼠标按钮时触发。不能通过键盘触发这个事件。

- **mouseenter**：在鼠标光标从元素外部首次移动到元素范围之内时触发。这个事件不冒泡，而且在光标移动到后代元素上不会触发。 DOM2 级事件并没有定义这个事件，但 DOM3 级事件将它纳入了规范。 IE、 Firefox 9+和 Opera 支持这个事件。

- **mouseleave**：在位于元素上方的鼠标光标移动到元素范围之外时触发。这个事件不冒泡，而且在光标移动到后代元素上不会触发。 DOM2 级事件并没有定义这个事件，但 DOM3 级事件将它纳入了规范。 IE、 Firefox 9+和 Opera 支持这个事件。

- **mousemove**：当鼠标指针在元素内部移动时重复地触发。不能通过键盘触发这个事件。 

- **mouseout**：在鼠标指针位于一个元素上方，然后用户将其移入另一个元素时触发。又移入的另一个元素可能位于前一个元素的外部，也可能是这个元素的子元素。不能通过键盘触发这个事件。

- **mouseover**：在鼠标指针位于一个元素外部，然后用户将其首次移入另一个元素边界之内时触发。不能通过键盘触发这个事件。

- **mouseup**：在用户释放鼠标按钮时触发。不能通过键盘触发这个事件。 


**3.2 位置：**

```javascript
//客户区坐标位置 相对于浏览器可视窗口
var div = document.getElementById("myDiv");
EventUtil.addHandler(div, "click", function(event){
	event = EventUtil.getEvent(event);
	alert("Client coordinates: " + event.clientX + "," + event.clientY);
});

//页面坐标位置  相对于整个html页面
var div = document.getElementById("myDiv");
EventUtil.addHandler(div, "click", function(event){
	event = EventUtil.getEvent(event);
	alert("Page coordinates: " + event.pageX + "," + event.pageY);
});

//屏幕坐标位置 相对于整个电脑屏幕
var div = document.getElementById("myDiv");
EventUtil.addHandler(div, "click", function(event){
	event = EventUtil.getEvent(event);
	alert("Screen coordinates: " + event.screenX + "," + event.screenY);
});
```



**3.3  修改键**

虽然鼠标事件主要是使用鼠标来触发的，但在按下鼠标时键盘上的某些键的状态也可以影响到所要采取的操作。这些修改键就是 Shift、 Ctrl、 Alt 和 Meta（在 Windows 键盘中是 Windows 键，在苹果机中是 Cmd 键），它们经常被用来修改鼠标事件的行为。 DOM 为此规定了 4 个属性，表示这些修改键的状态： shiftKey、 ctrlKey、 altKey 和 metaKey。这些属性中包含的都是布尔值，如果相应的键被按下了，则值为 true，否则值为 false。

```javascript
var div = document.getElementById("myDiv");
EventUtil.addHandler(div, "click", function(event){
event = EventUtil.getEvent(event);
var keys = new Array();
	if (event.shiftKey){
keys.push("shift");
}
if (event.ctrlKey){
	keys.push("ctrl");
}
if (event.altKey){
	keys.push("alt");
}
if (event.metaKey){
	keys.push("meta");
}
	alert("Keys: " + keys.join(","));
});
```

**3.4 相关元素**

在发生 mouseover 和 mouserout 事件时，还会涉及更多的元素。这两个事件都会涉及把鼠标指针从一个元素的边界之内移动到另一个元素的边界之内。对 mouseover 事件而言，事件的主目标是获得光标的元素，而相关元素就是那个失去光标的元素。类似地，对 mouseout 事件而言，事件的主目标是失去光标的元素，而相关元素则是获得光标的元素。DOM 通过 event 对象的 **relatedTarget** 属性提供了相关元素的信息。 **这个属性只对于 mouseover和 mouseout 事件才包含值**；对于其他事件，这个属性的值是 null。 

**3.5 鼠标按钮** 

只有在主鼠标按钮被单击（或键盘回车键被按下）时才会触发 click 事件，因此检测按钮的信息并不是必要的。但对mousedown 和 mouseup 事件来说，则在其 event 对象存在一个 button 属性，表示按下或释放的按钮。 DOM 的 button 属性可能有如下 3 个值： 0 表示主鼠标按钮， 1 表示中间的鼠标按钮（鼠标滚轮按钮）， 2 表示次鼠标按钮。 

**3.6 鼠标滚轮事件**

```javascript
EventUtil.addHandler(document, "mousewheel", function(event){
	event = EventUtil.getEvent(event);
	alert(event.wheelDelta);
});
```



#### 4.键盘与文本事件

**4.1 键盘事件与文本事件**

**键盘事件**:

- **keydown**：当用户按下键盘上的任意键时触发，而且如果按住不放的话，会重复触发此事件。
- **keypress**：当用户按下键盘上的字符键时触发，而且如果按住不放的话，会重复触发此事件。按下 Esc 键也会触发这个事件。Safari 3.1 之前的版本也会在用户按下非字符键时触发 keypress事件。
- **keyup**：当用户释放键盘上的键时触发。 

**文本事件：**

-  **textInput**。这个事件是对 keypress 的补充，用意是在将文本显示给用户之前更容易拦截文本。在文本插入文本框之前会触发 textInput 事件。 

**4.2 键码**

在发生 **keydown** 和 **keyup** 事件时， event 对象的 **keyCode** 属性中会包含一个代码，与键盘上一个特定的键对应。 （回车键定对应的键码为13）

**4.3 字符编码**

发生 **keypress** 事件意味着按下的键会影响到屏幕中文本的显示。在所有浏览器中，按下能够插入或删除字符的键都会触发 keypress 事件。IE9、 Firefox、 Chrome 和 Safari 的 event 对象都支持一个 **charCode** 属性，这个属性只有在发生keypress 事件时才包含值，而且这个值是按下的那个键所代表字符的 ASCII 编码。此时的 keyCode通常等于 0 或者也可能等于所按键的键码。

**4.5 textInput 事件** 

由于 textInput 事件主要考虑的是字符，因此它的 event 对象中还包含一个 data 属性，这个属性的值就是用户输入的字符（而非字符编码）。 

```javascript
var textbox = document.getElementById("myText");
EventUtil.addHandler(textbox, "textInput", function(event){
    event = EventUtil.getEvent(event);
    alert(event.data);
});
```

另外， event 对象上还有一个属性，叫 **inputMethod**，表示把文本输入到文本框中的方式。

- 0，表示浏览器不确定是怎么输入的。
- 1，表示是使用键盘输入的。
- 2，表示文本是粘贴进来的。
- 3，表示文本是拖放进来的。
- 4，表示文本是使用 IME 输入的。
- 5，表示文本是通过在表单中选择某一项输入的。
- 6，表示文本是通过手写输入的（比如使用手写笔）。
- 7，表示文本是通过语音输入的。
- 8，表示文本是通过几种方法组合输入的。
- 9，表示文本是通过脚本输入的。 



#### 5.变动事件

DOM2 级的变动（mutation）事件能在 DOM 中的某一部分发生变化时给出提示。变动事件是为 XML或 HTML DOM 设计的，并不特定于某种语言。 DOM2 级定义了如下变动事件。

- **DOMSubtreeModified**：在 DOM 结构中发生任何变化时触发。这个事件在其他任何事件触发后都会触发。
- **DOMNodeInserted**：在一个节点作为子节点被插入到另一个节点中时触发。
- **DOMNodeRemoved**：在节点从其父节点中被移除时触发。
- **DOMNodeInsertedIntoDocument**：在一个节点被直接插入文档或通过子树间接插入文档之后触发。这个事件在 DOMNodeInserted 之后触发。
- **DOMNodeRemovedFromDocument**：在一个节点被直接从文档中移除或通过子树间接从文档中移除之前触发。这个事件在 DOMNodeRemoved 之后触发。
- **DOMAttrModified**：在特性被修改之后触发。
- **DOMCharacterDataModified**：在文本节点的值发生变化时触发。 



#### 6.HTML5事件

**6.1 beforeunload 事件**

之所以有发生在 window 对象上的 beforeunload 事件，是为了让开发人员有可能在页面卸载前阻止这一操作。这个事件会在浏览器卸载页面之前触发，可以通过它来取消卸载并继续使用原有页面。  

为了显示这个弹出对话框，必须将 event.returnValue 的值设置为要显示给用户的字符串（对IE 及 Fiefox 而言），同时作为函数的值返回（对 Safari 和 Chrome 而言），如下面的例子所示。 

```javascript
EventUtil.addHandler(window, "beforeunload", function(event){
    event = EventUtil.getEvent(event);
    var message = "I'm really going to miss you if you go.";
    event.returnValue = message;
    return message;
});
```

**6.2 DOMContentLoaded 事件**

如前所述， window 的 load 事件会在页面中的一切都加载完毕时触发，但这个过程可能会因为要加载的外部资源过多而颇费周折。而 DOMContentLoaded 事件则在形成完整的 DOM 树之后就会触发，不理会图像、 JavaScript 文件、 CSS 文件或其他资源是否已经下载完毕。与 load 事件不同，DOMContentLoaded 支持在页面下载的早期添加事件处理程序，这也就意味着用户能够尽早地与页面进行交互。
要处理 DOMContentLoaded 事件，可以为 document 或 window 添加相应的事件处理程序（尽管这个事件会冒泡到 window，但它的目标实际上是 document）。来看下面的例子。

```javascript
EventUtil.addHandler(document, "DOMContentLoaded", function(event){
	alert("Content loaded");
}); 
```

**6.3 hashchange 事件** 

HTML5 新增了 hashchange 事件，以便在 URL 的参数列表（及 URL 中“#”号后面的所有字符串）发生变化时通知开发人员。之所以新增这个事件，是因为在 Ajax 应用中，开发人员经常要利用 URL 参数列表来保存状态或导航信息。
必须要把 hashchange 事件处理程序添加给 window 对象，然后 URL 参数列表只要变化就会调用它。此时的 event 对象应该额外包含两个属性： oldURL 和 newURL。 

```javascript
EventUtil.addHandler(window, "hashchange", function(event){
	alert("Old URL: " + event.oldURL + "\nNew URL: " + event.newURL);
});

//保证兼容性的情况下可以按照此方法调用得到当前参数列表
EventUtil.addHandler(window, "hashchange", function(event){
alert("Current hash: " + location.hash);
});
```



### 第十四章 表单脚本

### 14.1 表单基础知识

在 HTML 中，表单是由\<form>元素来表示的，而在 JavaScript 中，表单对应的则是 HTMLFormElement 类型。HTMLFormElement 继承了 HTMLElement，因而与其他 HTML 元素具有相同的默认属性。不过， HTMLFormElement 也有它自己下列独有的属性和方法。

- **acceptCharset**：服务器能够处理的字符集；等价于 HTML 中的 accept-charset 特性。
- **action**：接受请求的 URL；等价于 HTML 中的 action 特性。
- **elements**：表单中所有控件的集合（HTMLCollection）。
- **enctype**：请求的编码类型；等价于 HTML 中的 enctype 特性。
- **length**：表单中控件的数量。
- **method**：要发送的 HTTP 请求类型，通常是"get"或"post"；等价于 HTML 的 method 特性。
- **name**：表单的名称；等价于 HTML 的 name 特性。
- **reset()**：将所有表单域重置为默认值。
- **submit()**：提交表单。
- **target**：用于发送请求和接收响应的窗口名称；等价于 HTML 的 target 特性。 



#### 1.提交表单

```html
<!-- 提交表单方式一 -->
<!-- 通用提交按钮 -->
<input type="submit" value="Submit Form">
<!-- 自定义提交按钮 -->
<button type="submit">Submit Form</button>
<!-- 图像按钮 -->
<input type="image" src="graphic.gif">
```

以这种方式提交表单时，浏览器会在将请求发送给服务器之前触发 submit 事件。这样，我们就有机会验证表单数据，并据以决定是否允许表单提交。阻止这个事件的默认行为就可以取消表单提交。例如，下列代码会阻止表单提交。 

```javascript
var form = document.getElementById("myForm");
EventUtil.addHandler(form, "submit", function(event){
    //取得事件对象
    event = EventUtil.getEvent(event);
    //阻止默认事件
    EventUtil.preventDefault(event);
});
```

```javascript
//提交表单方式二
var form = document.getElementById("myForm");
//提交表单
form.submit();
```

调用 submit()方法的形式提交表单时，**不会触发 submit 事件**，因此要记得在调用此方法之前先验证表单数据 。



#### 2.重置表单

```html
<!-- 通用重置按钮 -->
<input type="reset" value="Reset Form">
<!-- 自定义重置按钮 -->
<button type="reset">Reset Form</button>
```

```javascript
var form = document.getElementById("myForm");
EventUtil.addHandler(form, "reset", function(event){
    //取得事件对象
    event = EventUtil.getEvent(event);
    //阻止表单重置
    EventUtil.preventDefault(event);
});
```

```javascript
var form = document.getElementById("myForm");
//重置表单
form.reset();
```

**与调用 submit()方法不同，调用 reset()方法会像单击重置按钮一样触发 reset 事件。**

 

#### 3.表单字段

```javascript
var form = document.getElementById("form1");
//取得表单中的第一个字段
var field1 = form.elements[0];
//取得名为"textbox1"的字段
var field2 = form.elements["textbox1"];
//取得表单中包含的字段的数量
var fieldCount = form.elements.length;

<form method="post" id="myForm">
    <ul>
        <li><input type="radio" name="color" value="red">Red</li>
        <li><input type="radio" name="color" value="green">Green</li>
        <li><input type="radio" name="color" value="blue">Blue</li>
    </ul>
</form>

var form = document.getElementById("myForm");
var colorFields = form.elements["color"];
alert(colorFields.length); //3
var firstColorField = colorFields[0];
var firstFormField = form.elements[0];
alert(firstColorField === firstFormField); //true
```

##### 3.1 共有的表单字段属性

除了\<fieldset>元素之外，所有表单字段都拥有相同的一组属性。由于\<input>类型可以表示多种表单字段，因此有些属性只适用于某些字段，但还有一些属性是所有字段所共有的。表单字段共有的属性如下。

- **disabled**：布尔值，表示当前字段是否被禁用。
- **form**：指向当前字段所属表单的指针；**只读**。
- **name**：当前字段的名称。
- **readOnly**：布尔值，表示当前字段是否只读。
- **tabIndex**：表示当前字段的切换（tab）序号。
- **type**：当前字段的类型，如"checkbox"、 "radio"，等等。
- **value**：当前字段将被提交给服务器的值。对文件字段来说，这个属性是只读的，包含着文件在计算机中的路径。

```javascript
var form = document.getElementById("myForm");
var field = form.elements[0];
//修改 value 属性
field.value = "Another value";
//检查 form 属性的值
alert(field.form === form); //true
//把焦点设置到当前字段
field.focus();
//禁用当前字段
field.disabled = true;

//避免多次提交表单
EventUtil.addHandler(form, "submit", function(event){
event = EventUtil.getEvent(event);
var target = EventUtil.getTarget(event);
//取得提交按钮
var btn = target.elements["submit-btn"];
//禁用它
btn.disabled = true;
});
```

##### 3.2 共有的表单字段方法 

每个表单字段都有两个方法：  即 **focus()** 和 **blur()**

```javascript
//html5 新增属性 autofocus
<input type="text" autofocus>

// js 设置方式   
EventUtil.addHandler(window, "load", function(event){
	var element = document.forms[0].elements[0];
    if (element.autofocus !== true){
		element.focus(); 
        console.log("JS focus");
    }
});
document.forms[0].elements[0].blur();
```

##### 3.3 共有的表单字段事件

除了支持鼠标、键盘、更改和 HTML 事件之外，所有表单字段都支持下列 3 个事件。
**blur**：当前字段失去焦点时触发。
**change**：对于\<input>和\<textarea>元素，在它们失去焦点且 value 值改变时触发；对于\<select>元素，在其选项改变时触发。
**focus**：当前字段获得焦点时触发。 



### 14.2 文本框脚本

```javascript
<input type="text" size="25" maxlength="50" value="initial value">
    
<textarea rows="25" cols="5">initial value</textarea>    

var textbox = document.forms[0].elements["textbox1"];
alert(textbox.value);
textbox.value = "Some new value";
```

#### 1. 选择文本

 选择（**select**）事件

```javascript
//鼠标选择文本时候触发
var textbox = document.forms[0].elements["textbox1"];
EventUtil.addHandler(textbox, "select", function(event){
var alert("Text selected" + textbox.value);
});
```

获取选中的内容**selectionStart**,**selectionEnd**，设置选中的范围**setSelectionRange**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <label for="inputId">输入</label><input id="inputId" maxlength="10" value="123456789" autofocus>
</body>
    <script>
        let input = document.getElementById('inputId');
        input.addEventListener("select",function (event) {
            console.log("选择的文本"+input.value.substring(input.selectionStart,input.selectionEnd));
            //设置选中的范围
            input.setSelectionRange(0,5)
        })
    </script>
</html>
```

#### 2. 过滤输入(**keypress**)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <label for="inputId">输入</label><input id="inputId" type="text" autofocus>
    <button>点击</button>
</body>
    <script>
        let put = document.getElementById('inputId');
        put.addEventListener("keypress",function (event) {
            console.log(event.key);
           if (!/\d/.test(event.key)){
               event.preventDefault()
           }
        });
    </script>
</html>
```

#### 3.自动切换焦点

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <label for="inputId1">输入1</label>
    <input id="inputId1" type="text" maxlength="3" autofocus>
    <label for="inputId2">输入2</label>
    <input id="inputId2" type="text" maxlength="3" autofocus>
    <label for="inputId3">输入3</label>
    <input id="inputId3" type="text" maxlength="3" autofocus>
    <button>点击</button>
</body>
    <script>
       //自动切换焦点
       let inputs = document.getElementsByTagName("input");
       for (let i=0;i<inputs.length;i++){
           inputs[i].addEventListener("keypress",function (event) {
               if (this.value.trim().length==this.getAttribute("maxlength")) {
                   if (inputs[i+1]){
                       inputs[i+1].focus()
                   }
               }
           })
       }
    </script>
</html>
```

#### 4. HTML5 验证约束API 

```html
<!--必填字段校验-->
<input type="text" name="username" required>
var isUsernameRequired = document.forms[0].elements["username"].required
<!--邮件和网址校验-->
<input type="email" name ="email">
<input type="url" name="homepage">
<!--数值范围校验-->
<input type="number" min="0" max="100" step="5" name="count">
input.stepUp(); //加 1
input.stepUp(5); //加 5
input.stepDown(); //减 1
input.stepDown(10); //减 10
<!--输入模式校验-->
<input type="text" pattern="\d+" name="count">

<!--禁用验证 novalidate -->
<form method="post" action="signup.php" novalidate></form>

<form method="post" action="foo.php">
<!--这里插入表单元素-->
<input type="submit" value="Regular Submit">
    <input type="submit" formnovalidate name="btnNoValidate"
value="Non-validating Submit">
</form>
document.forms[0].elements["btnNoValidate"].formNoValidate = true;
```

通过设置 **novalidate** 属性，可以告诉表单不进行验证。 

如果一个表单中有多个提交按钮，为了指定点击某个提交按钮不必验证表单，可以在相应的按钮上添加 **formnovalidate** 属性。

**约束校验** 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <label for="myInput">输入数值</label><input id="myInput" type="text" pattern="\d+" name="count">
    <button>校验输入内容</button>
</body>
    <script>
        //可以校验某一个具体的表单项或者校验整个表单
        let myInput = document.getElementById("myInput");
        document.getElementsByTagName("button")[0].addEventListener("click",function () {
            let b = myInput.checkValidity();
            //校验的明细信息
            console.log(myInput.validity);
            alert("校验结果:"+b)   //true or false
        })
    </script>
</html>
```

与 checkValidity()方法简单地告诉你字段是否有效相比， **validity** 属性则会告诉你为什么字段有效或无效。这个对象中包含一系列属性，每个属性会返回一个布尔值。

- **customError** ：如果设置了 setCustomValidity()，则为 true，否则返回 false。
- **patternMismatch**：如果值与指定的 pattern 属性不匹配，返回 true。
- **rangeOverflow**：如果值比 max 值大，返回 true。
- **rangeUnderflow**：如果值比 min 值小，返回 true。
- **stepMisMatch**：如果 min 和 max 之间的步长值不合理，返回 true。
- **tooLong**：如果值的长度超过了 maxlength 属性指定的长度，返回 true。有的浏览器（如 Firefox 4）
- 会自动约束字符数量，因此这个值可能永远都返回 false。
- **typeMismatch**：如果值不是"mail"或"url"要求的格式，返回 true。
- **valid**：如果这里的其他属性都是 false，返回 true。 checkValidity()也要求相同的值。
- **valueMissing**：如果标注为 required 的字段中没有值，返回 true。
- 因此，要想得到更具体的信息，就应该使用 validity 属性来检测表单的有效性。下面是一个例子。

```javascript
if (input.validity && !input.validity.valid){
    if (input.validity.valueMissing){
    	alert("Please specify a value.")
    } else if (input.validity.typeMismatch){
    	alert("Please enter an email address.");
    } else {
   	 alert("Value is invalid.");
    }
} 
```



### 14.3 选择框脚本

选择框是通过\<select>和\<option>元素创建的。为了方便与这个控件交互，除了所有表单字段共有的属性和方法外， HTMLSelectElement 类型还提供了下列属性和方法。

- **add(newOption, relOption)**：向控件中插入新\<option>元素，其位置在相关项（relOption）之前。

- **multiple**：布尔值，表示是否允许多项选择；等价于 HTML 中的 multiple 特性。

- **options**：控件中所有\<option>元素的 HTMLCollection。

- **remove(index)**：移除给定位置的选项。

- **selectedIndex**：基于 0 的选中项的索引，如果没有选中项，则值为-1。对于支持多选的控件，只保存选中项中第一项的索引。

- **size**：选择框中可见的行数；等价于 HTML 中的 size 特性。 

  ```html
  <select name="location" id="selLocation">
      <option value="Sunnyvale, CA">Sunnyvale</option> <!--若被选中 选择框的值为 “Sunnyvale, CA”-->
      <option value="Los Angeles, CA">Los Angeles</option>
      <option value="Mountain View, CA">Mountain View</option>
      <option value="">China</option>      <!--若被选中 选择框的值为 “”-->
      <option>Australia</option>   <!--若被选中 选择框的值为 “Australia”-->
  </select>
  ```

在 DOM 中，每个\<option>元素都由一个 **HTMLOptionElement** 对象表示。为便于访问数据，HTMLOptionElement 对象添加了下列属性： 

- **index**：当前选项在 options 集合中的索引。

- **label**：当前选项的标签；等价于 HTML 中的 label 特性。

- **selected**：布尔值，表示当前选项是否被选中。将这个属性设置为 true 可以选中当前选项。

- **text**：选项的文本。

- **value**：选项的值（等价于 HTML 中的 value 特性）。 

  ```javascript
  //推荐选择方式
  var text = selectbox.options[0].text; //选项的文本
  var value = selectbox.options[0].value; //选项的值
  ```



#### 1.选择选项

单选情况下：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <select name="location" id="selLocation">
        <option value="Sunnyvale, CA">Sunnyvale</option>
        <option value="Los Angeles, CA">Los Angeles</option>
        <option value="Mountain View, CA">Mountain View</option>
        <option value="">China</option>
        <option>Australia</option>
    </select>
</body>
    <script>
        //单选选择选中项
        let selLocation = document.getElementById("selLocation");
        selLocation.addEventListener("change",function () {
            console.log("text : "+this.options[selLocation.selectedIndex].text);
            console.log("value : "+this.options[selLocation.selectedIndex].value);
        })
    </script>
</html>
```

多选情况下：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <select name="location" multiple id="selLocation">
        <option value="Sunnyvale, CA">Sunnyvale</option>
        <option value="Los Angeles, CA">Los Angeles</option>
        <option value="Mountain View, CA">Mountain View</option>
        <option value="">China</option>
        <option>Australia</option>
    </select>
    <button id="getAll">获取全部选中项</button>
</body>
    <script>
        //多选获取选择项的值
        result=[];
        let btn = document.getElementById("getAll");
        btn.addEventListener("click",function () {
            let selLocation = document.getElementById("selLocation");
            let options = selLocation.options;
            for (let i=0;i<options.length;i++){
                if (options[i].selected){
                  result.push(options[i].value);
                }
            }
            console.log(result);
        })
    </script>
</html>
```

#### 2.增加选项

```javascript
var newOption = new Option("Option text", "Option value");
selectbox.add(newOption, undefined); //最佳方案
```

兼容 DOM 的浏览器要求必须指定第二个参数，因此要想编写跨浏览器的代码，就不能只传入一个参数。这时候，为第二个参数传入 undefined，就可以在所有浏览器中都将新选项插入到列表最后了。来看一个例子。 

#### 3.移除选项

```javascript
selectbox.removeChild(selectbox.options[0]); //移除第一个选项
selectbox.remove(0); //移除第一个选项
selectbox.options[0] = null; //移除第一个选项
//移除所有项
function clearSelectbox(selectbox){
    for(var i=0, len=selectbox.options.length; i < len; i++){
    	selectbox.remove(i);
    }
}
```

#### 4.移动和重排选项

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <div style="float: left;">
            <select name="location" multiple id="left" style="height: 200px;width: 100px">
                <option value="Sunnyvale, CA">Sunnyvale</option>
                <option value="Los Angeles, CA">Los Angeles</option>
                <option value="Mountain View, CA">Mountain View</option>
                <option value="">China</option>
                <option>Australia</option>
            </select>
        </div>
        <div style="float: left" >
            <button id="moveToRight" style="display: block">》》</button>
            <button id="moveToLeft" style="display: block">《《</button>
        </div>
        <div style="float: left;">
            <select name="location" multiple id="right" style="height: 200px;width: 100px">
                <option value="111">111</option>
                <option value="222">222</option>
                <option value="333">333</option>
                <option value="444">444</option>
            </select>
        </div>
    </div>

</body>
    <script>
        //多选获取选择项的值
        let moveToRight = document.getElementById("moveToRight");
        let moveToLeft = document.getElementById("moveToLeft");
        moveToRight.addEventListener("click",move);
        moveToLeft.addEventListener("click",move);
        function move() {
            let fromOption;
            let toOption;
            if (this.id==="moveToRight") {
                fromOption = document.getElementById("left");
                toOption = document.getElementById("right");
            }else
            {
                fromOption = document.getElementById("right");
                toOption = document.getElementById("left");
            }
            let options = fromOption.options;
            for (let i=0;i<options.length;i++){
                if (options[i].selected){
                    toOption.appendChild(options[i]);
                    //选择框的options是动态变化
                    i--;
                }
            }
        }
    </script>
</html>
```

### 14.4 表单序列化

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form id="loginForm">
        <input type="text" name="username">
        <input type="password" name="password">
        <select>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <label>
            sex
            <input type="radio" name="sex" value="man">
            <input type="radio" name="sex" value="woman">
        </label>

        <label>
            like
            <input type="checkbox" name="like" value="basketball">
            <input type="checkbox" name="like" value="football">
            <input type="checkbox" name="like" value="swimming">
        </label>

        <button type="submit">提交</button>
    </form>
</body>
    <script>
        let loginForm = document.getElementById("loginForm");
        loginForm.addEventListener("submit",function (event) {
           let result = serialize(loginForm);
           alert(result)
        });
        function serialize(form){
            var parts = [],
                field = null,
                i,
                len,
                j,
                optLen,
                option,
                optValue;
            for (i=0, len=form.elements.length; i < len; i++){
                field = form.elements[i];
                switch(field.type){
                    case "select-one":
                    case "select-multiple":
                        if (field.name.length){
                            for (j=0, optLen = field.options.length; j < optLen; j++){
                                option = field.options[j];
                                if (option.selected){
                                    optValue = "";
                                    if (option.hasAttribute){
                                        optValue = (option.hasAttribute("value") ?
                                            option.value : option.text);
                                    } else {
                                        optValue = (option.attributes["value"].specified ?
                                            option.value : option.text);
                                    }
                                    parts.push(encodeURIComponent(field.name) + "=" +
                                        encodeURIComponent(optValue));
                                }
                            }
                        }
                        break;
                    case undefined: //字段集
                    case "file": //文件输入
                    case "submit": //提交按钮
                    case "reset": //重置按钮
                    case "button": //自定义按钮
                        break;
                    case "radio": //单选按钮
                    case "checkbox": //复选框
                        if (!field.checked){
                            break;
                        }
                    /* 执行默认操作 */
                    default:
                        //不包含没有名字的表单字段
                        if (field.name.length){
                            parts.push(encodeURIComponent(field.name) + "=" +
                                encodeURIComponent(field.value));
                        }
                }
            }
            return parts.join("&");
        }
    </script>
</html>

<!--序列化结果
username=122&password=22&sex=man&like=basketball&like=football-->
```



### 第十六章 HTML5 脚本编程

### 1.媒体元素

```html
<!-- 嵌入视频 -->
<video src="conference.mpg" id="myVideo">Video player not available.</video>
<!-- 嵌入音频 -->
<audio src="song.mp3" id="myAudio">Audio player not available.</audio>

<!-- 嵌入视频 -->
<video id="myVideo">
<source src="conference.webm" type="video/webm; codecs='vp8, vorbis'">
<source src="conference.ogv" type="video/ogg; codecs='theora, vorbis'">
<source src="conference.mpg">
Video player not available.
</video>
<!-- 嵌入音频 -->
<audio id="myAudio">
<source src="song.ogg" type="audio/ogg">
<source src="song.mp3" type="audio/mpeg">
Audio player not available.
</audio>

//检测编解码器的支持情况
var audio = document.getElementById("audio-player");
//很可能"maybe"
if (audio.canPlayType("audio/mpeg")){
//进一步处理
}
//可能是"probably"
if (audio.canPlayType("audio/ogg; codecs=\"vorbis\"")){
//进一步处理
}
```

媒体元素都有一个 canPlayType()方法，该方法接收一种格式/编解码器字符串，返回"probably"、 "maybe"或""（ 空字符串）。 



### 第十七章 错误处理

```javascript
// 异常捕获
try {
    someFunction();
    } catch (error){
    if (error instanceof TypeError){
    //处理类型错误
    } else if (error instanceof ReferenceError){
    //处理引用错误
    } else {
    //处理其他类型的错误
    }
}

//带 finally 语句
function testFinally(){
    try {
    return 2;
    } catch (error){
    return 1;
    } finally {
    return 0;
    }
}

//手动抛出异常
function assert(condition, message){
    if (!condition){
    throw new Error(message);
    }
}
```



## 第二十章 JSON

### 20.1 语法

 JSON 字符串必须使用**双引号**（单引号会导致语法错误）。

SON 的语法可以表示以下**三种类型**的值。

- **简单值**：使用与 JavaScript 相同的语法，可以在 JSON 中表示字符串、数值、布尔值和 null。但 JSON 不支持 JavaScript 中的特殊值 undefined。
- **对象**：对象作为一种复杂数据类型，表示的是一组无序的键值对儿。而每个键值对儿中的值可以是简单值，也可以是复杂数据类型的值。
- **数组**：数组也是一种复杂数据类型，表示一组有序的值的列表，可以通过数值索引来访问其中的值。数组的值也可以是任意类型——简单值、对象或数组。 

```json
//简单值
"Hello world!"

//对象
{
    "name": "Nicholas",
    "age": 29,
    "school": {
    "name": "Merrimack College",
    "location": "North Andover, MA"
    }
}

//数组
[25, "hi", true]

//复杂JSON对象
[	
    {
		"title": "Professional JavaScript",
		"authors": [
			"Nicholas C. Zakas"
		],
		"edition": 3,
		"year": 2011
	},
	{
		"title": "Professional JavaScript",
		"authors": [
			"Nicholas C. Zakas"
		],
		"edition": 2,
		"year": 2009
	},
	{
		"title": "Professional Ajax",
		"authors": [
			"Nicholas C. Zakas",
			"Jeremy McPeak",
			"Joe Fawcett"
		],
		"edition": 2,
		"year": 2008
	},
	{
		"title": "Professional Ajax",
		"authors": [
			"Nicholas C. Zakas",
			"Jeremy McPeak",
			"Joe Fawcett"
		],
		"edition": 1,
		"year": 2007
	},
	{
		"title": "Professional JavaScript",
		"authors": [
			"Nicholas C. Zakas"
		],
		"edition": 1,
		"year": 2006
	}
]
```

### 20.2 json序列化与反序列化

#### 1.序列化

```javascript
//序列化
var jsonText = JSON.stringify(book);
//反序列化
var bookCopy = JSON.parse(jsonText);
```

#### 2.序列化选项

##### 2.1 过滤结果

如果过滤器参数是数组，那么 JSON.stringify()的结果中将只包含数组中列出的属性。 

```javascript
var book = {
    "title": "Professional JavaScript",
    "authors": [
    "Nicholas C. Zakas"
    ],
    "edition": 3,
    "year" : 2011
	};
var jsonText = JSON.stringify(book, ["title", "edition"]);
```

如果第二个参数是函数，行为会稍有不同。传入的函数接收两个参数，属性（键）名和属性值。根据属性（键）名可以知道应该如何处理要序列化的对象中的属性。属性名只能是字符串，而在值并非键值对儿结构的值时，键名可以是空字符串。 

```javascript
var book = {
    "title": "Professional JavaScript",
    "authors": [
    "Nicholas C. Zakas"
    ],
    "edition": 3,
    "year" : 2011
	};
var jsonText = JSON.stringify(book, function(key, value){
    switch(key){
        case "authors":
            return value.join(",")
        case "year":
            return 5000;
        case "edition":
            return undefined;
        default:
            return value;
        }
});
//结果 {"title":"Professional JavaScript","authors":"Nicholas C. Zakas","year":5000}
```

这里，函数过滤器根据传入的键来决定结果。如果键为"authors"，就将数组连接为一个字符串；如果键为"year"，则将其值设置为 5000；如果键为"edition"，**通过返回 undefined 删除该属性。**最后，一定要提供 default 项，此时返回传入的值，以便其他值都能正常出现在结果中。 

JSON.stringify()方法的第三个参数用于控制结果中的缩进和空白符。如果这个参数是一个数值，那它表示的是每个级别缩进的空格数。 如果缩进参数是一个字符串而非数值，则这个字符串将在 JSON 字符串中被用作缩进字符（不再使用空格）。 

```javascript
var jsonText = JSON.stringify(book, null, 4);
var jsonText = JSON.stringify(book, null, " - -");
{
--"title": "Professional JavaScript",
--"authors": [
----"Nicholas C. Zakas"
--],
--"edition": 3,
--"year": 2011
}
```

##### 2.2 toJSON()方法 

有时候， JSON.stringify()还是不能满足对某些对象进行自定义序列化的需求。在这些情况下，可以给对象定义 toJSON()方法，返回其自身的 JSON 数据格式。 

```javascript
var book = {
    "title": "Professional JavaScript",
    "authors": [
    "Nicholas C. Zakas"
    ],
    "edition": 3,
    "year" : 2011,
    toJSON: function(){
        return this.title;
        }
	};
var jsonText = JSON.stringify(book);
	
```

##### 2.3 解析选项

JSON.parse()方法也可以接收另一个参数，该参数是一个函数，将在每个键值对儿上调用。 

```javascript
var book = {
	"title": "Professional JavaScript",
	"authors": [
		"Nicholas C. Zakas"
	],
	"edition": 3,
	"year": 2011,
	"releaseDate": new Date(2011, 11, 1)
};
var jsonText = JSON.stringify(book);
var bookCopy = JSON.parse(jsonText, function(key, value){
if (key == "releaseDate"){
    return new Date(value);
        } else {
        return value;
        }
    });
alert(bookCopy.releaseDate.getFullYear());
```



## 第二十二章 高级技巧

### 22.1 高级函数

#### 1.安全类型检测

任何值上调用 Object 原生的 toString()方法，都会 返回一个[object NativeConstructorName]格式的字符串。每个类在内部都有一个[[Class]]属性，这个属性中就指定了上述字符串中的构造函数名。 

```javascript
Object.prototype.toString.call(value); //"[object Array]"
```

#### 2.作用域安全的构造函数

```javascript
function Person(name, age, job){
this.name = name;
this.age = age;
this.job = job;
}
var person = new Person("Nicholas", 29, "Software Engineer");

// 没有使用new
var person = Person("Nicholas", 29, "Software Engineer");
alert(window.name); //"Nicholas"
alert(window.age); //29
alert(window.job); //"Software Engineer"

//构造作用域安全的构造函数
function Polygon(sides){
    if (this instanceof Polygon) {
        this.sides = sides;
        this.getArea = function(){
        return 0;
        };
    } else {
    	return new Polygon(sides);
    }
}
function Rectangle(width, height){
    Polygon.call(this, 2);
    this.width = width;
    this.height = height;
    this.getArea = function(){
    	return this.width * this.height;
    };
}
Rectangle.prototype = new Polygon();
var rect = new Rectangle(5, 10);
alert(rect.sides); //2

```

#### 3.函数绑定

```javascript
// 错误的方式
var handler = {
    message: "Event handled",
    handleClick: function(event){
    alert(this.message);
    }
};
var btn = document.getElementById("my-btn");
EventUtil.addHandler(btn, "click", handler.handleClick);//undefiend
//此处的this指向执行的DOM元素


//正确的方式
function bind(fn, context){
    return function(){
    	return fn.apply(context, arguments);
    };
}
var handler = {
message: "Event handled",
handleClick: function(event){
    alert(this.message);
    }
};
var btn = document.getElementById("my-btn");
EventUtil.addHandler(btn, "click", bind(handler.handleClick, handler));
```

在这个例子中，我们用 bind()函数创建了一个保持了执行环境的函数，并将其传给 EventUtil.addHandler()。 event 对象也被传给了该函数，如下所示： 

```javascript
function bind(fn, context){
    return function(){
   		return fn.apply(context, arguments);
    };
}
var handler = {
    message: "Event handled",
    handleClick: function(event){
    alert(this.message + ":" + event.type);
    }
};
var btn = document.getElementById("my-btn");
EventUtil.addHandler(btn, "click", bind(handler.handleClick, handler));
```

ECMAScript 5 为所有函数定义了一个原生的 bind()方法，进一步简单了操作。换句话说，你不用再自己定义 bind()函数了，而是可以直接在函数上调用这个方法。例如： 

```javascript
var handler = {
    message: "Event handled",
    handleClick: function(event){
    	alert(this.message + ":" + event.type);
    }
};
var btn = document.getElementById("my-btn");
EventUtil.addHandler(btn, "click", handler.handleClick.bind(handler)); //最佳实现方案
```

### 22.2 防篡改对象

#### 1.不可扩展对象

在调用了 Object.preventExtensions()方法后，就不能给 person 对象添加新属性和方法了。 

```javascript
var person = { name: "Nicholas" };
Object.preventExtensions(person);
person.age = 29;
alert(person.age); //undefined
alert(Object.isExtensible(person)); //true
```

2.密封的对象

ECMAScript 5 为对象定义的第二个保护级别是密封对象（sealed object）。密封对象不可扩展，而且已有成员的[[Configurable]]特性将被设置为 false。这就意味着不能删除属性和方法。要密封对象，可以使用 Object.seal()方法。 

```javascript
var person = { name: "Nicholas" };
Object.seal(person);
person.age = 29;
alert(person.age); //undefined
delete person.name;
alert(person.name); //"Nicholas"
person.name = "tom";
alert(person.name); //"tom"
```

使用 Object.isSealed()方法可以确定对象是否被密封了。因为被密封的对象不可扩展，所以用Object.isExtensible()检测密封的对象也会返回 false。

```javascript
var person = { name: "Nicholas" };
alert(Object.isExtensible(person)); //true
alert(Object.isSealed(person)); //false
Object.seal(person);
alert(Object.isExtensible(person)); //false
alert(Object.isSealed(person)); //true 
```

#### 3.冻结的对象

最严格的防篡改级别是冻结对象（frozen object）。冻结的对象既不可扩展，又是密封的，而且对象数据属性的[[Writable]]特性会被设置为 false。如果定义[[Set]]函数，访问器属性仍然是可写的。ECMAScript 5 定义的 Object.freeze()方法可以用来冻结对象。 

```javascript
var person = { name: "Nicholas" };
Object.freeze(person);
person.age = 29;
alert(person.age); //undefined
delete person.name;
alert(person.name); //"Nicholas"
person.name = "Greg";
alert(person.name); //"Nicholas"
```

当然，也有一个 Object.isFrozen()方法用于检测冻结对象。因为冻结对象既是密封的又是不可扩展的，所以用 Object.isExtensible()和 Object.isSealed()检测冻结对象将分别返回 false和 true。 



### 22.3 高级定时器

#### 1.函数节流

```javascript
var processor = {
	timeoutId: null,
	//实际进行处理的方法
    performProcessing: function(){
    //实际执行的代码
    },
//初始处理调用的方法
process: function(){
    clearTimeout(this.timeoutId);
    var that = this;
    this.timeoutId = setTimeout(function(){
        that.performProcessing();
        }, 100);
    }
};
//尝试开始执行
processor.process();
```

这个模式可以使用 throttle()函数来简化，这个函数可以自动进行定时器的设置和清除，如下例所示： 

```javascript
function throttle(method, context) {
    clearTimeout(method.tId);
    method.tId= setTimeout(function(){
    method.call(context);
    }, 100);
}

// 调用
function resizeDiv(){
    var div = document.getElementById("myDiv");
    div.style.height = div.offsetWidth + "px";
}
window.onresize = function(){
    throttle(resizeDiv);
};	
```



## 第二十三章 离线应用与客户端存储

### 23.1 离线检测

```javascript
//检测网络是否畅通
if (navigator.onLine){
//正常工作
} else {
//执行离线状态时的任务
}

EventUtil.addHandler(window, "online", function(){
alert("Online");
});
EventUtil.addHandler(window, "offline", function(){
alert("Offline");
});
```

### 23.2 数据存储

#### 1.Cookie

cookie 由浏览器保存的以下几块信息构成。

- **名称**：一个唯一确定 cookie 的名称。cookie 名称是不区分大小写的，所以 myCookie 和 MyCookie被认为是同一个 cookie。然而，实践中最好将 cookie 名称看作是区分大小写的，因为某些服务器会这样处理 cookie。 cookie 的名称必须是经过 URL 编码的。 

- **值**：储存在 cookie 中的字符串值。值必须被 URL 编码。
- **域**： cookie 对于哪个域是有效的。所有向该域发送的请求中都会包含这个 cookie 信息。这个值可以包含子域（subdomain，如 www.wrox.com  ），也可以不包含它（如.wrox.com，则对于 wrox.com的所有子域都有效）。如果没有明确设定，那么这个域会被认作来自设置 cookie 的那个域。
- **路径**：对于指定域中的那个路径，应该向服务器发送 cookie。例如，你可以指定 cookie 只有从http://www.wrox.com/books/ 中才能访问，那么 http://www.wrox.com 的页面就不会发送 cookie 信息，即使请求都是来自同一个域的。
- **失效时间**：表示 cookie 何时应该被删除的时间戳（也就是，何时应该停止向服务器发送这个cookie）。默认情况下，浏览器会话结束时即将所有 cookie 删除；不过也可以自己设置删除时间。这个值是个 GMT 格式的日期（Wdy, DD-Mon-YYYY HH:MM:SS GMT），用于指定应该删除cookie 的准确时间。因此， cookie 可在浏览器关闭后依然保存在用户的机器上。如果你设置的失
- 效日期是个以前的时间，则 cookie 会被立刻删除。
- **安全标志**：指定后， cookie 只有在使用 SSL 连接的时候才发送到服务器。例如， cookie 信息只能发送给https://www.wrox.com，而 http://www.wrox.com 的请求则不能发送 cookie。 

```
HTTP/1.1 200 OK
Content-type: text/html
Set-Cookie: name=value; expires=Mon, 22-Jan-07 07:10:24 GMT; domain=.wrox.com
Other-header: other-header-value
```

```javascript
// 设置cookie
document.cookie = "name=Nicholas";
// 最好编码
document.cookie = encodeURIComponent("name") + "=" +
encodeURIComponent("Nicholas") + "; domain=.wrox.com; path=/";
document.cookie = encodeURIComponent("name") + "=" +
encodeURIComponent("Nicholas") + "; domain=.wrox.com; path=/";
//cookie 工具
var CookieUtil = {
    get: function (name) {
        var cookieName = encodeURIComponent(name) + "=",
            cookieStart = document.cookie.indexOf(cookieName),
            cookieValue = null;
        if (cookieStart > -1) {
            var cookieEnd = document.cookie.indexOf(";", cookieStart);
            if (cookieEnd == -1) {
                cookieEnd = document.cookie.length;
            }
            cookieValue = decodeURIComponent(document.cookie.substring(cookieStart
                + cookieName.length, cookieEnd));
        }
        return cookieValue;
    },
    set: function (name, value, expires, path, domain, secure) {
        var cookieText = encodeURIComponent(name) + "=" +
            encodeURIComponent(value);
        if (expires instanceof Date) {
            cookieText += "; expires=" + expires.toGMTString();
        }
        if (path) {
            cookieText += "; path=" + path;
        }
        if (domain) {
            cookieText += "; domain=" + domain;
        }
        if (secure) {
            cookieText += "; secure";
        }
        document.cookie = cookieText;
    },
    //没有删除已有 cookie 的直接方法。所以，需要使用相同的路径、域和安全选项再次设置 cookie，并将失效时间设置为过去的时间。 
    unset: function (name, path, domain, secure) {
        this.set(name, "", new Date(0), path, domain, secure);
    }
};
```

#### 2.web存储机制

##### 2.1 Storage 类型

Storage 类型提供最大的存储空间（因浏览器而异）来存储名值对儿。 Storage 的实例与其他对象类似，有如下方法。 

- **clear()**： 删除所有值。 

- **getItem(name)**：根据指定的名字 name 获取对应的值。
- **key(index)**：获得 index 位置处的值的名字。
- **removeItem(name)**：删除由 name 指定的名值对儿。
- **setItem(name, value)**：为指定的 name 设置一个对应的值。

##### 2.2 sessionStorage 对象 

sessionStorage 对象存储特定于某个会话的数据，也就是该数据只保持到浏览器关闭。这个对象就像会话 cookie，也会在浏览器关闭后消失。 存储在 sessionStorage 中的数据只能由最初给对象存储数据的页面访问到，所以对多页面应用有限制。由于 sessionStorage 对象其实是 Storage 的一个实例，所以可以使用 setItem()或者直接设置新的属性来存储数据。下面是这两种方法的例子。  

```javascript
//使用方法存储数据
sessionStorage.setItem("name", "Nicholas");
//使用属性存储数据
sessionStorage.book = "Professional JavaScript";

//使用方法读取数据
var name = sessionStorage.getItem("name");
//使用属性读取数据
var book = sessionStorage.book;

//遍历sessionstorage
for (var i=0, len = sessionStorage.length; i < len; i++){
    var key = sessionStorage.key(i);
    var value = sessionStorage.getItem(key);
    alert(key + "=" + value);
}

//删除数据
delete sessionStorage.name;
//使用方法删除一个值
sessionStorage.removeItem("book");
```

##### 2.3 localStorage 对象 

要访问同一个 localStorage 对象，页面必须来自**同一个域名**（子域名无效），使用**同一种协议**，在**同一个端口**上。

 由于 localStorage 是 Storage 的实例，所以可以像使用 sessionStorage 一样来使用它。 

```javascript
//使用方法存储数据
localStorage.setItem("name", "Nicholas");
//使用属性存储数据
localStorage.book = "Professional JavaScript";
//使用方法读取数据
var name = localStorage.getItem("name");
//使用属性读取数据
var book = localStorage.book;
```

