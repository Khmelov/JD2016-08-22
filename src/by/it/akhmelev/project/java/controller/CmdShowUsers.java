package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
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

        HttpSession session=req.getSession();
        User amd=(User)session.getAttribute("user");
        if (amd==null)
            return Actions.INDEX.action;
        int idRole=amd.getFk_Role();
        if (idRole!=1)
            return Actions.PROFILE.action;
        DAO dao=DAO.getDAO();
        if (Form.isPost(req)){
            User user=new User();
            try {
                user.setId(Form.getInt(req,"ID"));
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                user.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                user.setFk_Role(Form.getInt(req,"fk_Role"));
                req.setAttribute(Messages.msgMessage,user);
                if (user.getId()>0){
                    dao.user.update(user);
                }
                if (user.getId()<0){
                    user.setId(user.getId()*(-1));
                    dao.user.delete(user);
                }
                if (user.getId()==0){
                    dao.user.create(user);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                req.setAttribute(Messages.msgMessage,"Ошибка!!");
            }
        }




        req.setAttribute("users",dao.user.getAll(""));
        req.setAttribute("roles",dao.role.getAll(""));
        return null;
    }
}
