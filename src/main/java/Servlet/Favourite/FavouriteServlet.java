package Servlet.Favourite;
import Entity.*;
import Servlet.*;
import DAO.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FavouriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url="/favourite.jsp";
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Favourite favourite = FavouriteDAO.selectFavourite(user.getId());
        request.setAttribute("favourite", favourite);
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    public int indexProductIsFound(Product product, Favourite favourite) {
        for (int i = 0; i < favourite.getProducts().size(); i++) {
            if (favourite.getProducts().get(i). equals(product.getCode())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
