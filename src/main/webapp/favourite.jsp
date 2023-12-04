<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="styles/viewFavourite.css">
</head>
<body>
<%@include file="header.jsp"%>

<section style="border-radius:8px; margin-bottom: 50px; margin-top: 80px;padding-bottom: 30px ;background-color: rgb(234,239,239); box-shadow: 0 0 10px 7px rgba(0, 0, 0, 0.1); /* Tạo viền mờ */
">
    <div style="display: flex; flex-direction: row" >
        <p style="margin-left: 10px;font-weight: bolder;font-size: 23px"> YÊU THÍCH</p>
        <p style="margin-left: 135px;font-weight: bolder;font-size: 23px">Tên sản phẩm </p>
        <p style="margin-left: 380px;font-weight: bolder;font-size: 23px">Giá tiền</p>
    </div>
    <c:forEach var="product" items="${favourite.products}">
    <div class="container-favourite" >
        <div class="tick-fproduct">

        </div>
        <div class="image-fproduct">
            <img src="${product.imgURL}">
        </div>
        <div class="name-fproduct">
            <p style="margin-left: 40px">${product.name}</p>
            <p style="margin-left: 40px">MSP: ${product.code}</p>
        </div>
        <div class="price-fproduct">
            <p><fmt:formatNumber value="${product.price}" pattern="#,###"/>₫</p>
        </div>
        <div class="add-fcart">
            <form action="addCart" method="post" style="display: flex; justify-content: center; align-items: center;">
                <button><img src="images/add-to-cart.png"></button>
                <input type="hidden" name="productCode" value="${product.code}">
            </form>
        </div>
        <div class="delete-fproduct">
            <form action="removeFavourite" method="post" style="display: flex; justify-content: center; align-items: center;">
                <input type="hidden" name="productCode" value="${product.code}">
                <button type="submit"><img src="images/bin.png"></button>
            </form>

        </div>
    </div>
    </c:forEach>
</section>
<%@include file="footer.jsp"%>

</body>
</html>