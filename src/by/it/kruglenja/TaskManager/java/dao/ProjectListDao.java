package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.ProjectList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectListDao implements InterfaceDAO<ProjectList> {

    public boolean create(ProjectList projectList) throws SQLException {
        String sql = String.format("INSERT INTO `projectlist`(`projectName`, `projectDescription`, `projectSrart`, " +
                        "`projectRedLine`, `projectDeadLine`, `Users_id`, `Users_Roles_id`) VALUES " +
                        "('%s', '%s', '%s', '%s', '%s', '%s', '%d')",
                projectList.getProjectName(), projectList.getprojectDescription(), projectList.getProjectStart(),
                projectList.getProjectRedLine(), projectList.getProjectDeadLine(), projectList.getUsers_id(),
                projectList.getUsers_Roles_id());
        long id = Dao.executeCreate(sql);
        projectList.setId(id);
        return (id > 0);
    }


    public boolean update(ProjectList projectList) throws SQLException {
        String sql = String.format("UPDATE `projectlist` SET `projectName`= '%s',`projectDescription`= '%s'," +
                        "`projectSrart`= '%s',`projectRedLine`= '%s',`projectDeadLine`= '%s'," +
                        "`Users_id`= '%d',`Users_Roles_id`= '%d' WHERE `projectlist`.`id` = '%d'",
                projectList.getProjectName(), projectList.getprojectDescription(), projectList.getProjectStart(),
                projectList.getProjectRedLine(), projectList.getProjectDeadLine(), projectList.getUsers_id(),
                projectList.getUsers_Roles_id(), projectList.getId());
        return Dao.executeUpdate(sql);
    }


    public boolean delete(ProjectList projectList) throws SQLException {
        String sql = String.format("DELETE FROM `projectlist` WHERE `projectList`.`id` = '%d'", projectList.getId());
        return Dao.executeUpdate(sql);
    }


    public ProjectList read(long id) throws SQLException {
        String sqlSuffix = String.format("WHER id=%d", id);
        List<ProjectList> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<ProjectList> getAll(String sqlSuffix) throws SQLException {
        List<ProjectList> result = new ArrayList<>();
        String sql = String.format("SELECT `id`, `projectName`, `projectDescription`, `projectSrart`, `projectRedLine`, `projectDeadLine`, `Users_id`, `Users_Roles_id` FROM `projectlist` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String projectName = resultSet.getString("projectName");
                String projectDescription = resultSet.getString("projectDescription");
                String projectSrart = resultSet.getString("projectSrart");
                String projectRedLine = resultSet.getString("projectRedLine");
                String projectDeadLine = resultSet.getString("projectDeadLine");
                long Users_id = resultSet.getLong("Users_id");
                long Users_Roles_id = resultSet.getLong("Users_Roles_id");
                ProjectList projectList = new ProjectList(id, projectName, projectDescription, projectSrart, projectRedLine, projectDeadLine, Users_id, Users_Roles_id);
                result.add(projectList);
            }
        }
        return result;
    }
}
