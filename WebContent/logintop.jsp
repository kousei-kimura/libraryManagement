<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ログイン画面</title>
</head>
<body>


<div class="form">

<div align="center">


<% if(request.getParameter("error") != null){ %>

	<p style="color:red"><font size="10">全ての項目が入力されていません。<br>入力してください。</font></p>

	<%}%>


	<form action="/Librarymanagement/LoginServlet.html" method="post">

		<font size="10">【IDとPWを入力してください。】</font><br>

		<p><font size="10">ユーザID：<input class="t" type="text" name="id" size="40"></font></p><br>

		<p><font size="10">PW：<input class="t" type="password" name="pw" size="40"></font></p><br>

		<input class="b" type="submit" name="button" value="ログイン">

	</form>


</div>

</div>

</body>
</html>