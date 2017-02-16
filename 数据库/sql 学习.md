## sql server 学习

* **问题一**

> 数据库中有表如下，

    id  name  
    1   lizhen
    1   nihao
    1	welcome
    2   zhangsan
    2    nihao
    
> 呈现如下

```
1  lizhen,nihao,welcome
2  zhangsan,nihao
```

* **解决问题**

  ```
  USE play
  go
  if EXISTS (SELECT 1 from Sysobjects where name='test' )
  drop table test
  go

  create table test(id int,name VARCHAR(50));
  insert test(id,name) values(1,'lizhen');
  insert test(id,name) values(1,'nihao');
  insert test(id,name) values(1,'welcome');
  insert test(id,name) values(2,'zhansan');
  insert test(id,name) values(2,'deny');
  ```

  ```
  USE play
  go
  SELECT id ,name=STUFF((SELECT ','+name from test as t2 where t2.id=test.id for xml path('') ), 1, 1, '')
  from test
  GROUP BY id;

  USE play
  go
  SELECT id ,(SELECT name from test as t2 where t2.id=test.id for xml path('') )
  from test
  GROUP BY id;
  ```

  ​


