<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/viewPayment.css">

</head>
<body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div class="card">
    <div class="card-top border-bottom text-center">
        <a href="index.jsp" style="font-size: 16px; font-weight: 700; text-decoration: underline;">Quay về trang chủ</a>
        <span id="logo">Nạp Tiền</span>
    </div>
    <div class="card-body">
        <div class="row upper"></div>
        <div class="row">
            <div class="col-md-7">
                <div class="left border">
                    <div class="row">
                        <span class="header">Nạp tiền</span>
                        <div class="icons">
                            <img src="https://img.icons8.com/color/48/000000/visa.png"/>
                            <img src="https://img.icons8.com/color/48/000000/mastercard-logo.png"/>
                            <img src="https://img.icons8.com/color/48/000000/maestro.png"/>
                        </div>
                    </div>
                    <form>
                        <span>Tên chủ thẻ:</span>
                        <input placeholder="Linda Williams">
                        <span>Số thẻ:</span>
                        <input placeholder="0125 6780 4567 9909">
                        <div class="row">
                            <div class="col-4"><span>Ngày hết hạn:</span>
                                <input placeholder="YY/MM">
                            </div>
                            <div class="col-4"><span>CVV:</span>
                                <input id="cvv">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-5">
                <div class="right border">
                    <form action="addMoney" method="post">
                    <div class="row lower">
                        <div class="col text-left">
                            <label>Nhập số tiền</label> <input name="money" type="text" value="0">
                        </div>
                    </div>
                    <button type="submit" class="btn">Xác nhận</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div>
    </div>
</div>
</body>
</html>