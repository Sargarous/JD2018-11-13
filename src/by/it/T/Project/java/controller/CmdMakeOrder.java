package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.CompletedOrder;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;


public class CmdMakeOrder implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws Exception {
        if (by.it.kruglenja.Project.java.controller.Form.isPost(req)) {
            Dao dao = Dao.getDao();
            String address = by.it.kruglenja.Project.java.controller.Form.getString(req, "address");
            String info = Form.getString(req, "info");
            double totalPrice = 223;
            long user_id = (long) req.getSession().getAttribute("sesionUserId");

            CompletedOrder co = new CompletedOrder(0, address, info, totalPrice, user_id);
            if (dao.completedOrder.create(co)) {
                String message = "Заказ успешно оформлен";
                req.setAttribute("message", message);
                return by.it.kruglenja.Project.java.controller.Action.ORDER;

            }
        }
        return Action.ORDER;
    }
}
