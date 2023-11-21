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
            String productCode = request.getParameter("productCode");
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("cart");

            //tim san pham da ton tai trong gio hang chua
            for (int i = 0; i < cart.getItems().size(); i++) {
                LineItem lineItem = cart.getItems().get(i);
                if (lineItem.getItem().getCode().equals(productCode)) {
                    lineItem.setQuantity(lineItem.getQuantity() + 1);
                    LineItemDAO.update(lineItem); //chi can cap nhat database cua LineItem
                    CartDAO.update(cart);
                }
            }

            //neu san pham do khong co trong gio hang
            Product product = productDAO.selectProduct(productCode);
            LineItem lineItem = new LineItem();
            lineItem.setItem(product);
            lineItem.setQuantity(1);
            LineItemDAO.insert(lineItem);
            cart.getItems().add(lineItem);
            CartDAO.update(cart);

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
