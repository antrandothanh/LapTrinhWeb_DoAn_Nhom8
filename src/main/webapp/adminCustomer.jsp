<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" href="styles/body-admin.css">
    <link rel="stylesheet" type="text/css" href="styles/adminCustomer.css"/>
</head>
<body>
    <section>
        <jsp:include page="adminHeader.jsp"/>
    </section>
    <section style="display: flex">
        <section>
            <jsp:include page="adminSideBar.jsp"/>
        </section>
        <section class="content-container" style="height: 800px">
            <div class="content-title">
                Quản lí tài khoản khách hàng
            </div>
            <div class="list-of-customer-container">
                Danh sách các tài khoản của khách
            </div>
            <form action="" method="">
                <div class="edit-customer-container">
                    <div style="display: flex; padding-top: 20px">
                        <div class="label-of-customer">
                            <label>Mã khách hàng:</label>
                            <label>Tên tài khoản:</label>
                            <label>Mật khẩu:</label>
                            <label>Tên khách hàng:</label>
                            <label>Email:</label>
                            <label>Điện thoại:</label>
                            <label>Địa chỉ:</label>
                        </div>
                        <div class="input-of-customer">
                            <input type="text" name="customerID">
                            <input type="text" name="customerUsername">
                            <input type="text" name="customerPassword">
                            <input type="text" name="customerName">
                            <input type="text" name="customerEmail">
                            <input type="text" name="customerPhone">
                            <input type="text" name="customerAddress">
                        </div>
                    </div>
                    <div class="button-container">
                        <input type="submit" name="addCustomer" value="Thêm">
                        <input type="submit" name="editCustomer" value="Sửa">
                        <input type="submit" name="removeCustomer" value="Xoá">
                    </div>
                </div>
            </form>
            </div>
        </section>
    </section>
</body>
</html>
