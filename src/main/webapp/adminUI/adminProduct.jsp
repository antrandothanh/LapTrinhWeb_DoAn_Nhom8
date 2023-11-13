<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0"/>
    <title>Quản lí cửa hàng</title>
    <link rel="stylesheet" type="text/css" href="styles/body.css"/>
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
                Điều chỉnh sản phẩm
            </div>
            <div class="list-of-product-container">
                Xin chao
            </div>
                <form action="" method="">
                    <div class="edit-product-container">
                        <div style="display: flex; padding-top: 20px">
                            <div class="label-of-product">
                                <label>Mã sản phẩm:</label>
                                <label>Tên sản phẩm:</label>
                                <label>Giá tiền:</label>
                                <label>Thương hiệu:</label>
                                <label>Bộ sưu tập:</label>
                                <label>Loại đồng hồ:</label>
                                <label>Màu sắc:</label>
                                <label>Mô tả:</label>
                            </div>
                            <div class="input-of-product">
                                <input type="text" name="productCode">
                                <input type="text" name="productName">
                                <input type="text" name="productPrice">
                                <input type="text" name="productBrand">
                                <input type="text" name="productCollection">
                                <div class="input-type-radio">
                                    <input type="radio" name="productType" value="Nam">
                                    <label>Nam</label>
                                    <input type="radio" name="productType" value="Nữ">
                                    <label>Nữ</label>
                                    <input type="radio" name="productType" value="Cặp đôi">
                                    <label>Cặp đôi</label>
                                </div>
                                <input type="text" name="productColor">
                                <input type="text" name="productDescription">
                            </div>
                        </div>
                        <div class="button-container">
                            <input type="submit" name="addProduct" value="Thêm">
                            <input type="submit" name="editProduct" value="Sửa">
                            <input type="submit" name="removeProduct" value="Xoá">
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </section>
</body>
</html>
