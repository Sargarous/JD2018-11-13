package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdDelete  implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req)throws SQLException {
        Dao.getDao().delete();
        req.getSession().setAttribute("message", "База данных удалена!");
        return Action.ERROR;
    }
}
