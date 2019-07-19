package by.it.T.Project.java.controller;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex  implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
    public by.it.kruglenja.Project.java.controller.Action execute(HttpServletRequest req)throws SQLException {
        Dao dao = Dao.getDao();
        List<Spareparts> catalog = dao.spareparts.getAll();
        req.getSession().setAttribute("catalog", catalog);
        return Action.INDEX;
    }
}