package Servlet.Favourite;

import DAO.CartDAO;
import DAO.FavouriteDAO;
import DAO.productDAO;
import Entity.Cart;
import Entity.*;
import Entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveFavouriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/favourite.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Favourite favourite = FavouriteDAO.selectFavourite(user.getId());
        String code =request.getParameter("productCode");
        Product product = productDAO.selectProduct(code);
        if (FavouriteDAO.indexProductIsFound(product, favourite) != -1) {
            int i = FavouriteDAO.indexProductIsFound(product, favourite);
            favourite.getProducts().remove(i);
            FavouriteDAO.update(favourite);
        }
        request.setAttribute("favourite",favourite);
        sc.getRequestDispatcher(url).forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
