<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="styles/cart.css">
</head>
<body>
<%@include file="header.jsp"%>
<section id="cart-main-container">
    <div id="cart-header" class="border-after">
        <h1>GIỎ HÀNG</h1>
    </div>
    <div id="title-column" class="border-after">
        <div class="column-elements" style="width: 30px;"><input type="checkbox"></div>
        <div class="column-elements" style="width: 160px;"></div>
        <div class="column-elements" style="width: 740px; font-weight: 700; margin: 0 auto;">Tên sản phẩm</div>
        <div class="column-elements" style="width: 100px; font-weight: 700;">Số lượng</div>
        <div class="column-elements" style="width: 220px; font-weight: 700">Giá tiền</div>
        <div class="column-elements delete" style="width: 65px;">
            <form action="cart" method="post">
                <button onclick="deleteProduct(this)">DELETE</button>
            </form>
        </div>
    </div>

    <c:set var="totalPrice" value="0" />
    <c:forEach var="lineItem" items="${sessionScope.cart.items}">
    <div id="cart-product">
        <div class="cart-product-elements border-after">
            <!-- check -->
            <div class="column-elements" style="width: 30px;"><input type="checkbox"></div>
            <!-- ảnh -->
            <div class="column-elements image">
                <a href="#"><img src="${lineItem.item.imgURL}" alt=""></a>
            </div>
            <!-- tên -->
            <div class="column-elements name" style="width: 740px;">
                <p><strong>${lineItem.item.name}</strong></p>
                <p style="font-size: 15px;">MSP: ${lineItem.item.code}</p>
            </div>
            <!--số lượng-->
            <div class="column-elements quantity" style="width: 100px;">
                <button class="quantity-btn minus"></button>
                <input type="number" class="quantity" value="${lineItem.quantity}" min="1">
                <button class="quantity-btn plus"></button>
            </div>
            <!--giá-->
            <div class="column-elements price price-value" style="width: 220px;">
                <fmt:formatNumber value="${lineItem.item.price}" pattern="#,###"/>₫
            </div>
            <!--xoá-->
            <div class="column-elements delete" style="width: 65px;">
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="PRO003">
                    <input type="hidden" name="quantity" value="0">
                    <button onclick="deleteProduct(this)">DELETE</button>
                </form>
            </div>
        </div>

        <c:set var="productPrice" value="${lineItem.item.price * lineItem.quantity}"/>
        <c:set var="totalPrice" value="${totalPrice + productPrice}"/>
        </c:forEach>


        <div id="total-price">
            <div class="column-elements" style="width: 160px;"></div>
            <div class="column-elements" style="width: 740px; font-weight: 700"></div>
            <div class="column-elements" style="width: 100px; font-weight: 700"></div>
            <div class="column-elements" style="width: 220px; font-weight: 700">
                <fmt:formatNumber value="${totalPrice}" pattern="#,###"/>đ</div>
            <div class="column-elements" style="width: 65px;"></div>
        </div>
    </div>
</section>
<section id="check-out">
    <div id="continue-shopping">
        <a href="#"><p><strong>Tiếp tục mua hàng</strong></p></a>
    </div>
    <div id="checkout-buttons">
        <button id="btn-update"><strong>CẬP NHẬT</strong></button>
        <button id="btn-payment" onclick="window.location.href = 'cartProduct.jsp'"><strong>THANH TOÁN</strong></button>
    </div>
</section>
<script src="styles/cart.js"></script>
<%@include file="footer.jsp"%>
</body>
</html>