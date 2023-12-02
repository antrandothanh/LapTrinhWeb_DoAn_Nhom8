<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/customerInformation.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Xin chào</title>
</head>
<body>
<%@include file="header.jsp"%>

<div class="content-container">
    <div class="form-container">
        <div class="box">
            <h2>Thông tin cá nhân</h2>
            <form action="manageCustomer" method="post">
                <div>
                    <div>
                        <label for="username">Tên tài khoản:</label>
                        <input type="text" id="username" name="username" value="<%=user.getUsername()%>" readonly required>

                        <label for="password">Mật khẩu:</label>
                        <input type="text" id="password" name="password" value="<%=user.getPassword()%>" required>

                        <label for="name">Tên:</label>
                        <input type="text" id="name" name="name" value="<%=user.getName()%>" required>
                    </div>
                    <div>
                        <label for="address">Địa chỉ:</label>
                        <input type="text" id="address" name="address" value="<%=user.getAddress()%>" required>

                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="<%=user.getEmail()%>" required>

                        <label for="phone">Điện thoại:</label>
                        <input type="text" id="phone" name="phone" value="<%=user.getPhone()%>" required>

                        <label for="money">Số tiền:</label>
                        <input type="text" id="money" value="<%=user.getMoney()%>" readonly required>
                    </div>
                </div>

                <button type="submit" name="action" value="customerEditInformation">Sửa thông tin</button>
            </form>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
