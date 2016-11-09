package by.it.kisel.project.java.old_demo;

import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.SIGNUP.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Email") == null) {
            return page;
        }

        Persons persons = new Persons();
        persons.setID(0);
        //добавляем пользователей и администраторов, но это демо!!!
        int fkPersons = Integer.parseInt(request.getParameter("FK_role"));
        persons.setFK_role(fkPersons);

        persons.setEmail(request.getParameter("Email"));   //почта
        persons.setFirstName(request.getParameter("Login"));   //логин
        //пароль. тут проблема безопасности.
        // нужно "солить" и хешировать.

        //проверим поля (добавьте паттерны самостоятельно)
        if (FormHelper.valid(persons.getEmail()) &&
                FormHelper.valid(persons.getFirstName()) &&
                FormHelper.valid(persons.getEmail())
                ) {
            DAO dao = DAO.getDAO();
            if (dao.persons.create(persons)) {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь создан. Введите данные для авторизации.");
                page = Action.SIGNUP.okPage;
            } else {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь НЕ создан. Введите данные заново. " + dao.persons.lastSQL);
                page = Action.SIGNUP.inPage;
            }
        }
        return page;
    }
}