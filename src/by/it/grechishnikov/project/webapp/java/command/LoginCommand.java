package by.it.grechishnikov.project.webapp.java.command;

import by.it.grechishnikov.project.webapp.java.bean.User;
import by.it.grechishnikov.project.webapp.java.dao.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class LoginCommand implements Command {
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //Если запрос не пост, то редирект на главную
        if(!isPost(req)) {
            return Commands.INDEX.message;
        }
        //Читаем логин и пароль из запроса
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        //Если логин или пароль валидны, то делаем поиск по базе
        if (login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX)) {
            //Если такой пользователь есть, то идем на главную
            if (checkInDB(login, password, req, resp)) {
                return Commands.INDEX.message;
            }
        }
        //Инача делаем редирект
        return "goToLogin";
    }

    private static boolean checkInDB(String login, String password, HttpServletRequest req, HttpServletResponse resp) {
        boolean check = false;
        UsersDAO dao = DAO.getInstance().getUsersDAO();
        List<User> list = dao.getAll();
        for (User user : list) {
            //Если нашли такого пользователя
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                check = true;
                //Создаем сессию
                HttpSession session = req.getSession(true);
                session.setAttribute(user.getLogin(), user);
                //Добавляем в куки логин и пароль
                Cookie cookie = new Cookie("login", login);
                cookie.setMaxAge(30);
                resp.addCookie(cookie);
                cookie = new Cookie("id", String.valueOf(user.getId()));
                cookie.setMaxAge(30);
                resp.addCookie(cookie);
                break;
            }
        }
        return check;
    }

    private static boolean isPost(HttpServletRequest req) {
        String method = req.getMethod();
        return method != null && method.equalsIgnoreCase("post");
    }
}