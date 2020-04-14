# Tomcat 架构解析

<nav>
<a href="#一Tomcat-简介">一、Tomcat 简介</a><br/>
<a href="#二Tomcat-架构">二、Tomcat 架构</a><br/>
<a href="#三连接器">三、连接器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-ProtocolHandler">3.1 ProtocolHandler</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-Adapter">3.2 Adapter</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-Mapper-和-MapperListener">3.3 Mapper 和 MapperListener</a><br/>
<a href="#四容器">四、容器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-Container-和-Lifecycle">4.1 Container 和 Lifecycle</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-分层结构">4.2 分层结构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-Pipeline-和-Valve">4.3 Pipeline 和 Valve</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#44-FilterChain">4.4 FilterChain</a><br/>
<a href="#五请求流程">五、请求流程</a><br/>
<a href="#六启动流程">六、启动流程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-startupsh--catalinash">1. startup.sh & catalina.sh</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-Bootstrap">2. Bootstrap</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-Catalina">3. Catalina</a><br/>
<a href="#七类加载器">七、类加载器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-Web-App-Class-Loader">1. Web App Class Loader</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-Shared-Class-Loader">2. Shared Class Loader</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-Catalina-Class-Loader">3. Catalina Class Loader</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-Common-Class-Loader">4. Common Class Loader</a><br/>
</nav>



## 一、Tomcat 简介

Tomcat 是目前主流的基于 Java 语言的轻量级应用服务器，它是对是 Java Servlet，JavaServer Pages（JSP），Java Expression Language（EL 表达式）和 Java WebSocket 技术的开源实现。当前 Tomcat 共有四个版本：

+ **Tomcat 7**：支持 Servlet 3.0，JSP 2.2，EL 2.2 和 WebSocket 1.1 规范。
+ **Tomcat 8.5**：支持 Servlet 3.1，JSP 2.3，EL 3.0 和 WebSocket 1.1 规范，并可以通过安装 Tomcat 原生库来支持 HTTP/2 。当前 Tomcat 8.5 已经完全取代了 Tomcat 8，Tomcat 8 已停止维护，并不再提供下载。
+ **Tomcat 9**：是当前主要的发行版；它建立在 Tomcat 8.0.x 和 8.5.x 之上，并实现了 Servlet 4.0，JSP 2.3，EL 3.0，WebSocket 1.1 和 JASPIC 1.1 规范。
+ **Tomcat 10 (alpha)** ：是当前主要的开发版；它实现了 Servlet 5.0，JSP 3.0，EL 4.0 和 WebSocket 2.0 规范。



## 二、Tomcat 架构

Tomcat 的整体架构如下：

<div align="center"> <img src="..\pictures\tomcat_架构.png"/> </div>


+ **Server**：表示整个 Servlet 容器，在整个 Tomcat 运行环境中只有唯一一个 Server 实例。一个 Server 包含多个 Service，每个 Service 互相独立，但共享一个 JVM 以及系统类库。
+ **Service**：一个 Service 负责维护多个 Connector 和一个 Engine。其中 Connector 负责开启 Socket 并监听客户端请求，返回响应数据；Engine 负责具体的请求处理。
+ **Connector**：连接器，用于监听并转换来自客户端 Socket 请求，然后将 Socket 请求交由 Container 处理，支持不同协议以及不同的 I/O 方式。
+ **Engine**：表示整个 Servlet 引擎，在 Tomcat 中，Engine 为最高层级的容器对象。
+ **Host**：表示 Engine 中的虚拟机，通常与一个服务器的网络名有关，如域名等。
+ **Context**：表示 ServletContext ，在 Servlet 规范中，一个 ServletContext 即表示一个独立的 Web 应用。
+ **Wrapper**：是对标准 Servlet 的封装。

以上各组件的详细介绍如下：



## 三、连接器

连接器的主要功能是将 Socket 的输入转换为 Request 对象，并交由容器进行处理；之后再将容器处理完成的 Response 对象写到输出流。连接器的内部组件如下：

<div align="center"> <img src="..\pictures\tomcat连接器组件.png"/> </div>


### 3.1 ProtocolHandler

**1. Endpoint**

EndPoint 会启动线程来监听服务器端口，并负责处理来自客户端的 Socket 请求，是对传输层的抽象。它支持以下 IO 方式：

+ **BIO**：即最传统的 I/O 方式；
+ **NIO**：采用 Java NIO 类库进行实现，Tomcat 8 之后默认该 I/O 方式，以替换原来的 BIO；
+ **NIO2**：采用 JDK 7 最新的 NIO2 类库进行实现；
+ **APR**：采用 APR (Apache 可移植运行库) 实现，APR 是使用 C/C++ 编写的本地库，需要单独进行安装。

**2. Processor**

负责构造 Request 和 Response 对象，并通过 Adapter 提交到容器进行处理，是对应用层的抽象。它支持以下应用层协议：

+ **HTTP / 1.1 协议**；
+ **HTTP / 2.0 协议**：自 Tomcat 8.5 以及 9.0 版本后开始支持；
+ **AJP 协议**：即定向包协议。

**3. ProtocolHandler**

ProtocolHandler 通过组合不同类型的 Endpoint 和 Processor 来实现针对具体协议的处理功能。按照不同的协议（HTTP 和 AJP）和不同的 I/O 方式（NIO，NIO2，AJP）进行组合，其有以下六个具体的实现类：

<div align="center"> <img src="..\pictures\tomcat_AbstractProtocol.png"/> </div>


**4. 协议升级**

可以看到上面的 ProtocolHandler 只有对 HTTP 1.1 协议进行处理的实现类，并没有对 HTTP 2.0 进行处理的实现类，想要对 HTTP 2.0 进行处理，需要使用到协议升级：当 ProtocolHandler 收到的是一个 HTTP 2.0 请求时，它会根据请求创建一个用于升级处理的令牌 UpgradeToken，该令牌中包含了升级处理器 HttpUpgradeHandler（接口），对于 HTTP 2.0 而言，其实现类是 Http2UpgradeHandler。

### 3.2 Adapter

Tomcat 设计者希望连接器是一个单独的组件，能够脱离 Servlet 规范而独立存在，以便增加其使用场景，因此 Process 对输入流封装后得到的 Request 不是一个 Servlet Request，该 Request 的全限定命名为：org.apache.coyote.Request 。因此在这里需要使用适配器模式（具体实现类是 CoyoteAdapter）将其转换为 org.apache.catalina.connector.Request，它才是标准的 ServletRequest 的实现：

<div align="center"> <img src="..\pictures\tomcat_request.png"/> </div>


### 3.3 Mapper 和 MapperListener

由 Socket 输入流构建好标准的 ServletRequest 后，连接器还需要知道将 Request 发往哪一个容器，这需要通过 Mapper 来实现。Mapper 维护了请求路径与容器之间的映射信息。在 Tomcat 7 及之前的版本中 Mapper 由连接器自身维护，在 Tomcat 8 之后的版本中，Mapper 由 Service 进行维护。

MapperListener 实现了 ContainerListener 和 LifecycleListener 接口，用于在容器组件状态发生变更时，注册或取消对应容器的映射关系，这么做主要是为了支持 Tomcat 的热部署功能。



## 四、容器

### 4.1 Container 和 Lifecycle

Tomcat 中的所有容器都实现了 Container 接口，它定义了容器共同的属性与方法，而 Container 接口则继承自 Lifecycle 接口。Tomcat 中的大多数组件都实现了 Lifecycle 接口，它定义了与组件生命周期相关的公共方法，如 `init()`，`start()`，`stop()`，`destroy()` :



<div align="center"> <img src="..\pictures\tomcat_container.png"/> </div>




### 4.2 分层结构

Tomcat 之所以采用分层的结构，主要是为了更好的灵活性和可扩展性：

+ **Engine**：最顶层的容器，一个 Service 中只有一个 Engine；
+ **Host**：代表一个虚拟主机，一个 Engine 可以包含多个虚拟主机；
+ **Context**：表示一个具体的 Web 应用程序，一个虚拟主机可以包含多个 Context；
+ **Wrapper**：是 Tomcat 对 Servlet 的包装，一个 Context 中可以有多个 Wrapper。

<div align="center"> <img src="..\pictures\tomcat_分层结构.png"/> </div>


Tomcat 容器的分层结构在其 conf 目录下的 `server.xml` 配置文件中也有体现：

```xml
<Server port="8005" shutdown="SHUTDOWN">
  <Service name="Catalina">
    <Connector port="8080" protocol="HTTP/1.1"connectionTimeout="20000"redirectPort="8443" />
    <Engine name="Catalina" defaultHost="localhost">
      <Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true">
    </Engine>
  </Service>
</Server>
```

这里的 appBase 代表我们应用程序所在父目录，我们部署的每一个应用程序就是一个独立的 Context 。

### 4.3 Pipeline 和 Valve

<div align="center"> <img src="..\pictures\tomcat_多层容器.jpg"/> </div>


由连接器发过来的请求会最先发送到 Engine，最终逐层传递，直至我们编写的 Servlet，这种传递主要通过 Pipeline 和 Valve 来实现。每层容器都有自己的 Pipeline，Pipeline 相当于处理管道；每个 Pipeline 中有一个 Valve 链，每个 Valve 可以看做一个独立的处理单元，用于对请求进行处理。最基础的 Valve 叫做 Basic Valve，新增的 Valve 会位于已有的 Valve 之前。Pipeline 和 Valve 的接口定义如下：

```java
public interface Pipeline extends Contained {
 
    public Valve getBasic();           // 获得Basic Valve
    public void setBasic(Valve valve); // 设置Basic Valve
    public void addValve(Valve valve); // 新增Valve
    public Valve[] getValves();        // 获取所有Valve
    public void removeValve(Valve valve);// 移除Valve
    public Valve getFirst(); //获取第一个 Valve
   
    public boolean isAsyncSupported();
    public void findNonAsyncValves(Set<String> result);
}
```

```java
public interface Valve {

    public Valve getNext();
    // 每一个Valve都持有其下一个Valve,这是标准的责任链模式
    public void setNext(Valve valve);
    // 对请求进行检查、处理或增强
    public void invoke(Request request, Response response) throws IOException, ServletException;
    public void backgroundProcess();
    public boolean isAsyncSupported();
}

```

通过 Pipeline 的 Valve 责任链模式，每一层容器都可以很方便地进行功能的扩展，来对请求进行检查、处理或增强。每一层处理完成后，就会传递到下一层的 First Valve，由下一层进行处理。以 Engine 容器为例，其实现类为 StandardEngine：

```java
public class StandardEngine extends ContainerBase implements Engine {
    public StandardEngine() {
        super();
        pipeline.setBasic(new StandardEngineValve());
         ....
        }
    }
```

在 StandardEngine 创建时就会为其 Pipeline 设置上一个名为 StandardEngineValve 的 Basic Valve，StandardEngineValve 的实现如下：

```java
final class StandardEngineValve extends ValveBase {

    public StandardEngineValve() {super(true);}

    @Override
    public final void invoke(Request request, Response response) throws IOException, ServletException {

        // 获取当前请求的Host
        Host host = request.getHost();
        if (host == null) {
            return;
        }
        if (request.isAsyncSupported()) {
            request.setAsyncSupported(host.getPipeline().isAsyncSupported());
        }

        // 将请求传递给host的Pipeline的第一个Valve
        host.getPipeline().getFirst().invoke(request, response);
    }
}
```

Engine 的 Basic Valve（即最后一个 Valve）在 `invoke` 方法中会获取到下一级容器（Host）的第一个 Valve，从而完成首尾相接。

### 4.4 FilterChain

通过 Pipeline 和 Valve 的传递，请求最终会传递到最内层容器 Wrapper 的 Basic Valve，其实现类为 StandardWrapperValve 。StandardWrapperValve 会在 `invoke` 方法中为该请求创建 FilterChain，依次执行请求对应的过滤器： 

```java
// 为该请求创建Filter Chain
ApplicationFilterChain filterChain = ApplicationFilterFactory.createFilterChain(request, wrapper, servlet);
.....
// 调用Filter Chain的doFilter方法
filterChain.doFilter(request.getRequest(), response.getResponse());
```

当到达执行链的末端后，会执行 servlet 的 service 方法：

```java
servlet.service(request, response);
```

以我们最常使用的 HttpServlet 为例，其最终的 service 方法如下：

```shell
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        if (method.equals(METHOD_GET)) {
            long lastModified = getLastModified(req);
            if (lastModified == -1) {
                .....
                doGet(req, resp);
            } else {
               ......
            }

        } else if (method.equals(METHOD_HEAD)) {
            long lastModified = getLastModified(req);
            maybeSetLastModified(resp, lastModified);
            doHead(req, resp);

        } else if (method.equals(METHOD_POST)) {
            doPost(req, resp);

        } else if (method.equals(METHOD_PUT)) {
            doPut(req, resp);

        } else if (method.equals(METHOD_DELETE)) {
            doDelete(req, resp);

        } else if (method.equals(METHOD_OPTIONS)) {
            doOptions(req,resp);

        } else if (method.equals(METHOD_TRACE)) {
            doTrace(req,resp);

        } ......
    }
```

至此，来自客户端的请求就逐步传递到我们编写的 doGet 或者 doPost 方法中。



## 五、请求流程

这里对前面的连接器和容器章节进行总结，Tomcat 对客户端请求的完整处理流程如下：

![tomcat启动请求处理流程](C:\Users\ciic\Downloads\tomcat启动请求处理流程.jpg)



## 六、启动流程

Tomcat 整体的启动流程如下图所示：

<div align="center"> <img src="..\pictures\tomcat启动流程.png"/> </div>




#### 1. startup.sh & catalina.sh

`startup.sh` 是对 `catalina.sh` 的一层薄封装，主要用于检查 `catalina.sh` 是否存在以及调用它。 `catalina.sh` 负责启动一个 JVM 来运行 Tomcat 的启动类 Bootstrap 。

#### 2. Bootstrap

Bootstrap 独立于 Tomcat 结构之外，它以 JAR 包的形式存在于 `bin` 目录下，主要负责初始化 Tomcat 的类加载器，并通过反射来创建 Catalina。

#### 3. Catalina

Catalina 通过 Digester 解析 server.xml 来创建所有的服务组件。Digester 是一款能将 XML 转换为 Java 对象的事件驱动型工具，简而言之，它通过流读取 XML 文件，当识别出特定 XML 节点后，就会创建对应的组件。



## 七、类加载器

Tomcat 并没有完全沿用 JVM 默认的类加载机制，为了保证 Web 应用之间的隔离性和加载的灵活性，其采用了下图所示的类加载机制：

<div align="center"> <img width="600px" src="..\pictures\tomcat_类加载器.jpg"/> </div>


#### 1. Web App Class Loader

负责加载 `/WEB-INF/classes` 目录下的未压缩的 Class 和资源文件，以及 `/WEB-INF/lib` 目录下的 Jar 包。它只对当前的 Web 应用可见，对其它 Web 应用均不可见，因此它可以保证 Web 应用之间的彼此隔离。

#### 2. Shared Class Loader

是所有 Web 应用的父类加载器，它负责加载 Web 应用之间共享的类，从而避免资源的重复加载。

#### 3. Catalina Class Loader

用于加载 Tomcat 应用服务器的类加载器，从而保证 Tomcat 与 Web 应用程序之间的隔离。

#### 4. Common Class Loader

其作用和 Shared Class Loader 类似，当 Tomcat 与 Web 应用程序之间存在共同依赖时，可以使用其进行加载。再往上，流程就与 JVM 类加载的流程一致了。





## 参考资料

+ 刘光瑞 . Tomcat架构解析 . 人民邮电出版社 . 2017-05
