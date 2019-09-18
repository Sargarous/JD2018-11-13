package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDao implements InterfaceDAO<Task> {

    public boolean create(Task task) throws SQLException {
        String sql = String.format("INSERT INTO `tasks`(`taskName`, `taskDescription`, `taskStartTime`," +
                        " `taskRedLine`, `taskDeadLine`, `ProjectList_id`, `ProjectList_Users_id`," +
                        " `ProjectList_Users_Roles_id`, `Users_id`, `Users_Roles_id`) VALUES" +
                        "('%s', '%s', '%s', '%s', '%s', '%d', '%d', '%d', '%d', '%d')", task.getTaskName(),
                task.getTaskDescription(), task.getTaskStratTime(), task.getTaskRedLine(), task.getTaskDeadLine(),
                task.getProjectList_id(), task.getProjectList_Users_id(),
                task.getProject_Users_Roles_id(), task.getUsers_id(), task.getUsers_Roles_id());
        long id = Dao.executeCreate(sql);
        task.setId(id);
        return (id > 0);
    }

    public boolean update(Task task) throws SQLException {
        String sql = String.format("UPDATE `tasks` SET `taskName`='%s',`taskDescription`='%s'," +
                        "`taskStartTime`='%s',`taskRedLine`='%s',`taskDeadLine`='%s',`ProjectList_id`='%d'," +
                        "`ProjectList_Users_id`='%d',`ProjectList_Users_Roles_id`='%d',`Users_id`='%d'," +
                        "`Users_Roles_id`='%d' WHERE `tasks`.`id` = '%d'",
                task.getTaskName(), task.getTaskDescription(), task.getTaskStratTime(), task.getTaskRedLine(),
                task.getTaskDeadLine(), task.getProjectList_id(), task.getProjectList_Users_id(), task.getProject_Users_Roles_id(),
                task.getUsers_id(), task.getUsers_Roles_id(), task.getId());
        System.out.println("sql " + sql);
        return Dao.executeUpdate(sql);
    }

    public boolean delete(Task task) throws SQLException {
        String sql = String.format("DELETE FROM `tasks` WHERE `tasks`.`id` = %d", task.getId());
        return Dao.executeUpdate(sql);
    }

    public Task read(long id) throws SQLException {
        List<Task> tasks = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }


    @Override
    public List<Task> getAll(String sqlSuffix) throws SQLException {
        List<Task> result = new ArrayList<>();
        String sql = String.format("SELECT `id`, `taskName`, `taskDescription`, `taskStartTime`, `taskRedLine`, " +
                "`taskDeadLine`, `ProjectList_id`, `ProjectList_Users_id`, `ProjectList_Users_Roles_id`, `Users_id`, " +
                "`Users_Roles_id` FROM `tasks` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String taskName = resultSet.getString("taskName");
                String taskDescription = resultSet.getString("taskDescription");
                String taskStartTime = resultSet.getString("taskStartTime");
                String taskRedLine = resultSet.getString("taskRedLine");
                String taskDeadLine = resultSet.getString("taskDeadLine");
                long ProjectList_id = resultSet.getLong("ProjectList_id");
                long ProjectList_Users_id = resultSet.getLong("ProjectList_Users_id");
                long ProjectList_Users_Roles_id = resultSet.getLong("ProjectList_Users_Roles_id");
                long Users_id = resultSet.getLong("Users_id");
                long Users_Roles_id = resultSet.getLong("Users_Roles_id");

                Task task = new Task(id, taskName, taskDescription, taskStartTime, taskRedLine, taskDeadLine,
                        ProjectList_id, ProjectList_Users_id, ProjectList_Users_Roles_id, Users_id, Users_Roles_id);
                result.add(task);
            }
            return result;

        }
    }
}
