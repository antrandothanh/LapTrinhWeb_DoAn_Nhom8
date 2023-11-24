package Servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.productDAO;
import Entity.Product;
import DAO.FavouriteDAO;
import Entity.Favourite;
import Entity.User;
import Entity.Cart;
import Entity.LineItem;
import DAO.UserDAO;
import DAO.CartDAO;
import DAO.LineItemDAO;


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
                Cart cart;
                cart = CartDAO.selectCart(user.getId());
                if (cart == null) {
                    cart = new Cart(user);
                    CartDAO.insert(cart);
                }
                Favourite favourite;
                favourite= FavouriteDAO.selectFavourite(user.getId());
                if (favourite == null) {
                    favourite = new Favourite(user);
                    FavouriteDAO.insert(favourite);
                }
            }
            else {
                url = "/login.jsp";
                message = "Account doesn't exist, please sign up";
                req.setAttribute("message", message);
            }
        } else if (action.equals("logout")) {
            session.removeAttribute("user");
            url = "/index.jsp";
        } else if (action.equals("addCustomer")) {
            User customer = new User();
            customer.setUsername(req.getParameter("customerUsername"));
            customer.setPassword(req.getParameter("customerPassword"));
            customer.setName(req.getParameter("customerName"));
            customer.setEmail(req.getParameter("customerEmail"));
            customer.setPhone(req.getParameter("customerPhone"));
            customer.setAddress(req.getParameter("customerAddress"));
            if (!UserDAO.userExisted(customer.getUsername())) {
                UserDAO.insert(customer);
                message = "Successfully added";
                req.setAttribute("message", message);
            } else {
                req.setAttribute("user", customer);
                message = "Username is existing, please change other username";
                req.setAttribute("message", message);
            }
            url = refreshPageForCustomize(req,resp);
        } else if (action.equals("updateCustomer")) {
            String username = req.getParameter("customerUsername");
            if (!UserDAO.userExisted(username)) {
                message = "Customer is not found!";
                req.setAttribute("message", message);
            } else {
                User customer = UserDAO.selectUser(username);
                customer.setPassword(req.getParameter("customerPassword"));
                customer.setName(req.getParameter("customerName"));
                customer.setAddress(req.getParameter("customerAddress"));
                customer.setEmail(req.getParameter("customerEmail"));
                customer.setPhone(req.getParameter("customerPhone"));
                UserDAO.update(customer);
                message = "Successfully updated";
                req.setAttribute("message", message);
            }
            url = refreshPageForCustomize(req,resp);
        } else if (action.equals("removeCustomer")) {
            String username = req.getParameter("customerUsername");
            if (UserDAO.userExisted(username)) {
                User user = UserDAO.selectUser(username);
                UserDAO.delete(user);
                message = "Successfully removed";
            } else {
                message = "Customer is not found";
            }
            req.setAttribute("message", message);
            url = refreshPageForCustomize(req,resp);
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    protected String refreshPageForCustomize(HttpServletRequest request, HttpServletResponse response){
        // Cập nhật danh sách user trong session
        HttpSession session = request.getSession();
        List<User> users = UserDAO.selectUsers();
        session.setAttribute("users", users);

        String url = "/adminCustomer.jsp";
        return url;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
