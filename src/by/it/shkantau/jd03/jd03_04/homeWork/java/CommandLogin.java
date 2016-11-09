package by.it.shkantau.jd03.jd03_04.homeWork.java;

import javax.servlet.http.HttpServletRequest;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //DO SOMETHING;
        //USE DAO
        //&ETC
        return Action.LOGIN.inPage;
    }
}