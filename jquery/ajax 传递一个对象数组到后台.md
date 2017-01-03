## ajax 传递一个对象数组到后台

在ajax如果传递一个数组到后台，后台就用list接受，

传递对象数组推荐方法，

var list={}; 声明为一个对象

循环jquery 选择器

list[listData["+i+"].name=xxx;

list[listData["+i+"].desc=xxx;

$.ajax({

 data:list,

})



在controller 用  list<xxx>  listData进行接受   注意listData名字一定得相同