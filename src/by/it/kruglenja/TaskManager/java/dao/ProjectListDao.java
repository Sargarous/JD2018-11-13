package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.ProjectList;

import java.sql.SQLException;
import java.util.List;

public class ProjectListDao implements InterfaceDAO<ProjectList>{
    @Override
    public boolean create(ProjectList bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ProjectList bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(ProjectList bean) throws SQLException {
        return false;
    }

    @Override
    public ProjectList read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<ProjectList> getAll(String sqlSuffix) throws SQLException {
        return null;
    }

    @Override
    public List<ProjectList> getAll() throws SQLException {
        return null;
    }
}
