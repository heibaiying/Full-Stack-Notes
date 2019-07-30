# MongoDB 聚合操作

## 一、聚合简述

在日常开发中，我们通常需要对存储数据进行聚合分析后，再返回给客户端。MongoDB提供了三种聚合的方式，分别是聚合管道，map-reduce 函数和单用途聚合方法。

## 二、聚合管道

MongoDB 的聚合操作类似于流水线处理，文档会依次进入多个管道阶段并执行相应的操作。这里先插入部分演示数据：

```shell
db.employees.insertMany([
    {
        emp_no: 10001,
        name: {firstName:"Georgi",lastName:"Facello"},
        age: 26,
        gender: "F",
        hobby: ["basketball", "football"]
    },
    {
        emp_no: 10002,
        name: {firstName:"Bezalel",lastName:"Simmel"},
        age: 32,
        gender: "M",
        hobby: ["basketball", "tennis"]
    },
    {
        emp_no: 10003,
        name: {firstName:"Parto",lastName:"Bamford"},
        age: 46,
        gender: "M",
        hobby: []
    },
    {
        emp_no: 10004,
        name: {firstName:"Chirstian",lastName:"Koblick"},
        age: 40,
        gender: "F",
        hobby: ["football", "tennis"]
    }
])
```

一个简单的聚合操作如下，这个聚合操作会经过两个阶段的数据处理：

+ 第一个管道阶段为 $match：会筛选出所有性别值为 F 的雇员的文档，然后输出到下一个管道操作中；
+ 第二个管道阶段为 $project：用于定义返回的字段内容，这里返回 fullname 字段，它由 firstName + lastName 组成。

```shell
db.employees.aggregate([
    { $match: { gender: "F" } },
    { $project: 
        { fullName:
            { $concat: ["$name.firstName", "$name.lastName"]}
        } 
    }
])
```

所以最后的输出结果如下：

```json
{
	"_id" : ObjectId("5d3fe6488ba16934ccce999d"),
	"fullName" : "GeorgiFacello"
},
{
	"_id" : ObjectId("5d3fe6488ba16934ccce99a0"),
	"fullName" : "ChirstianKoblick"
}
```

在当前最新的 MongoDB 4.x 中，MongoDB 提供了将近 30 个管道阶段，用于满足不同数据处理的需求。以下主要介绍常用几个管道阶段，如果想要了解全部的管道阶段，可以参见官方文档：[Aggregation Pipeline Stages](https://docs.mongodb.com/manual/reference/operator/aggregation-pipeline/)

### 1.1 $match

$match 主要用于筛选符合条件的数据，通常应该把 $match 放在尽量靠前的位置，这时候它会利用索引来优化查询，同时还可以降低后续阶段所需要处理的数据量。示例如下：

```shell
db.employees.aggregate([
    { $match: { gender: "F" } }
])
```

### 1.2 $project

$project 主要用于定义需要返回的字段，1 代表包含该字段，0 代表不包含，除了可以作用于顶层字段外，还可以作用于内嵌字段。同时 $project 还支持使用表达式将多个字段或变量进行组合，并作为新的字段返回。示例如下：

```shell
db.employees.aggregate([
     {
      $project: {
         _id: 0,
         "name.firstName": 1,
         gender: 1,
         fullName: { $concat: ["$name.firstName", "$name.lastName"] }
      }
   }
])
```

从 MongoDB 3.6 开始，还可以在聚合表达式中使用 $project + 变量 REMOVE 来按照条件定义返回字段，设置为 REMOVE 变量的字段将会从 $projection 的输出中排除。示例如下：

```shell
db.employees.aggregate([
     {
      $project: {
         hobby: {
            $cond: {
               if: { $eq: [ [], "$hobby" ] },
               then: "$$REMOVE",
               else: "$hobby"
            }
         }
      }
   }
])
```

这里判断当文档的 hobby 属性为空数组时，则其 hobby 属性不会被输出到下一个管道阶段。

### 1.3 $group

$group 管道阶段和大多数关系型数据库中的 group by 字句功能类似，都是用于分组计算。示例如下：

```json
db.employees.aggregate(
   [
     { $group : { 
         _id : "$gender",
         totalAge: { $sum: "$age"},
         avgAge: { $avg: "$age" },
         count: { $sum: 1 }
        } 
     }
   ]
)
```

上面的语句会按照性别进行分组，并计算分组后两组人的总年龄、平均年龄和总人数，输出如下：

```json
{
	"_id" : "M",
	"totalAge" : 78,
	"avgAge" : 39,
	"count" : 2
},
{
	"_id" : "F",
	"totalAge" : 66,
	"avgAge" : 33,
	"count" : 2
}
```

如果你想计算所有员工的年龄总和、平均年龄、以及员工总数，则可以将 $group 管道阶段的 _id 字段设置为 null ，语句如下：

```shell
db.employees.aggregate(
   [
     { $group : { 
         _id : null,
         totalAge: { $sum: "$age"},
         avgAge: { $avg: "$age" },
         count: { $sum: 1 }
        } 
     }
   ]
)

# 输出如下
{
	"_id" : null,
	"totalAge" : 144,
	"avgAge" : 36,
	"count" : 4
}
```

### 1.4 $unwind

$unwind 将文档按照数组中的每一个元素进行拆分，类似于大多数流式计算中的 flatMap 算子。其语法格式如下：

```shell
{
  $unwind:
    {
      path: <field path>,
      includeArrayIndex: <string>,
      preserveNullAndEmptyArrays: <boolean>
    }
}
```

+ **path**：用于展开的数组字段；

+ **includeArrayIndex**：用于显示对应元素在原数组的位置信息；

+ **preserveNullAndEmptyArrays**：如果用于展开的字段值为 null 或空数组时，则对应的文档不会被输出到下一阶段。如果想要输出到下一阶段则需要将该属性设置为 true。示例语句如下：

```json
db.employees.aggregate( [
   {$project: {_id: 0, emp_no: 1, hobby:1}},
   { $unwind: 
        { path: "$hobby",
          includeArrayIndex: "arrayIndex", 
          preserveNullAndEmptyArrays: true 
        } 
   }
] )
```

此时输出内容如下。如果 preserveNullAndEmptyArrays 的值为 false 或者没有设置，则 10003 这条数据不会被输出。

```json
{"emp_no":10001,"hobby":"basketball","arrayIndex":0},
{"emp_no":10001,"hobby":"football","arrayIndex":1},

{"emp_no":10002,"hobby":"basketball","arrayIndex":0},
{"emp_no":10002,"hobby":"tennis","arrayIndex":1},

{"emp_no":10003,"arrayIndex":null},

{"emp_no":10004,"hobby":"football","arrayIndex":0},
{"emp_no":10004,"hobby":"tennis","arrayIndex":1}
```

### 1.5 $sort

$sort 主要用于排序操作，需要注意的是如果可以，应当尽量将该操作放置在管道的第一阶段，从而可以利用索引进行排序，否则就需要使用内存进行排序，这时排序操作就会变得相当昂贵，需要额外的内存和计算资源的开销。

示例如下：

```shell
db.employees.aggregate([
   {$skip: 2} ,
   {$sort: {age: 1}},
   {$limit: 10}
])
```

### 1.6 $limit

限制返回文档的数量。

### 1.7 $skip

跳过一定数量的文档。

### 1.8 $lookup

```shell
db.titles.insertMany([
    {
      emp_no: 10001,
      title: "Senior Engineer"
    },
    {
      emp_no: 10002,
      title: "Staff"
    },
    {
      emp_no: 10003,
      title: "Senior Engineer"
    },
    {
      emp_no: 10004,
      title: "Engineer"
    },
    {
      emp_no: 10004,
      title: "Senior Engineer "
    }
])
```

```shell
db.employees.aggregate([
   {
      $lookup:
         {
            from: "titles",
            localField: "emp_no",
            foreignField: "emp_no",
            as: "emp_title"
        }
   }
]) 


db.employees.aggregate([
   {
      $lookup:
         {
           from: "titles",
           let: { gender: "$gender"},
           pipeline: [
              { $match:
                 { $expr: { $eq: [ "$$gender","M"]}}
              }
           ],
           as: "emp_title"
         }
    }
])



db.employees.aggregate([
   {
      $lookup:
         {
           from: "titles",
           pipeline: [
              { $match:
                  { $expr: { $eq: [ "$title","M"]}}
              }
           ],
           as: "emp_title"
         }
    }
])
```

### 1.9 $out

$out 用于将数据写入指定的集合，它必须是管道中的最后一个阶段。如果指定的集合不存在，则会自动新建；如果指定的集合存在，它会覆盖原有集合的数据。其实际的步骤如下：

- 创建临时集合；
- 将索引从现有集合复制到临时集合；
- 将文档插入临时集合中；
- 调用 db.collection.renameCollection(target, true) 方法将临时集合重命名为目标集合。

$out 的使用示例如下：

```shell
db.employees.aggregate([
    { $out: "emps"}
])
```

### 1.10 自动优化

在大多数情况下 MongoDB 会按照我们定义管道的先后顺序执行管道操作，但是某些情况下，MongoDB 会在不影响结果的前提下，改变管道执行顺序，从而获得更好的性能表现。常见的优化策略如下：

#### $project or $addFields + $match

当投影操作后面有匹配操作时，MongoDB 会将 $match 阶段中不需要进行投影操作的字段的过滤条件提前到投影操作前执行。

#### $sort + $match

当排序操作后面有匹配操作时，会将匹配操作提前，以减少需要排序的数据量。

#### $project + $skip

当投影操作后面有跳过操作时，会先执行跳过操作，从而减少需要进行投影操作的数据量。

#### $sort + $limit

当排序操作在限制操作之前时，如果没有中间阶段会修改文档数量 (例如 $unwind，$group)，优化器会将 $limit 合并到 $sort中。如果在 $sort 和 $limit 之间存在修改文档数量的管道阶段，MongoDB 将不会执行合并。

了解这些优化策略可以有助于我们在开发中合理设置管道的顺序。想要了解全部的优化策略，可以参阅 MongoDB 的官方文档：[Aggregation Pipeline Optimization](https://docs.mongodb.com/manual/core/aggregation-pipeline-optimization/)

## 三、MapReduce

## 四、单用途聚合方法