# oracle和mysql 知识点总结和异同对比

## 目录<br/>
<a href="#一数据库管理">一、数据库管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-用户管理">1.1 用户管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#111-mysql用户权限管理">1.1.1 mysql用户、权限管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#112-oracle-用户角色权限管理">1.1.2 oracle 用户、角色、权限管理</a><br/>
<a href="#二DQL-语句">二、DQL 语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-基础查询">2.1 基础查询</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1常量查询的区别">1.常量查询的区别：</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2字符串拼接">2.字符串拼接</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3判断字段是否为空">3.判断字段是否为空</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4查询非空字段">4.查询非空字段</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-常见函数">2.2 常见函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1字符函数">1.字符函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2数学函数">2.数学函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3日期函数">3.日期函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-oracle-日期函数">1. oracle 日期函数：</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-oracel常用的时间格式掩码">1.1 oracel常用的时间格式掩码</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-Oracle-获取当前年月日">1.2 Oracle 获取当前年、月、日</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#13-计算两个时间差">1.3 计算两个时间差</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#14-日期和字符串转换">1.4 日期和字符串转换</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#15-日期的加减计算">1.5 日期的加减计算</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2mysql日期函数">2.mysql日期函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-mysql-常用日期格式掩码">2.1 mysql 常用日期格式掩码</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-Oracle-获取当前年月日">2.2 Oracle 获取当前年、月、日</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-计算两个时间之差">2.3 计算两个时间之差</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-日期和字符串转换">2.4 日期和字符串转换</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#25-日期的加减计算">2.5 日期的加减计算</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4流程控制函数">4、流程控制函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-oracle-decode函数">4.1 oracle decode函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-mysql流程控制函数">4.2 mysql流程控制函数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5分页查询">5.分页查询</a><br/>
<a href="#三DML语句">三、DML语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-插入语句">1. 插入语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11-mysql-多行插入">1.1 mysql 多行插入</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12-oracle-多行插入">1.2 oracle 多行插入</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2多表更新">2.多表更新</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-mysql-多表更新">2.1 mysql 多表更新</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-oracle-多表更新">2.2 oracle 多表更新</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-级联删除">3. 级联删除</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-mysql-级联删除">3.1 mysql 级联删除</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-oracle-级联删除">3.2 oracle 级联删除</a><br/>
<a href="#四DDL语句">四、DDL语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-数据库操作">4.1 数据库操作</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-mysql数据库的创建修改和删除">4.1 mysql数据库的创建、修改和删除</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-oracle-数据库的创建和删除">4.2 oracle 数据库的创建和删除</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-表的管理">4.2 表的管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#421-创建表">4.2.1 创建表 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-oracle-字段类型">1. oracle 字段类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-mysql-字段类型">2. mysql 字段类型</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#422-修改表">4.2.2 修改表</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#423-删除表">4.2.3 删除表</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#424-复制表">4.2.4 复制表</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-约束">4.3 约束</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#431-常见的约束">4.3.1 常见的约束</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#432-创建表时添加约束">4.3.2 创建表时添加约束</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#433-修改表时添加或删除约束">4.3.3 修改表时添加或删除约束</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#434-自增长列mysql">4.3.4 自增长列(mysql)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#435-序列oracle">4.3.5 序列(oracle)</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#436-级联操作">4.3.6 级联操作</a><br/>
<a href="#五TCL语言">五、TCL语言</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-事务">5.1 事务</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#511-事务隔离级别">5.1.1 事务隔离级别</a><br/>
<a href="#六其他扩展">六、其他扩展</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-视图">6.1 视图</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-触发器">6.2 触发器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-存储过程">6.3 存储过程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#631-创建存储过程">6.3.1 创建存储过程</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#632变量">6.3.2变量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#633-存储过程的查询">6.3.3 存储过程的查询</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#634-存储过程的修改">6.3.4 存储过程的修改</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#635-存储过程的删除">6.3.5 存储过程的删除</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#636-条件语句">6.3.6 条件语句</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1分支结构">1.分支结构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2循环结构">2.循环结构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#64-游标">6.4 游标</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#641-游标简介">6.4.1 游标简介</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#642-游标的特性">6.4.2 游标的特性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#643-游标的操作">6.4.3 游标的操作</a><br/>

## 正文<br/>


## 一、数据库管理

### 1.1 用户管理

#### 1.1.1 mysql用户、权限管理

**1.创建、修改、删除用户**

```mysql
-- 创建用户
CREATE USER '用户名' IDENTIFIED BY '密码';

-- 重命名
RENAME USER '用户名' TO '新用户名'；

-- 修改用户口令
    -- 自己的口令
    SET PASSWORD=Password('新密码')
    -- 其他用户的口令
    SET PASSWORD FOR 用户名 = Password('新密码')
-- 删除用户
DROP USER '用户名'；
```

**2.用户权限管理**

```mysql
-- 查看用户权限
SHOW GRANTS FOR '用户名'；

-- 赋予权限
GRANT privileges ON [权限范围] TO '用户名'；

-- 撤回权限
REVOKE privileges ON [权限范围] TO '用户名'；
```

**注：修改完权限以后 一定要刷新服务，或者重启服务，刷新服务用：FLUSH PRIVILEGES**



**3.权限级别范围**

MySQL grant 权限，分别可以作用在多个层次上。
```mysql
-- 1. grant 作用在整个 MySQL 服务器上：
grant select on . to dba@localhost; -- dba 可以查询 MySQL 中所有数据库中的表。
grant all on . to dba@localhost; -- dba 可以管理 MySQL 中的所有数据库
-- 2. grant 作用在单个数据库上：
grant select on testdb.* to dba@localhost; -- dba 可以查询 testdb 中的表。
-- 3. grant 作用在单个数据表上：
grant select, insert, update, delete on testdb.orders to dba@localhost;
-- 4. grant 作用在表中的列上：
grant select(id, se, rank) on testdb.apache_log to dba@localhost;
-- 5. grant 作用在存储过程、函数上：
grant execute on procedure testdb.pr_add to ’dba’@’localhost’
grant execute on function testdb.fn_add to ’dba’@’localhost’

```

**4.可以赋予的权限(privileges)列表:**

- ALTER: 修改表和索引。
- CREATE: 创建数据库和表。
- DELETE: 删除表中已有的记录。
- DROP: 抛弃(删除)数据库和表。
- INDEX: 创建或抛弃索引。
- INSERT: 向表中插入新行。
- REFERENCE: 未用。
- SELECT: 检索表中的记录。
- UPDATE: 修改现存表记录。
- FILE: 读或写服务器上的文件。
- PROCESS: 查看服务器中执行的线程信息或杀死线程。
- RELOAD: 重载授权表或清空日志、主机缓存或表缓存。
- SHUTDOWN: 关闭服务器。
- **ALL: 所有权限，ALL PRIVILEGES同义词**。
- USAGE: 特殊的 "无权限" 权限。



#### 1.1.2 oracle 用户、角色、权限管理

**1、创建用户**

oracle内部有两个建好的用户：system和sys。用户可直接登录到system用户以创建其他用户，因为system具有创建别 的用户的 权限。 在安装oracle时，用户或系统管理员首先可以为自己建立一个用户。

```mysql
语法[创建用户]：  create user 用户名 identified by 口令[即密码]；
例子：  create user test identified by test;

语法[更改用户]:  alter user 用户名 identified by 口令[改变的口令];
例子：  alter user test identified by 123456;
```

**2、删除用户**

```mysql
语法：drop  user 用户名;
例子：drop  user test;
```

若用户拥有对象，则不能直接删除，否则将返回一个错误值。指定关键字cascade,可删除用户所有的对象，然后再删除用户。

```sql
语法：  drop user 用户名 cascade;
例子：  drop user test cascade;
```

**3、授权角色**

oracle为兼容以前版本，提供三种标准角色（role）connect/resource和dba.

（1）connect role(连接角色)

- 临时用户，特指不需要建表的用户，通常只赋予他们connect role. 
- connect是使用oracle简单权限，这种权限只对其他用户的表有访问权限，包括select/insert/update和delete等。
- 拥有connect role 的用户还能够创建表、视图、序列（sequence）、簇（cluster）、同义词(synonym)、回话（session）和其他  数据的链（link）

（2） resource role(资源角色)

- 更可靠和正式的数据库用户可以授予resource role。
- resource提供给用户另外的权限以创建他们自己的表、序列、过程(procedure)、触发器(trigger)、索引(index)和簇(cluster)。 

（3） dba role(数据库管理员角色)

- dba role拥有所有的系统权限
- 包括无限制的空间限额和给其他用户授予各种权限的能力。system由dba用户拥有

```sql
-- 授权命令
语法： grant connect, resource to 用户名;
例子： grant connect, resource to test;

-- 撤销权限
语法： revoke connect, resource from 用户名;
列子： revoke connect, resource from test;
```

 

**4. 创建/授权/删除角色**

除了前面讲到的三种系统角色----connect、resource和dba，用户还可以在oracle创建自己的role。用户创建的role可以由表或系统权限或两者的组合构成。为了创建role，用户必须具有create role系统权限。

（1）创建角色

```mysql
语法： create role 角色名;
例子： create role testRole;
```

（2）授权角色

```mysql
语法： grant select on class to 角色名;
列子： grant select on class to testRole;
```

注：现在，拥有testRole角色的所有用户都具有对class表的select查询权限

（3）删除角色

```mysql
语法： drop role 角色名;
例子： drop role testRole;
```

注：与testRole角色相关的权限将从数据库全部删除




## 二、DQL 语句

### 2.1 基础查询

#### 1.常量查询的区别：

```sql
-- mysql 
select 常量值;

--oracel
select 常量值 from dual;
```

#### 2.字符串拼接

```sql
-- mysql oracle
select concat(字符1，字符2，字符3,...);
```

#### 3.判断字段是否为空

功能：判断某字段或表达式是否为null，如果为null 返回指定的值，否则返回原本的值

```sql
-- mysql
select ifnull(字段名,默认值)  from 表名;

--oracle
select nvl(字段名,默认值)  from 表名;
```

#### 4.查询非空字段

```sql
-- mysql oracle
select 字段名 from 表名 where 字段名 IS NOT NULL;
```



### 2.2 常见函数

#### 1.字符函数

```sql
-- mysql oracle
concat:连接
substr:截取子串
upper:变大写
lower：变小写
replace：替换
length：获取字节长度
trim:去前后空格
lpad：左填充
rpad：右填充
instr:获取子串第一次出现的索引
```

#### 2.数学函数

```mysql
-- mysql -oracle
ceil:向上取整
round：四舍五入
mod:取模
floor：向下取整

-- mysql
truncate:截断
rand:获取随机数，返回0-1之间的小数
-- oracle
trunc:截断
 SELECT DBMS_RANDOM.value(0,1) FROM DUAL;  获取随机数，返回0-1之间的小数
```

#### 3.日期函数

#### 1. oracle 日期函数：

##### 1.1 Oracle 常用的时间格式掩码

| 掩码元素 | 含义                                                 |
| -------- | ---------------------------------------------------- |
| YYYY     | 四位数年份 （如：2005）     year                     |
| YY       | 二位数年份（如  05）                                 |
| Q        | 季度（1-4）                                          |
| MM       | 月份（01-12）      month                             |
| WW       | 年的星期数（1-53），其中第一星期为年的第一天至第七天 |
| W        | 月的星期数（1-5），其中第一星期为月的第一天至第七天  |
| DDD      | 年的日（1-366）                                      |
| DD       | 月的日（1-31）                                       |
| D        | 周的日（1-7），其中周日为1，周六为7    day           |
| HH24     | 24小时制（0-23）     hour                            |
| MI       | 分钟（0-59）     minute                              |
| SS       | 秒（0-59）     second                                |
| SSSSS    | 自午夜之后的秒（0-86399）                            |



##### 1.2 Oracle 获取当前年、月、日

EXTRACT ({ YEAR | MONTH | DAY | HOUR | MINUTE | SECOND } | {  TIMEZONE_HOUR | TIMEZONE_MINUTE } | { TIMEZONE_REGION | TIMEZONE_ABBR }  FROM { date_value | interval_value } ) 

```sql
select extract(year from sysdate)　from dual; --当前年

select extract(month from sysdate) from dual; --本年到当月的月数

select extract(day from sysdate)　from dual; --本月到当日的天数

```



##### 1.3 计算两个时间差

```sql
--天：
ROUND(TO_NUMBER(END_DATE - START_DATE))
--小时：
ROUND(TO_NUMBER(END_DATE - START_DATE) * 24)
--分钟：
ROUND(TO_NUMBER(END_DATE - START_DATE) * 24 * 60)
--秒：
ROUND(TO_NUMBER(END_DATE - START_DATE) * 24 * 60 * 60)
--毫秒：
ROUND(TO_NUMBER(END_DATE - START_DATE) * 24 * 60 * 60 * 60)
```



##### 1.4 日期和字符串转换

```sql
-- 日期到字符串
select sysdate,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual
select sysdate,to_char(sysdate,'yyyy-mm-dd hh:mi:ss') from dual

-- 字符串到日期
select to_date('2018-10-10 10:13:56','yyyy-mm-dd hh24:mi:ss') from dual

```



##### 1.5 日期的加减计算

```sql
--当前时间减去7分钟的时间
select sysdate,sysdate - interval '7' MINUTE from dual;

--当前时间减去7小时的时间
select sysdate - interval '7' hour from dual;

--当前时间减去7天的时间
select sysdate - interval '7' day from dual;

--当前时间减去7月的时间
select sysdate,sysdate - interval '7' month from dual;

--当前时间减去7年的时间
select sysdate,sysdate - interval '7' year from dual;

--时间间隔乘以一个数字
select sysdate,sysdate - 8*interval '7' hour from dual;
```



#### 2.mysql日期函数

##### 2.1 mysql 常用日期格式掩码

|          | 值                                                    | 含义                                              |
| -------- | ----------------------------------------------------- | ------------------------------------------------- |
| 秒       | %S、%s                                                | 两位数字形式的秒（ 00,01, ..., 59）               |
| 分       | %I、%i                                                | 两位数字形式的分（ 00,01, ..., 59）               |
| 小时     | %H                                                    | 24小时制，两位数形式小时（00,01, ...,23）         |
| %h       | 12小时制，两位数形式小时（00,01, ...,12）             |                                                   |
| %k       | 24小时制，数形式小时（0,1, ...,23）                   |                                                   |
| %l       | 12小时制，数形式小时（0,1, ...,12）                   |                                                   |
| %T       | 24小时制，时间形式（HH:mm:ss）                        |                                                   |
| %r       | 12小时制，时间形式（hh:mm:ss AM 或 PM）               |                                                   |
| %p       | AM上午或PM下午                                        |                                                   |
| 周       | %W                                                    | 一周中每一天的名称（Sunday,Monday, ...,Saturday） |
| %a       | 一周中每一天名称的缩写（Sun,Mon, ...,Sat）            |                                                   |
| %w       | 以数字形式标识周（0=Sunday,1=Monday, ...,6=Saturday） |                                                   |
| %U       | 数字表示周数，星期天为周中第一天                      |                                                   |
| %u       | 数字表示周数，星期一为周中第一天                      |                                                   |
| 天       | %d                                                    | 两位数字表示月中天数（01,02, ...,31）             |
| %e       | 数字表示月中天数（1,2, ...,31）                       |                                                   |
| %D       | 英文后缀表示月中天数（1st,2nd,3rd ...）               |                                                   |
| %j       | 以三位数字表示年中天数（001,002, ...,366）            |                                                   |
| 月       | %M                                                    | 英文月名（January,February, ...,December）        |
| %b       | 英文缩写月名（Jan,Feb, ...,Dec）                      |                                                   |
| %m       | 两位数字表示月份（01,02, ...,12）                     |                                                   |
| %c       | 数字表示月份（1,2, ...,12）                           |                                                   |
| 年       | %Y                                                    | 四位数字表示的年份（2015,2016...）                |
| %y       | 两位数字表示的年份（15,16...）                        |                                                   |
| 文字输出 | %文字                                                 | 直接输出文字内容                                  |



##### 2.2 mysql 获取当前年、月、日

- now：返回当前日期+时间
- year:返回年
- month：返回月
- day:返回日
- curdate:返回当前日期
- curtime：返回当前时间
- hour:小时
- minute:分钟
- second：秒



##### 2.3 计算两个时间之差

**2.3.1、利用TO_DAYS函数**

```mysql
select to_days(now()) - to_days('20120512')
```

**2.3.2、利用DATEDIFF函数**

```mysql
select datediff(now(),'20120512')
```

**2.3. 3、利用TIMESTAMPDIFF函数**

计算两日期时间之间相差的天数，秒数，分钟数，周数，小时数，这里主要分享的是通过MySql内置的函数 TimeStampDiff() 实现。函数 TimeStampDiff() 是MySQL本身提供的可以计算两个时间间隔的函数，语法为：

```mysql
TIMESTAMPDIFF(unit,datetime_expr1,datetime_expr2)
```

其中unit单位有如下几种：

- FRAC_SECOND   表示间隔是毫秒
- SECOND   秒
- MINUTE   分钟
- HOUR   小时
- DAY   天
- WEEK   星期
- MONTH   月
- QUARTER   季度
- YEAR   年

```sql
--计算两日期之间相差多少周
select timestampdiff(week,'2011-09-30','2015-05-04');
--计算两日期之间相差多少天
select timestampdiff(day,'2011-09-30','2015-05-04');
```



##### 2.4 日期和字符串转换

```sql
-- 字符串转日期
select str_to_date('2018-12-15 16:44:41','%Y-%m-%d %H:%i:%s');
-- 日期转字符串
select date_format(now(),'%Y-%m-%d %H:%i:%s');
```



##### 2.5 日期的加减计算

MySQL 为日期增加一个时间间隔：date_add()

 MySQL 为日期减去一个时间间隔：date_sub()

```sql
select date_add(now(), interval 1 day); -- 加1天
select date_add(now(), interval 1 hour); --加1小时
select date_add(now(), interval 1 minute); -- 加1分钟
select date_add(now(), interval 1 second); --加1秒
select date_add(now(), interval 1 microsecond);--加1毫秒
select date_add(now(), interval 1 week);--加1周
select date_add(now(), interval 1 month);--加1月
select date_add(now(), interval 1 quarter);--加1季
select date_add(now(), interval 1 year);--加1年
```



#### 4、流程控制函数

##### 4.1 oracle decode函数

**decode(条件,值1,返回值1,值2,返回值2,...值n,返回值n,缺省值)**  

该函数的含义如下：

```mysql
IF 条件=值1 THEN
　　　　RETURN(翻译值1)
ELSIF 条件=值2 THEN
　　　　RETURN(翻译值2)
　　　　......
ELSIF 条件=值n THEN
　　　　RETURN(翻译值n)
ELSE
　　　　RETURN(缺省值)
END IF
```

**decode(字段或字段的运算，值1，值2，值3）**  

这个函数运行的结果是，当字段或字段的运算的值等于值1时，该函数返回值2，否则返回值3，值1，值2，值3也可以是表达式

```sql
-- 比较大小,取较小值 
select decode(sign(变量1-变量2),-1,变量1,变量2) from dual; 
-- sign()函数根据某个值是0、正数还是负数，分别返回0、1、-1 
```



##### 4.2 mysql流程控制函数

1.if(条件表达式，表达式1，表达式2)：如果条件表达式成立，返回表达式1，否则返回表达式2

2.case情况一

```sql
case 变量或表达式或字段
when 常量1 then 值1
when 常量2 then 值2
...
else 值n
end
```

```sql
--运用
select case 字段名
when 条件值1 then 值1
when 条件值2 then 值1
else 其他值
end from 表名
```

3.case情况二

```
case 
when 条件1 then 值1
when 条件2 then 值2
...
else 值n
end
```

#### 5.分页查询

```sql
-- mysql
select 查询列  from 表 limit [offset , ]  size;
-- offset代表的是起始的条目索引，默认从0开始

--oracle
SELECT * FROM  
(  
SELECT A.*, ROWNUM RN  
FROM (SELECT * FROM TABLE_NAME) A  
WHERE ROWNUM <= 40  
)  
WHERE RN >= 21  

```

## 三、DML语句

### 1. 插入语句

##### 1.1 mysql 多行插入

```mysql
-- 方式一
insert into 表名【(字段名,..)】 values(值，..),(值，...),...;

-- 方式二
insert into 表名(字段名,...) values(值,...);
insert into 表名(字段名,...) values(值,...);
insert into 表名(字段名,...) values(值,...);
...
```

##### 1.2 oracle 多行插入

```mysql
INSERT ALL INTO  表 VALUES(各个值)  INTO 表 VALUES (其它值) INTO 表 VALUES(其它值) ....
```



#### 2.多表更新

##### 2.1 mysql 多表更新

```mysql
update 表1 别名 
left|right|inner join 表2 别名 
on 连接条件  
set 字段=值,字段=值 
【where 筛选条件】;
```

##### 2.2 oracle 多表更新

不支持类似mysql 的语法



#### 3. 级联删除

##### 3.1 mysql 级联删除

```mysql
delete 别名1,别名2 from 表1 别名 
inner|left|right join 表2 别名 
on 连接条件
【where 筛选条件】
```

##### 3.2 oracle 级联删除

不支持上面的语法，可以通过以下方式实现

- 创建约束时设定级联删除
- 使用触发器（创建时没有级联删除） 



## 四、DDL语句

### 4.1 数据库操作

#### 4.1 mysql数据库的创建、修改和删除

1、创建库

```sql
create database 【if not exists】 库名【 character set 字符集名】;
```

2、修改库

```sql
alter database 库名 character set 字符集名;
```

3、删除库

```sql
drop database 【if exists】 库名;
```



#### 4.2 oracle 数据库的创建和删除

**1.oracle创建数据库：**

1. 创建两个数据库的文件
2. 创建用户，与上面创建的文件形成映射关系
3. 给用户添加权限

（1）、创建两个数据库的文件（databaseName.dbf 和databaseName_temp.dbf 两个文件）  

```shell
CREATE TABLESPACE monitor LOGGING DATAFILE 'E:\app\owner\oradata\orcl\databaseName.dbf' 
SIZE 100M AUTOEXTEND ON NEXT 32M MAXSIZE 500M EXTENT MANAGEMENT LOCAL;

create temporary tablespace monitor_temp tempfile 'E:\app\owner\oradata\orcl\databaseName_temp.dbf'
size 100m autoextend on next 32m maxsize 500m extent management local;
```

（2）、创建用户，与上面创建的文件形成映射关系

```sql
CREATE USER youUsername IDENTIFIED BY youPassword DEFAULT databaseName monitor TEMPORARY TABLESPACE databaseName_temp;
```

（3）、添加权限

```sql
grant connect,resource,dba to databaseName;
grant create session to databaseName;
```

**2、删除数据库**

```sql
DROP TABLESPACE databaseName INCLUDING CONTENTS AND DATAFILES;
```

**3、删除用户**

```sql
drop user youUsername cascade;
```

**4. 关于权限的说明**

**CONNECT角色：** 是授予最终用户的典型权利，最基本的权力，能够连接到ORACLE数据库中，并在对其他用户的表有访问权限时，做SELECT、UPDATE、INSERT等操作。

- ALTER SESSION --修改会话
- CREATE CLUSTER --建立聚簇
- CREATE DATABASE LINK --建立数据库链接
- CREATE SEQUENCE --建立序列
- CREATE SESSION --建立会话
- CREATE SYNONYM --建立同义词
-  CREATE VIEW --建立视图

**RESOURCE角色：** 是授予开发人员的，能在自己的方案中创建表、序列、视图等。

- CREATE CLUSTER --建立聚簇
- CREATE PROCEDURE --建立过程
- CREATE SEQUENCE --建立序列
- CREATE TABLE --建表
- CREATE TRIGGER --建立触发器
-  CREATE TYPE --建立类型

**DBA角色**，是授予系统管理员的，拥有所有的系统权限



### 4.2 表的管理

#### 4.2.1 创建表 

```sql
-- mysql
create table 【if not exists】 表名(
	字段名 字段类型 【约束】,
	字段名 字段类型 【约束】,
	...
	字段名 字段类型 【约束】 

)

-- oracle
CREATE TABLE [schema.]表名(
    字段名 字段类型 【约束】
	字段名 字段类型 【约束】,
	...
	字段名 字段类型 【约束】 
);

```

##### 1. oracle 字段类型

| 数据类型       | 描述                                   |
| -------------- | -------------------------------------- |
| VARCHAR2(size) | 可变长字符数据                         |
| CHAR(size)     | 定长字符数据                           |
| NUMBER(p,s)    | 可变长数值数据，P为整数位，S为小数位   |
| DATE           | 日期型数据                             |
| LONG           | 可变长字符数据，最大可达到2G           |
| CLOB           | 字符数据，最大可达到4G                 |
| ROWID          | 行地址                                 |
| RAW (LONG RAW) | 原始的二进制数据                       |
| BLOB           | 二进制数据，最大可达到4G               |
| BFILE          | 存储外部文件的二进制数据，最大可达到4G |

##### 2. mysql 字段类型

（1）数值类型：

| 类型         | 大小                                     | 范围（有符号）                                               | 范围（无符号）                                               | 用途            |
| ------------ | ---------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------------- |
| TINYINT      | 1 字节                                   | (-128，127)                                                  | (0，255)                                                     | 小整数值        |
| SMALLINT     | 2 字节                                   | (-32 768，32 767)                                            | (0，65 535)                                                  | 大整数值        |
| MEDIUMINT    | 3 字节                                   | (-8 388 608，8 388 607)                                      | (0，16 777 215)                                              | 大整数值        |
| INT或INTEGER | 4 字节                                   | (-2 147 483 648，2 147 483 647)                              | (0，4 294 967 295)                                           | 大整数值        |
| BIGINT       | 8 字节                                   | (-9 233 372 036 854 775 808，9 223 372 036 854 775 807)      | (0，18 446 744 073 709 551 615)                              | 极大整数值      |
| FLOAT        | 4 字节                                   | (-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38) | 0，(1.175 494 351 E-38，3.402 823 466 E+38)                  | 单精度 浮点数值 |
| DOUBLE       | 8 字节                                   | (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 双精度 浮点数值 |
| DECIMAL      | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值                                               | 依赖于M和D的值                                               | 小数值          |

（2）日期和时间类型

| 类型      | 大小 (字节) | 范围                                                         | 格式                | 用途                     |
| --------- | ----------- | ------------------------------------------------------------ | ------------------- | ------------------------ |
| DATE      | 3           | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME      | 3           | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR      | 1           | 1901/2155                                                    | YYYY                | 年份值                   |
| DATETIME  | 8           | 1000-01-01 00:00:00/9999-12-31 23:59:59                      | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| TIMESTAMP | 4           | 1970-01-01 00:00:00/2038   结束时间是第 **2147483647** 秒，北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 | YYYYMMDD HHMMSS     | 混合日期和时间值，时间戳 |

  （3）字符串类型

| 类型       | 大小                | 用途                            |
| ---------- | ------------------- | ------------------------------- |
| CHAR       | 0-255字节           | 定长字符串                      |
| VARCHAR    | 0-65535 字节        | 变长字符串                      |
| TINYBLOB   | 0-255字节           | 不超过 255 个字符的二进制字符串 |
| TINYTEXT   | 0-255字节           | 短文本字符串                    |
| BLOB       | 0-65 535字节        | 二进制形式的长文本数据          |
| TEXT       | 0-65 535字节        | 长文本数据                      |
| MEDIUMBLOB | 0-16 777 215字节    | 二进制形式的中等长度文本数据    |
| MEDIUMTEXT | 0-16 777 215字节    | 中等长度文本数据                |
| LONGBLOB   | 0-4 294 967 295字节 | 二进制形式的极大文本数据        |
| LONGTEXT   | 0-4 294 967 295字节 | 极大文本数据                    |

#### 4.2.2 修改表

1.添加列

```sql
-- mysql
alter table 表名 add column 列名 类型 【default 值】 【first|after 字段名】;

-- oracle
alter table 表名 add 列名 类型 【default 值】【not null】；
```

2.修改列的类型或约束

```sql
-- mysql
alter table 表名 modify column 列名 新类型 【新约束】;

-- oracle
alter table 表名 modify (列名 新类型 【新约束】);
```

3.修改列名

```mysql
-- mysql
alter table 表名 change column 旧列名 新列名 类型;

-- oracle
alter table 表名 rename column 旧列名 to 新列名;
```

4 .删除列

```sql
-- mysql oracle
alter table 表名 drop column 列名;
```

5.修改表名

```
-- mysql oracle
alter table 表名 rename to 新表名;
```

#### 4.2.3 删除表

```mysql
-- mysql
drop table【if exists】 表名;

-- oracle
drop table 表名;
```

#### 4.2.4 复制表

1、复制表的结构

```sql
-- mysql
create table 表名 like 旧表;

-- oracle
create table 表名 as select * from 旧表 where 1=2;
```

2、复制表的结构+数据

```mysql
-- mysql oracle
create table table_name_new as select * from table_name_old【where 筛选】;
```

3 、只复制数据

```sql
-- mysql oracle

-- 两个表结构一样
insert into 表1 select * from  表2;

-- 两个表的结构不一样，只复制部分列
insert into 表1(column1,column2,column3) select column1x,column2x,column3x from 表2;

```



### 4.3 约束

#### 4.3.1 常见的约束

- NOT NULL：非空，该字段的值必填
- UNIQUE：唯一，该字段的值不可重复
- DEFAULT：默认，该字段的值不用手动插入有默认值
- CHECK：检查，mysql不支持
- PRIMARY KEY：主键，该字段的值不可重复并且非空  unique+not null
- FOREIGN KEY：外键，该字段的值引用了另外的表的字段

注：主键和唯一约束区别

- 一个表至多有一个主键，但可以有多个唯一
- 主键不允许为空，唯一可以为空



#### 4.3.2 创建表时添加约束

```sql
create table 表名(
	字段名 字段类型 not null,#非空
	字段名 字段类型 primary key,#主键
	字段名 字段类型 unique,#唯一
	字段名 字段类型 default 值,#默认
	constraint 约束名 foreign key(字段名) references 主表（被引用列）
)

```

#### 4.3.3 修改表时添加或删除约束

```sql
--1、非空约束
    -- mysql
        -- 添加非空
        alter table 表名 modify column 字段名 字段类型 not null;
        -- 删除非空
        alter table 表名 modify column 字段名 字段类型 ;
    -- oracle
        -- 添加非空
        alter table 表名 modify 字段名  not null;
        -- 删除非空
        alter table 表名 modify 字段名 ;


-- 2、默认约束
   -- mysql
        -- 添加默认
        alter table 表名 modify column 字段名 字段类型 default 默认值
        -- 删除默认
        alter table 表名 modify column 字段名 字段类型 ;
   -- oracle
	-- 添加默认
	alter table 表名 modify 字段名 default 默认值;
        -- 删除默认
        alter table 表名 modify 字段名 ;


-- 3、主键约束 (oracle mysql)
     -- 添加主键
    alter table 表名 add【 constraint 约束名】 primary key(字段名);
     -- 删除主键
    alter table 表名 drop primary key;

-- 4、唯一约束 (oracle mysql)
     -- 添加唯一
    alter table 表名 add【 constraint 约束名】 unique(字段名);
     -- 删除唯一
    alter table 表名 drop index 索引名;

-- 5、外键约束 (oracle mysql)
     --添加外键
    alter table 表名 add【 constraint 约束名】 foreign key(字段名) references 主表（被引用列）;
     --删除外键
    alter table 表名 drop foreign key 约束名;

```

#### 4.3.4 自增长列(mysql)

- 不用手动插入值，可以自动提供序列值，默认从1开始，步长为1
- 一个表至多有一个自增长列
- 自增长列只能支持数值型
- 自增长列必须为一个key

```sql
-- 创建表时设置自增长列
create table 表(
	字段名 字段类型 约束 auto_increment
)

-- 修改表时设置自增长列
alter table 表 modify column 字段名 字段类型 约束 auto_increment

-- 删除自增长列
alter table 表 modify column 字段名 字段类型 约束 
```

#### 4.3.5 序列(oracle)

oracle 没有自增长列，可以使用序列实现

**1.创建序列**

```sql
  CREATE SEQUENCE sequence  //创建序列名称
       [INCREMENT BY n]  //递增的序列值是n 如果n是正数就递增,如果是负数就递减 默认是1
       [START WITH n]    //开始的值,递增默认是minvalue 递减是maxvalue
       [{MAXVALUE n | NOMAXVALUE}] //最大值
       [{MINVALUE n | NOMINVALUE}] //最小值
       [{CYCLE | NOCYCLE}] //循环/不循环
       [{CACHE n | NOCACHE}];//分配并存入到内存中
```

使用CACHE选项时，该序列会根据序列规则预生成一组序列号。保留在内存中，当使用下一个序列号时，可以更快的响应。当内存中的序列号用完时，系统再生成一组新的序列号，并保存在缓存中，这样可以提高生成序列号的效率。Oracle默认会生产20个序列号。

**2.修改序列**

```sql
  alter SEQUENCE sequence  //创建序列名称
       [INCREMENT BY n]  //递增的序列值是n 如果n是正数就递增,如果是负数就递减 默认是1
       [START WITH n]    //开始的值,递增默认是minvalue 递减是maxvalue
       [{MAXVALUE n | NOMAXVALUE}] //最大值
       [{MINVALUE n | NOMINVALUE}] //最小值
       [{CYCLE | NOCYCLE}] //循环/不循环
       [{CACHE n | NOCACHE}];//分配并存入到内存中
```

**3.删除序列**

```
DROP SEQUENCE sequence
```

**4.使用序列**

```sql
insert into 表名（字段,..） values(sequence.nextval,...);
```



#### 4.3.6 级联操作

```sql
-- oracle mysql
-- 级联删除
ALTER TABLE 表名 ADD CONSTRAINT 约束名 FOREIGN KEY(外键列列名) REFERENCES 关联表(列名) ON DELETE CASCADE;
-- 级联置空
ALTER TABLE 表名 ADD CONSTRAINT 约束名 FOREIGN KEY(外键列列名) REFERENCES 关联表(列名) ON DELETE SET NULL;
```



## 五、TCL语言

### 5.1 事务

#### 5.1.1 事务隔离级别

| 隔离级别                    | 脏读 | 不可重复读 | 幻读 |
| --------------------------- | ---- | ---------- | ---- |
| Read uncommitted(读未提交)  | 是   | 是         | 是   |
| Read committed（读已提交）  | 否   | 是         | 是   |
| Repeatable read（可重复读） | 否   | 否         | 是   |
| Serializable（串行读）      | 否   | 否         | 否   |

**1.设置事务隔离级别**

```sql
-- mysql oracle
SET [SESSION|GLOBAL] TRANSACTION ISOLATION LEVEL [READ UNCOMMITTED|READ COMMITTED|REPEATABLE READ|SERIALIZABLE]
```

**2.查看事务隔离级别**

(1 )**mysql**默认的事务处理级别是 REPEATABLE-READ,也就是可重复读

```sql
-- mysql
-- 1.查看当前会话隔离级别
select @@tx_isolation;

-- 2.查看系统当前隔离级别
select @@global.tx_isolation;
```

(2) **oracle**数据库支持READ COMMITTED 和 SERIALIZABLE这两种事务隔离级别。默认系统事务隔离级别是READ COMMITTED,也就是读已提交。

```sql
--查看系统默认事务隔离级别,也是当前会话隔离级别
--1.首先创建一个事务
declare
     trans_id Varchar2(100);
  begin
     trans_id := dbms_transaction.local_transaction_id( TRUE );
  end; 

--2.查看事务隔离级别
SELECT s.sid, s.serial#,

　　CASE BITAND(t.flag, POWER(2, 28))
　　　　WHEN 0 THEN 'READ COMMITTED'
　　　　ELSE 'SERIALIZABLE'
　　END AS isolation_level
FROM v$transaction t
JOIN v$session s ON t.addr = s.taddr AND s.sid = sys_context('USERENV', 'SID');


```

**3.基本事务操作**

- 开启事务：start transaction

- 使用回滚点名：savepoint 回滚点
- 提交事务：commit;
- 回滚事务：rollback;
- 回滚到指定的地方：rollback to 回滚点名;



## 六、其他扩展

### 6.1 视图

**1. 创建视图**

```sql
CREATE [OR REPLACE] [{FORCE|NOFORCE}] VIEW view_name
AS
SELECT查询
[WITH READ ONLY CONSTRAINT]
```

- **OR REPLACE**：如果视图已经存在，则替换旧视图。
- **FORCE**：即使基表不存在，也可以创建该视图，但是该视图不能正常使用，当基表创建成功后，视图才能正常使用。
- **NOFORCE**：如果基表不存在，无法创建视图，该项是默认选项。
- **WITH READ  ONLY**：默认可以通过视图对基表执行增删改操作，WITH  READ ONLY说明视图是只读视图。



**2. 删除视图**

```sql
drop view 视图;
```



**3.查看所有视图**

```sql
-- mysql
show table status where comment='view';

-- oracle
select * from dba_tab_privs  --查看所有视图
[all_tab_cols / all_tab_columns]--查看所有用户下的表及视图结构
[user_tab_cols / user_tab_columns] --查看当前用户下的表及视图结构
[user_col_comments] --查看当前用户下表及视图中字段名称及字段注释
[all_col_comments]  --查看所以用户下表及视图中字段名称及字段注释
```



**4.查看单个视图**

```sql
-- mysql
show create view hy_account_hospital_view;

-- oracle
select text from user_views where view_name='view_name';
```



### 6.2 触发器

**1.基本语法**

```sql
-- 创建触发器
CREATE TRIGGER 触发器名 BEFORE|AFTER 触发事件
ON 表名 FOR EACH ROW
[BEGIN]
    执行语句列表
    执行语句列表
    ...
[END]

-- 删除触发器
DROP TRIGGER [IF EXISTS] [schema_name.]触发器名

-- 查看触发器
SHOW TRIGGERS [FROM schema_name];
```

**MySQL支持创建以下六种触发器：**

- 
  BEFORE INSERT,
- BEFORE DELETE,
- BEFORE UPDATE
- AFTER INSERT,
- AFTER DELETE,
- AFTER UPDATE

**在触发器内部语句中，可以引用NEW和OLD两张虚拟表：**

- 在 INSERT 型触发器中，NEW 用来表示将要（BEFORE）或已经（AFTER）插入的新数据；
- 在 UPDATE 型触发器中，OLD 用来表示将要或已经被修改的原数据，NEW 用来表示将要或已经修改为的新数据；
- 在 DELETE 型触发器中，OLD 用来表示将要或已经被删除的原数据；
- 使用方法： [NEW|OLD].columnName 

注：oracle使用 :NEW 和 : OLD来引用 这两张虚拟表，mysql则直接使用NEW和OLD



### 6.3 存储过程

#### 6.3.1 创建存储过程

```sql
DELIMITER //
CREATE PROCEDURE  过程名([[IN|OUT|INOUT] 参数名 数据类型],...)
	BEGIN
      过程体
    END
DELIMITER ; 
                       
--调用
call([参数名])                       
```

- **IN**参数的值必须在调用存储过程时指定，在存储过程中修改该参数的值不能被返回，为默认值  
- **OUT**:该值可在存储过程内部被改变，并可返回  
- **INOUT**:调用时指定，并且可被改变和返回

#### 6.3.2变量

声明：DECLARE 变量名1[,变量名2...] 数据类型 [默认值]; 

赋值：SET 变量名 = 变量值 [,变量名= 变量值 ...]

用户变量一般以@开头



#### 6.3.3 存储过程的查询

```sql
--查询存储过程
SELECT name FROM mysql.proc WHERE db='数据库名';
SELECT routine_name FROM information_schema.routines WHERE routine_schema='数据库名';
SHOW PROCEDURE STATUS WHERE db='数据库名';
```

```sql
-- 查看存储过程详细信息
SHOW CREATE PROCEDURE 数据库.存储过程名;
 
```

#### 6.3.4 存储过程的修改

ALTER PROCEDURE 更改用CREATE PROCEDURE 建立的预先指定的存储过程，其不会影响相关存储过程或存储功能。

```sql
ALTER {PROCEDURE | FUNCTION} sp_name [characteristic ...]
characteristic:
{ CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
| SQL SECURITY { DEFINER | INVOKER }
| COMMENT 'string'
```

- sp_name参数表示存储过程或函数的名称；  
- characteristic参数指定存储函数的特性。  
- CONTAINS SQL表示子程序包含SQL语句，但不包含读或写数据的语句；  
- NO SQL表示子程序中不包含SQL语句；  
- READS SQL DATA表示子程序中包含读数据的语句；  
- MODIFIES SQL DATA表示子程序中包含写数据的语句。  
- SQL SECURITY { DEFINER | INVOKER }指明谁有权限来执行，DEFINER表示只有定义者自己才能够执行；INVOKER表示调用者可以执行。  
- COMMENT 'string'是注释信息。

```sql
-- 将读写权限改为MODIFIES SQL DATA，并指明调用者可以执行。
ALTER  PROCEDURE  num_from_employee
  MODIFIES SQL DATA
  SQL SECURITY INVOKER ;
-- 将读写权限改为READS SQL DATA，并加上注释信息'FIND NAME'。
ALTER  PROCEDURE  name_from_employee
  READS SQL DATA
  COMMENT 'FIND NAME' ;
 
```

#### 6.3.5 存储过程的删除

```sql
DROP PROCEDURE [过程1[,过程2…]]
```

#### 6.3.6 条件语句

##### 1.分支结构

**（1）case结构**

```mysql
case 表达式或字段
when 值1 then 语句1;
when 值2 then 语句2；
..
else 语句n;
end [case];

语法2：
case 
when 条件1 then 语句1;
when 条件2 then 语句2；
..
else 语句n;
end [case];
```

**（2）if 结构**

```mysql
if 条件1 then 语句1;
elseif 条件2 then 语句2;
...
else 语句n;
end if;
```



##### 2.循环结构

（1）while

```sql
【名称:】while 循环条件 do
		循环体
end while 【名称】;
```


（2）loop

```sql
【名称：】loop
		循环体
end loop 【名称】;
```

（3）repeat

```sql
【名称:】repeat
		循环体
until 结束条件 
end repeat 【名称】;
```

结束循环：

- leave：类似于break，用于跳出所在的循环
- iterate：类似于continue，用于结束本次循环，继续下一次

对比：

- 这三种循环都可以省略名称，但如果循环中添加了循环控制语句（leave或iterate）则必须添加名称

- loop 一般用于实现简单的死循环

- while 先判断后执行

- repeat 先执行后判断，无条件至少执行一次




### 6.4 游标

#### 6.4.1 游标简介

游标的设计是一种数据缓冲区的思想，用来存放SQL语句执行的结果。游标是一种能从包括多条数据记录的结果集中每次提取一条记录的机制。
尽管游标能遍历结果中的所有行，但一次只指向一行。
游标的作用就是用于对查询数据库所返回的记录进行遍历，以便进行相应的操作。

#### 6.4.2 游标的特性

游标具有三个属性：

1. 不敏感（Asensitive）：数据库可以选择不复制结果集
2. 只读（Read only）
3. 不滚动（Nonscrollable）：游标只能向一个方向前进，并且不可以跳过任何一行数据。

#### 6.4.3 游标的操作

**1、游标的定义**

```
DECLARE cursor_name CURSOR FOR select_statement  
```

**2、打开游标**

```
OPEN cursor_name;
```

**3、取游标中的数据**

```
FETCH cursor_name INTO var_name [, var_name]...
```

**4、关闭游标**

```
CLOSE cursor_name;
```

**5、释放游标**

```
DEALLOCATE cursor_name;
```



## 参考资料

+ [Oracle创建用户、角色、授权、建表](https://www.cnblogs.com/roger112/p/7685307.html)
+ [MYSQL存储过程](https://www.cnblogs.com/mark-chan/p/5384139.html)
+ [MySQL数据库高级（九）——游标](http://blog.51cto.com/9291927/2097626)




