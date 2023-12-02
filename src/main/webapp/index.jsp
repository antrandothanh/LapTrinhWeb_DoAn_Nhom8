<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    <title>Home</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <section id="home-section">
        <section id="big-banner">
            <a href="#"><img src="images/home/banner2.png" alt="big-banner"></a>
        </section>
        <section id="slide-brand">
            <h2 class="name-section">ĐỒNG HỒ HIỆU</h2>
                <div class="slider-container">
                    <div class="slider">
                        <c:forEach var="brand" items="${sessionScope.brands}">
                            <div class="brand-slide-items">
                                <a href="${brand.name}.jsp">
                                    <img src="images/home/${brand.name}.png" alt="cartier">
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
        </section>

        <section id="top-brand">
            <h2 class="name-section">TOP THƯƠNG HIỆU</h2>
            <div class="top-brand-box">
                <div class="sub-box">
                    <a href="chorpard.jsp">
                        <img src="images/home/chorpard2.png" alt="box1" style="width:100%;height:100%;">
                    </a>
                    <div class="brand-name" id="brand-chorpard"></div>
                </div>
                <div class="sub-box">
                    <a href="rolex.jsp">
                        <img src="images/home/rolex2.png" alt="box2" style="width:100%;height:100%;">
                    </a>
                    <div class="brand-name" id="brand-rolex"></div>
                </div>
            </div>
        </section>

        <section id="new-arrival">
            <h2 class="name-section">NEW ARRIVAL</h2>
            <div class="scrollable-container">
                <div class="new-arrival-box">
                    <c:forEach var="product" items="${sessionScope.products}" varStatus="loop">
                        <%
                            // Đảo ngược danh sách products để lấy 10 sp cuối trong danh sach
                            java.util.Collections.reverse((java.util.List) session.getAttribute("products"));
                        %>
                        <c:if test="${loop.index < 10}">
                        <div class="product-new-arrival-box">
                            <a href="loadProducts?action=viewProductDetail&amp;productCode=${product.code}">
                                <div class="img-product">
                                    <img src="${product.imgURL}" alt="dongho1">
                                    <div class="icon-product-new-arrival">
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
                                <div class="product-info">
                                    <p><strong>${product.name}</strong></p>
                                    <p>Thương hiệu: ${product.brand.name}</p>
                                    <p>Mã sản phẩm: ${product.code}</p>
                                    <p>Description: ${product.description}</p>
                                    <p class="price">${product.price}₫</p>
                                </div>
                            </a>
                        </div>
                        </c:if>
                    </c:forEach>
                </div>

            </div>

        </section>
        <section  id="gender-for">
            <div class="container-gender-for">
                <div class="box1-container-gender-for">
                    <a href="men.jsp">
                        <div class="picture-box1-container-gender-for">

                        </div>
                    </a>
                    <div class="text-box-container-gender-for">
                        <h4><strong>ĐỒNG HỒ NAM</strong></h4>
                        <p>TỪ NHỮNG THƯƠNG HIỆU NỔI TIẾNG NHẤT GÓP MẶT.</p>
                        <a href="men.jsp"><strong>DISCOVER NOW</strong></a>
                    </div>
                </div>
                <div class="box2-container-gender-for">
                    <a href="women.jsp">
                        <div class="picture-box2-container-gender-for">

                        </div>
                    </a>
                    <div class="text-box-container-gender-for">
                        <h4><strong>ĐỒNG HỒ NỮ</strong></h4>
                        <p>TỪ NHỮNG THƯƠNG HIỆU NỔI TIẾNG NHẤT GÓP MẶT.</p>
                        <a href="women.jsp"><strong>DISCOVER NOW</strong></a>
                    </div>
                </div>
            </div>
        </section>

    </section>

    <%@include file="footer.jsp"%>
</body>
</html>