
//  SỰ KIỆN CLICK TICK ALL
// Lấy tham chiếu đến checkbox ở #title-column
const titleCheckbox = document.querySelector("#title-column input[type='checkbox']");
// Lấy tất cả các checkbox bên dưới #cart-product
const productCheckboxes = document.querySelectorAll("#cart-product input[type='checkbox']");
// Thêm sự kiện lắng nghe cho checkbox ở #title-column
titleCheckbox.addEventListener("change", function () {
// Lặp qua tất cả các checkbox bên dưới và đặt trạng thái kiểm tra của chúng
productCheckboxes.forEach((checkbox) => {
    checkbox.checked = titleCheckbox.checked;
});
});


//SỰ KIỆN DELETE SẢN PHẨM
function deleteProduct(button)
{
// Lấy đối tượng div cha của nút DELETE (sản phẩm)
const product = button.parentElement.parentElement;

// Lấy đối tượng cha của sản phẩm (container của các sản phẩm)
const cartProductContainer = document.getElementById("cart-product");

// Xoá sản phẩm khỏi giỏ hàng
cartProductContainer.removeChild(product);
}
