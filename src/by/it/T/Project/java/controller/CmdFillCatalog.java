package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.controller.Form;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdFillCatalog implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req) throws Exception {
//        if (!Util.checkAdmin(req)){
//            return Action.LOGIN;
//        }
        if (by.it.kruglenja.Project.java.controller.Form.isPost(req)){
             String model = by.it.kruglenja.Project.java.controller.Form.getString(req, "selectModel");
             String category = by.it.kruglenja.Project.java.controller.Form.getString(req, "selectCategory");
             String name = by.it.kruglenja.Project.java.controller.Form.getString(req, "partName");
             String serial_number = by.it.kruglenja.Project.java.controller.Form.getString(req, "serialNumber");
             double weight = by.it.kruglenja.Project.java.controller.Form.getDouble(req, "weigth");
             double price = by.it.kruglenja.Project.java.controller.Form.getDouble(req, "price");
             int storageQuanity = Form.getInteger(req, "storageQuanity");

            Spareparts spareparts = new Spareparts(0, model,category, name, serial_number, weight, price, storageQuanity );
            Dao dao = Dao.getDao();
            if (dao.spareparts.create(spareparts))
                return by.it.kruglenja.Project.java.controller.Action.FILLCATALOG;
        }
        return Action.FILLCATALOG;
    }
}
