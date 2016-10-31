package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CmdProfile extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        HttpSession session=req.getSession();
        User user=null;
        if (!Form.isPost(req)) {
            user=(User)session.getAttribute("user");
        }
        else
        session.invalidate();
        if (user!=null) {
            req.setAttribute(Messages.msgMessage,"Login OK");
            return null;}
        return Actions.LOGIN.action;
    }
}
