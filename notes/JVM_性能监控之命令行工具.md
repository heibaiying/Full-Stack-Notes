# JVM 性能监控之命令行工具

<nav>
<a href="#一简介">一、简介</a><br/>
<a href="#二jps">二、jps</a><br/>
<a href="#三jstat">三、jstat</a><br/>
<a href="#四jinfo">四、jinfo</a><br/>
<a href="#五jmap">五、jmap</a><br/>
<a href="#六jhat">六、jhat</a><br/>
<a href="#七jstack">七、jstack</a><br/>
</nav>


## 一、简介

在 JDK 安装目录的 `bin` 文件夹下，除了提供有 `javac` 、`java` 这两个常用的编译和运行工具外，还提供了一系列命令行工具用于 JVM 的性能监控和故障诊断，常用的命令如下：



## 二、jps

jps（JVM Process Status Tool）用于列出正在运行的虚拟机进程的主类名称和 LVMID（Local Virtual Machine Identifier，本地虚拟机唯一标识），这里得到的 LVMID 是进行后续其它查询的基础。示例如下：

```shell
C:\Users>jps
10848 Main
14560 Jps
7040 Launcher
11572
9492 DeadLockTest
7868 JConsole
```

可选参数有 `-v` ，用于输出虚拟机进程启动时的 JVM 参数。



## 三、jstat

jstat（JVM Statistics Monitoring Tool）用于监视虚拟机的运行状态。使用格式如下：

```shell
jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]
```

其中 `option` 的所有可选值如下：

| 选项              | 作用                                                         |
| ----------------- | ------------------------------------------------------------ |
| -class            | 监视类加载、卸载数量、总空间以及类装载所耗费的时间           |
| -gc               | 监视 Java 堆状况，包括 Eden 区、2 个 Survivor 区、老年代的容量、已用空间、垃圾收集时间等信息 |
| -gccapacity       | 与 -gc 基本相同，但主要关注的是 Java 堆各个区域使用到的最大、最小空间 |
| -gcutil           | 与 -gc 基本相同，但主要关注的是已使用空间占总空间的百分比    |
| -gccause          | 与 -gcutil 基本相同，但是会额外输出上一次垃圾回收的原因      |
| -gcnew            | 监视新生代垃圾回收的状况                                     |
| -gcnewcapacity    | 与 -gcnew 基本相同，但主要关注的是使用到的最大、最小空间     |
| -gcold            | 监视老年代垃圾回收的状况                                     |
| -gcoldcapacity    | 与 -gcold 基本相同，但主要关注的是使用到的最大、最小空间     |
| -compiler         | 输出即时编译器编译过的方法、耗时等信息                       |
| -printcompilation | 输出已经被即时编译的方法                                     |

命令行中的 `interval` 表示监控的时间间隔，`count` 表示监控次数。示例如下：

```shell
jstat -gc 9492 3s 5 # 每3s输出一次，一共输出5次
```

<div align="center"> <img src="..\pictures\jstat_gc.png"/> </div>


输出信息中各个参数含义分别如下：

- **S0C**：survivor 0 的容量大小，单位 kB；
- **S1C**：survivor 1 的容量大小，单位 kB；
- **S0U**：survivor 0 已使用的空间大小，单位 kB；
- **S1U**：survivor 1 已使用的空间大小，单位 kB；
- **EC**：Eden 区的容量大小，单位 kB；
- **EU**：Eden 区已使用的空间大小，单位 kB；
- **OC**：老年代的容量大小，单位 kB；
- **OU**：老年代已使用的空间大小，单位 kB；
- **MC**：Metaspace 容量大小，单位 kB；
- **MU**：Metaspace 已使用的空间大小，单位 kB；
- **CCSC**：压缩类的空间大小，单位 kB；
- **CCSU**：压缩类已使用的空间大小，单位 kB；
- **YGC**：年轻代垃圾回收的次数；
- **YGCT**： 年轻代垃圾回收所消耗的时间；
- **FGC**：老年代垃圾回收的次数；
- **FGCT**：老年代垃圾回收所消耗的时间；
- **GCT**：垃圾回收所消耗的总时间。

以上是 option 为 `-gc` 时的输出结果，不同 option 的输出结果是不同的，所有输出结果及其参数解释可以参考官方文章： https://docs.oracle.com/javase/8/docs/technotes/tools/unix/jstat.html 



## 四、jinfo

jinfo（Configuration Info for Java）的作用是实时查看和调整虚拟机的各项参数。使用格式如下：

```shell
jinfo [option] <pid>
```

其中 `option ` 支持以下可选项：

- **-flag name** ：输出指定的虚拟机参数的值；
- **-flag [+|-]name** ：启用或禁用指定名称的虚拟机参数；
- **-flag name=value** ：设置虚拟机参数的值；
- **-flags** ：以键值对的方式输出 JVM 的相关属性；
- **-sysprops**：以键值对的方式输出 Java 相关的系统属性。

示例如下：

```java
jinfo -flags 13604
jinfo -flag CMSInitiatingOccupancyFraction 13604
```

<div align="center"> <img src="..\pictures\jinfo.png"/> </div>




## 五、jmap

jmap（Memory Map for Java）命令主要用于生成堆转储快照（一般称为 heapdump 或 dump文件）。除此之外，它还可以用来查询 finalize 执行队列、Java 堆和方法区的详细信息，如空间使用率、当前使用的收集器等。 使用格式如下：

```shell
jmap [option] <pid>
```

其中 `option` 支持以下可选项：

| 选项                        | 作用 |
| --------------------------- | ---- |
| -dump:[live,]format=b,file= | 生成 Java 堆转储快照，其中 live 用于指明是否只 dump 出存活的对象 |
| -finalizerinfo         | 显示在 F-Queue 中等待 Finalizer 线程执行 finalize 方法的对象。只在 Linux/Solaris 平台下有效 |
| -heap                  | 显示 Java 堆详细信息，如使用哪种回收器、参数配置、分代状况等。只在 Linux/Solaris 平台下有效 |
| -histo[:live]          | 显示堆中对象的统计信息，包括类、实例数量、合计容量 |
| -permstat               | 以 ClassLoader 为统计口径显示永久代内存状态。只在 Linux/Solaris 平台下有效 |
| -F                    | 当虚拟机进程堆 -dump 选项没有响应时，可使用这个选项强制生成 dump 快照。<br/>只在 Linux/Solaris 平台下有效 |

示例如下：

```shell
jmap -dump:format=b,file=test.bin 3260
```

<div align="center"> <img src="..\pictures\jmap.png"/> </div>




## 六、jhat

jhat（JVM Heap Analysis Tool）命令主要用来分析 jmap 生成的堆转储快照。 假设我们有如下一段程序：

```java
public class StackOverFlowTest {

    private static List<StackOverFlowTest> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            list.add(new StackOverFlowTest());
            Thread.sleep(10); //因为只是演示，所以休眠一下，避免生成的堆转储文件过大，导致分析时间过长
        }
    }
}
```

其最终会抛出 `java.lang.OutOfMemoryError: Java heap space` 异常，意味着在 JVM 堆上发生了内存溢出。在程序运行期间，我们可以使用上面的 jmap 命令生成堆转储快照，并使用 jhat 命令进行分析：

<div align="center"> <img src="..\pictures\jhat.png"/> </div>


jhat 命令最终的分析结果会以网页的方式进行提供，端口为 7000，界面如下：

<div align="center"> <img src="..\pictures\jhat_web.png"/> </div>


jhat 分析的结果并不够直观，因此我们还可以借助第三方工具来分析堆转储快照，这里以 JProfiler 为例，该软件可以直接从[官网](https://www.ej-technologies.com/products/jprofiler/overview.htm)下载并安装，安装完成后，点击 `session` 选项卡，并使用 `Open Snapshot` 打开 jmap 命令生成的堆转储快照：

<div align="center"> <img src="..\pictures\jprofiler-1.png"/> </div>


之后程序会自动进行分析，分析结果如下：

<div align="center"> <img src="..\pictures\jprofiler-2.png"/> </div>


通过以上可视化的统计结果，我们就可以很快定位到导致内存溢出的原因。



## 七、jstack

jstack（Stack Trace for Java）命令用于生成虚拟机的线程快照（一般称为 threaddump 或者 javacore 文件）。线程快照就是每一条线程正在执行的方法堆栈的集合，线程快照可以用于定位线程长时间停顿的原因，如死锁、死循环和长时间挂起等。其使用格式如下：

```shell
 jstack -F [-m] [-l] <pid>
```

各选项的作用如下：

| 选项 | 作用                                            |
| ---- | ----------------------------------------------- |
| -F   | 当正常输出的请求不被响应时，强制输出线程堆栈    |
| -m   | 除堆栈外，显示关于锁的附加信息                  |
| -l   | 如果有调用本地方法的话，则可以显示 C/C++ 的堆栈 |

假设我们的程序中存在如下死锁：

```java
public class DeadLockTest {

    private static final String a = "a";
    private static final String b = "b";

    public static void main(String[] args) {
        new DeadLockTest().deadlock();
    }

    private void deadlock() {
        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (b) {
                synchronized (a) {
                }
            }
        }).start();
    }
}
```

此时使用 jstack 分析就能很快的定位到问题所在，示例如下：

```shell
jstack 8112
```

输出结果如下：

<div align="center"> <img src="..\pictures\jstack.png"/> </div>


从输出中结果中可以看出，出现了一个死锁，该死锁由线程 Thread-0 和 Thread-1 导致，原因是 Thread-0 锁住了对象 `<0x00000000d6d8d610>` ，并尝试获取 `<0x00000000d6d8d640>` 对象的锁；但是 Thread-0 却恰恰相反，锁住了对象 `<0x00000000d6d8d640>` ，并尝试获取 `<0x00000000d6d8d610>`  对象的锁，由此导致死锁。



## 参考资料

+ 主要参考自：周志明 . 深入理解Java虚拟机（第3版）. 机械工业出版社 , 2019-12 ，想要深入了解虚拟机的话，推荐阅读原书。
+ 官方文档：https://docs.oracle.com/javase/8/docs/technotes/tools/unix/s11-troubleshooting_tools.html#sthref327