package by.it.TaskManager.java.dao;

import by.it.TaskManager.java.beans.Users;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements InterfaceDAO<Users>{

    @Override
    public boolean create(Users user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(`id`, `userName`, `password`, `roles_id`)" +
                " VALUES ('%d','%s','%s','%d')", user.getId(), user.getUserName(), user.getPassword(), user.getRoles_id());
        long id = 
    }

    @Override
    public boolean update(Users user) throws SQLException {
        String sql = String.format("");    }

    @Override
    public boolean delete(Users user) throws SQLException {
        String sql = String.format("");    }

    @Override
    public Users read(long id) throws SQLException {
        String sql = String.format("");    }

    @Override
    public List<Users> getAll(String sqlSuffix) throws SQLException {
        String sql = String.format("");    }
}
