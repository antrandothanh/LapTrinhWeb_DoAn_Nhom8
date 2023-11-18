<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rolex</title>
    <link rel="stylesheet" href="styles/brand-elements.css">
</head>
<body>
    <%@include file="header.jsp"%>
    <section id="brand-elements-page">
        <section id="banner-brand">
            <div class="picture-brand"
                 style="width: 100%;
                    height: 82%;
                    background-image: url(images/brand-elements/rolex/rolex-banner.png);
                    background-size: cover;
                    margin: 0 auto;">
            </div>
            <div class="navbar-brand">
                <div class="navbar-content-brand">
                    <a class="home-link" href="index.jsp">Home</a>
                    &nbsp;/&nbsp; <a class="brand-link" href="brand.jsp">Thương hiệu</a>
                    &nbsp;/&nbsp; <a href="rolex.jsp">Rolex</a>
                </div>
            </div>
        </section>
        <section id="intro-brand">
            <div class="intro-brand-content">
                <h1 class="text-center">ROLEX COLLECTION</h1>
                <div class="detail-cont">
                    Hans Wilsdorf founded the company we now know as Rolex in 1905. Born in Kulmbach, Germany in 1881, the company,
                    Wilsdorf & Davies, was based in London.
                    By 1908 it had become one of the leading watch companies in the UK. It was in this year that he coined the name Rolex.
                </div>
            </div>
        </section>

        <section id="brand-products">
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="product" items="${sessionScope.products}" varStatus="loop">
                <c:if test="${product.brandCode == 'ROLEX'}">
                    <c:set var="count" value="${count + 1}" scope="page" />
                    <!--1 hàng 4 cái-->
                    <c:if test="${count % 4 == 1}">
                        <div class="box-brand-products">
                    </c:if>

                    <!-- Hiển thị sản phẩm -->
                    <div class="box-brand-product-element">     <!-- 1 sản phẩm trong hàng 1 -->
                        <a href="viewProduct.jsp?productCode=${product.code}">
                            <div class="img-product">
                                <img src="${product.imgURL}" alt="dongho${product.code}">
                                <div class="icon-brand-products">
                                    <button class="icon heart-icon" alt="tim"></button>
                                    <button class="icon cart-icon" alt="cart"></button>
                                </div>
                            </div>
                            <p><strong>${product.name}</strong></p>
                            <p>${product.brandCode}</p>
                            <p>Mã sản phẩm: ${product.code}</p>
                            <p>Descripton: ${product.description}</p>
                            <p>Type: ${product.type}</p>
                            <p class="price">${product.price}₫</p>
                        </a>
                    </div>

                    <!--dùng thư viện JSTL Functions
                    fn:length(sessionScope.products) sẽ trả về số lượng sản phẩm có type == 'men'
                    hiện tại sessionScope.products là ds sp được lưu trong session nhưng
                    được lọc qua điều kiện product.type == 'men'-->
                    <c:if test="${count % 4 == 0 or count == fn:length(sessionScope.products)}">
                        </div>
                    </c:if>

                </c:if>
            </c:forEach>
        </section>
    </section>

    <!-- xử lí khi click vào icon giỏ hàng hoặc yêu thích -->
    <script>
        var heartIcons = document.querySelectorAll('.heart-icon');  //lưu tất cả cái có class heart-icon thành mảng
        for (var i = 0; i < heartIcons.length; i++)
        {
            heartIcons[i].addEventListener('click', function(event) {   //sự kiện click
                event.preventDefault(); //ngăn sự kiện click của thẻ a cha nó
                if (this.classList.contains('active')) {
                    this.classList.remove('active');
                } else {
                    this.classList.add('active');
                }
            });
        }
        var cartIcons = document.querySelectorAll('.cart-icon');
        for (var j = 0; j < cartIcons.length; j++)
        {
            cartIcons[j].addEventListener('click', function(event) {
                event.preventDefault();
                if (this.classList.contains('active')) {
                    this.classList.remove('active');
                } else {
                    this.classList.add('active');
                }
            });
        }

    </script>
    <%@include file="footer.jsp"%>
</body>
</html>