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

public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDAO.selectCart(user.getId());
        for (int i=0; i<cart.getItems().size(); i++){
            if (cart.getItems().get(i).getStatus().equals("True")){
                LineItem lineItem = cart.getItems().get(i);
                System.out.println("------------san pham duoc chon---------\n");
                System.out.println(lineItem.getItem().getCode());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
