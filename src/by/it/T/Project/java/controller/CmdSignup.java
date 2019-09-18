package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.controller.SiteExpression;
import by.it.kruglenja.Project.java.dao.Dao;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignup implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws SQLException, SiteExpression {
        if (by.it.kruglenja.Project.java.controller.Form.isPost(req)) {
            String login = by.it.kruglenja.Project.java.controller.Form.getString(req, "login");
            String password = by.it.kruglenja.Project.java.controller.Form.getString(req, "password", "[а-яa-zA-Z0-9_-]{6,}");
            String passwordValidation = by.it.kruglenja.Project.java.controller.Form.getString(req, "passwordValidation", "[а-яa-zA-Z0-9_-]{6,}");
            if (!password.equals(passwordValidation)){
                req.getSession().setAttribute("message", "Подтверждение не совпадает с паролем!");
                return by.it.kruglenja.Project.java.controller.Action.SIGNUP;
            }
            String email = by.it.kruglenja.Project.java.controller.Form.getString(req, "email");
            String phone_number = Form.getString(req, "phone_number");

            User user = new User(0, login, password, email, phone_number, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("sesionUserId", user.getId());

            return by.it.kruglenja.Project.java.controller.Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
