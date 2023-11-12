function myFunction() {
    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("myBtn");

    if (dots.style.display === "none") {
        dots.style.display = "block";
        btnText.innerHTML = "XEM THÊM";
        moreText.style.display = "none";
    } else {
        dots.style.display = "none";
        btnText.innerHTML = "THU GỌN";
        moreText.style.display = "block";
    }
}
var dialog = document.querySelector('dialog');
dialogPolyfill.registerDialog(dialog);

function showThisDialog() {
    document.getElementById('dialog-add-info').showModal();
}

function hideThisDialog() {
    document.getElementById('dialog-add-info').close();
}
function showImage(imageSource) {
    const maxImage = document.getElementById('maxImage');
    maxImage.src = imageSource;
}
function toPage(){
    window.location.href = "cartProduct.jsp";
}
function toProduct(){
    window.location.href = "viewProduct.jsp";
}
function toFavourite() {
    var shape = document.getElementById("fa");
    if (shape.classList.contains("fa-regular")) {
        shape.classList.remove("fa-regular");
        shape.classList.add("fa-solid");
    } else {
        shape.classList.remove("fa-solid");
        shape.classList.add("fa-regular");
    }
}