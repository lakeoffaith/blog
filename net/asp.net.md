## asp.net

ScriptManager.RegisterClientScriptBlock

3.使用Page.ClientScript.RegisterClientScriptInclude

许多开发者把JavaScript放置在.js文件中，使用RegisterClientScriptInclude方法可以注册.js文件中的 JavaScript。



string myScript = “myJavaScriptCode.js”



Page.ClientScript.RegisterClientScriptInclude(“myKey”, myScript);

这将在ASP.NET页面产生如下结构：

```
<script src=”myJavaScriptCode.js” type=”text/javascript”></script>
```



