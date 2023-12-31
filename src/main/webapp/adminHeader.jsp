<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Entity.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header-admin.css">
</head>
    <%
        User user = (User)session.getAttribute("user");
    %>
    <section class="header">
        <div class="logo-luxury-shopping">
            <img src="picture/logo.png" alt="logo Luxury Shopping">
        </div>
        <div class="name-of-section-and-admin">
            <span id="title-section">TRANG QUẢN TRỊ VIÊN</span>
            <span id="admin-name">Xin chào <strong><%=user.getName()%></strong></span>
        </div>
    </section>
</html>
