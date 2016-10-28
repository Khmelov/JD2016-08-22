package by.it.grechishnikov.project.webapp.command;

import by.it.grechishnikov.project.webapp.ServletController;
import by.it.grechishnikov.project.webapp.bean.User;
import by.it.grechishnikov.project.webapp.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Level;

public class LoginCommand implements Command {
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        //Если логин или пароль валидны, то делаем поиск по базе
        if (login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX)) {
            ServletController.logger.log(Level.INFO, "\n****LOGIN VALID: Login = " + login + ", Password = " + password + "****");
            if (checkInDB(login, password)) {
                return "/index.jsp";
            }
        }
        //Инача делаем редирект
        ServletController.logger.log(Level.WARNING, "\n****LOGIN ERROR: Login = " + login + ", Password = " + password + "****");
        return "goToLogin";
    }

    private static boolean checkInDB(String login, String password) {
        boolean check = false;
        UsersDAO dao = DAO.getInstance().getUsersDAO();
        List<User> list = dao.getAll();
        for (User u : list) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                check = true;
                ServletController.logger.log(Level.INFO, "\n****LOGIN USER = " + u.toString() + "****");
                break;
            }
        }
        return check;
    }
}