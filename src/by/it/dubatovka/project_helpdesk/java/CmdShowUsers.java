package by.it.dubatovka.project_helpdesk.java;


import by.it.dubatovka.project_helpdesk.java.beans.User;
import by.it.dubatovka.project_helpdesk.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action {

    @Override
    Action execute(HttpServletRequest req) {

      //  String outListUsers (List<Users>)

        DAO dao = DAO.getDAO();
        List<User> usersList =dao.user.getAll("");

        req.setAttribute("usersList", usersList);

        return null;
    }
}
