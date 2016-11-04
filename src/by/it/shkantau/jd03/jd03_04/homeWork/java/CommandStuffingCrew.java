package by.it.shkantau.jd03.jd03_04.homeWork.java;

import javax.servlet.http.HttpServletRequest;


public class CommandStuffingCrew implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.STUFFINGCREW.okPage;
    }
}
