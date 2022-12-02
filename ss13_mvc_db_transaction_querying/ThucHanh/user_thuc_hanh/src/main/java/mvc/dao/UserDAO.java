package mvc.dao;

import mvc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUser();
    boolean updateUser(User user) throws SQLException;
    boolean deleteUser(int id) throws SQLException;
    User getUserById(int id);
    void insertUserProcedure(User user) throws SQLException;
}
