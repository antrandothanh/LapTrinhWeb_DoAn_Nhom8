package Servlet;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.FavouriteDAO;
import Entity.Favourite;
import Entity.User;
import Entity.Cart;
import DAO.UserDAO;
import DAO.CartDAO;


public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

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
            long money = 0;
            user.setMoney(money);

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

                //cookie
                Cookie cookie = new Cookie("usernameCookie", user.getUsername());
                cookie.setMaxAge(60*60*24); //đặt 1 ngày
                cookie.setPath("/"); //cho phép tất cả các page có thể lấy thông tin từ cookie này
                resp.addCookie(cookie);

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

            //Xoá cookie
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); //delete the cookie
                cookie.setPath("/"); //allow the download application to access it
                resp.addCookie(cookie);
            }
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
        } else if (action.equals("customerEditInformation")) {
            // Khách hàng tự thay đổi thông tin cá nhân

            User user = UserDAO.selectUser(req.getParameter("username"));

            user.setPassword(req.getParameter("password"));
            String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "UTF-8");
            user.setName(name);
            String address = new String(req.getParameter("address").getBytes("iso-8859-1"), "UTF-8");
            user.setAddress(address);
            user.setEmail(req.getParameter("email"));
            user.setPhone(req.getParameter("phone"));

            UserDAO.update(user);
            session.setAttribute("user", user);

            url = "/userPage.jsp";
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
