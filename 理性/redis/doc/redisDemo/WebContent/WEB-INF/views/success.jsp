<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hello lizhengang

	<button id="Add">增加一条数据</button>
	<button id="Delete">删除一条数据</button>
	<script type="text/javascript">
		function ajax(actionName){
			var xmr=null;
			var params = "name=lihao"; 
			xmr=new XMLHttpRequest();
			xmr.open("GET","http://localhost:8080/redisDemo/"+actionName+"?name=lihao");
			xmr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmr.onreadystatechange=function(){
				if(xmr.readyState==4 && xmr.status==200){
					console.log(xmr.responseText);
					xmr=null;
				}
			};
			xmr.send();
		};
		function init(){
			var addbutton=document.getElementById("Add");
			addbutton.onclick=function(){
				ajax("add");
			}
			
			var deletebutton=document.getElementById("Delete");
			deletebutton.onclick=function(){
				ajax("delete");
			};
			
		};
		init();
	</script>
</body>
</html>