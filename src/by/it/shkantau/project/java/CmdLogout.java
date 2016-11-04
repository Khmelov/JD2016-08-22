package by.it.shkantau.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CmdLogout extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (request.getMethod().equalsIgnoreCase("post")){
            request.removeAttribute("user");
            session.invalidate();
            return Actions.LOGIN.action;
        }

//        Object o = session.getAttribute("user");
//
//        if (o instanceof User){
//            request.setAttribute(AttrMessages.msgMessage, "OK login="+((User) o).getLogin());
//            return null;
//        }
//        return Actions.LOGIN.action;
        return null;
    }
}
