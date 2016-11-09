package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.Role;
import by.it.prymshyts.jd03.project.java.beans.User;
import by.it.prymshyts.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CommandShowUsers implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        DAO dao = DAO.getDAO();

        if (FormHelper.isPost(request)) {
            User user = new User();

            try {
                user.setID(FormHelper.getInt(request, "ID"));
                user.setLogin(FormHelper.getString(request, "Login", Patterns.LOGIN));
                user.setPassword(FormHelper.getString(request, "Password", Patterns.PASSWORD));
                user.setMail(FormHelper.getString(request, "Email", Patterns.EMAIL));
                user.setFK_Role(FormHelper.getInt(request, "FK_Role"));
                request.setAttribute(Action.msgMessage, user);

                if (user.getID() > 0){
                    dao.getUserDAO().update(user);
                }
                if (user.getID() < 0){
                    user.setID(user.getID() * (-1));
                    dao.getUserDAO().delete(user);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute(Action.msgError, "Ошибка!");
            }
        }

        List<User> userList = dao.getUserDAO().getAll();
        List<Role> roleList = dao.getRoleDAO().getAll();
        request.setAttribute("users", userList);
        request.setAttribute("roles", roleList);

        return Action.SHOWUSERS.inPage;
    }
}