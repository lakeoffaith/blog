## Polymer web 组件

将css,html,js进行封装，给予特定的生命周期，简化开发，成为开发平台



grul 将会超过grunt,



web组件是可以除jquery,但是最好不除。



组件用brower构建，需要引入nodejs.可以发布。

```
<script>

 Polymer({

  is: 'demo-test',

  extends: 'div', <!-- 关键就在这里

  ready: function(e) {

   this.innerHTML = '我是一个 demo-test';

  }

 });

</script>

 

<div is="demo-test"></div>

```



