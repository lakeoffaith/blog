## pockethub 

* 调试 github登录Callback_url问题

  ```
  1.在github oauth new application 中的callback_url 填入 myawesomeschema://nihao.com
  2.在项目中gradle.properties 中 pockethub_github_callback=myawesomeschema://nihao.com
  ```

  ​