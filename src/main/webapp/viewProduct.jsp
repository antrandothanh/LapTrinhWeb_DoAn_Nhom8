<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ViewProduct</title>
    <link rel="stylesheet" href="styles/viewProduct.css">
    <link href="https://fonts.cdnfonts.com/css/azonix" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="assets/favicon.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

    <%@include file="header.jsp"%>
    <body class="body">
    <script src="styles/viewProduct.js"></script>
    <div class="logo-brand">
        <div  class="img-logo">
            <img src="anh/logo.webp">
        </div>
        <div class="type">
            <a href="#">Đồng Hồ Nam</a>
            <a href="#">Đồng Hồ Nữ</a>
            <a href="#">Sản Phẩm Bán Chạy</a>
            <a href="#">Sản Phẩm Mới</a>
            <a href="#">Bài Viết</a>
        </div>
    </div>
    <div class="product">
        <div class="img-mini">
            <img src="anh/mini1.webp" onclick="showImage('mini1.webp')">
            <img src="anh/mini2.webp" onclick="showImage('mini2.webp')">
            <img src="anh/mini3.webp" onclick="showImage('mini3.webp')">
        </div>
        <div class="img-max">
            <button id="favourite" class="favourite"><i onclick="toFavourite()" id="fa" class="fa-regular fa-heart"></i></button>
            <img id="maxImage" src="anh/mini1.webp"><br>
            <button id="open-dialog" onclick="showThisDialog()" > <i class="fa-regular fa-comment"></i> Tư vấn thêm</button>
        </div>
        <div class="buy">
            <h1>Frederique Constant Highlife FC-391WN4NH6 Watch 41mm</h1>
            <p>MSP: 102704 Chưa có đánh giá</p>
            <p>HAPPY WOMEN'S DAY 20/10/2023</p>
            <p>92,120,900 VNĐ</p>
            <button class="button-order" id="to-page" onclick="toPage()">ĐẶT HÀNG</button>
            <div class="two-button">
                <button class="button-pay">THANH TOÁN ONLINE</button>
                <button class="button-installment">TRẢ GÓP</button>
            </div>
            <div class="support">
                <h3>Quý khách cần hỗ trợ?</h3>
                <p>› Sản phẩm nhập khẩu chính hãng.</p>
                <p>› Vận chuyển miễn phí toàn quốc.</p>
                <p>› Thanh toán sau khi nhận hàng.</p>
                <p>› Bảo hành 6 Năm tại Công ty.</p>
                <p>› Bảo hành chính hãng toàn cầu.</p>
                <p>› Gọi <span>1800 0091</span> hoặc <span>028 3833 9999</span> để đặt hàng.</p>

            </div>
            <div class="button-share">
                <button class="share"><i class="fa-regular fa-share-from-square"></i> Chia sẻ ngay</button>
                <div class="icon-contact">
                    <a href="#"  target="_blank" class="fa fa-facebook"></a>
                    <a href="#" target="_blank" class="fa fa-twitter"></a>
                    <a href="#" target="_blank" class="fa fa-pinterest"></a>
                    <a href="#" target="_blank" class="fa fa-linkedin"></a>
                </div>
            </div>

        </div>
    </div>
    <div class="nav-menu">
        <ul>
            <li><a href="#introduce" >GIỚI THIỆU</a></li>
            <li><a href="#parameter">THÔNG SỐ</a></li>
            <li><a href="#evaluate">ĐÁNH GIÁ</a></li>
            <li><a href="#sameProduct">SẢN PHẨM TƯƠNG TỰ</a></li>
            <li><a href="#watched">ĐÃ XEM</a></li>
        </ul>
    </div>
    <section id="introduce">
        <div class="text-introduce"  >
            <h1 class="topic">GIỚI THIỆU</h1>
            <p>Emblematic complication of watchmaking, the Highlife Automatic Chronograph is equipped with the FC-391 movement, offering a 60-hour power reserve.

                Highlights

                Functions

                Hours, Minutes, Seconds, Date at 4 o'clock, Mechanical Chronograph

                Type of movement: Automatic

                Movement

                REFERENCE: FC-391 (Base LJPL110)

                Type of movement: Automatic

                Power reserve (hours): 60h
                <span id="dots">...</span>
            <div id="more" class="text-introduce-hidden">
                Vibrations per hour: 28'800 alt/h

                Jewels:26

                Case

                Material: Stainless steel

                Colour: Stainless steel

                Diameter or dimensions (mm): 41

                Thickness (mm): 14.22

                Lug width (mm): 25.50

                Water-resistance (ATM): 10

                Dial

                Finishing: Matt with globe pattern embossed in the center

                Indexes: Applied indexes

                Strap / Bracelet

                Material: Calf leather with crocodile pattern

                Colour: Blue

                Dimensions (mm): 75×115

                Buckle: Pin Buckle

                Buckle width: 18

                Strap width (=lug width): 25.5

                Limited edition of (number of pieces): 1888





            </div>

            </p>
            <button onclick="myFunction()" id="myBtn" class="hidden-button" >XEM THÊM</button>
        </div>
    </section>
    <section id="parameter" class="container-parameter">
        <h1 class="topic">THÔNG SỐ</h1>
        <div class="parameter">
            <div class="left">
                <div class="member-parameter"><span class="parameter-head">Thương hiệu</span>  <spanp>: Frederique Constant</spanp></div>
                <div class="member-parameter"><span class="parameter-head">Bộ sưu tập</span>  <span>: HIGHLIFE</span></div>
                <div class="member-parameter"><span class="parameter-head">SKU</span> <span>: FC-391WN4NH6</span></div>
                <div class="member-parameter"> <span class="parameter-head">Mã sản phẩm</span> <span>: 102704</span></div>
                <div class="member-parameter"><span class="parameter-head">Giới tính</span>  <span>: Nam</span></div>
                <div class="member-parameter"><span class="parameter-head">Loại máy </span> <span>: Automatic</span></div>
            </div>

            <div class="right">
                <div class="member-parameter"><span class="parameter-head">Đường kính</span>  <span>: 41mm</span></div>
                <div class="member-parameter"><span class="parameter-head">Màu sắc </span> <span>: Blue</span></div>
                <div class="member-parameter"><span class="parameter-head">Style</span>  <span>: - Chưa phân loại -</span></div>
                <div class="member-parameter"> <span class="parameter-head">Chất lượng dây</span><span>: Dây Da</span></div>
                <div class="member-parameter"><span class="parameter-head">Tính nắng </span> <span>: Chronograph</span></div>
                <div class="member-parameter"><span class="parameter-head">Độ chịu nước </span> <span>: 10 ATM</span></div>
            </div>


        </div>
    </section>
    <section id="evaluate" class="evaluate-container">
        <h1 class="topic">ĐÁNH GIÁ</h1>
        <div class="evaluate-member">
            <div class="evaluate-input">
                <p class="point"><span>5</span>/5</p>
                <div>
                    <i class="fa-regular fa-star"></i>
                    <i class="fa-regular fa-star"></i>
                    <i class="fa-regular fa-star"></i>
                    <i class="fa-regular fa-star"></i>
                    <i class="fa-regular fa-star"></i>
                </div>
                <p>Chưa có đánh giá nào !</p>
                <button class="write-evaluate">VIẾT ĐÁNH GIÁ</button>
            </div>
            <div class="evaluate-output"></div>
        </div>
    </section>
    <dialog id="dialog-add-info">
        <div class="add-info" id="add-info">
            <p class="name-form">TƯ VẤN THÊM SẢN PHẨM <button id="close-dialog" onclick=" hideThisDialog()"><i class="fa-solid fa-xmark"></i></button></p>
            <div class="info-member">
                <div class="product-info">
                    <img src="anh/mini1.webp">
                    <p class="product-name">Frederique Constant Highlife FC-391WN4NH6 Watch 41mm</p>
                    <p><span class="product-code">MSP: 102704</span> |
                        <span class="product-evaluate">
                        <i class="fa-regular fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                    </span>
                        <span>Chưa có đánh giá</span>
                    </p>
                    <p class="product-price">92,120,900 VNĐ</p>
                </div>
                <div class="contact-info">
                    <input class="info-input" type="text" value=" Tên khách hàng">
                    <input class="info-input" type="text" value=" Số điện thoại">
                    <input class="info-input" type="text" value=" Địa chỉ email">
                    <textarea class="info-input-1" rows="3" cols="40" > Yêu cầu tư vấn</textarea>
                    <button class="button-add-info">TƯ VẤN THÊM</button>
                </div>
            </div>
        </div>
    </dialog>
    </body>
    <%@include file="footer.jsp"%>
</html>