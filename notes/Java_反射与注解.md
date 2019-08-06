# Java 反射

## 一、Class 类

### 1.1 Class 对象

在 Java 中，每个已加载的类在内存中都有一份类信息，类信息对应的类是 java.lang.Class，每个对象都持有指向它所属类信息的引用。所以想要获取 Class 对象，有以下三种方法：

+ 通过类名获取：

```java
Class<Date> dateClass = Date.class;
Class<Integer> integerClass = int.class;
```

+ 通过对象的`getClass()`方法获取：

```java
Date date = new Date();
Class<? extends Date> aClass = date.getClass();
```

+ 通过 Class 类的静态方法 `forName` 获取：

```java
Class<?> aClass = Class.forName("java.util.Date");
```

### 1.2 名称信息

Class 提供了如下三个方法，由于获取名称信息，其作用和输出分别如下：

- **getName**：返回 Java 内部使用的名称；
- **getSimpleName**：返回简称；
- **getCanonicalName**：返回由 Java 语言规范定义的命名。

| Class 对象      | getName             | getSimpleName | getCanonicalName    |
| --------------- | ------------------- | ------------- | ------------------- |
| int.class       | int                 | int           | int                 |
| int[].class     | [I                  | int[]         | int[]               |
| int\[][].class  | [[I                 | int\[][]      | int\[][]            |
| String.class    | java.lang.String    | String        | java.lang.String    |
| String[].class  | [Ljava.lang.String; | String[]      | java.lang.String[]  |
| ArrayList.class | java.util.ArrayList | ArrayList     | java.util.ArrayList |

对于数组类型的getName返回值，使用前缀`[`表示数组，有几个`[`表示是几维数组，数组类型使用字符表示：boolean（Z）、byte（B）、char（C）、double（D）、float（F）、int（I）、long（J）、short（S）、接口和类（L）。

### 1.3 构造器

Class 有以下四个获取构造器信息的方法：

```java
//឴ 获取所有的public构造器
public Constructor<?>[] getConstructors()
//឴ 获取所有构造器
public Constructor<?>[] getDeclaredConstructors()
//឴ 获取指定参数的public构造器
public Constructor<T> getConstructor(Class<?>... parameterTypes)
// 获取指定参数的构造器឴
public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
```

获取指定的构造器后，可以使用`newInstance`方法来创建其实例，实例如下：

```java
class Test {

    static class Student {
        private String name;
        private int age;

        Student() {}

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';}
    }

    public static void main(String[] args) throws Exception {
        Constructor<? extends Student> constructor = Student.class.getDeclaredConstructor(String.class, int.class);
        Student student = constructor.newInstance("heibaiying", 10);
        System.out.println(student);
    }
}

输出：Student{name='heibaiying', age=10}
```

如果你只是想调用默认的无参构造器，则可以直接使用 Class 对象的`newInstance`方法：

```java
Student student = Student.class.newInstance();
```


### 1.4 字段信息

Class 有以下四个获取字段信息的方法：

```java
// 返回本类或其父类的所有public字段
public Field[] getFields()
// 返回本类声明的所有字段，但不包括父类的
public Field[] getDeclaredFields()
// 返回本类或其父类中指定名称的public字段
public Field getField(String name)
// 返回本类声明的指定名称的字段
public Field getDeclaredField(String name)
```

字段信息被封装在 Field 类中，Field 对象有以下常用方法：

```java
// 获取字段的名称
public String getName()
// 判断是否有该字段的访问权限
public boolean isAccessible()
// 设置为true表示忽略Java的访问检查机制，从而可以读写非public的字段
public void setAccessible(boolean flag)
// 获取指定对象obj中该字段的值
public Object get(Object obj)
// 将指定对象obj中该字段的值设为value
public void set(Object obj, Object value)
```

以下给出一个修改字段的使用示例：

```java
class Test {

    static class Student {
        private String name;
        private int age;
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        Field field = aClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student, "heibaiying");
        System.out.println(field.get(student)); 
    }
}
输出： heibaiying
```

### 1.5 方法信息

Class 有以下四个获取方法信息的方法：

```java
// 返回本类或其父类的所有public方法
public Method[] getMethods() 
// 返回本类声明的所有方法，但不包括父类的
public Method[] getDeclaredMethods() 
// 返回本类或其父类中指定名称及其参数类型的public方法
public Method getMethod(String name, Class<?>... parameterTypes)
// 返回本类声明的指定名称及其参数类型的方法
public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
```

方法信息被封装在 Method 类中，Method 对象有以下常用方法：

```java
// 获取方法的名称
public String getName()
// 设置为true表示忽略Java的访问检查机制，从而可以调用非public方法    
public void setAccessible(boolean flag)
// 在指定的obj对象上调用invoke方法，args为传递的参数列表    
public Object invoke(Object obj, Object... args)
```

基本使用示例如下：

```java
class Test {

    static class Student {
        private String name;
        public void setName(String name) {this.name = name;}
        public String getName() { return name;}
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        Method setMethod = aClass.getDeclaredMethod("setName",String.class);
        setMethod.invoke(student, "heibaiying");
        Method geMethod = aClass.getDeclaredMethod("getName");
        System.out.println(geMethod.invoke(student));
    }
}
输出： heibaiying
```

### 1.6  类型检查

想要判断某个对象是否是某个类或其子类的示例，可以使用`instanceof`关键字，或者使用 Class 的 `isInstance`方法，示例如下：

```java
static class Manager {}

static class Employee extends Manager {}

public static void main(String[] args) {
    Employee employee = new Employee();
    System.out.println(employee instanceof Manager);  // true
    System.out.println(employee instanceof Employee); // true

    System.out.println(Manager.class.isInstance(employee));  // true
    System.out.println(Employee.class.isInstance(employee)); // true

}
```

如果想要判断对象的具体类型，则可以使用`equals`方法进行比较，示例如下：

```java
employee.getClass().equals(Manager.class); // false
employee.getClass().equals(Employee.class); // true
```

在知道对象的类型后，如果你需要对其进行类型转换，则可以使用类型转换语法或者 Class 的`cast`方法：

```java
Manager manager01 = Manager.class.cast(employee);
Manager manager02 = (Manager) employee;
```



## 二、注解

### 2.1 注解定义

下面是`@Override`注解的定义，所有注解均使用`@interface`关键字修饰，`@Target`定义注解的运用对象，`@Retention`表示注解信息保留到什么时候。

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

`@Target`有以下可选值，其含义分别如下：

- **TYPE**：表示类、接口（包括注释类型）或枚举声明
- **FIELD**：字段声明（包括枚举常量）
- **METHOD**：方法声明
- **PARAMETER**：参数声明
- **CONSTRUCTOR**：构造器声明
- **LOCAL_VARIABLE**：本地变量声明
- **ANNOTATION_TYPE**：注解声明
- **PACKAGE**：包声明
- **TYPE_PARAMETER**：类型参数声明
- **TYPE_USE**：任何使用类型的语句

`@Retention`有以下可选值，其含义分别如下：

- **SOURCE**：只在源代码中保留，编译器将代码编译为字节码后就会丢掉。

- **CLASS**：保留在字节码文件中，但虚拟机将 class 文件加载到内存时不一定会在内存中保留，这是默认的行为。

- **RUNTIME**：一直保留到运行时，可以通过反射获取其信息。

### 2.2 注解信息

对于`@Retention`类型为`RUNTIME`的注解，可以利用反射机制查看其信息。因为注解可以运用在不同目标上，所以 Class 、Field、Method、Constructor 都有如下方法：

```
// 获取所有注解
public Annotation[] getAnnotations()
public Annotation[] getDeclaredAnnotations()
public <T extends Annotation> T getAnnotation(Class<T> annotationClass) 
public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) 
```

这里给出一个使用示例，模仿常用的序列化框架，通过注解定义字段的序列化名称和序列化格式，注解定义如下：

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Json {
    String value();
    String format() default "";
}
```



```java
class Test {

    static class Student {
        /*当只有一个值并且其对应的方法名为value时候，可以省略 value =  */
        @Json("姓名")
        private String name;
        @Json(value = "出生日期", format = "yyyy-MM-dd HH:mm:ss")
        private Date birthday;
        ......
    }

    static void parse(Object object, Class<?> clazz) throws IllegalAccessException {

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Json.class)) {
                field.setAccessible(true);
                Object value = field.get(object);
                Json json = field.getAnnotation(Json.class);
                String name = json.value();
                String format = json.format();
                if (!"".equals(format) && field.getType() == Date.class) {
                    SimpleDateFormat formatter = new SimpleDateFormat(format);
                    value = formatter.format((Date) value);
                }
                System.out.println(name + ":" + value);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("heibai", new Date());
        parse(student, Student.class);
    }
}

输出如下： 
姓名:heibai
出生日期:2019-07-06 08:45:47
```

### 2.3 注解继承

一个常用的元注解是`@Inherited`，它表示某个注解是否能够被继承。示例如下：

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ClassName {
    String value();
}
```

使用示例如下：此时如果加上`@Inherited`注解，则两者的输出都是 true；如果不加上`@Inherited`，第二行语句输出 false，代表子类 PrimaryStudent 没有继承到` @ClassName`注解。

```java
class Test {

    @ClassName("学生类")
    static class Student {}

    static class PrimaryStudent extends Student {}

    public static void main(String[] args) {
        System.out.println(Student.class.isAnnotationPresent(ClassName.class));
        System.out.println(PrimaryStudent.class.isAnnotationPresent(ClassName.class));
    }
}
```



