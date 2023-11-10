<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="styles/cartProduct.css">
    <link href="https://fonts.cdnfonts.com/css/azonix" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="assets/favicon.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <%@include file="header.jsp"%>
    <h2>Thông tin giao hàng</h2>
    <div class="container-cart">
        <div class="cart-left">
            <p>Bạn có Voucher ưu đãi? <a href="#">Áp dụng ngay</a></p>
            <input class="input-long" type="text" value=" Tên khách hàng">
            <input class="input-short"  type="text" value=" Địa chỉ email">
            <input class="input-short"  type="text" value=" Số điện thoại">
            <input class="input-short"  type="text" value=" Địa chỉ nhận hàng">
            <select class="input-select" >
                <option value="0"> Vui lòng chọn</option>
                <option value="1"> Hà Nội</option>
                <option value="2"> Vinh</option>
                <option value="3"> Đà Nẵng</option>
                <option value="4"> Tp. Hồ Chí Minh</option>

            </select>
            <textarea class="input-very-long" rows="3" cols="40" > Ghi chú</textarea>
            <div class="check-method-pay">
                <div class="member-method-pay"> <input name="method" type="radio"> Chuyển khoản ngân hàng </div>
                <div class="member-method-pay">
                    <input name="method" type="radio"> Thanh toán khi giao hàng (C.O.D)
                    <div>
                        <p>Giao hàng trên phạm vi toàn quốc.</p>
                        <p>Quý khách nhận hàng, kiểm tra và thanh toán thông qua các đối tác vận chuyển của Luxury Shopping.</p>
                    </div>

                </div>
                <div class="member-method-pay"> <input name="method" type="radio"> Thanh toán trước 10% </div>
                <div class="member-method-pay"> <input name="method" type="radio"> Thanh toán đầy đủ 100% </div>
                <div class="member-method-pay"> <input name="method" type="radio"> Đăng ký trả góp </div>
                <div class="member-method-pay"> <input name="method" type="radio"> Trả góp </div>

            </div>
            <button>ĐẶT HÀNG</button>
            <div><input type="checkbox"> Đồng ý với điều khoản & chính sách đặt hàng</div>
        </div>
        <div class="cart-right">
            <div class="info-cart">
                <div class="info-cart-right">
                    <div class="product-cart">
                        <img class="img-cart" src="anh/mini4.webp">
                        <button class="quantity">1</button>
                        <button class="move"><i class="fa-solid fa-xmark"></i></button>
                    </div>
                    <div class="text-cart">
                        <p>Frederique Constant Highlife FC-391WN4NH6 Watch 41mm </p>
                        <p>MSP: 68728</p>
                        <div>
                            <button>-</button>
                            <input type="text" value="1">
                            <button>+</button>
                            <span>92,120,900</span>
                        </div>
                    </div>
                </div>
                <div class="info-cart-right">
                    <div class="product-cart">
                        <img class="img-cart" src="anh/mini1.webp">
                        <button class="quantity">1</button>
                        <button class="move"><i class="fa-solid fa-xmark"></i></button>
                    </div>
                    <div class="text-cart">
                        <p>Frederique Constant Highlife FC-391WN4NH6 Watch 41mm </p>
                        <p>MSP: 68728</p>
                        <div>
                            <button>-</button>
                            <input type="text" value="1">
                            <button>+</button>
                            <span>92,120,900</span>
                        </div>
                    </div>
                </div>
                <div class="info-pay">
                    <p>Vận chuyển <span> Miễn phí</span></p>
                    <p >Tổng cộng <span class="pay-price"> 32,995,470</span></p>
                </div>
            </div>
        </div>

    </div>
    </body>
    <%@include file="footer.jsp"%>
</html>