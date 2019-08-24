# Mycat 基础

<nav>
<a href="#一Mycat-简介">一、Mycat 简介</a><br/>
<a href="#二Mycat-核心概念">二、Mycat 核心概念</a><br/>
<a href="#三Mycat-安装">三、Mycat 安装</a><br/>
<a href="#四Mycat-基本配置">四、Mycat 基本配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-serverxml">4.1 server.xml</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-schemaxml">4.2 schema.xml</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-rulexml">4.3 rule.xml</a><br/>
<a href="#五Mycat-读写分离">五、Mycat 读写分离</a><br/>
<a href="#六Mycat-分库分表">六、Mycat 分库分表</a><br/>
<a href="#七Mycat-与-MySQL-80">七、Mycat 与 MySQL 8.0</a><br/>
</nav>

## 一、Mycat 简介

Mycat 是一个开源的数据库中间件，可以解决分布式数据库环境下的大多数问题，如读写分离、分库分表等，除此之外，它还具备以下特性：

- 支持 MySQL、Oracle、DB2、SQL Server、PostgreSQL 等数据库常见的 SQL 语法。
- 能够基于心跳机制进行自动地故障切换，支持读写分离，支持MySQL主从架构，以及 galera cluster 集群。
- 支持数据的多片自动路由与聚合，支持 sum，count，max 等常用的聚合函数，支持跨库分页。
- 支持单库内部任意 join，支持跨库两表 join，也支持基于 caltlet 的多表 join。
- 支持通过全局表，ER 关系表等分片策略来实现多表 join 查询。
- 支持XA分布式事务（1.6.5 +）。
- 支持全局序列号，能够解决分布式环境下的主键生成问题。
- 支持使用 zookeeper 来协调主从切换、统一管理配置数据以及使用 zookeeper 来生成全局唯一 ID。( 1.6+ )
- 提供了 Web 监控界面，来对 Mycat、MySQL 以及服务器的状态进行监控。

## 二、Mycat 核心概念

在引入 Mycat 后，所有的客户端请求需要经过中间件进行转发上，此时客户端直接面向的是 Mycat 上的逻辑库或逻辑表：

### 逻辑库

在 Mycat 的配置文件中进行定义，它对应一个或者多个实际的数据库或数据库集群。

### 逻辑表

可以对应一张实际的表，也可以表示为多个分片表的集合。按其特性可以分为以下四类：

+ **分片表**：表按照指定键进行拆分，并散落到多个数据库实例上，从而可以解决单表过大的问题。
+ **非分片表**：通常情况下，只有大表需要分片，小表并没有分片的必要，所以在 Mycat 中它们也被称为非分片表，主要是为了在概念上与分片表进行区分。
+ **ER表**：基于实体关系模型进行分片的表，如订单表和订单明细表通常都是大表，此时可以按照订单号进行 ER 分片，从而保证同一单号的订单记录和明细记录都处于同一分片上，进而避免跨分片查询。
+ **全局表**：同样也是用于避免跨分片查询。假设在查询订单明细时需要查询产品所属分类 （如家电产品、生活用品），产品类别表通常是小表，此时可以声明为全局表，之后 Mycat 会将其拷贝到所有分片上，从而避免跨分片查询。

### 分片节点

将表按照分片键进行分片后，一个表中的所有数据就会被分发到不同的数据库上，这些数据库节点就称为分片节点。

## 三、Mycat 安装

## 四、Mycat 基本配置

在 Mycat 的安装目录的 `conf` 目录下，有以下三个核心配置文件：

+ **server.xml**：主要用于定义用户信息，全局 SQL 防火墙、以及与 Mycat 自身相关的配置。
+ **schema.xml**：主要用于定义逻辑库，逻辑表，逻辑数据节点以及实际的物理数据库的信息。
+ **rule.xml**：主要用于定义分片规则，并提供给 schema.xml 标签中的分片表使用。

### 4.1 server.xml

一个 server.xml 的配置示例如下，主要包含以下标签：

+ **\<system>** ：定义  Mycat 相关的配置。
+ **\<firewall>**：配置全局 SQL 防火墙，可以在其下通过子标签定义 IP 白名单和黑名单。
+ **\<user>**：用于设置默认账户或普通账户，并为其分配在逻辑库或逻辑表上的权限。权限通过 dml 属性来指定，如  dml="0110" ，四个位置上的数值分别对应 insert，update，select，delete 权限，1 为具有该权限，0 为不具有。

```xml
<system> 
    <!-- 0为需要密码登陆、1为不需要密码登陆 ,默认为0，设置为1则需要指定默认账户-->
    <property name="nonePasswordLogin">0</property> 
    <property name="charset">utf8</property>
</system>

<firewall>
    <whitehost>
        <host host="1*7.0.0.*" user="root"/>
    </whitehost>
    <blacklist check="false">
    </blacklist>
</firewall>

<!-- 定义默认账户-->
<user name="root" defaultAccount="true">
    <property name="password">123456</property>
    <property name="schemas">TESTDB</property>
    <!-- 权限设置 -->
    <privileges check="true">
        <schema name="TESTDB" dml="0110" >
            <table name="tb01" dml="0000"></table>
            <table name="tb02" dml="1111"></table>
        </schema>
    </privileges>
</user>

<!-- 定义默认账户-->
<user name="user">
    <property name="password">123456</property>
    <property name="schemas">TESTDB</property>
    <property name="readOnly">true</property>
</user>
```

在上面的示例中，用户配置的是明文密码，这样会存在安全隐患，因此 Mycat 也支持对密码进行加密，示例如下：

```shell
# 该jar包在Mycat安装目录的lib目录下
shell > java -cp Mycat-server-1.6.7.1-release.jar  io.mycat.util.DecryptUtil 0:root:123456
GO0bnFVWrAuFgr1JMuMZkvfDNyTpoiGU7n/Wlsa151CirHQnANVk3NzE3FErx8v6pAcO0ctX3xFecmSr+976QA==
```

可以将明文密码替换为加密密码，但此时还需在对应用户的 user 标签下增加如下配置，代表启用加密功能：

```xml
<property name="usingDecrypt">1</property> 
```

### 4.2 schema.xml

下面是一个示例的 schema.xml 配置文件，主要包含以下标签：

+ **\<schema>**：主要用于定义逻辑库，checkSQLschema 表明是否检查 schema，当其为 true 时，如果发送 `select * from db.table1` 等查询时，会自动修改为 `select * from table1` 。sqlMaxLimit 用于限制返回数据的行数。
+ **\<table>**：主要用于定义逻辑表。这里以分片表为例，定义了订单表的分片节点及分片规则。
+ **\<dataNode>**：定义逻辑数据节点。下面示例配置中的每个节点分别对应主从复制集群上的一个数据库实例。
+ **\<dataHost>**：实际的单台物理数据库或数据库集群，下面的示例配置中对应的是一个 maser-slave 集群。

```xml
<schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100">
    <!-- mod-long 分片规则在下文的 rule.xml中定义 -->
    <table name="order" dataNode="dn1,dn2,dn3" rule="mod-long" />
</schema>

<dataNode name="dn1" dataHost="cluster01" database="order_db" />
<dataNode name="dn2" dataHost="cluster02" database="order_db" />
<dataNode name="dn3" dataHost="cluster03" database="order_db" />

<dataHost name="cluster01" maxCon="1000" minCon="10" balance="0"
          dbType="mysql" dbDriver="native" switchType="1">
    <!-- 心跳检查 -->
    <heartbeat>select user()</heartbeat>
    <writeHost host="master" url="192.168.0.226:3306" user="root"  password="123456">
        <readHost host="salve" url="192.168.0.227:3306" user="root" password="123456" />
    </writeHost>
</dataHost>

...... 省略 cluster02，cluster03
```

这里解释一下 dataHost 标签的相关属性：maxCon 表示最大连接数，minCon 表示最小连接数，dbType 表示数据库类型 ( 如 mysql、oracle 等)，其他属性都有多个可选值，具体如下：

+ **dbDriver**：数据库类型，可选的值有 native 和 JDBC，如果是 mysql，maridb，postgresql 等数据库，直接可以使用 native  即可。其他数据库则需要将对应的驱动包拷贝到 Mycat 安装目录的 lib 目录下，并写上完整的驱动类的类名。

+ **switchType**：

  默认值为 1，代表自动切换；

  设置为 2，代表基于 MySQL 主从同步的状态来决定是否切换；

  设置为 3，代表基于 MySQL galary cluster 的切换机制进行切换；

  如果你的集群基于 MMM 或 MHA 等高可用架构实现自动切换，则可以将该值设置为 -1，代表不切换。

+ **balance**：

  balance="0" ：不开启读写分离机制，所有读请求都发送到当前可用的 writeHost 上。

  balance="1" ：全部的 readHost 与 stand by writeHost 参与读操作。stand by writeHost 通常指的是双主复制中处于 stand 状态的主节点，即假设集群复制架构为 Master1 -> Slave1，Master2 -> Slave2，并且 M1 与 M2  互为主备 )，此时 Master2 ，Slave1，Slave2 都会参与读的负载。

  balance="2" ：所有读请求随机在 writeHost、 readhost 上进行分发。

  balance="3" ：所有读请求随机分发到 writeHost 对应的 readhost 执行，writerHost 不负担读压力。

### 4.3 rule.xml

rule.xml 文件中定义的是分片规则，主要包含以下标签：

+ **\<tableRule>**：定义分片规则的名称，分片键和分片算法。以下分片规则表示对订单 Id 按照取模算法进行分片。
+ **\<function>**：定义分片算法的具体实现类，以及所需要的参数。

```xml
<tableRule name="mod-long">
    <rule>
        <columns>order_id</columns>
        <algorithm>mod-long</algorithm>
    </rule>
</tableRule>
<function name="mod-long" class="io.mycat.route.function.PartitionByMod">
    <!-- nodes 节点的数量-->
    <property name="count">3</property>
</function>
```

Mycat 内置支持十几种分片算法，如 取模分片，枚举分片，范围分片，字符串 hash 分片，一致性 hash 分片，日期分片等。关于这些分片算法的详细说明可以参考官方文档：[Mycat 官方指南](http://www.mycat.io/document/mycat-definitive-guide.pdf)

## 五、Mycat 读写分离

Mycat 读写分离的配置非常简单，只需要通过配置 balance，writeHost 和 readHost 就可以实现，示例如下：

```xml
<dataHost name="localhost1" maxCon="1000" minCon="10" balance="1"
          writeType="0" dbType="mysql" dbDriver="native">
    <heartbeat>select user()</heartbeat>
    <!-- 可以配置多个writeHost -->
    <writeHost host="Master" url="hostname1:3306" user="root"
               password="123456">
        <!-- 可以配置多个readHost-->
        <readHost host="Slave" url="hostname2:3306" user="root"
                  password="123456" />
    </writeHost>
</dataHost>
```

但是需要注意的是如上的配置还是会存在单点问题，因为只有一个 writeHost ，Mycat 支持配置多个 writeHost，示例如下：

```xml
<writeHost host="Master" url="hostname1:3306" user="root"
           password="123456">
    <!-- 可以配置多个readHost-->
    <readHost host="Slave1" url="hostname2:3306" user="root"
              password="123456" />
    <readHost host="Slave2" url="hostname3:3306" user="root"
              password="123456" />
</writeHost>
<writeHost host="Slave3" url="hostname4:3306" user="root" password="123456" />
```

以上是 Mycat 官方指南中给出的配置，即在一主三从的复制架构下，可以选择其中一个 Slave 为备用的写入节点，此时当 Master 节点宕机后，会继续在该备用节点执行写入操作。这个配置和架构存在以下两个问题：

+ 第一 Mycat 并不能让 Slave 1 和 Slave 2 自动将自己的复制主节点变更为 Slave 3，这个过程仍需要你自己来实现。
+ 第二你很难确定哪个节点该作为备用的主节点，在上面的配置中我们设置 Slave 3 为备用节点，但在主节点宕机后，可能 Slave 1 和 Slave 2 的复制偏移量都要大于 Slave 3，显然它们更适合成为新的主节点。 

基于以上两个原因，如果想要实现高可用，并不建议配置多个 writeHost ，而是配置一个 writeHost ，但其指向的是虚拟的读  IP 地址，此时复制架构由 MMM 或者 MHA 架构来实现，并由它们来提供虚拟机的读 IP。

## 六、Mycat 分库分表

综合以上全部内容，这里给出一个分库分表的示例，其架构如下：

<div align="center"> <img src="https://github.com/heibaiying/Full-Stack-Notes/blob/master/pictures/mysql-mycat-分库分表实战.png"/> </div>

如上图所示，这里模拟的是一个电商数据库，并对其执行分库分表操作：

- 将用户相关表，订单相关表，商品相关表分表拆分到单独的数据库中；
- 将订单表和订单明细表进行横向分表，拆分到不同的数据库中。同时为了避免订单表关联订单明细表时出现跨分片查询的情况，需要将其配置为 ER 表；
- 由于地址表，在查询用户信息（如家庭地址），订单信息（收货地址），商品信息（商品产地）的时候都需要用到，所以会将其声明为全局表，它会存在于以上所有分片上，从而避免跨分片查询。

为节省篇幅，以上所有测试表和测试库的建立语句单独整理至：[ec_shop.sql](https://github.com/heibaiying/Full-Stack-Notes/blob/master/resources/ec_shop.sql) 。分库分表的具体操作如下：

### 6.1 server.xml

这里新增一个 Mycat 用户，并定义其管理的逻辑数据库为 ec_shop，另外使用 fakeMySQLVersion 来定义你所需要模拟的 MySQL 数据库的版本。如果没有特殊需求， Mycat 自带的 server.xml 中的其他配置可不做更改。

```xml
<system>
    <property name="fakeMySQLVersion">5.7.20</property>
</system>

<user name="heibaiying">
    <property name="password">
        B+BlA/U17pjyzHslglpDgYUxpgqK8qC62IRt/S74RBW6R7dZFJAXVb5tJDgmhzM4fj14MMhLnNmvKko6D73+iA==
    </property>
    <property name="schemas">ec_shop</property>
    <property name="usingDecrypt">1</property>
</user>
```

### 6.2 schema.xml

这里使用 childTable 来将订单表和订单明细表定义为 ER 表，避免跨分片查询。并将地址表 area_info 使用 `type="global"` 声明为全局，同样也是为了避免跨分片查询。

```xml
<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">
<mycat:schema xmlns:mycat="http://io.mycat/">

    <schema name="ec_shop" checkSQLschema="false" sqlMaxLimit="100">
        <table name="customers" primaryKey="customer_id" dataNode="dn01"/>
        <table name="products" primaryKey="product_id" dataNode="dn02"/>
        <table name="orders" primaryKey="order_id" dataNode="dn03,dn04" rule="mod-long">
            <childTable name="order_detail" primaryKey="order_detail_id" joinKey="order_id"
                        parentKey="order_id"/>
        </table>
        <table name="area_info" primaryKey="area_id" type="global" dataNode="dn01,dn02,dn03,dn04"/>
    </schema>


    <dataNode name="dn01" dataHost="host01" database="ec_shop_customer"/>
    <dataNode name="dn02" dataHost="host02" database="ec_shop_product"/>
    <dataNode name="dn03" dataHost="host03" database="ec_shop_order"/>
    <dataNode name="dn04" dataHost="host04" database="ec_shop_order"/>

    <dataHost name="host01" maxCon="1000" minCon="10" balance="0"
              dbType="mysql" dbDriver="native" switchType="1">
        <heartbeat>select user()</heartbeat>
        <writeHost host="master" url="192.168.0.226:3306" user="root" password="123456"/>
    </dataHost>

    <dataHost name="host02" maxCon="1000" minCon="10" balance="0"
              dbType="mysql" dbDriver="native" switchType="1">
        <heartbeat>select user()</heartbeat>
        <writeHost host="master" url="192.168.0.227:3306" user="root" password="123456"/>
    </dataHost>

    <dataHost name="host03" maxCon="1000" minCon="10" balance="0"
              dbType="mysql" dbDriver="native" switchType="1">
        <heartbeat>select user()</heartbeat>
        <writeHost host="master" url="192.168.0.228:3306" user="root" password="123456"/>
    </dataHost>

    <dataHost name="host04" maxCon="1000" minCon="10" balance="0"
              dbType="mysql" dbDriver="native" switchType="1">
        <heartbeat>select user()</heartbeat>
        <writeHost host="master" url="192.168.0.229:3306" user="root" password="123456"/>
    </dataHost>

</mycat:schema>
```

### 6.3 rule.xml

定义订单表所使用的分片规则，这里使用取模算法作为示例：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mycat:rule SYSTEM "rule.dtd">
<mycat:rule xmlns:mycat="http://io.mycat/">
    <tableRule name="mod-long">
        <rule>
            <columns>order_id</columns>
            <algorithm>mod-long</algorithm>
        </rule>
    </tableRule>
    <function name="mod-long" class="io.mycat.route.function.PartitionByMod">
        <!-- nodes 节点的数量-->
        <property name="count">2</property>
    </function>
</mycat:rule>
```



## 七、Mycat 与 MySQL 8.0

这里我后端使用的数据库是 MySQL 8.0.17 ，相比于使用 MySQL  5.6 或 5.7 来整合 Mycat ，多了一些注意事项，主要如下：

### 7.1 密码错误

即便你在 server.xml 中正确的配置了用户名和密码，但在使用 mysql shell 连接 Mycat 时，还是会抛出密码错误的异常：

```shell
Access denied for user 'xxx', because password is error
```

这是由于从 MySQL 8.0.4 开始使用 caching_sha2_password 作为认证的插件，而之前版本的插件为 mysql_native_password，我在测试中使用的 Mycat 版本为 1.6.7，它并不支持 caching_sha2_password 。因此在登录时候需要通过 `--default_auth` 来指定使用原有的认证插件。

```shell
# 1.6.7 版本 Mycat 默认的连接端口号为 8066
mysql -uheibaiying -p -h127.0.0.1 -P8066 --default_auth=mysql_native_password
```

### 7.2 数据库连接失败

Mycat 和 MySQL 都正常启动，但是在 Mycat 上执行 SQL 语句失败，提示无效的数据库。此时可以查看 Mycat  logs 目录下的 mycat.log 文件，通常会出现下面所示的异常：

```shell
(io.mycat.backend.mysql.nio.MySQLConnectionAuthenticator.handle(MySQLConnectionAuthenticator.java:91)
- can't connect to mysql server ,errmsg:Client does not support authentication protocol requested by
server; consider upgrading MySQL client MySQLConnection
```

这和上面是同样的原因，都是因为认证插件而导致的问题。此时需要修改账户所使用的认证插件：

```sql
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'xxxx';
FLUSH PRIVILEGES;
```

修改后可以使用如下命令进行查看：

```sql
mysql> SELECT Host,User,plugin FROM mysql.user;
+---------------+------------------+-----------------------+
| Host          | User             | plugin                |
+---------------+------------------+-----------------------+
| %             | root             | mysql_native_password |
| 192.168.200.% | repl             | mysql_native_password |
| localhost     | mysql.infoschema | caching_sha2_password |
| localhost     | mysql.session    | caching_sha2_password |
| localhost     | mysql.sys        | caching_sha2_password |
| localhost     | root             | mysql_native_password |
+---------------+------------------+-----------------------+
```

之后再重启 Mycat 服务就可以正常连接。



## 参考资料

Mycat 官方指南：http://www.mycat.io/document/mycat-definitive-guide.pdf







