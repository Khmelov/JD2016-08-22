package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.User;
import by.it.voronovich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;

        if (request.getParameter("Password") == null) {
            return page;
        }
        String password=request.getParameter("Password");   //пароль
        String login=request.getParameter("Login");   //логин

        if (FormHelper.valid(password) && FormHelper.valid(login)) {
            DAO dao = DAO.getDAO();
            List<User> users=dao.user.getAll(
                    String.format("where Login='%s' and Password='%s'",login,password));
        User user=null;
        if (users.size()>0) {
            user=users.get(0);
        }
        if (user==null) {
            request.setAttribute(
                    Action.msgMessage,
                    "Неверные данные, повторите ввод.");
            page = Action.LOGIN.inPage;
            } else {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(60*15);
            session.setAttribute("user",user);
            request.setAttribute(
                    Action.msgMessage,
                    "Добро пожаловать, "+user.getName());
            page = Action.LOGIN.okPage;
            }
        }
        return page;
    }
}