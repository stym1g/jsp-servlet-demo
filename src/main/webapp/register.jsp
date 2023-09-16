<%--
  Created by IntelliJ IDEA.
  User: satyam
  Date: 10/09/23
  Time: 1:48 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
  <style>
    .container{
      width: 40%;
      border: 1px solid #1d1515;
      margin: auto;
    }
  </style>
</head>
<body>
<div class="container">
  <h1 style="text-align: center">My Form</h1>
  <form action="RegisterServlet" method="post">
    <table>
      <tr>
        <td>First Name: <input type="text" name="first_name" placeholder="Enter first name here"></td>
        <td>Last Name: <input type="text" name="last_name" placeholder="Enter last name here"></td>
      </tr>
      <tr>
        <td>Email: <input type="email" name="user_email" placeholder="Enter email here"></td>
      </tr>
      <tr>
        <td>Username: <input type="text" name="user_name" placeholder="Choose a username"></td>
      </tr>
      <tr>
        <td>Mobile: <input type="text" name="user_mobile" maxlength="10" placeholder="Enter mobile here"></td>
      </tr>
      <tr>
        <td>Choose Password:<input type="password" name="user_password" placeholder="Password here"></td>
      </tr>
      <tr>
        <td>
          <input type="checkbox" value="checked" name="accept_terms">  Accept terms and conditions
        </td>
      </tr>
      <tr>
        <td style="text-align: center"><button type="submit">Submit</button>  <button type="reset">Reset</button> </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
