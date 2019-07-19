package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.controller.Action;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;

}
