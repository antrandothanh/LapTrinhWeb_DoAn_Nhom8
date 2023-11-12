<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <div class="brand-slide-items">
                        <a href="cartier.jsp">
                            <img src="images/home/cartier.png" alt="cartier">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="chorpard.jsp">
                            <img src="images/home/chorpard.png" alt="omega">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="rolex.jsp">
                            <img src="images/home/rolex.png" alt="rolex">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="vacheron.jsp">
                            <img src="images/home/vacheron.png" alt="vacheron">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="christian.jsp">
                            <img src="images/home/christian.png" alt="christian">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="patek.jsp">
                            <img src="images/home/patek.png" alt="patek">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="hublot.jsp">
                            <img src="images/home/hublot.png" alt="patek">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="omega.jsp">
                            <img src="images/home/omega.png" alt="cartier">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="cartier.jsp">
                            <img src="images/home/cartier.png" alt="omega">
                        </a>
                    </div>
                    <div class="brand-slide-items">
                        <a href="chorpard.jsp">
                            <img src="images/home/chorpard.png" alt="omega">
                        </a>
                    </div>
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
                    <div class="brand-name" id="brand-chorpard"></div> <!-- Thêm id tương ứng với hình ảnh thương hiệu -->
                </div>
                <div class="sub-box">
                    <a href="rolex.jsp">
                        <img src="images/home/rolex2.png" alt="box2" style="width:100%;height:100%;">
                    </a>
                    <div class="brand-name" id="brand-rolex"></div> <!-- Thêm id tương ứng với hình ảnh thương hiệu -->
                </div>
            </div>
        </section>
        <section id="new-arrival">
            <h2 class="name-section">NEW ARRIVAL</h2>
            <div class="scrollable-container">
                <div class="new-arrival-box">
                    <div class="product-new-arrival-box">
                        <a href="viewProduct.jsp">
                            <div class="img-product">
                                <img src="images/brand-elements/vacheron/dh4.png" alt="dongho1">
                                <div class="icon-product-new-arrival">
                                    <button class="icon heart-icon" alt="icon"></button>
                                    <button class="icon cart-icon" alt="giohang"></button>
                                </div>

                            </div>
                            <p><strong>Rolex Submariner 124060</strong></p>
                            <p>Thương hiệu: Vacheron</p>
                            <p>Mã sản phẩm: </p>
                            <p> Xuất xứ: Thụy Sĩ</p>
                            <p class="price">469.000.000₫</p>
                        </a>
                    </div>
                    <div class="product-new-arrival-box">
                        <a href="#">
                            <div class="img-product">
                                <img src="images/brand-elements/omega/dh1.png" alt="dongho2">
                                <div class="icon-product-new-arrival">
                                    <button class="icon heart-icon" alt="icon"></button>
                                    <button class="icon cart-icon" alt="giohang"></button>
                                </div>

                            </div>
                            <p><strong>Rolex Lady-Datejust 28 Chocolate 279171 (Fluted/Jubilee)</strong></p>
                            <p>Thương hiệu: Omega</p>
                            <p>Mã sản phẩm: </p>
                            <p> Xuất xứ: Thụy Sĩ</p>
                            <p class="price">469.000.000₫</p>
                        </a>
                    </div>
                    <div class="product-new-arrival-box">
                        <a href="#">
                            <div class="img-product">
                                <img src="images/brand-elements/cartier/dh1.png" alt="dongho3">
                                <div class="icon-product-new-arrival">
                                    <button class="icon heart-icon" alt="icon"></button>
                                    <button class="icon cart-icon" alt="giohang"></button>
                                </div>

                            </div>
                            <p><strong>Rolex Oyster Perpetual 41 Green 124300</strong></p>
                            <p>Thương hiệu: Cartier</p>
                            <p>Mã sản phẩm: </p>
                            <p> Xuất xứ: Thụy Sĩ</p>
                            <p class="price">403.000.000₫</p>
                        </a>
                    </div>
                    <div class="product-new-arrival-box">
                        <a href="#">
                            <div class="img-product">
                                <img src="images/brand-elements/hublot/dh1.png" alt="dongho4">
                                <div class="icon-product-new-arrival">
                                    <button class="icon heart-icon" alt="icon"></button>
                                    <button class="icon cart-icon" alt="giohang"></button>
                                </div>

                            </div>
                            <p><strong>Rolex Datejust 36 Slate Roman 126234 (Fluted/Jubilee)</strong></p>
                            <p>Thương hiệu: Hublot</p>
                            <p>Mã sản phẩm: </p>
                            <p> Xuất xứ: Thụy Sĩ</p>
                            <p class="price">431.500.000₫</p>
                        </a>
                    </div>
                    <div class="product-new-arrival-box">
                        <a href="#">
                            <div class="img-product">
                                <img src="images/brand-elements/christian/dh1.png" alt="dongho5">
                                <div class="icon-product-new-arrival">
                                    <button class="icon heart-icon" alt="icon"></button>
                                    <button class="icon cart-icon" alt="giohang"></button>
                                </div>

                            </div>
                            <p><strong>Rolex Oyster Perpetual 36 Bright Blue 126000</strong></p>
                            <p>Thương hiệu: Christian Dior</p>
                            <p>Mã sản phẩm: </p>
                            <p> Xuất xứ: Thụy Sĩ</p>
                            <p class="price">269.000.000₫</p>
                        </a>
                    </div>
                    <div class="product-new-arrival-box">
                        <a href="#">
                            <div class="img-product">
                                <img src="images/brand-elements/patek/dh1.png" alt="dongho6">
                                <div class="icon-product-new-arrival">
                                    <button class="icon heart-icon" alt="icon"></button>
                                    <button class="icon cart-icon" alt="giohang"></button>
                                </div>

                            </div>
                            <p><strong>Rolex Datejust 36 Slate Roman 126234 (Fluted/Jubilee)</strong></p>
                            <p>Thương hiệu: Patek</p>
                            <p>Mã sản phẩm: </p>
                            <p> Xuất xứ: Thụy Sĩ</p>
                            <p class="price">465.500.000₫</p>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <section  id="gender-for">
            <div class="container-gender-for">
                <div class="box1-container-gender-for">
                    <a href="#">
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
                    <a href="#">
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

    <!-- xử lí khi click vào icon giỏ hàng hoặc yêu thích -->
    <script>
        var heartIcons = document.querySelectorAll('.heart-icon');
        for (var i = 0; i < heartIcons.length; i++)
        {
            heartIcons[i].addEventListener('click', function(event) {
                event.preventDefault();
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