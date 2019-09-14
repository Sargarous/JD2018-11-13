package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.Task;

import java.sql.SQLException;
import java.util.List;

public class TaskDao implements InterfaceDAO<Task>{
    @Override
    public boolean create(Task bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Task bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Task bean) throws SQLException {
        return false;
    }

    @Override
    public Task read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Task> getAll(String sqlSuffix) throws SQLException {
        return null;
    }

    @Override
    public List<Task> getAll() throws SQLException {
        return null;
    }
}
