package by.it.shkantau.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class CmdLogout extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if (request.getMethod().equalsIgnoreCase("post")){
            request.removeAttribute("user");
            session.invalidate();
            return Actions.LOGIN.action;
        }
        return null;
    }
}
