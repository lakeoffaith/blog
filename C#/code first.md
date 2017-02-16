## code first

* **更改数据库**

  (LocalDb)\v11.0  改成  localhost

  ```
   <add name="DefaultConnection" providerName="System.Data.SqlClient" connectionString="Data Source=localhost;Initial Catalog=Vbasket;User Id=sa;Password=black" />
  ```

  ​

* **操作**

  > 打开

  视图->其他窗口->程序包管理控制台

* **命令**

```
Enable-Migrations
//建议设置Configuration.cs 中的AutomaticMigrationsEnabled = true; 自动迁移数据库
Add-Migration
update-database
```

