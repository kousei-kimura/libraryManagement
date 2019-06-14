<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">

<title>貸出画面</title>
</head>
<body>

<div class="form">

<div align="center">


<% if(request.getParameter("error") != null){ %>

	<p style="color:red"><font size="10">IDが入力されていません。<br>入力してください。</font></p>

	<%} else {%>

	<font size="10">本のIDを入力してください。</font><br>

	<%}%>


	<form action="/Librarymanagement/LoanResultServlet.html" method="post">

	<p><input class="t" type="text" name="id" size="40"></p><br>

	<input class="b" type="submit" name="button" value="貸出">　

	<input class="b" type="submit" name="button" value="返却">　

	</form>

<form action="/Librarymanagement/ListServlrt.html" method="post">

	<input class="b" type="submit" name="button" value="一覧画面へ">

</form>

<form action="/Librarymanagement/MenuServlet.html" method="post">

	<input class="b" type="submit" name="button" value="メニュー画面へ">

</form>


</div>

</div>

</body>
</html>