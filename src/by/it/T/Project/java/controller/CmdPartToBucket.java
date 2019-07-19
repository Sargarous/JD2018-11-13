package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdPartToBucket implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws Exception {
        if (by.it.kruglenja.Project.java.controller.Form.isPost(req)) {
            Dao dao = Dao.getDao();
            Long sparepartsId = by.it.kruglenja.Project.java.controller.Form.getLong(req, "iD");
            long id = (long) req.getSession().getAttribute("sesionUserId");
            List<Order> orderCheck = dao.order.getAll(String.format(" WHERE users_id='%d'", id) );
            for (Order order : orderCheck) {
                if (order.getSpareParts_id()==sparepartsId) {
                    String message = "Такой товар уже есть в корзине";
                    req.setAttribute("message", message);
                    return by.it.kruglenja.Project.java.controller.Action.INDEX;
                }
            }
            int quanity = by.it.kruglenja.Project.java.controller.Form.getInteger(req, "quanity");
            String name = by.it.kruglenja.Project.java.controller.Form.getString(req, "name");
            String model = by.it.kruglenja.Project.java.controller.Form.getString(req, "model");
            double price = Form.getDouble(req, "price");
            long userId = (long) req.getSession().getAttribute("sesionUserId");
            Order order = new Order(0, quanity, model, name, price, sparepartsId, userId);
            if (dao.order.create(order))
                return by.it.kruglenja.Project.java.controller.Action.INDEX;
        }
        return Action.ERROR;
    }
}

