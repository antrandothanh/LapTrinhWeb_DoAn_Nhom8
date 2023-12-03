<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" href="styles/body-admin.css">
    <link rel="stylesheet" href="styles/adminStatistics.css">
</head>
<body>
<section>
    <jsp:include page="adminHeader.jsp"/>
</section>
<section style="display: flex">
    <section>
        <jsp:include page="adminSideBar.jsp"/>
    </section>
    <section class="content-container" style="height: 800px">
        <div class="content-title">
            <h1>Thống kê</h1>
        </div>
        <div class="list-of-invoice">
            <div class="all-invoices">
                <h2>All Invoices</h2>
                <table class="tableList">
                    <tr>
                        <th>Code</th>
                        <th>User</th>
                        <th>Created date</th>
                        <th>Address</th>
                        <th>Note</th>
                    </tr>
                <c:forEach var="invoice" items="${requestScope.invoiceList}">
                    <tr>
                        <td><c:out value="${invoice.code}"/></td>
                        <td><c:out value="${invoice.user.name}"/></td>
                        <td><c:out value="${invoice.createdDate}"/></td>
                        <td><c:out value="${invoice.address}"/></td>
                        <td><c:out value="${invoice.note}"/></td>
                    </tr>
                </c:forEach>
                </table>
            </div>
            <div class="best">
                <h3>The best Customer </h3>
                <label>Customer id: <span>${requestScope.bestuser.id}</span></label>
                <label>Name: <span>${requestScope.bestuser.name}</span></label>
                <label>Email: <span>${requestScope.bestuser.email}</span></label>
                <label>Address: <span>${requestScope.bestuser.address}</span></label>
                <label>Number of purchases: <span>${requestScope.number_of_purchases}</span></label>
                <label><strong>Total amount purchased: <fmt:formatNumber value="${requestScope.total_amount_purchased}" pattern="#,###"/>₫</span></strong></label>
            </div>
        </div>

        <div class="list-of-boughts">
            <div class="all-invoices">
                <h2>All Boughts</h2>
                <table class="tableList">
                    <tr>
                        <th>Code</th>
                        <th>Quantity</th>
                        <th>Item Code</th>
                        <th>Item Name</th>
                        <th>Item Price</th>
                    </tr>
                    <c:forEach var="bought" items="${requestScope.boughtList}">
                        <tr>
                            <td><c:out value="${bought.id}"/></td>
                            <td><c:out value="${bought.quantity}"/></td>
                            <td><c:out value="${bought.item.code}"/></td>
                            <td><c:out value="${bought.item.name}"/></td>
                            <td><c:out value="${bought.item.price}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="best">
                <h3>The most popular product: </h3>
                <img src="${requestScope.bestLineItem.item.imgURL}" alt="bestItemPicture">
                <label><span>${requestScope.bestLineItem.item.name}</span></label>
                <label>Product Code: <span>${requestScope.bestLineItem.item.code}</span></label>
                <label>Brand: <span>${requestScope.bestLineItem.item.brand.name}</span></label>
                <label>Quantity sold: <span>${requestScope.bestLineItem.quantity}</span></label>
            </div>
        </div>
        <div class="Revenue">
            <div class="revenue-box">
                <label><strong>Total Revenue:  <span><fmt:formatNumber value="${requestScope.totalRevenue}" pattern="#,###"/>₫</span></strong></label>
                <label><strong>Total Amount Of Products Sold:  <span>${requestScope.totalAmountOfProductsSold}</span></strong></label>
                <label><strong>Customer amount:  <span>${requestScope.amountOfCustomer}</span></strong></label>
            </div>
        </div>
    </section>
</section>
</body>
</html>
