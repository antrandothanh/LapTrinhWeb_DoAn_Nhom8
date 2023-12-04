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

<section>
    <c:forEach var="product" items="${favourite.products}">
    <div class="container-favourite">
        <div class="tick-fproduct">

        </div>
        <div class="image-fproduct">
            <img src="${product.imgURL}">
        </div>
        <div class="name-fproduct">
            <p>${product.description}</p>
            <p>MSP: ${product.code}</p>
        </div>
        <div class="price-fproduct">
            <p>${product.price}</p>
        </div>
        <div class="add-fcart">
            <form action="addCart" method="post">
                <button><img src="images/add-to-cart.png"></button>
                <input type="hidden" name="productCode" value="${product.code}">
            </form>
        </div>
        <div class="delete-fproduct">
            <form action="removeFavourite" method="post">
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