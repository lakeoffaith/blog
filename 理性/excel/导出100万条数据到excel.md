## 导出100万条数据到excel

* 目的

  数据库中有100万条数据，用java程序导入到excel,所花费的时间

* 演示

  ![演示](./show.gif)

* 过程

  * eclipse 创建main

  * sqlserver连接数据库程序

    * TCP/IP连接失败 

      ```
      sqlserver 配置管理器打开tcp/ip连接
      ```

  * excel连接包

    *  java.lang.ClassNotFoundException: org.apache.commons.collections4.ListValuedMap

      ```
      添加commons-collections的jar包
      ```

  * 在数据库中创建100万条数据

    * 创建excelDemo数据库和employee表

    * 执行查询

      ```
      use excelDemo;
      GO
      DECLARE @LN VARCHAR(300),@MN VARCHAR(200),@FN VARCHAR(200)
      DECLARE @LN_N INT,@MN_N INT,@FN_N INT
      SET @LN='李王张刘陈杨黄赵周吴徐孙朱马胡郭林何高梁郑罗宋谢唐韩曹许邓萧冯曾程蔡彭潘袁于董余苏叶吕魏蒋田杜丁沈姜范江傅钟卢汪戴崔任陆廖姚方金邱夏谭韦贾邹石熊孟秦阎薛侯雷白龙段郝孔邵史毛常万顾赖武康贺严尹钱施牛洪龚'
      SET @MN='德绍宗邦裕傅家積善昌世贻维孝友继绪定呈祥大正启仕执必定仲元魁家生先泽远永盛在人为任伐风树秀文光谨潭棰'
      SET @FN='丽云峰磊亮宏红洪量良梁良粮靓七旗奇琪谋牟弭米密祢磊类蕾肋庆情清青兴幸星刑'
      SET @LN_N=LEN(@LN)
      SET @MN_N=LEN(@MN)
      SET @FN_N=LEN(@FN)
      DECLARE @TMP VARCHAR(1000),@I INT
      SET @I=0
      WHILE @I<1000000
      BEGIN
          SET @TMP=CAST(SUBSTRING(@LN,CAST(RAND()*@LN_N AS INT),1) AS VARCHAR)
          SET @TMP=@TMP+CAST(SUBSTRING(@MN,CAST(RAND()*@MN_N AS INT),1) AS VARCHAR)
          SET @TMP=@TMP+CAST(SUBSTRING(@FN,CAST(RAND()*@FN_N AS INT),1) AS VARCHAR)
          INSERT INTO employee(name,cellPhone) VALUES(@TMP,'2005'+@I)
          SET @I=@I+1
      end
      ```

      ​

    ​

  * 读取数据

    * Invalid row number (65536) outside allowable range (0..65535)

      ```
      改用xssf
      ```

    * 速度太慢

      ```
      改用sxssf
      http://poi.apache.org/spreadsheet/index.html
      ```

  * 结果

    ```
    完成时间大约为40多秒
    ```

    ​