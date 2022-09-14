package ThucHanh.dictionary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet_dictionary" , value = "/dictionary")
public class Servlet_dictionary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String , String> dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("how", "như thế nào");
        dictionary.put("book","vở");
        dictionary.put("computer","máy tính");
        dictionary.put("bag","cái túi");

        String search = request.getParameter("word");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if (result != null) {
            writer.println("Word : "+search);
            writer.println("<br>");
            writer.println("Result : "+result);
        } else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String , String> dictionary = new HashMap<>();
//        dictionary.put("hello","xin chào");
//        dictionary.put("how", "như thế nào");
//        dictionary.put("book","vở");
//        dictionary.put("computer","máy tính");
//        dictionary.put("bag","cái túi");
//
//        String search = request.getParameter("word");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        String result = dictionary.get(search);
//        if (result != null) {
//            writer.println("Word : "+search);
//            writer.println("<br>");
//            writer.println("Result : "+result);
//        } else {
//            writer.println("Not found");
//        }
//        writer.println("</html>");
    }
}
