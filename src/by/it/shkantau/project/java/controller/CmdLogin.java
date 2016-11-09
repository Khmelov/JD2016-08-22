package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.User;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equalsIgnoreCase("POST")) {
            User user = new User();
            try {
                user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
                user.setPass(Form.getString(request, "pass", Patterns.PASSWORD));

                DAO dao = DAO.getDAO();
                List<User> userList = dao.userDAO.getAll(String.format("WHERE login='%s' AND pass='%s'", user.getLogin(), user.getPass()));
                if (userList.size() > 0) {
                    request.setAttribute(AttrMessages.msgMessage, "User login - OK ");

                    addUserToSessionCookie(userList.get(0), request, response);

                    return Actions.INDEX.action;
                } else {
                    throw new IllegalArgumentException("Wrong login or password");
                }
            } catch (Exception e) {
                request.setAttribute(AttrMessages.msgError, "Invalid field format. " + e.toString());
            }
        }
        return  null;
    }

    private void addUserToSessionCookie(User user, HttpServletRequest request, HttpServletResponse response){
//        Save user to Cookies
        Cookie cookie = new Cookie("uid", ""+user.hashCode());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
//        Save user to Session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

    }
}