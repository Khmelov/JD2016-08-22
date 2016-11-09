package by.it.zaharova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdLogOut extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Actions.SIGNUP.action;
        }

        return null;
    }
}
