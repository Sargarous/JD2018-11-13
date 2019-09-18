package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Roles;
import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.controller.Util;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUser implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
            if (by.it.kruglenja.Project.java.controller.Form.isPost(req)) {

                long id = by.it.kruglenja.Project.java.controller.Form.getLong(req, "id");
                String login = by.it.kruglenja.Project.java.controller.Form.getString(req, "login");
                String password = by.it.kruglenja.Project.java.controller.Form.getString(req, "password");
                String email = by.it.kruglenja.Project.java.controller.Form.getString(req, "email");
                String phone_number = by.it.kruglenja.Project.java.controller.Form.getString(req, "phone_number");
                long roles_Id = Form.getLong(req, "role");

                User user = new User(id, login, password, email, phone_number, roles_Id);
                if (req.getParameter("update") != null) {
                    dao.user.update(user);
                } else if (req.getParameter("delete") != null)
                    dao.user.delete(user);
            }
            List<User> users = dao.user.getAll();
            List<Roles> roles = dao.role.getAll();
            req.setAttribute("users", users);
            req.getSession().setAttribute("roles", roles);
            return by.it.kruglenja.Project.java.controller.Action.EDITUSERS;
        }
        return Action.LOGIN;
    }
}