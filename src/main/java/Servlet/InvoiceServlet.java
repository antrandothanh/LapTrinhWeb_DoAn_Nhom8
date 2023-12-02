package Servlet;

import DAO.*;
import Entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<BoughtItem> listBuy = (List<BoughtItem>) session.getAttribute("listBuy");

        //xoá lineItem đã mua ra khỏi cart

        //tạo hoá đơn, chuyển về trang hoá đơn
        String address = request.getParameter("address");
        String province = request.getParameter("province");
        String note = request.getParameter("note");
        Date createdDate = new Date();

        Invoice invoice = new Invoice(user, createdDate, address, note);
        InvoiceDAO.insert(invoice);
        invoice.setBoughtItems(listBuy);
        InvoiceDAO.update(invoice);

        session.setAttribute("invoice", invoice);
        session.setAttribute("province", province);
        long totalPrice = invoice.getTotalPrice();
        request.setAttribute("totalPrice", totalPrice);

        String url = "/invoice.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}

