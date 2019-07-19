package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.controller.SiteExpression;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdLogout implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws SQLException, SiteExpression {
        if (by.it.kruglenja.Project.java.controller.Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return by.it.kruglenja.Project.java.controller.Action.LOGIN;
            }
        }
        return Action.PROFILE;
    }
}
