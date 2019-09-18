package by.it.kruglenja.TaskManager.controller;

import javax.servlet.http.HttpServletRequest;

interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;
}
