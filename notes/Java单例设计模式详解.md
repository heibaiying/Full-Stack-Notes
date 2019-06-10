# Java 单例设计模式详解

参考自慕课网课程：[Java设计模式精讲](https://coding.imooc.com/class/270.html):star::star::star::star::star:

#### 1、单例模式的饿汉模式（线程安全）

缺点：在类初始化时候就会初始化对应的单例类，如果单例类没有被用到且单例类初始化复杂，就不应用这种模式

```java
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton;

    private HungrySingleton(){
        // 如果不加上这个判断，就会被反射攻击
        if (hungrySingleton!=null){
            throw new RuntimeException("单例模式禁止反射调用！");
        }
    }

    static {
        hungrySingleton=new HungrySingleton();
    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
```

```java
// 反射攻击
public class ReflectAttack {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 反射攻击
        Class<HungrySingleton> hungrySingletonClass = HungrySingleton.class;
        Constructor<HungrySingleton> constructor = hungrySingletonClass.getDeclaredConstructor();
        // 获取可操作权限
        constructor.setAccessible(true);
        HungrySingleton hungrySingleton = constructor.newInstance();
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(hungrySingleton==instance);
    }
}
```



#### 2.单例模式的懒汉模式（线程不安全）

```java
public class LazySingleton {

    private static LazySingleton lazySingleton=null;

    private LazySingleton(){
        if (lazySingleton!=null){
            throw new RuntimeException("单例模式禁止反射调用！");
        }
    }

    // 在多线程下是不安全的
    public static LazySingleton getInstance(){
        if (lazySingleton!=null){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }
}
```



#### 3.单例模式的懒汉模式（采用双重检查锁，线程安全）

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
                if (lazySingleton == null) {
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



#### 4.使用枚举实现单例（推荐 JVM保证下的单例）

**能够防止反射攻击和序列化对单例的破坏**

```java
// 枚举单例模式
public enum EnumInstance {

    INSTANCE;

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
```

```java
// 测试
public class Test {
    
    public static void main(String[] args) {
        EnumInstance instance0 = EnumInstance.INSTANCE;
        EnumInstance instance1 = EnumInstance.getInstance();
        EnumInstance instance2 = EnumInstance.getInstance();
        System.out.println(instance0 == instance1);  // true
        System.out.println(instance0 == instance2);  // true
        System.out.println(instance1 == instance2);  // true
    }
}

```

```java
public enum EnumInstance {

    INSTANCE;

    private String data;

    // 可以增加对应的方法
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
```



#### 5.容器式单例（不常用）

```java
public class ContainerSingleton {

    private ContainerSingleton(){
    }
    
    private static Map<String,Object> singletonMap = new HashMap<String,Object>();

    public static void putInstance(String key,Object instance){
        if(StringUtils.isNotBlank(key) && instance != null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }


}

```

