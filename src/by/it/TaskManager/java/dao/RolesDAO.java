package by.it.TaskManager.java.dao;

import java.sql.SQLException;
import java.util.List;

public class RolesDAO implements InterfaceDAO{

    @Override
    public boolean create(Object bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Object bean) throws SQLException {
        return false;
    }

    @Override
    public Object read(long id) throws SQLException {
        return null;
    }

    @Override
    public List getAll(String sqlSuffix) throws SQLException {
        return null;
    }
}
