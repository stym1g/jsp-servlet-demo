<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello" %>
</h1>
<br/>
<p>
    <a href="${pageContext.request.contextPath}/register.jsp">Register User</a>  <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
</p>
</body>
</html>