package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.controller.Util;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditOrder implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUser(req)) {
            if (by.it.kruglenja.Project.java.controller.Form.isPost(req)) {
                Dao dao = Dao.getDao();
                if (req.getParameter("update") != null) {
                    Long orderId = by.it.kruglenja.Project.java.controller.Form.getLong(req, "update");
                    Order oldOrder = dao.order.read(orderId);
                    oldOrder.setQuanity(by.it.kruglenja.Project.java.controller.Form.getInteger(req, "quanity"));
                    dao.order.update(oldOrder);
                    return by.it.kruglenja.Project.java.controller.Action.ORDER;

                } else if (req.getParameter("delete") != null) {
                    Long orderId = Form.getLong(req, "delete");
                    Order order = dao.order.read(orderId);
                    dao.order.delete(order);
                    return by.it.kruglenja.Project.java.controller.Action.ORDER;
                }
            }
        }
        return Action.LOGIN;
    }
}
