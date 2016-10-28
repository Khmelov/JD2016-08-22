package by.it.grechishnikov.project.webapp.command;

import by.it.grechishnikov.project.webapp.ServletController;
import by.it.grechishnikov.project.webapp.bean.User;
import by.it.grechishnikov.project.webapp.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Level;

public class SignUpCommand implements Command {
    private static UsersDAO dao = DAO.getInstance().getUsersDAO();

    public String execute(HttpServletRequest req) {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        String email = req.getParameter("Email");
        //Проверка на валидацию
        if(login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX) && email.matches(EMAIL_REGEX)) {
            ServletController.logger.log(Level.INFO, "\n****DATA VALID: Login = " + login + ", Password = " + password +
                    ", Email = " + email + "****");
            //Если такого пользователя не существует и имэйл не занят, то регистрируем
            if(!checkUserExist(login, email)) {
                User user = new User(login, password, email, 2);
                ServletController.logger.log(Level.INFO, "\n****CREATE USER: " + user.toString() + "****\n");
                dao.create(user);
                return "goToLogin";
            }

        }
        return "goToSignUp";
    }

    private static boolean checkUserExist(String login, String email) {
        List<User> users = dao.getAll();
        for (User u : users) {
            if (u.getLogin().equals(login) || u.getEmail().equals(email)) {
                ServletController.logger.log(Level.INFO, "\n****USER OR EMAIL EXIST = " + u.toString() + "****");
                return true;
            }
        }
        return false;
    }
}
