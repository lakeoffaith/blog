## datatable 

* 页面加载完成后，$("#table").dataTable({})，进行加载

* 按钮点击后，重新加载。$("#table").DataTable().ajax.reload();

* 传输添加参数

  ```
  fnServerParams 增加参数 aoData.push({"name": "conds", "value": data}); 
  ```

* 判断是否已经初始化了

  ```
   $('#datatable1').hasClass('dataTable')
  ```

  ​


1.自定义列

```
"columnDefs": [{"targets": [3],
"data": "id",
"render": function(data, type, full) {
			return "Update";}
}]

public ActionResult Edit(string id=null)
   {

 	 return View();

   }      

```



   





别的一种加载为为定义一个json对象。用$.extends,生产新的对象，传入进DataTables中。