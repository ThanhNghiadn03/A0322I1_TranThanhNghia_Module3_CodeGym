package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/case_study?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL , jdbcUsername , jdbcPassword);
        System.out.println("Ket noi thanh cong");
        return  connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getConnection();
    }
}
