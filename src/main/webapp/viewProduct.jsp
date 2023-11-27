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
            <img id="maxImage" src="anh/mini1.webp"><br>
        </div>
        <div class="buy">
            <form action="addFavourite" method="post">
                <input type="hidden" name="productCode" value="<c:out value='${product.code}'/>">
                <h1>Frederique Constant Highlife FC-391WN4NH6 Watch 41mm</h1>
                <p>MSP: 102704 Chưa có đánh giá</p>
                <p>Brand: </p>
                <p>Collection: HAPPY WOMEN'S DAY 20/10/2023</p>
                <p>Color: red</p>
                <p>Description: </p>
                <p>Type: </p>
                <p>Price: 92,120,900 VNĐ</p>
                <button class="addToCart-button" >THÊM VÀO GIỎ HÀNG</button>
            </form>
        </div>
    </div>
    </body>
    <%@include file="footer.jsp"%>
</html>