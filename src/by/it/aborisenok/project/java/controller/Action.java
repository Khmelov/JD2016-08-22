package by.it.aborisenok.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 01.11.2016.
 */
abstract public class Action {
        abstract Action execute(HttpServletRequest reg);

        @Override
        public String toString() {
                String name=this.getClass().getSimpleName();
                name=name.replace("Cmd","");
                return name;
        }

        public String getJsp(){
                String name = this.toString().toLowerCase();
                return "/"+name+".jsp";
        }
}
