package by.it.akhmelev.project.java.controller;


import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action {

    String outListUsers(List<User> users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.toString()).append("<br>");
        }
        return sb.toString();
    }

    @Override
    Action execute(HttpServletRequest req) {
        //auth????
        DAO dao = DAO.getDAO();
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", "<hr>"+outListUsers(users)+"<hr>");
        return null;
    }
}
