<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" type="text/css" href="styles/body.css"/>
    <link rel="stylesheet" type="text/css" href="styles/adminInformation.css"/>
</head>
<body>
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
                    <label>Mã:</label>
                    <br>
                    <label>Họ tên:</label>
                    <br>
                    <label>Email:</label>
                    <br>
                    <label>Số điện thoại:</label>
                    <br>
                    <label>Địa chỉ:</label>
                </div>
                <div class="values-of-information">
                    <span>ADM001</span>
                    <br>
                    <span>Trần Văn A</span>
                    <br>
                    <span>tranvana@gmail.com</span>
                    <br>
                    <span>0992871630</span>
                    <br>
                    <span>Thành phố Hồ Chí Minh</span>
                </div>
            </div>
        </section>
    </section>
</body>
</html>
