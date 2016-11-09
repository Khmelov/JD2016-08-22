package by.it.kisel.project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract public class Action {
    abstract Action execute(HttpServletRequest reg);

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
