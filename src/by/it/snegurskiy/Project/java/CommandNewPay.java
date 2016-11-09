package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Account;
import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public class CommandNewPay extends Action {

    @Override
    Action execute(HttpServletRequest req) {



        Users user = (Users) req.getSession().getAttribute("user");
        if (user == null) return Actions.LOGIN.action;
        DAO dao = DAO.getDAO();

        req.setAttribute("users", dao.user.getAll(String.format("where ID=%d", user.getID())));
        req.setAttribute("accounts", dao.account.getAll(String.format("where FK_users=%d", user.getID())));
        if (req.getParameter("button3") != null) {
            int in = Integer.parseInt(req.getParameter("in"));
            int sum=0;
            sum = Integer.parseInt(req.getParameter("sum"));
            int from = Integer.parseInt(req.getParameter("from"));
            Account accIN = dao.account.read(in);
            Account accFROM = dao.account.read(from);
            if (accFROM!=null&&accIN!=null&&accIN.getID()!=accFROM.getID()){
                if (accIN.getBalance() < sum) {
                req.setAttribute(Messages.msgError, "недостаточно средств");
                return null;
                }
                if (accIN.getBalance() >= sum) {
                accIN.setBalance(accIN.getBalance() - sum);
                accFROM.setBalance(accFROM.getBalance() + sum);
                    dao.account.update(accIN);
                    dao.account.update(accFROM);

                req.setAttribute(Messages.msgMessage, "платеж совершен");

                return Actions.MAINUSER.action;
                }
            } else req.setAttribute(Messages.msgError, "не верные счета"); return null;
        }


            return Actions.NEWPAY.action;
        }

    }

