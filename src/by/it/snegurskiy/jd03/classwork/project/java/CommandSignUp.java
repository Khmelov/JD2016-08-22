package by.it.snegurskiy.jd03.classwork.project.java;



import by.it.snegurskiy.jd03.classwork.project.java.Bean.Users;
import by.it.snegurskiy.jd03.classwork.project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.SIGNUP.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Login") == null) {
            return page;
        }

        Users user = new Users();
        user.setID(0);
        //добавляем пользователей
//        int fkUser = Integer.parseInt(request.getParameter("FK_role"));
//        user.setFK_Role(fkUser);
        user.setFK_Role(2);
        user.setSurname(request.getParameter("Surname"));
        user.setName(request.getParameter("Name"));
        user.setLogin(request.getParameter("Login"));   //логин
        user.setPassword(request.getParameter("Password"));
        //пароль. тут проблема безопасности.
        // нужно "солить" и хешировать.

        //проверим поля (добавьте паттерны самостоятельно)
        if (FormHelper.valid(user.getLogin()) &&
                FormHelper.valid(user.getPassword())
                ) {
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                request.setAttribute(
                        Action.message,
                        "Пользователь создан. Введите данные для авторизации.");
                page = Action.SIGNUP.okPage;
            }
//            else {
//                request.setAttribute(
//                        Action.msgMessage,
//                        "Пользователь НЕ создан. Введите данные заново. " + dao.user.lastSQL);
//                page = Action.SIGNUP.inPage;
//            }
        }
        return page;
    }
}