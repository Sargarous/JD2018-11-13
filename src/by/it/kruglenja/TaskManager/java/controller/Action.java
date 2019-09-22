package by.it.kruglenja.TaskManager.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum  Action {

    INDEX(new CmdIndex()),
    SIGNIN(new CmdSignUp()),
    TASKPAGE(new CmdTaskPage()),
    TASKCREATE(new CmdTaskCreate()),
    SIGNUP(new CmdSignUp());

    Cmd cmd;
    Action(Cmd cmdIndex) {this.cmd = cmdIndex;}

    String getJsp(){
        return "/" + this.name().toLowerCase() + ".jsp";
    }

    static Action definer(HttpServletRequest req){
        String command = req.getParameter("command");
        Action result = Action.INDEX;
        if (command != null && !command.isEmpty()){
            try {
                result = Action.valueOf(command.toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("wrong command");
            }
        }
        return result;
    }
}
