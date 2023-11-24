package Servlet.Cart;

import DAO.CartDAO;
import DAO.productDAO;
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

public class UpdateCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/cart.jsp";
        ServletContext sc = getServletContext();
        String quantity = request.getParameter("quantity");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Cart cart = CartDAO.selectCart(user.getId());
        Product product = productDAO.selectProduct(request.getParameter("productCode"));
        if (CartDAO.indexProductIsFound(product, cart) != -1) {
            int i = CartDAO.indexProductIsFound(product, cart);
            cart.getItems().get(i).setQuantity(Integer.parseInt(quantity));
            CartDAO.update(cart);
        }
        request.setAttribute("cart", cart);
        sc.getRequestDispatcher(url).forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
