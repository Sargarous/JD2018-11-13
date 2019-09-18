package by.it.kruglenja.TaskManager.controller;

import by.it.kruglenja.TaskManager.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();

        return null;
    }
}
