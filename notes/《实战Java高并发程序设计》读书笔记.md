# 《实战Java高并发程序设计》读书笔记

## 目录<br/>
<a href="#第二章-Java并行程序基础">第二章 Java并行程序基础</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-线程的基本操作">2.1 线程的基本操作</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#211-线程中断">2.1.1 线程中断</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#212-等待wait和通知notify">2.1.2 等待（wait）和通知（notify）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#213-等待线程结束join和谦让yield">2.1.3 等待线程结束（join）和谦让（yield）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-volatile与Java内存模型JMM">2.2 volatile与Java内存模型（JMM）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-线程组">2.3 线程组</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-守护线程Daemon">2.4 守护线程（Daemon）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#25-线程安全的概念和synchronized">2.5 线程安全的概念和synchronized </a><br/>
<a href="#第三章-JDK-并发包">第三章 JDK 并发包</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-同步控制">3.1 同步控制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#311-可重入锁ReentrantLock">3.1.1 可重入锁(ReentrantLock)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1锁申请等待超时">1.锁申请等待超时</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2公平锁">2.公平锁</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#312--条件condition">3.1.2  条件（condition）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#313-信号量Semaphore">3.1.3 信号量（Semaphore）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#314-读写锁ReadWriteLock-">3.1.4 读写锁（ReadWriteLock ）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#315-倒计时CountDown">3.1.5 倒计时（CountDown）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#316-循环栅栏CyclicBarrier">3.1.6 循环栅栏（CyclicBarrier）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#317-线程阻塞工具类LockSupport">3.1.7 线程阻塞工具类（LockSupport）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-线程池">3.2 线程池</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#321-JDK对线程池的支持">3.2.1 JDK对线程池的支持</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1计划任务">1.计划任务</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#322-线程池内部实现">3.2.2 线程池内部实现</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#**1JDK内置的拒绝策略**">1.JDK内置的拒绝策略</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2线程池的扩展">2.线程池的扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3合理优化线程池的数量">3.合理优化线程池的数量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#323-Fork/Join-框架">3.2.3 Fork/Join 框架</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-并发容器">3.3 并发容器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#331-并发集合简介javautilconcurrent">3.3.1 并发集合简介（java.util.concurrent）</a><br/>
<a href="#第四章-锁的优化及注意事项">第四章 锁的优化及注意事项</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-Java虚拟机对锁优化锁做的努力">4.2 Java虚拟机对锁优化锁做的努力</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-锁偏向">1. 锁偏向</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-轻量级锁">2. 轻量级锁</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-自旋锁">3. 自旋锁</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-锁消除">4. 锁消除</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-人手一只笔ThreadLocal">4.3 人手一只笔（ThreadLocal）</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#44-无锁">4.4 无锁</a><br/>
<a href="#第五章-并行模式与算法">第五章 并行模式与算法</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#55-JDK中的Future">5.5 JDK中的Future</a><br/>
<a href="#第六章--JAVA-8-并发">第六章  JAVA 8 并发</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#65-增强的FutureCompletableFuture">6.5 增强的Future(CompletableFuture)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#66--StampedLock">6.6  StampedLock</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#67-LongAdder-和-LongAccumulator">6.7 LongAdder 和 LongAccumulator</a><br/>

## 正文<br/>





## 第二章 Java并行程序基础

### 2.1 线程的基本操作

#### 2.1.1 线程中断

+ `Thread.interrupt() `是一个实例方法，它通知目标线程被中断，也就是设置中断标志位；
+ `Thread.isInterrupted()`也是实例方法，判断当前线程是否有被中断（通过检查中断标志位）；
+ `Thread.interrupted()`是静态方法：用来判断当前线程的中断状态，同时会清除当前线程中断标志位的状态。

```java
// Thread 类
public void interrupt()         	// 设置中断标志位
public boolean isInterrupted()    	// 判断是否被中断
public static boolean interrupted() // 判断是否被中断 并清除标志位  
```

```java
//只是设置标志位，并不能停止线程
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
                while (true) {
                    System.out.println("子线程打印");
              }
        });
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}

// 能停止线程
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("子线程打印");
              }
        });
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}

// 不能停止线程
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()||!Thread.currentThread().isInterrupted()) {
                    System.out.println("子线程打印");
            }
        });
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
```



#### 2.1.2 等待（wait）和通知（notify）

这两个方法在Object 下，意味着任何对象都可以调用这两个方法。

如果是一个线程调用了`wait()`,那么它就会进入object对象的等待队列。`notify()  `**随机唤醒(并非先等待先唤醒，不是公平的唤醒)**  等待队列中的一个队列，`notifyAll()` 唤醒全部等待。

```java
// 正常情况
public class Test {
    private static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                System.out.println("线程1");
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("线程2");
            }
        }).start();
    }
}
//输出：
	 线程1
	 线程2
	
	
// 锁住对象不释放
public class Test {
    private static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("线程2");
            }
        }).start();
    }
}

//输出：
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1
    线程1

// 等待与唤醒
public class Test {
    private static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println("对象object等待");
                    object.wait();
                    System.out.println("线程1后续操作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("对象object唤醒");
                object.notify();
                System.out.println("线程2后续操作");
            }
        }).start();
    }
}

// 输出
对象object等待
对象object唤醒
线程2后续操作
线程1后续操作


// 全部唤醒
public class Test {
    private static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println("对象object在线程1等待");
                    object.wait();
                    System.out.println("线程1后续操作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println("对象object在线程2等待");
                    object.wait();
                    System.out.println("线程2后续操作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("对象object唤醒");
                object.notifyAll();    
                //注: 如果是object.notify（）则是随机唤醒任意一个等待
                System.out.println("线程3后续操作");
            }
        }).start();
    }
}

// 输出
对象object在线程1等待
对象object在线程2等待
对象object唤醒
线程3后续操作
线程2后续操作
线程1后续操作
```

**（1）wait() 与 notify/notifyAll 方法必须在同步代码块中使用**

wait() 与 notify/notifyAll() 是Object类的方法，在执行两个方法时，要先获得锁。因此，wait()  与  notify/notifyAll()  经常与synchronized搭配使用，即在synchronized修饰的同步代码块或方法里面调用wait() 与   notify/notifyAll()方法。

**（2）wait() 与  notify/notifyAll() 的执行过程**

由于 wait() 与  notify/notifyAll() 是放在同步代码块中的，因此线程在执行它们时，肯定是进入了临界区中的，即该线程肯定是获得了锁的。

当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。

 当执行notify/notifyAll方法时，会唤醒一个处于等待该 对象锁 的线程，然后继续往下执行，直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁。

从这里可以看出，notify/notifyAll()执行后，并不立即释放锁，而是要等到执行完临界区中代码后，再释放。故在实际编程中，我们应该尽量在线程调用notify/notifyAll()后，立即退出临界区。即不要在notify/notifyAll()后面再写一些耗时的代码。

```java
public class Test {

    //通过wait() 和 notify() 实现一个阻塞的队列
    static class BlockArray<E> {

        private final Object object;

        BlockArray(){
            this.object=new Object();
        }

        private ArrayList<E> arrayList = new ArrayList<>();

        E take() throws InterruptedException {
            if (arrayList.size()>0 && arrayList.get(0)!= null){
                return pop();
            }else {
                // 如果不使用同步代码块 则会报 illegalmonitorstateexception 异常
                synchronized (object){
                    object.wait();
                    }
                return pop();
                }
        }

        private E pop() {
            E e = arrayList.get(0);
            arrayList.remove(0);
            return e;
        }

        void put(E e) {
            arrayList.add(arrayList.size(), e);
            synchronized (object){
                object.notify();
            }
        }

    }

    public static void main(String[] args) {
        BlockArray<Double> blockArray = new BlockArray<>();
        new Thread(() -> {
            while (true) {
                Double take;
                try {
                    take = blockArray.take();
                    System.out.println("读取线程：获得数据："+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        pool.scheduleAtFixedRate(() -> {
            double random = Math.random();
            System.out.println("写入线程：写入数据："+random);
            blockArray.put(random);
        },0,3,TimeUnit.SECONDS);
    }
}

结果：
写入线程：写入数据：0.19934473742252068
读取线程：获得数据：0.19934473742252068
写入线程：写入数据：0.06838214167831369
读取线程：获得数据：0.06838214167831369
写入线程：写入数据：0.5146915352784022
读取线程：获得数据：0.5146915352784022
```



#### 2.1.3 等待线程结束（join）和谦让（yield）

```
public static native void yield();
```

`yield()` 会使得当前线程让出CPU,但是在让出后，还会进行CPU资源的争夺，这意味这有可能会再次获得CPU的执行权。

`join()`方法的主要作用就是同步，它可以使得线程之间的并行执行变为串行执行。

```java
public class Test {
    private static int j=0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                j++;
            }
        });
        thread.start();
        System.out.println(j);
    }
}
//不等待线程结束，结果 0


public class Test {
    private static int j=0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                j++;
            }
        });
        thread.start();
        thread.join();
        System.out.println(j);
    }
}
//等待线程结束，结果 100000
```

### 2.2 volatile与Java内存模型（JMM）



一旦一个 共享变量（类的成员变量、类的静态成员变量）被 volatile 修饰之后，那么就具备了两层语义：

**1. 保证了不同线程对这个变量进行读取时的可见性，即一个线程修改了某个变量的值 ，这新值对其他线程来说是立即可见的 。(volatile  解决了线程间共享变量 的可见性问题）**

- 使用 volatile 关键字会强制将修改的值立即写入主存；
- 使用 volatile 关键字的话，当线程 2 进行修改时，会导致线程 1 的工作内存中缓存变量 (假设变量名是 x ) 的缓存行无效（反映到硬件层的话，就是 CPU 的 L1或者 L2 缓存中对应的缓存行无效）**；**
- 由于线程 1 的工作内存中缓存变量 x 的缓存行无效，所以线程 1再次读取变量 x 的值时 会去主存读取。那么，在线程 2 修改  x 值时（当然这里包括 2 个操作，修改线程 2 工作内存中的值，然后将修改后的值写入内存），会使得线程 1 的工作内存中缓存变量 x 的缓存行无效，然后线程 1 读取时，发现自己的缓存行无效，它会等待缓存行对应的主存地址被更新之后，然后去对应的主存读取最新的值。那么线程 1 读取到的就是最新的正确的值。

**2.禁止进行指令重排序 ，阻止编译器对代码的优化 。**

​	volatile 关键字禁止指令重排序有两层意思：

- 当程序执行到 volatile  变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，且 结果已经对后面的操作可见；在其后面的操作肯定还没有进行。

- 在进行指令优化时，不能把 volatile 变量前面的语句放在其后面执行，也不能把 volatile 变量后面的语句放到其前面执行。

  为了实现  volatile 的内存语义，加入 volatile 关键字时，编译器在生成字节码时，会在指令序列中插入**内存屏障**，会多出一个 lock  前缀指令。内存屏障是一组处理器指令，解决禁止指令重排序和内存可见性的问题。编译器和 CPU  可以在保证输出结果一样的情况下对指令重排序，使性能得到优化。处理器在进行重排序时是会考虑指令之间的数据依赖性。

  内存屏障有两个作用：

- 先于这个内存屏障的指令必须先执行，后于这个内存屏障的指令必须后执行 

- 使得内存可见性。所以， 如果你的字段是 volatile ，在读指令前插入读屏障，可以让高速缓存中的数据失效，重新从主内存加载数据。在写指令之后插入写屏障，能让写入缓存的最新数据写回到主内存。

 **使用场景**：synchronized关键字是防止多个线程同时执行一段代码，那么就会很影响程序执行效率，而volatile关键字在某些情况下性能要优于synchronized，但是要注意volatile关键字是无法替代synchronized关键字的，因为volatile关键字无法保证操作的原子性。通常来说，使用volatile必须具备以下2个条件：

- 　对变量的写操作不依赖于当前值
- 　该变量没有包含在具有其他变量的不变式中

有两种典型的使用场景，一是用于修饰多个线程之间的共享标志位变量，二是用于单例模式中饿汉模式:

```java
public class LazySingleton {

    // 必须要声明为 volatile 防止指令重排序
    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton() {
        if (lazySingleton != null) {
            throw new RuntimeException("单例模式禁止反射调用！");
        }
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton != null) {
                    /*
                     new对象过程：
                      1.分配内存给这个对象
                      2.初始化对象
                      3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址
                      上述三步会发生指令重排序
                     */
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
```
### 2.3 线程组

```java
public class Test {

    static class Task implements Runnable{
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            System.out.println("当前线程id: "+ current.getId()+" 当前所属线程组: "+ current.getThreadGroup().getName());
        }
    }

    public static void main(String[] args) {
        ThreadGroup group=new ThreadGroup("java线程组");
        Thread thread1 = new Thread(group, new Task());
        Thread thread2 = new Thread(group, new Task());
        thread1.start();
        thread2.start();
    }
}

//输出
当前线程id: 13 当前所属线程组: java线程组
当前线程id: 14 当前所属线程组: java线程组
```

### 2.4 守护线程（Daemon）

当一个Java应用中只有守护线程的时候，Java虚拟机就会自动退出。

```java
public class Test {

    static class Task implements Runnable{
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            System.out.println("当前线程id: "+ current.getId()+"当前所属线程组: "+ current.getThreadGroup().getName());
        }
    }

    public static void main(String[] args) {
       ThreadGroup group=new ThreadGroup("java线程组");
        Thread thread1 = new Thread(group, new Task());
        Thread thread2 = new Thread(group, new Task());
        Thread thread3 = new Thread(group, new Task());
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread1.start();  // 不会执行
        thread2.start();  // 不会执行
        thread3.start();  // 不会执行
    }
}
```

### 2.5 线程安全的概念和synchronized 

**1. volatile 和 synchronized 的区别**

- volatile 是变量修饰符，而 synchronized 则作用于代码块或方法。
- volatile 不会对变量加锁，不会造成线程的阻塞；synchronized 会对变量加锁，可能会造成线程的阻塞。
- volatile 仅能实现变量的修改可见性，并不能保证原子性；而synchronized 则 可 以 保 证 变 量 的 修 改 可 见 性 和  原 子 性 。（synchronized  有两个重要含义：它确保了一次只有一个线程可以执行代码的受保护部分（互斥），而且它确保了一个线程更改的数据对于其它线程是可见的（更改的可见性），在释放锁之前会将对变量的修改刷新到主存中）。
- volatile 标记的变量不会被编译器优化，禁止指令重排序；synchronized 标记的变量可以被编译器优化。

```java
// 线程不安全
public class Test {

    private static int i=0;
    
    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new IncreaseTask());
        Thread thread2= new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }

    static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                inc();
            }
        }
        private void inc() {
            i++;
        }
    }
}

```

```java
// 虽然用了synchronized，线程还是不安全
public class Test {

    private static int i=0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new IncreaseTask());
        Thread thread2= new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }

    static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                inc();
            }
        }
        private synchronized void inc() {   //synchronized 两个线程启动的不是同一个IncreaseTask实例
            i++;						    // inc() 是实例方法 所以两个线程锁住的是两个方法对象											
        }
    }
}
```

```java
// 线程安全解决办法一 ：两个线程启动同一个实例
public class Test {

    private static int i=0;

    public static void main(String[] args) throws InterruptedException {
        IncreaseTask task = new IncreaseTask();   
        Thread thread1= new Thread(task);     // 两个线程启动的是同一个实例
        Thread thread2= new Thread(task);
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }
    static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                inc();
            }
        }
        private synchronized void inc() {     // 由同一个实例对象产生的实例方法
            i++;
        }
    }
}


// 线程安全解决办法二: 将方法声明为static 类方法
public class Test {

    private static int i=0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new IncreaseTask());
        Thread thread2= new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }

    static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                inc();
            }
        }
        private static synchronized void inc() {  //这是一个类方法
            i++;
        }
    }
}

// 线程安全实现方法三   利用 synchronized 锁住 同一个对象
public class Test {

    private static final String s="";

    private static int i=0;

    static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                synchronized (s){
                    i++;
                }
            }
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new IncreaseTask());
        Thread thread2= new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }
}
```



## 第三章 JDK 并发包

### 3.1 同步控制

#### 3.1.1 可重入锁(ReentrantLock)

- `lock()`：获得锁，如果锁已经被占用，则等待；
- `lockInterruptibly()`: 获得锁，但优先响应中断；
- `tryLock()`:尝试获得锁，如果成功，返回true,失败返回false。该方法不等待，立即返回；
- `tryLock(long time,TimeUnit unit)`:在给定的时间内尝试获得锁；
- `unlock()`:释放锁

```java
// 线程安全的
public class Test {

    public static ReentrantLock reentrantLock=new ReentrantLock();
    private static Integer i=0;
    static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                   try {
                       reentrantLock.lock();
                       i++;
                   }catch (Exception e){
                       e.printStackTrace();
                   }finally {
                       reentrantLock.unlock();
                   }

            }
        }
        
    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new IncreaseTask());
        Thread thread2= new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }
}
    
 // 可重入性
  static class IncreaseTask implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                   try {
                       reentrantLock.lock();
                       reentrantLock.lock();
                       reentrantLock.lock();
                       i++;
                   }catch (Exception e){
                       e.printStackTrace();
                   }finally {
                       reentrantLock.unlock();
                       reentrantLock.unlock();
                       reentrantLock.unlock();
                   }

            }
        }

    }  
```



##### 1.锁申请等待超时

使用 `reentrantLock.tryLock` 方法，超过指定时间则不等待。

```java
public class Test {

    public static ReentrantLock reentrantLock=new ReentrantLock();

    private static Integer i=0;

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {

            try {
               if ( reentrantLock.tryLock(5, TimeUnit.SECONDS)){
                   Thread.sleep(6000);
               }else {
                   System.out.println("获得锁失败");
               }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new IncreaseTask());
        Thread thread2= new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
        //等待结束后 才打印返回值
        thread1.join();
        thread2.join();
        //并打印返回值
        System.out.println(i);
    }
}
```

##### 2.公平锁

```java
new ReentrantLock(true); //创建锁的时候指定参数

public class Test {

    public static ReentrantLock fairLock = new ReentrantLock(true);


    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new IncreaseTask());
        Thread thread2 = new Thread(new IncreaseTask());
        thread1.start();
        thread2.start();
    }
}
```

**公平锁需要维护一个有序队列，需要额外的开销，所以需要考虑场景使用。使用synchronized 实现的锁默认是不公平的**。

#### 3.1.2  条件（condition）

- `await()` 方法会使当前线程等待，**同时释放当前锁**，当其他线程中使用singnal()或者singnalAll()方法时，线程会**重新获得锁**并继续执行。或者当线程被中断时候，也能跳出等待。这和Object.wait() 方法很相似。
- `awaitUninterruptibly()` 方法与await()方法基本相同，但是它并不会在等待过程中响应中断。
- `singal()` 方法用于唤醒一个在等待中的线程。相对的`singalAll()`方法会唤醒所有在等待中的线程。

```java
public class Test {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                condition.await();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new IncreaseTask());
        thread1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
```

流程：在调用await()方法前线程必须获得重入锁，调用await()方法后线程会释放当前占用的锁。同理**在调用signal()方法时当前线程也必须获得相应重入锁**，调用signal()方法后系统会从condition.await()等待队列中唤醒一个线程。当线程被唤醒后，它就会尝试重新获得与之绑定的重入锁，一旦获取成功将继续执行。所以**调用signal()方法后一定要释放当前占用的锁**，这样被唤醒的线程才能有获得锁的机会，才能继续执行。

#### 3.1.3 信号量（Semaphore）

广义上说，信号量是对锁的扩展，无论是内部锁synchronized 还是 重入锁 ReentrantLock,一次都只允许一个线程访问一个资源，而信号量却允许指定多个线程，同时访问某一个资源。

- `acquire()`方法尝试获得一个准入的许可，若无法获得，则线程会等待，直到有线程释放一个许可或者当前线程被中断；
- `acquireUninterruptibly()`方法和acquire()类似，但是不响应中断；
- `tryAcquire()` 尝试获得一个许可，如果成功返回true,失败则返回false,它不会进行等待，立即返回；
- `release()` 用于在线程访问资源结束后，释放一个许可，以使其他等待许可的线程可以进行资源访问。

```java
public class Test {

    public static Semaphore semaphore=new Semaphore(5);

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getId()+"获得锁!");
                Thread.sleep(2000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        IncreaseTask task = new IncreaseTask();
        for (int i = 0; i < 20; i++) {
            new Thread(task).start();
        }
    }
}

// 五个一组，五个一组的输出
13获得锁!
14获得锁!
15获得锁!
16获得锁!
17获得锁!
    
18获得锁!
19获得锁!
20获得锁!
21获得锁!
22获得锁!
    
23获得锁!
24获得锁!
25获得锁!
26获得锁!
27获得锁!
    
28获得锁!
29获得锁!
30获得锁!
31获得锁!
32获得锁!
```

#### 3.1.4 读写锁（ReadWriteLock ）

**读写锁访问约束情况**

|      | 读     | 写   |
| :--: | ------ | ---- |
|  读  | 非阻塞 | 阻塞 |
|  写  | 阻塞   | 阻塞 |



```java
ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
```

```java
public class Test {

    // 可重入锁
    public static ReentrantLock reentrantLock = new ReentrantLock();
    // 读写锁
    public static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 读锁
    public static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    // 写锁
    public static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    //待写入或者带赋值的变量
    private static String i = "";

    //写方法
    static class Write implements Runnable {

        private Lock lock;
        private String value;

        Write(Lock lock, String value) {
            this.lock = lock;
            this.value = value;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(1000);
                i = value;
                System.out.println(Thread.currentThread().getName() + "写入值" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    //读方法
    static class Read implements Runnable {

        private Lock lock;

        Read(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "读取到值" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        // 耗时 2 秒 读锁是并行的
        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(new Write(writeLock, String.valueOf(j)));
            thread.start();
            thread.join();
        }
        for (int j = 0; j < 18; j++) {
            Thread thread = new Thread(new Read(readLock));
            thread.start();
        }


        // 耗时20秒
        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(new Write(reentrantLock, String.valueOf(j)));
            thread.start();
            thread.join();
        }
        for (int j = 0; j < 18; j++) {
            Thread thread = new Thread(new Read(reentrantLock));
            thread.start();
        }
    }
}
```

#### 3.1.5 倒计时（CountDown）

```java
public class Test {

    private static int number=1000000;
    private static CountDownLatch latch=new CountDownLatch(number);
    private static AtomicInteger integer=new AtomicInteger(0);

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            integer.incrementAndGet();
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IncreaseTask task = new IncreaseTask();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i <number ; i++) {
            executorService.submit(task);
        }
        latch.await();
        System.out.println("integer："+integer);
        executorService.shutdown();
    }
}
```

#### 3.1.6 循环栅栏（CyclicBarrier）

```java
/* 
 * @param   需要等待的线程数
 * @param   指定数量的线程到达后执行的操作
 */
public CyclicBarrier(int parties, Runnable barrierAction)
```

```java
// 每次有五个人完成 则算一个小组任务完成
public class Test {

    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            System.out.println("五人小组任务执行完成");
        }
    });

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                long l = new Double(Math.random() * 5000).longValue();
                Thread.sleep(l);
                System.out.println("任务"+Thread.currentThread().getId()+"执行完成");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int j = 0; j < 10; j++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }
}

// 输出
任务21执行完成
任务15执行完成
任务22执行完成
任务14执行完成
任务20执行完成
五人小组任务执行完成

任务16执行完成
任务19执行完成
任务17执行完成
任务18执行完成
任务13执行完成
五人小组任务执行完成
```

#### 3.1.7 线程阻塞工具类（LockSupport）

LockSupport的静态方法`park()` 可以阻塞当前线程，类似的还有`parkNanos() `和`parkUntil()`等方法。他们实现了一个限时的等待。

LockSupport类使用类似信号量的机制，它为每一个线程准备一个许可，如果许可可用，那么park()函数就会立即返回，并且消费这个许可（也就是将许可变为不可用），如果许可不可用，就会阻塞。而unpark()则使得一个许可变为可用（但是和信号量不同的是，许可不能累加，你不可能拥有超过一个许可，它永远只有一个）。

```java
public class Test {

    static class Task implements Runnable {

        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            System.out.println("线程"+ id +"开始阻塞");
            LockSupport.park();
            System.out.println("线程"+ id +"解除阻塞");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(new Task());
        Thread thread02 = new Thread(new Task());
        thread01.start();
        thread02.start();
        Thread.sleep(3000);
        System.out.println("主线程干预");
        LockSupport.unpark(thread01);
        LockSupport.unpark(thread02);
    }
}

// 输出
线程13开始阻塞
线程14开始阻塞
主线程干预
线程13解除阻塞
线程14解除阻塞
```

### 3.2 线程池

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/Executors.png"/> </div></br>
#### 3.2.1 JDK对线程池的支持

**newFixedThreadPool()方法**：该方法返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。当有一个新的任务提交时，线程池中若有空闲的线程，则立即执行。若没有，则新的任务会被暂时存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务。

**newSingleThreadExecutor()方法**： 该方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，任务会被保存在一个任务队列中，带线程空闲，按照先入先出的顺序执行队列中的任务。

**newCachedThreadPool()方法**：根据实际情况动态调整线程数量。

**newSingleThreadScheduledExecutor()方法**：该方法返回一个ScheduledExecutorService对象，线程池大小为 1。SeheduledExectorService接口在ExecutorService接口之上扩展了在给定时间执行某任务的功能，如在某个固定的延时之后执行，或者周期性执行某个任务。

**newScheduledThreadPool()方法**：该方法也返回一个ScheduledExecutorService对象，但该线程池可以指定线程数量。

```java
// 线程池举例
public class Test {

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
    }

}
```

##### 1.计划任务

```java
// 在给定的时间，对任务进行一次调度
public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
public <V> ScheduledFuture<V> schedule(Callable<V> callable,long delay, TimeUnit unit);

// 以上一个任务开始执行时间为起点，之后的period时间，调度下一次任务，如果任务耗时大于period，则上一次任务结束后立即执行下一次任务
public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,long initialDelay,long period,
                                                  TimeUnit unit);
// 以上一个任务开始执行时间为起点，再经过delay时间，调度下一次任务，不论任务耗时如何，上一次任务结束后都需要等待delay时间之后才可以执行下一次任务
public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,long delay,
                                                  TimeUnit unit);



public class Test {

    public static long cacheTime = System.currentTimeMillis();

    static class Task implements Runnable {

        private String type;

        Task(String type) {
            this.type = type;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                long nowTime = System.currentTimeMillis();
                long period = (nowTime - cacheTime);
                System.out.println(type + Thread.currentThread().getId() + "执行耗时" + period + "毫秒");
                cacheTime = nowTime;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        // 只执行一次
        ScheduledFuture<?> schedule = pool.schedule(new Task("schedule"), 2, TimeUnit.SECONDS);
        // 指定2秒为固定周期执行，如果项目执行耗时5秒，则项目结束后立马执行下一次任务，所以输出的时间间隔为5秒
        pool.scheduleAtFixedRate(new Task("FixedRate"), 0, 2, TimeUnit.SECONDS);
        // 总是在上一次项目结束后间隔指定周期执行，所以项目耗时5秒，还需要间隔2秒执行，所以输出的时间间隔为7秒
        pool.scheduleWithFixedDelay(new Task("WithFixedDelay"),0,2,TimeUnit.SECONDS);
    }

}
```



#### 3.2.2 线程池内部实现

```java
public ThreadPoolExecutor(int corePoolSize,                          //核心线程数量
                              int maximumPoolSize,                   //最大线程数量   
                              long keepAliveTime,                    //超过核心线程数量的线程的存活时间
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,     //任务队列
                              ThreadFactory threadFactory,           //线程工厂
                              RejectedExecutionHandler handler)      //拒绝策略
```

##### **1.JDK内置的拒绝策略**

**AbortPolicy策略**：该策略会直接抛出异常，阻止系统正常工作；

**CallerRunsPolicy策略**：只要线程池未关闭，该策略直接在调用线程中运行当前被丢弃的任务。这种情况下，提交任务的线程性能可能会急剧下降。

**DiscardOledestPolicy策略**：该策略将丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试再次提交当前任务。

**DiscardPolicy策略**：默认丢弃无法处理的任务，不予任何处理。

```java
public class Test {

    private  static int i=0;
    private static CountDownLatch latch=new CountDownLatch(1000);
    static class Task implements Runnable {

        @Override
        public void run() {
            increase();
        }

        private void increase(){
            synchronized (this){
                i++;
            }
            System.out.println(Thread.currentThread().getName()+"输出:"+i);
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 自定义线程
        ExecutorService executorService = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    System.out.println("create" + thread.getName());
                    return thread;
                });

        Task task = new Task();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(task);
        }
        latch.await();
        System.out.println("最后的结果是"+i);
        executorService.shutdown();
    }
}
```

##### 2.线程池的扩展

`ThreadPoolExecutor`是一个可以拓展的线程池，它提供了beforeExecute()、afterExecute()和terminated() 三个接口对线程池进行扩展。

```java
public class Test {

    private static int i = 0;

    private static CountDownLatch latch = new CountDownLatch(1000);

    static class Task implements Runnable {

        @Override
        public void run() {
            increase();
        }

        private void increase() {
            synchronized (this) {
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "输出:" + i);
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 自定义线程
        ExecutorService executorService = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()) {

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("线程" + t.getName() + "准备执行");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("线程" + r + "执行结束");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        Task task = new Task();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(task);
        }
        latch.await();
        System.out.println("最后的结果是" + i);
        executorService.shutdown();
    }
}
```

##### 3.合理优化线程池的数量

<div align="center"> <img src="../pictures/合理线程池数量.png"/> </div></br>

#### 3.2.3 Fork/Join 框架

 ForkJoin主要提供了两个主要的执行任务的接口。RecurisiveAction与RecurisiveTask：

- RecurisiveAction ：没有返回值的接口;
- RecurisiveTask ：带有返回值的接口。

ForkJoinPool提供如下两个常用的构造器：

- `ForkJoinPool(int parallelism) ` 创建一个包含parallelism个并行线程的ForkJoinPool;

- `ForkJoinPool() ` 以Runtime.availableProcessors()方法的返回值作为parallelism参数来创建ForkJoinPool。

```java
public class CountTask extends RecursiveTask<Long> {

    private Long start;

    private Long end;

    private static long hold=50L;

    CountTask(Long start,Long end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {
        long sum=0L;
        // 一定要保证能够进进入if中的终止条件，如果无限制的拆分,可能会导致栈溢出
        if (end-start<=hold){
            // 假设一个最小计算单元都是耗时的
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (long i = start; i < end; i++) {
                sum+=i;
            }
        }else {
            List<CountTask> countTasks=new ArrayList<>();
            long l = (end - start) / hold;
            for (int i = 0; i <l; i++) {
                CountTask task = new CountTask(start + i * hold, start + (i + 1) * hold);
                countTasks.add(task);
                task.fork();
                if (i==l-1){
                    CountTask countTask = new CountTask(start + (i + 1) * hold, end);
                    countTasks.add(countTask);
                    countTask.fork();
                }
            }
            for (CountTask countTask:countTasks){
                sum+=countTask.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool=new ForkJoinPool(100);
        CountTask task = new CountTask(0L, 10000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        Long aLong = result.get();
        System.out.println("结果为"+aLong);
    }
}

```

### 3.3 并发容器

#### 3.3.1 并发集合简介（java.util.concurrent）

- **ConcurrentHashMap**:线程安全的HashMap;
- **CopyOnWriteArrayList**:在读多写少的场合，这个List的性能非常好，远远好于Vector。CopyOnWriteArrayList读取是完全不用加锁的，写入也不会阻塞读取操作，只有写入与写入之间需要加锁。
- **ConcurrentLinkedQueue**:高效的并发队列，使用链表实现。可以看作一个线程安全的LinkList，算是在高并发环境下性能最好的队列;
- **BlockingQuene**:这是一个接口，JDK内部通过链表（LinkedBlockingQueue），数组（ArrayBlockingQueue）等方式实现了这个接口。表示阻塞队列，非常适合用于作为数据共享的通道；
- **ConcurrentSkipListMap**:跳表的实现。这是一个Map,使用调表的数据结构进行快速查找。



## 第四章 锁的优化及注意事项

### 4.2 Java虚拟机对锁优化锁做的努力

作为一款公用平台，JDK 本身也为并发程序的性能绞尽脑汁，在 JDK 内部也想尽一切办法提供并发时的系统吞吐量。

#### 1. 锁偏向

锁偏向是一种针对加锁操作的优化手段。

**如果一个线程获得了锁，那么锁就进入偏向模式。当这个线程再次请求锁时，无须再做任何同步操作。这样就节省了大量有关锁申请的操作，从而提高了程序性能。**

因此，对于几乎没有锁竞争的场合，偏向锁有比较好的优化效果，因为连续多次极有可能是同一个线程请求相同的锁。而对于锁竞争比较激烈的场合，其效果不佳。因为在竞争激烈的场合，最有可能的情况是每次都是不同的线程来请求相同的锁。使用Java虚拟机参数-XX:UseBiasedLocking 可以开启偏向锁。

#### 2. 轻量级锁

**如果偏向锁失败，即上一个请求的锁的线程和这个线程不是同一个。偏向锁失败意味者不能避免做同步操作**。此时，虚拟机并不会立即挂起线程。他会使用一种成为轻量级锁的优化手段。 

轻量级锁的操作也很方便，它只是简单地将对象头部作为指针，指向持有锁的线程堆栈的内部，来判断一个线程是否持有对象锁。 如果线程获得轻量级锁成功，则可以顺利进入临界区。如果轻量级锁失败，则表示其他线程抢先争夺了锁，那么当前线程的锁请求就会膨胀为重量级锁。

#### 3. 自旋锁

**锁膨胀后，虚拟机为了避免线程真实地在操作系统层面挂起，虚拟机还会在做最后的努力–自选锁**。由于当前线程暂时无法获得锁，但是什么时候可以获得锁是一个未知数。也许在CPU几个时钟周期后，就可以得到锁。如果这样，简单粗暴的挂起线程可能是一种得不偿失的操作，因此系统会进行一次赌注：它会假设在不久的将来，线程可以得到这把锁。

因此虚拟机让当前线程做个空循环，在经过若干次循环后，如果可以得到锁，那么就顺利进入临界区。如果还不能得到锁，才会真实地将线程在操作系统层面挂起。

#### 4. 锁消除

**锁消除是一种更彻底的锁优化。Java虚拟机在JIT编译时，通过对运行上下文的扫描，去除不可能存在共享资源竞争的锁。通过锁消除，可以节省毫无意义的请求锁时间**。

下面这种这种情况，我们使用vector， 而vector内部使用了synchronize请求锁。

```java
public String []  createStrings(){
    Vector<String>  v= new Vector<String>();
    for(int i=0;i<100;i++){
        v.add(Integer.toString(i));
    }
    return v.toArray(new String[]{});
}
```

由于V只在函数  createStrnigs  中使用，因此它只是一个单纯的局部变量。局部变量是在线程栈上分配的，属于线程私有额数据，因此不可能被其他线程访问。所以，在这种情况下，Vector内部所有加锁同步都是没有必要的。如果虚拟机检测到这种情况，就会将这些无用的锁操作去除。

**锁消除涉及的一项关键技术为逃逸分析。所谓逃逸分析就是观察某一个变量是否会逃出某一个作用域**。在本例中，变量v显然没有逃出createString  函数之外。以此为基础，虚拟机才可以大胆的将v内部的加锁操作去除。如果createStrings  返回的不是String数组，而是v本身，那么就认为变量v逃逸出了当前函数，也就是说v有可能被其他线程访问。如是这样，虚拟机就不能消除v中的锁操作。

**逃逸分析必须在 -server 模式下进行，可以使用 -XX:DoEscapeAnalysis 参数打开逃逸分析，使用 -XX:+EliminateLocks 参数可以打开锁消除。**



### 4.3 人手一只笔（ThreadLocal）

```java
// SimpleDateFormat.parse() 不是线程安全的方法
public class Test {
    public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static class Task implements Runnable{
        private int i;
        Task(int i){
            this.i=i;
        }

        @Override
        public void run() {
            try {
                Date parse = sdf.parse("2018-08-08 08:08:" + i / 60);
                System.out.println(i+":"+parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task(i));
        }
    }
}

```

使用threadLocal优化：

```java
public class Test {

    private static ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal<>();

    static class Task implements Runnable{
        private int i;
        Task(int i){
            this.i=i;
        }

        @Override
        public void run() {
            try {
                if (threadLocal.get()==null){
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date parse = threadLocal.get().parse("2018-08-08 08:08:" + i / 60);
                System.out.println(i+":"+parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
    }
}
```



### 4.4 无锁

CAS的全称是Compare And Swap 即比较交换，其算法核心思想如下

```java
执行函数：CAS(V,E,N)
```

其包含3个参数

- V表示要更新的变量

- E表示预期值

- N表示新值


如果V值等于E值，则将V的值设为N。若V值和E值不同，则说明已经有其他线程做了更新，则当前线程什么都不做。通俗的理解就是CAS操作需要我们提供一个期望值，当期望值与当前线程的变量值相同时，说明还没线程修改该值，当前线程可以进行修改，也就是执行CAS操作，但如果期望值与当前线程不符，则说明该值已被其他线程修改，此时不执行更新操作，但可以选择重新读取该变量再尝试再次修改该变量，也可以放弃操作。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/原子包.png"/> </div></br>
```java
// 原子类
public class Test {

    private static int i=0;
    private static AtomicInteger j=new AtomicInteger(0);
    // AtomicReference 对普通对象的封装
    private static AtomicReference<Integer> k=new AtomicReference<>(0);

    static class Task implements Runnable{

        private CountDownLatch latch;

        Task(CountDownLatch latch){
            this.latch=latch;
        }

        @Override
        public void run() {
            i++;
            j.incrementAndGet();
            k.getAndUpdate(x->x+1);
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int number = 10000;
        CountDownLatch latch=new CountDownLatch(number);
        Semaphore semaphore=new Semaphore(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Task task = new Task(latch);
        for (int i = 0; i < number; i++) {
            semaphore.acquire();
            executorService.execute(task);
            semaphore.release();
        }
        latch.await();
        System.out.println("输出i的值"+i);
        System.out.println("输出j的值"+j.get());
        System.out.println("输出K的值"+k.get());
        executorService.shutdown();
    }
}

// 输出
输出i的值9983
输出j的值10000
输出K的值10000
```

**1. 无锁数组**

```java
public class Test {

    private static int number = 100000;

    private static int capacity = 10;

    // 保证对集合内元素的操作具有原子性
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(capacity);

    // 对集合本生的操作线程安全 对集合内元素的操作线程不安全
    private static LinkedBlockingQueue<Integer> LinkedBlockingQueue = new LinkedBlockingQueue<>();

    //对集合本生的操作线程安全  对集合内元素的操作线程不安全
    private static Vector<Integer> vector = new Vector<>(10);

    //普通集合
    private static ArrayList<Integer> arrayList = new ArrayList<>(capacity);
    private static ArrayList<Integer> list = new ArrayList<>();

    static {
        for (int i = 0; i < capacity; i++) {
            arrayList.add(i, 0);
            vector.add(i, 0);
        }
    }

    static class Task implements Runnable {

        private CountDownLatch latch;
        private int number;

        Task(CountDownLatch latch, int number) {
            this.latch = latch;
            this.number = number;
        }

        @Override
        public void run() {
            LinkedBlockingQueue.add(1);
            list.add(1);
            int num = number % capacity;
            arrayList.set(num, arrayList.get(num) + 1);
            vector.set(num, arrayList.get(num) + 1);
            atomicIntegerArray.getAndIncrement(num);
            latch.countDown();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(number);
        Semaphore semaphore = new Semaphore(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < number; i++) {
            semaphore.acquire();
            executorService.execute(new Task(latch, i));
            semaphore.release();
        }
        latch.await();
        System.out.println("arrayList:" + arrayList);
        System.out.println("atomicIntegerArray:" + atomicIntegerArray);
        System.out.println("vector:" + vector);
        System.out.println("list:" + list.size());
        System.out.println("LinkedBlockingQueue:" + LinkedBlockingQueue.size());
        executorService.shutdown();
    }
}

// arrayList:[9999, 9998, 9985, 8542, 9998, 10000, 9996, 9999, 9995, 9998]
// atomicIntegerArray:[10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
// vector:[10000, 9999, 9986, 8543, 9999, 10001, 9997, 10000, 9996, 9999]
// list:99847
// LinkedBlockingQueue:100000
```

**2. AtomicIntegerFieldUpdater**

`AtomicIntegerFieldUpdater`让普通变量也能具备原子性的操作。

- AtomicIntegerFieldUpdater只能修改它可见范围内的变量，其是通过反射得到这个变量的，如果不可见，就会出错；
- 为保证变量被正确的读取，它必须是volatile类型的；
- 由于CSA操作会通过对象实例中的偏移量直接进行赋值，因此，它不支持static字段。

```java
public class Test {

    static class Task implements Runnable {

        private Candidate candidate;
        private CountDownLatch latch;
        private AtomicIntegerFieldUpdater fieldUpdater;

        Task(CountDownLatch latch, Candidate candidate,AtomicIntegerFieldUpdater fieldUpdater) {
            this.candidate = candidate;
            this.latch=latch;
            this.fieldUpdater=fieldUpdater;
        }

        @Override
        public void run() {
            fieldUpdater.incrementAndGet(candidate);
            latch.countDown();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        int number = 10000;
        CountDownLatch latch = new CountDownLatch(number);
        Semaphore semaphore = new Semaphore(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Candidate candidate = new Candidate("候选人", 0);
        AtomicIntegerFieldUpdater<Candidate> fieldUpdater=AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");
        for (int i = 0; i < number; i++) {
            semaphore.acquire();
            executorService.execute(new Task(latch, candidate,fieldUpdater));
            semaphore.release();
        }
        latch.await();
        System.out.println(candidate.getName() + "获得票数:" + candidate.getScore());
        executorService.shutdown();
    }


    private static class Candidate {

        private String name;

        // 1. 不能声明为 private  2. 必须用 volatile 关键字修饰
        public volatile int score;

        Candidate(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public int getScore() {
            return score;
        }
        public void setScore(int score) {
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

// 输出
候选人获得票数:10000
```

**3. SynchronousQueue队列  实现线程之间通讯**

SynchronousQueue内部没有容量，但是由于一个插入操作总是对应一个移除操作，反过来同样需要满足。那么一个元素就不会再SynchronousQueue 里面长时间停留，一旦有了插入线程和移除线程，元素很快就从插入线程移交给移除线程。也就是说这更像是一种信道（管道），资源从一个方向快速传递到另一方向。显然这是一种**快速传递元素的方式**，也就是说在这种情况下元素总是以最快的方式从插入着（生产者）传递给移除着（消费者），这在多任务队列中是最快处理任务的方式。

```java
public class Test {


    public static SynchronousQueue<Double> queue = new SynchronousQueue<>();

    static class ReadThread implements Runnable {

        @Override
        public void run() {
            System.out.println("读线程启动");
            while (true){
                try {
                    Double peek = queue.take();
                    System.out.println("读线程获取值:" + peek);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class WriteThread implements Runnable {

        @Override
        public void run() {
            System.out.println("写线程写入值");
            try {
                queue.put(Math.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadThread()).start();
        Thread.sleep(3000);
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.scheduleAtFixedRate(new WriteThread(),0,2,TimeUnit.SECONDS);
    }
}

结果：
读线程启动
写线程写入值
读线程获取值:0.4200400971747895
写线程写入值
读线程获取值:0.5515246887760102
写线程写入值
读线程获取值:0.37153976270075484
写线程写入值
读线程获取值:0.5244714268587413
```

## 第五章 并行模式与算法

### 5.5 JDK中的Future

使用Future模式,获取数据的时候可能无法立即得到需要的数据。而是先拿到一个包装,可以在需要的时候再去get获取需要的数据。

```java
public class Test {

    static class Task implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            Thread.sleep(3000);
            return Math.random();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(100);
        List<Future<Double>> futureList = new ArrayList<>();
        Task task = new Task();
        for (int i = 0; i < 100; i++) {
            Future<Double> submit = executors.submit(task);
            futureList.add(submit);
        }
        // 模拟主线程执行另外一个耗时的计算
        Thread.sleep(3000);
        for (int i = 0; i < futureList.size(); i++) {
            try {
                Double aDouble = futureList.get(i).get();
                System.out.println("获得任务" + i + "结果" + aDouble);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
    }
}
```

## 第六章  JAVA 8 并发

```java
public static void main(String[] args) {
        String[] strings={"1","2","3","4","5","6","7","8","9","10"};
        Consumer consumer = System.out::println;
        Consumer consumerErr = System.err::println;
        Arrays.stream(strings).forEach(consumer.andThen(consumerErr));
    }
```

### 6.5 增强的Future(CompletableFuture)

1. 当一个Future可能需要显示地完成时，使用`CompletionStage`接口去支持完成时触发的函数和操作。

```java
public class Test {

    static class Compute implements Runnable {

        private CompletableFuture<Integer> future;

        Compute(CompletableFuture<Integer> future){
            this.future=future;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程等待主线程运算完成····");
                Integer integer = future.get();
                System.out.println("子线程完成后续运算:"+integer*integer);
            } catch (InterruptedException|ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future=new CompletableFuture<>();
        System.out.println("主线程开始计算");
        new Thread(new Compute(future)).start();
        int i=0;
        for (int j = 0; j <100; j++) {
            i=i+j;
        }
        Thread.sleep(2000);
        System.out.println("主线程计算完成");
        future.complete(i);
    }
}


主线程开始计算
子线程等待主线程运算完成····
主线程计算完成
子线程完成后续运算:24502500
```

2. `CompletableFuture`中4个异步执行任务静态方法：

```java
public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
    return asyncSupplyStage(asyncPool, supplier);
}

public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier,Executor executor) {
    return asyncSupplyStage(screenExecutor(executor), supplier);
}

public static CompletableFuture<Void> runAsync(Runnable runnable) {
    return asyncRunStage(asyncPool, runnable);
}  

public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor) {
    return asyncRunStage(screenExecutor(executor), runnable);
}
```

其中supplyAsync用于有返回值的任务，runAsync则用于没有返回值的任务。Executor参数可以手动指定线程池，否则默认ForkJoinPool.commonPool()系统级公共线程池，**这些线程都是Daemon线程，这意味着如果主线程退出，这些线程无论是否完成，都会退出**。

```java
public class Test {

    private static Integer compute() {
        int i=0;
        for (int j = 0; j <100; j++) {
            i=i+j;
        }
        System.out.println("运算方法所在的线程："+Thread.currentThread().getId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getId()+"线程开始计算");
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(Test::compute);
        Integer integer = supplyAsync.get();
        System.out.println(Thread.currentThread().getId()+"线程计算完成:"+integer*integer);

    }
    
1线程开始计算
运算方法所在的线程：11
1线程计算完成:24502500
```

3. 流式调用

```java
public class Test {

    private static Integer compute() {
        System.out.println("compute所在线程："+Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }

    private static Integer epr(Integer integer) {
        try {
            System.out.println("epr所在线程："+Thread.currentThread().getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return integer*integer;
    }

    private static void accept(Integer integer){
        System.out.println("accept所在线程："+Thread.currentThread().getId());
        System.out.println("accept方法消费掉计算结果:"+integer);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(Test::compute)
                .thenApply(Test::epr)
                .thenAccept(Test::accept)   //值在这一步被消费掉了
                .thenAccept(x-> System.out.println("运算结果:"+x));
        future.get(); //如果缺少这一步，不会有任何输出。原因：supplyAsync 默认使用的线程池中的线程全部是守护线程
    }
}

compute所在线程：11
epr所在线程：11
accept所在线程：11
accept方法消费掉计算结果:10000
运算结果:null
```

4. 异常捕获 exceptionally

```java
public class Test {

    private static Integer compute() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 100 / 0;
        return 100;
    }

    private static Integer dealException(Throwable e){
        e.printStackTrace();
        return 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(Test::compute)
                .exceptionally(Test::dealException)
                .thenAccept(System.out::println);
        future.get();
    }
}
```

5.组合多个CompletableFuture ( thenCompose方法 和 thenCombineAsync方法)

```java
public class Test {

    private static Integer compute() {
        System.out.println("compute 所在线程："+Thread.currentThread().getId());
        return 100;
    }

    private static Integer epr(Integer integer) {
        System.out.println("epr 所在线程："+Thread.currentThread().getId());
        return integer*integer;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 组合实现方式1 thenCompose 一个计算的输入依赖另外一个计算的结果
        CompletableFuture<Void> future01 = CompletableFuture.supplyAsync(Test::compute)
                .thenCompose(x->CompletableFuture.supplyAsync(()->epr(x)))
                .thenAccept(x-> System.out.println("运算结果:"+x));
        future01.get();

        System.out.println();

        // 组合实现方式2 thenCombineAsync 两个计算之间不依赖
        CompletableFuture<Integer> future02 = CompletableFuture.supplyAsync(Test::compute);
        CompletableFuture<Integer> future03 = CompletableFuture.supplyAsync(()->Test.epr(100));
        CompletableFuture<Integer> futureAll = future02.thenCombineAsync(future03, (x, y) -> x + y);
        System.out.println("运算结果:"+futureAll.get());

    }
}

compute 所在线程：11
epr 所在线程：11
运算结果:10000

compute 所在线程：11
epr 所在线程：11
运算结果:10100
```

### 6.6  StampedLock

 StampedLock是并发包里面jdk8版本新增的一个锁，该锁提供了三种模式的读写控制，三种模式分别如下：

- 写锁writeLock，是个排它锁或者叫独占锁，同时只有一个线程可以获取该锁，当一个线程获取该锁后，其它请求的线程必须等待，当目前没有线程持有读锁或者写锁的时候才可以获取到该锁，请求该锁成功后会返回一个stamp票据变量用来表示该锁的版本，当释放该锁时候需要unlockWrite并传递参数stamp。

- 悲观读锁readLock，是个共享锁，在没有线程获取独占写锁的情况下，同时多个线程可以获取该锁，如果已经有线程持有写锁，其他线程请求获取该读锁会被阻塞。这里讲的悲观其实是参考数据库中的乐观悲观锁的，这里说的悲观是说在具体操作数据前悲观的认为其他线程可能要对自己操作的数据进行修改，所以需要先对数据加锁，这是在读少写多的情况下的一种考虑,请求该锁成功后会返回一个stamp票据变量用来表示该锁的版本，当释放该锁时候需要unlockRead并传递参数stamp。

- 乐观读锁tryOptimisticRead，是相对于悲观锁来说的，在操作数据前并没有通过CAS设置锁的状态，如果当前没有线程持有写锁，则简单的返回一个非0的stamp版本信息，获取该stamp后在具体操作数据前还需要调用validate验证下该stamp是否已经不可用，也就是看当调用tryOptimisticRead返回stamp后到到当前时间间是否有其他线程持有了写锁，如果是那么validate会返回0，否者就可以使用该stamp版本的锁对数据进行操作。由于tryOptimisticRead并没有使用CAS设置锁状态所以不需要显示的释放该锁。该锁的一个特点是适用于读多写少的场景，因为获取读锁只是使用与或操作进行检验，不涉及CAS操作，所以效率会高很多，但是同时由于没有使用真正的锁，在保证数据一致性上需要拷贝一份要操作的变量到方法栈，并且在操作数据时候可能其他写线程已经修改了数据，而我们操作的是方法栈里面的数据，也就是一个快照，所以最多返回的不是最新的数据，但是一致性还是得到保障的。

```java
public class Point {
    private double x, y;//内部定义表示坐标点
    private final StampedLock s1 = new StampedLock();//定义了StampedLock锁

    void move(double deltaX, double deltaY) {
        long stamp = s1.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            s1.unlockWrite(stamp);//退出临界区,释放写锁
        }
    }

    double distanceFormOrigin() {//只读方法
        long stamp = s1.tryOptimisticRead();  
        double currentX = x, currentY = y;
        if (!s1.validate(stamp)) {
            stamp = s1.readLock()
            try {
                currentX = x;
                currentY = y;
            } finally {
                s1.unlockRead(stamp);//退出临界区,释放读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
```

### 6.7 LongAdder 和 LongAccumulator

```java
public class Test {

    private static int number=1000000;
    private static CountDownLatch latch=new CountDownLatch(number);
    private static int anInt= 0 ;
    private static AtomicLong atomicLong=new AtomicLong(0L);
    // 比 AtomicLong 性能更好  适用于求和的场景
    private static LongAdder longAdder=new LongAdder();
    // 对 LongAccumulator 增加 构造函数支持传入对应的运算函数
    private static LongAccumulator longAccumulator=new LongAccumulator((x,y)->x+y,0);

    static class Task implements Runnable{

        @Override
        public void run() {
            anInt++;
            atomicLong.incrementAndGet();
            longAdder.add(1);
            longAccumulator.accumulate(1);
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(1000);
        Task task = new Task();
        for (int i = 0; i < number; i++) {
            semaphore.acquire();
            executor.submit(task);
            semaphore.release();
        }
        latch.await();
        System.out.println("int:"+anInt);
        System.out.println("atomicLong:"+atomicLong.intValue());
        System.out.println("longAdder:"+longAdder.intValue());
        System.out.println("longAccumulator:"+longAccumulator.intValue());
        executor.shutdown();
    }
}


int:998719
atomicLong:1000000
longAdder:1000000
longAccumulator:1000000
```



## 参考内容：

+ **《实战Java高并发程序设计》** 葛一鸣 郭超 编
+ [Java多线程（二）volatile关键字](https://juejin.im/post/5b5727d66fb9a04f834652d6)
+ [JDK8并发包新增StampedLock锁](https://www.jianshu.com/p/481071ddafd3)
