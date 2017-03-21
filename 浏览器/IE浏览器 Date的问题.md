## IE浏览器 Date的问题

* 不能转换date

  ```
  1.var dateTime = new Date("2016/05/20 23:42:00");   改用着种格式
  2.判断document.all 为真的时候，用不定式分割日期字符串，new Date(yyyy,MM,dd,HH,mm,ss);
  ```

  ​