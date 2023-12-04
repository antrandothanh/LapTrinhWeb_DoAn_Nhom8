<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <link rel="stylesheet" href="styles/customerInformation.css">--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />--%>
<%--    <title>Xin chào</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@include file="header.jsp"%>--%>

<%--<div class="content-container">--%>
<%--    <div class="form-container">--%>
<%--        <div class="box">--%>
<%--            <h2>Thông tin cá nhân</h2>--%>
<%--            <form action="manageCustomer" method="post">--%>
<%--                <div>--%>
<%--                    <div>--%>
<%--                        <label for="username">Tên tài khoản:</label>--%>
<%--                        <input type="text" id="username" name="username" value="<%=user.getUsername()%>" readonly required>--%>

<%--                        <label for="password">Mật khẩu:</label>--%>
<%--                        <input type="text" id="password" name="password" value="<%=user.getPassword()%>" required>--%>

<%--                        <label for="name">Tên:</label>--%>
<%--                        <input type="text" id="name" name="name" value="<%=user.getName()%>" required>--%>
<%--                    </div>--%>
<%--                    <div>--%>
<%--                        <label for="address">Địa chỉ:</label>--%>
<%--                        <input type="text" id="address" name="address" value="<%=user.getAddress()%>" required>--%>

<%--                        <label for="email">Email:</label>--%>
<%--                        <input type="email" id="email" name="email" value="<%=user.getEmail()%>" required>--%>

<%--                        <label for="phone">Điện thoại:</label>--%>
<%--                        <input type="text" id="phone" name="phone" value="<%=user.getPhone()%>" required>--%>

<%--                        <label for="money">Số tiền:</label>--%>
<%--                        <input type="text" id="money" value="<%=user.getMoney()%>" readonly required>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <button type="submit" name="action" value="customerEditInformation">Sửa thông tin</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<%@include file="footer.jsp"%>--%>
<%--</body>--%>
<%--</html>--%>










<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xin chào</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/customerInformation.css">
</head>
<body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="header.jsp"%>
<div class="container rounded bg-white mt-5">
    <div class="row">
        <div class="col-md-4 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="mat an danh" width="90"><span class="font-weight-bold"><%=user.getName()%></span><span class="text-black-50"><%=user.getEmail()%></span></div>
        </div>
        <div class="col-md-8">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <div class="d-flex flex-row align-items-center back"><i class="fa fa-long-arrow-left mr-1 mb-1"></i>
                        <h6><a href="index.jsp">Quay lại trang chủ</a></h6>
                    </div>
                    <h6 class="text-right">Thông tin khách hàng</h6>
                </div>
                <form action="manageCustomer" method="post">
                    <div class="row mt-2">
                        <div class="col-md-6"><label>Tên tài khoản</label><input type="text" class="form-control" name="username" value="<%=user.getUsername()%>" readonly required></div>
                        <div class="col-md-6"><label>Mật khẩu</label><input type="text" class="form-control" name="password" value="<%=user.getPassword()%>"  required></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label>Tên</label><input type="text" class="form-control" name="name" value="<%=user.getName()%>" required></div>
                        <div class="col-md-6"><label>Địa chỉ</label><input type="text" class="form-control" name="address" value="<%=user.getAddress()%>"  required></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label>Email</label><input type="email" class="form-control" name="email" value="<%=user.getEmail()%>" required></div>
                        <div class="col-md-6"><label>Điện thoại</label><input type="text" class="form-control" name="phone" value="<%=user.getPhone()%>>" required></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label>Tiền</label><input type="text" class="form-control" value="<%=user.getMoney()%>" readonly required></div>
                    </div>
                    <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="submit" name="action" value="customerEditInformation">Sửa thông tin</button></div>
                </form>

            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>

