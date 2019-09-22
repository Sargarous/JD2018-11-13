package by.it.kruglenja.TaskManager.java.controller;

import by.it.kruglenja.TaskManager.java.beans.User;
import by.it.kruglenja.TaskManager.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)){
            String login = Form.getString(req, "login");
            String userPassword = Form.getString(req, "userPassword", "[a-zA-Z0-9]{4,}");
            String passwordValidation = Form.getString(req, "passwordValidation");
            if (!userPassword.equals(passwordValidation)){
                req.getSession().setAttribute("message", "Пароль не совпадает");
                return Action.SIGNUP;
            }
            String userEmail = Form.getString(req, "userEmail");

            User user = new User();
            user.setlogin(login);
            user.setUserPassword(userPassword);
            user.setUserEmail(userEmail);
            user.setRoles_id(3);

            if (Dao.getDao().user.create(user)){
                req.setAttribute("message", "Регистрация прошла успешно, войдите под своей учетной записью");
                req.setAttribute("message", "");
                return Action.INDEX;

            }
        }

        return Action.SIGNUP;
    }
}
