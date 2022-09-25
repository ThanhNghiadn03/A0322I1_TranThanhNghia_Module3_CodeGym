package customer_mvc.controller;

import customer_mvc.bean.Customer;
import customer_mvc.service.CustomerService;
import customer_mvc.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController" , urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                createCustomer(request,response);
                break;
            case "edit" :
                updateCustomer(request,response);
                break;
            case "delete" :
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                showCreateForm(request,response);
                break;
            case "edit" :
                showEditForm(request,response);
                break;
            case "delete" :
                showDeleteForm(request,response);
                break;
            case "view" :
                viewCustomer(request,response);
                break;
            default:
                listCustomers(request,response);
                break;
        }
    }
//    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
//        List<Customer> customers = this.customerService.findAll();
//        request.setAttribute("customers",customers);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/list.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/create.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        int id = (int)(Math.random()*10000);
//
//        Customer customer = new Customer(id,name,email,address);
//        this.customerService.save(customer);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/create.jsp");
//        request.setAttribute("message" , "New customer was created");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/error.jsp");
//        } else {
//            request.setAttribute("customer",customer);
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/edit.jsp");
//        }
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/error.jsp");
//        } else {
//            customer.setName(name);
//            customer.setAddress(address);
//            customer.setEmail(email);
//            this.customerService.update(id,customer);
//            request.setAttribute("customer", customer);
//            request.setAttribute("message","Customer infomation was updated");
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/edit.jsp");
//        }
//        try {
//            dispatcher.forward(request,response);
//        }catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer==null) {
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/error.jsp");
//        } else {
//            request.setAttribute("customer",customer);
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/delete.jsp");
//        }
//        try {
//            dispatcher.forward(request,response);
//        }catch (ServletException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/views/error.jsp");
        } else {
            this.customerService.remove(id);
            try {
                response.sendRedirect("/customers");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/error.jsp");
//        } else {
//            request.setAttribute("customer",customer);
//            dispatcher = request.getRequestDispatcher("WEB-INF/views/view.jsp");
//        }
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
