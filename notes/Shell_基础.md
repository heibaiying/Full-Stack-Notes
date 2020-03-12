# shell 基础
<nav>
<a href="#一脚本基础">一、脚本基础</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-创建脚本">1.1 创建脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-显示消息">1.2 显示消息</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-使用变量">1.3 使用变量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#14-数学运算">1.4 数学运算</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#15-退出脚本">1.5 退出脚本</a><br/>
<a href="#二分支语句">二、分支语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-if-then">2.1 if-then</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-if-then-else">2.2 if-then-else</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-if-then-elif">2.3 if-then-elif</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-test-命令">2.4 test 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#25-复合条件">2.5 复合条件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#26-if-then-高级特性">2.6 if-then 高级特性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#27-case">2.7 case</a><br/>
<a href="#三循环语句">三、循环语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-for">3.1 for</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-while">3.2 while</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-until">3.3 until</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-break--contiune">3.4 break & contiune </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#35-处理循环的输出">3.5 处理循环的输出</a><br/>
<a href="#四处理用户输入">四、处理用户输入</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-命令行参数">4.1 命令行参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-移动变量">4.2 移动变量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-处理用户输入">4.3 处理用户输入</a><br/>
<a href="#五处理程序输出">五、处理程序输出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-文件描述符">5.1 文件描述符</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-输出重定向">5.2 输出重定向</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#53-输入重定向">5.3 输入重定向</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#54-自定义重定向">5.4 自定义重定向</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#55-阻止命令输出">5.5 阻止命令输出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#56-创建临时文件">5.6 创建临时文件</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#57-记录输出">5.7 记录输出</a><br/>
<a href="#六创建函数">六、创建函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-创建函数">6.1 创建函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-函数参数">6.2 函数参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-退出状态码">6.3 退出状态码</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#64-局部变量">6.4 局部变量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#65-函数库">6.5 函数库</a><br/>
<a href="#七控制脚本">七、控制脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#71-处理信号">7.1 处理信号</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#72-后台运行">7.2 后台运行</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#73-作业控制">7.3 作业控制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#74-定时作业">7.4 定时作业</a><br/>
</nav>


## 一、脚本基础

### 1.1 创建脚本

在创建 shell 脚本时，必须在文件第一行指定要使用的 shell 。其格式为：

```shell
#!/bin/bash
```

示例如下：

```shell
#!/bin/bash
date
who
```

脚本创建完成后，还需要使用 `chomd` 命令赋予文件拥有者执行文件的权限：

```java
chmod u+x test1
```

- u 表示该文件的拥有者，g 表示同组其他用户，o 表示该组外的其他用户，a 表示所有用户；
- \+ 表示增加权限、- 表示取消权限、= 表示设定唯一权限；
- x 表示可执行，r 表示可读取，w 表示可写入。

### 1.2 显示消息

shell 支持使用 echo 命令来在控制台上显示文本内容，以提示用户进行相应的操作：

```shell
echo This is a test
```

默认情况下，不需要使用引号来圈定所需要输出的字符，但如果待输出字符中含有单引号，则需要使用双引号进行圈定，反之亦然。示例如下：

```shell
echo "This is a test to see if you're paying attention"
```

除此之外，echo 还支持 `-n` 参数，用于将文本和命令行的输出显示在同一行：

```shell
echo -n "The time and date are: "
date

输出：the time and date are: 2020年 02月 18日 星期二 10:29:28 CST
```

### 1.3 使用变量

**1. 用户变量**

用户变量可以是由字母、数字或下划线组成的长度不超过 20 的任意字符串，区分大小，采用等号进行赋值，在变量、等号和值之间不能有空格。定义完成后，可以使用 `$` 符号进行引用：

```
name=heibaiying
echo $name
```

需要注意的是使用一个已经存在的用户变量来对新的用户变量进行赋值，仍然需要使用 `$` 符号进行引用：

```shell
value1=10
value2=$value1 #正确
value2=value1  #错误
```

因为 `$` 符号已经用作引用变量，所以如果想在普通文本中使用它，则需要使用 `\` 进行转义。

**2. 环境变量**

在 shell 脚本中，除了可以使用用户自定义变量外，还可以使用系统内置的环境变量，系统内置的环境变量可以使用 `set` 命令进行查看。和自定义变量一样，引用系统变量时也需要使用 `$` 符号。

**3. 命令变量**

除了可以将普通文本内容赋值给变量外，还可以将命令的输出赋值给变量，此时可以使用两种方式来进行引用：

+ 使用反引号将整个命令圈起来；
+ 使用 `$()` 格式。

示例如下：

```shell
date1=`date`
echo "1.The date and time are: " $date1

date2=$(date)
echo "2.The date and time are: " $date2
```

### 1.4 数学运算

**1. 基本运算**

在 shell 脚本中，如果想要将数学运算的结果赋值给变量，一种较为通用的方式是使用方括号表示法（ $[ operation ] ），示例如下：

```shell
var1=$[1 + 5]   # 结果：6
var2=$[$var1 * 2]  # 结果：12
var3=$[$var1 * ($var2 - $var1)] # 结果：36
```

需要注意的是 bash shell 默认只支持整数运算，不支持浮点数运算：

```shell
var1=100
var2=45
var3=$[$var1 / $var2]
echo The final result is $var3  # 结果：2
```

**2. 浮点数运算**

如果想要支持浮点数运算，可以使用内置的 bc 计算器，在命令行中输入 `bc` 命令即可打开该计算器：

```shell
[root@node01 ~]# bc
bc 1.06.95
Copyright 1991-1994, 1997, 1998, 2000, 2004, 2006 Free Software Foundation, Inc.
This is free software with ABSOLUTELY NO WARRANTY.
For details type `warranty'.
scale = 4
8/3
2.6666
```

如果想要在脚本文件中使用 bc 计算器，则需要使用到命令变量，其基本格式如下：

```shell
variable=$(echo "options; expression" | bc)
```

该方式通过管道运算符将 echo 的输出作为 bc 命令的输入，同时使用 `$()` 格式来引用 bc 命令的输出，示例如下：

```shell
var1=100
var2=45
var3=$(echo "scale=4; $var1 / $var2" | bc)
echo The answer for this is $var3  # 结果：2.2222
```

如果你要进行的运算比较复杂，需要多行书写，此时可以使用内联输入重定向：

```shell
var1=10
var2=1.5
var3=5
var4=2.5
var5=$(bc << EOF
a1 = ( $var1 * $var2)
b1 = ($var3 * $var4)
a1 + b1
EOF
) # 结果：27.5
```

这里使用 EOF 来标识了内联重定向数据的开始和结束。

### 1.5 退出脚本

**1. 退出状态码**

shell 中运行的每个命令在结束时都会传递给 shell 一个退出状态码（exit status），可以使用 `$?` 来查看上一个命令的退出状态码，使用示例如下：

```shell
# date
2020年 02月 18日 星期二 11:43:42 CST
# echo $?
0
```

0 表示命令成功结束，其他常用状态码如下：

| **状态码** | **描述**                       |
| ---------- | ------------------------------ |
| 0          | 命令成功结束                   |
| 1          | 一般性未知错误                 |
| 2          | 不适合的 shell 命令            |
| 126        | 命令不可执行                   |
| 127        | 没找到命令                     |
| 128        | 无效的退出参数                 |
| 128+x      | 与 Linux 信号 x 相关的严重错误 |
| 130        | 通过 Ctrl+C 终止的命令         |
| 255        | 范围之外的退出状态码           |

**2. exit 命令**

默认情况下，shell 脚本会以最后一个命令的退出状态码来作为最终的退出状态码， 当然你也可以使用 exit 命令来指定最终的退出状态码，示例如下：

```
exit 0
```

需要注意的是退出状态码的范围只能是 0~255，如果超过这个数值，则会以对 256 取余的结果来作为退出状态码：

```shell
exit 300 #实际的退出状态码为：44
```



## 二、分支语句

### 2.1 if-then

```shell
if  command
then
    commands
fi
```

如果 if 后面 commond 命令的退出状态码为 0，则执行 then 部分的命令，then 后面可以是一行或多行命令。

### 2.2 if-then-else

```shell
if  command
then
    commands
else
    commands
fi
```

如果 if 后面的 commond 命令的退出状态码为 0，则执行 then 部分的命令，否则执行 else 部分的命令。

### 2.3 if-then-elif

```shell
if  command1
then
    commands
elif command2
then
    commands
fi
```

bash shell 会依次执行 if 语句，只有第一个退出状态码是 0 的语句中的 then 部分会被执行。

### 2.4 test 命令

`test` 可以用在 if-then 的测试语句中，如果 `test` 命令中条件成立，`test` 命令就会退出并返回退出状态码 0。基本格式如下：

```shell
if  test condition
then
    commands
fi
```

bash shell 还提供了另一种条件测试方法，其效果与 test 命令相同，只需要使用方括号将测试条件包裹起来，格式如下：

```shell
if [ condition ]
then
    commands
fi
```

需要注意的是第一个方括号后和第二个方括号前必须加上一个空格，否则就会报错。常见的条件测试分为以下三种：

**1. 数值比较**

| 比较      | 描述                      |
| --------- | ------------------------- |
| n1 -eq n2 | 检查 n1 是否与 n2 相等    |
| n1 -ge n2 | 检查 n1 是否大于或等于 n2 |
| n1 -gt n2 | 检查 n1 是否大于 n2       |
| n1 -le n2 | 检查 n1 是否小于或等于 n2 |
| n1 -lt n2 | 检查 n1 是否小于 n2       |
| n1 -ne n2 | 检查 n1 是否不等于 n2     |

示例如下：

```shell
value1=10
value2=11

if [ $value1 -eq $value2 ]
then
    echo "The values are equal"
else
    echo "The values are different"
fi
```

**2. 字符串比较**

| 比较         | 描述                       |
| ------------ | -------------------------- |
| str1 = str2  | 检查 str1 是否和 str2 相同 |
| str1 != str2 | 检查 str1 是否和 str2 不同 |
| str1 < str2  | 检查 str1 是否比 str2 小   |
| str1 > str2  | 检查 str1 是否比 str2 大   |
| -n str1      | 检查 str1 的长度是否非 0   |
| -z str1      | 检查 str1 的长度是否为 0   |

字符串在进行大小比较时使用的是标准的 ASCII 顺序，但需要注意的是 `<` 和 `>` 符号通常会被解释为输入重定向符号和输出重定向符号，因此需要使用 `\` 对其进行转义。

**3. 文件比较**

| 比较            | 描述                                                   |
| --------------- | ------------------------------------------------------ |
| -d file         | 检查 file 是否存在并且是一个目录                       |
| -e file         | 检查 file 是否存在                                     |
| -f file         | 检查 file 是否存在并且是一个文件                       |
| -r file         | 检查 file 是否存在并且可读                             |
| -s file         | 检查 file 是否存在并且非空                             |
| -w file         | 检查 file 是否存在并且可写                             |
| -x file         | 检查 file 是否存在并且可执行                           |
| -O file         | 检查 file 是否存在并且属于当前用户所有                 |
| -G file         | 检查 file 是否存在并且默认组与当前用户的默认组是否相同 |
| file1 -nt file2 | 检查 file1 是否比 file2 新                             |
| file1 -ot file2 | 检查 file1 是否比 file2 旧                             |

### 2.5 复合条件

除了上面的单一测试外，还可以使用逻辑运算符来组合测试：

+ **&&** ：等价于 and ，基本格式如下： [ condition1 ] && [ condition2 ] ；
+ **||** ：等价于 or，基本格式如下：[ condition1 ] || [ condition2 ] 。

### 2.6 if-then 高级特性

bash shell 提供了两项可在 if-then 语句中使用的高级特性：

+ 用于数学表达式的双括号；
+ 用于高级字符串处理功能的双方括号。

**1. 使用双括号**

基本格式如下：

```shell
(( expression ))
```

expression 可以是任意的数学赋值或比较表达式，除此之外还支持以下运算符：

| 符 号 | 描 述    |
| ----- | -------- |
| val++ | 后增     |
| val-- | 后减     |
| ++val | 先增     |
| --val | 先减     |
| !     | 逻辑求反 |
| ~     | 位求反   |
| **    | 幂运算   |
| <<    | 左位移   |
| \>>   | 右位移   |
| &     | 位布尔和 |
| \|    | 位布尔或 |
| &&    | 逻辑和   |
| \|\|  | 逻辑或   |

示例如下：

```shell
val1=10
#
if (( $val1 ** 2 > 90 ))
then
    (( val2 = $val1 ** 2 )) 
    echo "The square of $val1 is $val2" 
fi
```

同时由于使用了双括号，这里的 `>` 符号也不需要转义。

**2. 使用双方括号**

双方括号的基本格式如下：

```shell
[[ expression ]]
```

它最主要的功能是支持字符串的模式匹配，示例如下：

```shell
if [[ $USER == r* ]] #匹配所有以r开头的用户
then
    echo "Hello $USER"
else
    echo "Sorry, I do not know you"
fi
```

### 2.7 case

case 命令会将指定的变量与不同模式进行比较，如果变量和模式相匹配，那么 shell 会执行该模式指定的命令，基本格式如下：

```shell
case variable in
pattern1 | pattern2 )  commands1 ;;
pattern3 )  commands2 ;;
*)  default commands ;;
esac
```

示例如下：

```shell
city=上海
case $city in
北京|天津)
echo "华北地区";;
上海)
echo "华东地区";;
广州)
echo "华南地区";;
*)
echo "其他地区";;
esac
```



## 三、循环语句

### 3.1 for

for 命令的基本使用格式如下：

```shell
for var in list
do
    commands
done
```

使用示例如下：

```shell
for letter in a b c d e f g
do
    echo The next letter is $letter
done

# 输出
The next letter is a
The next letter is b
The next letter is c
The next letter is d
The next letter is e
The next letter is f
The next letter is g
```

默认情况下，bash shell 会将下列字符当做字段分隔符：

+ 空格；
+ 制表符；
+ 换行符。

如果你想要的采用自定义的字段分隔符，可以通过修改 IFS（internal field separator，内部字段分隔符）来进行实现：

```shell
value="a,b,c,d,e,f"
OLDIFS=$IFS  # 保存原有的IFS
IFS=,  # 自定义IFS
for letter in $value
do
  echo The next letter is $letter
done
IFS=$OLDIFS # 还原默认的IFS,防止影响其他命令的执行
```

除此之外，for 命令还支持在读取目录时使用通配符，示例如下：

```shell
for file in /home/rich/test/*
do
  if [ -d "$file" ]
  then
    echo "$file 是一个目录"
  elif [ -f "$file" ]
  then
    echo "$file 是一个文件"
  fi
done
```

除了上面介绍的 for 循环外，bash shell 还支持 C 语言风格的 for 循环，示例如下：

```shell
for (( i=1; i <= 10; i++ ))
do
    echo "The next number is $i"
done
```

该风格的 for 循环还支持在迭代中使用多个变量，示例如下：

```shell
for (( a=1, b=10; a <= 10; a++, b-- ))
do
    echo "$a - $b"
done
```

### 3.2 while

while 命令的基本格式如下：

```shell
while test commands
do
     other commands
done
```

使用示例如下：

```shell
var1=10
while [ $var1 -gt 0 ]
do
    echo $var1
    var1=$[ $var1 - 1 ]
done
```

while 命令支持使用多个测试语句，但只有最后一个测试语句的退出状态码会被用来决定循环的结束。

### 3.3 until

```shell
until test commands
do
    other commands
done
```

使用示例如下：

```shell
var1=100
until [ $var1 -eq 0 ]
do
    echo $var1
    var1=$[ $var1 - 25 ]
done
```

### 3.4 break & contiune 

和其他大多数编程语言类似，shell 支持使用 break 和 contiune 来控制循环：

+ break 用于退出循环，默认只能跳出当前循环，如果想要跳出多层循环，可以使用 `break n` 进行指定；
+ contiune 用于提前结束本次循环。

基本使用示例如下：

```shell
for var1 in 1 2 3 4 5 6 7 8 9 10
do
  if [ $var1 -eq 5 ]
  then
    break
  fi
  echo "Iteration number: $var1"
done
echo "循环结束"
```

### 3.5 处理循环的输出

想要对循环的输出进行处理，可以通过在 done 之后添加一个处理命令来实现，例如将循环的输出重定向到指定文件中：

```shell
for letter in a b c d e f g
do
  echo The next letter is $letter
done > output.txt


# cat output.txt
The next letter is a
The next letter is b
The next letter is c
The next letter is d
The next letter is e
The next letter is f
The next letter is g
```



## 四、处理用户输入

### 4.1 命令行参数

命令行参数允许在运行脚本时向脚本传递额外参数，示例如下：

```shell
./test 10 20
```

这些位置参数可以在程序中直接引用：`$0` 是脚本名，`$1` 是第一个参数，`$2` 是第二个参数，依次类推，直到第九个参数 `$9` ；如果命令行参数不止 9 个，则之后的变量名需要加上花括号，例如 `${10}` 。另外还需要注意以下事项：

+ 每个参数默认使用空格进行分割，如果参数值包含空格，则需要用单引号或者双引号进行包裹；
+ 如果你在启动脚本时使用的是完整的路径，则`$0` 也会包含路径信息，此时可以使用 `basename $0` 来获取脚本名称；
+ 命令行参数的总个数可以使用 `$#` 来获取；
+ 如果想要访问所有参数，可以使用 `$*` 和 `$@` ，两者的区别在于：`$*` 会将命令行上的所有参数当做一个整体的单词来保存，而 `$@` 会将命令行上的所有参数当做同一个字符串中的多个独立单词来保存，示例如下：

```shell
echo
count=1
for param in "$*"
do
    echo "\$* Parameter #$count = $param"
    count=$[ $count + 1 ]
done

echo
count=1
for param in "$@"
do
    echo "\$@ Parameter #$count = $param"
    count=$[ $count + 1 ]
done
```

运行结果：

```shell
# ./test.sh a b c

$* Parameter #1 = a b c

$@ Parameter #1 = a
$@ Parameter #2 = b
$@ Parameter #3 = c
```

### 4.2 移动变量

bash shell 支持使用 shift 命令来移动参数。默认情况下，它会将每个参数向左移动一个位置：即变量 `$3` 的值会移到 `$2` 中，变量 `$2` 的值会移到 `$1` 中，而变量 `$1` 的值则会被删除（变量 `$0` 的值，也就是程序名，不会改变）。使用 shift 参数，可以很方便的完成参数的遍历，示例如下：

```shell
count=1
while [ -n "$1" ]
do
    echo "Parameter #$count = $1"
    count=$[ $count + 1 ]
    shift
done
```

输出结果如下：

```shell
# ./test.sh a b c
Parameter #1 = a
Parameter #2 = b
Parameter #3 = c
```

如果想要一次移动多个参数，可以使用 `shift n` 来实现。另外，通过 shift 还可以很方便的处理带值的选项，示例如下：

```shell
while [ -n "$1" ]
do
  case "$1" in
    -a) echo "Found the -a option";;
    -b) param="$2"  #当找到选项b时，则后面一个参数就是其对应的值
        echo "Found the -b option, with parameter value $param"  
        shift ;;
    -c) echo "Found the -c option";;
    --) shift
        break ;;
     *) echo "$1 is not an option";;
  esac
  shift
done
```

输出结果如下：

```shell
# ./test.sh -a -b heibaiying -d
Found the -a option
Found the -b option, with parameter value heibaiying
-d is not an option
```

### 4.3 处理用户输入

命令行参数主要用于初始化脚本运行，但在程序运行的过程中，你可能还需要与用户进行交互，并根据用户的输入来决定程序的走向，此时可以使用 read 命令来实现：

```shell
read -p "Please enter your age: " age  # -p用于显示提示文本，用户的输入会被保存到age变量中
days=$[ $age * 365 ]
echo "That makes you over $days days old! "
```

除此之外还支持使用以下参数：

+ **-s**：用于隐藏用户输入，即用户的输入不会显示在终端页面上，通常用在输入密码等敏感信息时；
+ **-t**：用于指定等待的秒数，如果在指定时间内用户没有输入，则 read 命令会以非 0 状态码退出，示例如下：

```shell
if read -t 5 -p "Please enter your name: " name
then
    echo "Hello $name, welcome to my script"
else
    echo "Sorry, too slow! "
fi
```

read 命令除了可以用于读取终端的输入外，还可以用于读取文件的内容，通常配合 cat 命令来使用，示例如下：

```shell
count=1
cat test | while read line
do
  echo "Line $count: $line"
  count=$[ $count + 1]
done
```

## 五、处理程序输出

### 5.1 文件描述符

Linux 系统将每个对象都当作文件处理，并用文件描述符（ filedescriptor ）来标识每个文件对象。文件描述符是一个非负整数，可以唯一标识会话中打开的文件，每个进程一次最多可以有九个文件描述符。bash shell 保留了前三个文件描述符（ 0 、1 和 2 ）用于特定的表述：

| 文件描述符 | 缩写   | 描述     |
| ---------- | ------ | -------- |
| 0          | STDIN  | 标准输入 |
| 1          | STDOUT | 标准输出 |
| 2          | STDERR | 标准错误 |

+ **STDIN**：代表 shell 的标准输入，它可以是终端界面的键盘，也可以是使用重定向符号（<）读取的文件。
+ **STDOUT**：代表 shell 的标准输出，它通常是终端界面的显示器，也可以是使用重定向符号（>）创建的文件。
+ **STDERR**：代表 shell 的标准错误输出，默认情况下，STDERR 文件描述符和 STDOUT 文件描述符指向相同的地方。也就是说，在默认情况下，错误消息会被输出到显示器上。当然你也可以重定向错误的输出位置：

```shell
ls -al badfile 2> test1 #将错误输出重定向到test1文件，正常的输出默认显示到屏幕上
ls -al badfile 2> test2 1> test3 #将错误的输出重定向到test2，正常输出重定向到test1
```

如果你想要将正常输出和错误输出重定向到同一个文件，可以使用 `&>` 符号进行简写：

```shell
ls -al badfile &> test4
```

### 5.2 输出重定向

**1. 临时重定向**

如果你想要在脚本中输出特定的错误信息，此时可以在文件描述符数字之前加一个 & ：

```shell
echo "捕获到未知异常" >&2
```

此时异常信息就会被添加到标准错误输出中。但上面提到过，标准错误输出默认是显示在界面上，如果想要将捕获到的错误信息输出到指定文件中，则还需要对标准错误输出进行重定向：

```shell
$ ./test 2> error.txt
```

**2. 永久重定向**

如果需要对每条语句都进行临时重定向，此时可以使用 `exec` 进行一次性永久重定向：

```shell
exec 1>testout #之后的所有正常输出都重定向到testout文件中
echo "This is a test of redirecting all output"
echo "from a script to another file."
echo "without having to redirect every individual line"
```

### 5.3 输入重定向

 exec 命令还允许你将 STDIN 重定向到文件上，示例如下：

```shell
exec 0< testfile
```

### 5.4 自定义重定向

bash shell 只占用了 3 个文件描述符，其他的 6 个（ 3~8 ）文件描述符均可用作自定义的输入或输出重定向，具体如下：

```shell
exec 3>test3out #将文件描述符为3的输出重定向到test3out
echo "and this should be stored in the file" >&3
```

如果之后想要关闭自定义的文件描述符，需要将它重定向到特殊符号 `&-` ：

```shell
exec 3>&-
```

需要注意的是一旦关闭了文件描述符，就不能再向它写入任何数据，否则就会抛出异常。

### 5.5 阻止命令输出

 如果你不需要任何输出信息，此时可以将输出重定向到一个叫作 null 的特殊文件中，在 Linux 系统上 null 文件的标准位置是 `/dev/null` ，重定向到该位置的任何数据都会被丢弃，不会显示：

```shell
$ ls -al > /dev/null
$ cat /dev/null
$
```

### 5.6 创建临时文件

通常你会需要创建某些临时文件用于保存程序输出，此时可以使用 mktemp 命令来实现，它会创建一个唯一的临时文件，并赋予创建者完整的读写权限。默认情况下， mktemp 会在本地目录中创建一个文件，你只要指定文件名，并加上任意个 X ，X 会被替换为其他字符，用于保证唯一性：

```shell
# mktemp testing.XXXXXX
testing.UdxhQH
# mktemp testing.XXXXXX
testing.3pe64N
# mktemp testing.XXX
testing.SWw
```

除此之外，它还支持以下参数：

+ **-t** ：该选项会强制 mktemp 在系统的临时目录（如 /tmp）下创建文件， 此时它会返回临时文件的全路径；
+ **-d**：该选项告诉 mktemp 需要创建的是一个目录而不是文件。

### 5.7 记录输出

如果你需要将输出既显示在终端上，又写入到文件中，此时可以使用 tee 命令来实现。它不仅会将结果输出到 STDOUT 中，同时也会将结果写出到指定的文件中：

```shell
#  date | tee testfile
2020年 02月 20日 星期四 14:21:40 CST
# cat testfile
2020年 02月 20日 星期四 14:21:40 CST
```



## 六、创建函数

### 6.1 创建函数

在 shell 脚本中可以通过以下两种方式来定义函数：

```shell
# 方式一：使用function关键字
function  name {
    commands
}

# 方式二
name () {
    commands
}
```

调用函数时，只需要在对应行中指定函数名即可，示例如下：

```shell
function func {
    echo "This is an example of a function"
}
func #调用函数
```

函数的调用必须在函数的定义之后，另外函数名必须是唯一的，如果出现同名函数，则后面的函数定义会覆盖前面的函数定义。

### 6.2 函数参数

如果想要为函数传递所需的参数，只需要在函数名后面跟上所需的参数即可。在函数体内可以通过 `$1` 、 `$2` 来进行引用的；`$0` 则表示具体的函数名，`$#` 表示参数的总数：

```shell
function addem {
  if [ $# -eq 0 ] || [ $# -gt 2 ] #如果没有传递参数或者传递两个以上的参数都返回-1
  then
    echo -1
  elif [ $# -eq 1 ]
  then
    echo $[ $1 + $1 ]
  else
    echo $[ $1 + $2 ]
  fi
}

echo -n "Adding 10 and 15: "
value=$(addem 10 15)
echo $value  #25
```

同时如上面的例子所示，**函数的返回值使用 echo 语句进行输出**。

### 6.3 退出状态码

默认情况下，函数中最后一条命令的退出状态码就是整个函数的退出状态码。在函数执行后，可以使用变量 `$?` 来获取函数的退出状态码。如果你想要返回自定义的状态码，可以使用 return 命令来实现：

```shell
function func {
    read -p "Enter a value: " value
    echo "doubling the value"
    return $[ $value * 2 ]
}
```

和命令的退出状态码一致，这里的退出状态码的取值范围必须是 0~255 。

### 6.4 局部变量

在 shell 脚本中，变量分为全局变量和局部变量。默认情况下，你在脚本中定义的任何变量都是全局变量，为了避免函数体内的变量对全局变量造成污染，你可以在函数体内使用局部变量，此时只需要在变量声明前面加上 local 关键字即可：

```shell
value1=100
value2=100
function func {
  local value1=200
  value2=200
  echo  "局部变量value1 ：" $value1     #200
  echo  "局部变量value2 ：" $value2     #200
}
func
echo  "全局变量value1 ：" $value1     #100 使用局部变量可以保证同名的全局变量不被污染
echo  "全局变量value2 ：" $value2     #200  没有使用局部变量，全局变量收到了勿扰
```

### 6.5 函数库

某些时候你可能需要引用第三方的函数库，或者你的通用函数比较多，此时可以将通用函数定义到一个统一的文件中。如下，就是一个简单的自定义函数库：

```shell
$ cat myfuncs
# 自定义函数库
function addem {
  echo $[ $1 + $2 ]
}
function multem {
  echo $[ $1 * $2 ]
}
function divem {
  if [ $2 -ne 0 ]
  then
    echo $[ $1 / $2 ]
  else
    echo -1
  fi
}
```

想要在其他脚本中引用该函数库，可以使用 source 命令。source 命令可以使用点操作符进行简写，假设脚本文件和函数库文件处于同一目录，此时只需要在脚本文件中使用以下命令进行引用：

```shell
. ./myfuncs #引用函数库
value1=10
value2=5
result1=$(addem $value1 $value2) #直接调用函数库中的函数
```

## 七、控制脚本

### 7.1 处理信号

Linux 系统可以使用信号来与运行在系统中的进程通信，从而可以启动、停止、终止进程。我们可以通过对脚本进行编程，使其在收到特定信号时执行特定的操作，常用的 Linux 系统信号如下：

| 信号 | 值      | 描述                                                         |
| ---- | ------- | ------------------------------------------------------------ |
| 1    | SIGHUP  | 挂起进程                                                     |
| 2    | SIGINT  | 终止进程（可以通过键盘组合 Ctrl+C 进程触发）                 |
| 3    | SIGQUIT | 停止进程                                                     |
| 9    | SIGKILL | 无条件终止进程                                               |
| 15   | SIGTERM | 尽可能终止进程                                               |
| 17   | SIGSTOP | 无条件停止进程，但不是终止进程                               |
| 18   | SIGTSTP | 停止或暂停进程，但不终止进程程（可以通过键盘组合 Ctrl+Z 进程触发） |
| 19   | SIGCONT | 继续运行处于停止状态的进程                                   |

想要在脚本中捕获这些信号，可以通过 trap 命令来实现，其基本使用格式如下：

```shell
trap commonds signals
```

使用示例如下：

```shell
trap "echo ' Sorry! I have trapped Ctrl-C'" SIGINT  #捕获SIGINT信号并执行echo命令

count=1
while [ $count -le 10 ]
do
    echo "Loop #$count"
    sleep 1
    count=$[ $count + 1 ]
done
```

除了可以在 shell 脚本中捕获到正常信号外，你还可以在 shell 脚本退出时捕获到退出信号：

```shell
trap "echo Goodbye..." EXIT #捕获脚本退出的EXIT信号
```

要想在脚本中的不同位置进行不同的捕获处理，你只需重新使用 trap 命令即可。如果想要删除已设置好的捕获，则需要在 trap 命令与信号名称之间加上两个破折号：

```shell
trap -- SIGINT #删除对SIGINT命令的捕获
```

### 7.2 后台运行

如果想要以后台模式运行 shell ，只要在命令后加个 & 符号：

```shell
$ ./test.sh &
```

采用该方式运行的后台进程默认是与终端会话关联在一起的，如果终端会话退出了，那么后台进程也会随之退出，如果希望后台进程在登出控制台之后仍能继续运行，则可以使用 nohup 命令：

```shell
$ nohup ./test.sh &
```

由于 nohup 命令会解除进程与终端的关联，此时进程也就不再同 STDOUT 和 STDERR 联系在一起。为了保存该命令产生的输出， nohup 命令会自动将 STDOUT 和 STDERR 的消息重定向到一个名为 nohup.out 的文件中。如果该文件已存在，则会将输出以追加的方式写入该文件。

### 7.3 作业控制

想要查看 shell 当前正在处理的作业，可以使用 jobs 命令来实现：

```shell
# jobs -l
[1]+ 14630 停止                  ./test.sh
[2]- 14831 运行中               ./test.sh > test.out &
```

`-l` 表示列出作业的 PID 以及作业号，其余的部分可选参数如下：

+ **-r**：只列运行中的作业；
+ **-s**：只列出已停止的作业。

如上输出所示，带加号的作业是默认作业，当默认作业处理完成后，带减号的作业会成为下一个默认作业。不论 shell 中有多少个正在运行的作业，任何时候都只有一个带加号的作业和一个带减号的作业。

在 bash 的作业控制中，还可以将已停止的作业作为后台进程或前台进程进行重启，命令如下：

```shell
bg 1 #将作业号为1的作业以后台进程的方式进程重启 
fg 1 #将作业号为1的作业以前台进程的方式进程重启 
```

### 7.4 定时作业

Linux 提供了以下两个命令来执行定时作业：

+ **at**：用于一次性的定时作业；
+ **corn**：用于需要周期性执行的定时作业。

**1. at 命令**

at 命令的基本格式如下：

```shell
at [-f filename] time
```

`-f` 用于指定脚本文件，time 用于指定脚本的执行时间，它可以是以下多种格式：

+ 标准的小时和分钟格式，比如 10:15；
+ AM/PM 指示符，比如 10:15 PM；
+ 特定可命名时间，比如 now、noon、midnight 或者 teatime（4 PM）。

除了指定运行作业的时间，也可以通过不同的日期格式指定特定的日期：

+ 标准日期格式，比如 MMDDYY、MM/DD/YY 或 DD.MM.YY；
+ 文本日期，比如 Jul 4 或 Dec 25，加不加年份均可。

另外还可以指定时间增量：

+ now + 25 min；
+ 10:15 + 7 days。

使用示例如下：

```shell
$ at -f test.sh now #立即执行test.sh脚本
```

使用 at 命令时，该作业会被提交到作业队列中（job queue）。针对不同优先级，存在 26 种不同的作业队列，通常用小写字 a~z 或大写字母 A~Z 来指代，作业队列的字母排序越高，作业运行的优先级就越低。默认情况下， at 的作业会被提交到 a 队列，如果想以更高优先级运行作业，可以用 `-q` 参数进行指定。

需要注意的是，显示器并不会关联 at 提交的作业。取而代之的是，Linux 系统会将提交该作业的用户的电子邮件地址作为 STDOUT 和 STDERR，任何发到 STDOUT 或 STDERR 的输出都会通过邮件系统发送给该用户；如果你的系统中没有安装 sendmail ，那就无法获得任何输出。因此在使用 at 命令时，最好在脚本中对 STDOUT 和 STDERR 进行重定向。

最后 Linux 还提供了 `atq` 命令用于查看处于等待状态的作业，并且支持使用  `atrm` 命令来删除处于等待中的作业：

```shell
 $ atrm 18 #删除作业号为18的等待作业
```

**2. cron 命令**

cron 命令通常用于需要周期性执行的任务，其基本格式如下：

```shell
min hour dayofmonth month dayofweek command
```

使用示例如下：

```shell
15 10 * * * /root/test.sh #每天15:10分执行test.sh脚本
```

想要新建基于该 cron 表达式的定时任务，可以使用 `crontab -e` 命令，然后在打开的文本编辑器（操作类似 Vim）中输入上述表达式，编辑完成后保存即可。最后可以使用 `crontab -l` 来查看系统中所有的定时任务：

```shell
# crontab -l
15 10 * * * /root/test.sh
```



## 参考资料

布鲁姆，布雷斯纳汉 . Linux命令行与shell脚本编程大全（第3版）. 人民邮电出版社 . 2016-8-1

