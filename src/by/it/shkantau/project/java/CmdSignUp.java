package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.User;
import by.it.shkantau.project.java.dao.DAO;



import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        if (request.getMethod().equals("POST")) {
            User user = new User();
            user.setId(0);
            try {
                user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
                user.setEmail(Form.getString(request, "email", Patterns.EMAIL));
                user.setPass(Form.getString(request, "pass", Patterns.PASSWORD));
                user.setRole(Integer.parseInt(request.getParameter("role")));

            } catch (Exception e) {
                request.setAttribute(AttrMessages.msgError, "Invalid field format. " + e.toString());
                return null;
            }

            //пароль. тут проблема безопасности.
            // нужно "солить" и хешировать.

            //проверим поля (добавьте паттерны самостоятельно)
            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            if (dao.userDAO.create(user) > 0) {
                request.setAttribute(AttrMessages.msgMessage, "New user is created. Input new user login and password.");
//                return Actions.SIGNUP.action;
            } else {
                request.setAttribute(AttrMessages.msgError, "User does not created. Create new user again. " + dao.userDAO.lastSQL);
            }
            return  Actions.INDEX.action;
        }else {

            HttpSessionAttrHelper.updateRole(request);
//            Object o = request.getSession().getAttribute("roles");
//            if (o != null) {
//                if (o instanceof List) {
//                    List<Role> roleList = (List<Role>) o;
//                    request.setAttribute("roles", roleList);
//                    request.getSession().setAttribute("roles",roleList);
//                }
//            }else {
//                DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
//                List<Role> roles = dao.roleDAO.getAll("");
//                request.setAttribute("roles",roles);
//                request.getSession().setAttribute("roles",roles);
//            }

        }

        return null;
    }
}