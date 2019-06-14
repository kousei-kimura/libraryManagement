<%@page import="java.util.ArrayList"%>
<%@page import="dto.Book_InformationDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">

<title>図書一覧</title>
</head>
<body>


<div class="form">


<div align="center">

 <table>

		 <tr>
            <th scope="col" >図書ID</th>
            <th scope="col" >図書名</th>
            <th scope="col" >著者</th>
            <th scope="col" >出版社</th>
            <th scope="col" >ISBN</th>
            <th scope="col" >登録日</th>
            <th scope="col" >更新日</th>
            <th scope="col" >状態</th>
        </tr>

<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<Book_InformationDto> List = (ArrayList<Book_InformationDto>)request.getAttribute("list");
	for(int i = 0 ; i < List.size() ; i++){
		Book_InformationDto booklist = List.get(i);
	%>

<% if(i%2 == 0) {%>

		 <tr>
            <td class="t"><%=booklist.getBookid() %></td>
            <td class="t"><%=booklist.getBookname() %></td>
            <td class="t"><%=booklist.getAuthor() %></td>
            <td class="t"><%=booklist.getPublisher() %></td>
            <td class="t"><%=booklist.getIsbnid() %></td>
            <td class="t"><%=booklist.getRecordday() %></td>
            <td class="t"><%=booklist.getResetday() %></td>
            <td class="t"><%=booklist.getLoanstate() %></td>
        </tr>

        <% } else{%>

        <tr>
            <td class="f"><%=booklist.getBookid() %></td>
            <td class="f"><%=booklist.getBookname() %></td>
            <td class="f"><%=booklist.getAuthor() %></td>
            <td class="f"><%=booklist.getPublisher() %></td>
            <td class="f"><%=booklist.getIsbnid() %></td>
            <td class="f"><%=booklist.getRecordday() %></td>
            <td class="f"><%=booklist.getResetday() %></td>
            <td class="f"><%=booklist.getLoanstate() %></td>
        </tr>

        <% } %>

	<%}%>

    </table>

	<form action="/Librarymanagement/LoanServlet.html" method="post">

	<input class="b"  type="submit" name="button" value="貸出画面へ">

	</form>

<form action="/Librarymanagement/MenuServlet.html" method="post">

	<input class="b" type="submit" name="button" value="メニュー画面へ">

</form>


</div>

</div>

</body>
</html>