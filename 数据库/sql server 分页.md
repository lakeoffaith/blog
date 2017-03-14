## sql server 分页

```
sqlserver 分页  limit

  1. select top @pageSize id from tablename  
  2. where id not in (  
  3.   select top @offset id from tablename  
  4. ) 
```

