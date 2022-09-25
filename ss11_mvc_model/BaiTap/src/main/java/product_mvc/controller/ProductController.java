package product_mvc.controller;

import product_mvc.bean.Product;
import product_mvc.service.ProductService;
import product_mvc.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController" , urlPatterns = "/products")
public class ProductController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                createProduct(request,response);
                break;
            case "edit" :
                editProduct(request,response);
                break;
            case "delete" :
                deleteProduct(request,response);
                break;
            case "search" :
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
                showCreateProduct(request,response);
                break;
            case "edit" :
                showEditProduct(request,response);
                break;
            case "delete" :
                showDeleteProduct(request,response);
                break;
            case "view" :
                showDetailProduct(request,response);
                break;
            case "search" :
                break;
            default:
                listProduct(request,response);
                break;
        }
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view_product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view_product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("WEB-INF/view_product/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null) {
            dispatcher = request.getRequestDispatcher("");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("WEB-INF/view_product/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("WEB-INF/view_product/view.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufac = request.getParameter("manufac");
        int id = (int)(Math.random()*10000);
        Product product = new Product(id,name,price,description,manufac);
        this.productService.saveProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view_product/create.jsp");
        request.setAttribute("message" , "New product was created");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String descrip = request.getParameter("description");
        String manufac = request.getParameter("manufac");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("");
        }else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(descrip);
            product.setManuFac(manufac);
            this.productService.editProduct(id,product);
            request.setAttribute("product" , product);
            request.setAttribute("message","product information was updated");
            dispatcher = request.getRequestDispatcher("WEB-INF/view_product/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null) {
            dispatcher = request.getRequestDispatcher("");
        } else {
            this.productService.deleteProduct(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
