package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdShowUsers extends Action{

    private String debugOut(List<User> users) {
            StringBuilder out=new StringBuilder();
            for (User user:users){
                out.append(user.toString()).append("<br>");
            }
            return out.toString();
        }

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        req.setAttribute("users",dao.user.getAll(""));
        req.setAttribute("roles",dao.role.getAll(""));
        return null;
    }
}
