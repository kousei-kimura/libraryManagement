<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>追加</title>
</head>
<body>

<div class="form">

<div align="center">


<% if(request.getParameter("error1") != null){ %>

	<p style="color:red"><font size="10">全ての項目が入力されていません。<br>入力してください。</font></p>

	<%} else {%>

	<font size="10">登録したい本の内容を入力してください。</font><br>

	<%}%>


	<form action="/Librarymanagement/AddResultServlet.html" method="post">

	<p><font size="10">図書ID : </font><input class="t" type="text" name="bookid" size="40"></p><br>

	<p><font size="10">図書名 : </font><input class="t" type="text" name="bookname" size="40"></p><br>

	<p><font size="10">著者 : </font><input class="t" type="text" name="author" size="40"></p><br>

	<p><font size="10">出版社 : </font><input class="t" type="text" name="publisher" size="40"></p><br>

	<p><font size="10">ISBN番号 : </font><input class="t" type="text" name="isbnid" size="40"></p><br>

	<input class="b" type="submit" name="button" value="登録">

	</form>


<form action="/Librarymanagement/MenuServlet.html" method="post">

	<input class="b" type="submit" name="button" value="メニュー画面へ">

</form>

</div>

</div>

</body>
</html>