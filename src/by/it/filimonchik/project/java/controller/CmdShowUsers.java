package by.it.filimonchik.project.java.controller;

import by.it.filimonchik.project.java.bean.User;
import by.it.filimonchik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action {

    @Override
    Action execute(HttpServletRequest req) {

        DAO dao = DAO.getDAO();
        List<User> usersList =dao.user.getAll("");

        req.setAttribute("usersList", usersList);

        return null;
    }
}