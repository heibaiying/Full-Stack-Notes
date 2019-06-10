

# 《linux就该这么学》读书笔记

## 目录<br/>
<a href="#第一章-部署虚拟环境安装Linux系统">第一章 部署虚拟环境安装Linux系统</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#16-Yum-软件仓库">1.6 Yum 软件仓库</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#17-systemd-初始化进程">1.7 systemd 初始化进程</a><br/>
<a href="#第二章-新手必须掌握的Linux命令">第二章 新手必须掌握的Linux命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-执行查看帮助命令">2.2 执行查看帮助命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-常用系统工作命令">2.3 常用系统工作命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-echo命令">1. echo命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-date命令">2. date命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-reboot-命令">3. reboot 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-poweroff命令">4. poweroff命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-wget命令">5. wget命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6-ps-命令">6. ps 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7-top-命令">7. top 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8-pidof-命令">8. pidof 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#9-kill命令">9. kill命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#10-killall-命令">10. killall 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#24-系统状态检测命令">2.4 系统状态检测命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-ifconfig-命令">1. ifconfig 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-uname-命令">2. uname 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-uptime-命令">3. uptime 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-free-命令">4. free 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-who-命令">5. who 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6-last-命令">6. last 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7-history-命令">7. history 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8-sosreport-命令">8. sosreport 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-pwd-命令">1. pwd 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-cd-命令">2. cd 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-ls命令">3. ls命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#26-文本文件编辑命令">2.6 文本文件编辑命令 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-cat-命令">1. cat 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-more-命令">2. more 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3head-命令">3.head 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-tail-命令">4. tail 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-tr-命令">5. tr 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6-wc-命令">6. wc 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7-stat-命令">7. stat 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8-cut命令">8. cut命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#9-diff-命令">9. diff 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-touch-命令">1. touch 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-mkdir-命令">2. mkdir 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-cp-命令">3. cp 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-mv-命令">4. mv 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-rm-命令">5. rm 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6-dd-命令">6. dd 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7-file命令">7. file命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#28-打包压缩与搜索命令">2.8 打包压缩与搜索命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-tar-命令">1. tar 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-grep-命令">2. grep 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-find命令">3. find命令</a><br/>
<a href="#第三章-管道符、重定向与环境变量">第三章 管道符、重定向与环境变量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#31-输入输出重定向">3.1 输入输出重定向</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-管道运算符">3.2 管道运算符</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#33-命令通配符">3.3 命令通配符</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-常用的转义字符">3.4 常用的转义字符</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#35-重要的环境变量">3.5 重要的环境变量</a><br/>
<a href="#第四章-Vim-编辑器与-shell-脚本命令">第四章 Vim 编辑器与 shell 脚本命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-vim编辑器">4.1 vim编辑器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-编写的脚本">4.2 编写的脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#421-编写简单的脚本">4.2.1 编写简单的脚本</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#422-接受用户参数">4.2.2 接受用户参数</a><br/>
<a href="#43-流程控制语句">4.3 流程控制语句</a><br/>
<a href="#44-计划任务服务程序">4.4 计划任务服务程序</a><br/>
<a href="#第五章-用户身份与文件权限">第五章 用户身份与文件权限</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-用户身份与能力">5.1 用户身份与能力</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-useradd-命令">1. useradd 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-groupadd-命令">2. groupadd 命令 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-usermod-命令">3. usermod 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4-passwd-命令">4. passwd 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5-userdel-命令">5. userdel 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-文件权限与归属">5.2 文件权限与归属</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#53-文件的特殊权限">5.3 文件的特殊权限</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#531-SUID">5.3.1 SUID</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#532-SGID">5.3.2 SGID</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1chmod命令">1.chmod命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2chown命令">2.chown命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#533-SBIT">5.3.3 SBIT</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#54-文件的隐藏属性">5.4 文件的隐藏属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1--chattr命令">1.  chattr命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-lsattr-命令">2. lsattr 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#55-文件访问控制列表">5.5 文件访问控制列表</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#551-setfacl-命令">5.5.1 setfacl 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#552-getfacl-命令">5.5.2 getfacl 命令</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#56-su命令与sudo服务">5.6 su命令与sudo服务</a><br/>
<a href="#第六章-存储结构与磁盘划分">第六章 存储结构与磁盘划分</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#61-一切从“/”开始">6.1 一切从“/”开始</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-物理设备的命名规则">6.2 物理设备的命名规则</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#64-挂载硬件设备">6.4 挂载硬件设备</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1挂载">1.挂载</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2永久挂载">2.永久挂载</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3撤消挂载">3.撤消挂载</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#68-软硬链接连接方式">6.8 软硬链接连接方式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-ln-命令">1. ln 命令</a><br/>
<a href="#第八章--Iptables与Firewalld防火墙">第八章  Iptables与Firewalld防火墙</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#82-iptables">8.2 iptables</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#821-策略与规则链">8.2.1 策略与规则链 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#822-基本的命令参数">8.2.2 基本的命令参数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#83-Firewalld">8.3 Firewalld</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#831-终端管理工具">8.3.1 终端管理工具</a><br/>
## 正文<br/>


## 第一章 部署虚拟环境安装Linux系统

### 1.6 Yum 软件仓库

**表：常见的yum命令**

| 命令                      | 列出所有仓库                 |
| ------------------------- | ---------------------------- |
| yum repolist all          | 列出所有仓库                 |
| yum list all              | 列出仓库中所有软件包         |
| yum info 软件包名称       | 查看软件包信息               |
| yum install 软件包名称    | 安装软件包                   |
| yum reinstall 软件包名称  | 重新安装软件包               |
| yum update 软件包名称     | 升级软件包                   |
| yum remove 软件包名称     | 移除软件包                   |
| yum clean all             | 清除所有仓库缓存             |
| yum check-update          | 检查可更新的软件包           |
| yum grouplist             | 查看系统中已经安装的软件包组 |
| yum groupinstall 软件包组 | 安装指定的软件包组           |
| yum groupremove 软件包组  | 移除指定的软件包组           |
| yum groupinfo 软件包组    | 查询指定的软件包组信息       |



### 1.7 systemd 初始化进程

**表：systemctl 管理服务的启动、重启、停止、重载、查看状态等常用命令** 

| System V init 命令（RHE6系统） | systemctl命令（RHEL 7 系统）  | 作用                           |
| ------------------------------ | ----------------------------- | ------------------------------ |
| service foo start              | systemctl start foo.service   | 启动服务                       |
| service foo restart            | systemctl restart foo.service | 重启服务                       |
| service foo stop               | systemctl stop foo.service    | 停止服务                       |
| service foo reload             | systemctl reload foo.service  | 重新加载配置文件（不终止服务） |
| service foo status             | systemctl status foo.service  | 查看服务状态                   |



**表：systemctl 设置服务开机启动、不启动、查看各级别下服务启动状态等常用命令** 

| System V init 命令（RHE6系统） | systemctl命令（RHEL 7 系统）             | 作用                               |
| ------------------------------ | ---------------------------------------- | ---------------------------------- |
| chkconfig foo in               | systemctl enable foo.service             | 开机自动启动                       |
| chkconfig foo off              | systemctl disable foo.service            | 开机不自动启动                     |
| chkconfig foo                  | systemctl is-enable foo.service          | 查看特定服务是否为开启自动启动     |
| chkconfig --list               | systemctl list-unit-files --type=service | 查看各个级别下服务的启动与禁用情况 |



```shell
[root@localhost ~]# chkconfig docker
注意：正在将请求转发到“systemctl is-enabled docker.service”。
enabled
```



## 第二章 新手必须掌握的Linux命令

### 2.2 执行查看帮助命令

**表：man命令中常用按键以及用途**

| 按键      | 用处                               |
| --------- | ---------------------------------- |
| 空格键    | 向下翻一页                         |
| PaGe down | 向下翻一页                         |
| PaGe up   | 向上翻一页                         |
| home      | 直接前往首页                       |
| end       | 直接前往尾页                       |
| /         | 从上至下搜索某个关键词，如“/linux” |
| ?         | 从下至上搜索某个关键词，如“?linux” |
| n         | 定位到下一个搜索到的关键词         |
| N         | 定位到上一个搜索到的关键词         |
| q         | 退出帮助文档                       |

### 2.3 常用系统工作命令

#### 1. echo命令

echo 命令用于在终端输出字符串或变量提取后的值，格式为“echo [字符串 | $变量]”。 

```shell
[root@localhost ~]# echo hello
hello
[root@localhost ~]# echo $SHELL
/bin/bash
```

#### 2. date命令

date命令用于显示及设置系统的时间或日期。

**表： date命令中的参数以及作用**

| 参数 | 作用           |
| ---- | -------------- |
| %t   | 跳格[Tab键]    |
| %H   | 小时（00～23） |
| %I   | 小时（00～12） |
| %M   | 分钟（00～59） |
| %S   | 秒（00～59）   |
| %j   | 今年中的第几天 |

按照默认格式查看当前系统时间的date命令如下所示：

```shell
[root@linuxprobe ~]# date
Mon Aug 24 16:11:23 CST 2017
```

按照“年-月-日 小时:分钟:秒”的格式查看当前系统时间的date命令如下所示：

```shell
[root@linuxprobe ~]# date "+%Y-%m-%d %H:%M:%S"
2017-08-24 16:29:12
```

将系统的当前时间设置为2017年9月1日8点30分的date命令如下所示：

```shell
[root@linuxprobe ~]# date -s "20170901 8:30:00"
Fri Sep 1 08:30:00 CST 2017
```

再次使用date命令并按照默认的格式查看当前的系统时间，如下所示：

```shell
[root@linuxprobe ~]# date
Fri Sep 1 08:30:01 CST 2017
```

date命令中的参数%j可用来查看今天是当年中的第几天。

```shell
[root@linuxprobe ~]# date "+%j"
244
```

#### 3. reboot 命令

reboot 命令用于重启系统，其格式为 reboot。 

#### 4. poweroff命令

poweroff 命令用于关闭系统，其格式为 poweroff。 

#### 5. wget命令

wget 命令用于在终端中下载网络文件，格式为“wget [参数] 下载地址”。 

**表：wget 命令的参数以及作用** 

| 参数 | 作用                                 |
| ---- | ------------------------------------ |
| -b   | 后台下载模式                         |
| -P   | 下载到指定目录                       |
| -t   | 最大尝试次数                         |
| -c   | 断点续传                             |
| -p   | 下载页面内所有资源，包括图片、视频等 |
| -r   | 递归下载                             |

wget 命令递归下载 www.linuxprobe.com 网站内的所有页面数据以及文件，下载完后会自动保存到当前路径下一个名为 www.linuxprobe.com 的目录中。 

```shell
[root@localhost ~]# wget -r -p http://www.linuxprobe.com
```

#### 6. ps 命令

ps 命令用于查看系统中的进程状态，格式为“ps [参数]”。 

**表：ps 命令的参数以及作用** 

| 参数 | 作用                               |
| ---- | ---------------------------------- |
| -a   | 显示所有进程（包括其他用户的进程） |
| -u   | 用户以及其他详细信息               |
| -x   | 显示没有控制终端的进程             |

在Linux系统中，有5种常见的进程状态，分别为运行、中断、不可中断、僵死与停止，其各自含义如下所示。

> **R（运行）**：进程正在运行或在运行队列中等待。
>
> **S（中断）**：进程处于休眠中，当某个条件形成后或者接收到信号时，则脱离该   状态。
>
> **D（不可中断）**：进程不响应系统异步信号，即便用kill命令也不能将其中断。
>
> **Z（僵死）**：进程已经终止，但进程描述符依然存在, 直到父进程调用wait4()系统函数后将进程释放。
>
> **T（停止）**：进程收到停止信号后停止运行。

| USER         | PID      | %CPU         | %MEM       | VSZ                      | RSS                        | TTY      | STAT     | START        | TIME              | COMMAND        |
| ------------ | -------- | ------------ | ---------- | ------------------------ | -------------------------- | -------- | -------- | ------------ | ----------------- | -------------- |
| 进程的所有者 | 进程ID号 | 运算器占用率 | 内存占用率 | 虚拟内存使用量(单位是KB) | 占用的固定内存量(单位是KB) | 所在终端 | 进程状态 | 被启动的时间 | 实际使用CPU的时间 | 命令名称与参数 |

```shell
USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
root         1  0.0  0.6 128148  6736 ?        Ss   09:41   0:03 /usr/lib/systemd
root         2  0.0  0.0      0     0 ?        S    09:41   0:00 [kthreadd]
root         3  0.0  0.0      0     0 ?        S    09:41   0:00 [ksoftirqd/0]
root         5  0.0  0.0      0     0 ?        S<   09:41   0:00 [kworker/0:0H]
root         7  0.0  0.0      0     0 ?        S    09:41   0:00 [migration/0]
root         8  0.0  0.0      0     0 ?        S    09:41   0:00 [rcu_bh]
root         9  0.0  0.0      0     0 ?        R    09:41   0:01 [rcu_sched]
root        10  0.0  0.0      0     0 ?        S<   09:41   0:00 [lru-add-drain]
root        11  0.0  0.0      0     0 ?        S    09:41   0:00 [watchdog/0]
root        13  0.0  0.0      0     0 ?        S    09:41   0:00 [kdevtmpfs]
```

#### 7. top 命令

top 命令用于动态地监视进程活动与系统负载等信息，其格式为 top。 

```shell
top - 10:59:52 up  1:18,  2 users,  load average: 0.00, 0.01, 0.05
Tasks:  90 total,   2 running,  88 sleeping,   0 stopped,   0 zombie
%Cpu(s):  0.7 us,  0.3 sy,  0.0 ni, 99.0 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
KiB Mem :  1015508 total,   586988 free,   116684 used,   311836 buff/cache
KiB Swap:  1048572 total,  1048572 free,        0 used.   730224 avail Mem 

  PID USER      PR  NI    VIRT    RES    SHR S %CPU %MEM     TIME+ COMMAND      
 1890 root      20   0  161840   2164   1552 R  0.7  0.2   0:00.18 top          
 1000 root      20   0  573816  19080   6060 S  0.3  1.9   0:01.53 tuned        
 1812 root      20   0       0      0      0 S  0.3  0.0   0:01.92 kworker/0:0  
    1 root      20   0  128148   6736   4216 S  0.0  0.7   0:03.38 systemd      
    2 root      20   0       0      0      0 S  0.0  0.0   0:00.00 kthreadd     
    3 root      20   0       0      0      0 S  0.0  0.0   0:00.17 ksoftirqd/0  
    5 root       0 -20       0      0      0 S  0.0  0.0   0:00.00 kworker/0:0H 
    7 root      rt   0       0      0      0 S  0.0  0.0   0:00.00 migration/0  
    8 root      20   0       0      0      0 S  0.0  0.0   0:00.00 rcu_bh       
    9 root      20   0       0      0      0 R  0.0  0.0   0:01.09 rcu_sched    
   10 root       0 -20       0      0      0 S  0.0  0.0   0:00.00 lru-add-dr
```

top命令执行结果的前5行为系统整体的统计信息，其所代表的含义如下。

> 第1行：系统时间、运行时间、登录终端数、系统负载（三个数值分别为1分钟、5分钟、15分钟内的平均值，数值越小意味着负载越低）。
>
> 第2行：进程总数、运行中的进程数、睡眠中的进程数、停止的进程数、僵死的进程数。
>
> 第3行：用户占用资源百分比、系统内核占用资源百分比、改变过优先级的进程资源百分比、空闲的资源百分比等。其中数据均为CPU数据并以百分比格式显示，例如“97.1 id”意味着有97.1%的CPU处理器资源处于空闲。
>
> 第4行：物理内存总量、内存使用量、内存空闲量、作为内核缓存的内存量。
>
> 第5行：虚拟内存总量、虚拟内存使用量、虚拟内存空闲量、已被提前加载的内存量。

#### 8. pidof 命令

pidof 命令用于查询某个指定服务进程的 PID 值，格式为“pidof \[参数][服务名称]”。 

#### 9. kill命令

kill 命令用于终止某个指定 PID 的服务进程，格式为“kill \[参数][进程 PID]”。 

#### 10. killall 命令

killall 命令用于终止某个指定名称的服务所对应的全部进程，格式为：“killall \[参数][服务名称]”。 



### 2.4 系统状态检测命令

#### 1. ifconfig 命令

ifconfig命令用于获取网卡配置与网络状态等信息，格式为“ifconfig \[网络设备][参数]”。

#### 2. uname 命令

uname命令用于查看系统内核与系统版本等信息，格式为“uname [-a]”。

在使用uname命令时，一般会固定搭配上-a参数来完整地查看当前系统的内核名称、主机名、内核发行版本、节点名、系统时间、硬件名称、硬件平台、处理器类型以及操作系统名称等信息。

```shell
[root@linuxprobe ~]# uname -a
Linux linuxprobe.com 3.10.0-123.el7.x86_64 #1 SMP Mon May 5 11:16:57 EDT 2017 x86_64 x86_64 x86_64 GNU/Linux
```

顺带一提，如果要查看当前系统版本的详细信息，则需要查看redhat-release文件，其命令以及相应的结果如下：

```shell
[root@linuxprobe ~]# cat /etc/redhat-release
Red Hat Enterprise Linux Server release 7.0 (Maipo)
```

#### 3. uptime 命令

uptime用于查看系统的负载信息。

显示**当前系统时间**、**系统已运行时间**、**启用终端数量**以及**平均负载值**等信息。平均负载值指的是系统在最近1分钟、5分钟、15分钟内的压力情况（下面加粗的信息部分）；负载值越低越好，尽量不要长期超过1，在生产环境中不要超过5。

```shell
[root@linuxprobe ~]# uptime
22:49:55 up 10 min, 2 users, load average: 0.01, 0.19, 0.18
```

#### 4. free 命令

free 用于显示当前系统中内存的使用量信息，格式为“free [-h]”。 

**swap**全称为swap place，即交换区，当内存不够的时候，被踢出的进程被暂时存储到交换区。当需要这条被踢出的进程的时候，就从交换区重新加载到内存，否则它不会主动交换到真实内存中。

**表：执行free -h命令后的输出信息**

|                    | 内存总量 | 已用量 | 可用量 | 进程共享的内存量 | 磁盘缓存的内存量 | 缓存的内存量 |
| ------------------ | -------- | ------ | ------ | ---------------- | ---------------- | ------------ |
|                    | total    | used   | free   | shared           | buffers          | cached       |
| Mem:               | 1.8G     | 1.3G   | 542M   | 9.8M             | 1.6M             | 413M         |
| -/+ buffers/cache: |          | 869M   | 957M   |                  |                  |              |
| Swap:              | 2.0G     | 0B     | 2.0G   |                  |                  |              |

#### 5. who 命令

who用于查看当前登入主机的用户终端信息，格式为“who [参数]”。

```
[root@linuxprobe ~]# who
```

**表： 执行who命令的结果**

| 登陆的用户名 | 终端设备 | 登陆到系统的时间      |
| ------------ | -------- | --------------------- |
| root         | :0       | 2017-08-24 17:52 (:0) |
| root         | pts/0    | 2017-08-24 17:52 (:0) |

#### 6. last 命令

last 命令用于查看所有系统的登录记录，格式为“last [参数]”。 

#### 7. history 命令

history命令用于显示历史执行过的命令，格式为“history [-c]”。

执行history命令能显示出当前用户在本地计算机中执行过的最近1000条命令记录。如果觉得1000不够用，还可以自义/etc/profile文件中的HISTSIZE变量值。在使用history命令时，如果使用-c参数则会清空所有的命令历史记录。还可以使用“!编码数字”的方式来重复执行某一次的命令。

#### 8. sosreport 命令

sosreport命令用于收集系统配置及架构信息并输出诊断文档，格式为sosreport。



### 2.5 工作目录切换命令

#### 1. pwd 命令

#### 2. cd 命令

“cd -”命令返回到上一次所处的目录 

#### 3. ls命令



### 2.6 文本文件编辑命令 

#### 1. cat 命令

cat 命令用于查看纯文本文件（内容较少的），格式为“cat \[选项][文件]”。 

- -n 带行号显示。

#### 2. more 命令

more 命令用于查看纯文本文件（内容较多的），格式为“more [选项]文件”。 可以使用空格键或回车
键向下翻页。 

#### 3.head 命令

head 命令用于查看纯文本文档的前 N 行，格式为“head \[选项][文件]”。 

```shell
head -n 20 initial-setup-ks.cfg
```

#### 4. tail 命令

tail 命令用于查看纯文本文档的后 N 行或持续刷新内容，格式为“tail \[选项][文件]”。

```shell
head -n 20 initial-setup-ks.cfg
```

tail 命令最强悍的功能是可以持续刷新一个文件的内容，当想要实时查看最新日志文件时，这特别有用，此时的命令格式为“tail -f 文件名”。 

#### 5. tr 命令

tr 命令用于替换文本文件中的字符，格式为“tr \[原始字符][目标字符]”。 

```shell
cat anaconda-ks.cfg | tr [a-z] [A-Z]
```

#### 6. wc 命令

wc 命令用于统计指定文本的行数、字数、字节数，格式为“wc [参数] 文本”。 

| 参数 | 作用         |
| ---- | ------------ |
| -l   | 只显示行数   |
| -w   | 只显示单词数 |
| -c   | 只显示字节数 |

#### 7. stat 命令

stat 命令用于查看文件的具体存储信息和时间等信息，格式为“stat 文件名称”。 

```shell
stat anaconda-ks.cfg
```

#### 8. cut命令

cut 命令用于按“列”提取文本字符，格式为“cut [参数] 文本”。 

- -f 参数来设置需要看的列数，
- -d 参数来设置**间隔符号** 

```shell
cut -d: -f1 /etc/passwd
```

#### 9. diff 命令

diff 命令用于比较多个文本文件的差异，格式为“diff [参数] 文件”。 

- 使用-c 参数来详细比较出多个文件的差异之处 
- 使用--brief 参数来确认两个文件是否不同 

```shell
diff --brief diff_A.txt diff_B.txt
diff -c diff_A.txt diff_B.txt
```

### 2.7 文件目录管理命令

#### 1. touch 命令

touch 命令用于创建空白文件或**设置文件的时间**，格式为“touch \[选项][文件]”。

 **表:  touch命令的参数及其作用**

| 参数 | 作用                      |
| ---- | ------------------------- |
| -a   | 仅修改“读取时间”（atime） |
| -m   | 仅修改“修改时间”（mtime） |
| -d   | 同时修改atime与mtime      |

```shell
touch -d "2017-05-04 15:44" anaconda-ks.cfg 
```

#### 2. mkdir 命令

mkdir 命令用于创建空白的目录，格式为“mkdir [选项] 目录”。

- -p 参数来递归创建出具有嵌套叠层关系的文件目录  

```shell
mkdir -p a/b/c/d/e
```

#### 3. cp 命令

cp 命令用于复制文件或目录，格式为“cp [选项] 源文件 目标文件”。 

**表： cp命令的参数及其作用**

| 参数 | 作用                                         |
| ---- | -------------------------------------------- |
| -p   | 保留原始文件的属性                           |
| -d   | 若对象为“链接文件”，则保留该“链接文件”的属性 |
| -r   | 递归持续复制（用于目录）                     |
| -i   | 若目标文件存在则询问是否覆盖                 |
| -a   | 相当于-pdr（p、d、r为上述参数）              |

#### 4. mv 命令

mv 命令用于剪切文件或将文件重命名，格式为“mv [选项] 源文件 [目标路径|目标文件名]”。 如果在同一个目录中对一个文件进行剪切操作，其实也就是对其进行重命名： 

```shell
mv x.log linux.log
```

#### 5. rm 命令

rm 命令用于删除文件或目录，格式为“rm [选项] 文件”。 

- -f 参数来强制删除 
- -r 参数递归删除文件夹

#### 6. dd 命令

dd 命令用于按照指定大小和个数的数据块来复制文件或转换文件，格式为“dd [参数]”。 

**表： dd命令的参数及其作用**

| 参数  | 作用                 |
| ----- | -------------------- |
| if    | 输入的文件名称       |
| of    | 输出的文件名称       |
| bs    | 设置每个“块”的大小   |
| count | 设置要复制“块”的个数 |

用 dd 命令从/dev/zero 设备文件中取出一个大小为 560MB 的数据块，然后保存成名为 560_file 的文件

```shell
dd if=/dev/zero of=560_file count=1 bs=560M
```

在 Linux 系统中可以直接使用 dd 命令来压制出光盘镜像文件，将它变成一个可立即使用的 iso 镜像 

```shell
dd if=/dev/cdrom of=RHEL-server-7.0-x86_64-LinuxProbe.Com.iso
```

#### 7. file命令

file 命令用于查看文件的类型，格式为“file 文件名”。 

```shell
file anaconda-ks.cfg
```



### 2.8 打包压缩与搜索命令

#### 1. tar 命令

tar 命令用于对文件进行打包压缩或解压，格式为“tar \[选项][文件]”。 

**表：tar命令的参数及其作用**

| 参数 | 作用                   |
| ---- | ---------------------- |
| -c   | 创建压缩文件           |
| -x   | 解开压缩文件           |
| -t   | 查看压缩包内有哪些文件 |
| -z   | 用Gzip压缩或解压       |
| -j   | 用bzip2压缩或解压      |
| -v   | 显示压缩或解压的过程   |
| -f   | 目标文件名             |
| -p   | 保留原始的权限与属性   |
| -P   | 使用绝对路径来压缩     |
| -C   | 指定解压到的目录       |

常用打包命令 :   “**tar -czvf   压缩包名称.tar.gz   要打包的目录**”；

常用解压命令 ：“**tar -xzvf 压缩包名称.tar.gz**”。 



#### 2. grep 命令

grep 命令用于在文本中执行关键词搜索，并显示匹配的结果，格式为“grep \[选项][文件]”。 

**表: grep命令的参数及其作用**

| 参数 | 作用                                           |
| ---- | ---------------------------------------------- |
| -b   | 将可执行文件(binary)当作文本文件（text）来搜索 |
| -c   | 仅显示找到的行数                               |
| -i   | 忽略大小写                                     |
| -n   | 显示行号                                       |
| -v   | 反向选择——仅列出没有“关键词”的行。             |

```shell
[root@localhost dic]# cat index.html |grep html -n
1:<html>
3:<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
75:</html>
```

#### 3. find命令

find 命令用于按照指定条件来查找文件，格式为“find [查找路径] 寻找条件 操作”。 

**表：find命令中的参数以及作用**

| 参数               | 作用                                                         |
| ------------------ | ------------------------------------------------------------ |
| -name              | 匹配名称                                                     |
| -perm              | 匹配权限（mode为完全匹配，-mode为包含即可）                  |
| -user              | 匹配所有者                                                   |
| -group             | 匹配所有组                                                   |
| -mtime -n +n       | 匹配修改内容的时间（-n指n天以内，+n指n天以前）               |
| -atime -n +n       | 匹配访问文件的时间（-n指n天以内，+n指n天以前）               |
| -ctime -n +n       | 匹配修改文件权限的时间（-n指n天以内，+n指n天以前）           |
| -nouser            | 匹配无所有者的文件                                           |
| -nogroup           | 匹配无所有组的文件                                           |
| -newer f1 !f2      | 匹配比文件f1新但比f2旧的文件                                 |
| --type b/d/c/p/l/f | 匹配文件类型（后面的字幕字母依次表示块设备、目录、字符设备、管道、链接文件、文本文件） |
| -size              | 匹配文件的大小（+50KB为查找超过50KB的文件，而-50KB为查找小于50KB的文件） |
| -prune             | 忽略某个目录                                                 |
| -exec …… {}\;      | 后面可跟用于进一步处理搜索结果的命令（下文会有演示）         |

获取到指定目录中所有以 host 开头的文件列表，可以执行如下命令： 

```shell
find /etc -name "host*" -print
```

如果要在整个系统中搜索权限中包括 SUID 权限的所有文件，只需使用-4000 即可： 

```shell
find / -perm -4000 -print
```



## 第三章 管道符、重定向与环境变量

### 3.1 输入输出重定向

> 标准输入重定向（STDIN，文件描述符为0）：默认从键盘输入，也可从其他文件或命令中输入。
>
> 标准输出重定向（STDOUT，文件描述符为1）：默认输出到屏幕。
>
> 错误输出重定向（STDERR，文件描述符为2）：默认输出到屏幕。

**对于输入重定向来讲，用到的符号及其作用如表3-1所示。**

表3-1                                         输入重定向中用到的符号及其作用

| 符号                 | 作用                                         |
| -------------------- | -------------------------------------------- |
| 命令 < 文件          | 将文件作为命令的标准输入                     |
| 命令 << 分界符       | 从标准输入中读入，直到遇见分界符才停止       |
| 命令 < 文件1 > 文件2 | 将文件1作为命令的标准输入并将标准输出到文件2 |

**对于输出重定向来讲，用到的符号及其作用如表3-2所示。**

表3-2                                         输出重定向中用到的符号及其作用

| 符号                                  | 作用                                                         |
| ------------------------------------- | ------------------------------------------------------------ |
| 命令 > 文件                           | 将标准输出重定向到一个文件中（清空原有文件的数据）           |
| 命令 2> 文件                          | 将错误输出重定向到一个文件中（清空原有文件的数据）           |
| 命令 >> 文件                          | 将标准输出重定向到一个文件中（追加到原有内容的后面）         |
| 命令 2>> 文件                         | 将错误输出重定向到一个文件中（追加到原有内容的后面）         |
| 命令 >> 文件 2>&1   或  命令 &>> 文件 | 将标准输出与错误输出共同写入到文件中（追加到原有内容的后面） |

```shell
man bash > readme.txt
```

### 3.2 管道运算符

管道命令符的作用也可以用一句话来概括“**把前一个命令原本要输出到屏幕的标准正常数据当作是后一个命令的标准输入**”。 

### 3.3 命令通配符

- 星号（*）代表匹配零个或多个字符；
- 问号（?）代表匹配单个字符；
- 中括号内加上数字[0-9]代表匹配 0～9 之间的单个数字的字符；
- 而中括号内加上字母[abc]则是代表匹配 a、 b、 c 三个字符中的任意一个字符 

```shell
 ls -l /dev/sda*
 ls -l /dev/sda?
 ls -l /dev/sda[0-9]
 ls -l /dev/sda[135]
```

### 3.4 常用的转义字符

> 反斜杠（\）：使反斜杠后面的一个变量变为单纯的字符串。
>
> 单引号（''）：转义其中所有的变量为单纯的字符串。
>
> 双引号（""）：保留其中的变量属性，不进行转义处理。
>
> 反引号（``）：把其中的命令执行后返回结果。

```shell
[root@linuxprobe ~]# PRICE=5
[root@linuxprobe ~]# echo "Price is $PRICE"
Price is 5

[root@linuxprobe ~]# echo "Price is \$$PRICE"
Price is $5

[root@linuxprobe ~]# echo `uname -a`
Linux linuxprobe.com 3.10.0-123.el7.x86_64 #1 SMP Mon May 5 11:16:57 EDT 2017
x86_64 x86_64 x86_64 GNU/Linux
```

### 3.5 重要的环境变量

表3-3                                       Linux系统中最重要的10个环境变量

| 变量名称     | 作用                             |
| ------------ | -------------------------------- |
| HOME         | 用户的主目录（即家目录）         |
| SHELL        | 用户在使用的Shell解释器名称      |
| HISTSIZE     | 输出的历史命令记录条数           |
| HISTFILESIZE | 保存的历史命令记录条数           |
| MAIL         | 邮件保存路径                     |
| LANG         | 系统语言、语系名称               |
| RANDOM       | 生成一个随机数字                 |
| PS1          | Bash解释器的提示符               |
| PATH         | 定义解释器搜索用户执行命令的路径 |
| EDITOR       | 用户默认的文本编辑器             |

```shell
 echo $HOME
```

设置一个名称为 WORKDIR 的变量 :

```shell
[root@linuxprobe ~]# mkdir /home/workdir
[root@linuxprobe ~]# WORKDIR=/home/workdir
[root@linuxprobe ~]# cd $WORKDIR
[root@linuxprobe workdir]# pwd
/home/workdir
```

但是，这样的变量不具有全局性，作用范围也有限，默认情况下不能被其他用户使用。如果工作需要，可以使用 **export 命令**将其提升为全局变量 。



## 第四章 Vim 编辑器与 shell 脚本命令

### 4.1 vim编辑器

> 命令模式：控制光标移动，可对文本进行复制、粘贴、删除和查找等工作。
>
> 输入模式：正常的文本录入。
>
> 末行模式：保存或退出文档，以及设置编辑环境。

表4-1                                                      Vim中常用的命令

| 命令 | 作用                                               |
| ---- | -------------------------------------------------- |
| dd   | 删除（剪切）光标所在整行                           |
| 5dd  | 删除（剪切）从光标处开始的5行                      |
| yy   | 复制光标所在整行                                   |
| 5yy  | 复制从光标处开始的5行                              |
| n    | 显示搜索命令定位到的下一个字符串                   |
| N    | 显示搜索命令定位到的上一个字符串                   |
| u    | 撤销上一步的操作                                   |
| p    | 将之前删除（dd）或复制（yy）过的数据粘贴到光标后面 |

表4-2                                                  末行模式中可用的命令

| 命令          | 作用                                 |
| ------------- | ------------------------------------ |
| :w            | 保存                                 |
| :q            | 退出                                 |
| :q!           | 强制退出（放弃对文档的修改内容）     |
| :wq!          | 强制保存退出                         |
| :set nu       | 显示行号                             |
| :set nonu     | 不显示行号                           |
| :命令         | 执行该命令                           |
| :整数         | 跳转到该行                           |
| :s/one/two    | 将当前光标所在行的第一个one替换成two |
| :s/one/two/g  | 将当前光标所在行的所有one替换成two   |
| :%s/one/two/g | 将全文中的所有one替换成two           |
| ?字符串       | 在文本中从下至上搜索该字符串         |
| /字符串       | 在文本中从上至下搜索该字符串         |

使用 a、 i、 o 三个键从命令模式切换到输入模式。其中， a 键与 i 键分别是在光标后面一位和光标当前位置切换到输入模式，而 **o 键则是在光标的下面再创建一个空行**，此时可敲击 a 键进入到编辑器的输入模式。 

### 4.2 编写的脚本

#### 4.2.1 编写简单的脚本

```shell
[root@linuxprobe ~]# vim example.sh
#!/bin/bash
pwd
ls -al
```

#### 4.2.2 接受用户参数

- $0   对应的是当前 Shell 脚本程序的名称，
- $#   对应的是总共有几个参数，
- $*   对应的是所有位置的参数值， 
- $?   对应的是显示上一次命令的执行返回值，
- 而$1、$2、 $3……则分别对应着第 N 个位置的参数值 

```shell
[root@linuxprobe ~]# vim example.sh
#!/bin/bash
echo "当前脚本名称为$0"
echo "总共有$#个参数，分别是$*。"
echo "第1个参数为$1，第5个为$5。"
[root@linuxprobe ~]# sh example.sh one two three four five six
当前脚本名称为example.sh
总共有6个参数，分别是one two three four five six。
第1个参数为one，第5个为five。
```

**按照测试对象来划分，条件测试语句可以分为4种**：

> 文件测试语句；
>
> 逻辑测试语句；
>
> 整数值比较语句；
>
> 字符串比较语句。

表4-3                                                    文件测试所用的参数

| 操作符 | 作用                       |
| ------ | -------------------------- |
| -d     | 测试文件是否为目录类型     |
| -e     | 测试文件是否存在           |
| -f     | 判断是否为一般文件         |
| -r     | 测试当前用户是否有权限读取 |
| -w     | 测试当前用户是否有权限写入 |
| -x     | 测试当前用户是否有权限执行 |

表4-4                                                  可用的整数比较运算符

| 操作符 | 作用           |
| ------ | -------------- |
| -eq    | 是否等于       |
| -ne    | 是否不等于     |
| -gt    | 是否大于       |
| -lt    | 是否小于       |
| -le    | 是否等于或小于 |
| -ge    | 是否大于或等于 |

表4-5                                                常见的字符串比较运算符

| 操作符 | 作用                   |
| ------ | ---------------------- |
| =      | 比较字符串内容是否相同 |
| !=     | 比较字符串内容是否不同 |
| -z     | 判断字符串内容是否为空 |

下面使用文件测试语句来判断/etc/fstab是否为一个目录类型的文件，然后通过Shell解释器的内设$?变量显示上一条命令执行后的返回值。如果返回值为0，则目录存在；如果返回值为非零的值，则意味着目录不存在：

```shell
[root@linuxprobe ~]# [ -d /etc/fstab ]
[root@linuxprobe ~]# echo $?
1
```

## 4.3 流程控制语句

**结构**：

```shell
# if单分支结构
if 条件测试操作
	then 命令序列
fi


# if双分支结构
if 条件测试操作
	then 命令序列1
	else 命令序列2
fi


# if多分支结构
if 条件测试操作1 ;
	then 命令序列1
elif 条件测试操作2 ;
	then 命令序列2
else
	命令序列3
fi


# for 条件循环语句
for 变量名 in 取值列表
do 
	命令序列
done


# while 条件循环语句
while 条件测试操作
do
	命令序列
done


# case 条件测试语句
case 变量值 in
模式1）
	命令序列1
	；；
模式2）
	命令序列2
	;;
	.....
*)
	默认命令序列
esac
```

**示例**：

```shell
# if单分支结构
#!/bin/bash
DIR="/media/cdrom"
if [ ! -e $DIR ]
then
mkdir -p $DIR
fi


# if双分支结构
#!/bin/bash
ping -c 3 -i 0.2 -W 3 $1 &> /dev/null
if [ $? -eq 0 ]
then
echo "Host $1 is On-line."
else
echo "Host $1 is Off-line."
fi


# if多分支结构
#!/bin/bash
read -p "Enter your score（0-100）：" GRADE
if [ $GRADE -ge 85 ] && [ $GRADE -le 100 ] ; then
echo "$GRADE is Excellent"
elif [ $GRADE -ge 70 ] && [ $GRADE -le 84 ] ; then
echo "$GRADE is Pass"
else
echo "$GRADE is Fail" 
fi


# for 条件循环语句
#!/bin/bash
read -p "Enter The Users Password : " PASSWD
for UNAME in `cat users.txt`
do
id $UNAME &> /dev/null
if [ $? -eq 0 ]
then
echo "Already exists"
else
useradd $UNAME &> /dev/null
echo "$PASSWD" | passwd --stdin $UNAME &> /dev/null
if [ $? -eq 0 ]
then
echo "$UNAME , Create success"
else
echo "$UNAME , Create failure"
fi
fi
done


# while 条件循环语句
#!/bin/bash
PRICE=$(expr $RANDOM % 1000)
TIMES=0
echo "商品实际价格为0-999之间，猜猜看是多少？"
while true
do
read -p "请输入您猜测的价格数目：" INT
let TIMES++
if [ $INT -eq $PRICE ] ; then
echo "恭喜您答对了，实际价格是 $PRICE"
echo "您总共猜测了 $TIMES 次"
exit 0
elif [ $INT -gt $PRICE ] ; then
echo "太高了！"
else
echo "太低了！"
fi
done


# case 条件测试语句
#!/bin/bash
read -p "请输入一个字符，并按Enter键确认：" KEY
case "$KEY" in
[a-z]|[A-Z])
echo "您输入的是 字母。"
;;
[0-9])
echo "您输入的是 数字。"
;;
*)
echo "您输入的是 空格、功能键或其他控制字符。"
esac
```



## 4.4 计划任务服务程序

> 一次性计划任务：今晚11点30分开启网站服务。
>
> 长期性计划任务：每周一的凌晨3点25分把/home/wwwroot目录打包备份为backup.tar.gz。

**一次性计划任务：**

- 设置一次性计划任务 “at 时间”
- 查看已设置好但还未执行的一次性计划任务，可以使用“at -l”命令
- 删除用“atrm 任务序号”

```shell
[root@linuxprobe ~]# at 23:30
at > systemctl restart httpd
at > 此处请同时按下Ctrl+d来结束编写计划任务
job 3 at Mon Apr 27 23:30:00 2015
[root@linuxprobe ~]# at -l
3 Mon Apr 27 23:30:00 2016 a root
[root@linuxprobe ~]# echo "systemctl restart httpd" | at 23:30
job 4 at Mon Apr 27 23:30:00 2015
[root@linuxprobe ~]# at -l
3 Mon Apr 27 23:30:00 2016 a root
4 Mon Apr 27 23:30:00 2016 a root
[root@linuxprobe ~]# atrm 3
[root@linuxprobe ~]# at -l
4 Mon Apr 27 23:30:00 2016 a root
```

**周期性任务**：

- 创建、编辑计划任务的命令为“crontab -e”
- 查看当前计划任务的命令为“crontab -l”
- 删除某条计划任务的命令为“crontab -r”
- 另外，如果您是以管理员的身份登录的系统，还可以在 crontab 命令中加上-u 参数来编辑他人的计划任务 

表4-6                                       使用crond设置任务的参数字段说明

| 字段 | 说明                                     |
| ---- | ---------------------------------------- |
| 分钟 | 取值为0～59的整数                        |
| 小时 | 取值为0～23的任意整数                    |
| 日期 | 取值为1～31的任意整数                    |
| 月份 | 取值为1～12的任意整数                    |
| 星期 | 取值为0～7的任意整数，其中0与7均为星期日 |
| 命令 | 要执行的命令或程序脚本                   |

**在crond服务的计划任务参数中，所有命令一定要用绝对路径的方式来写，如果不知道绝对路径，请用whereis命令进行查询**

```shell
[root@linuxprobe ~]# crontab -e
no crontab for root - using an empty one
crontab: installing new crontab
[root@linuxprobe ~]# crontab -l
#假设在每周一、三、五的凌晨3点25分，都需要使用tar命令把某个网站的数据目录进行打包处理，使其作为一个备份文件。
25 3 * * 1,3,5 /usr/bin/tar -czvf backup.tar.gz /home/wwwroot


[root@linuxprobe ~]# whereis rm
rm: /usr/bin/rm /usr/share/man/man1/rm.1.gz /usr/share/man/man1p/rm.1p.gz
[root@linuxprobe ~]# crontab -e
crontab: installing new crontab
[root@linuxprobe ~]# crontab -l
#每周一至周五的凌晨1点钟自动清空/tmp目录内的所有文件
25 3 * * 1,3,5 /usr/bin/tar -czvf backup.tar.gz /home/wwwroot
0 1 * * 1-5 /usr/bin/rm -rf /tmp/*
```

**计划任务中的“分”字段必须有数值，绝对不能为空或是*号，而“日”和“星期”字段不能同时使用，否则就会发生冲突。**



## 第五章 用户身份与文件权限

### 5.1 用户身份与能力

> 管理员UID为0：系统的管理员用户。
>
> 系统用户UID为1～999： Linux系统为了避免因某个服务程序出现漏洞而被黑客提权至整台服务器，默认服务程序会有独立的系统用户负责运行，进而有效控制被破坏范围。
>
> 普通用户UID从1000开始：是由管理员创建的用于日常工作的用户。

#### 1. useradd 命令

useradd命令用于创建新的用户，格式为“useradd [选项] 用户名”。

可以使用useradd命令创建用户账户。使用该命令创建用户账户时，默认的用户家目录会被存放在/home目录中，默认的Shell解释器为/bin/bash，而且默认会创建一个与该用户同名的基本用户组。这些默认设置可以根据表5-1中的useradd命令参数自行修改。

表5-1                                       useradd命令中的用户参数以及作用

| 参数 | 作用                                     |
| ---- | ---------------------------------------- |
| -d   | 指定用户的家目录（默认为/home/username） |
| -e   | 账户的到期时间，格式为YYYY-MM-DD.        |
| -u   | 指定该用户的默认UID                      |
| -g   | 指定一个初始的用户基本组（必须已存在）   |
| -G   | 指定一个或多个扩展用户组                 |
| -N   | 不创建与用户同名的基本用户组             |
| -s   | 指定该用户的默认Shell解释器              |

```shell
[root@linuxprobe ~]# useradd -d /home/linux -u 8888 -s /sbin/nologin linuxprobe
[root@linuxprobe ~]# id linuxprobe
uid=8888(linuxprobe) gid=8888(linuxprobe) groups=8888(linuxprobe)
```

#### 2. groupadd 命令 

groupadd 命令用于创建用户组，格式为“groupadd [选项] 群组名”。 

#### 3. usermod 命令

usermod命令用于修改用户的属性，格式为“usermod [选项] 用户名”。

前文曾反复强调，Linux系统中的一切都是文件，因此在系统中创建用户也就是修改配置文件的过程。用户的信息保存在/etc/passwd文件中，可以直接用文本编辑器来修改其中的用户参数项目，也可以用usermod命令修改已经创建的用户信息。

表5-2                                            usermod命令中的参数及作用

| 参数  | 作用                                                         |
| ----- | ------------------------------------------------------------ |
| -c    | 填写用户账户的备注信息                                       |
| -d -m | 参数-m与参数-d连用，可重新指定用户的家目录并自动把旧的数据转移过去 |
| -e    | 账户的到期时间，格式为YYYY-MM-DD                             |
| -g    | 变更所属用户组                                               |
| -G    | 变更扩展用户组                                               |
| -L    | 锁定用户禁止其登录系统                                       |
| -U    | 解锁用户，允许其登录系统                                     |
| -s    | 变更默认终端                                                 |
| -u    | 修改用户的UID                                                |

```shell
[root@linuxprobe ~]# usermod -u 8888 linuxprobe
[root@linuxprobe ~]# id linuxprobe
uid=8888(linuxprobe) gid=1000(linuxprobe) groups=1000(linuxprobe),0(root)
```

#### 4. passwd 命令

passwd命令用于修改用户密码、过期时间、认证信息等，格式为“passwd \[选项][用户名]”。

表5-3                                           passwd命令中的参数以及作用

| 参数    | 作用                                                         |
| ------- | ------------------------------------------------------------ |
| -l      | 锁定用户，禁止其登录                                         |
| -u      | 解除锁定，允许用户登录                                       |
| --stdin | 允许通过标准输入修改用户密码，如echo "NewPassWord" \| passwd --stdin Username |
| -d      | 使该用户可用空密码登录系统                                   |
| -e      | 强制用户在下次登录时修改密码                                 |
| -S      | 显示用户的密码是否被锁定，以及密码所采用的加密算法名称       |

```shell
[root@linuxprobe ~]# passwd -l linuxprobe
Locking password for user linuxprobe.
passwd: Success
[root@linuxprobe ~]# passwd -S linuxprobe
linuxprobe LK 2017-12-26 0 99999 7 -1 (Password locked.)
[root@linuxprobe ~]# passwd -u linuxprobe
Unlocking password for user linuxprobe.
passwd: Success
[root@linuxprobe ~]# passwd -S linuxprobe
linuxprobe PS 2017-12-26 0 99999 7 -1 (Password set, SHA512 crypt.)
```

#### 5. userdel 命令

userdel命令用于删除用户，格式为“userdel [选项] 用户名”。

表5-4                                              userdel命令的参数以及作用

| 参数 | 作用                     |
| ---- | ------------------------ |
| -f   | 强制删除用户             |
| -r   | 同时删除用户及用户家目录 |

### 5.2 文件权限与归属

>  -：普通文件。
>
> d：目录文件。
>
> l：链接文件。
>
> b：块设备文件。
>
> c：字符设备文件。
>
> p：管道文件。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/文件权限的字符与数字表示.png"/> </div></br>

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/文件属性信息.png"/> </div></br>

### 5.3 文件的特殊权限

#### 5.3.1 SUID

SUID 是一种对二进制程序进行设置的特殊权限，可以让二进制程序的执行者临时拥有属主的权限（仅对拥有执行权限的二进制程序有效） 

#### 5.3.2 SGID

SGID主要实现如下两种功能：

> 让执行者临时拥有属组的权限（对拥有执行权限的二进制程序进行设置）；
>
> 在某个目录中创建的文件自动继承该目录的用户组（只可以对目录进行设置）。

##### 1.chmod命令

chmod是一个非常实用的命令，能够用来设置文件或目录的**权限**，格式为“chmod [参数] 权限 文件或目录名称”。

##### 2.chown命令

chown设置文件或目录的**所有者和所属组**，其格式为“chown [参数] 所有者:所属组 文件或目录名称”。

```shell
[root@linuxprobe ~]# chmod 760 test
[root@linuxprobe ~]# ls -l test
-rwxrw----. 1 linuxprobe root 15 Feb 11 11:50 test
[root@linuxprobe ~]# chown root:bin test
[root@linuxprobe ~]# ls -l test
-rwxrw----. 1 root bin 15 Feb 11 11:50 test
```

#### 5.3.3 SBIT

SBIT特殊权限位可确保用户只能删除自己的文件，而不能删除其他用户的文件。换句话说，当对某个目录设置了SBIT粘滞位权限后，那么该目录中的文件就只能被其所有者执行删除操作了。

### 5.4 文件的隐藏属性

#### 1.  chattr命令

chattr命令用于设置文件的隐藏权限，格式为“chattr [参数] 文件”。如果想要把某个隐藏功能添加到文件上，则需要在命令后面追加“+参数”，如果想要把某个隐藏功能移出文件，则需要追加“-参数”。

表5-6                                  chattr命令中用于隐藏权限的参数及其作用

| 参数 | 作用                                                         |
| ---- | ------------------------------------------------------------ |
| i    | 无法对文件进行修改；若对目录设置了该参数，则仅能修改其中的子文件内容而不能新建或删除文件 |
| a    | 仅允许补充（追加）内容，无法覆盖/删除内容（Append Only）     |
| S    | 文件内容在变更后立即同步到硬盘（sync）                       |
| s    | 彻底从硬盘中删除，不可恢复（用0填充原文件所在硬盘区域）      |
| A    | 不再修改这个文件或目录的最后访问时间（atime）                |
| b    | 不再修改文件或目录的存取时间                                 |
| D    | 检查压缩文件中的错误                                         |
| d    | 使用dump命令备份时忽略本文件/目录                            |
| c    | 默认将文件或目录进行压缩                                     |
| u    | 当删除该文件后依然保留其在硬盘中的数据，方便日后恢复         |
| t    | 让文件系统支持尾部合并（tail-merging）                       |
| x    | 可以直接访问压缩文件中的内容                                 |

```shell
[root@linuxprobe ~]# echo "for Test" > linuxprobe
[root@linuxprobe ~]# chattr +a linuxprobe
[root@linuxprobe ~]# rm linuxprobe
rm: remove regular file ‘linuxprobe’? y
rm: cannot remove ‘linuxprobe’: Operation not permitted
```

#### 2. lsattr 命令

lsattr命令用于显示文件的隐藏权限，格式为“lsattr [参数] 文件”。

```shell
[root@linuxprobe ~]# lsattr linuxprobe
-----a---------- linuxprobe
[root@linuxprobe ~]# chattr -a linuxprobe
[root@linuxprobe ~]# lsattr linuxprobe 
---------------- linuxprobe
[root@linuxprobe ~]# rm linuxprobe 
rm: remove regular file ‘linuxprobe’? y
```

### 5.5 文件访问控制列表

#### 5.5.1 setfacl 命令

setfacl 命令用于管理文件的 ACL 规则，格式为“setfacl [参数] 文件名称”。文件的 ACL提供的是在所有者、所属组、其他人的读/写/执行权限之外的特殊权限控制，使用 setfacl 命令可以**针对单一用户或用户组、单一文件或目录来进行读/写/执行权限的控制**。其中：

- 针对目录文件需要使用-R 递归参数；
- 针对普通文件则使用-m 参数；
- 如果想要删除某个文件的 ACL，则可以使用-b 参数。

下面来设置用户在/root 目录上的权限： 

```shell
[root@linuxprobe ~]# setfacl -Rm u:linuxprobe:rwx /root
```

#### 5.5.2 getfacl 命令

getfacl命令用于显示文件上设置的ACL信息，格式为“getfacl 文件名称”。

### 5.6 su命令与sudo服务

su 命令与用户名之间有一个减号（-），这意味着完全切换到新的用户，**即把环境变量信息也变更为新用户的相应信息**，而不是保留原始的信息。强烈建议在切换用户身份时添加这个减号（-）。 

sudo 命令用于给普通用户提供额外的权限来完成原本 root 管理员才能完成的任务，格式为“sudo [参数] 命令名称”。  

表5-7                                          sudo服务中的可用参数以及作用

| 参数             | 作用                                                   |
| ---------------- | ------------------------------------------------------ |
| -h               | 列出帮助信息                                           |
| -l               | 列出当前用户可执行的命令                               |
| -u 用户名或UID值 | 以指定的用户身份执行命令                               |
| -k               | 清空密码的有效时间，下次执行sudo时需要再次进行密码验证 |
| -b               | 在后台执行指定的命令                                   |
| -p               | 更改询问密码的提示语                                   |

## 第六章 存储结构与磁盘划分

### 6.1 一切从“/”开始

表6-1                                  Linux系统中常见的目录名称以及相应内容

| 目录名称    | 应放置文件的内容                                          |
| ----------- | --------------------------------------------------------- |
| /boot       | 开机所需文件—内核、开机菜单以及所需配置文件等             |
| /dev        | 以文件形式存放任何设备与接口                              |
| /etc        | 配置文件                                                  |
| /home       | 用户主目录                                                |
| /bin        | 存放单用户模式下还可以操作的命令                          |
| /lib        | 开机时用到的函数库，以及/bin与/sbin下面的命令要调用的函数 |
| /sbin       | 开机过程中需要的命令                                      |
| /media      | 用于挂载设备文件的目录                                    |
| /opt        | 放置第三方的软件                                          |
| /root       | 系统管理员的家目录                                        |
| /srv        | 一些网络服务的数据文件目录                                |
| /tmp        | 任何人均可使用的“共享”临时目录                            |
| /proc       | 虚拟文件系统，例如系统内核、进程、外部设备及网络状态等    |
| /usr/local  | 用户自行安装的软件                                        |
| /usr/sbin   | Linux系统开机时不会使用到的软件/命令/脚本                 |
| /usr/share  | 帮助与说明文件，也可放置共享文件                          |
| /var        | 主要存放经常变化的文件，如日志                            |
| /lost+found | 当文件系统发生错误时，将一些丢失的文件片段存放在这里      |

### 6.2 物理设备的命名规则

表6-2                                             常见的硬件设备及其文件名称

| 硬件设备      | 文件名称           |
| ------------- | ------------------ |
| IDE设备       | /dev/hd[a-d]       |
| SCSI/SATA/U盘 | /dev/sd[a-p]       |
| 软驱          | /dev/fd[0-1]       |
| 打印机        | /dev/lp[0-15]      |
| 光驱          | /dev/cdrom         |
| 鼠标          | /dev/mouse         |
| 磁带机        | /dev/st0或/dev/ht0 |

由于现在的IDE设备已经很少见了，所以一般的硬盘设备都会是以“/dev/sd”开头的。而一台主机上可以有多块硬盘，因此系统采用a～p来代表16块不同的硬盘（默认从a开始分配），而且硬盘的分区编号也很有讲究：

> 主分区或扩展分区的编号从1开始，到4结束；
>
> 逻辑分区从编号5开始。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/设备文件名称.png"/> </div></br>

### 6.4 挂载硬件设备

当用户需要使用硬盘设备或分区中的数据时，需要先将其与一个已存在的目录文件进行关联，而这个关联动作就是“挂载”。 

#### 1.挂载

mount命令用于挂载文件系统，格式为“mount 文件系统  挂载目录”。

表6-3                                             mount命令中的参数以及作用

| 参数 | 作用                                                         |
| ---- | ------------------------------------------------------------ |
| -a   | 挂载所有在/etc/fstab中定义的文件系统，会在执行后自动检查/etc/fstab文件中有无疏漏被挂载的设备文件，如果有，则进行自动挂载操作。 |
| -t   | 指定文件系统的类型。 对于比较新的Linux系统来讲，一般不需要使用-t参数来指定文件系统的类型 |

```shell
[root@linuxprobe ~]# mount /dev/sdb2 /backup
```

#### 2.永久挂载

如果想让硬件设备和目录永久地进行自动关联，就必须把挂载信息按照指定的填写格式“设备文件  挂载目录 格式类型 权限选项 是否备份  是否自检”（各字段的意义见表6-4）写入到**/etc/fstab**文件中。

表6-4                        用于挂载信息的指定填写格式中，各字段所表示的意义

| 字段     | 意义                                                         |
| -------- | ------------------------------------------------------------ |
| 设备文件 | 一般为设备的路径+设备名称，也可以写唯一识别码（UUID，Universally Unique Identifier） |
| 挂载目录 | 指定要挂载到的目录，需在挂载前创建好                         |
| 格式类型 | 指定文件系统的格式，比如Ext3、Ext4、XFS、SWAP、iso9660（此为光盘设备）等 |
| 权限选项 | 若设置为defaults，则默认权限为：rw, suid, dev, exec, auto, nouser, async |
| 是否备份 | 若为1则开机后使用dump进行磁盘备份，为0则不备份               |
| 是否自检 | 若为1则开机后自动进行磁盘自检，为0则不自检                   |

如果想将文件系统为ext4的硬件设备/dev/sdb2在开机后自动挂载到/backup目录上，并保持默认权限且无需开机自检，就需要在/etc/fstab文件中写入下面的信息，这样在系统重启后也会成功挂载。

```shell
[root@linuxprobe ~]# vim /etc/fstab
#
# /etc/fstab
# Created by anaconda on Wed May 4 19:26:23 2017
#
# Accessible filesystems, by reference, are maintained under '/dev/disk'
# See man pages fstab(5), findfs(8), mount(8) and/or blkid(8) for more info
#
/dev/mapper/rhel-root / xfs defaults 1 1
UUID=812b1f7c-8b5b-43da-8c06-b9999e0fe48b /boot xfs defaults 1 2
/dev/mapper/rhel-swap swap swap defaults 0 0
/dev/cdrom /media/cdrom iso9660 defaults 0 0 
# 永久挂载
/dev/sdb2 /backup ext4 defaults 0 0
```

#### 3.撤消挂载

umount命令用于撤销已经挂载的设备文件，格式为“umount  [挂载点/设备文件]”。

```shell
[root@linuxprobe ~]# umount /dev/sdb2
```

### 6.8 软硬链接连接方式

**硬链接（hard link）**：可以将它理解为一个“指向原始文件inode的指针”，系统不为它分配独立的inode和文件。所以，硬链接文件与原始文件其实是同一个文件，只是名字不同。我们每添加一个硬链接，该文件的inode连接数就会增加1；而且只有当该文件的inode连接数为0时，才算彻底将它删除。换言之，由于硬链接实际上是指向原文件inode的指针，因此即便原始文件被删除，依然可以通过硬链接文件来访问。需要注意的是，由于技术的局限性，我们不能跨分区对目录文件进行链接。

**软链接（也称为符号链接[symbolic link]）**：仅仅包含所链接文件的路径名，因此能链接目录文件，也可以跨越文件系统进行链接。但是，当原始文件被删除后，链接文件也将失效，从这一点上来说与Windows系统中的“快捷方式”具有一样的性质。

#### 1. ln 命令

ln命令用于创建链接文件，格式为“ln [选项]  目标”。

表6-6                                             ln命令中可用的参数以及作用

| 参数 | 作用                                               |
| ---- | -------------------------------------------------- |
| -s   | 创建“符号链接”（如果不带-s参数，则默认创建硬链接） |
| -f   | 强制创建文件或目录的链接                           |
| -i   | 覆盖前先询问                                       |
| -v   | 显示创建链接的过程                                 |

```shell
# 软连接
[root@linuxprobe ~]# echo "Welcome to linuxprobe.com" > readme.txt
[root@linuxprobe ~]# ln -s readme.txt readit.txt
[root@linuxprobe ~]# cat readme.txt 
Welcome to linuxprobe.com
[root@linuxprobe ~]# cat readit.txt 
Welcome to linuxprobe.com
[root@linuxprobe ~]# ls -l readme.txt 
-rw-r--r-- 1 root root 26 Jan 11 00:08 readme.txt
[root@linuxprobe ~]# rm -f readme.txt 
[root@linuxprobe ~]# cat readit.txt 
cat: readit.txt: No such file or directory

# 硬连接 删除原文件后 链接文件任然有效
[root@linuxprobe ~]# echo "Welcome to linuxprobe.com" > readme.txt
[root@linuxprobe ~]# ln readme.txt readit.txt
[root@linuxprobe ~]# cat readme.txt 
Welcome to linuxprobe.com
[root@linuxprobe ~]# cat readit.txt 
Welcome to linuxprobe.com
[root@linuxprobe ~]# ls -l readme.txt 
-rw-r--r-- 2 root root 26 Jan 11 00:13 readme.txt
[root@linuxprobe ~]# rm -f readme.txt 
[root@linuxprobe ~]# cat readit.txt 
Welcome to linuxprobe.com
```

## 第八章  Iptables与Firewalld防火墙

### 8.2 iptables

#### 8.2.1 策略与规则链 

iptables服务把用于处理或过滤流量的策略条目称之为规则，多条规则可以组成一个规则链，而规则链则依据数据包处理位置的不同进行分类，具体如下：

> 在进行路由选择前处理数据包（PREROUTING）；
>
> 处理流入的数据包（INPUT）；
>
> 处理流出的数据包（OUTPUT）；
>
> 处理转发的数据包（FORWARD）；
>
> 在进行路由选择后处理数据包（POSTROUTING）。

#### 8.2.2 基本的命令参数

表8-1                                           iptables中常用的参数以及作用

| 参数        | 作用                                         |
| ----------- | -------------------------------------------- |
| -P          | 设置默认策略                                 |
| -F          | 清空规则链                                   |
| -L          | 查看规则链                                   |
| -A          | 在规则链的末尾加入新规则                     |
| -I num      | 在规则链的头部加入新规则                     |
| -D num      | 删除某一条规则                               |
| -s          | 匹配来源地址IP/MASK，加叹号“!”表示除这个IP外 |
| -d          | 匹配目标地址                                 |
| -i 网卡名称 | 匹配从这块网卡流入的数据                     |
| -o 网卡名称 | 匹配从这块网卡流出的数据                     |
| -p          | 匹配协议，如TCP、UDP、ICMP                   |
| --dport num | 匹配目标端口号                               |
| --sport num | 匹配来源端口号                               |

```shell
# 在iptables命令后添加-L参数查看已有的防火墙规则链：
iptables -L
# 在iptables命令后添加-F参数清空已有的防火墙规则链：
iptables -F
# 把INPUT规则链的默认策略设置为拒绝：
iptables -P INPUT DROP
# 向INPUT链中添加允许ICMP流量进入的策略规则：
iptables -I INPUT -p icmp -j ACCEPT
# 删除INPUT规则链中刚刚加入的那条策略（允许ICMP流量），并把默认策略设置为允许：
iptables -D INPUT 1
iptables -P INPUT ACCEPT
# 将INPUT规则链设置为只允许指定网段的主机访问本机的22端口，拒绝来自其他所有主机的流量：
iptables -I INPUT -s 192.168.10.0/24 -p tcp --dport 22 -j ACCEPT
iptables -A INPUT -p tcp --dport 22 -j REJECT
# 向INPUT规则链中添加拒绝所有人访问本机12345端口的策略规则：
iptables -I INPUT -p tcp --dport 12345 -j REJECT
iptables -I INPUT -p udp --dport 12345 -j REJECT
# 向INPUT规则链中添加拒绝192.168.10.5主机访问本机80端口（Web服务）的策略规则：
ptables -I INPUT -p tcp -s 192.168.10.5 --dport 80 -j REJECT
# 向INPUT规则链中添加拒绝所有主机访问本机1000～1024端口的策略规则：
iptables -A INPUT -p tcp --dport 1000:1024 -j REJECT
iptables -A INPUT -p udp --dport 1000:1024 -j REJECT
```

### 8.3 Firewalld

表8-2                                     firewalld中常用的区域名称及策略规则

| 区域     | 默认规则策略                                                 |
| -------- | ------------------------------------------------------------ |
| trusted  | 允许所有的数据包                                             |
| home     | 拒绝流入的流量，除非与流出的流量相关；而如果流量与ssh、mdns、ipp-client、amba-client与dhcpv6-client服务相关，则允许流量 |
| internal | 等同于home区域                                               |
| work     | 拒绝流入的流量，除非与流出的流量相关；而如果流量与ssh、ipp-client与dhcpv6-client服务相关，则允许流量 |
| public   | 拒绝流入的流量，除非与流出的流量相关；而如果流量与ssh、dhcpv6-client服务相关，则允许流量 |
| external | 拒绝流入的流量，除非与流出的流量相关；而如果流量与ssh服务相关，则允许流量 |
| dmz      | 拒绝流入的流量，除非与流出的流量相关；而如果流量与ssh服务相关，则允许流量 |
| block    | 拒绝流入的流量，除非与流出的流量相关                         |
| drop     | 拒绝流入的流量，除非与流出的流量相关                         |

#### 8.3.1 终端管理工具

表8-3                                   firewall-cmd命令中使用的参数以及作用

| 参数                          | 作用                                                 |
| ----------------------------- | ---------------------------------------------------- |
| --get-default-zone            | 查询默认的区域名称                                   |
| --set-default-zone=<区域名称> | 设置默认的区域，使其永久生效                         |
| --get-zones                   | 显示可用的区域                                       |
| --get-services                | 显示预先定义的服务                                   |
| --get-active-zones            | 显示当前正在使用的区域与网卡名称                     |
| --add-source=                 | 将源自此IP或子网的流量导向指定的区域                 |
| --remove-source=              | 不再将源自此IP或子网的流量导向某个指定区域           |
| --add-interface=<网卡名称>    | 将源自该网卡的所有流量都导向某个指定区域             |
| --change-interface=<网卡名称> | 将某个网卡与区域进行关联                             |
| --list-all                    | 显示当前区域的网卡配置参数、资源、端口以及服务等信息 |
| --list-all-zones              | 显示所有区域的网卡配置参数、资源、端口以及服务等信息 |
| --add-service=<服务名>        | 设置默认区域允许该服务的流量                         |
| --add-port=<端口号/协议>      | 设置默认区域允许该端口的流量                         |
| --remove-service=<服务名>     | 设置默认区域不再允许该服务的流量                     |
| --remove-port=<端口号/协议>   | 设置默认区域不再允许该端口的流量                     |
| --reload                      | 让“永久生效”的配置规则立即生效，并覆盖当前的配置规则 |
| --panic-on                    | 开启应急状况模式                                     |
| --panic-off                   | 关闭应急状况模式                                     |
