# Java 并发编程基础

## 一、线程基础

### 1.1 创建线程

创建线程通常以下两种方式：

- 实现 Runnable 接口：

```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable:" + Thread.currentThread().getId());
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();
```

- 采用匿名内部类：

```java
// 1.创建线程
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getId());
    }
});
// 2.启动线程
thread.start();
```

```java
// 使用Java 8的lambda可以简写如下：
new Thread(() -> System.out.println("Thread:" + Thread.currentThread().getId())).start();
```

由于 Thread类 实现了 Runnable 接口，所以两种方式本质上还是同一种。需要注意的是，当你使用 `new` 关键字创建了一个线程后，此时线程并没有开始执行，所以你还需要调用`start`方法启动线程。启动一个线程的实质是请求 Java 虚拟机运行相应的线程，而这个线程具体何时能够运行是由线程调度器（Scheduler）决定的，线程可能立即执行，也可能稍后运行，甚至有可能永远不会被执行。

### 1.2 线程属性

**编号(ID)** ：用于标识线程的唯一编号，只读属性。

**名称(Name)**：用于区分不同线程的名称，可读可写。

**线程类别(Daemon)**：布尔类型，为 true 表示是守护线程，否则为用户线程，用户线程会阻止 Java 虚拟机正常停止，守护线程则不会。通常可以把一些不重要的线程设置为守护线程，比如监控其他线程工作的线程，当工作线程停止后，虚拟机就可以正常退出。在开发中我们可以使用`setDaemonn`方法设置线程为守护线程，该方法必须在`start`方法前调用，如果在其后调用，则会抛出`IllegalThreadStateException`异常。

**优先级(Priority)**：Java 线程支持 1~10 的 10个优先级，默认值为5，代表一般优先级。Java 线程的优先级本质上只是给线程调度器一个提示信息，它并不能保证线程一定按照优先级的高低顺序运行，所以它是不可靠的，需要谨慎使用。

需要说明的是在 Java 平台中，一个线程的线程类别，优先级都默认与其父线程相同。

### 1.3 线程状态

Java 线程的生命周期分为以下几个状态：

**RUNABLE**：该状态包括两个子状态：READY 和 RUNING。处于 READY 状态的线程被称为活跃线程，被线程调度器选中后则开始运行，转化为 RUNING 状态。

**BLOCKED**：一个线程发起一个阻塞式 IO 操作后，或者申请一个由其他线程持有的独占资源（比如锁）时，相应的线程就会处于该状态。

**WAITING**：线程处于无时间限制的等待状态。

**TIMED_WAITING**：有时间限制的等待状态，如果在指定时间内并没有执行的特定的操作，则该线程自动转换为 RUNABLE。

**TERMINATED**：`Thread.run()`正常返回或者由于抛出异常而提前终止，则对应的线程都会处于终止状态。

各个状态之间的转换关系如下图：

![线程完整生命周期](D:\Full-Stack-Notes\pictures\线程完整生命周期.jpg)

## 二、线程同步机制





