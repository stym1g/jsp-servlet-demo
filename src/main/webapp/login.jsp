<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
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
    <h1 style="text-align: center">Login to your account</h1>
    <form action="Login" method="post">
        <table>
            <tr>
                <td>User Name: <input type="text" name="user_name" placeholder="Choose a username"></td>
            </tr>
            <tr>
                <td>Password:<input type="password" name="user_password" placeholder="Password here"></td>
            </tr>
            <tr>
                <td style="text-align: center"><button type="submit">Login</button> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
