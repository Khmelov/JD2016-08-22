package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Account;
import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CommandMainUser extends Action{
    @Override
    Action execute(HttpServletRequest req) {
            Users user=(Users)req.getSession().getAttribute("user");
            DAO dao=DAO.getDAO();
            req.setAttribute("users", dao.user.getAll(String.format("where ID=%d",user.getID())));
            req.setAttribute("accounts",dao.account.getAll(String.format("where FK_users=%d",user.getID())));
            if (req.getParameter("button1") != null) {
                Account account=new Account();
                account.setID(0);
                account.setBalance(0);
                account.setFK_users(user.getID());
                dao.account.create(account);
            }
        if (req.getParameter("button2") != null) {
            return Actions.NEWPAY.action;
        }
        if (req.getParameter("button4") != null) {
            return Actions.PUTMONEY.action;
        }





        return null;
    }
}