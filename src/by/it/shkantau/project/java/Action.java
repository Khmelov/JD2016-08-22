package by.it.shkantau.project.java;

import javax.servlet.http.HttpServletRequest;

abstract public class Action {
    abstract Action execute(HttpServletRequest request);

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
