package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.User;
import by.it.voronovich.project.java.dao.DAO;
import by.it.voronovich.project.java.dao.UserDAO;
import by.it.voronovich.project.java.patterns.Patterns;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CommandAdminCab implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.ADMINCAB.inPage;

        List<User> userList = new UserDAO().getAll("");
        if (!userList.isEmpty()) {
            request.setAttribute("userList", userList);
        }
        DAO dao=DAO.getDAO();
        if (FormHelper.isPost(request)){
            User user=new User();
            try {
                user.setIdUsers(FormHelper.getInt(request,"idUsers"));
                user.setName(FormHelper.getString(request, "Name", Patterns.NAME));
                user.setSurname(FormHelper.getString(request, "Surname", Patterns.SURNAME));
                user.setLogin(FormHelper.getString(request, "Login", Patterns.LOGIN));
                user.setPassword(FormHelper.getString(request, "Password", Patterns.PASSWORD));
                user.setEmail(FormHelper.getString(request, "Email", Patterns.EMAIL));
                user.setFK_Role(FormHelper.getInt(request,"FK_Role"));
                if (user.getIdUsers()>0){
                    if(dao.user.update(user)) {
                        request.setAttribute(Action.msgMessage, "Изменения приняты");
                        page = Action.ADMINCAB.okPage;
                    }
                }
                if (user.getIdUsers()<0){
                    user.setIdUsers(user.getIdUsers()*(-1));
                    if(dao.user.delete(user)){
                        request.setAttribute(Action.msgMessage, "Пользователь удален");
                        page = Action.ADMINCAB.okPage;
                    }
                }
                if (user.getIdUsers()==0){
                    if(dao.user.create(user)){
                        request.setAttribute(Action.msgMessage, "Пользователь создан");
                        page = Action.ADMINCAB.okPage;
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute(Action.msgMessage,"Ошибка!!!");
            }
        }
        request.setAttribute("users",dao.user.getAll(""));
        return page;
    }
}
