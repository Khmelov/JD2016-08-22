package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.voronovich.project.java.hash.HashCookie.sha256;

@WebServlet("/do2")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        //выставим в сообщение данные из формы (для отладки)
        //request.setAttribute(Action.msgMessage, FormHelper.strDebugForm(request));

        ActionFactory client = new ActionFactory(); // определение команды, пришедшей из JSP
        ActionCommand command = client.defineCommand(request);

        //вызов реализованного метода execute() и передача параметров
        //классу-обработчику конкретной команды. Обработчик должен вернуть адрес view
        String viewPage = command.execute(request);

        response.setHeader("Cache-Control", "no-store");

        //Создадим куки для логина и пароля, пароль захешируем
        User user = (User) request.getSession(true).getAttribute("user");
        if (user != null) {
            Cookie cookieLogin = new Cookie("Login", user.getLogin());
            cookieLogin.setMaxAge(24 * 60 * 60);
            response.addCookie(cookieLogin);

            //Захешируем пароль пользователя через sha256
            Cookie cookiePassword = new Cookie("Password", sha256(user.getPassword()));
            cookiePassword.setMaxAge(24 * 60 * 60);
            response.addCookie(cookiePassword);
        }

        //метод отправляет пользователю страницу ответа
        if (viewPage != null) {
            ServletContext servletContext=getServletContext();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewPage);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
            //можно короче:
            //getServletContext().getRequestDispatcher(viewPage).forward(request,response);
        } else {
            // установка страницы c cообщением об ошибке
            viewPage = Action.ERROR.inPage;
            response.sendRedirect(request.getContextPath() + viewPage);
        }
    }
}