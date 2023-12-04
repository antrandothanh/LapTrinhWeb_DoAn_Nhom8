package Servlet;

import DAO.*;
import Entity.*;
import Service.EmailService;
import Service.EmailServiceImpl;

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
        String url = "/invoice.jsp";

        //tạo hoá đơn, chuyển về trang hoá đơn
        String address = request.getParameter("address");
        String province = request.getParameter("province");
        String note = request.getParameter("note");
        Date createdDate = new Date();
        Invoice invoice = new Invoice(user, createdDate, address, note);
        invoice.setBoughtItems(listBuy);
        long totalPrice = invoice.getTotalPrice();
        long updateMoney = user.getMoney() - totalPrice;
        if (updateMoney < 0){   //k đủ tiền
            for (BoughtItem boughtItem : listBuy) {
                BoughtItemDAO.deleteItem(boughtItem);
            }
            url = "/addMoney.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
            return;
        }

        InvoiceDAO.insert(invoice);
        InvoiceDAO.update(invoice);

        session.setAttribute("invoice", invoice);
        session.setAttribute("province", province);
        request.setAttribute("totalPrice", totalPrice);

        user.setMoney(updateMoney);
        UserDAO.update(user);

        //gui mail
        // Construct HTML body
        String htmlBody = "<html><head><meta charset=\"UTF-8\"></head><body>";
        htmlBody += "<p>Invoice id: " + invoice.getCode() + "</p>";
        htmlBody += "<p>User name: " + invoice.getUser().getName() + "</p>";
        htmlBody += "<p>Address: " + invoice.getAddress() + "</p>";
        htmlBody += "<p>Created date: " + invoice.getCreatedDate() + "</p>";
        htmlBody += "<p>Total Price: " + totalPrice + "VND</p>";
        htmlBody += "</body></html>";

        // Send email with HTML body
        EmailService emailService = new EmailServiceImpl();
        String toEmail = user.getEmail();
        emailService.sendHtmlContent(toEmail, "Order confirmation", htmlBody);

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

