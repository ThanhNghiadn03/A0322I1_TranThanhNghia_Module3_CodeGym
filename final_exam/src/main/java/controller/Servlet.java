package controller;

import service.BenhAnService;
import service.BenhNhanService;
import service.impl.BenhAnServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns = ("/xyz"))
public class Servlet extends HttpServlet {
    private BenhAnService benhAnService = new BenhAnServiceImpl();
    private BenhNhanService benhNhanService = new BenhAnServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
