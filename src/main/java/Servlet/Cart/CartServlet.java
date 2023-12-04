package Servlet.Cart;

import DAO.CartDAO;
import Entity.Cart;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String url = "/cart.jsp";
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user != null) {
            Cart cart = CartDAO.selectCart(user.getId());
            for (int i = 0; i < cart.getItems().size(); i++) {
                cart.getItems().get(i).setStatus("False");
            }
            CartDAO.update(cart);
            request.setAttribute("cart", cart);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.getWriter().write("Please Login!");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }

}
