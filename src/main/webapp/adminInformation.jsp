<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Entity.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" type="text/css" href="styles/body-admin.css"/>
    <link rel="stylesheet" type="text/css" href="styles/adminInformation.css"/>
</head>
<body>
    <%
        User user = (User)session.getAttribute("user");
    %>
    <section>
        <jsp:include page="adminHeader.jsp"/>
    </section>
    <section style="display: flex">
        <section>
            <jsp:include page="adminSideBar.jsp"/>
        </section>
        <section class="content-container" style="height: 500px">
            <div class="content-title">
                Thông tin cá nhân
            </div>
            <div class="admin-information-container">
                <div class="label-of-information">
                    <label>Tên tài khoản:</label>
                    <br>
                    <label>Tên:</label>
                    <br>
                    <label>Email:</label>
                    <br>
                    <label>Số điện thoại:</label>
                    <br>
                    <label>Địa chỉ:</label>
                </div>
                <div class="values-of-information">
                    <span><%=user.getUsername()%></span>
                    <br>
                    <span><%=user.getName()%></span>
                    <br>
                    <span><%=user.getEmail()%></span>
                    <br>
                    <span><%=user.getPhone()%></span>
                    <br>
                    <span><%=user.getAddress()%></span>
                </div>
            </div>
        </section>
    </section>
</body>
</html>
