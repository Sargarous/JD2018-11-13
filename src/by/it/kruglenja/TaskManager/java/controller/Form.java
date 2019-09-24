package by.it.kruglenja.TaskManager.java.controller;



import javax.servlet.http.HttpServletRequest;

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
}
