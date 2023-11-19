package Servlet;

import DAO.CartDAO;
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

        String action = request.getParameter("action");

        if (action == null){
            action = "cart";
        }
        String url = "/index.jsp";
        if (action.equals("home")){
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
            HttpSession session = request.getSession();

            Cart cart = (Cart) session.getAttribute("cart");
            User u = new User();
            u.setId(123);

            cart = CartDAO.selectCart(u.getId());
            if (cart == null){
                cart = new Cart();
                cart.setUser(u);
            }
            Product p = productDAO.selectProduct(productCode);
            int quantity;
            try{
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0){
                    quantity = 1;
                }
                LineItem lineItem = new LineItem(p, quantity);
                if (quantity > 0){
                    CartDAO.updateLineItem(cart, lineItem);
                } else if (quantity == 0) {
                    CartDAO.removeItem(cart, lineItem);
                }

            } catch (NumberFormatException nfe){
                LineItem lineItem = new LineItem(p, 1);
                CartDAO.addItem(cart,lineItem);
            }

            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }
}
