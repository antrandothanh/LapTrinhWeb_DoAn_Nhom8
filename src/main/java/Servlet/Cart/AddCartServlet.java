package Servlet.Cart;

import DAO.CartDAO;
import DAO.ProductDAO;
import Entity.Cart;
import Entity.LineItem;
import Entity.Product;
import Entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String contextPath = request.getServletContext().getContextPath();

        // Kết hợp đường dẫn cơ bản với phần còn lại của đường dẫn cụ thể
        String url = contextPath + "/cart";

        ServletContext sc =getServletContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null){
            url = "/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        Cart cart = CartDAO.selectCart(user.getId());
        Product product = ProductDAO.selectProduct(request.getParameter("productCode"));
        if (cart.indexProductIsFound(product) != -1) {
            int i = cart.indexProductIsFound(product);
            cart.getItems().get(i).setQuantity(cart.getItems().get(i).getQuantity() + 1);
            CartDAO.update(cart);
        } else {
            LineItem lineItem = new LineItem(product, 1, "False");
            cart.getItems().add(lineItem);
            CartDAO.update(cart);
        }
        request.setAttribute("cart", cart);
        response.sendRedirect(url);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
