package by.it.TaskManager.java.dao;

import by.it.TaskManager.java.beans.*;
import by.it.kruglenja.Project.java.dao.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    private static volatile DAO dao;

    public InterfaceDAO<Roles> role;
    public InterfaceDAO<Users> user;
    public InterfaceDAO<Projects> project;
    public InterfaceDAO<Tasks> task;
    public InterfaceDAO<UserToProject> userToProject;

    private DAO(){
//        role = new RolesDAO();
//        user = new UsersDAO();
//        project = new ProjectsDAO();
//        task = new TasksDAO();
//        userToProject = new userToProjectDAO();
    }

    public  static DAO getDAO(){
        if (dao == null){
            synchronized (DAO.class){
                if (dao == null){
                    dao = new DAO();
                }
            }
        }
        return dao;
    }

    private void reset(){
        Connect.deleteDb();
        Connect.createDb();
    }

    private void deleteDb(){
        Connect.deleteDb();
    }

    static boolean executeUpdate(String sql) throws SQLException{
        try(Connection connection = Connect.getConnection();
            Statement statement = connection.createStatement()){
            return (1==statement.executeUpdate(sql));
        }
    }

    static long executeCrate(String sql) throws SQLException{
        try (Connection connection = Connect.getConnection();
            Statement statement = connection.createStatement()){
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet generatedId = statement.getGeneratedKeys();
                if (generatedId.next()){
                    return generatedId.getLong(1);
                }
            }

        }
        return -1;
    }
}
