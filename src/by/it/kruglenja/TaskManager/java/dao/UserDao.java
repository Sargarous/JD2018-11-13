package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.User;

import java.sql.SQLException;
import java.util.List;

public class UserDao implements InterfaceDAO<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `user`(`id`, `userName`, `userPassword`, `userEmail`, `Roles_id`) VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getRoles_id());
        long id = Dao.executeCrate(sql);
        user.setId(id);
        return id > 0;
    }
public boolean read
    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        return null;
    }
}
