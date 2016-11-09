package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

import static by.it.snegurskiy.Project.java.Form.*;

class CommandMainAdmin extends Action{

    private String debugOut(List<Users> users) {
        StringBuilder out=new StringBuilder();
        for (Users user:users){
            out.append(user.toString()).append("<br>");
        }
        return out.toString();
    }

    @Override
    public Action execute(HttpServletRequest req) throws ParseException {

        DAO dao=DAO.getDAO();
        req.setAttribute("users", dao.user.getAll(""));
        req.setAttribute("roles",dao.role.getAll(""));
        req.setAttribute("statuses",dao.status.getAll(""));
        if (Form.isPost(req)){
            Users user=new Users();
            try {
                user.setID(Form.getInt(req,"ID"));
                user.setSurname(Form.getString(req, "Surname", Patterns.NAME));
                user.setName(Form.getString(req, "Name", Patterns.NAME));
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                user.setFK_Role(Form.getInt(req,"FK_Role"));
                user.setFK_Status(Form.getInt(req,"FK_Status"));
                req.setAttribute(Messages.msgMessage,user);
                if (user.getID()<0){
                    user.setID(user.getID()*(-1));
                    if (user.getFK_Status()==1) user.setFK_Status(2);
                    else user.setFK_Status(1);
                    dao.user.update(user);
                }


            } catch (ParseException e) {
                e.printStackTrace();
                req.setAttribute(Messages.msgMessage,"Ошибка!!");
            }
        }

        return null;
    }
}
