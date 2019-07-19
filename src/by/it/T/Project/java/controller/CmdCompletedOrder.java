package by.it.T.Project.java.controller;
import java.util.List;

import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Util;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdCompletedOrder implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
                List<by.it.kruglenja.Project.java.beans.CompletedOrder> co = dao.completedOrder.getAll();
                req.setAttribute("co", co);
                return by.it.kruglenja.Project.java.controller.Action.COMPLETEDORDER;
        }
        return Action.LOGIN;
    }
}
