package Servlet;

import DAO.*;
import Entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BoughtItem> listBought = BoughtItemDAO.selectBoughtItems();
        List<Invoice> invoices = InvoiceDAO.selectInvoices();

        //tổng tiền mà best user mua
        long total_amount_purchased = 0;
        //tổng doanh thu
        long totalRevenue = 0;
        //tổng số lượng sản phẩm đã bán được
        int totalAmountOfProductsSold = 0;

        if (invoices != null) {
            //best user
            int[] index_value_bestUser = InvoiceDAO.timUserMuaNhieuNhat(invoices);
            int index_bestUser = index_value_bestUser[0];
            User bestUser = UserDAO.selectUser(invoices.get(index_bestUser).getUser().getUsername());
            int soLanMua = index_value_bestUser[1];
            request.setAttribute("bestuser", bestUser);
            request.setAttribute("number_of_purchases", soLanMua);

            total_amount_purchased = InvoiceDAO.total_amount_purchased(invoices, bestUser.getId());

            totalRevenue = InvoiceDAO.totalRevenue(invoices);

            totalAmountOfProductsSold = InvoiceDAO.totalAmountOfProduct(invoices);
        }
        request.setAttribute("total_amount_purchased", total_amount_purchased);
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalAmountOfProductsSold", totalAmountOfProductsSold);

        //tổng số lượng khách hàng
        int amountOfCustomer = 0;
        if (listBought != null) {
            //sản phẩm được mua nhiều nhất
            int[] index_value_bestProduct = BoughtItemDAO.timSanPhamXuatHienNhieuNhat(listBought);
            //cặp key-value chứa vị trí và số lượng của sp xh nhiều nhất trong listBought
            int bestProduct_index = index_value_bestProduct[0];
            Product bestProduct = listBought.get(bestProduct_index).getItem();
            int quantityBestProduct = index_value_bestProduct[1];
            LineItem bestLineItem = new LineItem(bestProduct, quantityBestProduct, "True");
            request.setAttribute("bestLineItem", bestLineItem);

            amountOfCustomer = UserDAO.AmountOfCustomer();
        }
        request.setAttribute("amountOfCustomer", amountOfCustomer);

        request.setAttribute("boughtList", listBought);
        request.setAttribute("invoiceList", invoices);

        String url = "/adminStatistics.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
