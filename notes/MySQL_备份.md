# 数据备份与恢复

## 一、备份

## 二、mysqldump

### 2.1 基本语法

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



## 三、Xtrabackup

### 3.1 安装

Xtrabackup 可以直接使用 yum 命令进行安装，这里我的 MySQL 为 8.0 ，对应安装的 Xtrabackup 也为 8.0，命令如下：

```shell
# 安装Percona yum 源
yum install https://repo.percona.com/yum/percona-release-latest.noarch.rpm

# 安装
yum install percona-xtrabackup-80
```

### 3.2 全量备份

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

### 3.3 增量备份

#### 1. 创建备份

```shell
xtrabackup  --user=root --password --backup  --target-dir=/data/backups/base/
```



```shell
xtrabackup  --user=root --password --backup  --target-dir=/data/backups/inc1 \
--incremental-basedir=/data/backups/base
```



```shell
xtrabackup  --user=root --password --backup  --target-dir=/data/backups/inc2 \
--incremental-basedir=/data/backups/inc1
```

#### 2. 准备备份

```shell
xtrabackup --prepare --apply-log-only --target-dir=/data/backups/base
```

```shell
xtrabackup --prepare --apply-log-only --target-dir=/data/backups/base \
--incremental-dir=/data/backups/inc1
```

```shell
xtrabackup --prepare --target-dir=/data/backups/base \
--incremental-dir=/data/backups/inc2
```

#### 3. 恢复备份

```shell
xtrabackup --copy-back --target-dir=/data/backups/base

chown -R mysql:mysql /usr/app/mysql-8.0.17/data
```

