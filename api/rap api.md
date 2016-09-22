##RAP API

##explain
在后端还没好的情况下，为了前端能获取模拟的数据(json),我们决定采用RAP 作为mock,供前端调用。
##step
将jsmock修改成jsmockdata可以将响应结果变成json文本，转换为json就可以直接使用
##case
1. 请求 变量名 id	备注 @mock=200   没有id的话默认为200
2. 响应 变量名  userId  备注  @mock=@userId    让返回的userId的值等于请求参数id
3. 响应 变量名  results|1  类型为 array<object>  让返回results的长度为1，
4. 响应 变量名  number|1-100  类型为数字      让返回number为1-100中的随机数
5. 响应 变量名  number|1-100.1  类型为数字    可以返回number为1-100中带一个小数位的数字
6. 响应 变量名  name    为results数组成员属性名 备注为@mock=$order('wanwu','zhangsan')则表示results有两个数组成员,第一个name为wanwu,第二个name为zhangsan。注意results变量名如果为results 和 results|1 都只随机返回一个数组成员


##ref
[http://rap.taobao.org/org/index.do](http://rap.taobao.org/org/index.do)

[http://mockjs.com/examples.html](http://mockjs.com/examples.html)

[https://segmentfault.com/a/1190000003087224](https://segmentfault.com/a/1190000003087224)
* * *
update 2016-09-09
update 2016-09-11
last update 2016-09-22