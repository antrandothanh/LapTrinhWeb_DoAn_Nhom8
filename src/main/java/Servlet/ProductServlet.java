package Servlet;

import DAO.UserDAO;
import DAO.productDAO;
import Entity.Brand;
import Entity.Category;
import Entity.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Product> products = productDAO.selectProducts();
        session.setAttribute("products", products);

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
        String productBrandCode = request.getParameter("productBrand");
        String productCollection = request.getParameter("productCollection");
        String productType = request.getParameter("productType");
        String productColor = request.getParameter("productColor");
        String productURL_IMG = request.getParameter("productURL_IMG");
        String productDescription = request.getParameter("productDescription");

        Product p = new Product(productCode, productName, productPrice, productBrandCode, productCollection, productType,
                productColor, productURL_IMG, productDescription);

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

        String productBrandCode = request.getParameter("productBrand");
        String productCollection = request.getParameter("productCollection");
        String productType = request.getParameter("productType");
        String productColor = request.getParameter("productColor");
        String productURL_IMG = request.getParameter("productURL_IMG");
        String productDescription = request.getParameter("productDescription");

        Product p = new Product(productCode, productName, productPrice, productBrandCode, productCollection, productType,
                                productColor, productURL_IMG, productDescription);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}

