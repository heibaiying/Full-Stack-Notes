# RabbitMQ 管理

rabbitmqctl 标准语法([] 表示可选参数，{} 表示必选参数)：

rabbitmqctl [-n node] \[-t timeout] [-q] \{command} [command options...]

- **[-n node]**：指定节点；
- **[-t timeout]**：操作超时时间，单位秒；
-  **[-q]** ：quiet 屏蔽一些消息的输出，默认不开启。

### 5.1 虚拟主机与权限

**虚拟主机：**

| 作用         | 命令                                                         | 示例                                 |
| ------------ | ------------------------------------------------------------ | ------------------------------------ |
| 新建虚拟主机 | rabbitmqctl  add_vhost {vhost}                               | rabbitmqctl  add_vhost  vhost1       |
| 罗列虚拟主机 | rabbitmqctl  list_vhosts [vhostinfoitem...]<br/>name：表示vhost 名称<br/>tracing:表示是否启用了RabbitMQ的trace功能 | abbitmqctl  list_vhosts name tracing |
| 删除虚拟主机 | rabbitmqctl delete_vhost {vhost}                             | rabbitmqctl delete_vhost  vhost1     |

**权限管理**：

当创建一个用户时，用户通常会被指派给至少一个vhost,并且只能访问被指派的vhost内的队列、交换器和绑定关系等。因此，RabbitMQ中的授予权限是指在vhost级别对用户而言的权限授予。

| 作用               | 命令                                                         | 示例                                                         |
| ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 权限授予           | rabbitmqctl  set_permissions [-p vhost] {user} {config} {write} {read}<br/>vhost : 授予用户访问权限的 vhost 名称，可以设置为默认值，即 vhost 为 “/”<br/>user: 可以访问指定 vhost 的用户名。<br>conf: 一个用于匹配用户在哪些资源上拥有可配置权限的正则表达式。<br/>write: 一个用于匹配用户在哪些资源上拥有可写权限的正则表达式。<br/>read : 一个用于匹配用户在哪些资源上拥有可读权限的正则表达式 。<br/>可配置指的是队列和交换器的创建及删除之类的操作;可写指的是发布消息;可读指与消息有关的操作，包括读取消息及清空整个队列等。 | 赋予所有权限:<br>rabbitmqctl set_permissions -p vhost1 root ".\*"  ".\*"  ".\*"<br>在以“queue”开头的资源上具备可配置权限：<br>rabbitmqctl set_permissions -p vhost1 root "^queue.\*"  ".\*"  ".\*" |
| 清除权限           | rabbitmqctl clear_permissions [-p vhost] {username}          | rabbitmqctl clear_permissions -p vhost1 root                 |
| 显示虚拟机上的权限 | rabbitmqctl list_permissions [-p vhost]                      | rabbitmqctl list_permissions -p vhost1                       |
| 显示用户权限       | rabbitmqctl list_user_permissions {username}                 | rabbitmqctl list_user_permissions root                       |

### 5.2 用户管理

| 作用               | 命令                                                         |
| ------------------ | ------------------------------------------------------------ |
| 创建用户           | rabbitmqctl  add_user {username} {password}                  |
| 更改密码           | rabbitmqctl change_password {username}  {newpassword}        |
| 验证密码是否正确   | rabbitmqctl authenticate_user {username} {password}          |
| 删除用户           | rabbitmqctl delete_user {username}                           |
| 罗列当前的所有用户 | rabbitmqctl list_users                                       |
| 设置用户角色       | rabbitmqctl set_user_tags {username} {tag ...} <br/>设置0个、1个或者多个角色，设置之后任何之前现有的身份都会被删除 |

用户的角色分为 5 种类型：

- **none**: 无任何角色。新创建的用户的角色默认为 none。
- **management**: 可以访问 Web 管理页面。
- **policymaker**: 包含 management 的所有权限，并且可以 管理策略 ( Policy) 和参数(Parameter)。
- **monitoring**: 包含 management 的所有权限，并且可以看到所有连接、信道及节点相关的信息。
- **administartor**: 包含 monitoring 的所有权限，井且可以管理用户、 虚拟主机、权限、策略、参数等，是最高权限。

### 5.3 web端管理

在使用 Web 管理界面之前需要先启用 RabbitMQ management 插件 。 RabbitMQ 提供了很多的插件，默认存放在 $RABBITMQ_HOME /plugins 目录下 ，插件扩展名为“.ez”。

| 作用     | 命令                                   |
| -------- | -------------------------------------- |
| 启动插件 | rabbitmq-plugins enable [plugin-name]  |
| 关闭插件 | rabbitmq-plugins disable [plugin-name] |
| 查看插件 | rabbitmq-plugins list                  |

### 5.4 应用与集群管理

#### 5.4.1 应用管理

| 命令                             | 作用                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| rabbitmqctl stop [pid_file]      | 用于停止运行 RabbitMQ 的 Erlang 虚拟机和 RabbitMQ 服务应用。<br/>如果指定了 pid_file ,还需要等待指定进程的结束。其中 pid file 是通过调用 rabbitmq-server 命令启动RabbitMQ 服务时创建的，默认情况下存放于Mnesia 目录中，可以通过 RABBITMQ_PID_FILE这个环境变量来改变存放路径。注意，如果使用 rabbitmq-server -detach 这个带有-detach 后缀的命令来启动 RabbitMQ 服务则不会生成 pid file 文件。 |
| rabbitmqctl shutdown             | 用于停止运行 RabbitMQ 的 Erlang 虚拟机和 RabbitMQ 服务应用。执行这个命令会阻塞直到 Erlang 虚拟机进程退出。 |
| rabbitmqctl stop_app             | 停止 RabbitMQ 服务应用，但是 Erlang 虚拟机还是处于运行状态。 |
| rabbitmqctl start_app            | 启动RabbitMQ 服务应用                                        |
| rabbitmqctl wait [pid_file]      | 等待 RabbitMQ 应用的启动。它会等到 pid_file 的创建，然后等待 pid_file 中所代表的进程启动。当指定的进程没有启动 RabbitMQ 应用而关闭时将会返回失败。 |
| rabbitmqctl reset                | RabbitMQ 节点重置还原到最初状态。包括从原来所在的集群中删除此节点，从管理数据库中删除所有的配置数据，如己配置的用户、 vhost 等，以及删除所有的持久化消息。执行rabbitmqctl reset 命令前必须停止RabbitMQ应用(比如先执行 rabbitmqctlstop_app) 。 |
| rabbitmqctl force_reset          | 强制将 RabbitMQ 节点重置还原到最初状态。不同于 rabbitmqctl reset 命令，rabbitmqctl force reset 命令不论当前管理数据库的状态和集群配置是什么，都会无条件地重置节点。它只能在数据库或集群配置己损坏的情况下使用。与 rabbitmqctl reset命令一样，执行 rabbitmqctl force reset 命令前必须先停止 RabbitMQ 应用。 |
| rabbitmqctl rotate_logs {suffix} | 指示 RabbitMQ 节点轮换日志文件。 RabbitMQ 节点会将原来的日志文件中的内容追加到"原始名称+后缀"的日志文件中，然后再将新的日志内容记录到新创建的日志中(与原日志文件同名)。当目标文件不存在时，会新创建。如果不指定后缀 suffix. 则日志文件只是重新打开而不会进行轮换。 |

#### 5.4.2 集群管理

| 命令                                             | 作用                                                         |
| ------------------------------------------------ | ------------------------------------------------------------ |
| rabbitmqctl join_cluster {cluster_node} [-- ram] | 将节点加入指定集群中。<br/>在这个命令执行前需要停止RabbitMQ应用并重置节点。 |
| rabbitmqctl cluster_status                       | 显示集群状态                                                 |
| rabbitmqctl change_cluster_node_type {disc\|ram} | 修改集群节点的类型。<br/>在这个命令执行前需要停止RabbitMQ应用。 |
| rabbitmqctl forget_cluster_node [--offine]       | 将节点重集群中删除，允许离线执行                             |
| rabbitmqctl update_cluster_nodes {clusternode}   | 在集群中的节点应用启动前咨询clusternode节点的最新信息，并更新相应的集群信息。 |
| rabbitmqctl force_boot                           | 确保节点可以启动，即使它不是最后一个关闭的节点。             |
| rabbitmqctl sync_queue [- p vhost] {queue}       | 指示未同步队列 queue 的 slave 镜像可以同步 master 镜像行的内容。同步期间此队列会被阻塞(所有此队列的生产消费者都会被阻塞)，直到同步完成。此条命令执行成功的前提是队列queue 配置了镜像。注意 ， 未同步队列中的消息被耗尽后 ， 最终也会变成同步，此命令主要用于未耗尽的队列。 |
| rabbitmqctl cancel_sync_queue [-p vhost] {queue} | 取消队列queue同步镜像的操作。                                |
| rabbitmqctl set_cluster_name {name}              | 设置集群名称。集群名称默认是集群中第一个节点的名称。         |

### 5.5 服务端状态

#### 1. 队列状态

**命令:  rabbitmqctl list_queues [-p vhost]\[queueinfoitem...]**

此命令返回队列的详细信息，如果无 [-p vhost] 参数，将显示默认的 vhost 为 " / " 中的队列详情 。 queueinfoitem 参数用于指示哪些队列的信息项会包含在结果集中，**结果集的列顺序将匹配参数的顺序** 。 queueinfoitem 可以是下面列表中的任何值 。

- **name**: 队列名称 。
- **durable**: 队列是否持久化 。
- **auto_delete**: 队列是否自动删除 。
- **arguments** : 队列的参数。
- **policy** : 应用到队列上的策略名称 。
- **pid**: 队列关联的 Erlang 进程的 ID 。
- **owner_pid**: 处理排他队列连接的 Erlang 进程 D 。 如果此队列是非排他的，此值将为空。
- **exclusive**: 队列是否是排他的 。
- **exclusive_consumer_pid**: 订阅到此排他队列的消费者相关的信道关联的 Erlang进程ID。如果此队列是非排他的，此值将为空 。
- **exclusive_consumer_tag** : 订阅到此排他队列的消费者的 consumerTag 。 如果此队列是非排他的，此值将为空。
- **messages_ready**: 准备发送给客户端的消息个数 。
- **messages_unacknowledged**: 发送给客户端但尚未应答的消息个数 。
- **messages**: 准备发送给客户端和未应答消息的总和 。
- **messages_ready_ram**: 驻留在内存中 messages_ready 的消息个数 。
- **messages_unacknowledged_ram**: 驻留在内存中 messages_unacknowledged的消息个数 。
- **messages_ram** : 驻留在内存中的消息总数 。
- **messages_persistent** : 队列中持久化消息的个数 。 对于非持久化队列来说总是 0 。
- **messages_bytes**: 队列中所有消息的大小总和 。 这里不包括消息属性或者任何其他开销。
- **messages_bytes_ready**: 准备发送给客户端的消息的大小总和。
- **messages_bytes_unacknowledged**: 发送给客户端但尚未应答的消息的大小总和。
- **messages_bytes_ram**: 驻留在内存中的 messages_bytes 。
- **messages_bytes_persistent**: 队列中持久化的 messages_bytes 。
- **disk_reads**: 从队列启动开始，己从磁盘中读取该队列的消息总次数。
- **disk_writes**: 从队列启动开始，己向磁盘队列写消息的总次数。
- **consumer**: 消费者数目。
- **consumer_utilisation**: 队列中的消息能够立刻投递给消费者的比率，介于 0 和1之间 。这个受网络拥塞或者 Basic.Qos 的影响而小于 1 。
- **memory**: 与队列相关的 Erlang 进程所消耗的内存字节数，包括栈、堆及内部结构 。
- **slave_pids**: 如果队列是镜像的 ，列出所有 slave 镜像的 pid 。
- **synchronised_slave_pids**: 如果队列是镜像的，列出所有己经同步的 slave 镜像的 pid 。
- **state** : 队列状 态。正常情况下是running : 如果队列正常同步数据可能会有"{syncing, MsgCount}" 的状态;如果队列所在的节点掉线了，则队列显示状态为down (此时大多数的 queueinfoitems 也将不可用〉。

**如果没有指定 queueinfoitems ，那么此命令将显示队列的名称和消息的个数。**  



#### 2. 交换机状态

**命令：rabbitmqctl list_exchanges [-p vhost]\[exchangeinfoitem...]**

- **name**: 交换器的名称。
- **type**: 交换器的类型。
- **durable** : 设置是否持久化。 durable 设置为 true 表示持久化，反之是非持久化。持久化可以将交换器信息存盘 ，而在服务器重启的时候不会丢失相关信息。
- **auto_delete** : 设直是否自动删除。
- **internal** : 是否是内置的。
- **arguments** : 其他一些结构化参数，比如 alternate-exchange 。
- **policy** : 应用到交换器上的策略名称。 

**如果没有指定 exchangeinfoitem, 那么此命令将显示交换器的名称和类型。** 



#### 3. 绑定状态

**命令：rabbitmqctl list_bindings [-p vhost]\[bingdinfoitem...]**

- **source_name**: 绑定中消息来源的名称。
- source_kind: 绑定中消息来源的类别。
- **destination_name**: 绑定中消息目的地的名称。
- **destination_kind**: 绑定中消息目的地的种类。
- **routing_key**: 绑定的路由键。
- **arguments**: 绑定的参数。

**如果没有指定 bindinginfoitem，那么将显示所有的条目。** 



#### 4. TCP|IP 连接状态

**命令:  rabbitmqctl list_connections [-p vhost]\[connectioninfoitem...]**

- **pid**: 与连接相关的 Erlang 进程 ID 。
- **name**: 连接的名称。
- **port**: 服务器端口。
- **host**: 返回反向 DNS 获取的服务器主机名称，或者 IP 地址，或者未启用。
- **peer_port**: 服务器对端端口。当一个客户端与服务器连接时，这个客户端的端口就是 peer_port 。
- **peer_host**: 返回反向 DNS 获取的对端主机名称，或者IP地址，或者未启用。 
- **ssl**: 是否启用 SSL 。
- **ssl_protocol**: SSL 协议，如 tlsv1 。
- **ssl_key_exchange**: SSL 密钥交换算法，如 rsa 。
- **ssl_cipher**: SSL 加密算法，如 aes_256_cbc 。
- **ssl_hash**: SSL 哈希算法，如 sha。
- **peer_cert_subject**: 对端的 SSL 安全证书的主题，基于RFC4514 的形式。
- **peer_cert_issuer**: 对端 SSL 安全证书的发行者， 基于RFC4514 的形式 。
- **peer_cert_validity**: 对端 SSL 安全证书的有效期。
- **state**: 连接状态，包括 starting 、tuning 、opening、 running 、flow 、blokcing 、blocked 、closing 和closed这几种。
- **channels**: 该连接中的信道个数。
- **protocol**: 使用的 AMQP 协议的版本，当前是 {0，9 ， 1} 或者 {0， 8 ，0} 。注意，如果客户端请求的是 AMQP 0-9 的连接， RabbitMQ 也会将其视为 0-9-l 。
- **auth_mechanism**: 使用的 SASL 认证机制，如 PLAIN 、 AMQPLAIN 、 EXTERNAL 、RABBIT-CR-DEMO 等 。
- **user**: 与连接相关的用户名。
- **vhost**: 与连接相关的 vhost 的名称。
- **timeout**: 连接超时/协商的心跳间隔，单位为秒。
- **frame** max: 最大传输帧的大小，单位为 B 。
- **channel_max**: 此连接上信道的最大数量。如果值 0 ，则表示无上限，但客户端一般会将 0 转变为 65535 
- **client_properties**: 在建立连接期间由客户端发送的信息属性。
- **recv_oct**: 收到的字节数。
- **recv_cnt**: 收到的数据包个数。 
- **send_oct**: 发送的字节数。
- **end_cnt** : 发送的数据包个数。
- **send_pend**: 发送队列大小。
- **connected_at** : 连接建立的时间戳。 



#### 5. 信道状态

**命令:  rabbitmqctl list_channels [-p vhost]\[channelinfoitem...]**

- **pid**: 与连接相关的 Erlang 进程 ID 。
- **connection** : 信道所属连接的 Erlang 进程 ID 。
- **name** : 信道的名称。
- **number**: 信道的序号。
- **user**: 与信道相关的用户名称。
- **vhost** : 与信道相关的 vhost。
- **transactional**: 信道是否处于事务模式。
- **confirm** : 信道是否处于 publisher confirm 模式。
- **consumer_count** : 信道中的消费者的个数。
- **messages_unacknowledged**: 己投递但是还未被 ack 的消息个数。 
- **messages_uncommitted** : 己接收但是还未提交事务的消息个数 。
- **acks_uncommitted** : 己 ack 收到但是还未提交事务的消息个数 。
- **messages_unconfirmed** : 己发送但是还未确认的消息个数 。 如果信道不处于publisher confmn 模式下 ，则此值为 0 。
- **perfetch_count** : 新消费者的 Qos 个数限制 。 0 表示无上限 。
- **global_prefetch_count**: 整个信道的 Qos 个数限制 。 0 表示无上限 。 



#### 6.消费者状态

**命令:  rabbitmqctl list_consumers [-p vhost]**



#### 7.Brokder的状态

**命令:  rabbitmqctl status**

显示 Broker 的状态， 比如当前 Erlang 节点上运行的应用程序、 RabbitMQ/Erlang 的版本信息、 os 的名称 、内存及文件描述符等统计信息。 



#### 8.其他状态

**rabbitmqctl node_health_check**
对 RabbitMQ 节点进行健康检查 ， 确定应用是否正常运行。

**rabbitmqctl environment**
显示每个运行程序环境中每个变量的名称和值。

**rabbitmqctl report**
为所有服务器状态生成一个服务器状态报告，井将输出重定向到一个文件。相关示例如下 :

```shell
[root@nodel -]# rabbitmqctl report > report.txt
```

**rabbitmqctl eval {expr}**
执行任意 Erlang 表达式。相关示例如下(示例命令用于返回 rabbitmqctl 连接的节点名称) :

```shell
[root@nodel - ]# rabbitmqctl eval 'node().'
rabbit@nodel 
```



