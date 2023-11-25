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
        <div class="column-elements" style="width: 30px;"></div>
        <div class="column-elements" style="width: 160px;"></div>
        <div class="column-elements" style="width: 445px; font-weight: 700; margin: 0 auto;">Tên sản phẩm</div>
        <div class="column-elements" style="width: 100px; font-weight: 700;">Số lượng</div>
        <div class="column-elements" style="width: 220px; font-weight: 700">Giá tiền</div>
        <div class="column-elements delete" style="width: 65px;"></div>
    </div>


    <div id="cart-product" style="display: flex;flex-direction: row">
        <!-- check -->
        <div class="check-box">
            <form action="payment" method="post">
                <c:forEach var="lineItem" items="${cart.items}" varStatus="loop">
                    <div class="heii" style="display: flex; flex-direction: row; justify-content: center; align-items: center;">
                        <input type="hidden" name="productCode_${loop.index}" value="${lineItem.item.code}">
                        <input type="hidden" name="quantity_${loop.index}" value="${lineItem.quantity}">
                        <div class="column-elements" style="width: 30px; display: flex; justify-content: center;">
                            <input type="checkbox" name="statusCheckbox_${loop.index}" style="margin: 0;">
                        </div>
                    </div>
                </c:forEach>
                <div id="checkout-buttons">
                    <button type="submit" id="btn-payment">
                        <strong>THANH TOÁN</strong>
                    </button>
                </div>
            </form>
        </div>

        <c:set var="totalPrice" value="0" />
        <div>
        <c:forEach var="lineItem" items="${cart.items}">
            <div class="cart-product-elements border-after">

                <!-- ảnh -->
                <div class="column-elements image">
                    <a href="#"><img src="${lineItem.item.imgURL}" alt=""></a>
                </div>
                <!-- tên -->
                <div class="column-elements name" style="width: 445px;">
                    <p><strong>${lineItem.item.name}</strong></p>
                    <p style="font-size: 15px;">MSP: ${lineItem.item.code}</p>
                </div>
                <!--số lượng-->
                <div class="column-elements quantity" style="width: 100px;">
                    <form action="updateQuantityCart" method="post">
                        <button type="submit">a</button>
                        <button class="quantity-btn minus"></button>
                        <input type="hidden" name="productCode" value="${lineItem.item.code}">
                        <input type="number" class="quantity" name="quantity" value="<c:out value='${lineItem.quantity}'/>" min="1">
                        <button class="quantity-btn plus"></button>
                    </form>
                </div>
                <!--giá-->
                <div class="column-elements price price-value" style="width: 220px;">
                    <fmt:formatNumber value="${lineItem.item.price}" pattern="#,###"/>₫
                </div>
                <!--xoá-->
                <div class="column-elements delete" style="width: 65px;">
                    <form action="removeCart" method="post">
                        <input type="hidden" name="productCode" value="${lineItem.item.code}">
                        <input type="hidden" name="quantity" value="0">
                        <button>DELETE</button>
                    </form>
                </div>
            </div>
            <c:set var="productPrice" value="${lineItem.item.price * lineItem.quantity}"/>
            <c:set var="totalPrice" value="${totalPrice + productPrice}"/>
        </c:forEach>
        </div>
    </div>
    <div id="total-price">
        <div class="column-elements" style="width: 160px;"></div>
        <div class="column-elements" style="width: 740px; font-weight: 700"></div>
        <div class="column-elements" style="width: 100px; font-weight: 700"></div>
        <div class="column-elements" style="width: 220px; font-weight: 700">
            <fmt:formatNumber value="${totalPrice}" pattern="#,###"/>đ</div>
        <div class="column-elements" style="width: 65px;"></div>
    </div>
</section>
<section id="check-out">
    <div id="continue-shopping">
        <a href="#"><p><strong>Tiếp tục mua hàng</strong></p></a>
    </div>
</section>
<%@include file="footer.jsp"%>
</body>
</html>