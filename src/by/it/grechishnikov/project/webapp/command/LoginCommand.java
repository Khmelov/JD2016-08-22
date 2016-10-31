package by.it.grechishnikov.project.webapp.command;

import by.it.grechishnikov.project.webapp.ServletController;
import by.it.grechishnikov.project.webapp.bean.User;
import by.it.grechishnikov.project.webapp.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class LoginCommand implements Command {
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        //Если логин или пароль валидны, то делаем поиск по базе
        if (login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX)) {
            ServletController.logger.log(Level.INFO, "\n****LOGIN VALID: Login = " + login + ", Password = " + password + "****");
            if (checkInDB(login, password, req, resp)) {
                return Commands.INDEX.message;
            }
        }
        //Инача делаем редирект
        ServletController.logger.log(Level.WARNING, "\n****LOGIN ERROR: Login = " + login + ", Password = " + password + "****");
        return "goToLogin";
    }

    private static boolean checkInDB(String login, String password, HttpServletRequest req, HttpServletResponse resp) {
        boolean check = false;
        UsersDAO dao = DAO.getInstance().getUsersDAO();
        List<User> list = dao.getAll();
        for (User user : list) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                check = true;
                ServletController.logger.log(Level.INFO, "\n****LOGIN USER = " + user.toString() + "****");
                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);
                Cookie cookie = new Cookie("login", login);
                cookie.setMaxAge(30);
                resp.addCookie(cookie);
                break;
            }
        }
        return check;
    }
}