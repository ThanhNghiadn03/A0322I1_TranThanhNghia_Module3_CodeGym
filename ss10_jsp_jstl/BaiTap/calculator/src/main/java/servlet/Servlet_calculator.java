package servlet;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_calculator" , urlPatterns = "/calculator")
public class Servlet_calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNum = Double.parseDouble(request.getParameter("firstOperand"));
        double secondNum = Double.parseDouble(request.getParameter("secondOperand"));
        String oprerator = request.getParameter("operand");
        Calculator c = new Calculator(firstNum,secondNum);
        double result = 0.0;
        String error = null;
        switch (oprerator) {
            case "+" :
                result = c.addTwoNum();
                break;
            case "-" :
                result = c.subTwoNum();
                break;
            case "*" :
                result = c.multiTwoNum();
                break;
            case "/" :
                if (secondNum != 0 ) {
                    result = c.divdeTwoNum();
                } else {
                    throw new RuntimeException("Can't divide by zero");
                }
                break;
            default:
                throw new RuntimeException("Invalid operator");
        }
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Result : ");
        writer.println(firstNum + " "+oprerator+" "+secondNum + " = "+result);
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
