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

<div class="form">

<div align="center">


<% if(request.getParameter("error1") != null){ %>

	<p style="color:red"><font size="10">IDが入力されていません。<br>入力してください。</font></p>

	<%} else {%>

	<font size="10">削除したい本のIDを入力してください。</font><br>

	<%}%>


<form action="/Librarymanagement/DeleteResultServlet.html" method="post">

	<p><font size="10">図書ID : </font><input class="t" type="text" name="bookid" size="40"></p><br>

	<input class="b" type="submit" name="button" value="削除">

	</form>


<form action="/Librarymanagement/MenuServlet.html" method="post">

	<input class="b" type="submit" name="button" value="メニュー画面へ">

</form>

</div>

</div>

</body>
</html>