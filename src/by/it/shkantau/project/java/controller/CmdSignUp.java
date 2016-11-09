package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.Role;
import by.it.shkantau.project.java.beans.User;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equals("POST")) {
            User user = new User();
            user.setId(0);
            try {
                user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
                user.setEmail(Form.getString(request, "email", Patterns.EMAIL));
                if (!Form.getString(request, "pass", Patterns.PASSWORD).equals(Form.getString(request, "passConfirm", Patterns.PASSWORD))){
                    throw  new IllegalArgumentException("Passwords don't match");
                }
                user.setPass(Form.getString(request, "pass", Patterns.PASSWORD));
                user.setRole(Role.USER_ROLE);

            } catch (Exception e) {
                request.setAttribute(AttrMessages.msgError, "Invalid field format. " + e.toString());
                return null;
            }

            //пароль. тут проблема безопасности.
            // нужно "солить" и хешировать.

            //проверим поля (добавьте паттерны самостоятельно)
            DAO dao = DAO.getDAO();
            if (dao.userDAO.create(user) > 0) {
                request.setAttribute(AttrMessages.msgMessage, "New user is created. Input new user login and password.");
//                return Actions.SIGNUP.action;
            } else {
                request.setAttribute(AttrMessages.msgError, "User does not created. Create new user again. " + dao.userDAO.lastSQL);
            }
            return  Actions.INDEX.action;
        }
//        else {
//            SessionAttrSesHelper.setRolesToAttribute(request);
//        }

        return null;
    }
}