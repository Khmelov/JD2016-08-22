package by.it.opiga.JD03_04.Project.java.controller;

import by.it.opiga.JD03_04.Project.java.beans.mybeans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Action{
    @Override
    Action execute(HttpServletRequest req,HttpServletResponse resp) {

        HttpSession session=req.getSession();
        User user=null;
        if(!Form.isPost(req))
            user=(User) session.getAttribute("user");
        else {session.invalidate();}





        if (user!=null)
        {req.setAttribute(Messages.msgMessage,"Login OK");
        return null;}
        else return Actions.LOGIN.action;
    }
}
