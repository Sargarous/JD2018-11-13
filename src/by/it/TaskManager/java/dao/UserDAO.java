package by.it.TaskManager.java.dao;

import by.it.TaskManager.java.beans.Users;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements InterfaceDAO<Users>{


    @Override
    public boolean create(Users bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Users bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Users bean) throws SQLException {
        return false;
    }

    @Override
    public Users read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Users> getAll(String sqlSuffix) throws SQLException {
        return null;
    }
}
