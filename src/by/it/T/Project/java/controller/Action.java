package by.it.T.Project.java.controller;

import by.it.kruglenja.Project.java.controller.*;
import by.it.kruglenja.Project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;

public enum Action {
    RESET(new CmdReset()),
    DELETE(new CmdDelete()),
    INDEX( new CmdIndex()),
    LOGIN( new CmdLogin()),
    SIGNUP( new CmdSignup()),
    LOGOUT( new CmdLogout()),
    ORDER(new CmdOrder()),
    ERROR(new CmdError()),
    PROFILE(new CmdProfile()),
    PARTTOBUCKET(new CmdPartToBucket()),
    DELETEORDERPART(new DeleteOrderPart()),
    EDITUSERS(new CmdEditUser()),
    EDITORDER(new EditOrder()),
    MAKEORDER(new CmdMakeOrder()),
    COMPLETEDORDER(new CmdCompletedOrder()),
    FILLCATALOG(new CmdFillCatalog());


    by.it.kruglenja.Project.java.controller.Cmd cmd;
    Action(by.it.kruglenja.Project.java.controller.Cmd cmdIndex) {
        this.cmd = cmdIndex;
    }
    String getJsp(){
        return  "/" + this.name().toLowerCase() + ".jsp";
    }

    static Action definer(HttpServletRequest req) {
        String command = req.getParameter("command");
        Action result = Action.INDEX;
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("wrong command");
            }
        }
        return result;
    }
}
