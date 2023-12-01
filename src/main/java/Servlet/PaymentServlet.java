package Servlet;

import DAO.BoughtItemDAO;
import DAO.CartDAO;
import DAO.productDAO;
import Entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        Cart cart = CartDAO.selectCart(user.getId());

        //cap nhat status
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

        //vao trang dat hang
        String url = "/cartProduct.jsp";
        List<BoughtItem> listBuy = new ArrayList<>();

        for (int i=0; i<cart.getItems().size(); i++){
            if (cart.getItems().get(i).getStatus().equals("True")){
                LineItem lineItem = cart.getItems().get(i);
                BoughtItem boughtItem = new BoughtItem(lineItem.getItem(), lineItem.getQuantity());
                BoughtItemDAO.insert(boughtItem);
                listBuy.add(boughtItem);
            }
        }
        request.setAttribute("listBuy", listBuy);
        session.setAttribute("listBuy", listBuy);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
