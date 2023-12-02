package Servlet;
import DAO.*;
import Entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MoneyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getServletContext().getContextPath();

        String url = "/access.jsp";
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String moneystr = request.getParameter("money");
        if (user == null){
            response.getWriter().write("Please Login!");
        }
        else
        {
            Long newmoney= user.getMoney()+Long.parseLong(moneystr);
            user.setMoney(newmoney);
            UserDAO.update(user);
        }
        session.setAttribute("user", user);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
