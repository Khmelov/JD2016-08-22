package by.it.dubatovka.project_helpdesk.java;

import by.it.dubatovka.project_helpdesk.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Action {
    @Override
    Action execute(HttpServletRequest req)
    {
        HttpSession session=req.getSession();
        User user =(User)session.getAttribute("user");
        if (user!=null)req.setAttribute(Messages.msgMessage,"Login");

        return null;
    }
}
