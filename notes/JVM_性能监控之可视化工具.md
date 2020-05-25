# JVM 性能监控之可视化工具

<nav>
<a href="#一简介">一、简介</a><br/>
<a href="#二JConsole">二、JConsole</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-简介">2.1 简介</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-使用">2.2 使用</a><br/>
<a href="#三VisualVM">三、VisualVM</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-简介">3.1 简介</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-使用">3.2 使用</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-安装插件">3.3 安装插件</a><br/>
<a href="#四连接远程进程">四、连接远程进程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-不使用安全凭证">4.1 不使用安全凭证</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-使用安全凭证">4.2 使用安全凭证</a><br/>
</nav>


## 一、简介

在 JDK 安装目录的 `bin` 文件夹下，除了提供有命令行监控工具外，还提供了几种可视化的监控工具，以方便用户直观地了解虚拟机的运行状态。常用的可视化监控工具如下：



## 二、JConsole

### 2.1 简介

JConsole（Java Monitoring and Management Console）是一款基于 JMX（Java Manage-ment Extensions）的可视化监视工具。它的主要功能是通过 JMX 的 MBean（Managed Bean）对系统信息进行收集和动态调整系统参数。JMX（Java Management Extensions）是一个为应用程序、设备、系统等植入管理功能的框架，通常用于监控系统的运行状态或管理系统的部分功能。

### 2.2 使用

打开位于 bin 目录下的 `jconsole` 程序后，它会自动扫描当前主机上的所有 JVM 进程：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jconsole-start.png"/> </div>


选中需要监控的进程后，点击连接，即可进入监控界面。监控界面包含了 *概览*、*内存*、*线程*、*类*、*VM 概要*、*MBean* 六个选项卡。其中概览界面显示的是 *内存*、*线程*、*类* 等三个选项卡界面的概览信息，如下所示：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jconsole-概览.png"/> </div>




而内存界面主要用于显示堆和非堆上各个区域的使用量：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jconsole-内存.png"/> </div>




线程界面内主要显示各个线程的堆栈信息，最下角有一个 **检测死锁** 按钮，点击后如果检测到死锁存在，则在下部的线程选项卡旁边会出现死锁选项卡：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jconsole-检测死锁.png"/> </div>




点击死锁选项卡则可以看到造成死锁的线程：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jconsole-死锁.png"/> </div>




最后的 **类** 选项卡主要用于显示当前已加载和已卸载的类的数量。而 **VM 概要** 选项卡则主要用于显示虚拟机的相关参数，如下所示：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jconsole-概要.png"/> </div>




## 三、VisualVM

### 3.1 简介

VisualVM（All-in-One Java Troubleshooting Tool）是 Oracle 提供的功能最强大的运行监视和故障处理程序之一， 它除了支持常规的运行监视、故障处理等功能外，还能用于性能分析（Profiling）。同时因为 VisualVM 是基于 NetBeans 平台的开发工具，所以它还支持通过插件来进行功能的拓展。VisualVM 的主要功能如下：

- 显示虚拟机进程及其配置信息、环境信息（与 jps、jinfo 功能类似）；
- 监视应用程序的处理器、垃圾收集、堆、方法区以及线程的信息（与 jstat、jstack 功能类似）；
- dump以及分析堆转储快照（与 jmap、jhat 功能类似）；
- 方法级的程序运行性能分析，找出被调用最多、运行时间最长的方法；
- 离线程序快照：可以收集程序的运行时配置、线程 dump、内存 dump 等信息来建立快照。

### 3.2 使用

打开位于 bin 目录下的 `jvisualvm` 程序， 它会自动扫描当前主机上的所有 JVM 进程：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual.png"/> </div>




点击需要监控的进程后，右侧即会显示相关的监控信息：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-监视.png"/> </div>




**1. 堆 Dump**

在监控界面点击按钮可以 **执行垃圾回收** 或者 **堆 Dump** 。进行堆 Dump 后，还会显示其分析结果：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-堆dump.png"/> </div>




**2. 线程 Dump**

在线程界面可以查看所有线程的状态，如果出现死锁，该界面还会进行提示：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-线程.png"/> </div>




此时可以进行 **线程 Dump** 来获取具体的线程信息，效果和 jstack 命令类似：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-dump.png"/> </div>




**3. 性能分析**

在 Profiler 界面，可以进行 CPU 和 内存的性能分析。要开始性能分析，需要先选择 **CPU** 或 **内存** 按钮中的一个，VisualVM 将会开始记录应用程序执行过的所有方法：如果是进行的是 CPU 执行时间分析，将会统计每个方法的执行次数、执行耗时；如果是内存分析，则会统计每个方法关联的对象数以及这些对象所占的空间。想要结束性能分析，点击停止按钮即可：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-性能分析.png"/> </div>




**4.  Visual GC**

Visual GC 面板默认是不显示的，需要通过插件进行扩展。它会实时监控虚拟机的状态，在功能上类似于 jstat 命令：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-gc.png"/> </div>




### 3.3 安装插件

在主界面，点击 **工具 => 插件** ，可以打开插件面板。右击插件选项或者点击安装按钮即可完成对应插件的安装：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-插件安装.png"/> </div>




需要注意的是，安装插件前需要按照自己 JVM 的版本来配置插件中心，否则会抛出 ”无法连接到插件中心“ 的异常。每个版本对应的插件中心可以在该网址上查看：https://visualvm.github.io/pluginscenters.html，界面如下：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-插件中心.png"/> </div>




之后需要将正确的插件中心的地址配置到程序中：



<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-配置插件中心.png"/> </div>




## 四、连接远程进程

以上演示 JConsole 和 VisualVM 时，我们都是用的本地进程，但在实际开发中，我们更多需要监控的是服务器上的远程进程。想要监控远程主机上的进程，需要进行 JMX 的相关配置，根据连接时是否需要用户名和密码，可以分为以下两种配置方式：

### 4.1 不使用安全凭证

启动服务器上的 Java 进程时增加以下参数：

```shell
 java -Dcom.sun.management.jmxremote.port=12345  #jmx远程连接的端口号
 -Dcom.sun.management.jmxremote.ssl=false 
 -Dcom.sun.management.jmxremote.authenticate=false  
 -jar springboot.jar 
```

此时只需要知道主机地址和端口号就可以连接，不需要使用用户名和密码，所以安全性比较低。

### 4.2 使用安全凭证

启动服务器上的 Java 进程时增加以下参数：

```shell
java -Dcom.sun.management.jmxremote.port=12345 
-Dcom.sun.management.jmxremote.ssl=false 
-Dcom.sun.management.jmxremote.authenticate=true 
-Dcom.sun.management.jmxremote.access.file=/usr/local/jmxremote.access 
-Dcom.sun.management.jmxremote.password.file=/usr/local/jmxremote.password 
-jar springboot.jar 
```

其中 `jmxremote.access ` 的内容如下，其中 admin 为用户名，readwrite 表示可读可写，也可以设置为 readonly（只读）：

```shell
admin readwrite  
```

 `jmxremote.password` 的内容如下，其中 admin 为用户名，123456 为密码：

```shell
admin 123456
```

两个文件创建好后，还需要赋予其执行权限：

```shell
chmod 600 /usr/local/jmxremote.access
chmod 600 /usr/local/jmxremote.password
chown root:root /usr/local/jmxremote.access
chown root:root /usr/local/jmxremote.password
```

之后在使用 VisualVM 进行远程连接时，配置如下：

<div align="center"> <img src="https://gitee.com/heibaiying/Full-Stack-Notes/raw/master/pictures\jvisual-连接远程主机.png"/> </div>


需要注意的是这里的端口号是配置的 `Dcom.sun.management.jmxremote.port` 的值，而不是 Java 程序的端口号。连接完成后，即可查看到对应进程的监控状态。



## 参考资料

1. 主要参考自：周志明 . 深入理解Java虚拟机（第3版）. 机械工业出版社 , 2019-12 ，想要深入了解虚拟机的话，推荐阅读原书。
2. visualvm 官方文档：https://visualvm.github.io/documentation.html
3. [Java_jvisualvm使用JMX连接远程机器（实践）](https://www.cnblogs.com/gossip/p/6141941.html)
4. [使用JMX透过防火墙远程监控tomcat服务](https://my.oschina.net/mye/blog/64879)