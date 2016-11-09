package by.it.opiga.JD03_04.Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Action {
    abstract Action execute(HttpServletRequest reg, HttpServletResponse resp);

    public Action getRedirectAction() {
        return redirectAction;
    }

    public void setRedirectAction(Action redirectAction) {
        this.redirectAction = redirectAction;
    }

    private Action redirectAction;

    @Override
    public String toString() {
        String name=this.getClass().getSimpleName();
        name=name.replace("Cmd","");
        return name;
    }

    public String getJsp(){
        String name=this.toString().toLowerCase();
        return "/"+name+".jsp";
    }



}
