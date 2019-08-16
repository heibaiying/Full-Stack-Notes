## 一、基于二进制日志的复制

主节点配置：

```properties
[mysqld]
server-id = 226
# 开启二进制日志
log-bin=mysql-bin
```

从节点配置：

```properties
[mysqld]
server-id = 227
# 配置中继日志
relay_log  = mysql-relay-bin
# 为了保证数据的一致性，从节点应该设置为只读
read_only = 1
# 以下两个配置代表是否开启二进制日志，如果存在其他节点需要从该从节点上复制数据，则开启，否则不用配置
log-bin = mysql-bin
# 是否将中继节点收到的复制事件写到自己的二进制日志中
log_slave_updates = 1
```

创建复制账号：

```shell
CREATE USER 'repl'@'192.168.0.%' IDENTIFIED WITH mysql_native_password BY '123456'; 
GRANT REPLICATION SLAVE on *.* TO 'repl'@'192.168.0.%' ;
```

查看主节点日志状态：

```shell
mysql> SHOW MASTER STATUS;
+------------------+----------+--------------+------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+------------------+----------+--------------+------------------+-------------------+
| mysql-bin.000001 |      887 |              |                  |                   |
+------------------+----------+--------------+------------------+-------------------+
```

建立复制链路：

```shell
CHANGE MASTER TO MASTER_HOST='192.168.0.226',\
 		MASTER_USER='repl',	\
		MASTER_PASSWORD='123456',\
		MASTER_LOG_FILE='mysql-bin.000001',\
		MASTER_LOG_POS=887;
```

开始复制：

```shell
START SLAVE;
```

查看从节点复制状态：

```shell
mysql> SHOW SLAVE STATUS\G
*************************** 1. row ***************************
               Slave_IO_State: Waiting for master to send event
                  Master_Host: 192.168.0.226
                  Master_User: repl
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: mysql-bin.000001
          Read_Master_Log_Pos: 887
               Relay_Log_File: mysql-relay-bin.000002
                Relay_Log_Pos: 322
        Relay_Master_Log_File: mysql-bin.000001
        #    Slave_IO_Running: Yes
        #   Slave_SQL_Running: Yes
              Replicate_Do_DB:
          Replicate_Ignore_DB:
           Replicate_Do_Table:
       Replicate_Ignore_Table:
      Replicate_Wild_Do_Table:
  Replicate_Wild_Ignore_Table:
                   Last_Errno: 0
                   Last_Error:
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 887
              Relay_Log_Space: 530
              Until_Condition: None
               Until_Log_File:
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File:
           Master_SSL_CA_Path:
              Master_SSL_Cert:
            Master_SSL_Cipher:
               Master_SSL_Key:
     #  Seconds_Behind_Master: 0
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error:
               Last_SQL_Errno: 0
               Last_SQL_Error:
  Replicate_Ignore_Server_Ids:
             Master_Server_Id: 226
                  Master_UUID: e1148574-bdd0-11e9-8873-0800273acbfd
             Master_Info_File: mysql.slave_master_info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State: Slave has read all relay log; waiting for more updates
           Master_Retry_Count: 86400
                  Master_Bind:
      Last_IO_Error_Timestamp:
     Last_SQL_Error_Timestamp:
               Master_SSL_Crl:
           Master_SSL_Crlpath:
           Retrieved_Gtid_Set:
            Executed_Gtid_Set:
                Auto_Position: 0
         Replicate_Rewrite_DB:
                 Channel_Name:
           Master_TLS_Version:
       Master_public_key_path:
        Get_master_public_key: 0
            Network_Namespace:
1 row in set (0.00 sec)
```

## 二、基于 GTID 的复制

主从服务器均增加以下配置：

```properties
gtid-mode = ON
enforce-gtid-consistency = ON
```

在从服务器上执行以下命令，关闭原有复制链路：

```shell
STOP SLAVE IO_THREAD FOR CHANNEL '';
```

建立新的 GTID 复制链路：

```shell
CHANGE MASTER TO MASTER_HOST='192.168.0.226',\
		MASTER_USER='repl',
		MASTER_PASSWORD='123456',
		MASTER_AUTO_POSITION=1;
```

开始复制：

```shell
START SLAVE;
```

查看从节点复制状态：

在主节点上执行任意修改操作，查看复制情况：

```
Retrieved_Gtid_Set: e1148574-bdd0-11e9-8873-0800273acbfd:1-2
Executed_Gtid_Set: e1148574-bdd0-11e9-8873-0800273acbfd:1-2
```

