package by.it.kruglenja.TaskManager.java.controller;

import by.it.kruglenja.TaskManager.java.beans.Task;
import by.it.kruglenja.TaskManager.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class CmdTaskCreate implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            long userId = (long) req.getSession().getAttribute("sessionUserId");
            String taskName = Form.getString(req, "taskName");
            String taskDescription = Form.getString(req, "taskDescription");
            LocalDateTime taskStartTime = Form.getDate(req, "taskStartTime");
            LocalDateTime taskRedLine = Form.getDate(req, "taskRedLine");
            LocalDateTime taskDeadLine = Form.getDate(req, "taskDeadLine");
            Task task = new Task();
            task.setTaskName(taskName);
            task.setTaskDescription(taskDescription);
            task.settaskStartTime(taskStartTime);
            task.setTaskRedLine(taskRedLine);
            task.setTaskDeadLine(taskDeadLine);
            task.setUsers_id(userId);
            task.setUsers_Roles_id(3);
            task.setProjectList_id(0);
            task.setProjectList_Users_id(0);
            task.setProjectList_Users_id(3);
            if (Dao.getDao().task.create(task)) {
                req.setAttribute("message", "Задача добавлена");
            } else {
                req.setAttribute("message", "Неверно заполнена форма!");
            }
        }
        return Action.TASKPAGE;
    }
}
