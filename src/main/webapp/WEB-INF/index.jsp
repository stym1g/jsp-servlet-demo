<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1><a href="first">Servlet 1</a></h1>
<h1><a href="second">Servlet 2</a></h1>
<h1><a href="third">Servlet 3</a></h1>
<p>
    <a href="${pageContext.request.contextPath}/register.jsp">Register User Page</a>
</p>
</body>
</html>