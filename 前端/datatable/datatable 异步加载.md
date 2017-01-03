## datatable 异步加载

1.页面加载完成后，$("#table").dataTable({})，进行加载

2.按钮点击后，重新加载。$("#table").DataTable().ajax.reload();





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