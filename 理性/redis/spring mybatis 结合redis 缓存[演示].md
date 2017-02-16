## spring mybatis 结合redis 缓存[演示]

* **效果**

  ```
  1，1000篇文章，
  2,5000个评论
  3，评论列表，多次刷新，不会发送新的sql，时间比较
  4，增加评论，如果不修改redis中的相应的评论无效，则同样不会发送新的sql
  5,删除评论，修改redis中的相应的评论无线，再次查询，则会发送sql
  ```

* **视频**

* 任务分解

  * sql文件

    > DROP TABLE IF EXISTS article;
    >
    > CREATE TABLE article(
    >
    > ​	id int(11) NOT NULL AUTO_INCREMENT,
    >
    > ​	name varchar(255) DEFAULT NULL,
    >
    > ​	content varchar(255) DEFAULT NULL,
    >
    > ​	PRIMARY KEY(id)
    >
    > )ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8

  * sql评论

    >articleId int(11) NOT NULL,
    >
    >PRIMARY KEY (id),
    >
    >KEY f_comment_article (articleId),
    >
    >CONSTRAINT f_comment_article FOREIGN KEY (articleId) REFRENCES article (id) ON DELETE CASCADE 

  * eclipse 和 tomcat 发布

    >eclipse 新建动态项目，生产web.xml;右键项目发布到服务中，进入新建server项目，在server窗口中点击启动，发布项目成功。

    http://blog.csdn.net/tuntun1120/article/details/52787316

  * springmvc

    >对页面进行链接进行跳转获取数据，生产页面。
    >
    >1:在web.xml中配置servlet,加载进入springmvc.xml
    >
    >2:springmvc.xml 开启注解扫描，@Controller,@RequestMapper,@ResponseBody
    >
    >3:视图解析器，找到所需要的jsp模板。

  * spring

    >提供事务管理 :  业务逻辑完整性，数据库数据统一，要么数据插入全部正确，要么直接报错，数据全部不插入。
    >
    >提供切面 aop:用于权限控制，访问某个方法的日子记录，执行时间长度计算
    >
    >提供ioc容器: 通过注解来创建bean， 管理对象周期,依赖注入。
    >
    >配置文件:1:注解扫描，2:sqlsessionfactory bean,3:事务bean,4:mybatis mapper bean, 4:aop:aspectj-autoproxy/
    >
    >包:1:spring 需要的包 aop: aspectjweaver,aopalliance.jar

  * mybatis

    > mybatis-config.xml:配置全局别名加载mapper.xml,启用关联延迟加载，二级缓存，连接池等
    >
    > mapper.xml :resultmapper ,启用延迟加载，sql
    >
    > 包:1 sql打印 log4j,log4j-api,log4j-core,slf4j-api,slf4j-log4j12 ;2 mybatis ,mybatis-spring

  * 查询

  * 增删改查

  * 查询评论

  * 插入 1000 篇文章 和 5000 评论

    ```
    BEGIN

    	DECLARE b int DEFAULT 0;
    	DECLARE t_error INTEGER DEFAULT 0;
    	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;

    	START TRANSACTION;
    	while b<5000 DO
    	INSERT INTO comment (content,articleId) VALUES(CONCAT('评论的内容',b),FLOOR(6872+RAND()*1000));
    	set b=b+1;
    	end WHILE;
    	if t_error=1 THEN
    		ROLLBACK;
    	ELSE
    		COMMIT;
    	END IF;
    	SELECT t_error;



    END
    ```

  * 根据文章的id来查询 所有的评论

  * 查看到发送的sql

  * mybatis的延时加载功能

  * mybatis的二级缓存

    >mybatis的二级缓存http://www.cnblogs.com/DoubleEggs/p/6243223.html

  * redis 

    > 服务器安装 http://www.cnblogs.com/koal/p/5484916.html
    >
    > 客户端使用  如 flushall
    >
    > 包:jedis  和spring-data-redis
    >
    > 配置:1:redis.properties 2:spring中maxTotal和maxWaitMillis ，redisTemplate的bean

  * redis中存放list

  * 页面按钮调用原生ajax请求

  * 删除评论，redis中清除缓存

* **更改**

  1:list中每条数据以单独的key存放，数据的增删改都只针对redis中的数据，每隔一段时间就需要同步数据库和redis,怎么去同步？