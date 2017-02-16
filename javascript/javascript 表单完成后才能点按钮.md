## javascript 表单完成后才能点按钮

```
<html>
<head>
</head>
<body>
    <!-- HTML 正文 -->
    <form action="sent.php" method="post" name="frm">
    <input type="text" name="name_input" id="name">
    <br>
    <button type="submit" class="button button-dark" id="send" disabled>Send message</button>
</form>
</body>
<script type="text/javascript">
    document.getElementById("name").addEventListener("keyup", function() {
    var nameInput = document.getElementById('name').value;
    if (nameInput != "") {
        document.getElementById('send').removeAttribute("disabled");
    } else {
        document.getElementById('send').setAttribute("disabled", null);
    }
});
</script>  
</html>
```



* **disabled**

​	属性：元素有disabled则表示为不可操作，无disabled则为可操作，不能设置为false或者true来判断