# 《Java 8 实战》读书笔记
## 目录<br/>
<a href="#第二部分-函数式数据处理">第二部分 函数式数据处理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第4章-引入流">第4章 引入流</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1流的基本使用">1.流的基本使用</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2数值流">2.数值流</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3构建流">3.构建流</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第5章-使用流">第5章 使用流</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1中间操作和基本操作">1.中间操作和基本操作</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2flatMap的使用">2.flatMap的使用</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3归约">3.归约</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第6章-用流收集数据">第6章 用流收集数据</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1预定义收集器">1.预定义收集器</a><br/>
<a href="#第三部分-高效的Java-8编程">第三部分 高效的Java 8编程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#第12章-新的日期和时间API">第12章 新的日期和时间API</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#121-LocalDate、LocalTime、Instant、Duration、period">12.1 LocalDate、LocalTime、Instant、Duration、period</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1使用-LocalDate-和-LocalTime">1.使用 LocalDate 和 LocalTime</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2使用LocalDateTime">2.使用LocalDateTime</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3时间间隔-Duration-或-Period">3.时间间隔 Duration 或 Period</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#122-操纵、解析和格式化日期">12.2 操纵、解析和格式化日期</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1操纵日期加减">1.操纵日期加减</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2使用TemporalAdjusters">2.使用TemporalAdjusters</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3日期格式解析">3.日期格式解析</a><br/>
## 正文<br/>






## 第二部分 函数式数据处理

### 第4章 引入流

#### 1.流的基本使用

```java
// 基础数据类
public class Data {

    public enum Type {MEAT, FISH, OTHER}

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH));

    static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Data.Type type;

        public Dish(String name, boolean vegetarian, int calories, Data.Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Data.Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return name;
        }

    }
}

```

```java
// 流的使用
public class Stream {

    public static void main(String[] args) {
        List<String> collect = Data.menu.stream().filter(d -> d.getCalories() > 	300).map(Data.Dish::getName).limit(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
```

#### 2.数值流

**映射到数值流(mapToInt)**

```java
public class Stream {

    public static void main(String[] args) {

        //得到的是 Stream<Integer>
        java.util.stream.Stream<Integer> integerStream = Data.menu.stream().map(Data.Dish::getCalories);
        Integer reduce = integerStream.reduce(0, Integer::sum);
        System.out.println(reduce); //4200

        //得到的是 IntStream
        IntStream intStream = Data.menu.stream().mapToInt(Data.Dish::getCalories);
        int sum = intStream.sum();
        System.out.println(sum);    //4200
    }
}
```

**数值流到映射(boxed)**

```java
public class Stream {

    public static void main(String[] args) {

        //得到的是 Stream<Integer>
        java.util.stream.Stream<Integer> integerStream = Data.menu.stream().map(Data.Dish::getCalories);
        Integer reduce = integerStream.reduce(0, Integer::sum);
        System.out.println(reduce); //4200

        //得到的是 IntStream
        IntStream intStream = Data.menu.stream().mapToInt(Data.Dish::getCalories);
        java.util.stream.Stream<Integer> boxed = intStream.boxed();
        Integer reduceSum = boxed.reduce(0, Integer::sum);
        System.out.println(reduceSum);    //4200
    }
}
```

```java
// 收集器对流的消耗
public class Stream {

    public static void main(String[] args) {

        //得到的是 Stream<Integer>
        java.util.stream.Stream<Integer> integerStream = Data.menu.stream().map(Data.Dish::getCalories);
        Integer reduce = integerStream.reduce(0, Integer::sum);
        System.out.println(reduce); //4200

        //得到的是 IntStream
        IntStream intStream = Data.menu.stream().mapToInt(Data.Dish::getCalories);
        int sum = intStream.sum();
        // 下面这行报错:IllegalStateException: stream has already been operated upon or closed
        // 因为sum() 是一个终止流方法，会消耗掉流，所以调用 intStream.boxed() 方法时候会报错
        java.util.stream.Stream<Integer> boxed = intStream.boxed();
        Integer reduceSum = boxed.reduce(0, Integer::sum);
        System.out.println(sum);          //4200
        System.out.println(reduceSum);    //4200
    }
```

#### 3.构建流

**1.由值创建流**

```java
public class StreamCreate {

    public static void main(String[] args) {

        // 由值创建流
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // 创建空流 
        Stream<Object> empty = Stream.empty();
    }
}
```

**2.由数组创建流**

```java
public class StreamCreate {

    public static void main(String[] args) {

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);  //41
    }
}
```

**3.由文件创建流**

```java
public class StreamCreate {

    public static void main(String[] args) {
        
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            Set<String> collect = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .collect(Collectors.toSet());
            collect.forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**4.由函数生成流**

Stream API提供了两个静态方法来从函数生成流： **Stream.iterate**和**Stream.generate**。这两个操作可以创建所谓的无限流：不像从固定集合创建的流那样有固定大小的流。由iterate和generate产生的流会用给定的函数按需创建值，因此可以无穷无尽地计算下去！一般来说，应该使用limit(n)来对这种流加以限制，以避免打印无穷多个值。 

- **iterate**方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator\<T>类型）。 
- **generate**方法也可让你按需生成一个无限流。但generate不是依次对每个新生成的值应用函数的。它接受一个Supplier\<T>类型的Lambda提供新的值。 

```java
public class StreamCreate {

    public static void main(String[] args) {

        // 迭代
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
```

### 第5章 使用流

你可以把Java 8的流看作花哨又懒惰的数据集迭代器。它们支持两种类型的操作：中间操作和终端操作。中间操作可以链接起来，**将一个流转换为另一个流**。这些操作不会消耗流，其目的是建立一个流水线。与此相反，**终端操作会消耗流**，以产生一个最终结果，例如返回流中的最大元素。 

#### 1.中间操作和基本操作

**表5-1 中间操作和终端操作** 

| 操作      | 类型              | 返回类型     | 使用的类型/函数式接口  | 函数描述符      |
| --------- | ----------------- | ------------ | ---------------------- | --------------- |
| filter    | 中间              | Stream<T>    | Predicate\<T>          | T -> boolean    |
| distinct  | 中间(有状态-无界) | Stream<T>    |                        |                 |
| skin      | 中间(有状态-有界) | Stream<T>    | long                   |                 |
| limit     | 中间(有状态-有界) | Stream<T>    | long                   |                 |
| map       | 中间              | Stream<T>    | Function<T,R>          | T -> R          |
| flatMap   | 中间              | Stream<T>    | Function<T,Stream\<R>> | T -> Stream\<R> |
| sorted    | 中间(有状态-无界) | Stream<T>    | Comparator\<T>         | (T , T) -> int  |
| anyMatch  | 终端              | boolean      | Predicate\<T>          | T -> boolean    |
| noneMatch | 终端              | boolean      | Predicate\<T>          | T -> boolean    |
| allMatch  | 终端              | boolean      | Predicate\<T>          | T -> boolean    |
| findAny   | 终端              | Optional\<T> |                        |                 |
| findFirst | 终端              | Optional\<T> |                        |                 |
| forEach   | 终端              | void         | Cosumer\<T>            | T -> void       |
| collect   | 终端              | R            | collector<T, A, R>     |                 |
| reduce    | 终端              | Optional\<T> | BinaryOperator\<T>     | (T , T) -> T    |
| count     | 终端              | long         |                        |                 |

#### 2.flatMap的使用

给 定 单 词 列 表["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]。 

**Arrays.stream()的方法可以接受一个数组并产生一个流 。**

```java
public class Stream {

    public static void main(String[] args) {
        String[] strings = {"Hello", "World"};
        
        // 如下图 5.5
        List<String[]> list01 = Arrays.stream(strings)
                .map(s -> s.split(""))
                .distinct().collect(Collectors.toList());

        // 使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。 如下图5.6
        List<String> list02 = Arrays.stream(strings)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());

        //每个单词转换成一个字母数组，然后把每个数组变成了一个独立的流。
        List<java.util.stream.Stream<String>> list03 = Arrays.stream(strings)
                .map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct().collect(Collectors.toList());

        list01.forEach(System.out::println);
        list02.forEach(System.out::println);
        list03.forEach(System.out::println);
    }
}
```

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/flatmap1.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/flatmap2.png"/> </div></br>

#### 3.归约

```java
public class Stream {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}
```

### 第6章 用流收集数据

#### 1.预定义收集器

预定义收集器主要指 Collectors类提供的工厂方法（例如groupingBy）创建的收集器。它们主要提供了三大功能：

- 将流元素归约和汇总为一个值
- 元素分组
- 元素分区 

**表6.1 Collectors 类的静态工厂方法**

| 工厂方法          | 返回类型              | 用于                                                         |
| ----------------- | --------------------- | ------------------------------------------------------------ |
| toList            | List\<T>              | 把流中所有项目收集到一个List                                 |
| toSet             | Set\<T>               | 把流中所有项目收集到一个Set,删除重复项                       |
| toCollection      | Collection\<T>        | 把流中所有项目收集到给定的供应源创建的集合                   |
| counting          | Long                  | 计算流中元素的个数                                           |
| summingInt        | Integer               | 对流中项目的一个整数属性求和                                 |
| averagingInt      | Double                | 计算流中项目Integer属性的平均值                              |
| summarizingInt    | IntSummaryStatistics  | 收集关于流中项目Integer属性的统计值，例如最大、最小、总和与平均值 |
| joining           | String                | 连接对流中每个项目调用toString方法所生成的字符串             |
| maxBy             | Optional\<T>          | 查找最大元素的Optional,或如果流为空则为Optional.empty()      |
| minBy             | Optional\<T>          | 查找最小元素的Optional,或如果流为空则为Optional.empty()      |
| reducing          | 规约操作产生的类型    | 从一个作为累加器的初始值开启，利用BinaryOperator与流中的元素逐个结合，从而将流归约为单个值 |
| collectingAndThen | 转换返回返回的类型    | 包裹另一个收集器，对其结果应用转换函数                       |
| groupingBy        | Map<K,List\<T>>       | 根据项目的一个属性的值对流中项目作分组，并将其属性值作为结果Map的键 |
| partitionBy       | Map<Boolean,List\<T>> | 根据对流中每个项目应用谓词的结果来对项目进行区分             |

```java
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class Stream {

    public static void main(String[] args) {
        
        // toList
        List<Data.Dish> dishList = Data.menu.stream().collect(toList());

        // toSet
        Set<Data.Dish> dishSet = Data.menu.stream().collect(Collectors.toSet());
        
        // toCollection
        ArrayList<Data.Dish> arrayList = Data.menu.stream()
                .collect(Collectors.toCollection(ArrayList::new));

        // counting
        long count = Data.menu.stream().count();
        // summingInt 可以用中间操作等价
        Integer sum01 = Data.menu.stream()
                .collect(Collectors.summingInt(Data.Dish::getCalories));
        Integer sum02 = Data.menu.stream()
                .mapToInt(Data.Dish::getCalories).sum();

        // averagingInt
        Double average = Data.menu.stream()
                .collect(Collectors.averagingInt(Data.Dish::getCalories));

        // summarizingInt
        IntSummaryStatistics statistics = Data.menu.stream()
                .collect(Collectors.summarizingInt(Data.Dish::getCalories));
        statistics.getAverage();
        statistics.getMax();

        // joining
        String joining = Data.menu.stream().map(Data.Dish::getName)
                .collect(Collectors.joining(","));

        // maxBy
        Optional<Data.Dish> max = Data.menu.stream()
                .max(Comparator.comparingInt(Data.Dish::getCalories));

        // minBy
        Optional<Data.Dish> min = Data.menu.stream()
                .min(Comparator.comparingInt(Data.Dish::getCalories));

        // reducing
        Integer reduce01 = Data.menu.stream().map(Data.Dish::getCalories)
                .reduce(0, Integer::sum);
        Integer reduce02 = Data.menu.stream().map(Data.Dish::getCalories)
                .reduce(0, Integer::sum);

        // collectingAndThen
        Integer size = Data.menu.stream().collect(collectingAndThen(toList(), List::size));

        // groupingBy
        Map<Data.Type, List<Data.Dish>> typeListMap = Data.menu.stream()
                .collect(groupingBy(Data.Dish::getType));

        // partitionBy
        Map<Boolean, List<Data.Dish>> booleanListMap = Data.menu.stream()
                .collect(partitioningBy(Data.Dish::isVegetarian));
    }
}
```

## 第三部分 高效的Java 8编程

### 第12章 新的日期和时间API

#### 12.1 LocalDate、LocalTime、Instant、Duration、period

##### 1.使用 LocalDate 和 LocalTime

```java
public class NewDateApi {

    public static void main(String[] args) {

        // 创建日期
        LocalDate date = LocalDate.of(2018, 10, 8);
        int year = date.getYear();              // 2018
        Month month = date.getMonth();          // OCTOBER
        int value = month.getValue();           // 10
        int dayOfMonth = date.getDayOfMonth();  // 8
        int i = date.lengthOfMonth();           // 31

        // 获取当前日期
        LocalDate now = LocalDate.now();

        //创建时间
        LocalTime time = LocalTime.of(12, 13, 32);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        // 通过解析创建日期和时间
        // the text to parse such as "2007-12-03", not null
        LocalDate localDate = LocalDate.parse("2019-03-12");
        // the text to parse such as "10:15:30", not null
        LocalTime localTime = LocalTime.parse("12:21:45");
    }
}
```

##### 2.使用LocalDateTime

```java
public class NewDateApi {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        LocalTime time = LocalTime.of(13, 45, 20);

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);

        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate localDate = dt1.toLocalDate();
        LocalTime localTime = dt1.toLocalTime();

        boolean equal = dt1.isEqual(dt2);        // true
        boolean equals = date.equals(localDate); // true

    }
}
```

##### 3.时间间隔 Duration 或 Period

```java
// 计算时间间隔
public class NewDateApi {

    public static void main(String[] args) {

        LocalDate date01 = LocalDate.of(2014, Month.MARCH, 18);
        LocalDate date02 = LocalDate.of(2012, Month.MARCH, 23);
        LocalTime time01 = LocalTime.of(13, 45, 20);
        LocalTime time02 = LocalTime.of(13, 12, 35);

        // 计算日期间隔
        Period between01 = Period.between(date01, date02);

        // 计算时间间隔
        Duration between02 = Duration.between(time01, time02);

        // 间隔时间可能为正值 也可能为负值 可以用 isNegative 判断
        System.out.println(between01.getDays());
        System.out.println(between01.getYears());
        System.out.println(between02.getSeconds());

    }
}
```

```java
// 创建时间间隔
public class NewDateApi {

    public static void main(String[] args) {

        // 创建 Duration 和 Period 对象
        Duration duration = Duration.ofMinutes(3);
        Duration duration1 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

    }
}
```

#### 12.2 操纵、解析和格式化日期

##### 1.操纵日期加减

```java
public class NewDateApi {

    public static void main(String[] args) {

        // 以直接修改方式操作 LocalDate
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        // 以相对的方式操作 LocalDate
        LocalDate date5 = date1.plusWeeks(1);
        LocalDate date6 = date1.minusYears(3);
        LocalDate date7 = date1.plus(6, ChronoUnit.MONTHS);


        // 操作 LocalDate 
        LocalTime time = LocalTime.of(12, 3, 18);
        LocalTime time1 = time.withHour(3);
        LocalTime time2 = time.plus(3, ChronoUnit.HOURS);
        System.out.println(time2.getHour());

    }
}
```

##### 2.使用TemporalAdjusters

```java
import java.time.*;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class NewDateApi {

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());

    }
}
```

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/TemporalAdjuster类中的工厂方法.png"/> </div></br>



##### 3.日期格式解析

```java
public class NewDateApi {

    public static void main(String[] args) {

        // 使用内置格式解析
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); //2014-03-18


        // 使用自定义格式解析
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);

    }
}
```

