# Java 函数式编程

<nav>
<a href="#一Lambda">一、Lambda</a><br/>
<a href="#二函数式接口">二、函数式接口</a><br/>
<a href="#三创建流">三、创建流</a><br/>
<a href="#四操作流">四、操作流</a><br/>
<a href="#五收集器">五、收集器</a><br/>
<a href="#六并行流">六、并行流</a><br/>
</nav>


## 一、Lambda

### 1.1 格式

JDK 从 1.8 版本开始支持 Lambda 表达式，通过 Lambda 表达式我们可以将一个函数作为参数传入方法中。在 JDK 1.8 之前，我们只能通过匿名表达式来完成类似的功能，但是匿名表达式比较繁琐，存在大量的模板代码，不利于将行为参数化，而采用 Lamdba 则能很好的解决这个问题。Lambda 表达式的基本语法如下：

```java
(parameters) -> expression
```

或采用花括号的形式：

```java
(parameters) -> { statements; }
```

Lambda 表达式具有如下特点：

- **可选的参数：**不需要声明参数类型，编译器会依靠上下文进行自动推断；
- **可选的参数圆括号：**当且仅当只有一个参数时，包裹参数的圆括号可以省略； 
- **可选的花括号：**如果主体只有一个表达式，则无需使用花括号； 
- **可选的返回关键字：**如果主体只有一个表达式，则该表达式的值就是整个 Lambda 表达式的返回值，此时不需要使用 return 关键字进行显式的返回。

### 1.2 行为参数化

 上面我们说过，Lambda 表达式主要解决的是行为参数化的问题，而什么是行为参数化？下面给出一个具体的示例：

```java
/**
 * 定义函数式接口
 * @param <T> 参数类型
 */
@FunctionalInterface
public interface CustomPredicate<T> {
    boolean test(T t);
}
```

```java
/**
 * 集合过滤
 * @param list 待过滤的集合
 * @param predicate 函数式接口
 * @param <T> 集合中元素的类型
 * @return 满足条件的元素的集合
 */
public static <T> List<T> filter(List<T> list, CustomPredicate<T> predicate) {
    ArrayList<T> result = new ArrayList<>();
    for (T t : list) {
        // 将满足条件的元素添加到返回集合中
        if (predicate.test(t)) result.add(t);
    }
    return result;
}

```

针对不同类型的集合，我们可以通过传入不同的 Lambda 表达式作为参数来表达不同的过滤行为，这就是行为参数化：

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
filter(integers, x -> x % 2 == 0);  // 过滤出所有偶数

List<Employee> employees = Arrays.asList(
    new Employee("张某", 21, true),
    new Employee("李某", 30, true),
    new Employee("王某", 45, false));
filter(employees, employee -> employee.getAge() > 25); // 过滤出所有年龄大于25的员工
```

需要注意的是上面我们声明接口时，使用了 `@FunctionalInterface` 注解，它表示当前的接口是一个函数式接口。函数式接口就是只含有一个抽象方法的接口；即一个接口不论含有多少个默认方法和静态方法，只要它只有一个抽象方法，它就是一个函数式接口。使用 `@FunctionalInterface` 修饰后，当该接口有一个以上的抽象方法时，编译器就会进行提醒。

任何使用到函数式接口的地方，都可以使用 Lambda 表达式进行简写。例如 Runnable 接口就是一个函数式接口，我们可以使用 Lambda 表达式对其进行简写：

```java
new Thread(() -> {
    System.out.println("hello");
});
```

### 1.3 方法引用和构造器引用

紧接上面的例子，如果我们需要过滤出所有的正式员工，除了可以写成下面的形式外：

```java
filter(employees, employee -> employee.isOfficial());
```

还可以使用方法引用的形式进行简写：

```java
filter(employees, Employee::isOfficial);
```

除了方法引用外，还可以对构造器进行引用，示例如下：

```java
Stream<Integer> stream = Stream.of(1, 3, 5, 2, 4);
stream.collect(Collectors.toCollection(ArrayList::new));  //等价于 toCollection(()->new ArrayList<>())
```

方法引用和构造器引用的目的都是为了让代码更加的简洁。



## 二、函数式接口

通常我们不需要自定义函数式接口，JDK 中内置了大量函数式接口，基本可以满足大多数场景下的使用需求，最基本的四种如下：

**1. Consumer\<T>**：消费型接口，消费输入的变量，没有返回值：

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    ...
}
```

**2. Consumer\<T>**：供给型接口，供给变量：

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

**3. Function<T, R>**：对输入类型为 T 的变量执行特定的转换操作，并返回类型为 R 的返回值：

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
    ...
}
```

 **4. Predicate\<T>**：判断类型为 T 的变量是否满足特定的条件，如果满足则返回 true，否则返回 flase：

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    ...
}
```

其他函数式接口都是这四种基本类型的扩展和延伸。以 BiFunction 和 BinaryOperator 接口为例：

+ **BiFunction<T, U, R>**：是函数型接口 Function<T, R> 的扩展，Function 只能接收一个入参；而 BiFunction 可以用于接收两个不同类型的入参；
+ **BinaryOperator\<T>**：是 BiFunction 的一种特殊化情况，即两个入参和返回值的类型均相同，通常用于二元运算。定义如下：

```java
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
  ....
}
```

下面演示一下 BinaryOperator 的用法：

```java
/**
 * 执行归约操作
 */
public static <T> T reduce(List<T> list, T initValue, BinaryOperator<T> binaryOperator) {
    for (T t : list) {
        initValue = binaryOperator.apply(initValue, t);
    }
    return initValue;
}

public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    reduce(integers, 0, (a, b) -> a + b); // 求和  输出：15
    reduce(integers, 1, (a, b) -> a * b); // 求积  输出：120
}
```



## 三、创建流

JDK 1.8 中另一个大的改进是引入了流，通过流、Lamda 表达式以及函数式接口，可以高效地完成数据的处理。创建流通常有以下四种方法：

**1. 由值创建**

使用静态方法 `Stream.of()` 由指定的值进行创建：

```java
Stream<String> stream = Stream.of("a", "b ", "c", "d");
```

**2. 由集合或数组创建**

使用静态方法 `Arrays.stream()` 由指定的数组进行创建：

```java
String[] strings={"a", "b ", "c", "d"};
Stream<String> stream = Arrays.stream(strings);
```

调用集合类的 `stream()` 方法进行创建：

```shell
List<String> strings = Arrays.asList("a", "b ", "c", "d");
Stream<String> stream = strings.stream();
```

`stream()` 方法定义在 `Collection` 接口中，它是一个默认方法，因此大多数的集合都可以通过该方法来创建流：

```java
public interface Collection<E> extends Iterable<E> {
    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
```

**3. 由文件创建**

```java
try (Stream<String> lines = Files.lines(Paths.get("pom.xml"), StandardCharsets.UTF_8)) {
    lines.forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}
```

**4. 由函数创建**

除了以上方法外，还可以通过 `Stream.iterate()` 和 `Stream.generate()` 方法来来创建无限流：

+ `Stream.iterate()` 接受两个参数：第一个是初始值；第二个参数是一个输入值和输出值相同的函数型接口，主要用于迭代式地产生新的元素，示例如下：

  ```java
  // 依次输出0到9
  Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::print);
  ```

+ `Stream.generate()`  接收一个供应型函数作为参数，用于按照该函数产生新的元素：

  ```java
  // 依次输出随机数
  Stream.generate(Math::random).limit(10).forEach(System.out::print);
  ```

## 四、操作流

### 4.1 基本操作

当流创建后，便可以利用 Stream 类上的各种方法对流中的数据进行处理，常用的方法如下：

| 操作      | 作用                               | 返回类型     | 使用的类型/函数式接口  |
| --------- | ---------------------------------- | ------------ | ---------------------- |
| filter    | 过滤符合条件的元素                 | Stream\<T>   | Predicate\<T>          |
| distinct  | 过滤重复元素                       | Stream\<T>   |                        |
| skip      | 跳过指定数量的元素                 | Stream\<T>   | long                   |
| limit     | 限制元素的数量                     | Stream\<T>   | long                   |
| map       | 对元素执行特定转换操作             | Stream\<T>   | Function<T,R>          |
| flatMap   | 将元素扁平化后执行特定转换操作     | Stream\<T>   | Function<T,Stream\<R>> |
| sorted    | 对元素进行排序                     | Stream\<T>   | Comparator\<T>         |
| anyMatch  | 是否存在任意一个元素能满足指定条件 | boolean      | Predicate\<T>          |
| noneMatch | 是否所有元素都不满足指定条件       | boolean      | Predicate\<T>          |
| allMatch  | 是否所有元素都满足指定条件         | boolean      | Predicate\<T>          |
| findAny   | 返回任意一个满足指定条件的元素     | Optional\<T> |                        |
| findFirst | 返回第一个满足指定条件的元素       | Optional\<T> |                        |
| forEach   | 对所有元素执行特定的操作           | void         | Cosumer\<T>            |
| collect   | 使用收集器                         | R            | Collector<T, A, R>     |
| reduce    | 执行归约操作                       | Optional\<T> | BinaryOperator\<T>     |
| count     | 计算流中元素的数量                 | long         |                        |

> 注：上表中返回类型为 Stream\<T> 的操作都是中间操作，代表还可以继续调用其它方法对流进行处理。返回类型为其它的操作都是终止操作，代表处理过程到此为止。

使用示例如下：

```java
Stream.iterate(0, x -> x + 1)       // 构建流
    .limit(20)                        // 限制元素的个数
    .skip(10)                        // 跳过前10个元素
    .filter(x -> x % 2 == 0)         // 过滤出所有偶数
    .map(x -> "偶数:" + x)            // 对元素执行转换操作
    .forEach(System.out::println);    // 打印出所有元素
```

输出结果如下：

```shell
偶数:10
偶数:12
偶数:14
偶数:16
偶数:18
```

 上表的 `flatMap()` 方法接收一个参数，该参数是一个函数型接口 `Function<? super T, ? extends Stream<? extends R>> mapper`，主要用于将流中的元素转换为 `Stream` ，从而可以将原有的元素进行扁平化，示例如下：

```java
String[] strings = {"hello", "world"};

Arrays.stream(strings)
    .map(x -> x.split(""))              // 拆分得到: ['h','e','l','l','o'],['w','o','r','l','d']
    .flatMap(x -> Arrays.stream(x))  // 将每个数组进行扁平化处理得到：'h','e','l','l','o','w','o','r','l','d'
    .forEach(System.out::println);
```

而上表的 `reduce()` 方法则接收两个参数：第一个参数表示执行归约操作的初始值；第二个参数是上文我们介绍过的函数式接口 `BinaryOperator<T>` ，使用示例如下：

```java
Stream.iterate(0, x -> x + 1).limit(10)
    .reduce(0, (a, b) -> a + b); //进行求和操作
```

### 4.2 数值流

上面的代码等效于对 Stream 中的所有元素执行了求和操作，因此我们还可以调用简便方法 `sum()` 来进行实现，但是需要注意的是 `Stream.iterate()` 生成流中的元素类型都是包装类型：

```java
Stream<Integer> stream = Stream.iterate(0, x -> x + 1); //包装类型Integer
```

而 `sum()` 方法则是定义在 IntStream 上，此时需要将流转换为具体的数值流，对应的方法是 `mapToInt()`：

````java
Stream.iterate(0, x -> x + 1).limit(10).mapToInt(x -> x).sum();
````

类似的方法还有 `mapToLong()` 和 `mapToDouble()` 。如果你想要将数值流转换为原有的流，相当于对其中的元素进行装箱操作，此时可以调用 `boxed()` 方法：

```java
IntStream intStream = Stream.iterate(0, x -> x + 1).limit(10).mapToInt(x -> x);
Stream<Integer> boxed = intStream.boxed();
```



## 五、收集器

Stream 中最强大一个终止操作是 `collect()` ，它接收一个收集器 Collector 作为参数，可以将流中的元素收集到集合中，或进行分组、分区等操作。Java 中内置了多种收集器的实现，可以通过 Collectors 类的静态方法进行调用，常用的收集器如下：

| 工厂方法          | 返回类型              | 用于                                                         |
| ----------------- | --------------------- | ------------------------------------------------------------ |
| toList            | List\<T>              | 把流中所有元素收集到 List 中                                 |
| toSet             | Set\<T>               | 把流中所有元素收集到 Set 中                                  |
| toCollection      | Collection\<T>        | 把流中所有元素收集到指定的集合中                             |
| counting          | Long                  | 计算流中所有元素的个数                                       |
| summingInt        | Integer               | 将流中所有元素转换为整数，并计算其总和                       |
| averagingInt      | Double                | 将流中所有元素转换为整数，并计算其平均值                     |
| summarizingInt    | IntSummaryStatistics  | 将流中所有元素转换为整数，并返回统计结果，包含最大值、最小值、<br/>总和与平均值等信息 |
| joining           | String                | 将流中所有元素转换为字符串，并使用给定连接符进行连接         |
| maxBy             | Optional\<T>          | 查找流中最大元素的 Optional                                  |
| minBy             | Optional\<T>          | 查找流中最小元素的 Optional                                  |
| reducing          | 规约操作产生的类型    | 对流中所有元素执行归约操作                                   |
| collectingAndThen | 转换返回的类型        | 先把流中所有元素收集到指定的集合中，再对集合执行特定的操作   |
| groupingBy        | Map<K,List\<T>>       | 对流中所有元素执行分组操作                                   |
| partitionBy       | Map<Boolean,List\<T>> | 对流中所有元素执行分区操作                                   |

使用示例如下：

```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 4, 5, 6); 

stream.collect(Collectors.toSet());  // [1, 2, 3, 4, 5, 6]
stream.collect(Collectors.toList()); // [1, 2, 3, 4, 4, 5, 6]
stream.collect(Collectors.toCollection(ArrayList::new)); // [1, 2, 3, 4, 4, 5, 6]
stream.collect(Collectors.counting()); // 7 等效于 stream.count();
stream.collect(Collectors.summarizingInt(x -> x)); // IntSummaryStatistics{count=7, sum=25, min=1, average=3.571429, max=6}
stream.collect(Collectors.maxBy((Integer::compareTo))); // Optional[6]
stream.collect(Collectors.reducing(1, (a, b) -> a * b)); // 等效于 stream.reduce(1, (a, b) -> a * b);
collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size)); // 先把所有元素收集到Set中，再计算Set的大小
```

> 注意：以上每个终止操作只能单独演示，因为对一个流只能执行一次终止操作。并且执行完终止操作后，就不能再对这个流进行任何操作，否则将抛出 `java.lang.IllegalStateException: stream has already been operated upon or closed` 的异常。

### 5.2 分组

分组收集器可以实现类似数据库 groupBy 子句的功能。假设存在如下员工信息：

```java
Stream<Employee> stream = Stream.of(new Employee("张某", "男", "A公司", 20),
    new Employee("李某", "女", "A公司", 30),
    new Employee("王某", "男", "B公司", 40),
    new Employee("田某", "女", "B公司", 50));
```

```java
public class Employee {
    
    private String name;
    private String gender;
    private String company;
    private int age;
    
    @Override
    public String toString() {return "Employee{" + "name='" + name + '\'' + '}';
    }
}
```

此时如果需要按照公司进行分组，则可以使用 `groupingBy()` 收集器： 

```java
stream.collect(Collectors.groupingBy(Employee::getCompany));

对应的分组结果如下：
{ 
   B公司=[Employee{name='王某'}, Employee{name='田某'}], 
   A公司=[Employee{name='张某'}, Employee{name='李某'}]
}
```

如果想要计算分组后每家公司的人数，还可以为 `groupingBy()` 传递一个收集器 Collector 作为其第二个参数，调用其重载方法：

```java
stream.collect(Collectors.groupingBy(Employee::getCompany, Collectors.counting()));

对应的结果如下：
{
  B公司=2, 
  A公司=2
}    
```

因为第二个参数是一个 Collector，这意味着你可以再传入一个分组收集器来完成多级分组，示例如下：

```java
stream.collect(Collectors.groupingBy(Employee::getCompany, Collectors.groupingBy(Employee::getGender)));

先按照公司分组，再按照性别分组，结果如下：
{ 
   B公司={女=[Employee{name='田某'}], 男=[Employee{name='王某'}]}, 
   A公司={女=[Employee{name='李某'}], 男=[Employee{name='张某'}]}
}
```

除此之外，也可以通过代码块来自定义分组条件，示例如下：

```java
Map<String, List<Employee>> collect = stream.collect(Collectors.groupingBy(employee -> {
    if (employee.getAge() <= 30) {
        return "青年员工";
    } else if (employee.getAge() < 50) {
        return "中年员工";
    } else {
        return "老年员工";
    }
}));

对应的分组结果如下：
{ 
  中年员工=[Employee{name='王某'}], 
  青年员工=[Employee{name='张某'}, Employee{name='李某'}], 
  老年员工=[Employee{name='田某'}]
}    
```

### 5.3 分区

分区是分组的一种特殊情况，即将满足指定条件的元素分为一组，将不满足指定条件的元素分为另一组，两者在使用上基本类似，示例如下：

```java
stream.collect(Collectors.partitioningBy(x -> "A公司".equals(x.getCompany())));

对应的分区结果如下：
{
  false=[Employee{name='王某'}, Employee{name='田某'}], 
  true=[Employee{name='张某'}, Employee{name='李某'}]
}    
```



## 六、并行流

想要将普通流转换为并行流非常简单，只需要调用 Stream 的 `parallel()` 方法即可：

```java
stream.parallel();
```

此时流中的所有元素会被均匀的分配到多个线程上进行处理。并行流内部使用的是 ForkJoinPool 线程池，它默认的线程数量就是处理器数量，可以通过 `Runtime.getRuntime().availableProcessors()` 来查看该值，通常不需要更改。

当前也没有办法为某个具体的流指定线程数量，只能通过修改系统属性 `java.util.concurrent.ForkJoinPool.common.parallelism` 的值来改变所有并行流使用的线程数量，示例如下：

```java
System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12"); 
```

如果想将并行流改回普通的串行流，则只需要调用 Stream 的 `sequential()` 方法即可：

```she
stream.sequential();
```





## 参考资料

 厄马(Raoul-Gabriel Urma) / 弗斯科(Mario Fusco) / 米克罗夫特(Alan Mycroft) .**《Java 8实战》**. 人民邮电出版社 . 2016-04-01