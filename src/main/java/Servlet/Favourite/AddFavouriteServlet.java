package Servlet.Favourite;

import DAO.FavouriteDAO;
import DAO.ProductDAO;
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

        String contextPath = request.getServletContext().getContextPath();

        // Kết hợp đường dẫn cơ bản với phần còn lại của đường dẫn cụ thể
        String url = contextPath + "/favourite";

        ServletContext sc =getServletContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null){
            response.getWriter().write("Please Login!");
        }
        Favourite favourite = FavouriteDAO.selectFavourite(user.getId());
        Product product = ProductDAO.selectProduct(request.getParameter("productCode"));
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
