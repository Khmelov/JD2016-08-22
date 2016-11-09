package by.it.kisel.project.java.old_demo;

import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Email") == null) {
            return page;
        }
        String email=request.getParameter("Email");
        String firstName=request.getParameter("FirstName");

        if (FormHelper.valid(email) && FormHelper.valid(firstName)) {
            DAO dao = DAO.getDAO();
            List<Persons> personss=dao.persons.getAll(
                    String.format("where FirstName='%s' and Login='%s'",firstName,email));
        Persons persons=null;
        if (personss.size()>0) {
            persons=personss.get(0);
        }
        if (persons==null) {
            request.setAttribute(
                    Action.msgMessage,
                    "Неверные данные повторите ввод.");
            page = Action.LOGIN.inPage;
            } else {
            request.setAttribute(
                    Action.msgMessage,
                    "Добро пожаловать, "+persons.getFirstName());
            page = Action.LOGIN.okPage;
            }
        }
        return page;
    }
}