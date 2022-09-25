package mvc.controller;

import mvc.dao.UserDAOimpl;
import mvc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet" , urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAOimpl userDAOimpl;
    public void init() {
        userDAOimpl = new UserDAOimpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create" :
                    insertUser(request,response);
                    break;
                case "edit" :
                    updateUser(request,response);
                    break;

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create" :
                    showNewForm(request,response);
                    break;
                case "edit" :
                    showEditForm(request,response);
                    break;
                case "delete" :
                    deleteUser(request,response);
                    break;
                default:
                    listUser(request,response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userDAOimpl.selectAllUsers();
        request.setAttribute("listUser",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/list.jsp");
        dispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/create.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAOimpl.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/edit.jsp");
        request.setAttribute("user",existingUser);
        dispatcher.forward(request,response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name,email,country);
        userDAOimpl.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/create.jsp");
        dispatcher.forward(request,response);
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User book = new User(id,name,email,country);
        userDAOimpl.updateUser(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/edit.jsp");
        dispatcher.forward(request,response);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAOimpl.deleteUser(id);
        List<User> listUser = userDAOimpl.selectAllUsers();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/list.jsp");
        dispatcher.forward(request,response);
    }
}

