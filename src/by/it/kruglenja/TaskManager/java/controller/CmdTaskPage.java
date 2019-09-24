package by.it.kruglenja.TaskManager.java.controller;

import by.it.kruglenja.TaskManager.java.beans.Task;
import by.it.kruglenja.TaskManager.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdTaskPage implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        long userId = (long) req.getSession().getAttribute("sessionUserId");
        List<Task> tasks = dao.task.getAll(" WHERE `Users_id`=" + userId);
        System.out.println();
        if (tasks.size() > 0) {
            req.setAttribute("tasksList", tasks);
        } else {
            req.setAttribute("message", "Список задач пуст");
        }
        return Action.TASKPAGE;
    }
}
