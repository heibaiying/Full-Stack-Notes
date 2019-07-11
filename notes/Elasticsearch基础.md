# Elasticsearch 基本操作


# 一、索引管理


## 1.1 新建索引

使用指定配置创建索引，这里指定分片的数量为 3； 副本系数为 2，即每个分片两个副本；默认情况下分片数量和副本系数都是 1。需要注意的是创建索引时，索引名称只能是小写，长度不能超过 255 个字符，同时尽量不要包含特殊字符，不能以`-`，`_`，`+`等字符开头。

```json
PUT weibo
{
    "settings" : {
        "number_of_shards" : 3, 
        "number_of_replicas" : 2 
    }
}
```

## 1.2 修改配置

```json
PUT weibo/_settings
{
  "number_of_replicas": 1
}
```

ES 支持修改索引的副本系数，但不支持随意修改索引的分片数，这与 ES 分片的路由机制有关，ES 使用以下公式来决定每条数据存储在哪个具体的分片上：

```java
shard = hash(routing) % number_of_shards
```

routing 是一个任意字符串，默认是 `_id` ，同时也支持自定义。ES 对其进行哈希运算然后按 number_of_shards 进行取余，之后就计算出存储分片的序号。基于这个原因，所以 ES 不允许对 number_of_shards 进行修改，因为这会导致已有数据存储位置的计算规则失效。

## 1.3 查看与删除

查看索引、查看索引配置、删除索引的语法分别如下：

```shell
# 查看索引信息
GET weibo
# 查看索引配置信息
GET weibo/_settings
# 删除索引
DELETE weibo
```

## 1.4 打开与关闭

ES 中的索引支持打开和关闭操作，索引关闭不能进行读写操作，后其占用的系统资源也会随之减少。索引打开和关闭的语法为：

```shell
# 关闭索引
POST weibo/_close
# 打开索引
POST weibo/_open
```

ES 支持一次关闭多个索引，多个索引名之间使用逗号分隔，同时也支持通配符和`_all`关键字，示例如下：

```shell
# 关闭多个索引，ignore_unavailable=true代表如果其中某个索引不存在，则忽略该索引
POST weibo1,weibo2,weibo3/_close?ignore_unavailable=true
# 支持通配符
POST weibo*/_close
# 关闭集群中所有索引
POST _all/_close
```

# 二、文档管理

## 2.1 新建文档

```json
PUT weibo/_doc/1
{
  "user" : "kimchy",
  "post_date" : "2009-11-15T14:12:12",
  "message" : "trying out Elasticsearch"
}
```

这里需要注意的是在 7.x 版本后  ES 已经不推荐使用文档类型，所以这里的`_doc`其表示端点名称而不是文档类型。输出如下：

```json
{
  "_index" : "weibo",
  "_type" : "_doc",
  "_id" : "1",
  "_version" : 1,
  "result" : "created",
  "_shards" : {
    "total" : 2,
    "successful" : 1,
    "failed" : 0
  },
  "_seq_no" : 0,
  "_primary_term" : 1
}

```

### 1. _id

在输出中可以看到`_id`的值为 1，这是在创建时指定的。如果创建时没有指定，则由 ES 自动生成。

### 2. _version

`_version`代表当前文档的版本号，基于它可以实现乐观锁的效果，需要配合version_type 使用，version_type 有以下可选值：

+ **interna** ：当给定的版本号与文档版本号相同时候，才执行对应的操作；

+ **external 或 external_gt** ：如果给定版本号大于存储文档的版本或者原文档不存在时，才执行对应的操作，给定版本号将用作新的版本。

+ **external_gte** ：和上一条类似，等价于 gt + equal ，即给定版本号大于或等于存储文档的版本或者原文档不存在时，才执行对应的操作。

使用示例：`PUT weibo/_doc/1?version=2&version_type=external { ... }`

### 3. _shards

输出结果中的`_shards`节点下有三个参数，其含义分别如下：

- **total** ：操作涉及到的分片综述，这里由于创建`weibo`索引时指定主分片数量和副本系数都是1，所以 只有 1个 primary 分片和 1 个 replica 分片，故其总数为 2； 
- **successful** ：这里我采用的是单节点的 ES , replica 分片实际上是不存在的。因为按照 ES 的规则，primary 分片及其对应的replica 分片不能处于同一台主机上，因为处于同一台主机上时无法达到容错的效果。所以这里只有 primary 分片写入数据成功，故值为1；
- **failed** ：执行复制操作失败的 replica 分片的数量，这里由于 replica 分片本生就不存在所以值为 0。

### 4. routing

在上面我们提到，ES 的分片路由规则默认进行哈希的对象是`_id`，如果你想指定使用其他字段，则可以使用`routing`参数进行指定，示例如下：

```json
POST weibo/_doc?routing=kimchy
{
    "user" : "kimchy",
    "post_date" : "2009-11-15T14:12:12",
    "message" : "trying out Elasticsearch"
}
```

# 2.2 查询文档

## 三、映射详解

