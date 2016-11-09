package by.it.grechishnikov.project.webapp.java.command;

import by.it.grechishnikov.project.webapp.java.bean.User;
import by.it.grechishnikov.project.webapp.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class SignUpCommand implements Command {
    private static UsersDAO dao = DAO.getInstance().getUsersDAO();

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        String email = req.getParameter("Email");
        //Проверка на валидацию
        if(login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX) && email.matches(EMAIL_REGEX)) {
            //Если такого пользователя не существует и имэйл не занят, то регистрируем
            if(!checkUserExist(login, email)) {
                User user = new User(login, password, email, 2);
                dao.create(user);
                return Commands.GO_TO_LOGIN.message;
            }

        }
        return Commands.GO_TO_SIGN_UP.message;
    }

    private static boolean checkUserExist(String login, String email) {
        List<User> users = dao.getAll();
        for (User u : users) {
            if (u.getLogin().equals(login) || u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
