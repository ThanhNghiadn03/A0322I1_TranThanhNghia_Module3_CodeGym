package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_convert_money",value = "/convert")
public class Servlet_convert_money extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vn = usd*rate;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h2> Rate : "+rate+"</h2>");
        writer.println("<h2> USD : "+usd+"</h2>");
        writer.println("<h2> VN : "+vn+"</h2>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
