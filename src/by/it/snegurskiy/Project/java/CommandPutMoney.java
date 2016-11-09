package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Account;
import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandPutMoney extends Action {
    @Override
    Action execute(HttpServletRequest req) {



        Users user = (Users) req.getSession().getAttribute("user");
        if (user == null) return Actions.LOGIN.action;
        DAO dao = DAO.getDAO();

        req.setAttribute("users", dao.user.getAll(String.format("where ID=%d", user.getID())));
        req.setAttribute("accounts", dao.account.getAll(String.format("where FK_users=%d", user.getID())));
        if (req.getParameter("button5") != null) {
            int putsum = Integer.parseInt(req.getParameter("putsum"));
            int putfrom = Integer.parseInt(req.getParameter("putfrom"));
            Account accPutFROM = dao.account.read(putfrom);
            if (accPutFROM!=null){
                    accPutFROM.setBalance(accPutFROM.getBalance() + putsum);
                    dao.account.update(accPutFROM);

                    req.setAttribute(Messages.msgMessage, "деньги переведены");

                    return Actions.MAINUSER.action;
                }

        }


        return Actions.PUTMONEY.action;
    }

}
