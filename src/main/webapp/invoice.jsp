<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>company invoice - Bootdey.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles/invoice.css" rel="stylesheet">
</head>
<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
<%@include file="header.jsp"%>
<div class="page-content container">
    <div class="page-header text-blue-d2">
        <h1 class="page-title text-secondary-d1">
            Review Invoice
        </h1>
    </div>
    <div class="container px-0">
        <div class="row mt-4">
            <div class="col-12 col-lg-12">
                <hr class="row brc-default-l1 mx-n1 mb-4" />
                <div class="row">
                    <div class="col-sm-6">
                        <div>
                            <span class="text-sm text-grey-m2 align-middle">To:</span>
                            <span class="text-600 text-110 text-blue align-middle">${sessionScope.user.name}</span>
                        </div>
                        <div class="text-grey-m2">
                            <div class="my-1">
                                ${sessionScope.invoice.address}
                            </div>
                            <div class="my-1">
                                ${sessionScope.province}
                            </div>
                            <div class="my-1"><i class="fa fa-phone fa-flip-horizontal text-secondary"></i> <b class="text-600">${sessionScope.user.phone}</b></div>
                        </div>
                    </div>

                    <div class="text-95 col-sm-6 align-self-start d-sm-flex justify-content-end">
                        <hr class="d-sm-none" />
                        <div class="text-grey-m2">
                            <div class="mt-1 mb-2 text-secondary-m1 text-600 text-125">
                                Invoice
                            </div>
                            <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Created Date:</span> ${sessionScope.invoice.createdDate}</div>
                            <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Status:</span> Succesfully</div>

                        </div>
                    </div>
                </div>

                <div class="mt-4">
                    <div class="row text-600 text-white bgc-default-tp1 py-25">
                        <div class="col-9 col-sm-5">PRODUCT CODE</div>
                        <div class="d-none d-sm-block col-4 col-sm-2">NAME</div>
                        <div class="d-none d-sm-block col-sm-2">UNIT PRICE</div>
                        <div class="col-2">AMOUNT</div>
                    </div>
                    <c:forEach var="lineItem" items="${sessionScope.listBuy}">
                        <div class="text-95 text-secondary-d3">
                            <div class="row mb-2 mb-sm-0 py-25">
                                <div class="col-9 col-sm-5">${lineItem.item.code}</div>
                                <div class="d-none d-sm-block col-2">${lineItem.item.name}</div>
                                <div class="d-none d-sm-block col-2 text-95"><fmt:formatNumber value="${lineItem.item.price}" pattern="#,###"/>VND</div>
                                <div class="col-2 text-secondary-d2">${lineItem.quantity}</div>
                            </div>
                        </div>
                        <div class="row border-b-2 brc-default-l2"></div>
                    </c:forEach>

                    <div class="row mt-3">
                        <div class="col-12 col-sm-5 text-grey text-90 order-first order-sm-last">
                            <div class="row my-2 align-items-center bgc-primary-l3 p-2">
                                <div class="col-7 text-right">
                                    NOTE
                                </div>
                                <div class="col-5">
                                    <span>${sessionScope.invoice.note}</span>
                                </div>
                            </div>
                            <div class="row my-2 align-items-center bgc-primary-l3 p-2">
                                <div class="col-7 text-right">
                                    TOTAL PRICE
                                </div>
                                <div class="col-5">
                                    <span><fmt:formatNumber value="${requestScope.totalPrice}" pattern="#,###"/>VND</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <div class="thank" style="margin-top: 15px">
                        <span class="text-secondary-d1 text-105">Thank you for your business</span>
                        <a href="index.jsp" class="btn btn-info btn-bold px-4 float-right mt-3 mt-lg-0" style="margin-top: 10px">Countinue Shopping</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
</script>
<%@include file="footer.jsp"%>
</body>
</html>