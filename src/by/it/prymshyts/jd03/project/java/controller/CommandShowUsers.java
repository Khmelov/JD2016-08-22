package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.Role;
import by.it.prymshyts.jd03.project.java.beans.User;
import by.it.prymshyts.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandShowUsers implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        DAO dao = DAO.getDAO();

        List<User> userList = dao.getUserDAO().getAll();
        List<Role> roleList = dao.getRoleDAO().getAll();
        request.setAttribute("users", userList);
        request.setAttribute("roles", roleList);
        return Action.SHOWUSERS.inPage;
    }
}