package by.it.seroglazov.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't find jdbc.Driver class: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = ActionDefiner.define(req);
        Action next = action.cmd.execute(req);
        if (next == null || next == action) {
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.getJsp());
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            resp.setDateHeader("Expires", 0); // Proxies.
            requestDispatcher.forward(req, resp);
        }
        else resp.sendRedirect("do?command=" + next.toString().toLowerCase());
    }


}