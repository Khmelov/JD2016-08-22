package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Persons persons = new Persons();
        if (Form.isPost(req)) {
            try {
                persons.setFirstName(Form.getString(req, "FirstName", Patterns.FIRSTNAME));
                persons.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            List<Persons> personss = dao.persons.getAll(
                    String.format("where FirstName='%s' and Email='%s'",
                            persons.getFirstName(),
                            persons.getEmail()
                    ));
            if (personss.size() > 0) {
                persons = personss.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("persons", persons);
                return Actions.PROFILE.action;
            }
            req.setAttribute(Messages.msgError, "NO SUCH USER");
        }
        return null;
    }
}
