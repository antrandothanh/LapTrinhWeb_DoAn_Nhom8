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
            int[] index_value_bestUser = timUserMuaNhieuNhat(invoices);
            int index_bestUser = index_value_bestUser[0];
            User bestUser = UserDAO.selectUser(invoices.get(index_bestUser).getUser().getUsername());
            int soLanMua = index_value_bestUser[1];
            request.setAttribute("bestuser", bestUser);
            request.setAttribute("number_of_purchases", soLanMua);

            total_amount_purchased = total_amount_purchased(invoices, bestUser.getId());

            totalRevenue = totalRevenue(invoices);

            totalAmountOfProductsSold = totalAmountOfProduct(invoices);
        }
        request.setAttribute("total_amount_purchased", total_amount_purchased);
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalAmountOfProductsSold", totalAmountOfProductsSold);

        if (listBought != null) {
            //sản phẩm được mua nhiều nhất
            int[] index_value_bestProduct = timSanPhamXuatHienNhieuNhat(listBought);
            //cặp key-value chứa vị trí và số lượng của sp xh nhiều nhất trong listBought
            int bestProduct_index = index_value_bestProduct[0];
            Product bestProduct = listBought.get(bestProduct_index).getItem();
            int quantityBestProduct = index_value_bestProduct[1];
            LineItem bestLineItem = new LineItem(bestProduct, quantityBestProduct, "True");
            request.setAttribute("bestLineItem", bestLineItem);
        }
        //tổng số lượng khách hàng
        int amountOfCustomer = 0;
        amountOfCustomer = UserDAO.AmountOfCustomer();
        request.setAttribute("amountOfCustomer", amountOfCustomer);

        int amountOfProduct = 0;
        amountOfProduct = ProductDAO.demSoLuongSanPham();
        request.setAttribute("amountOfProduct", amountOfProduct);

        request.setAttribute("boughtList", listBought);
        request.setAttribute("invoiceList", invoices);

        String url = "/adminStatistics.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    public int[] timUserMuaNhieuNhat(List<Invoice> invoices){
        int max = 0;
        int [] index_value = new int[2];
        int b[] = new int[invoices.size()];
        for (int i=0; i<invoices.size(); i++){
            for (int j=0; j<=i; j++){
                if (invoices.get(i).getUser().getId() == invoices.get(j).getUser().getId()){
                    b[i] += 1;
                }
            }
        }
        max = b[0];
        for (int i=0; i<invoices.size(); i++){
            if (b[i] > max){
                max = b[i];
            }
        }
        for (int i=0; i<invoices.size(); i++){
            if (b[i] == max){
                System.out.println("Ma khach hang mua nhieu nhat: "+ invoices.get(i).getUser().getId());
                System.out.println("Khach hang mua nhieu nhat: "+ invoices.get(i).getUser().getName());
                System.out.println("So lan mua hang: " + b[i]);
                index_value[0] = i;
                index_value[1] = b[i];
            }
        }

        return index_value;
    }
    public long total_amount_purchased(List<Invoice> invoices, long userid){
        long total = 0;
        for (int i=0; i< invoices.size(); i++){
            if (invoices.get(i).getUser().getId() == userid){
                total += invoices.get(i).getTotalPrice();
            }
        }
        return total;
    }
    public long totalRevenue(List<Invoice> invoices) {
        long total = 0;
        for (int i = 0; i < invoices.size(); i++) {
            total += invoices.get(i).getTotalPrice();
        }
        return total;
    }
    public int totalAmountOfProduct(List<Invoice> invoices){
        int quantity = 0;
        for (int i=0; i<invoices.size(); i++){
            quantity += invoices.get(i).getToTalAmountOfProduct();
        }
        return quantity;
    }
    public int[] timSanPhamXuatHienNhieuNhat(List<BoughtItem> listBought){
        int max = 0;
        int[] index_value = new int[2];
        int []b = new int[listBought.size()]; //tao mang b co listBought.size phan tu = 0
        for (int i=0; i<listBought.size(); i++){
            for (int j=0; j<=i; j++){
                if (listBought.get(i).getItem().getCode().equals(listBought.get(j).getItem().getCode())){
                    b[i]+=listBought.get(j).getQuantity();
                }
            }
        }
        //tim max
        max = b[0];
        for (int i=1; i<listBought.size(); i++){
            if (b[i] > max){
                max =  b[i];
            }
        }
        for (int i=0; i<listBought.size(); i++){
            if (b[i] == max){
                System.out.println("San pham xh nhieu nhat: "+ listBought.get(i).getItem().getCode());
                System.out.println("So luong: " + b[i]);
                index_value[0] = i;
                index_value[1] = b[i];
            }
        }
        return index_value;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
