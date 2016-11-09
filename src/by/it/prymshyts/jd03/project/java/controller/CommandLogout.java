package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        User user = null;

        if (FormHelper.isPost(request)) {
            session.invalidate();
        } else {
            user = (User) session.getAttribute("user");
        }

        if (user != null) {
            request.setAttribute(Action.msgMessage, "Login ok");
        } else {
            return Action.LOGIN.inPage;
        }

        return Action.LOGOUT.inPage;
    }
}
