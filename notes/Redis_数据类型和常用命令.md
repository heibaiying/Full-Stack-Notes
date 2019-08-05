# Redis 基本数据类型和常用命令

## 一、数据类型

Redis 5 支持以下多种数据类型：

- 二进制安全字符串。
- Lists (列表)：根据插入顺序排序的字符串元素的集合。
- Sets (集)：未排序的不重复的字符串元素的集合。
- Sorted Sets (排序集)：类似于集，但每个字符串元素与被称为分数的值相关，元素总是按其分数排序。
- Hashes (散列) ：由字段 (Field) 和值都是字符串组成的映射的集合。
- Bit Arrays (也称 bitmaps 位图) ：Bitmaps 本身不是一种数据结构， 实际上它就是字符串，但是它可以对字符串的位进行操作，所以在 Redis 官方的分类当中将其单独归为一类；
- HyperLogLogs：实际类型为字符串类型 ，它是一种基数算法， 通过 HyperLogLog 可以利用极小的内存空间完成独立总数的统计。 
- Streams (流) ：Stream是 Redis 5.0 引入的一种新数据类型，用于在生产者和消费者之间建立数据通道。

## 二、常用命令

### 2.1 字符串

| 作用                 | 命令格式                                                     | 参数或示例                                                   |
| -------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 设置值               | set key value \[ex seconds]\[px milliseconds][nx\|xx] setnx setex | ex seconds：为键设置秒级过期时间； <br/>px milliseconds：为键设置毫秒级过期时间；<br/>nx： 键不存在时才可以添加成功；<br/>xx： 键存在时才可以修改成功。 |
| 获取值               | get key                                                      | 如果获取的键不存在 ，则返回 nil                              |
| 批量设置             | mset key value [key value ...]                               | mset a 1 b 2 c 3 d 4                                         |
| 批量获取值           | mget key [key ...]                                           | mget a b c d                                                 |
| 计数                 | incr key <br/>decr key<br/>incrby key increment（指定数值自增）<br/>decrby key decrement（指定数值自减）<br/>incrbyfloat key increment （浮点数自增） | 值是整数时返回自增或自减后的结果；<br/>值不是整数时返回错误；<br/>键不存在时自动创建，并按照初始值为 0 进行自增或自减。 |
| 追加值               | append key value                                             | 向字符串尾部追加值。                                         |
| 字符串长度           | strlen key                                                   | 获取字符串长度，中文占用三个字节                             |
| 设置并返回原值       | getset key value                                             |                                                              |
| 设置指定位置的字符串 | setrange key offeset value                                   |                                                              |
| 获取部分字符串       | getrange key start end                                       |                                                              |

### 2.3 哈希

| 作用                   | 格式                                                         | 参数或示例                                                   |
| ---------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 设置值                 | hset key field value                                         | hset user:1 name tom<br/>hset user:1 age 12                  |
| 获取值                 | hget key field                                               | hget user:1 name                                             |
| 删除 field             | hdel key field [field ...]                                   |                                                              |
| 计算 field 个数        | hlen key                                                     |                                                              |
| 批量设置或获取         | hmget key field [field]<br/>hmset key field value [field value...] | hmset user:1 name mike age 12 city tianjin<br/>hmget user:1 name city |
| 判断 field 是否存在    | hexists key field                                            |                                                              |
| 获取所有 field         | hkeys key                                                    |                                                              |
| 获取所有 value         | hvals key                                                    |                                                              |
| 获取所有的 filed-value | hgetall key                                                  | 如果哈希元素个数比较多可能会阻塞Redis，此时可以使用 hscan 渐进式遍历 |
| 计数                   | hincrby key field<br/>hincrbyfloat key field                 |                                                              |

### 2.4 列表

| 作用     | 格式                                                         | 参数或示例                                                   |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 增       | 左侧插入：lpush key value [value ...] <br/>右侧插入：rpush key value [value ...] <br/>某个指定元素前后插入：linsert key before\|after pivot value |                                                              |
| 查       | 获取指定范围内的元素列表：lrange key start end <br/>获取列表指定索引下标的元素：lindex key index <br/>获取列表指定长度：llen key | lrange listkey 0 -1                                          |
| 删       | 从列表左侧弹出元素：lpop key <br/>从列表右侧弹出元素：rpop key <br/>删除指定元素：lrem key count value <br/>截取列表：ltrim key start end | count>0：从左到右， 删除最多 count 个元素。<br/>count<0：从右到左， 删除最多 -count 个元素。<br/>count=0： 删除所有 |
| 改       | 修改指定下标的元素：lset key index newValue                  |                                                              |
| 阻塞操作 | blpop key [key ...] timeout <br/>brpop key [key ...] timeout | key[key...]： 多个列表的键。 timeout： 阻塞时间\|等待时间（单位秒） |



### 2.5 集合

集合（set） 类型也是用来保存多个的字符串元素， 但和列表类型不一样的是， 集合中的元素是无序的， 不允许有重复元素，不能通过下标获取元素。  

| 作用                 | 格式                           | 参数或示例                                |
| -------------------- | ------------------------------ | ----------------------------------------- |
| 添加元素             | sadd key element [element ...] | 返回结果为添加成功的元素个数              |
| 删除元素             | srem key element [element ...] | 返回结果为成功删除的元素个数              |
| 计算元素个数         | scard key                      |                                           |
| 判断元素是否在集合中 | sismember key element          |                                           |
| 随机返回             | srandmember key [count]        | 随机从集合返回指定个数元素，count 默认为1 |
| 从集合随机弹出元素   | spop key                       | srandmember 不会从集合中删除元素，spop 会 |
| 获取集合中所有元素   | smembers key                   | 可用 sscan 代替                           |

**集合间操作**：

| 作用                         | 格式                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| 求多个集合的交集             | sinter key [key ...]                                         |
| 求多个集合的并集             | suinon key [key ...]                                         |
| 求多个集合的差集             | sdiff key [key ...]                                          |
| 将交集、并集、差集的结果保存 | sinterstore destination key [key ...] <br/>suionstore destination key [key ...]<br/>sdiffstore destination key [key ...] |

### 2.6 有序集合

有序集合中的元素可以排序。它给每个元素设置一个分数（score） 作为排序的依据。  

| 作用                     | 格式                                                         | 参数或示例                                                   |
| ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 添加成员                 | zadd key score member [score member ...]                     | nx： member 不存在时才可设置成功， 用于添加；<br>xx： member 存在时可以设置成功， 用于更新；<br/>ch： 返回此次操作后， 有序集合内元素和分数发生变化的个数；<br/>incr：对 score 做增加， 相当于下面的 zincrby。 |
| 计算成员个数             | zcard key                                                    |                                                              |
| 计算某个成员的分数       | zscore key member                                            |                                                              |
| 计算某个成员的排名       | zrank key member  zrevrank key member                        | zrank是从分数从低到高返回排名， zrevrank 反之。              |
| 删除成员                 | zrem key member [member ...]                                 |                                                              |
| 增加成员分数             | zincrby key increment member                                 | zincrby user:ranking 9 tom                                   |
| 返回指定排名范围的成员   | zrange key start end [withscores] <br/>zrevrange key start end [withscores] | zrange是从低到高返回， zrevrange 反之。                      |
| 返回指定分数范围内的成员 | zrangebyscore key min max \[withscores][limit offset count] <br/>zrevrangebyscore key max min \[withscores][limit offset count] | 其中 zrangebyscore 按照分数从低到高返回， zrevrangebyscore 反之；<br/> [limit offset count] 选项用于限制输出的起始位置和个数； <br/>min 和 max 代表最小和最大值，支持开闭区间， 也可以使用 -inf 和+inf 代表无限小和无限大。 |
| 删除指定排名内的升序元素 | zremrangerank key start end                                  |                                                              |
| 删除指定分数范围的成员   | zremrangebyscore key min max                                 |                                                              |

**集合间操作**：

| 作用 | 格式                                                         |
| ---- | ------------------------------------------------------------ |
| 交集 | zinterstore destination numkeys key \[key ...]  [weights weight [weight ...]] \[aggregate sum\|min\|max] |
| 并集 | zunionstore destination numkeys key \[key ...] [weights weight [weight ...]] \[aggregate sum\|min\|max] |

- destination： 交集计算的结果保存到这个键。
- numkeys： 需要做交集计算键的个数。
- key[key...]： 需要做交集计算的键。 
- weights weight[weight...]： 每个键的权重， 在做交集计算时， 每个键中的每个 member 会将自己分数乘以这个权重， 每个键的权重默认是1。
- aggregate sum|min|max： 计算成员交集后， 分值可以按照sum（和） 、min（最小值） 、 max（最大值） 做汇总， 默认值是 sum。 

### 2.7 全局命令

1. 查看所有键： keys \*
2. 查看键总数：dbsize
3. 检查键是否存在：exists key
4. 删除键：del key [key ...]
5. 键过期：expire key seconds ，使用 ttl 命令可以查看键剩余的过期时间， 它有以下三种返回值：
   - 大于等于0的整数： 键剩余的过期时间。
   - -1： 键未设置过期时间。
   - -2： 键不存在 
6. 查看键的数据类型：type key

### 2.8 键过期

可以使用以下命令完成设置键的过期时间：

- expire key seconds： 键在 seconds 秒后过期；
- expireat key timestamp： 键在秒级时间戳 timestamp 后过期； 
- pexpire key milliseconds： 键在 milliseconds 毫秒后过期；
- pexpireat key milliseconds-timestamp：键在毫秒级时间戳 timestamp 后过期。 

注意事项：

- 如果 expire key 的键不存在， 返回结果为 0；
- 如果设置过期时间为负值， 键会立即被删除， 此时等价于 del 命令；
- persist  key  命令可以将键的过期时间清除，使键变成永久的；
- 需要特别注意对于字符串类型键， 执行 set 命令会清除掉已有的过期时间；
- Redis 不支持对二级数据结构的内部元素设置过期时间， 例如不能对列表内的某个元素设置过期时间；
- setex 命令是 set+expire 的组合， 它是一个原子操作。

### 2.9 渐进式键遍历

使用 keys  命令遍历键可能会带来阻塞的风险，因为 Redis 提供了渐进式键遍历命令 scan ，使用格式如下：

```shell
scan cursor [match pattern] [count number] 
```

- cursor：游标，第一次遍历从 0 开始， 每次遍历完都会返回当前游标的值， 直到游标值为 0， 表示遍历结束。
- match patternr：可选参数， 它的作用的是匹配特定模式的键；
- count numberr：可选参数， 它的作用是表明每次要遍历的键个数， 默认值是 10。 

### 2.10 数据库管理

1.切换数据库：select dbIndex

2.清除数据库：flushdb/flushall，flushdb只清除当前数据库， flushall会清除所有数据库。 


