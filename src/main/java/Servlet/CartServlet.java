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

        //String action = request.getParameter("action");
        String action = null;

        if (action == null){
            action = "cart";
        }
        String url = "/index.jsp";
        if (action.equals("home")){
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            Product product = productDAO.selectProduct(request.getParameter("productCode"));
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            Cart cart = CartDAO.selectCart(user.getId());
            if (indexProductIsFound(product, cart) != -1) {
                int i = indexProductIsFound(product, cart);
                cart.getItems().get(i).setQuantity(cart.getItems().get(i).getQuantity() + 1);
                CartDAO.update(cart);
            } else {
                LineItem lineItem = new LineItem(product, 1);
                cart.getItems().add(lineItem);
                CartDAO.update(cart);
            }
            url = "/cart.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }

    public int indexProductIsFound(Product product, Cart cart) {
        for (int i = 0; i < cart.getItems().size(); i++) {
            if (cart.getItems().get(i).getItem().getCode().equals(product.getCode())) {
                return i;
            }
        }
        return -1;
    }
}
