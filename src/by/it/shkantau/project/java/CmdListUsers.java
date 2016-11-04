package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.Role;
import by.it.shkantau.project.java.beans.User;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdListUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        // here must placed authorization

        HttpSession session = request.getSession();
        Object o = session.getAttribute("roles");
        if (o != null) {
            if (o instanceof List) {
                List<Role> roles = (List<Role>) o;
            } else {
                DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
                List<Role> roles=dao.roleDAO.getAll("");
                session.setAttribute("roles", roles);
            }
        }


        DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
        List<User> users=dao.userDAO.getAll("");

            if (users==null) {
                request.setAttribute( AttrMessages.msgError,"Wrong data." + dao.userDAO.lastSQL);
                return  null;
            } else {
                request.setAttribute(AttrMessages.msgMessage,"Read usersCount=" + users.size());
                request.setAttribute("users", users);
                return null;
            }
    }
}
