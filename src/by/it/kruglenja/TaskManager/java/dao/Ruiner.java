package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Ruiner {
    public static void main(String[] args) throws SQLException, ParseException {
        Locale.setDefault(new Locale("en", "US"));
        //User dao
//        Dao dao = Dao.getDao().getDao();
        User user = new User();
        Task task = new Task();

        user.setlogin("RTX");
        user.setUserPassword("2012");
        user.setUserEmail("Ahab@Boss");
        user.setRoles_id(1);
        System.out.println("+-+-+-+-+-+-+-+Users AHAB dao+-+-+-+-+-+-+-+");

        if (Dao.getDao().user.create(user)) {
            System.out.println("create -------->" + user);
            System.out.println(" try change login to XXX-------->" + user);
        }
        user.setlogin("XXX");
        user.setRoles_id(3);
        if (Dao.getDao().user.update(user)) {
            System.out.println("Updated " + Dao.getDao().user.getAll());
        }
        user.setId(1);
//        if (Dao.getDao().user.delete(user))
////        if (Dao.getDao().user.delete(user)) {
////            System.out.println("user -------->" + user.getLogin() + "--------> deleted");
////        }
//            System.out.println("<_USER GET ALL_>");
//        List<User> all1;
//        all1 = Dao.getDao().user.getAll();
//        for (User s : all1) {
//            System.out.println(s);
//        }
        System.out.println("\n" + "+-+-+-+-+-+-+-+Tasks dao+-+-+-+-+-+-+-+");


        task.setTaskName("Task 1");
        task.setTaskDescription("Description for Task 1");
        LocalDateTime newDate = null;
        String dateTime = "2019-09-05 00:00:00";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            newDate = LocalDateTime.parse(dateTime, dtf);
            System.out.println(newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        task.settaskStartTime(newDate);

        task.setTaskRedLine(newDate);
        task.setTaskDeadLine(newDate);
        task.setUsers_id(2);
        task.setUsers_Roles_id(user.getRoles_id());
        if (Dao.getDao().task.create(task))
            System.out.println("create task created" );
        task.setId(2);
//        if (Dao.getDao().task.delete(task))
//            System.out.println("task id 2 deleted");
//        List<Task> tasks;
//        tasks = Dao.getDao().task.getAll();
//        for (Task s : tasks) {
//            System.out.println("getall " + s);
//        }
        long userId = 2;
        System.out.println("-------------------------------");
        List<Task> task1 = Dao.getDao().task.getAll(String.format(" WHERE `Users_id`='%d'", userId));
        for (Task c : task1) {
            System.out.println("All tasks from uers" + userId + c);
        }




        System.out.println("\n" + "+-+-+-+-+-+-+-+ dao+-+-+-+-+-+-+-+");


    }
}
