<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <title>Luxury Store | Home</title>
</head>
<body>
    <section id="header">
        <div class="information">
            <div class="address">
                <img src="picture/Location_16px.png" alt=""  >
                01 Võ Văn Ngân, Linh Chiểu, Thủ Đức, Thành phố Hồ Chí Minh
            </div>
            <div class="hotline">
                Call Us: 1800 9991 | 028 3353 9929
            </div>
        </div>
        <div class="nav-1">
            <div class = "nav-1-children-1">
                <span><a href="search.jsp"><img src="picture/Search_32px.png" alt="search" width="104px"></a>   <!-- logo tìm kiếm--> </span>
            </div>
            <div class="logo">
                <a href="index.jsp"><img src="picture/logo.png" alt="logo" width="104px"></a>   <!-- logo cửa hàng -->
            </div>
            <div class="nav-1-children-2">
                    <form  action="favourite" method="post">
                        <input type="submit" value="" class="custom-favorite-button">
                    </form>
                    <form action="cart" method="post">
                        <!--<a href="cart.jsp"><img src="picture/ShoppingBag_32px.png" alt="cart" width="104px"></a>-->
                        <input type="submit" value="" class="custom-cart-button">
                    </form>
                    <!-- logo giỏ hàng--></span>
                <%
                    User user = (User)session.getAttribute("user");
                    if (user != null) {
                        %>
                            <div style="display: flex;justify-content: center;justify-items: center;text-align: center;align-items: center;">
                                <a  style="text-decoration: none;width: 95px;height: 30px" href="userPage.jsp"><%=user.getName()%></a>
                            </div>
                            <div style="display: flex;justify-content: center;justify-items: center;text-align: center;align-items: center;">
                                <a  style="text-decoration: none;width: 95px;height: 30px" href="login?action=logout">Đăng Xuất</a>
                            </div>
                        <%
                    } else {
                        %>
                            <div style="display: flex;justify-content: center;justify-items: center;text-align: center;align-items: center;">
                                <a style="text-decoration: none;width: 95px;height: 30px" href="login.jsp">Đăng Nhập</a>
                            </div>
                            <div style="display: flex;justify-content: center;justify-items: center;text-align: center;align-items: center;">
                                <a style="text-decoration: none; width: 95px;height: 30px" href="register.jsp">Đăng Kí</a>
                            </div>
                        <%
                    }
                %>

            </div>
        </div>
        <hr>
        <div class="nav-2">
            <a href="brand.jsp">THƯƠNG HIỆU</a>
            <a href="men.jsp">ĐỒNG HỒ NAM</a>
            <a href="women.jsp">ĐỒNG HỒ NỮ</a>

            <%
                if (user != null && user.getUsername().contains("ADMIN")) {
                    %>
                    <a href="adminInformation.jsp">QUẢN LÍ</a>
                    <%
                } else {
                    %>
                    <a href="addMoney.jsp">NẠP TIỀN</a>
                    <%
                }
            %>
        </div>
    </section>
</body>
</html>