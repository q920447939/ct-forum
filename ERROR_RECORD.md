1,spring-boot 加上@RestController 不起作用或者报错
    `The DispatcherServlet configuration needs to include a HandlerAdapter that supports th`
    

解决方法一:尝试加上`@RestController`+`@RequestMapping`

```java
@RestController
@RequestMapping("/topic")
```

2,报错`No serializer found for class java.lang.Object and no properties discovered to create BeanSerializer `
    我的解决办法是发现bean copy的时候,bean里面还有bean  如下,此时属性records由于是泛型导致我项目中使用的copy会丢失类型,于是返回json解析的时候就会报错,所以重新设置一下records属性值就行了
```java
    public class Page<T> implements IPage<T> {
        private List<T> records;
    }
    //do something
    
    IPage<TopicVO> vos = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
    vos.setRecords(CopyAttributesUtils.copyAlistToBlist(pageList.getRecords(), TopicVO.class));
    //此时如果进行vos的json转化就会报错,debug也会发现records的值是异常的         
```



3,报错 

     Cause: com.mysql.cj.jdbc.exceptions.PacketTooBigException: Packet for query is too large (7,366 > 1,024). You can change this value on the server by setting the 'max_allowed_packet' variable.
         ; Packet for query is too large (7,366 > 1,024). You can change this value on the server by setting the 'max_allowed_packet' variable.; nested exception is com.mysql.cj.jdbc.exceptions.PacketTooBigException: Packet for query is too large (7,366 > 1,024). You can change this value on the server by setting the 'max_allowed_packet' variable.] with root cause
     
     com.mysql.cj.jdbc.exceptions.PacketTooBigException: Packet for query is too large (7,366 > 1,024). You can change this value on the server by setting the 'max_allowed_packet' variable.`



解决办法(MySQL根据配置文件会限制Server接受的数据包大小。有时候插入、更新或查询时数据包的大小，会受 max_allowed_packet 参数限制，导致操作失败。):

1.查询

```mysql
show VARIABLES like '%max_allowed_packet%';
```

得到结果如下：

```mssql
+--------------------+------------+ 
| Variable_name   | Value  | 
+--------------------+-------------------+ 
| max_allowed_packet | 1024 | 
+--------------------+-------------------+
```

2.在mysql 命令行中运行

```mysql
set global max_allowed_packet = 2*1024*1024*10
```



3.重启

 	3.1docker内重启命令  ` docker restart 9ff548e8bd4c` ,   `9ff548e8bd4c`是容器id

```shell
[root@VM_95_93_centos ~]# docker ps  
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                               NAMES
9ff548e8bd4c        mysql:5.7           "docker-entrypoint.s…"   7 days ago          Up 7 days           0.0.0.0:3306->3306/tcp, 33060/tcp   MySQLDocker
[root@VM_95_93_centos ~]# docker restart 9ff548e8bd4c

```

​	3.2  重启Linux的mysql

​		1、使用 service 启动：`service mysqld restart`

​		2、使用 mysqld 脚本启动：`/etc/inint.d/mysqld restart  `

4.查看是否修改成功

```mysql
show VARIABLES like '%max_allowed_packet%';
```

