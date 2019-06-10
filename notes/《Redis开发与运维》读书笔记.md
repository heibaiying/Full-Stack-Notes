# 《Redis开发与运维》读书笔记

## 目录<br/>
<a href="#第二章-API的理解与使用">第二章 API的理解与使用</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-预备">2.1 预备</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#211-全局命令">2.1.1 全局命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#212-数据结构和内部编码">2.1.2 数据结构和内部编码</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#213-单线程架构">2.1.3 单线程架构</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-字符串">2.2 字符串</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-哈希">2.3 哈希</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-列表">2.4 列表</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#25-集合">2.5 集合</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#26-有序集合">2.6 有序集合</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#27-键管理">2.7 键管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#271-单个键管理">2.7.1 单个键管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1键重命名">1.键重命名  </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-随机返回键">2. 随机返回键 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3键过期">3.键过期</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#272-键遍历">2.7.2 键遍历</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-全量键遍历">1. 全量键遍历</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-渐进式遍历">2. 渐进式遍历</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#273-数据库管理">2.7.3 数据库管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1切换数据库">1.切换数据库</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2flushdb/flushall">2.flushdb/flushall </a><br/>
<a href="#第三章-小功能-大用处">第三章 小功能 大用处</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-慢查询分析">3.1 慢查询分析</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#311-慢查询的两个配置参数">3.1.1 慢查询的两个配置参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-redis-shell">3.2 redis shell</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#321-redis-cli">3.2.1 redis-cli</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#322-redis-server">3.2.2 redis-server</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#323-redis-benchmark">3.2.3 redis-benchmark</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-Pipeline">3.3 Pipeline</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-事务与Lua">3.4 事务与Lua</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#35-Bitmaps">3.5 Bitmaps</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#36-HyperLogLog">3.6 HyperLogLog</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#37-发布订阅">3.7 发布订阅</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#38-GEO">3.8 GEO</a><br/>
<a href="#第四章-客户端">第四章 客户端</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#44-客户端管理">4.4 客户端管理</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#441-客户端API">4.4.1 客户端API</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#442-客户端相关配置">4.4.2 客户端相关配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#443-客户端统计片段">4.4.3 客户端统计片段</a><br/>
<a href="#第五章-持久化">第五章 持久化</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-RDB">5.1 RDB</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-AOF">5.2 AOF</a><br/>
<a href="#第六章-复制">第六章 复制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-配置">6.1 配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#611-建立复制">6.1.1 建立复制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#612-断开复制">6.1.2 断开复制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#613-传输延迟">6.1.3 传输延迟</a><br/>
<a href="#第十章-集群">第十章 集群</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#101-数据分区">10.1 数据分区</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#102-搭建集群">10.2 搭建集群</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#104--集群扩容">10.4  集群扩容</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1042-扩容集群">10.4.2 扩容集群</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1043-收缩集群">10.4.3 收缩集群</a><br/>
<a href="#附[CacheCloud-GitHub]https//githubcom/sohutv/cachecloud">附：[CacheCloud GitHub](https://github.com/sohutv/cachecloud)</a><br/>
## 正文<br/>


## 第二章 API的理解与使用

### 2.1 预备

#### 2.1.1 全局命令

1. 查看所有键： **keys \*** 

2. 查看键总数：**dbsize**  

3. 检查键是否存在：**exists key**

4. 删除键：**del key [key ...]**   支持删除多个键

5. 键过期：**expire key seconds**

   ttl命令会返回键的剩余过期时间， 它有3种返回值：

   - 大于等于0的整数： 键剩余的过期时间。
   - -1： 键没设置过期时间。
   - -2： 键不存在 

6. 键的数据结构 **type key**

#### 2.1.2 数据结构和内部编码

type命令实际返回的就是当前键的数据结构类型， 它们分别是：**string**（字符串） 、 **hash**（哈希） 、 **list**（列表） 、 **set**（集合） 、 **zset**（有序集合） 

#### 2.1.3 单线程架构

1. 纯内存访问， Redis将所有数据放在内存中， 内存的响应时长大约为100纳秒， 这是Redis达到每秒万级别访问的重要基础。
2. 非阻塞I/O， Redis使用epoll作为I/O多路复用技术的实现， 再加上Redis自身的事件处理模型将epoll中的连接、 读写、 关闭都转换为事件， 不在网络I/O上浪费过多的时间， 如图2-6所示。 
3. 单线程避免了线程切换和竞态产生的消耗。 

### 2.2 字符串

| 作用                   | 格式                                                         | 参数或示例                                                   |
| ---------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 设置值                 | set key value \[ex seconds]\[px milliseconds][nx\|xx] setnx setex | ex seconds： 为键设置秒级过期时间。 <br/>px milliseconds： 为键设置毫秒级过期时间。<br/>nx： 键必须不存在， 才可以设置成功， 用于添加。<br/>xx： 与nx相反， 键必须存在， 才可以设置成功， 用于更新。 |
| 获取值                 | get key                                                      | r如果获取的键不存在 ，则返回nil(空)                          |
| 批量设置               | mset key value [key value ...]                               | mset a 1 b 2 c 3 d 4                                         |
| 批量获取值             | mget key [key ...]                                           | mget a b c d                                                 |
| 计数                   | incr key decr key incrby key increment（指定数值自增）<br/>decrby key decrement（指定数值自减）<br/>incrbyfloat key increment （浮点数自增） | 值不是整数， 返回错误。 值是整数， 返回自增或自减后的结果。<br/>键不存在，创建键，并按照值为0自增或自减， 返回结果为1。 |
| 追加值                 | append key value                                             | 向字符串的默认追加值                                         |
| 字符串长度             | strlen key                                                   | 获取字符串长度，中文占用三个字节                             |
| 设置并返回原值         | getset key value                                             |                                                              |
| 设置指定位置的租字符串 | setrange key offeset value                                   |                                                              |
| 获取部分字符串         | getrange key start end                                       |                                                              |

### 2.3 哈希

| 作用                      | 格式                                                         | 参数或示例                                                   |
| ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 设置值                    | hset key field value                                         | hset user:1 name tom<br/>hset user:1 age 12                  |
| 获取值                    | hget key field                                               | hget user:1 name                                             |
| 删除field                 | hdel key field [field ...]                                   |                                                              |
| 计算field个数             | hlen key                                                     |                                                              |
| 批量设置或获取field-value | hmget key field [field]<br/>hmset key field value [field value...] | hmset user:1 name mike age 12 city tianjin<br/>hmget user:1 name city |
| 判断field是否存在         | hexists key field                                            |                                                              |
| 获取所有field             | hkeys key                                                    |                                                              |
| 获取所有value             | hvals key                                                    |                                                              |
| 获取所有的filed-value     | hgetall key                                                  | 如果哈希元素个数比较多， 会存在阻塞Redis的可能。<br/>获取全部 可以使用hscan命令， 该命令会渐进式遍历哈希类型 |
| 计数                      | hincrby key field<br/>hincrbyfloat key field                 |                                                              |

### 2.4 列表

| 作用     | 格式                                                         | 参数或示例                                                   |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 增       | 左侧插入：lpush key value [value ...] <br/>右侧插入：rpush key value [value ...] <br/>某个指定元素前后插入：linsert key before\|after pivot value |                                                              |
| 查       | 获取指定范围内的元素列表：lrange key start end <br/>获取列表指定索引下标的元素：lindex key index <br/>获取列表指定长度：llen key | lrange listkey 0 -1                                          |
| 删       | 从列表左侧弹出元素：lpop key <br/>从列表右侧弹出元素：rpop key <br/>删除指定元素：lrem key count value <br/>截取列表：ltrim key start end | count>0， 从左到右， 删除最多count个元素。<br/>count<0， 从右到左， 删除最多count绝对值个元素。<br/>count=0， 删除所有 |
| 改       | 修改指定索引下标的元素：lset key index newValue              |                                                              |
| 阻塞操作 | blpop key [key ...] timeout <br/>brpop key [key ...] timeout | key[key...]： 多个列表的键。 timeout： 阻塞时间\|等待时间（单位： 秒） |



### 2.5 集合

集合（set） 类型也是用来保存多个的字符串元素， 但和列表类型不一样的是， **集合中不允许有重复元素**， 并且集合中的元素是无序的， **不能通过索引下标获取元素**。  

**集合内操作**：

| 作用                 | 格式                           | 参数或示例                                |
| -------------------- | ------------------------------ | ----------------------------------------- |
| 添加元素             | sadd key element [element ...] | 返回结果为添加成功的元素个数              |
| 删除元素             | srem key element [element ...] | 返回结果为成功删除的元素个数              |
| 计算元素个数         | scard key                      |                                           |
| 判断元素是否在集合中 | sismember key element          |                                           |
| 随机返回             | srandmember key [count]        | 随机从集合返回指定个数元素，count 默认为1 |
| 从集合随机弹出元素   | spop key                       | srandmember 不会从集合中删除元素，spop 会 |
| 获取集合中所有元素   | smembers key                   | 可用sscan 代替                            |

**集合间操作**：

| 作用                         | 格式                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| 求多个集合的交集             | sinter key [key ...]                                         |
| 求多个集合的并集             | suinon key [key ...]                                         |
| 求多个集合的差集             | sdiff key [key ...]                                          |
| 将交集、并集、差集的结果保存 | sinterstore destination key [key ...] <br/>suionstore destination key [key ...]<br/>sdiffstore destination key [key ...] |

### 2.6 有序集合

有序集合中的元素可以排序。 但是它和列表使用索引下标作为排序依据不同的是， 它给每个元素设置一个分数（score） 作为排序的依据。  

**集合内操作**：

| 作用                     | 格式                                                         | 参数或示例                                                   |
| ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 添加成员                 | zadd key score member [score member ...]                     | nx： member必须不存在， 才可设置成功， 用于添加。<br> xx： member必须存在， 才可以设置成功， 用于更新。<br/>ch： 返回此次操作后， 有序集合元素和分数发生变化的个数<br/>incr： 对score做增加， 相当于后面介绍的zincrby。 |
| 计算成员个数             | zcard key                                                    |                                                              |
| 计算某个成员的分数       | zscore key member                                            |                                                              |
| 计算某个成员的排名       | zrank key member  zrevrank key member                        | zrank是从分数从低到高返回排名， zrevrank反之。               |
| 删除成员                 | zrem key member [member ...]                                 |                                                              |
| 增加成员分数             | zincrby key increment member                                 | zincrby user:ranking 9 tom                                   |
| 返回指定排名范围的成员   | zrange key start end [withscores] zrange key start end [withscores] | zrange是从低到高返回， zrevrange反之。                       |
| 返回指定分数范围内的成员 | zrangebyscore key min max \[withscores][limit offset count] <br/>zrevrangebyscore key max min \[withscores][limit offset count] | 其中zrangebyscore按照分数从低到高返回， zrevrangebyscore反之。 [limit offset count]选项可以限制输出的起始位置和个数： 同时min和max还支持开区间（小括号） 和闭区间（中括号） ， -inf和+inf分别代表无限小和无限大 |
| 删除指定排名内的升序元素 | zremrangerank key start end                                  |                                                              |
| 删除指定分数范围的成员   | zremrangebyscore key min max                                 |                                                              |

**集合间操作**：

| 作用 | 格式                                                         |
| ---- | ------------------------------------------------------------ |
| 交集 | zinterstore destination numkeys key \[key ...]  [weights weight [weight ...]] \[aggregate sum\|min\|max] |
| 并集 | zunionstore destination numkeys key \[key ...] [weights weight [weight ...]] \[aggregate sum\|min\|max] |

- destination： 交集计算结果保存到这个键。
- numkeys： 需要做交集计算键的个数。
- key[key...]： 需要做交集计算的键。 
- weights weight[weight...]： 每个键的权重， 在做交集计算时， 每个键中的每个member会将自己分数乘以这个权重， 每个键的权重默认是1。
- aggregate sum|min|max： 计算成员交集后， 分值可以按照sum（和） 、min（最小值） 、 max（最大值） 做汇总， 默认值是sum。 

### 2.7 键管理

#### 2.7.1 单个键管理

##### 1.键重命名  

**rename key newkey** 

 为了防止被强行rename， Redis提供了renamenx命令， 确保只有newKey不存在时候才被覆盖。

##### 2. 随机返回键 

 **random  key**

##### 3.键过期

- expire key seconds： 键在seconds秒后过期。
- expireat key timestamp： 键在秒级时间戳timestamp后过期。 
- pexpire key milliseconds： 键在milliseconds毫秒后过期。
- pexpireat key milliseconds-timestamp键在毫秒级时间戳timestamp后过期 

注意：

1. 如果expire key的键不存在， 返回结果为0 
2. 如果设置过期时间为负值， 键会立即被删除， 犹如使用del命令一样 
3. persist  key  t命令可以将键的过期时间清除 
4. 对于字符串类型键， 执行set命令会去掉过期时间， 这个问题很容易在开发中被忽视 
5. Redis不支持二级数据结构（例如哈希、 列表） 内部元素的过期功能， 例如不能对列表类型的一个元素做过期时间设置
6. setex命令作为set+expire的组合， 不但是原子执行， 同时减少了一次网络通讯的时间  

#### 2.7.2 键遍历

##### 1. 全量键遍历

**keys pattern** 

##### 2. 渐进式遍历

scan cursor \[match pattern] \[count number] 

- cursor是必需参数， 实际上cursor是一个游标， 第一次遍历从0开始， 每次scan遍历完都会返回当前游标的值， 直到游标值为0， 表示遍历结束。
- match pattern是可选参数， 它的作用的是做模式的匹配， 这点和keys的模式匹配很像。
- count number是可选参数， 它的作用是表明每次要遍历的键个数， 默认值是10， 此参数可以适当增大。 

#### 2.7.3 数据库管理

##### 1.切换数据库

**select dbIndex**

##### 2.flushdb/flushall 

flushdb/flushall命令用于清除数据库， 两者的区别的是flushdb只清除当前数据库， flushall会清除所有数据库。 



## 第三章 小功能 大用处

### 3.1 慢查询分析

#### 3.1.1 慢查询的两个配置参数

```shell
# 设置慢查询阈值 耗时高于阈值的操作将被记录
config set slowlog-log-slower-than 20000
# 设置慢查询维护日志的记录长度
config set slowlog-max-len 1000
# 将配置持久化到本地配置文件
config rewrite  

# 获取慢查询日志
slowlog get [n]
# 获取慢查询日志当前的长度
slowlog len
# 慢查询日志重置
slowlog reset
```



### 3.2 redis shell

#### 3.2.1 redis-cli

```shell
# 1. -r （repeat）选项代表将执行多次命令
redis-cli -r 3 ping

# 2. -i (interval) 选项代表每隔几秒执行一次命令
redis-cli -r 5 -i 1 ping

# 3. -x 选项代表从标准输入（stdin）读取数据作为redis-cli 的最后一个参数
echo "world" | redis-cli -x set hello

# 4. --salve 选项是把当前客户端模拟成当前Redis节点的从节点，可以用来获取当前Redis节点的更新操作
redis-cli --salve

# 5. --stat 选项可以实时获取Redis的重要统计信息
redis-cli --stat

# --no-raw 选项要求命令的返回结果必须是原始的格式
# --raw 返回格式化之后的结果
$ redis-cli set hello "你好"
$ redis-cli get hello
 "\xe4\xbd\xa0\xe5\xa5\xbd"
$redis-cli --no-raw get hello
 "\xe4\xbd\xa0\xe5\xa5\xbd"
$redis-cli --raw get hello 
 你好
```

#### 3.2.2 redis-server

```shell
# --test-memory 选项用来检测当前操作系统能否稳定地分配指定容量给Redis
redis-server --test-memory 1024
```

#### 3.2.3 redis-benchmark

```shell
# 1. -c (client) 选项代表客户端的并发数量（默认是50）
# 2. -n (num）选项代表客户端请求总量（默认是100000）
redis-benchmark -c 100 -n 20000  代表100个客户端同时请求Redis,一共执行20000次

# 3.-q 选项仅仅显示 redis-benchmark 的 requests per second 信息
redis-benchmark -c 100 -n 20000 -g

# 4.-r 执行 redis-benchmark 的时候插入更多随机的键
redis-benchmark -c 100 -n 20000 -r 10000
# -r 选项会在key,count键上加一个12位的后缀，-r 10000 代表只对后四位做随机处理（-r 不是随机数的个数）

# 5.-P选项代表每个请求pipeline的数据量（默认为1）

# 6.-k<boolean>
# -k 选项代表客户端是否使用keepalive,1为使用，0为不使用，默认值为 1。

# 7.-t 选项可以对指定命令进行基准测试
redis-benchmark -t get,set -q

# 8.--csv 选项会将结果按照csv格式输出，便于后续处理
```



### 3.3 Pipeline

原生批量命令与Pipeline对比 :

- 原生批量命令是原子的， Pipeline是非原子的。
- 原生批量命令是一个命令对应多个key， Pipeline支持多个命令。
- 原生批量命令是Redis服务端支持实现的， 而Pipeline需要服务端和客户端的共同实现。 



### 3.4 事务与Lua

1. **multi**命令代表事务开始， **exec**命令代表事务结束 ,如果要停止事务的执行， 可以使用**discard**命令代替exec命令即可。 
2. **Redis并不支持回滚功能** 。
3. 有些应用场景需要在事务之前， 确保事务中的key没有被其他客户端修改过， 才执行事务， 否则不执行（类似乐观锁） ， Redis提供了**watch**命令来解决这类问题 。



### 3.5 Bitmaps

```shell
# 1.设置值
setbit key offset value

# 2.获取值
getbit key offset

# 3.获取BitMaps指定范围值为1的个数
bitcount [start][end]

# 4.Bitmaps 间的运算
bitop op destkey key[key...]
# op 可以为 and (交集)、or(并集)、not(非)、xor(异或)操作

# 计算Bitmaps中第一个值为targetBit的偏移量
bitpos key tartgetBit [start] [end]
```

### 3.6 HyperLogLog

通过HyperLogLog可以利用极小的内存空间完成独立总数的统计 。

```shell
# 1.添加
pfadd key element [element …]

# 2.计算独立用户数
pfcount key [key …]

# 3.合并
pfmerge destkey sourcekey [sourcekey ...]
```

### 3.7 发布订阅

```shell
# 1. 发布消息
publish channel message

# 2.订阅消息
subscribe channel [channel ...]

# 3.取消订阅
unsubscribe [channel [channel ...]]

# 4.按照模式订阅和取消订阅
psubscribe pattern [pattern...]
punsubscribe [pattern [pattern ...]]

# 查看活跃的频道(指当前频道至少有一个订阅者)
pubsub channels [pattern]

# 查看频道订阅数
pubsub numsub [channel ...]

# 查看模式订阅数
pubsub numpat
```

### 3.8 GEO

```
# 1.增加地理位置信息
geoadd key longitude latitude member [longitude latitude member ...]
geoadd cities:locations 116.28 39.55 beijing

# 2.获取地理位置信息
geopos key member [member ...]
geopos cities:locations tianjin

# 删除地理位置信息
zrem key member
```



## 第四章 客户端

### 4.4 客户端管理

#### 4.4.1 客户端API

**1.client list**

```shell
127.0.0.1:6379> client list
id=1610 addr=10.0.2.2:58879 fd=9 name= age=2169 idle=1590 flags=N db=0 sub=0 psub=0 multi=-1 qbuf=0 qbuf-free=0 obl=0 oll=0 omem=0 events=r cmd=scan
id=1612 addr=10.0.2.2:59560 fd=10 name=heibairuiwen age=1642 idle=0 flags=N db=0 sub=0 psub=0 multi=-1 qbuf=26 qbuf-free=32742 obl=0 oll=0 omem=0 events=r cmd=client
```

| 参数      | 含义                                                         |
| --------- | ------------------------------------------------------------ |
| id        | 客户端连接id                                                 |
| addr      | 客户端连接IP和端口                                           |
| fd        | socket 的文件描述符                                          |
| name      | 客户端连接名<br/>client setName 设置当前客户端名字；<br/>client getName 获取当前客户端名字 |
| age       | 客户端连接存活时间                                           |
| idle      | 客户端连接空闲时间                                           |
| flags     | 客户端类型类型标识                                           |
| db        | 当前客户端正在使用的数据库索引下标                           |
| sub/psub  | 当前客户端订阅的频道或者模式                                 |
| multi     | 当前事务中已执行命令个数                                     |
| qbuf      | 输入缓冲区总容量<br/>输入缓冲区会根据内容动态调整，但大小不能超过1G |
| qbuf-free | 输入缓冲区剩余容量                                           |
| obl       | 输出固定缓冲区的长度                                         |
| oll       | 输出动态缓冲区列表长度                                       |
| omem      | 固定缓冲区和动态缓冲区使用的容量。输出缓冲区的容量控制：<br/>client-output-buffer-limit  \<class>  \<hard limit>   \<soft limit>   \<soft seconds><br/>\<class>： 客户端类型分为三种。normal： 普通客户端；slave： slave客户端， 用于复制；pubsub： 发布订阅客户端。<br/>\<hard limit>： 如果客户端使用的输出缓冲区大于\<hard limit>， 客户端会被立即关闭。<br/>\<soft limit>和\<soft seconds>： 如果客户端使用的输出缓冲区超过了\<soft limit>并且持续了\<soft limit>秒， 客户端会被立即关闭。<br/>示例：client-output-buffer-limit normal 20mb 10mb 120 |
| events    | 文件描述符事作件（r/w）: r 和 w 分别代表客户端套接字可读和可写 |
| cmd       | 当前客户端最后一次执行的命令，不包含参数                     |
**2.客户端的限制maxclients和timeout** 

Redis提供了maxclients参数来限制最大客户端连接数， 一旦连接数超过maxclients， 新的连接将被拒绝。 maxclients默认值是10000， 可以通过info clients来查询当前Redis的连接数。

可以通过config set maxclients对最大客户端连接数进行动态设置。

**3.client kill** 

client kill ip:port  此命令用于杀掉指定IP地址和端口的客户端。

**4.client pause** 

client pause timeout(毫秒)   client pause命令用于阻塞客户端timeout毫秒数， 在此期间客户端连接将被阻塞。

**5.monitor**

monitor命令用于监控Redis正在执行的命令。monitor命令能够监听其他客户端正在执行的命令， 并记录了详细的时间戳。

#### 4.4.2 客户端相关配置

1. **timeout**： 检测客户端空闲连接的超时时间， 一旦idle时间达到了timeout， 客户端将会被关闭， 如果设置为0就不进行检测。
2. **tcp-keepalive**： 检测TCP连接活性的周期， 默认值为0， 也就是不进行检测， 如果需要设置， 建议为60， 那么Redis会每隔60秒对它创建的TCP连接进行活性检测， 防止大量死连接占用系统资源。
3. **tcp-backlog**： TCP三次握手后， 会将接受的连接放入队列中， tcpbacklog就是队列的大小， 它在Redis中的默认值是511。  

#### 4.4.3 客户端统计片段

**info clients** 

1. **connected_clients**： 代表当前Redis节点的客户端连接数， 需要重点监控， 一旦超过maxclients， 新的客户端连接将被拒绝。
2. **client_longest_output_list**： 当前所有输出缓冲区中队列对象个数的最大值。
3. **client_biggest_input_buf**： 当前所有输入缓冲区中占用的最大容量。
4. **blocked_clients**： 正在执行阻塞命令（例如blpop、 brpop、brpoplpush） 的客户端个数。 



## 第五章 持久化

### 5.1 RDB

RDB 持久化是把当前进程数据生成快照保存到硬盘的过程。触发RBD持久化的过程分为手动触发和自动触发。

**手动触发**：

```shell
# 手动触发（阻塞）
save
# 手动触发（非阻塞）
bgsave
```

**自动触发**：

1. 使用save相关配置， 如“save m n”。 表示m秒内数据集存在n次修改时， 自动触发bgsave。
2. 如果从节点执行全量复制操作， 主节点自动执行bgsave生成RDB文件并发送给从节点。
3. 执行debug reload命令重新加载Redis时， 也会自动触发save操作。
4. 默认情况下执行shutdown命令时， 如果没有开启AOF持久化功能则自动执行bgsave。 

**保存**：

 RDB文件保存在dir配置指定的目录下， 文件名通过**dbfilename**配置指定。 可以通过执行**config set dir{newDir}**和**config setdbfilename{newFileName}**运行期动态执行， 当下次运行时RDB文件会保存到新目录。 

**缺点**：

无法做到实时持久化/秒级持久化，重量级操作，频繁执行成本高

### 5.2 AOF

AOF 持久化以独立日志的方式记录每次写命令，重启时在重新执行AOF文件中的命令达到恢复数据的目的。

1. 开启AOF功能需要设置配置： **appendonly yes**， 默认不开启。 
2. AOF文件名通过**appendfilename**配置设置， 默认文件名是appendonly.aof。 
3. 保存路径同RDB持久化方式一致， 通过dir配置指定。 

**1. AOF缓冲区同步文件策略**：

| 可配置值       | 说明                                                         |
| -------------- | ------------------------------------------------------------ |
| always         | 命令写入aof_buf后调用系统fsyn操作同步到AOF文件，fsync 完成后线程返回 |
| everysec(常用) | 每秒执行一次                                                 |
| no             | 同步由操作系统控制                                           |

**2. AOF重写过程**：

**手动触发**：直接调用**bgrewriteaof**命令

**自动触发**：根据**auto-aof-rewrite-min-size**和**auto-aof-rewrite-percentage**参数确定自动触发时机。 

- auto-aof-rewrite-min-size： 表示运行AOF重写时文件最小体积， 默认为64MB。
- auto-aof-rewrite-percentage： 代表当前AOF文件空间（aof_current_size） 和上一次重写后AOF文件空间（aof_base_size） 的比值。 

**3. 错误修复**

对于错误格式的AOF文件， 先进行备份， 然后采用**redis-check-aof--fix**命令进行修复， 修复后使用diff-u对比数据的差异， 找出丢失的数据， 有些可以人工修改补全。 



## 第六章 复制

### 6.1 配置

#### 6.1.1 建立复制

三种方式：

1. 在配置文件中加入slaveof  {masterHost}  {masterPort}随Redis启动生效。
2. 在redis-server启动命令后加入--slaveof  {masterHost}  {masterPort}生效。
3. 直接使用命令： slaveof  {masterHost}  {masterPort}生效。 

```shell
127.0.0.1:6380>slaveof 127.0.0.1 6379
```

#### 6.1.2 断开复制

在从节点执行**slaveof no one**来断开与主节点复制关系。 从节点断开复制后**并不会抛弃原有数据**， 只是无法再获取主节点上的数
据变化。 

通过slaveof命令还可以实现切主操作， 所谓切主是指把当前从节点对主节点的复制切换到另一个主节点。 执行slaveof{newMasterIp} {newMasterPort}命令即可。**会清除原有数据**。 

注：**默认情况下， 从节点使用slave-read-only=yes配置为只读模式**。  

#### 6.1.3 传输延迟

Redis为我们提供了**repl-disable-tcp-nodelay**参数用于控制是否关闭TCP_NODELAY， 默认关闭， 说明如下：

- 当关闭时， 主节点产生的命令数据无论大小都会及时地发送给从节点， 这样主从之间延迟会变小， 但增加了网络带宽的消耗。 适用于主从之间的网络环境良好的场景， 如同机架或同机房部署。
- 当开启时， 主节点会合并较小的TCP数据包从而节省带宽。 默认发送时间间隔取决于Linux的内核， 一般默认为40毫秒。 这种配置节省了带宽但增大主从之间的延迟。 适用于主从网络环境复杂或带宽紧张的场景， 如跨机房部署。 



## 第十章 集群

### 10.1 数据分区

Redis Cluser采用虚拟槽分区， 所有的键根据哈希函数映射到0~16383整数槽内， 计算公式： slot=CRC16（key） &16383。 每一个节点负责维护一部分槽以及槽所映射的键值数据。 

### 10.2 搭建集群

**用redis-trib.rb搭建集群** ：

**1.Ruby环境准备** 

```shell
# 安装Ruby： 
wget https:// cache.ruby-lang.org/pub/ruby/2.3/ruby-2.3.1.tar.gz
tar xvf ruby-2.3.1.tar.gz
cd ruby-2.3.1
./configure -prefix=/usr/local/ruby
make
make install
cd /usr/local/ruby
sudo cp bin/ruby /usr/local/bin
sudo cp bin/gem /usr/local/bin

# 安装rubygem redis依赖：
wget http:// rubygems.org/downloads/redis-3.3.0.gem
gem install -l redis-3.3.0.gem
gem list --check redis gem

# 安装redis-trib.rb：
sudo cp /{redis_home}/src/redis-trib.rb /usr/local/bin

# 执行确认
# redis-trib.rb
```

**2.节点配置**

```shell
#节点端口
port 6379
# 开启集群模式
cluster-enabled yes
# 节点超时时间， 单位毫秒
cluster-node-timeout 15000
# 集群内部配置文件
cluster-config-file "nodes-6379.conf"
```

```shell
redis-server conf/redis-6481.conf
redis-server conf/redis-6482.conf
redis-server conf/redis-6483.conf
redis-server conf/redis-6484.conf
redis-server conf/redis-6485.conf
redis-server conf/redis-6486.conf
```

**3.创建集群** 

```shell
redis-trib.rb create --replicas 1 127.0.0.1:6481 127.0.0.1:6482 127.0.0.1:6483
127.0.0.1:6484 127.0.0.1:6485 127.0.0.1:6486
```

--replicas参数指定集群中每个主节点配备几个从节点， 这里设置为1。 

**4.集群完整性检查** 

集群完整性指所有的槽都分配到存活的主节点上， 只要16384个槽中有一个没有分配给节点则表示集群不完整。 可以使用redis-trib.rb check命令检测之前创建的两个集群是否成功， check命令只需要给出集群中任意一个节点地址就可以完成整个集群的检查工作 .

```shell
redis-trib.rb check 127.0.0.1:6379
redis-trib.rb check 127.0.0.1:6481
```

### 10.4  集群扩容

#### 10.4.2 扩容集群

**步骤：**

```shell
# 准备新的节点
redis-server conf/redis-6385.conf
redis-server conf/redis-6386.conf

# 加入集群
redis-trib.rb add-node 127.0.0.1:6385 127.0.0.1:6379
redis-trib.rb add-node 127.0.0.1:6386 127.0.0.1:6379

# 槽重新分片
redis-trib.rb reshard 127.0.0.1:6379

#要把节点6386作为6385的从节点， 从而保证整个集群的高可用。
127.0.0.1:6386>cluster replicate 1a205dd8b2819a00dd1e8b6be40a8e2abe77b756

#查看情况验证
cluster nodes
```

槽重新分片：

```shell
redis-trib.rb reshard host:port --from <arg> --to <arg> --slots <arg> --yes --timeout
<arg> --pipeline <arg>
```

参数说明：

- host： port： 必传参数， 集群内任意节点地址， 用来获取整个集群信息。
- --from： 制定源节点的id， 如果有多个源节点， 使用逗号分隔， 如果是all源节点变为集群内所有主节点， 在迁移过程中提示用户输入。
- --to： 需要迁移的目标节点的id， 目标节点只能填写一个， 在迁移过程中提示用户输入。
- --slots： 需要迁移槽的总数量， 在迁移过程中提示用户输入。
- --yes： 当打印出reshard执行计划时， 是否需要用户输入yes确认后再执行reshard。
- --timeout： 控制每次migrate操作的超时时间， 默认为60000毫秒。 

#### 10.4.3 收缩集群

下线节点：

```shell
redistrib.rb del-node{host： port}{downNodeId}
```



## 附：[CacheCloud GitHub](https://github.com/sohutv/cachecloud)

