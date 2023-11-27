<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vacheron Constantin</title>
    <link rel="stylesheet" href="styles/brand-elements.css">
</head>
<body>
    <%@include file="header.jsp"%>
    <section id="brand-elements-page">
        <section id="banner-brand">
            <div class="picture-brand"
                 style="width: 100%;
                    height: 82%;
                    background-image: url(images/brand-elements/vacheron/vacheron-banner.png);
                    background-size: cover;
                    margin: 0 auto;">
            </div>
            <div class="navbar-brand">
                <div class="navbar-content-brand">
                    <a class="home-link" href="index.jsp">Home</a>
                    &nbsp;/&nbsp; <a class="brand-link" href="brand.jsp">Thương hiệu</a>
                    &nbsp;/&nbsp; <a href="vacheron.jsp">Vacheron</a>
                </div>
            </div>
        </section>
        <section id="intro-brand">
            <div class="intro-brand-content">
                <h1 class="text-center">VACHERON CONSTANTIN COLLECTION</h1>
                <div class="detail-cont">
                    The world's oldest watch manufacturer in continuous operation since 1755 and
                    founder of the spirit of technical and precious Haute Horlogerie,
                    Vacheron Constantin has been making horological history for over 260 years.
                    From the beginning, Vacheron Constantin devotes its every effort to perpetuating the spirit of Fine Watchmaking.
                </div>
            </div>
        </section>

        <section id="brand-products">
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="product" items="${sessionScope.products}" varStatus="loop">
                <c:if test="${product.brand.name == 'vacheron'}">
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
                                    <form action="addFavourite" method="post">
                                        <input type="hidden" name="productCode" value="<c:out value='${product.code}'/>">
                                        <input type="submit" value="Add To Favite">
                                    </form>
                                    <form action="addCart" method="get">
                                        <input type="hidden" name="productCode" value="<c:out value='${product.code}'/>">
                                        <input type="submit" value="Add To Cart">
                                    </form>
                                </div>
                            </div>
                            <p><strong>${product.name}</strong></p>
                            <p>${product.brand.name}</p>
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
    <%@include file="footer.jsp"%>
</body>
</html>