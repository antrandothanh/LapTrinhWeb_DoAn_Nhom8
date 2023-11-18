package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Entity.User;
import DAO.UserDAO;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String url="/index.jsp";

        String action=req.getParameter("action");

        String message;

        if (action.equals("register")) {
            User user = new User();
            user.setName(req.getParameter("name"));
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setEmail(req.getParameter("email"));
            user.setPhone(req.getParameter("phone"));
            user.setAddress(req.getParameter("address"));

            if (!UserDAO.userExisted(user.getUsername())) {
                UserDAO.insert(user);
                url = "/login.jsp";
            } else {
                req.setAttribute("user", user);
                url = "/register.jsp";
                message = "Username is existing, please change other username";
                req.setAttribute("message", message);
            }
        } else if (action.equals("login")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (UserDAO.checkValidAccount(username, password)) {
                url = "/index.jsp";
                User user;
                user = UserDAO.selectUser(username);
                session.setAttribute("user", user);
            }
            else {
                url = "/login.jsp";
                message = "Account doesn't exist, please sign up";
                req.setAttribute("message", message);
            }
        } else if (action.equals("logout")) {
            session.removeAttribute("user");
            url = "/index.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
