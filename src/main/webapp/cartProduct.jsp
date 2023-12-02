<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="styles/cartProduct.css">
    <link href="https://fonts.cdnfonts.com/css/azonix" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="assets/favicon.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <%@include file="header.jsp"%>
    <h2 class="info-deliver">Thông tin giao hàng</h2>
    <form action="invoice" method="post">
        <div class="container-cart">
            <div class="cart-left">
                <input class="input-long" type="text" value="${sessionScope.user.name}" readonly>
                <input class="input-short"  type="text" value="${sessionScope.user.email}" readonly>
                <input class="input-short"  type="text" value="${sessionScope.user.phone}" readonly>
                <input class="input-short"  type="text" name="address" placeholder="Địa chỉ nhận hàng" required>
                <select class="input-select" name="province" required>
                    <option value=""> Vui lòng chọn</option>
                    <option value="Hà Nội"> Hà Nội</option>
                    <option value="Vinh"> Vinh</option>
                    <option value="Đà Nẵng"> Đà Nẵng</option>
                    <option value="Tp. Hồ Chí Minh"> Tp. Hồ Chí Minh</option>
                </select>
                <textarea class="input-very-long" rows="3" cols="40" name="note" placeholder="Ghi chú"></textarea>

                <button type="submit">ĐẶT HÀNG</button>
            </div>
            <div class="cart-right">
                <c:set var="totalPrice" value="0" />
                <c:forEach var="lineItem" items="${requestScope.listBuy}">
                    <div class="info-cart">
                        <div class="info-cart-right">
                            <div class="product-cart">
                                <img class="img-cart" src="${lineItem.item.imgURL}" alt="anhDongHo">
                                <button class="quantity">${lineItem.quantity}</button>
                                <button class="move"><i class="fa-solid fa-xmark"></i></button>
                            </div>
                            <div class="text-cart">
                                <p>${lineItem.item.name}</p>
                                <p>MSP: ${lineItem.item.code}</p>
                                <div>
                                    <span><fmt:formatNumber value="${lineItem.item.price}" pattern="#,###"/>₫</span>
                                </div>
                            </div>
                        </div>

                    </div>
                    <c:set var="productPrice" value="${lineItem.item.price * lineItem.quantity}"/>
                    <c:set var="totalPrice" value="${totalPrice + productPrice}"/>
                </c:forEach>
                <div class="info-pay">
                    <p>Vận chuyển <span> Miễn phí</span></p>
                    <p>Tổng cộng <span class="pay-price"><fmt:formatNumber value="${totalPrice}" pattern="#,###"/>đ</span></p>
                </div>
            </div>

        </div>
    </form>
    </body>
    <%@include file="footer.jsp"%>
</html>