package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Status;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateStatus extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        Status status = new Status();

        if (Form.isPost(req)) {
            try {
                status.setID(0);
                status.setFK_orders(Form.getInt(req,"FK_orders"));
                status.setOrderStatus(Form.getString(req,"OrderStatus",Patterns.ORDERSTATUS));

            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.status.create(status)) {
                req.setAttribute(Messages.msgMessage, "STATUS ADDED");
                return Actions.SHOWSTATUS.action;
            } else
                req.setAttribute(Messages.msgError, "FILL ERROR");
        }
        return null;
    }
}
