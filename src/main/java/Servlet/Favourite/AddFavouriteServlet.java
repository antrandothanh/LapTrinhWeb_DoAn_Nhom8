package Servlet.Favourite;

import DAO.CartDAO;
import DAO.FavouriteDAO;
import DAO.productDAO;
import Entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddFavouriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/doAnWeb_war/favourite";
        ServletContext sc =getServletContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Favourite favourite = FavouriteDAO.selectFavourite(user.getId());
        Product product = productDAO.selectProduct(request.getParameter("productCode"));
        if (FavouriteDAO.indexProductIsFound(product, favourite) == -1) {
            favourite.getProducts().add(product);
            FavouriteDAO.update(favourite);
        } else {
            System.out.println("co r");
        }
        request.setAttribute("favourite", favourite);
        response.sendRedirect(url);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
