<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form | Dan Aleko</title>
    <link rel="stylesheet" href="styles/registerAndLoginStyle.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="wrapper">
    <form action="login" method="post">
        <h1>Login</h1>
        <div class="input-box">
            <input type="text" placeholder="Username" name="username" required>
            <i class='bx bxs-user'></i>
        </div>
        <div class="input-box">
            <input type="password" placeholder="Password" name="password" required>
            <i class='bx bxs-lock-alt' ></i>
        </div>
        <button type="submit" name="action" value="login" class="btn">Login</button>
        <div class="register-link">
            <p>Dont have an account? <a href="register.jsp">Register</a></p>
        </div>
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
