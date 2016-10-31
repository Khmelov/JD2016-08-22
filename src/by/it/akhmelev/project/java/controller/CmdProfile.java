package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

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
