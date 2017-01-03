## sql优化

数据库优化，主要有sql优化。

sql优化主要有：

​	索引是否建立，

​       索引是否因为函数而失效 （UPPER(user_name)）

​       表的连接

​    索引和全表扫描。当需要扫描一张表的大部分的数据的时候，请选择全表扫描。

​      

sql优化思考步骤，就是了解oracle如何去执行这条语句，就是通过看执行计划

   explain plan   statement_id as "" for   select * from employee;

  给执行计划起一个名字

视图默认为执行计划的一部分，不显示出来。



sql优化报告

​     查询的频率。

​    查询的sql。

​    查询的磁盘i/o ，cpu

   查询的时间。



   调优后的sql，查询的磁盘，cpu,查询的时间。



​     