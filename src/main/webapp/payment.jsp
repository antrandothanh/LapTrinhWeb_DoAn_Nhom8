<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/viewPayment.css">

</head>
<body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div class="card">
    <div class="card-top border-bottom text-center">
        <a href="index.jsp"> Back to shop</a>
        <span id="logo">PAYMENT</span>
    </div>
    <div class="card-body">
        <div class="row upper">
            <span id="payment"><span id="three">3</span>Payment</span>
        </div>
        <div class="row">
            <div class="col-md-7">
                <div class="left border">
                    <div class="row">
                        <span class="header">Payment</span>
                        <div class="icons">
                            <img src="https://img.icons8.com/color/48/000000/visa.png"/>
                            <img src="https://img.icons8.com/color/48/000000/mastercard-logo.png"/>
                            <img src="https://img.icons8.com/color/48/000000/maestro.png"/>
                        </div>
                    </div>
                    <form>
                        <span>Cardholder's name:</span>
                        <input placeholder="Linda Williams">
                        <span>Card Number:</span>
                        <input placeholder="0125 6780 4567 9909">
                        <div class="row">
                            <div class="col-4"><span>Expiry date:</span>
                                <input placeholder="YY/MM">
                            </div>
                            <div class="col-4"><span>CVV:</span>
                                <input id="cvv">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-5">
                <div class="right border">
                    <div class="header">Order Summary</div>
                    <c:forEach var="lineItem" items="${sessionScope.listBuy}">
                    <div class="row item">
                        <div class="col-4 align-self-center"><img class="img-fluid" src="${lineItem.item.imgURL}"></div>
                        <div class="col-8">
                            <div class="row"><b><fmt:formatNumber value="${lineItem.item.price}" pattern="#,###"/>VND</b></div>
                            <div class="row text-muted">${lineItem.item.name}</div>
                            <div class="row">Qty: ${lineItem.quantity}</div>
                        </div>
                    </div>
                    </c:forEach>

                    <hr>
                    <div class="row lower">
                        <div class="col text-left">Subtotal</div>
                        <div class="col text-right"><fmt:formatNumber value="${requestScope.totalPrice}" pattern="#,###"/>VND</div>
                    </div>
                    <div class="row lower">
                        <div class="col text-left">Delivery</div>
                        <div class="col text-right">Free</div>
                    </div>
                    <div class="row lower">
                        <div class="col text-left"><b>Total to pay</b></div>
                        <div class="col text-right"><b><fmt:formatNumber value="${requestScope.totalPrice}" pattern="#,###"/>VND</b></div>
                    </div>
                    <div class="row lower">
                        <div class="col text-left"><a href="#"><u>Add promo code</u></a></div>
                    </div>
                    <button class="btn">Place order</button>
                    <p class="text-muted text-center">Complimentary Shipping & Returns</p>
                </div>
            </div>
        </div>
    </div>
    <div>
    </div>
</div>
</body>
</html>