package by.it.kruglenja.TaskManager.java.controller;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Form {
    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteExpression {
        String result = req.getParameter(name);
        if (result.matches(pattern))
            return result;
        throw new SiteExpression("name " + result + " incorrect");
    }

    static String getString(HttpServletRequest req, String name) throws SiteExpression {
        System.out.println(name);
        return getString(req, name, ".*");
    }

    static double getDouble(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Double.parseDouble(str);
    }

    static int getInteger(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }

    static long getLong(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Long.parseLong(str);
    }

    static long getLongById(HttpServletRequest req, String id) {
        String str = req.getParameter(id);
        return Long.parseLong(str);
    }

    static LocalDateTime getDate(HttpServletRequest req, String name) throws ParseException {
        LocalDateTime newDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTimeFromForm = req.getParameter(name);
        try {
            newDate = LocalDateTime.parse(dateTimeFromForm, formatter);
        } catch (DateTimeParseException e) {
            req.setAttribute("message", e);
        }
        return newDate;
    }
}
