# MySQL EXPLAIN 

EXPLAIN 关键字可以用于获取所修饰语句执行计划的相关信息，在 MySQL 8.0 中，EXPLAIN  支持大多数常见的语句，如 SELECT 、DELETE 、INSERT 、REPLACE、和 UPDATE 语句。示例如下：

```sql
-- 查询工资大于100000的雇员所在部门的编号
EXPLAIN SELECT * FROM dept_emp WHERE emp_no IN (SELECT emp_no FROM salaries WHERE salary > 100000) LIMIT 100;
```

![mysql-explain](D:\Full-Stack-Notes\pictures\mysql-explain.png)

```sql

mysql> EXPLAIN SELECT * FROM dept_emp WHERE emp_no IN (SELECT emp_no FROM salaries WHERE salary > 100000) LIMIT 100;
+----+-------------+----------+------+---------------+---------+---------+---------------------------+--------+-----------------------------------+
| id | select_type | table    | type | possible_keys | key     | key_len | ref                       | rows   | Extra                             |
+----+-------------+----------+------+---------------+---------+---------+---------------------------+--------+-----------------------------------+
|  1 | SIMPLE      | dept_emp | ALL  | PRIMARY       | NULL    | NULL    | NULL                      | 331570 | NULL                              |
|  1 | SIMPLE      | salaries | ref  | PRIMARY       | PRIMARY | 4       | employees.dept_emp.emp_no |      4 | Using where; FirstMatch(dept_emp) |
+----+-------------+----------+------+---------------+---------+---------+---------------------------+--------+-----------------------------------+
```

> 注：本篇文章测试数据来源于 MySQL 官方提供的 [Employees Sample Database](https://dev.mysql.com/doc/employee/en/)

### 1. id

每个 SELECT 语句都会对应输出结果中的一行数据，id 列是该行数据的编号，如果在语句当中没有子查询或者联合查询，则每行数据的编号都是 1 。如果涉及到 FROM 子查询 或者 UNION 查询，则编号通常会按照其在原始语句中的位置排序。示例如下：

```sql
-- 该FROM字句只是用于演示
mysql> EXPLAIN SELECT COUNT(1) FROM (SELECT emp_no FROM salaries) AS s;
+----+-------------+------------+-------+
| id | select_type | table      | type  |
+----+-------------+------------+-------+
|  1 | PRIMARY     | <derived2> | ALL   |
|  2 | DERIVED     | salaries   | index |
+----+-------------+------------+-------+ ......
```

```sql
-- 查询工资大于500000或部门编号等于d007的所有雇员的编号
mysql> EXPLAIN SELECT emp_no FROM salaries WHERE salary>500000 UNION ALL SELECT emp_no FROM dept_emp  WHERE dept_no = "d007";
+----+--------------+------------+------+
| id | select_type  | table      | type |
+----+--------------+------------+------+
|  1 | PRIMARY      | salaries   | ALL  |
|  2 | UNION        | dept_emp   | ref  |
| NULL | UNION RESULT | <union1,2> | ALL | 
+----+--------------+------------+------+  ......
```

### 2. select_type

### 3. table

- **<union*M*,*N*>**：输出结果中编号为 M 的行与编号为 N 的行的结果集的并集。
- **<derived*N*>**：输出结果中编号为 N 的行的结果集，使用 derived 修饰表示这是一个派生结果集，如来自于 FROM 子句中的子查询 。
- **<subquery*N*>**：输出结果中编号为 N 的行的结果集，使用 subquery 修饰表示其来源于一个物化子查询。

### 4. type

这个字段表示 MySQL 如何查找表中的行。常见参数按照查找性能由低到高，排序如下：

+ ALL：全表扫描；
+ index：按照索引顺序而不是行顺序进行全表扫描；
+ range：范围扫描；
+ ref：

### 5. possible_keys

表示在执行过程中可能会用到哪些索引来进行优化。

### 6. key

表示在执行过程中实际用到的用于优化的索引。

### 7. key_len

表示使用到的索引的字节数。

### 8. ref



### 9. rows

MySQL 为了找到目标行而读取的所有行的数量，这是一个估算的值。

### 10. Extra

用于显示额外的信息，常用

### 11. partitions

显示查询结果集中记录所在的分区。如果目标表不是分区表，则值为 null 。