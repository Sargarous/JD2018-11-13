package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.ProjectList;

import java.sql.SQLException;
import java.util.List;

public class ProjectListDao implements InterfaceDAO<ProjectList>{
    @Override
    public boolean create(ProjectList projectList) throws SQLException {
        String sql = String.format("INSERT INTO `projectlist`(`projectSrart`, `projectRedLine`, `projectDeadLine`, `projectTimeLeft`, `Users_id`, `Users_Roles_id`) VALUES ('%s', '%s', '%s', '%s', '%d', '%d')",
                projectList.getProjectStart(), projectList.getProjectRedLine(), projectList.getProjectDeadLine(), projectList.getUsers_id());
        return false;
    }

    @Override
    public boolean update(ProjectList bean) throws SQLException {
        String sql = String.format("");
        return false;
    }

    @Override
    public boolean delete(ProjectList bean) throws SQLException {
        String sql = String.format("");
        return false;
    }

    @Override
    public ProjectList read(long id) throws SQLException {
        String sql = String.format("");
        return null;
    }

    @Override
    public List<ProjectList> getAll(String sqlSuffix) throws SQLException {
        String sql = String.format("");
        return null;
    }

    @Override
    public List<ProjectList> getAll() throws SQLException {
        String sql = String.format("");
        return null;
    }
}
