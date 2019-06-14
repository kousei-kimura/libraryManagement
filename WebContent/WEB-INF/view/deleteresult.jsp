<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>削除</title>
</head>
<body>


<%
	request.setCharacterEncoding("UTF-8");

	String result = (String)request.getAttribute("result");

%>



<div class="form">

<div align="center">


<font size="15"><%= result%></font>

<form action="/Librarymanagement/DeleteServlet.html" method="post">

	<input class="b" type="submit" name="button" value="削除画面へ">

</form>


<form action="/Librarymanagement/MenuServlet.html" method="post">

	<input class="b" type="submit" name="button" value="メニュー画面へ">

</form>

</div>

</div>

</body>
</html>