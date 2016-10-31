package by.it.snegurskiy.jd03.classwork.project.java;


import by.it.snegurskiy.jd03.classwork.project.java.Bean.Users;
import by.it.snegurskiy.jd03.classwork.project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.System.out;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        String page;

       // проверим отправлены ли данные из формы, если нет, то покажем форму
//        if (request.getParameter("Login") == null) {
//            return page;
//        }
        String password=request.getParameter("Password");   //пароль
        String login=request.getParameter("Login");   //логин

        //if (FormHelper.valid(password) && FormHelper.valid(login)) {
        DAO dao = DAO.getDAO();
            List<Users> users=dao.user.getAll(
                    String.format("where Login='%s' and Password='%s'",login,password));

        Users user=null;
        if (users.size()>0) {
            user=users.get(0);
        }
        if (user==null) {
            request.setAttribute(
                    Action.msgError,
                    "Неверные данные повторите ввод.");
            page = Action.LOGIN.inPage;
            } else {
            request.setAttribute(
                    Action.message,
                    "Добро пожаловать, "+user.getLogin());
            page = Action.LOGIN.okPage;
            }

        return page;
    }
}