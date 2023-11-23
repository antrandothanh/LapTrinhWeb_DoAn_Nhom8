<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/registerAndLoginStyle.css">
</head>
<body>
<div class="form">
    <form action="login" method="post">
        <h1>Login</h1>
        <input type="hidden" name="action" value="login">
        <div class="form-container">
            <div class="label">
                <label>Username:</label>
                <label>Password:</label>
            </div>
            <div class="input">
                <input type="text" name="username">
                <input type="password" name="password">
            </div>
        </div>
        <input type="submit" value="Login">
    </form>
    <br>
    <p>If you haven't sign up yet, please <a href="register.jsp">sign up</a></p>
    <br>
    <%
        String message = (String)request.getAttribute("message");
        if (message != null) {
    %>
            <p><%=message%></p>
    <%
        }
    %>
</div>
</body>
</html>
