package Servlet.Cart;

import DAO.CartDAO;
import DAO.LineItemDAO;
import DAO.productDAO;
import Entity.Cart;
import Entity.Product;
import Entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/cart.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Cart cart = CartDAO.selectCart(user.getId());
        String code =request.getParameter("productCode");
        Product product = productDAO.selectProduct(code);
        if (indexProductIsFound(product, cart) != -1) {
            int i = indexProductIsFound(product, cart);
            cart.getItems().remove(i);
            CartDAO.update(cart);
        }
        request.setAttribute("cart",cart);
        sc.getRequestDispatcher(url).forward(request, response);
    }
    public int indexProductIsFound(Product product, Cart cart) {
        for (int i = 0; i < cart.getItems().size(); i++) {
            if (cart.getItems().get(i).getItem().getCode().equals(product.getCode())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
