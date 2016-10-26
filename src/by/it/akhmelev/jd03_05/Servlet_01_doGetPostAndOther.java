package by.it.akhmelev.jd03_05;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet_01_doGetPostAndOther extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,   HttpServletResponse response) throws ServletException {
    //Действия выполняемые при обращении пользователя к сервлету по Get
    //обращение к super ОТСУТСТВУЕТ!!!
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    //Действия выполняемые при обращении пользователя к сервлету по Post
    //обращение к super ОТСУТСТВУЕТ!!!
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        //а вот тут в service - наоборот, обращение к super обязательно
        //После этого можно писать ваш код.
    }
    //Далее смотрите папку PROJECT
}


