# MySQL EXPLAIN

EXPLAIN 关键字可以用于获取 SQL 语句执行计划的相关信息，在 MySQL 8.0 中，EXPLAIN  支持大多数 SQL 语句，如 SELECT 、DELETE 、INSERT 、REPLACE、和 UPDATE 。示例如下：

```shell
mysql> EXPLAIN SELECT * FROM employees;
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------+
| id | select_type | table     | type | possible_keys | key  | key_len | ref  | rows   | Extra |
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------+
|  1 | SIMPLE      | employees | ALL  | NULL          | NULL | NULL    | NULL | 299379 | NULL  |
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------+
```

注：本篇文章的测试数据来源于 MySQL 官方提供的 [Employees Sample Database](https://dev.mysql.com/doc/employee/en/)，其数据库结构如下：


<div align="center"> <img src="../pictures/employees-schema.png"/> </div>
以下分别介绍 EXPLAIN 输出结果中各个字段的含义：



## 1. id

 id 为行标识符，同时也表示语句执行的优先级，值越大则优先级越高。特殊情况下，如果某行语句引用了其他多行结果集的并集，则该值可以为 NULL。示例如下：

```shell
# 该FROM字句只是用于演示，并没有任何实际意义
mysql> EXPLAIN SELECT COUNT(1) FROM (SELECT emp_no FROM salaries) AS t;
+----+-------------+------------+-------+---------------+---------+---------+------+---------+-------------+
| id | select_type | table      | type  | possible_keys | key     | key_len | ref  | rows    | Extra       |
+----+-------------+------------+-------+---------------+---------+---------+------+---------+-------------+
|  1 | PRIMARY     | <derived2> | ALL   | NULL          | NULL    | NULL    | NULL | 2757635 | NULL        |
|  2 | DERIVED     | salaries   | index | NULL          | PRIMARY | 7       | NULL | 2757635 | Using index |
+----+-------------+------------+-------+---------------+---------+---------+------+---------+-------------+
```

```shell
# 查询工资大于500000或部门编号等于d007的所有雇员的编号
mysql> EXPLAIN SELECT emp_no FROM salaries WHERE salary>500000 UNION ALL SELECT emp_no FROM dept_emp WHERE dept_no = "d007";
+----+--------------+------------+------+---------------+---------+---------+-------+---------+--------------------------+
| id | select_type  | table      | type | possible_keys | key     | key_len | ref   | rows    | Extra                    |
+----+--------------+------------+------+---------------+---------+---------+-------+---------+--------------------------+
|  1 | PRIMARY      | salaries   | ALL  | NULL          | NULL    | NULL    | NULL  | 2837161 | Using where              |
|  2 | UNION        | dept_emp   | ref  | dept_no       | dept_no | 4       | const |   91566 | Using where; Using index |
| NULL | UNION RESULT | <union1,2> | ALL  | NULL          | NULL    | NULL    | NULL  |    NULL | Using temporary          |
+----+--------------+------------+------+---------------+---------+---------+-------+---------+--------------------------+
```

## 2. select_type

select_type 用于表示查询的类型，常见类型及其含义如下：

+ **SIMPLE**：不包含子查询或者 UNION 操作的查询；
+ **PRIMARY**：查询中如果包含任何子查询，那么最外层的查询则被标记为 PRIMARY ；
+ **SUBQUERY**：子查询中第一个 SELECT ；
+ **DEPENDENT SUBQUERY**：子查询中的第一个 SELECT，取决于外部查询；
+ **UNION**：UNION 操作的第二个或者之后的查询；
+ **DEPENDENT UNION**：UNION 操作的第二个或者之后的查询,取决于外部查询；
+ **UNION RESULT**：UNION 产生的结果集；
+ **DERIVED**：出现在 FROM 字句中的子查询。

这里以查询类型为 SUBQUERY 的情况进行演示，示例如下：

```shell
# 根据员工编号查询员工姓名及其工资总和
mysql> EXPLAIN SELECT first_name,(SELECT sum(salary) FROM salaries WHERE emp_no = 10001) FROM employees WHERE emp_no = 10001;
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+-------+
| id | select_type | table     | type  | possible_keys | key     | key_len | ref   | rows | Extra |
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+-------+
|  1 | PRIMARY     | employees | const | PRIMARY       | PRIMARY | 4       | const |    1 | NULL  |
|  2 | SUBQUERY    | salaries  | ref   | PRIMARY       | PRIMARY | 4       | const |   17 | NULL  |
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+-------+
```

## 3. table

表示语句执行的目标表，除了正常的表名或表别名外，还会出现以下取值：

- **<union*M*,*N*>**：输出结果中编号为 M 的行与编号为 N 的行的结果集的并集。
- **<derived*N*>**：输出结果中编号为 N 的行的结果集，derived 表示这是一个派生结果集，如 FROM 子句中的查询。
- **<subquery*N*>**：输出结果中编号为 N 的行的结果集，subquery 表示这是一个物化子查询。

## 4. type

type 字段是进行性能判断的重要依据，它表示 MySQL 使用何种方式来查找目标数据集，不同查找方式会导致不同的性能开销，常见查找方式及其性能表现按照由高到低的顺序排序如下：

**1. system**：这是 const 类型的一个特例，只会出现在待查询的表只有一行数据的情况下。

**2. const**：常出现在主键或唯一索引与常量值进行比较的场景下，此时查询性能是最优的。

```shell
mysql> EXPLAIN SELECT * FROM employees WHERE emp_no = 10008;
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+-------+
| id | select_type | table     | type  | possible_keys | key     | key_len | ref   | rows | Extra |
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+-------+
|  1 | SIMPLE      | employees | const | PRIMARY       | PRIMARY | 4       | const |    1 | NULL  |
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+-------+
```

**3. eq_ref**：当连接使用的是完整的索引并且是 PRIMARY KEY 或 UNIQUE NOT NULL INDEX 时使用它。

```shell
# 这里员工部门关系表 dept_no 的联合主键为 emp_no + dept_no ，即员工编号+部门标号
mysql> EXPLAIN SELECT * FROM employees e,dept_emp d WHERE e.emp_no = d.emp_no AND dept_no = "d005";
+----+-------------+-------+--------+-----------------+---------+---------+--------------------+------+-----------------------+
| id | select_type | table | type   | possible_keys   | key     | key_len | ref                | rows | Extra                 |
+----+-------------+-------+--------+-----------------+---------+---------+--------------------+------+-----------------------+
|  1 | SIMPLE      | d     | ref    | PRIMARY,dept_no | dept_no | 4       | const              |    1 | Using index condition |
|  1 | SIMPLE      | e     | eq_ref | PRIMARY         | PRIMARY | 4       | employees.d.emp_no |    1 | NULL                  |
+----+-------------+-------+--------+-----------------+---------+---------+--------------------+------+-----------------------+
```

**4. ref**：当连接使用的是前缀索引或连接条件不是 PRIMARY KEY 或 UNIQUE INDEX 时则使用它。

```shell
# 这里仅使用了前缀索引emp_no，所以其类型为 ref , 而不是 eq_ref
mysql> EXPLAIN SELECT * FROM employees e,dept_emp d WHERE e.emp_no = d.emp_no;
+----+-------------+-------+------+---------------+---------+---------+--------------------+--------+-------+
| id | select_type | table | type | possible_keys | key     | key_len | ref                | rows   | Extra |
+----+-------------+-------+------+---------------+---------+---------+--------------------+--------+-------+
|  1 | SIMPLE      | e     | ALL  | PRIMARY       | NULL    | NULL    | NULL               | 299379 | NULL  |
|  1 | SIMPLE      | d     | ref  | PRIMARY       | PRIMARY | 4       | employees.e.emp_no |      1 | NULL  |
+----+-------------+-------+------+---------------+---------+---------+--------------------+--------+-------+
```

**5. ref_or_null**：类似于 ref 类型的查询，但是附加了对 NULL 值列的查询。示例语句如下：

```sql
SELECT * FROM ref_table WHERE key_column=expr OR key_column IS NULL;
```

**6. index_merge**：该联接类型表示使用了索引进行合并优化，示例如下：

```shell
mysql> EXPLAIN SELECT * FROM dept_emp WHERE dept_no = "d004" AND emp_no < 10020;
+----+-------------+----------+-------------+-----------------+-----------------+---------+------+------+-----------------------------------------------+
| id | select_type | table    | type        | possible_keys   | key             | key_len | ref  | rows | Extra                                         |
+----+-------------+----------+-------------+-----------------+-----------------+---------+------+------+-----------------------------------------------+
|  1 | SIMPLE      | dept_emp | index_merge | PRIMARY,dept_no | dept_no,PRIMARY | 8,4     | NULL |    1 | Using intersect(dept_no,PRIMARY); Using where |
+----+-------------+----------+-------------+-----------------+-----------------+---------+------+------+-----------------------------------------------+
```

**7. range**：使用索引进行范围扫描，常见于 between、> 、< 这样的查询条件。

```shell
mysql> EXPLAIN SELECT * FROM employees WHERE emp_no > 10000;
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
| id | select_type | table     | type  | possible_keys | key     | key_len | ref  | rows   | Extra       |
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
|  1 | SIMPLE      | employees | range | PRIMARY       | PRIMARY | 4       | NULL | 149689 | Using where |
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
```

**8. index**：索引连接类型与 ALL 相同，只是扫描的是索引树，通常出现在索引是该查询的覆盖索引的情况：

```shell
mysql> EXPLAIN SELECT emp_no FROM employees;
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
| id | select_type | table     | type  | possible_keys | key     | key_len | ref  | rows   | Extra       |
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
|  1 | SIMPLE      | employees | index | NULL          | PRIMARY | 4       | NULL | 299379 | Using index |
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
```

**9. ALL**：全表扫描，效率最差的查找方式。

```shell
mysql> EXPLAIN SELECT * FROM employees WHERE first_name ="Bezalel";
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------------+
| id | select_type | table     | type | possible_keys | key  | key_len | ref  | rows   | Extra       |
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------------+
|  1 | SIMPLE      | employees | ALL  | NULL          | NULL | NULL    | NULL | 299379 | Using where |
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------------+
```

## 5. possible_keys

表示在执行过程中可能会用到哪些索引来进行优化。

## 6. key

表示在执行过程中实际用到的用于优化的索引。

## 7. key_len

表示使用到的索引的字节数。

## 8. ref

显示哪些列或常量与 key 列中指定的索引进行比较。

## 9. rows

MySQL 为了找到目标行而读取的所有行的数量，这是一个估算的值。

## 10. Extra

Extra 列主要用于显示额外的信息，常见信息及其含义如下：

**1. Using  where** ：MySQL 服务器会在存储引擎检索行后再进行过滤。示例如下：

```shell
# first_name 字段是一个普通的列，非索引列
mysql> EXPLAIN SELECT * FROM employees WHERE first_name = "Sumant";
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------------+
| id | select_type | table     | type | possible_keys | key  | key_len | ref  | rows   | Extra       |
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------------+
|  1 | SIMPLE      | employees | ALL  | NULL          | NULL | NULL    | NULL | 299379 | Using where |
+----+-------------+-----------+------+---------------+------+---------+------+--------+-------------+
```

**2. Using filesort**：通常出现在 GROUP BY 或 ORDER BY 语句中，且排序或分组没有基于索引，此时需要使用文件在内存中进行排序。因为使用索引排序的性能好于使用文件排序，所以出现这种情况可以考虑通过添加索引进行优化。示例如下：

```shell
mysql> EXPLAIN SELECT * FROM employees ORDER BY first_name ;
+----+-------------+-----------+------+---------------+------+---------+------+--------+----------------+
| id | select_type | table     | type | possible_keys | key  | key_len | ref  | rows   | Extra          |
+----+-------------+-----------+------+---------------+------+---------+------+--------+----------------+
|  1 | SIMPLE      | employees | ALL  | NULL          | NULL | NULL    | NULL | 299379 | Using filesort |
+----+-------------+-----------+------+---------------+------+---------+------+--------+----------------+
```

**3. Using index**：使用了覆盖索引进行查询，此时不需要访问表，从索引中就可以获取到所需的全部数据。示例如下：

```shell
mysql>  EXPLAIN SELECT emp_no FROM employees;
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
| id | select_type | table     | type  | possible_keys | key     | key_len | ref  | rows   | Extra       |
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
|  1 | SIMPLE      | employees | index | NULL          | PRIMARY | 4       | NULL | 299379 | Using index |
+----+-------------+-----------+-------+---------------+---------+---------+------+--------+-------------+
```

**4. Using  temporary**：表示需要使用临时表来处理查询，常出现在 GROUP BY 或 ORDER BY 语句中，示例如下：

```shell
mysql> EXPLAIN SELECT first_name,count(first_name) FROM employees GROUP BY first_name ;
+----+-------------+-----------+------+---------------+------+---------+------+--------+---------------------------------+
| id | select_type | table     | type | possible_keys | key  | key_len | ref  | rows   | Extra                           |
+----+-------------+-----------+------+---------------+------+---------+------+--------+---------------------------------+
|  1 | SIMPLE      | employees | ALL  | NULL          | NULL | NULL    | NULL | 299379 | Using temporary; Using filesort |
+----+-------------+-----------+------+---------------+------+---------+------+--------+---------------------------------+
```



## 参考资料

更多参数的说明可以参考 MySQL 官方文档：https://dev.mysql.com/doc/refman/8.0/en/explain-output.html
