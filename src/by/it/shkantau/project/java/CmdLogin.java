package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.User;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        if (request.getMethod().equalsIgnoreCase("POST")) {
            User user = new User();
            try {
                user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
                user.setPass(Form.getString(request, "pass", Patterns.PASSWORD));

                DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
                List<User> userList = dao.userDAO.getAll(String.format("WHERE login='%s' AND pass='%s'", user.getLogin(), user.getPass()));
                if (userList.size() > 0) {
                    request.setAttribute(AttrMessages.msgMessage, "User login - OK ");
//                    request.setAttribute("curUser", user.getLogin());
                    HttpSession session = request.getSession();
                    session.setAttribute("user", userList.get(0));
                    return Actions.INDEX.action;
                }
            } catch (Exception e) {
                request.setAttribute(AttrMessages.msgError, "Invalid field format. " + e.toString());
                return null;
            }
        }
        return  Actions.LOGIN.action;
    }
}