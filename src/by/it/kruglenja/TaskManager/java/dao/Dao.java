package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private static volatile Dao dao;

    public InterfaceDAO<Roles> roles;
    public InterfaceDAO<User> user;
    public InterfaceDAO<Task> task;
    public InterfaceDAO<ProjectList> projectList;

    private Dao() {
        roles = new RolesDao();
        user = new UserDao();
        task = new TaskDao();
        projectList = new ProjectListDao();
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }

    public void reset() {
        Connect.createDB();
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));

        }
    }

    static long executeCreate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }
}
