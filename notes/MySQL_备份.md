# 数据备份与恢复

## 一、备份简介

### 2.1 备份分类

按照不同的思考维度，通常将数据库的备份分为以下几类：

**物理备份 与 逻辑备份**

+ 物理备份：备份的是完整的数据库目录和数据文件。由于其基本都是 IO 复制，并不含任何逻辑转换，因此其备份和恢复速度通常都比较快。
+ 逻辑备份：通过数据库结构和内容信息来进行备份。因为要执行逻辑转换，因此其速度较慢，并且在以文本格式保存时，其输出文件的大小要远大于物理备份。逻辑备份和还原的粒度可以从服务器级别（所有数据库）精确到具体表，但备份不会包括日志文件、配置文件等与数据库无关的内容。

**全量备份 与 增量备份**

+ 全量备份：备份服务器在给定时间点上的所有数据。
+ 增量备份：备份在给定时间跨度内（从一个时间点到另一个时间点）对数据所做的更改。

**在线备份 与 离线备份**

+ 在线备份：在数据库服务运行状态下进行备份。此时其他客户端依旧可以连接到数据库，但为了保证数据的一致性，在备份期间必然会存在对数据加锁的操作，此时客户端的访问仍然可能受限。
+ 离线备份：在数据库服务停机状态下进行备份。此时备份过程更加简单，但会此时由于无法提供对外服务，通常会对业务造成比较大的影响。

### 2.2 备份工具

MySQL 支持的备份工具有很多种，这里列出常用的三种：

+ **mysqldump**：这是 MySQL 自带的备份工具，其采用的备份方式是逻辑备份，支持全库备份、单库备份、单表备份。由于其采用的是逻辑备份，所以生成的备份文件比物理备份的大，且所需恢复时间也比较长。
+ **mysqlpump**：这是 MySQL 5.7 之后新增的备份工具，在 mysqldump 的基础上进行了功能的扩展，支持多线程备份，支持对备份文件进行压缩，能够提高备份的速度和降低备份文件所需的储存空间。
+ **Xtrabackup**：这是 Percona 公司开发的实时热备工具，能够在不停机的情况下进行快速可靠的热备份，并且备份期间不会间断数据库事务的处理。它支持数据的全备和增备，并且由于其采用的是物理备份的方式，所以恢复速度比较快。

## 二、mysqldump

### 2.1 常用参数

mysqldump 的基本语法如下：

```shell
# 备份数据库或数据库中的指定表
mysqldump [options] db_name [tbl_name ...]
# 备份多个指定的数据库
mysqldump [options] --databases db_name ...
# 备份当前数据库实例中的所有表
mysqldump [options] --all-databases
```

options 代表可选操作，常用的可选参数如下：

+ **--host=host_name， -h host_name**

  指定服务器地址。

+ **--user=user_name， -u user_name**

  指定用户名。

+ **--password[=password]， -p[password]**

  指定密码。通常不用在命令行中明文指定，按照提示输出即可。

+ **--default-character-set=charset_name**

  导出文本使用的字符集，默认为 utf8。

+ **--events， -E**

  备份包含包含数据库中的事件。

+ **--ignore-table=db_name.tbl_name**

  不需要进行备份的表，必须使用数据库和表名来指定。也可以作用于视图。

+ **--routines， -R**

  备份包含包含数据库中的存储过程和自定义函数。

+ **--triggers**

  备份包含包含数据库中的触发器。

+ **--where='where_condition'， -w 'where_condition'**

  在对单表进行导出时候，可以指定过滤条件，例如指定用户名 `--where="user='jimf'"` 或用户范围 `-w"userid>1"` 。

+ **--lock-all-tables， -x**

  锁定所有数据库中的所有表，从而保证备份数据的一致性。此选项自动关闭 --single-transaction 和 --lock-tables。

+ **--lock-tables， -l**

  锁定当前数据库中所有表，能够保证当前数据库中表的一致性，但不能保证全局的一致性。

  由于--lock-tables每个数据库的锁表都是单独的，因此该选项不保证转储文件中的表在数据库之间在逻辑上是一致的。不同数据库中的表可能会以完全不同的状态转储。

+ **--single-transaction**

  此选项会将事务隔离模式设置为： REPEATABLE READ 并开启一个事务，从而保证备份数据的一致性。主要用于事务表，如 InnoDB 表。 但是此时仍然不能在备份表上执行 ALTER TABLE， CREATE TABLE， DROP TABLE， RENAME TABLE， TRUNCATE TABLE 等操作，因为 REPEATABLE READ 隔离并不能隔离这些操作。

  另外需要注意的是 --single-transaction 选项与 --lock-tables 选项是互斥的，因为 LOCK TABLES 会导致任何正在挂起的事务被隐式提交。转储大表时，可以将 --single-transaction 选项与 --quick 选项组合使用 。

+ **--quick， -q**

  主要用于备份大表。它强制 mysqldump 一次只从服务器检索一行数据，避免一次检索所有行而导致缓存溢出。

+ **--flush-logs, -F**

  在开始备份前刷新 MySQL 的日志文件。此选项需要 RELOAD 权限。如果此选项与 --all-databases 配合使用，则会在每个数据库开始备份前都刷新一次日志。如果配合 --lock-all-tables，--master-data 或 --single-transaction 使用，则只会在锁定所有表或者开启事务时刷新一次。

### 2.2 全量备份

mysqldump 的全量备份与恢复操作比较简单，使用示例如下：

```shell
# 备份雇员库
mysqldump  -uroot -p --databases employees > employees_bak.sql

# 恢复雇员库
mysql -uroot -p  < employees_bak.sql
```

单表备份：

```shell
# 备份雇员库中的职位表
mysqldump  -uroot -p --single-transaction employees titles > titles_bak.sql

# 恢复雇员库中的职位表
mysql> use employees;
mysql> source /root/mysqldata/titles_bak.sql;
```

### 2.3 增量备份

## 三、mysqlpump

### 3.1 简介

mysqlpump 在 mysqldump 的基础上进行了扩展增强，其主要的优点如下：

- 能够并行处理数据库及其中的对象，从而可以加快备份进程；

- 能够更好地控制数据库及数据库对象（表，存储过程，用户帐户等）；

- 能够直接对备份文件进行压缩；

- 备份时能够显示进度指标（估计值）；
- 备份用户时生成的是 CREATE USER 与 GRANT 语句，而不是像 mysqldump 一样直接备份成数据，可以方便用户按需恢复。

### 3.2 常用参数

mysqlpump 的使用和 mysqldump 基本一致，这里不再进行赘述。以下主要介绍部分新增的可选项，具体如下：

+ **--default-parallelism=N**

  每个并行处理队列的默认线程数。默认值为 2。

+ **--parallel-schemas=[N:]db_list**

  用于并行备份多个数据库：db_list 是一个或多个以逗号分隔的数据库名称列表；N 为使用的线程数，如果没有设置，则使用 --default-parallelism 参数的值。

+ **--users**

  将用户信息备份为 CREATE USER 语句和 GRANT语句 。如果想要只备份用户信息，则可以使用下面的命令：

  ```shell
  mysqlpump --exclude-databases=% --users
  ```

+ **--compress-output=algorithm**

  默认情况下，mysqlpump 不对备份文件进行压缩。可以使用该选项指定压缩格式，当前支持 LZ4 和 ZLIB 两种格式。需要注意的是压缩后的文件可以占用更少的存储空间，但是却不能直接用于备份恢复，需要先进行解压，具体如下：

  ```shell
  # 采用lz4算法进行压缩
  mysqlpump --compress-output=LZ4 > dump.lz4
  # 恢复前需要先进行解压
  lz4_decompress input_file output_file
  
  # 采用ZLIB算法进行压缩
  mysqlpump --compress-output=ZLIB > dump.zlib
  zlib_decompress input_file output_file
  ```

  MySQL 发行版自带了上面两个压缩工具，不需要进行额外安装。以上就是 mysqlpump 新增的部分常用参数，完整参数可以参考官方文档：[mysqlpump — A Database Backup Program](https://dev.mysql.com/doc/refman/8.0/en/mysqlpump.html#option_mysqlpump_compress-output)

## 四、Xtrabackup

### 4.1 安装

Xtrabackup 可以直接使用 yum 命令进行安装，这里我的 MySQL 为 8.0 ，对应安装的 Xtrabackup 也为 8.0，命令如下：

```shell
# 安装Percona yum 源
yum install https://repo.percona.com/yum/percona-release-latest.noarch.rpm

# 安装
yum install percona-xtrabackup-80
```

### 4.2 全量备份

#### 1. 创建备份

Xtrabackup 全量备份的基本语句如下，可以使用 target-dir 指明备份文件的存储位置，parallel 则是指明操作的并行度：

```shell
xtrabackup --backup  --user=root --password --parallel=3  --target-dir=/data/backups/
```

以上进行的是整个数据库实例的备份，如果需要备份指定数据库，则可以使用 --databases 进行指定。

另外一个容易出现的异常是：Xtrabackup 在进行备份时，默认会去 `/var/lib/mysql/mysql.sock` 文件里获取数据库的 socket 信息，如果你修改了数据库的 socket 配置，则需要使用 --socket 参数进行重新指定，否则会抛出找不到连接的异常。备份完整后需要立即执行的另外一个操作是 prepare。

#### 2. 准备备份

由于备份是将所有物理库表等文件复制到备份目录，而整个过程需要持续一段时间，此时备份的数据中就可能会包含尚未提交的事务或已经提交但尚未同步至数据文件中的事务，最终导致备份结果处于不一致状态。此时需要进行 prepare 操作来回滚未提交的事务及同步已经提交的事务至数据文件，从而使得整体达到一致性状态。命令如下：

```shell
xtrabackup --prepare --target-dir=/data/backups/
```

需要特别注意的在该阶段不要随意中断 xtrabackup 进程，因为这可能会导致数据文件损坏，备份将无法使用。

#### 3. 恢复备份

由于 xtrabackup 执行的是物理备份，所以想要进行恢复，必须先要停止 MySQL 服务。同时这里我们可以删除 MySQL 的数据目录来模拟数据丢失的情况，之后使用以下命令将备份文件拷贝到 MySQL 的数据目录下：

```shell
# 模拟数据异常丢失
rm -rf /usr/app/mysql-8.0.17/data/*

# 将备份文件拷贝到 data 目录下
xtrabackup --copy-back --target-dir=/data/backups/
```

copy-back 命令只需要指定备份文件的位置，不需要指定 MySQL 数据目录的位置，因为 Xtrabackup 会自动从 `/etc/my.cnf` 上获取 MySQL 的相关信息，包括数据目录的位置。如果不需要保留备份文件，可以直接使用 --move-back 命令，代表直接将备份文件移动到数据目录下。通常此时数据目录的所有者为执行命令的用户，需要更改为 mysql 用户，命令如下：

```shell
chown -R mysql:mysql /usr/app/mysql-8.0.17/data
```

再次启动即可完成备份恢复。

### 4.3 增量备份

使用 Xtrabackup 进行增量备份时，每一次增量备份都需要以上一次的备份为基础，之后再将增量备份运用到第一次全备之上，从而完成备份。具体操作如下：

#### 1. 创建备份

这里首先创建一个全备作为基础：

```shell
xtrabackup  --user=root --password --backup  --target-dir=/data/backups/base/
```

之后修改库中任意数据，然后进行第一次增量备份，此时需要使用 incremental-basedir 指定基础目录为全备目录：

```shell
xtrabackup  --user=root --password --backup  --target-dir=/data/backups/inc1 \
--incremental-basedir=/data/backups/base
```

再修改库中任意数据，然后进行第二次增量备份，此时需要使用 incremental-basedir 指定基础目录为上一次增备目录：

```shell
xtrabackup  --user=root --password --backup  --target-dir=/data/backups/inc2 \
--incremental-basedir=/data/backups/inc1
```

#### 2. 准备备份

准备基础备份：

```shell
xtrabackup --prepare --apply-log-only --target-dir=/data/backups/base
```

将第一次备份作用于全备数据：

```shell
xtrabackup --prepare --apply-log-only --target-dir=/data/backups/base \
--incremental-dir=/data/backups/inc1
```

将第二次备份作用于全备数据：

```shell
xtrabackup --prepare --target-dir=/data/backups/base \
--incremental-dir=/data/backups/inc2
```

在准备备份时候，除了最后一次增备外，其余的准备命令都需要加上 `--apply-log-only` 选项来阻止事务的回滚，因为备份时未提交的事务可能正在进行，并可能在下一次增量备份中提交。如全备中的某些事务可能在第一次备份中才会提交，如果不进行阻止，那么增量备份将没有任何意义。

#### 3. 恢复备份

恢复备份和全量备份时相同，只需要最终准备好的全备数据复制到 MySQL 的数据目录下即可：

```shell
xtrabackup --copy-back --target-dir=/data/backups/base
# 必须修改文件权限，否则无法启动
chown -R mysql:mysql /usr/app/mysql-8.0.17/data
```

此时增量备份就已经完成。需要说明的是：按照上面的情况，如果第二次备份之后发生了宕机，那么第二次备份后到宕机前的数据依然没法通过 Xtrabackup 进行恢复，此时就只能采用上面介绍的分析二进制日志的恢复方法。由此可以看出，无论是采用何种备份方式，二进制日志都是非常重要的，因此最好对其进行实时备份。

## 五、二进制日志的备份



## 参考资料

+ [Chapter 7 Backup and Recovery](https://dev.mysql.com/doc/refman/8.0/en/backup-and-recovery.html)
+ [mysqldump — A Database Backup Program](https://dev.mysql.com/doc/refman/8.0/en/mysqldump.html)
+ [mysqlpump — A Database Backup Program](https://dev.mysql.com/doc/refman/8.0/en/mysqlpump.html)
+ [Percona XtraBackup - Documentation](https://www.percona.com/doc/percona-xtrabackup/LATEST/index.html)