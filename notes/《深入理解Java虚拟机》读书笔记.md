# 《深入理解Java虚拟机》读书笔记
## 目录<br/>
<a href="#第二章-java内存区域与内存溢出异常">第二章 java内存区域与内存溢出异常</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-运行时数据区域">2.2 运行时数据区域</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#221--程序计数器">2.2.1  程序计数器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#222--Java虚拟机栈">2.2.2  Java虚拟机栈</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#223-本地方法栈">2.2.3 本地方法栈</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#224-Java堆">2.2.4 Java堆</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#225-方法区">2.2.5 方法区</a><br/>
<a href="#第四章-虚拟机性能监控与故障处理工具">第四章 虚拟机性能监控与故障处理工具</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#421-JDK命令行工具">4.2.1 JDK命令行工具</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#421-jps虚拟机进程状况工具">4.2.1 jps：虚拟机进程状况工具 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#422-jstat虚拟机统计信息监视工具">4.2.2 jstat：虚拟机统计信息监视工具</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-gc-参数返回结果">1. gc 参数返回结果</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-class-参数返回结果">2. class 参数返回结果</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-gcmetacapacity-参数返回结果">3. gcmetacapacity 参数返回结果</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#423-jinfoJava配置信息工具">4.2.3 jinfo：Java配置信息工具</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#424-jmapJava内存映像工具">4.2.4 jmap：Java内存映像工具 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#425-jhat虚拟机堆转储快照分析工具">4.2.5 jhat：虚拟机堆转储快照分析工具 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#426-jstackJava堆栈跟踪工具">4.2.6 jstack：Java堆栈跟踪工具 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-JDK的可视化工具">4.3 JDK的可视化工具 </a><br/>
<a href="#第十二章-Java内存模型">第十二章 Java内存模型</a><br/>
## 正文<br/>



## 第二章 java内存区域与内存溢出异常

### 2.2 运行时数据区域

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/java虚拟机运行时数据区.png"/> </div></br>



#### 2.2.1  程序计数器

**当前线程所执行的字节码的行号指示器。**

- 为了线程切换后能够恢复到正确地执行位置，每个线程都需要有一个独立的程序计数器；
- 如果正在执行java方法，计数器记录的是正在执行的虚拟机字节码指令的地址，如果执行的是Native方法，则计数器值为空；
- 此内存区域是唯一一个在java虚拟机规范中没有规定任何outOfMemoryError情况的区域。



#### 2.2.2  Java虚拟机栈

虚拟机栈描述的是Java方法执行的内存模型：每个方法在执行的同时都会创建一个栈帧，用于存储局部变量表、操作数栈、动态链接、方法出入口等信息。每一个方法从调用直到执行完成的过程，就对应着一个栈帧在虚拟机中入栈到出栈的过程。

- 局部变量表存放了编译器可知的各种基本数据类型、对象引用和returnAddress类型（指向一条字节码指令的地址）。
- 在java虚拟机规范中，对这个区域规定了两种异常：
  - 如果线程请求的栈深入大于虚拟机所允许的深度，将抛出StackOverflowError异常；
  - 如果虚拟机栈扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常。



#### 2.2.3 本地方法栈

与虚拟机栈类似，针对Native 方法服务。



#### 2.2.4 Java堆

此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。Java 堆可以处于物理上不连续的内存空间中，只要是逻辑上是连续的即可。如果堆中没有内存完成实例分配，并且堆也无法在扩展时，将会抛出OutOfMemoryError异常。



#### 2.2.5 方法区

方法区与Java堆一样，是各个线程共享的内存区域，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译后的代码等数据。

- 当方法区无法满足内存分配的需求时，将会抛出OutOfMemoryError异常。
- **运行时常量池**是方法区的一部分，Class文件中出了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池，用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后进入方法区的运行时常量池中存在。



## 第四章 虚拟机性能监控与故障处理工具

部分内容参考自博客：[JDK的命令行工具](https://blog.csdn.net/qq_31156277/article/details/80035236)

### 4.2.1 JDK命令行工具

#### 4.2.1 jps：虚拟机进程状况工具 

命令格式： jps \[options] [hostid]

| 参数 | 描述                                             |
| ---- | ------------------------------------------------ |
| -l   | 输出主类的全名，如果是执行的jar，则输出jar的路径 |
| -v   | 输出JVM启动时的JVM参数                           |
| -m   | 输出虚拟机进程启动时传递给主类main() 函数的参数  |

#### 4.2.2 jstat：虚拟机统计信息监视工具

命令格式：jstat [options] vmid [interval \[s|ms][count]] ]  

命令格式：jstat \[-命令选项]\[vmid]\[间隔时间/毫秒][查询次数]

| 参数              | 功能作用                                                     |
| ----------------- | ------------------------------------------------------------ |
| -class            | 监视类装载、卸载数量，以及总空间和装载耗时等                 |
| -gc               | 监视堆中 eden、 survivor 、老年代、元空间等空间大小和已使用情况，GC次数、耗时等 |
| -gcmetacapacity   | 元空间                                                       |
| -gcutil           | 与gc 类似，但是注重的是占比情况                              |
| -printcompilation | 输出已经被JIT重新编译的方法                                  |
| -gcoldcapacity    | 老年代统计信息                                               |
| -gcnew            | 新生代                                                       |
| -gccause          | 与-gcutil相似，但是会输出上一次GC的原因                      |

##### 1. gc 参数返回结果

使用-gc 命令； 为了能够更加直观，在程序中设置了VM相关参数； 然后运行、查看结果并分析。

| 参数 | 解析                 |
| ---- | -------------------- |
| S0C  | surivor(s0)区域大小  |
| s1c  | s1区大小             |
| S0U  | S0的使用大小         |
| S1U  | S1的使用大小         |
| EC   | eden可以使用的大小   |
| EU   | eden已经使用         |
| OC   | 老年代可以使用的大小 |
| OU   | 老年代已经使用的带下 |
| MC   | 元空间可以使用的大小 |
| MU   | 元空间已经使用的大小 |
| CCSC | 压缩类空间大小       |
| CCSU | 压缩类已经使用大小   |
| YGC  | 年轻代垃圾回收次数   |
| YGCT | 年轻代垃圾回收总耗时 |
| FGC  | 老年代垃圾回收次数   |
| FGCT | 老年代垃圾回收总耗时 |
| GCT  | 垃圾回收消耗总时间   |

##### 2. class 参数返回结果

-class 参数； 监视类装载、卸载数量、总空间以及装载所耗费的时间。

| 参数     | 解析            |
| -------- | --------------- |
| Loaded   | 加载class的数量 |
| Bytes    | 占用空间大小    |
| Unloaded | 未加载数量      |
| Bytes    | 未加载占用空间  |
| Time     | 时间            |

##### 3. gcmetacapacity 参数返回结果

元数据空间统计(-gcmetacapacity)

| 参数  | 描述                   |
| ----- | ---------------------- |
| MCMN  | 最小元数据容量         |
| MCMX  | 最大元数据容量         |
| MC    | 当前元数据空间大小     |
| CCSMN | 最小压缩类空间大小     |
| CCSMX | 最大压缩类空间大小     |
| CCSC  | 当前压缩类空间大小     |
| YGC   | 年轻代垃圾回收次数     |
| FGC   | 老年代垃圾回收次数     |
| FGCT  | 老年代垃圾回收消耗时间 |
| GCT   | 垃圾回收消耗总时间     |

#### 4.2.3 jinfo：Java配置信息工具

命令格式：jinfo [option] ipd

在控制台输入 jinfo ，则会提示相关命令参数，可借助提示执行相关命令。

```shell
  -flag <name>         to print the value of the named VM flag
  -flag [+|-]<name>    to enable or disable the named VM flag
  -flag <name>=<value> to set the named VM flag to the given value
  -flags               to print VM flags
  -sysprops            to print Java system properties
  <no option>          to print both of the above
```

#### 4.2.4 jmap：Java内存映像工具 

`jmap`（JVM Memory Map for java）命令用于生成`堆转储快照`;  当然还可以使用`-XX:HeapDumpOnOutOfMemoryError` 参数，可以让虚拟机在OOM异常之后自动生产dump文件。

| 选项          | 作用                                                         |
| ------------- | ------------------------------------------------------------ |
| -dump         | 生成Java堆转储快照。 格式   -dump:[live,]format=b,file=< filename >,其中live子参数说明是否只dump出存活的对象 |
| finalizerinfo | 显示F-Queue中等待Finalizer线程执行finalize方法的对象         |
| -heap         | 显示java堆详细信息，如使用哪种收集器、参数配置、分代状况等   |
| -histo        | 显示堆中对象统计信息，包括类，实例数量、合计容量             |
| -F            | 当虚拟机进程对   -dump选项没有响应时，可使用这个选项强制生成dump快照 |

#### 4.2.5 jhat：虚拟机堆转储快照分析工具 

可用 VisualVM  或者其他可视化分析工具代替

#### 4.2.6 jstack：Java堆栈跟踪工具 

jstack [ option ] vmid

| 参数 | 作用                                         |
| ---- | -------------------------------------------- |
| -F   | 当正常输出的请求不被响应时，强制输出线程堆栈 |
| -l   | 除堆栈外，显示关于锁的附加信息               |
| -m   | 如果调用本地方法的话，可以显示 c/C++的堆栈   |

### 4.3 JDK的可视化工具 

官方工具1： JConsole（Java监视与管理控制台）

官方工具2： VisualVM（多合一故障处理工具） 

IDEA下推荐插件：JProfiler



## 第十二章 Java内存模型

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/java内存模型.png"/> </div></br>

关于主内存与工作内存之间具体的交互协议，即一个变量如何从主内存拷贝到工作内存、 如何从工作内存同步回主内存之类的实现细节，Java内存模型中定义了以下8种操作来完成 ：

1. **lock（锁定）**：作用于主内存的变量，它把一个变量标识为一条线程独占的状态。
2. **unlock（解锁）**：作用于主内存的变量，它把一个处于锁定状态的变量释放出来，释放后的变量才可以被其他线程锁定。
3. **read（读取）**：作用于主内存的变量，它把一个变量的值从主内存传输到线程的工作内存中，以便随后的load动作使用。
4. **load（载入）**：作用于工作内存的变量，它把read操作从主内存中得到的变量值放入工作内存的变量副本中。
5. **use（使用）**：作用于工作内存的变量，它把工作内存中一个变量的值传递给执行引擎，每当虚拟机遇到一个需要使用到变量的值的字节码指令时将会执行这个操作。
6. **assign（赋值）**：作用于工作内存的变量，它把一个从执行引擎接收到的值赋给工作内存的变量，每当虚拟机遇到一个给变量赋值的字节码指令时执行这个操作。
7. **store（存储）**：作用于工作内存的变量，它把工作内存中一个变量的值传送到主内存中，以便随后的write操作使用。
8. **write（写入）**：作用于主内存的变量，它把store操作从工作内存中得到的变量的值放入主内存的变量中。 



**Java内存模型还规定了在执行上述8种基本操作时必须满足如下规则：**

1. 不允许read和load、 store和write操作之一单独出现，即不允许一个变量从主内存读取了但工作内存不接受，或者从工作内存发起回写了但主内存不接受的情况出现。
2. 不允许一个线程丢弃它的最近的assign操作，即变量在工作内存中改变了之后必须把该变化同步回主内存。
3. 不允许一个线程无原因地（没有发生过任何assign操作）把数据从线程的工作内存同步回主内存中。
4. 一个新的变量只能在主内存中“诞生”，不允许在工作内存中直接使用一个未被初始化（load或assign）的变量，换句话说，就是对一个变量实施use、 store操作之前，必须先执行过了assign和load操作。
5. 一个变量在同一个时刻只允许一条线程对其进行lock操作，但lock操作可以被同一条线程重复执行多次，多次执行lock后，只有执行相同次数的unlock操作，变量才会被解锁。
6. 如果对一个变量执行lock操作，那将会清空工作内存中此变量的值，在执行引擎使用这个变量前，需要重新执行load或assign操作初始化变量的值。
7. 如果一个变量事先没有被lock操作锁定，那就不允许对它执行unlock操作，也不允许去unlock一个被其他线程锁定住的变量。
8. 对一个变量执行unlock操作之前，必须先把此变量同步回主内存中（执行store、 write操作） 



**先行发生原则：**

1. **程序次序规则**（Program Order Rule）：在一个线程内，按照程序代码顺序，书写在前面的操作先行发生于书写在后面的操作。 准确地说，应该是控制流顺序而不是程序代码顺序，因为要考虑分支、 循环等结构。
2. **管程锁定规则**（Monitor Lock Rule）：一个unlock操作先行发生于后面对同一个锁的lock操作。 这里必须强调的是同一个锁，而“后面”是指时间上的先后顺序。
3. **volatile变量规则**（Volatile Variable Rule）：对一个volatile变量的写操作先行发生于后面对这个变量的读操作，这里的“后面”同样是指时间上的先后顺序。
4. **线程启动规则**（Thread Start Rule）：Thread对象的start（）方法先行发生于此线程的每一个动作。
5. **线程终止规则**（Thread Termination Rule）：线程中的所有操作都先行发生于对此线程的终止检测，我们可以通过Thread.join（）方法结束、 Thread.isAlive（）的返回值等手段检测到线程已经终止执行。
6. **线程中断规则**（Thread Interruption Rule）：对线程interrupt（）方法的调用先行发生于被中断线程的代码检测到中断事件的发生，可以通过Thread.interrupted（）方法检测到是否有中断发生。
7. **对象终结规则**（Finalizer Rule）：一个对象的初始化完成（构造函数执行结束）先行发生于它的finalize（）方法的开始。
8. **传递性**（Transitivity）：如果操作A先行发生于操作B，操作B先行发生于操作C，那就可以得出操作A先行发生于操作C的结论。 

