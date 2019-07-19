package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.controller.Action;
import by.it.kruglenja.Project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdError implements by.it.kruglenja.Project.java.controller.Cmd {
    @Override
   public Action execute(HttpServletRequest req)throws SQLException {
        return null;
    }
}
