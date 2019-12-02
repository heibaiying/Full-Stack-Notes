# 设计模式

## 软件设计的原则

### 1. 开闭原则

定义：软件实体应当对扩展开放，对修改关闭。

### 2. 里氏替换原则

定义：继承必须保证确保超类所拥有的性质在子类中仍然成立。即子类在继承父类时，除了添加新的方法来新增功能外，尽量避免重写父类方法，因为这会导致整个继承体系的复用性变差。

### 3. 依赖倒置原则

定义：高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象。其核心思想是要面向接口编程，而不是面向实现编程，这样可以降低耦合性，提高系统稳定性，提高代码的可读性和可维护性。

### 4. 单一职责原则

定义：一个类应该有且仅有一个引起它变化的原则，否则类应该被拆分。其核心思想是控制类的粒度大小、提高类的内聚性。

### 5. 接口隔离原则

定义：一个类对另一个类的依赖应该建立在最小的接口上。其核心思想是要为每个特定的功能建立对应的接口，而不是在一个接口中试图去包含所有功能，既要保证相对独立，也要避免过多接口所导致的臃肿。

### 6. 迪米特法则 (最少知道原则)

定义：如果两个软件实体不需要直接通讯，那么就应该避免直接互相调用，而是通过第三方转发该调用，从而降低耦合度，保证模块的相对独立。

### 7. 合成复用原则 (组合复用原则)

定义：应该优先使用组合、聚合等关联关系来实现复用，其次才是考虑使用继承关系。

**总结**：开闭原则是总纲，它告诉我们要对扩展开放，对修改关闭；里氏替换原则告诉我们不要破坏继承体系；依赖倒置原则告诉我们要面向接口编程；单一职责原则告诉我们实现类要职责单一；接口隔离原则告诉我们在设计接口的时候要精简单一；迪米特法则告诉我们要降低耦合度；合成复用原则告诉我们要优先使用组合或者聚合关系复用，少用继承关系复用。



# 创建型

## 1. 单例模式

### 1.1  饿汉式单例

饿汉式单例是最简单一种单例模式，它在类初始化时就完成相关单例对象的创建，可以通过静态代码块或静态内部类的方式来进行实现：

静态代码块方式：

```java
public class HungrySingleton implements Serializable {

	private static final HungrySingleton instance;

	static {
		instance = new HungrySingleton();
	}

    // 确保构造器私有
	private HungrySingleton() {}

    // 获取单例对象
	public static HungrySingleton getInstance() {
		return instance;
	}
}
```

静态内部类方式：

```java
public class StaticInnerClassHungrySingleton {

    private static class InnerClass {
        private static StaticInnerClassHungrySingleton instance = new StaticInnerClassHungrySingleton();
    }

    // 确保构造器私有
    private StaticInnerClassHungrySingleton() {}

    // 获取单例对象
    public static StaticInnerClassHungrySingleton getInstance() {
        return InnerClass.instance;
    }

}
```

恶汉式单例的优点在于其不存在线程安全问题，对象的唯一性由虚拟机在类初始化创建时保证；其缺点在于如果对象的创建比较消耗资源，并且单例对象不一定会被使用到，此时就会造成资源的浪费。

### 1.2 懒汉式单例

懒汉式单例的思想在于在需要使用单例对象时才进行创建，如果对象存在则直接返回，如果对象不存在则创建后返回，示例如下：

```java
public class LazySingletonUnsafe {

	private static LazySingletonUnsafe instance = null;

	private LazySingletonUnsafe() {
	}

	public static LazySingletonUnsafe getInstance() {
		if (instance == null) {
			instance = new LazySingletonUnsafe();
		}
		return instance;
	}
}
```

需要注意的是上面的代码在单线程环境下是没有问题的，但是在多线程环境下是线程不安全的，原因在于下面的创建代码是非原子性的：

```java
if (instance == null) {
    instance = new LazySingletonUnsafe();
}
```

想要保证创建操作的原子性，可以通过 synchronized 关键字来进行实现：

```java
public synchronized static LazySingletonUnsafe getInstance() {
		if (instance == null) {
			instance = new LazySingletonUnsafe();
		}
		return instance;
	}
```

此时该方法是线程安全的，但是性能却存在问题。因为 synchronized 修饰的是静态方法，其锁住的是整个类对象，这意味着所有想要获取该单例对象的线程都必须要等待内部锁的释放。假设单例对象已经创建完成，并有 100 个线程并发获取该单例对象，则这 100 个线程都需要等待，显然这会降低系统的吞吐量，因此更好的方式是采用 **双重检查锁的机制** 来实现懒汉式单例：

```java
public class DoubleCheckLazySingletonSafe {

    // 使用volatile来禁止指令重排序 
    private static volatile DoubleCheckLazySingletonSafe instance = null;

    private DoubleCheckLazySingletonSafe() {
    }

    // 双重检查
    public static DoubleCheckLazySingletonSafe getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLazySingletonSafe.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazySingletonSafe();
                }
            }
        }
        return instance;
    }
}
```

还是沿用上面的举例，假设单例对象已经创建完成，并有 100 个线程并发获取该单例对象，此时 `instance == null` 判断肯定是 false，所以所有线程都会直接获得该单例对象，而不会进入 synchronized 同步代码块，这减小了锁的锁定范围，用更小的锁粒度获得了更好的性能。但内部的 `if` 代码块任然需要使用 synchronized 关键字修饰，从而保证整个 if 代码块的原子性。

需要注意的是这里的 instance 需要使用 volatile 关键修饰，用于禁止对象在创建过程中出现指令重排序。通常对象的创建分为以下三步：

1. 给对象分配内存空间；
2. 调用对象的构造器方法，并执行初始化操作；
3. 将变量指向相应的内存地址。

如果没有禁止指令重排序，则 2 ，3 步可能会发生指令重排序，这在单线程下是没有问题的，也符合 As-If-Serial 原则，但是如果在多线程下就会出现线程不安全的问题：

```java
// 2. 由于线程1已经将变量指向内存地址，所以其他线程判断instance不为空，进而直接获取，但instance可能尚未初始化完成
if (instance == null) { 
    synchronized (DoubleCheckLazySingletonSafe.class) {
        if (instance == null) {
            // 1. 假设线程1已经给对象分配了内存空间并将变量instance指向了相应的内存地址，但尚未初始化完成
            instance = new DoubleCheckLazySingletonSafe();
        }
    }
}
return instance;
```

由于重排序的存在，其他线程可能拿到的是一个尚未初始化完成的 instance，此时就可能会导致异常，所以需要禁止其出现指令重排序。

### 1.3  使用序列化破坏单例

饿汉式单例和双重检查锁的懒汉式单例都是线程安全的，都能满足日常的开发需求，但如果你是类库的开发者，为了防止自己类库中的单例在调用时被有意或无意地破坏，你还需要考虑单例模式写法安全。其中序列化和反射攻击是两种常见的破坏单例的方式，示例如下：

```java
public class SerializationDamage {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton instance = HungrySingleton.getInstance();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("SingletonFile"));
        outputStream.writeObject(instance);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("SingletonFile")));
        HungrySingleton newInstance = (HungrySingleton) inputStream.readObject();
        System.out.println(instance == newInstance); // false
    }
}
```

将 HungrySingleton 实现 Serializable 接口后，使用上面的代码将对象序列化写入文件，然后再反序列获取，你会发现两次得到的不是一个对象，这就代表单例模式受到了序列化和反序列化的破坏。想要解决这个问题，需要在对应的单例类中定义 `readResolve()` 方法：

```java
public class HungrySingleton implements Serializable {
    ......
	private Object readResolve() {
		return instance;
	}
    ......
}
```

此时在反序列化时该方法就会被调用来返回对应类的实例，对应的 ObjectInputStream 类的源码如下：

```java
  // 在本用例中，readObject在内部最终调用的是readOrdinaryObject方法
private Object readOrdinaryObject(boolean unshared) throws IOException{
       .......
        if (obj != null && handles.lookupException(passHandle) == null &&
            desc.hasReadResolveMethod()) //如果对应的对象中有readResolve方法
        {
            // 则通过反射调用该方法来获取对应的实例对象
            Object rep = desc.invokeReadResolve(obj);
            ........
           handles.setObject(passHandle, obj = rep);
        }
        return obj;
    }
```

### 1.4 使用反射破坏单例

使用反射也可以破坏单例模式，并且由于 Java 的反射功能过于强大，这种破坏几乎是无法规避的，示例如下：

```java
public class ReflectionDamage {
    public static void main(String[] args) throws Exception {
        Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
        // 获取私有构造器的访问权限
        constructor.setAccessible(true);
        HungrySingleton hungrySingleton = constructor.newInstance();
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(hungrySingleton == instance); // false
    }
}
```

即便在创建单例对象时将构造器声明为私有，此时仍然可以通过反射获取，此时单例模式就被破坏了。如果你采用的是饿汉式单例，此时可以通过如下的代码来规避这种破坏：

```java
public class HungrySingleton implements Serializable {

	private static final HungrySingleton instance;

	static {
		instance = new HungrySingleton();
	}

    // 由于instance在类创建时就已经初始化完成，所以当使用反射调用构造器时就会抛出自定义的RuntimeException异常
	private HungrySingleton() {
		if (instance != null) {
			throw new RuntimeException("单例模式禁止反射调用");
		}
	}

	......
}
```

以上是饿汉式单例防止反射攻击的办法，如果你使用的是懒汉式单例，此时由于无法知道对象何时会被创建，并且反射功能能够获取到任意字段，方法，构造器的访问权限，所以此时没有任何方法能够规避掉反射攻击。

那么有没有一种单例模式能够在保证线程安全，还能够防止序列化和反射功能呢？在 Java 语言中，可以通过枚举式单例来实现。

### 1.5  枚举式单例

使用枚举实现单例的示例如下：

```java
public enum EnumInstance {

	INSTANCE;

	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public static EnumInstance getInstance() {
		return INSTANCE;
	}
}
```

想要实现一个单例枚举，对应的单例类必须要使用 enum 修饰，其余的字段声明（如：field）, 方法声明（如：setField）都和正常的类一样。首先枚举类是线程安全的，这点可以使用反编译工具 Jad 对类的 class 文件进行反编译来验证：

```java
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EnumInstance.java

package com.heibaiying.creational.singleton;

// 不可变的类
public final class EnumInstance extends Enum
{

    public static EnumInstance[] values()
    {
        return (EnumInstance[])$VALUES.clone();
    }

    public static EnumInstance valueOf(String name)
    {
        return (EnumInstance)Enum.valueOf(com/heibaiying/creational/singleton/EnumInstance, name);
    }

    // 私有构造器，枚举类没有无参构造器，Enum中只定义了Enum(String name, int ordinal) 构造器
    private EnumInstance(String s, int i)
    {
        super(s, i);
    }

    // 自定义的方法
    public String getField()
    {
        return field;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public static EnumInstance getInstance()
    {
        return INSTANCE;
    }

    // 静态不可变的实例对象
    public static final EnumInstance INSTANCE;
    // 自定义字段
    private String field;
    private static final EnumInstance $VALUES[];

    // 在静态代码中进行初始化
    static 
    {
        INSTANCE = new EnumInstance("INSTANCE", 0);
        $VALUES = (new EnumInstance[] {
            INSTANCE
        });
    }
}
```

通过反编译工具可以看到其和饿汉式单例模式类似，因此它也是线程安全的。另外它也能防止序列化攻击和反射攻击：

```java
public class EnumInstanceTest {
	public static void main(String[] args) throws Exception {
		// 序列化攻击
		EnumInstance instance = EnumInstance.getInstance();
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("EnumSingletonFile"));
		outputStream.writeObject(instance);
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("EnumSingletonFile")));
		EnumInstance newInstance = (EnumInstance) inputStream.readObject();
		System.out.println(instance == newInstance);
		// 反射攻击，Enum类中只有一个两个参数的构造器：Enum(String name, int ordinal)
		Constructor<EnumInstance> constructor = EnumInstance.class.getDeclaredConstructor(String.class, int.class);
		constructor.setAccessible(true);
		EnumInstance enumInstance = constructor.newInstance("name", 0);
		System.out.println(instance == enumInstance);
	}
}
```

对于序列化与反序列化，枚举类单例能保证两次拿到的都是同一个实例。对于反射攻击，枚举类单例会抛出明确的异常：

```java
Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
	at com.heibaiying.creational.singleton.EnumInstanceTest.main(EnumInstanceTest.java:18)
```



## 2. 简单工厂模式

### 2.1 定义

对于调用者来说，它无需知道对象的具体创建细节，只需要将自己所需对象的类型告诉工厂，然后由工厂自动创建并返回。

### 2.2 实现

![23_simple_factory](../pictures/23_simple_factory.png)

产品抽象类：

```java
public abstract class Phone {
	public abstract void call(String phoneNum);
}
```

具体的产品：

```java
public class HuaweiPhone extends Phone {
    public void call(String phoneNum) {
        System.out.println("华为手机拨打电话：" + phoneNum);
    }
}
```

```java
public class XiaomiPhone extends Phone {
    public void call(String phoneNum) {
        System.out.println("小米手机拨打电话：" + phoneNum);
    }
}
```

手机工厂：

```java
public class PhoneFactory {

    public Phone getPhone(String type) {
        if ("xiaomi".equalsIgnoreCase(type)) {
            return new XiaomiPhone();
        } else if ("huawei".equalsIgnoreCase(type)) {
            return new HuaweiPhone();
        }
        return null;
    }
}
```

调用工厂类获取具体的实例：

```java
public class ZTest {
	public static void main(String[] args) {
		PhoneFactory phoneFactory = new PhoneFactory();
		phoneFactory.getPhone("xiaomi").call("123");
		phoneFactory.getPhone("huawei").call("321");
	}
}
```

### 2.3  优缺点

简单工厂的优点在于其向用户屏蔽了对象创建过程，使得用户可以不必关注具体的创建细节，其缺陷在于违背了开闭原则。在简单工厂模式下，如果想要增加新的产品，就需要修改简单工厂中的判断逻辑，这就违背了开闭原则，因此其并不属于 GOF 经典的 23 种设计模式。在 Java 语言中，可以通过泛型来尽量规避这一缺陷，此时需要将创建产品的方法修改为如下所示：

```java
public Phone getPhone(Class<? extends Phone> phoneClass) {
    try {
        return (Phone) Class.forName(phoneClass.getName()).newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}
```

## 3. 工厂模式

### 3.1  定义

定义一个用于创建对象的工厂接口，但具体实例化哪一个工厂则由子类来决定。

### 3.2 实现

![23_factory_method](../pictures/23_factory_method.png)

产品抽象类：

```java
public abstract class Phone {
    public abstract void call(String phoneNum);
}
```

产品实现类：

```java
public class HuaweiPhone extends Phone {
    public void call(String phoneNum) {
        System.out.println("华为手机拨打电话：" + phoneNum);
    }
}
```

```java
public class XiaomiPhone extends Phone {
    public void call(String phoneNum) {
        System.out.println("小米手机拨打电话：" + phoneNum);
    }
}
```

工厂接口：

```java
public interface Factory {
    Phone produce();
}
```

工厂实现类：

```java
public class HuaweiPhoneFactory implements Factory {
    @Override
    public Phone produce() {
        return new HuaweiPhone();
    }
}
```

```java
public class XiaomiPhoneFactory implements Factory {
    @Override
    public Phone produce() {
        return new XiaomiPhone();
    }
}
```

由调用者来决定实例化哪一个工厂对象：

```java
public class ZTest {
    public static void main(String[] args) {
        XiaomiPhoneFactory xiaomiPhoneFactory = new XiaomiPhoneFactory();
        xiaomiPhoneFactory.produce().call("123");
        HuaweiPhoneFactory huaweiPhoneFactory = new HuaweiPhoneFactory();
        huaweiPhoneFactory.produce().call("456");
    }
}
```

### 3.3  优点

工厂模式的优点在于良好的封装性和可扩展性，如果想要增加新的产品（如：OppoPhone），只需要增加对应的工厂类即可，同时和简单工厂一样，它也向用户屏蔽了不相关的细节，使得系统的耦合度得以降低。

## 4. 抽象工厂模式

### 4.1  定义

提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的实现类。抽象工厂模式是工厂模式的升级版本，它适用于存在多个产品的情况。接着上面的例子，假设每个工厂不仅生产手机，而且还需要生产对应的充电器，这样才能算一个可以出售的产品，相关的代码示例如下：

### 4.2  实现

![23_abstract_factory](../pictures/23_abstract_factory.png)

充电器抽象类：

```java
public abstract class Charger {
    public abstract void Charge(Phone phone);
}
```

充电器实现类：

```java
public class HuaiweiCharger extends Charger {
    @Override
    public void Charge(Phone phone) {
        System.out.println("华为充电器给" + phone + "充电");
    }
}
```

```java
public class XiaomiCharger extends Charger {
    @Override
    public void Charge(Phone phone) {
        System.out.println("小米充电器给" + phone + "充电");
    }
}
```

工厂接口：

```java
public interface Factory {
    Phone producePhone();
    Charger produceCharger();
}
```

工厂实现类：

```java
public class HuaweiPhoneFactory implements Factory {
    @Override
    public Phone producePhone() {
        return new HuaweiPhone();
    }
    @Override
    public Charger produceCharger() {
        return new HuaiweiCharger();
    }
}
```

```java
public class XiaomiPhoneFactory implements Factory {
    @Override
    public Phone producePhone() {
        return new XiaomiPhone();
    }
    @Override
    public Charger produceCharger() {
        return new XiaomiCharger();
    }
}
```

调用具体的工厂实现类：

```java
public class ZTest {
	public static void main(String[] args) {
		XiaomiPhoneFactory xiaomiPhoneFactory = new XiaomiPhoneFactory();
		xiaomiPhoneFactory.produceCharger().Charge(xiaomiPhoneFactory.producePhone());
		HuaweiPhoneFactory huaweiPhoneFactory = new HuaweiPhoneFactory();
		huaweiPhoneFactory.produceCharger().Charge(huaweiPhoneFactory.producePhone());
	}
}
```

### 4.3 优缺点

抽象工厂模式继承了工厂模式的优点，能用于存在多个产品的情况，但其对应的产品族必须相对固定，假设我们现在认为 手机 + 充电器 + 耳机 才算一个可以对外出售的产品，则上面所有的工厂类都需要更改，但显然不是所有的手机都有配套的耳机，手机 + 充电器 这个产品族是相对固定的。

## 5. 构建者模式

### 5.1 定义

将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示。它是将一个复杂对象的创建过程分解为多个简单的步骤，然后一步一步的组装完成。

### 5.2 示例

![23_builder](../pictures/23_builder.png)

产品实体类：

```java
public class Phone {
	/*处理器*/
	private String processor;
	/*摄像头*/
	private String camera;
	/*屏幕*/
	private String screen;
}
```

建造者抽象类：

```java
public abstract class Builder {

    protected Phone phone = new Phone();
	/*安装处理器*/
    public abstract void addProcessor();
	/*组装摄像头*/
    public abstract void addCamera();
	/*安装屏幕*/
    public abstract void addScreen();
  
    public Phone produce() {
        return phone;
    }
}
```

建造者实现类：

```java
public class HuaweiBuilder extends Builder {
    @Override
    public void addProcessor() {
        phone.setProcessor("海思麒麟处理器");
    }

    @Override
    public void addCamera() {
        phone.setCamera("莱卡摄像头");
    }

    @Override
    public void addScreen() {
        phone.setScreen("OLED");
    }
}
```

```java
public class XiaomiBuilder extends Builder {
	@Override
	public void addProcessor() {
		phone.setProcessor("高通骁龙处理器");
	}

	@Override
	public void addCamera() {
		phone.setCamera("索尼摄像头");
	}

	@Override
	public void addScreen() {
		phone.setScreen("OLED");
	}
}
```

定义管理者类（也称为导演类），由它来驱使具体的构建者按照指定的顺序完成构建过程：

```java
public class Manager {

	private Builder builder;

	public Manager(Builder builder) {
		this.builder = builder;
	}

	public Phone buy() {
		builder.addCamera();
		builder.addProcessor();
		builder.addScreen();
		return builder.produce();
	}
}
```

调用管理者类获取产品：

```java
public class ZTest {
	public static void main(String[] args) {
		Phone huawei = new Manager(new HuaweiBuilder()).buy();
		System.out.println(huawei);
		Phone xiaomi = new Manager(new XiaomiBuilder()).buy();
		System.out.println(xiaomi);
	}
}
// 输出：
Phone(processor=海思麒麟处理器, camera=莱卡摄像头, screen=OLED)
Phone(processor=高通骁龙处理器, camera=索尼摄像头, screen=OLED)
```

### 5.3 优点

建造者模式的优点在于将复杂的构建过程拆分为多个独立的单元，在保证拓展性的基础上也保证了良好的封装性，使得客户端不必知道产品的具体创建流程。