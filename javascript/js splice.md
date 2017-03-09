## js splice

> javascript 数组删除指定位置的元素

```
var data=[{id:1,name:'first 1'},{id:2,name:'first 2'}]
var index=0; //从0开始
var howmany=1; //删除元素个数
data.splice(index,howmany);
//结果
console.log(data);
{id:2,name:'first 2'}
```

