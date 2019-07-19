package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.controller.Util;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdProfile implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws SQLException {
        if (!Util.checkUser(req)) {
            return by.it.kruglenja.Project.java.controller.Action.LOGIN;
        }
        if (Form.isPost(req)) {
//            Dao dao = Dao.getDao();
//            User user = (User) req.getSession().getAttribute("user");
//            user.setEmail("123");
//            user.setPhone_number("123");
//            user.setPassword("123");
//            if (dao.user.update(user))
//                return Action.PROFILE;
        }
        return Action.PROFILE;
    }
}
