package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class Ruiner {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(new Locale("en", "US"));
        //User dao
        Dao dao = Dao.getDao();
        User user = new User();
        Task task = new Task();

        user.setlogin("RTX");
        user.setUserPassword("2012");
        user.setUserEmail("Ahab@Boss");
        user.setRoles_id(1);
        System.out.println("+-+-+-+-+-+-+-+Users AHAB dao+-+-+-+-+-+-+-+");

        if (dao.user.create(user)) {
            System.out.println("create -------->" + user);
            System.out.println(" try change login to XXX-------->" + user);
        }
        user.setlogin("XXX");
        user.setRoles_id(3);
        if (dao.user.update(user)) {
            System.out.println("Updated " + dao.user.getAll());
        }
        user.setId(1);
        if (dao.user.delete(user))
//        if (dao.user.delete(user)) {
//            System.out.println("user -------->" + user.getLogin() + "--------> deleted");
//        }
            System.out.println("<_USER GET ALL_>");
        List<User> all1;
        all1 = dao.user.getAll();
        for (User s : all1) {
            System.out.println(s);
        }
        System.out.println("\n" + "+-+-+-+-+-+-+-+Tasks dao+-+-+-+-+-+-+-+");


        task.setTaskName("Task 1");
        task.setTaskDescription("Description for Task 1");
        task.settaskStartTime("19:20");
        task.setTaskRedLine("21:00");
        task.setTaskDeadLine("22:00");
        task.setUsers_id(2);
        task.setUsers_Roles_id(user.getRoles_id());
        if (dao.task.create(task))
            System.out.println("create task created" );
        task.setId(2);
        if (dao.task.delete(task))
            System.out.println("task id 2 deleted");
        List<Task> tasks;
        tasks = dao.task.getAll();
        for (Task s : tasks) {
            System.out.println(s);
        }

        Task task1 = dao.task.read(3);
        System.out.println(task1 + "tsr");
        task1.setTaskName(" id 3 rebuild");
        task1.setTaskDescription("Description for Task 3");

        System.out.println(task1.toString() + "to string");
        if (dao.task.update(task1))
            System.out.println("task with id 3 rebuilded");

        System.out.println("\n" + "+-+-+-+-+-+-+-+ dao+-+-+-+-+-+-+-+");


    }
}
