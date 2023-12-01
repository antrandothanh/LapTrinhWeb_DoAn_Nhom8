<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" type="text/css" href="styles/body-admin.css"/>
    <link rel="stylesheet" type="text/css" href="styles/adminProduct.css"/>
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
            Sản phẩm
        </div>
        <div class="list-of-product-container">
            <table id="products-table">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Brand</th>
                    <th>Collection</th>
                    <th>Type</th>
                    <th>Color</th>
                    <th>IMG</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="product" items="${sessionScope.products}">
                    <tr>
                        <td><c:out value='${product.getCode()}'/></td>
                        <td><c:out value='${product.getName()}'/></td>
                        <td><c:out value='${product.getPrice()}'/></td>
                        <td><c:out value='${product.getBrand().getName()}'/></td>
                        <td><c:out value='${product.getCollection()}'/></td>
                        <td><c:out value='${product.getType()}'/></td>
                        <td><c:out value='${product.getColor()}'/></td>
                        <td><c:out value='${product.getImgURL()}'/></td>
                        <td><c:out value='${product.getDescription()}'/></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <div class="edit-product-container">
            <form action="loadProducts" method="get" id="productForm">
                <div style="display: flex; padding-top: 20px">
                    <div class="label-of-product">
                        <label>Mã sản phẩm:</label>
                        <label>Tên sản phẩm:</label>
                        <label>Giá tiền:</label>
                        <label>Thương hiệu (nhập mã thương hiệu):</label>
                        <label>Bộ sưu tập:</label>
                        <label>Loại đồng hồ:</label>
                        <label>Màu sắc:</label>
                        <label>Link ảnh:</label>
                        <label>Mô tả:</label>
                    </div>
                    <div class="input-of-product">
                        <input type="text" name="productCode" required>
                        <input type="text" name="productName">
                        <input type="text" name="productPrice" value=0>
                        <input type="text" name="productBrandName">
                        <input type="text" name="productCollection">
                        <div class="input-type-radio">
                            <input type="radio" name="productType" value="men">
                            <label>Nam</label>
                            <input type="radio" name="productType" value="women">
                            <label>Nữ</label>
                        </div>
                        <input type="text" name="productColor">
                        <input type="text" name="productURL_IMG">
                        <input type="text" name="productDescription">

                    </div>
                </div>
                <div class="button-container">
                    <p id="message" style="color: red; font-weight: 700">${message}</p>
                    <button type="submit" name="action" value="addProduct">Thêm</button>
                    <button type="submit" name="action" value="updateProduct">Sửa</button>
                    <button type="submit" name="action" value="deleteProduct">Xoá</button>
                </div>
            </form>
        </div>
        </div>
    </section>
</section>
</body>
</html>
