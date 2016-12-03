package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.beans.Diagnostic;
import by.it.zaharova.project.java.beans.Doctors;
import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Actions.LOGIN.action;
        }

        return null;
    }
}
