<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Entity.User, DAO.UserDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" href="styles/body-admin.css">
    <link rel="stylesheet" type="text/css" href="styles/adminCustomer.css"/>
</head>
<body>
    <%
        List<User> customers = new ArrayList<>();
        List<User> users = UserDAO.selectUsers();
        for (User user : users) {
            if (user.getUsername().contains("CUSTOMER")) {
                customers.add(user);
            }
        }
        request.setAttribute("customers", customers);
    %>
    <section>
        <jsp:include page="adminHeader.jsp"/>
    </section>
    <section style="display: flex">
        <section>
            <jsp:include page="adminSideBar.jsp"/>
        </section>
        <section class="content-container" style="height: 800px">
            <div class="content-title">
                Khách hàng
            </div>
            <div class="list-of-customer-container">
                <table id="customers-table">
                    <tr>
                        <th>Username</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td><c:out value='${customer.getUsername()}'/></td>
                            <td><c:out value='${customer.getName()}'/></td>
                            <td><c:out value='${customer.getPassword()}'/></td>
                            <td><c:out value='${customer.getAddress()}'/></td>
                            <td><c:out value='${customer.getEmail()}'/></td>
                            <td><c:out value='${customer.getPhone()}'/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <jsp:useBean id="user" scope="session" class="Entity.User"></jsp:useBean>
            <form action="manageCustomer" method="post">
                <div class="edit-customer-container">
                    <div style="display: flex; padding-top: 20px">
                        <div class="label-of-customer">
                            <label>Tên tài khoản:</label>
                            <label>Mật khẩu:</label>
                            <label>Tên khách hàng:</label>
                            <label>Email:</label>
                            <label>Điện thoại:</label>
                            <label>Địa chỉ:</label>
                        </div>
                        <div class="input-of-customer">
                            <input type="text" name="customerUsername" value="<jsp:getProperty name="user" property="username"/>" required>
                            <input type="text" name="customerPassword" value="<jsp:getProperty name="user" property="password"/>" required>
                            <input type="text" name="customerName" value="<jsp:getProperty name="user" property="name"/>" required>
                            <input type="text" name="customerEmail" value="<jsp:getProperty name="user" property="email"/>" required>
                            <input type="text" name="customerPhone" value="<jsp:getProperty name="user" property="phone"/>" required>
                            <input type="text" name="customerAddress" value="<jsp:getProperty name="user" property="address"/>" required>
                        </div>
                    </div>
                    <div class="button-container">
                        <p id="message" style="color: red; font-weight: 700">${message}</p>
                        <button type="submit" name="action" value="addCustomer">Thêm</button>
                        <button type="submit" name="action" value="updateCustomer">Sửa</button>
                        <button type="submit" name="action" value="removeCustomer">Xoá</button>
                    </div>
                </div>
            </form>
            </div>
        </section>
    </section>
</body>
</html>
