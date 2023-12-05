<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ViewProduct</title>
    <link rel="stylesheet" href="styles/viewProduct.css">
</head>
    <%@include file="header.jsp"%>
    <body class="body">
    <div class="product">
        <div class="img-max">
            <img id="maxImage" src="${requestScope.product.imgURL}"><br>
        </div>
        <div class="buy">
            <form action="addCart" method="post">
                <input type="hidden" name="productCode" value="${requestScope.product.code}">
                <h1>${requestScope.product.name}</h1>
                <p>MSP: ${requestScope.product.code}</p>
                <p>Brand: ${requestScope.brand.name} (code: ${requestScope.brand.code})</p>
                <p class="collection">Collection: ${requestScope.product.collection}</p>
                <p>Color: ${requestScope.product.color}</p>
                <p>Description: ${requestScope.product.description}</p>
                <p>Type: ${requestScope.product.type}</p>
                <p class="price">Price: <fmt:formatNumber value="${requestScope.product.price}" pattern="#,###"/>₫</p>
                <button class="addToCart-button" >THÊM VÀO GIỎ HÀNG</button>
            </form>
        </div>
    </div>
    </body>
    <%@include file="footer.jsp"%>
</html>