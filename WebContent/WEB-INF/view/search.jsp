<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>検索</title>
</head>
<body>


<div class="form">

<div align="center">


	<font size="10">検索したいワードを入力してください。</font><br>


	<form action="/Librarymanagement/SearchResultServlet.html" method="post">

	<input class="t" type="text" name="search" size="40"><br>　

	<input class="b" type="submit" name="bookname" value="名前検索">

	<input class="b" type="submit" name="author" value="著者検索">

	<input class="b" type="submit" name="publisher" value="出版社検索">

	</form>



<form action="/Librarymanagement/MenuServlet.html" method="post">

	<input class="b" type="submit" name="button" value="メニュー画面へ">

</form>

</div>

</div>


</body>
</html>