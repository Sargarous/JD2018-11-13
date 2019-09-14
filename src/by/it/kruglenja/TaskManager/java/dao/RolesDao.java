package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.Roles;

import java.sql.SQLException;
import java.util.List;

public class RolesDao implements InterfaceDAO<Roles> {
    @Override
    public boolean create(Roles bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Roles bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Roles bean) throws SQLException {
        return false;
    }

    @Override
    public Roles read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Roles> getAll(String sqlSuffix) throws SQLException {
        return null;
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        return null;
    }
}
