package Servlet;

import DAO.CartDAO;
import DAO.LineItemDAO;
import DAO.UserDAO;
import DAO.productDAO;
import Entity.Cart;
import Entity.LineItem;
import Entity.Product;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Line;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String url = "/cart.jsp";
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Cart cart = CartDAO.selectCart(user.getId());
        request.setAttribute("cart", cart);
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }

}
