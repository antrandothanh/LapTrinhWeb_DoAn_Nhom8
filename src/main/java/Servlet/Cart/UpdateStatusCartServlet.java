package Servlet.Cart;

import DAO.CartDAO;
import DAO.productDAO;
import Entity.Cart;
import Entity.Product;
import Entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateStatusCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = "/cart.jsp";
        ServletContext sc = getServletContext();

        User user = (User)session.getAttribute("user");
        Cart cart = CartDAO.selectCart(user.getId());

        for (int i = 0; i < cart.getItems().size(); i++) {
            String productCode = request.getParameter("productCode_" + i);
            String statusCheckbox = request.getParameter("statusCheckbox_" + i);
            Product product = productDAO.selectProduct(productCode);
            if (CartDAO.indexProductIsFound(product, cart) != -1) {
                int x = CartDAO.indexProductIsFound(product, cart);
                if (statusCheckbox == null){
                    cart.getItems().get(x).setStatus("False");
                } else {
                    cart.getItems().get(x).setStatus("True");
                }
                CartDAO.update(cart);
            }
        }

        request.setAttribute("cart", cart);
        sc.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
