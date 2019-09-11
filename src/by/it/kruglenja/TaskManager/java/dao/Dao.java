package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.ProjectList;
import by.it.kruglenja.TaskManager.java.beans.Roles;
import by.it.kruglenja.TaskManager.java.beans.Task;
import by.it.kruglenja.TaskManager.java.beans.User;

public class Dao {
    private static volatile Dao dao;

    public InterfaceDAO<Roles> roles;
    public InterfaceDAO<User> user;
    public InterfaceDAO<Task> task;
    public InterfaceDAO<ProjectList> projectList;

    private Dao(){

    }

}
