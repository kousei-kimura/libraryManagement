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

<%
	request.setCharacterEncoding("UTF-8");

	String result = (String)request.getAttribute("result");

%>


<div class="form">

<div align="center">


<p><font size="15"><%= result%></font></p>



<form action="/Librarymanagement/LoanServlet.html" method="post">

	<input class="b" type="submit" name="button" value="貸出画面へ">

</form>

</div>

</div>


</body>
</html>