<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
    <link rel="stylesheet" href="styles/brand-elements.css">
    <link rel="stylesheet" href="styles/searchmenu.css">

</head>
<body>
    <%@include file="header.jsp"%>
    <div style="margin-top: 30px;margin-bottom: 30px">
        <form method="post" action="loadProducts" style="display: flex;justify-content: center;text-align: center;justify-items: center;">
                <div class="dropdown">
                    <button class="dropbtn">Tùy Chọn</button>
                    <div class="dropdown-content">
                        <button style="border-color:white;background-color: #3e8e41;width: 200px;color: white;" name="action" value="minToMax" type="submit">Sắp Xếp Tăng Dần</button>
                        <button  style="border-color:white;background-color: #3e8e41;width: 200px;color: white;" name="action" value="maxToMin" type="submit">Sắp Xếp Giảm Dần</button>
                        <button  style="border-color:white;background-color: #3e8e41;width: 200px;color: white;"  name="action" value="more500" type="submit">Trên 500 Triệu</button>
                        <button  style="border-color:white;background-color: #3e8e41;width: 200px;color: white;"  name="action" value="less500" type="submit">Dưới 500 Triệu</button>
                    </div>
                </div>
            <input type="text" name="searchInput">
            <input type="submit" value="Search">
            <input type="hidden" name="action" value="search">
        </form>
    </div>
    <section id="brand-elements-page">
        <section id="brand-products">
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="product" items="${requestScope.foundProduct}" varStatus="loop">
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
                                    <a href="#"><input type="submit" value="" class="favorite-btn"></a>
                                </form>
                                <form action="addCart" method="get">
                                    <input type="hidden" name="productCode" value="<c:out value='${product.code}'/>">
                                    <a href="#"><input type="submit" value="" class="cart-btn"></a>
                                </form>
                            </div>
                        </div>
                        <p><strong>${product.name}</strong></p>
                        <p>${product.brand.name}</p>
                        <p>Mã sản phẩm: ${product.code}</p>
                        <p>Descripton: ${product.description}</p>
                        <p>Type: ${product.type}</p>
                        <p class="price"><fmt:formatNumber value="${product.price}" pattern="#,###"/>₫</p>
                    </a>
                </div>

                <!--dùng thư viện JSTL Functions
                fn:length(sessionScope.products) sẽ trả về số lượng sản phẩm có type == 'men'
                hiện tại sessionScope.products là ds sp được lưu trong session nhưng
                được lọc qua điều kiện product.type == 'men'-->
                <c:if test="${count % 4 == 0 or count == fn:length(sessionScope.products)}">
                    </div>
                </c:if>
            </c:forEach>
        </section>
    </section>
    <%@include file="footer.jsp"%>
</body>
</html>
