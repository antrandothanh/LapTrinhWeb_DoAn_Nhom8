<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/registerAndLoginStyle.css">
</head>
<body>
<div class="form">
    <form action="register" method="post">
        <h1>Register</h1>
        <input type="hidden" name="action" value="register">
        <div class="form-container">
            <div class="label">
                <label>Username:</label>
                <label>Password:</label>
                <label>Name:</label>
                <label>Email:</label>
                <label>Phone:</label>
                <label>Address:</label>
            </div>
            <div class="input">
                <input type="text" name="username">
                <input type="text" name="password">
                <input type="text" name="name">
                <input type="text" name="email">
                <input type="text" name="phone">
                <input type="text" name="address">
            </div>
        </div>
        <input type="submit" value="Sign up">
    </form>
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
