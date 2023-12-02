package Servlet;

import DAO.brandDAO;
import DAO.productDAO;
import Entity.Brand;
import Entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Product> products = productDAO.selectProducts();
        session.setAttribute("products", products);

        List<Brand> brands = brandDAO.selectBrands();
        session.setAttribute("brands", brands);

        String action = request.getParameter("action");
        if (action == null) {
            action = "home";
        }
        String url = "/index.jsp";
        if (action.equals("home")) {
            url = "/index.jsp";
        } else if (action.equals("addProduct")) {
            url = addProduct(request, response);
        } else if (action.equals("updateProduct")) {
            url = updateProduct(request, response);
        } else if (action.equals("deleteProduct")) {
            url = deleteProduct(request, response);
        } else if (action.equals("search")) {
            url = searchProduct(request, response);
        } else if (action.equals("minToMax")) {
            url = searchProductMinToMax(request, response);
        } else if (action.equals("maxToMin")) {
            url = searchProductMaxToMin(request, response);
        } else if (action.equals("less500")) {
            url = searchProductLess500M(request, response);
        } else if (action.equals("more500")) {
            url = searchProductMore500M(request, response);
        } else if (action.equals("viewProductDetail")) {
            url = viewProductDetail(request, response);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    private String addProduct(HttpServletRequest request,
                              HttpServletResponse response){
        String productCode =request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String productPriceString = request.getParameter("productPrice");
        long productPrice = Long.parseLong(productPriceString);
        String productBrandName = request.getParameter("productBrandName");
        String productCollection = request.getParameter("productCollection");
        String productType = request.getParameter("productType");
        String productColor = request.getParameter("productColor");
        String productURL_IMG = request.getParameter("productURL_IMG");
        String productDescription = request.getParameter("productDescription");

        Brand brand = brandDAO.selectBrand(productBrandName);
        Product p = new Product();
        if (brand == null){
            Brand b = new Brand();
            b.setName(productBrandName);
            brandDAO.insert(b);
            p = new Product(productCode, productName, productPrice, b, productCollection, productType,
                    productColor, productURL_IMG, productDescription);
        }
        else {
            p = new Product(productCode, productName, productPrice, brand, productCollection, productType,
                    productColor, productURL_IMG, productDescription);
        }
        String message;
        if (!productDAO.productExisted(p.getCode())) {
            productDAO.insert(p);
            message = "Successfully added";
        } else {
            message = "ProductCode is existing, please change other productCode!";
        }
        request.setAttribute("message", message);

        // Cập nhật lại danh sách sản phẩm trong session
        HttpSession session = request.getSession();
        List<Product> products = productDAO.selectProducts();
        session.setAttribute("products", products);

        // Trả về trang hiện tại
        String url = "/adminProduct.jsp";
        return url;
    }
    private String updateProduct(HttpServletRequest request,
                                 HttpServletResponse response){
        String productCode =request.getParameter("productCode");
        String productName = request.getParameter("productName");

        String productPriceString = request.getParameter("productPrice");
        long productPrice = Long.parseLong(productPriceString);

        String productBrandName = request.getParameter("productBrandName");
        String productCollection = request.getParameter("productCollection");
        String productType = request.getParameter("productType");
        String productColor = request.getParameter("productColor");
        String productURL_IMG = request.getParameter("productURL_IMG");
        String productDescription = request.getParameter("productDescription");

        Brand brand = brandDAO.selectBrand(productBrandName);
        Product p = new Product();
        if (brand == null){
            Brand b = new Brand();
            b.setName(productBrandName);
            brandDAO.insert(b);
            p = new Product(productCode, productName, productPrice, b, productCollection, productType,
                    productColor, productURL_IMG, productDescription);
        }
        else {
            p = new Product(productCode, productName, productPrice, brand, productCollection, productType,
                    productColor, productURL_IMG, productDescription);
        }
        String message;
        if (productDAO.productExisted(p.getCode())){
            productDAO.update(p);
            message = "Successfully updated";
        }
        else {
            message = "ProductCode is not exist! Please enter right product code!";
        }
        request.setAttribute("message", message);

        // Cập nhật danh sách sản phẩm trong session
        HttpSession session = request.getSession();
        List<Product> products = productDAO.selectProducts();
        session.setAttribute("products", products);

        // Trả về trang hiện tại
        String url = "/adminProduct.jsp";
        return url;
    }
    private String deleteProduct(HttpServletRequest request,
                                 HttpServletResponse response){
        String productCode =request.getParameter("productCode");
        String message;
        if (productDAO.productExisted(productCode)){
            productDAO.delete(productCode);
            message = "Successfully deleted";
        }
        else {
            message = "ProductCode is not exist! Please enter right product code!";
        }
        request.setAttribute("message", message);

        // Cập nhật danh sách sản phẩm trong session
        HttpSession session = request.getSession();
        List<Product> products = productDAO.selectProducts();
        session.setAttribute("products", products);

        // Trả về trang hiện tại
        String url = "/adminProduct.jsp";
        return url;
    }

    private String searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        List<Product> foundProduct = productDAO.searchProducts(request.getParameter("searchInput"));
        request.setAttribute("foundProduct", foundProduct);
        return "/search.jsp";
    }
    private String searchProductMore500M(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        List<Product> foundProduct = productDAO.getProductsMore500M();
        request.setAttribute("foundProduct", foundProduct);
        return "/search.jsp";
    }
    private String searchProductLess500M(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        List<Product> foundProduct = productDAO.getProductsLess500M();
        request.setAttribute("foundProduct", foundProduct);
        return "/search.jsp";
    }
    private String searchProductMinToMax(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        List<Product> foundProduct = productDAO.getProductsMinToMax();
        request.setAttribute("foundProduct", foundProduct);
        return "/search.jsp";
    }
    private String searchProductMaxToMin(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        List<Product> foundProduct = productDAO.getProductsMaxToMin();
        request.setAttribute("foundProduct", foundProduct);
        return "/search.jsp";
    }
    private String viewProductDetail(HttpServletRequest request, HttpServletResponse response){
        String url = "/viewProduct.jsp";
        String productCode = request.getParameter("productCode");
        Product product = productDAO.selectProduct(productCode);
        Brand brand = brandDAO.selectBrandByCode(product.getBrand().getCode());

        request.setAttribute("product", product);
        request.setAttribute("brand", brand);

        return url;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}

