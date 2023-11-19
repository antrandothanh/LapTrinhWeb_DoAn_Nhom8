<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="styles/cart.css">
</head>
<body>
    <%@include file="header.jsp"%>
    <section id="cart-main-container">
        <div id="cart-header" class="border-after">
            <h1>GIỎ HÀNG ${sessionScope.cart.items[0].quantity}</h1>
        </div>
        <div id="title-column" class="border-after">
            <div class="column-elements" style="width: 30px;"><input type="checkbox"></div>
            <div class="column-elements" style="width: 160px;"></div>
            <div class="column-elements" style="width: 740px; font-weight: 700; margin: 0 auto;">Tên sản phẩm</div>
            <div class="column-elements" style="width: 100px; font-weight: 700;">Số lượng</div>
            <div class="column-elements" style="width: 220px; font-weight: 700">Giá tiền</div>
            <div class="column-elements" style="width: 65px;"></div>
        </div>
        <div id="cart-product">
            <div class="cart-product-elements border-after">
                <!-- check -->
                <div class="column-elements" style="width: 30px;"><input type="checkbox"></div>
                <!-- ảnh -->
                <div class="column-elements image">
                    <a href="#"><img src="images/brand-elements/chopard/dh1.png" alt=""></a>
                </div>
                <!-- tên -->
                <div class="column-elements name" style="width: 740px;">
                    <p><strong>Omega De Ville 425.35.34.20.57.001 Ladymatic Watch 34mm</strong></p>
                    <p style="font-size: 15px;">MSP: 68728</p>
                </div>
                <!--số lượng-->
                <div class="column-elements quantity" style="width: 100px;">
                    <button class="quantity-btn minus"></button>
                    <input type="number" class="quantity" value="1" min="1">
                    <button class="quantity-btn plus"></button>
                </div>
                <!--giá-->
                <div class="column-elements price price-value" style="width: 220px;">4,380,000₫</div>
                <!--xoá-->
                <div class="column-elements delete" style="width: 65px;">
                    <form action="cart" method="post">
                        <input type="hidden" name="productCode" value="PRO003">
                        <input type="hidden" name="quantity" value="0">
                        <button onclick="deleteProduct(this)">DELETE</button>
                    </form>
                </div>
            </div>
            <div class="cart-product-elements border-after">
                <div class="column-elements" style="width: 30px;"><input type="checkbox"></div>
                <div class="column-elements image">
                    <a href="#"><img src="images/brand-elements/hublot/dh1.png" alt=""></a>
                </div>
                <div class="column-elements name" style="width: 740px;">
                    <p><strong>Dior Grand Soir Year Of The Rabbit Limited 36mm</strong></p>
                    <p style="font-size: 15px;">MSP: 68728</p>
                </div>
                <!--số lượng-->
                <div class="column-elements quantity" style="width: 100px;">
                    <button class="quantity-btn minus"></button>
                    <input type="number" class="quantity" value="1" min="1">
                    <button class="quantity-btn plus"></button>
                </div>
                <!--giá-->
                <div class="column-elements price price-value" style="width: 220px;">4,380,000₫</div>
                <div class="column-elements delete" style="width: 65px;"><button onclick="deleteProduct(this)">DELETE</button></div>
            </div>
            <div class="cart-product-elements border-after">
                <div class="column-elements" style="width: 30px;"><input type="checkbox"></div>
                <div class="column-elements image">
                    <a href="#"><img src="images/brand-elements/patek/dh1.png" alt=""></a>
                </div>
                <div class="column-elements name" style="width: 740px;">
                    <p><strong>Frederique Constant Highlife FC-391WN4NH6 Watch 41mm</strong></p>
                    <p style="font-size: 15px;">MSP: 68728</p>
                </div>
                <!--số lượng-->
                <div class="column-elements quantity" style="width: 100px;">
                    <button class="quantity-btn minus"></button>
                    <input type="number" class="quantity" value="1" min="1">
                    <button class="quantity-btn plus"></button>
                </div>
                <!--giá-->
                <div class="column-elements price price-value" style="width: 220px;">4,380,000₫</div>
                <div class="column-elements delete" style="width: 65px;"><button onclick="deleteProduct(this)">DELETE</button></div>
            </div>
            <div id="total-price">
                <div class="column-elements" style="width: 160px;"></div>
                <div class="column-elements" style="width: 740px; font-weight: 700"></div>
                <div class="column-elements" style="width: 100px; font-weight: 700"></div>
                <div class="column-elements" style="width: 220px; font-weight: 700">Tổng cộng</div>
                <div class="column-elements" style="width: 65px;"></div>
            </div>
        </div>
    </section>
    <section id="check-out">
        <div id="continue-shopping">
            <a href="#"><p><strong>Tiếp tục mua hàng</strong></p></a>
        </div>
        <div id="checkout-buttons">
            <button id="btn-update"><strong>CẬP NHẬT</strong></button>
            <button id="btn-payment" onclick="window.location.href = 'cartProduct.jsp'"><strong>THANH TOÁN</strong></button>
        </div>
    </section>
    <script src="styles/cart.js"></script>
    <%@include file="footer.jsp"%>
</body>
</html>