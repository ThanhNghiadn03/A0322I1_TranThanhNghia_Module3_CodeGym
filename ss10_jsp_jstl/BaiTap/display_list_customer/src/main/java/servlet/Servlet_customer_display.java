package servlet;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Servlet_customer_display" , urlPatterns = "/customer")
public class Servlet_customer_display extends HttpServlet {
    public static List<Customer> listCustomer = new LinkedList<>();
    static {
            listCustomer.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội",""));
            listCustomer.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang",""));
            listCustomer.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định",""));
            listCustomer.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây",""));
            listCustomer.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội",""));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",listCustomer);
        request.getRequestDispatcher("view/customerDisplay.jsp").forward(request,response);
    }
}
